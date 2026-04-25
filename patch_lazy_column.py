import re

with open('app/src/main/kotlin/de/traewelling/app/ui/screens/CheckInScreen.kt', 'r') as f:
    content = f.read()

# The crash is an IllegalArgumentException from Jetpack Compose LazyColumn:
# "Key 168901137_Bf. Lüneburg (ZOB) was already used."
# We need to make the key unique, e.g. by using the index or a unique ID.
search_block = """                    items(uiState.searchResults, key = { "${it.id}_${it.name}" }) { station ->"""
replace_block = """                    items(uiState.searchResults.size) { index ->
                        val station = uiState.searchResults[index]"""

if search_block in content:
    with open('app/src/main/kotlin/de/traewelling/app/ui/screens/CheckInScreen.kt', 'w') as f:
        f.write(content.replace(search_block, replace_block))
    print("Patched successfully")
else:
    print("Could not find search block")
