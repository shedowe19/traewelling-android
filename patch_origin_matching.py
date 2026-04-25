import re

with open('app/src/main/kotlin/de/traewelling/app/service/TripTrackingService.kt', 'r') as f:
    content = f.read()

search_block = """        val originIndex = stopovers.indexOfFirst { it.id == origin?.id }
        val destIndex = stopovers.indexOfFirst { it.id == destination?.id }"""

replace_block = """        val originIndex = stopovers.indexOfFirst {
            it.id == origin?.id ||
            (it.name == origin?.name && it.name != null) ||
            (it.evaIdentifier == origin?.evaIdentifier && it.evaIdentifier != null)
        }
        val destIndex = stopovers.indexOfFirst {
            it.id == destination?.id ||
            (it.name == destination?.name && it.name != null) ||
            (it.evaIdentifier == destination?.evaIdentifier && it.evaIdentifier != null)
        }"""

if search_block in content:
    with open('app/src/main/kotlin/de/traewelling/app/service/TripTrackingService.kt', 'w') as f:
        f.write(content.replace(search_block, replace_block))
    print("Patched successfully")
else:
    print("Could not find search block")
