package de.traewelling.app.viewmodel

import android.app.Application
import android.speech.tts.TextToSpeech
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import de.traewelling.app.util.PreferencesManager
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.Locale

data class SettingsUiState(
    val isTtsEnabled: Boolean = false,
    val selectedTtsEngine: String? = null,
    val selectedTtsLanguage: String? = null,
    val selectedTtsVoice: String? = null,
    val availableTtsEngines: List<TextToSpeech.EngineInfo> = emptyList(),
    val availableLanguages: List<Locale> = emptyList(),
    val availableVoices: List<android.speech.tts.Voice> = emptyList(),
    val appTheme: String = "LIGHT"
)

class SettingsViewModel(application: Application) : AndroidViewModel(application), TextToSpeech.OnInitListener {

    private val prefs = PreferencesManager(application)

    private val _uiState = MutableStateFlow(SettingsUiState())
    val uiState: StateFlow<SettingsUiState> = _uiState.asStateFlow()

    private var tts: TextToSpeech? = null

    init {
        viewModelScope.launch {
            launch {
                prefs.isTtsEnabled.collect { enabled ->
                    _uiState.update { it.copy(isTtsEnabled = enabled) }
                    if (enabled && tts == null) {
                        initTts()
                    } else if (!enabled && tts != null) {
                        tts?.shutdown()
                        tts = null
                    }
                }
            }
            launch {
                prefs.ttsEngine.collect { eng -> _uiState.update { it.copy(selectedTtsEngine = eng) } }
            }
            launch {
                prefs.ttsLanguage.collect { lang -> _uiState.update { it.copy(selectedTtsLanguage = lang) } }
            }
            launch {
                prefs.ttsVoice.collect { voice -> _uiState.update { it.copy(selectedTtsVoice = voice) } }
            }
            launch {
                prefs.appTheme.collect { theme -> _uiState.update { it.copy(appTheme = theme) } }
            }
        }
    }

    private fun initTts(engine: String? = null) {
        val currentEngine = engine ?: _uiState.value.selectedTtsEngine
        tts?.shutdown()
        tts = if (currentEngine != null) {
            TextToSpeech(getApplication(), this, currentEngine)
        } else {
            TextToSpeech(getApplication(), this)
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts?.let { ttsInstance ->
                val engines = ttsInstance.engines
                val languages = Locale.getAvailableLocales().filter {
                    try {
                        ttsInstance.isLanguageAvailable(it) >= TextToSpeech.LANG_AVAILABLE
                    } catch (e: Exception) { false }
                }.sortedBy { it.displayName }

                val voices = try {
                    ttsInstance.voices?.toList() ?: emptyList()
                } catch (e: Exception) { emptyList() }

                _uiState.update { state ->
                    val filteredVoices = if (!state.selectedTtsLanguage.isNullOrEmpty()) {
                        voices.filter { it.locale.toLanguageTag() == state.selectedTtsLanguage }
                    } else {
                        voices
                    }
                    state.copy(
                        availableTtsEngines = engines,
                        availableLanguages = languages,
                        availableVoices = filteredVoices
                    )
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        tts?.shutdown()
    }

    fun toggleTts(enabled: Boolean) {
        viewModelScope.launch {
            prefs.setTtsEnabled(enabled)
        }
    }

    fun selectTtsEngine(engine: String) {
        viewModelScope.launch {
            prefs.saveTtsSettings(engine, _uiState.value.selectedTtsLanguage, _uiState.value.selectedTtsVoice)
            initTts(engine) // Re-init with new engine to load its voices/langs
        }
    }

    fun selectTtsLanguage(language: String) {
        viewModelScope.launch {
            prefs.saveTtsSettings(_uiState.value.selectedTtsEngine, language, "")
            _uiState.update { state ->
                state.copy(selectedTtsLanguage = language, selectedTtsVoice = "")
            }
            // Update voices based on the new language
            tts?.let { ttsInstance ->
                val voices = try {
                    ttsInstance.voices?.toList() ?: emptyList()
                } catch (e: Exception) { emptyList() }

                _uiState.update { state ->
                    val filteredVoices = if (language.isNotEmpty()) {
                        voices.filter { it.locale.toLanguageTag() == language }
                    } else {
                        voices
                    }
                    state.copy(availableVoices = filteredVoices)
                }
            }
        }
    }

    fun testTts() {
        if (_uiState.value.isTtsEnabled && tts != null) {
            val language = _uiState.value.selectedTtsLanguage
            val locale = if (!language.isNullOrEmpty()) Locale.forLanguageTag(language) else Locale.GERMAN
            val result = tts?.setLanguage(locale)

            if (result != TextToSpeech.LANG_MISSING_DATA && result != TextToSpeech.LANG_NOT_SUPPORTED) {
                val voiceName = _uiState.value.selectedTtsVoice
                if (!voiceName.isNullOrEmpty()) {
                    try {
                        val availableVoices = tts?.voices
                        val selectedVoice = availableVoices?.find { it.name == voiceName }
                        if (selectedVoice != null) {
                            tts?.voice = selectedVoice
                        }
                    } catch (e: Exception) {}
                }
                tts?.speak("Dies ist ein Test der Sprachausgabe.", TextToSpeech.QUEUE_FLUSH, null, "TTS_TEST")
            }
        }
    }

    fun selectTtsVoice(voiceName: String) {
        viewModelScope.launch {
            prefs.saveTtsSettings(_uiState.value.selectedTtsEngine, _uiState.value.selectedTtsLanguage, voiceName)
        }
    }

    fun setAppTheme(theme: String) {
        viewModelScope.launch {
            prefs.setAppTheme(theme)
        }
    }
}
