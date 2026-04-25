import sys

with open('app/src/main/kotlin/de/traewelling/app/viewmodel/CheckInViewModel.kt', 'r') as f:
    lines = f.readlines()

new_lines = []
for line in lines:
    if "searchResults = stations" in line:
        line = line.replace("searchResults = stations", "searchResults = stations.distinctBy { it.id }")
    new_lines.append(line)

with open('app/src/main/kotlin/de/traewelling/app/viewmodel/CheckInViewModel.kt', 'w') as f:
    f.writelines(new_lines)
