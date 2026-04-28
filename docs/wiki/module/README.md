# Module: Übersicht

## Zweck

Einstiegspunkt für die Beschreibung der Features und Module der App.

## Wichtige Module

- **Auth**: Login via OAuth2, Token Management (`AuthViewModel`, `OAuthHelper`).
- **Feed**: Globale und persönliche Status-Liste (`FeedViewModel`, `FeedScreen`).
- **Check-in**: Suchen von Bahnhöfen, Abfahrten, Trips und durchführen des Check-ins (`CheckInViewModel`, `CheckInScreen`).
- **Profile / Notifications**: Nutzerprofile und Benachrichtigungen verwalten (`ProfileViewModel`, `NotificationViewModel`).
- **Widget / Service**: Background Tasks für die Trip-Verfolgung (`TripWidgetProvider`, `TripTrackingService`).

## Verwandte Seiten

- [[architektur/module]]
