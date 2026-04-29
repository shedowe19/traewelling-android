import os

filepath = "app/src/main/kotlin/de/traewelling/app/ui/navigation/AppNavigation.kt"
with open(filepath, "r") as f:
    content = f.read()

# Add Settings to Screen sealed class
old_screen_def = """    object Notifications : Screen("notifications", "Meldungen",         Icons.Default.Notifications)
    object Profile       : Screen("profile",       "Profil",            Icons.Default.Person)
}"""

new_screen_def = """    object Notifications : Screen("notifications", "Meldungen",         Icons.Default.Notifications)
    object Profile       : Screen("profile",       "Profil",            Icons.Default.Person)
    object Settings      : Screen("settings",      "Einstellungen",     Icons.Default.Settings)
}"""

content = content.replace(old_screen_def, new_screen_def)

# Fix literal 'settings' string
content = content.replace('onSettingsClick = { navController.navigate("settings") }', 'onSettingsClick = { navController.navigate(Screen.Settings.route) }')
content = content.replace('composable("settings") {', 'composable(Screen.Settings.route) {')

with open(filepath, "w") as f:
    f.write(content)
print(f"Updated {filepath}")
