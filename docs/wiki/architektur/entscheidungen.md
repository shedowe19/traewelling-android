# Architektur: Entscheidungen

## Zweck

Kurze Zusammenfassung technischer Entscheidungen, für die es eventuell keine eigene ADR gibt.

## Entscheidungen

- **Jetpack Compose als UI Framework**: Gewählt für moderne, deklarative UI-Entwicklung.
- **Coroutines & StateFlow**: Gewählt für asynchrone Aufgaben und reaktives State Management (statt RxJava oder LiveData).
- **Retrofit & Gson**: Gewählt für die Anbindung an die Träwelling JSON-REST-API, wobei auf `@SerializedName` zur strikten Mappung geachtet wird.
- **Room Database**: Gewählt für lokales Caching und Offline-Fähigkeit (`StatusDao`).
- **Globaler NavHost**: Core Tabs (Feed, Check-in, Meldungen, Profil) sind innerhalb eines `HorizontalPager` verpackt für seitliches Swipen, während tiefere Navigation als unabhängige Routen konzipiert ist.

## Verwandte Seiten

- [Entscheidungen](../entscheidungen/README.md)