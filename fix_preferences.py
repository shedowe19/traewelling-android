import os

filepath = "app/src/main/kotlin/de/traewelling/app/util/PreferencesManager.kt"
with open(filepath, "r") as f:
    content = f.read()

old_setAppTheme = """    suspend fun setAppTheme(theme: String) {
        context.dataStore.edit { prefs ->
            prefs[KEY_APP_THEME] = theme
        }
    }"""

new_setAppTheme = """    suspend fun setAppTheme(theme: String) {
        val validThemes = listOf("LIGHT", "DARK", "AMOLED")
        val safeTheme = if (theme in validThemes) theme else "LIGHT"
        context.dataStore.edit { prefs ->
            prefs[KEY_APP_THEME] = safeTheme
        }
    }"""

content = content.replace(old_setAppTheme, new_setAppTheme)

with open(filepath, "w") as f:
    f.write(content)
print(f"Updated {filepath}")
