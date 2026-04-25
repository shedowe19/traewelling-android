import sys

with open('app/src/main/kotlin/de/traewelling/app/service/TripTrackingService.kt', 'r') as f:
    lines = f.readlines()

new_lines = []
for line in lines:
    if "val originStop = checkin.trainStation" in line:
        line = "                            val originStop = checkin.origin\n"
    new_lines.append(line)

with open('app/src/main/kotlin/de/traewelling/app/service/TripTrackingService.kt', 'w') as f:
    f.writelines(new_lines)
