# Modul: Auth

## Zweck

Dieses Modul verwaltet die Benutzerauthentifizierung und Session-Verwaltung innerhalb der App.

## Kontext

Die Authentifizierung ist der initiale Einstiegspunkt für den Nutzer, um personalisierte Funktionen wie Check-Ins und Feeds zu nutzen.

## Wichtige Dateien

- `app/src/main/kotlin/de/traewelling/app/viewmodel/AuthViewModel.kt`
- `app/src/main/kotlin/de/traewelling/app/data/repository/AuthRepository.kt`
- `app/src/main/kotlin/de/traewelling/app/data/api/OAuthApiService.kt`
- `app/src/main/kotlin/de/traewelling/app/util/OAuthHelper.kt`

## Verhalten

Das Modul initiiert den OAuth2 Flow, wickelt den Code-Austausch über den `OAuthApiService` ab und speichert die Tokens lokal via `PreferencesManager`. Das `AuthViewModel` propagiert den aktuellen Authentifizierungsstatus (eingeloggt / nicht eingeloggt) an die UI.

## Abhängigkeiten

- **Retrofit**: Für die API-Kommunikation (`OAuthApiService`).
- **DataStore**: Für die lokale Persistenz der Authentifizierungs-Token (`PreferencesManager`).

## Offene Fragen

- Unklar: Wird PKCE (`code_verifier`) bei jedem Login-Typ genutzt oder gibt es Legacy-Routen, die darauf verzichten?

## Verwandte Seiten

- [API Überblick](../api/ueberblick.md)
- [Module Übersicht](./README.md)