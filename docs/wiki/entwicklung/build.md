# Entwicklung: Build

## Zweck

Dokumentiert den Build-Prozess.

## Gradle Tasks

- `./gradlew assembleDebug` - Debug-Build erstellen
- `./gradlew assembleRelease` - Release-Build erstellen
- `./gradlew compileDebugKotlin` - Kotlin-Code kompilieren ohne vollen Build
- `./gradlew build` - Vollständiger Build

## Build-Konfiguration

- **compileSdk**: 34
- **minSdk**: 26
- **targetSdk**: 34
- **Java/Kotlin**: JDK 17, JVM Target 17

## Verwandte Seiten

- [Setup](./setup.md)
- [Config-Dateien](../konfiguration/config-dateien.md)