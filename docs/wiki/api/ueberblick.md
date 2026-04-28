# API: Überblick

## Zweck

Übersicht über die Netzwerkschnittstellen.

## TraewellingApiService

Zentrale Schnittstelle, definiert in `TraewellingApiService.kt`. Die App kommuniziert mit den Träwelling RESTful APIs.

### Endpunkt-Gruppen:
- **Auth**: `/api/v1/auth/user`, `/api/v1/auth/logout`.
- **Feed**: `/api/v1/dashboard`, `/api/v1/statuses`.
- **Station Search**: `/api/v1/trains/station/autocomplete`, `/api/v1/trains/station/nearby`, `/api/v1/stations`.
- **Departures/Trips**: `/api/v1/station/{id}/departures`, `/api/v1/trains/trip`.
- **Check-In**: `/api/v1/trains/checkin`.
- **Profile/Follow**: `/api/v1/user/...`.
- **Notifications**: `/api/v1/notifications/...`.

## OAuth
Token Exchange und Refreshing laufen über den `OAuthApiService` (`/oauth/token`).

## Verwandte Seiten

- [[api/interne-schnittstellen]]
- [[api/externe-schnittstellen]]
