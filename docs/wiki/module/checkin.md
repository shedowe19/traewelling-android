# Modul: Check-in

## Zweck

Ermöglicht dem Nutzer, Haltestellen zu suchen, Verbindungen abzufragen und letztendlich in einen Zug oder Bus einzuchecken.

## Kontext

Dies ist die Hauptfunktionalität der Träwelling-Plattform, über die Nutzer ihre Reise dokumentieren.

## Wichtige Dateien

- `app/src/main/kotlin/de/traewelling/app/ui/screens/CheckInScreen.kt`
- `app/src/main/kotlin/de/traewelling/app/viewmodel/CheckInViewModel.kt`

## Verhalten

Der Nutzer sucht eine Station. Die Ergebnisse werden von der API geladen und angezeigt. Wichtig ist die Deduplizierung von HAFAS-Ergebnissen im ViewModel, bevor sie an Jetpack Compose weitergegeben werden. Anschließend kann eine Fahrt aus den Abfahrten (`Departures`) ausgewählt und der eigentliche Check-In Request (`CheckInRequest`) abgesetzt werden.

## Abhängigkeiten

- **TraewellingApiService**: Zum Abfragen von Stations, Departures und Trips sowie für den finalen POST-Request für den Check-In.

## Offene Fragen

- TODO: Detailbetrachtung der Deduplizierungslogik bei Haltestellen, da APIs häufig Duplikate liefern.

## Verwandte Seiten

- [[api/ueberblick]]
- [[features/README]]
