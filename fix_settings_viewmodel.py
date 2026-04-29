import os

filepath = "app/src/main/kotlin/de/traewelling/app/viewmodel/SettingsViewModel.kt"
with open(filepath, "r") as f:
    content = f.read()

# Fix initTts
old_initTts = """    private fun initTts(engine: String? = null) {
        val currentEngine = engine ?: _uiState.value.selectedTtsEngine
        tts?.shutdown()
        tts = if (currentEngine != null) {
            TextToSpeech(getApplication(), this, currentEngine)
        } else {
            TextToSpeech(getApplication(), this)
        }
    }"""

new_initTts = """    private fun initTts(engine: String? = null) {
        val normalizedEngine = if (engine.isNullOrEmpty()) null else engine
        val normalizedSelectedEngine = if (_uiState.value.selectedTtsEngine.isNullOrEmpty()) null else _uiState.value.selectedTtsEngine
        val currentEngine = normalizedEngine ?: normalizedSelectedEngine
        tts?.shutdown()
        tts = if (currentEngine != null) {
            TextToSpeech(getApplication(), this, currentEngine)
        } else {
            TextToSpeech(getApplication(), this)
        }
    }"""
content = content.replace(old_initTts, new_initTts)

# Fix exceptions swallowing
import re
content = re.sub(r'\} catch \(e: Exception\) \{ false \}', '} catch (e: Exception) { android.util.Log.w("SettingsViewModel", "isLanguageAvailable check failed", e); false }', content)
content = re.sub(r'\} catch \(e: Exception\) \{ emptyList\(\) \}', '} catch (e: Exception) { android.util.Log.w("SettingsViewModel", "Failed to fetch voices", e); emptyList() }', content)
content = re.sub(r'\} catch \(e: Exception\) \{\}', '} catch (e: Exception) { android.util.Log.w("SettingsViewModel", "Failed to set voice", e) }', content)

# Fix selectTtsEngine empty string handling
old_selectTtsEngine = """    fun selectTtsEngine(engine: String) {
        viewModelScope.launch {
            prefs.saveTtsSettings(engine, _uiState.value.selectedTtsLanguage, _uiState.value.selectedTtsVoice)
            initTts(engine) // Re-init with new engine to load its voices/langs
        }
    }"""

new_selectTtsEngine = """    fun selectTtsEngine(engine: String) {
        val normalizedEngine = if (engine.isEmpty()) null else engine
        viewModelScope.launch {
            prefs.saveTtsSettings(normalizedEngine, _uiState.value.selectedTtsLanguage, _uiState.value.selectedTtsVoice)
            initTts(normalizedEngine) // Re-init with new engine to load its voices/langs
        }
    }"""

content = content.replace(old_selectTtsEngine, new_selectTtsEngine)

with open(filepath, "w") as f:
    f.write(content)
print(f"Updated {filepath}")
