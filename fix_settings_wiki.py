import os

filepath = "docs/wiki/module/settings.md"
with open(filepath, "r") as f:
    content = f.read()

new_content = content + """
## Offene Fragen

* Fehlerbehandlung in PreferencesManager — offen — @dev
* Integration von App-spezifischen Spracheinstellungen — offen — @dev
"""

with open(filepath, "w") as f:
    f.write(new_content)
print(f"Updated {filepath}")
