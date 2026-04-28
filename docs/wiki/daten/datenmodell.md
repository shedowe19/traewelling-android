# Daten: Datenmodell

## Zweck

Erklärt, wie Daten im Netzwerk modelliert sind.

## Modelle (Retrofit / Gson)

Definiert in `data/model/Models.kt`. Alle Felder müssen mit `@SerializedName` annotiert sein, um fehlerhaftes Mapping bei ProGuard/R8 oder Refactorings zu verhindern und dem Träwelling JSON-Schema zu entsprechen.

Beispiele:
- `StatusResponse`, `CheckInResponse`, `UserResponse`.

## Besonderheiten
- Manuelle Zeitedits (`manualDeparture`, `manualArrival`) aus Checkin-Objekten müssen berücksichtigt werden.

## Verwandte Seiten

- [[daten/schemas]]
