package de.traewelling.app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import de.traewelling.app.data.model.User
import de.traewelling.app.data.repository.TraewellingRepository
import de.traewelling.app.util.PreferencesManager
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class UserSearchUiState(
    val isLoading: Boolean = false,
    val query: String = "",
    val searchResults: List<User> = emptyList(),
    val error: String? = null
)

class UserSearchViewModel(application: Application) : AndroidViewModel(application) {
    private val prefs = PreferencesManager(application)
    private val repo = TraewellingRepository(application, prefs)

    private val _uiState = MutableStateFlow(UserSearchUiState())
    val uiState: StateFlow<UserSearchUiState> = _uiState.asStateFlow()

    private var searchJob: Job? = null

    fun updateQuery(query: String) {
        _uiState.update { it.copy(query = query, error = null) }

        if (query.isBlank()) {
            _uiState.update { it.copy(searchResults = emptyList(), isLoading = false) }
            searchJob?.cancel()
            return
        }

        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(350) // Debounce typing
            _uiState.update { it.copy(isLoading = true) }
            repo.searchUsers(query)
                .onSuccess { users ->
                    _uiState.update { it.copy(isLoading = false, searchResults = users) }
                }
                .onFailure { e ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = "Suche fehlgeschlagen: ${e.message}"
                        )
                    }
                }
        }
    }

    fun clearError() = _uiState.update { it.copy(error = null) }
}
