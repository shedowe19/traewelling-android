# API: Externe Schnittstellen

## Zweck

Kommunikation mit externen Services abseits der Haupt-API.

## HAFAS und externe Provider
Die App konsumiert Träwelling APIs, welche im Hintergrund oft auf Transit-Provider (wie HAFAS) zugreifen. Besonderheiten:
- HafasTripId wird für `getTrip` benötigt.
- Es gibt plattformspezifische Eigenheiten (z.B. Bahn-Steige mit Präfix `9`, die entfernt werden müssen).

## Verwandte Seiten

- [[api/ueberblick]]
