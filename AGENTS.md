# Projektbeschreibung: Träwelling Android (Optimiert)

Dieses Repository enthält eine erweiterte und optimierte Version der **Träwelling Android App**. Das Ziel dieser Version ist es, die Datenkonsistenz zwischen der Träwelling-Webseite und der mobilen App zu perfektionieren und gleichzeitig das Benutzererlebnis durch eine moderne, intuitive Benutzeroberfläche zu steigern.

## 🎯 Kernziele

1.  **Daten-Integrität:** Sicherstellung, dass alle manuellen Anpassungen (Check-in Zeiten), die auf der Webseite vorgenommen wurden, nahtlos und fehlerfrei in der App reflektiert werden.
2.  **Visuelle Exzellenz:** Einbindung modernster UI-Elemente in Jetpack Compose, um den Fahrplan und die Reise-Details ansprechend und informativ zu gestalten.
3.  **Transparenz bei Störungen:** Klare und unmissverständliche Darstellung von Verspätungen und Haltestellenausfällen.

## 🛠 Technische Details

### Synchronisation & Logik
Die App nutzt ein spezialisiertes ViewModel-System (`StatusDetailViewModel`), das HAFAS-Echtzeitdaten mit den individuellen Träwelling-Statusinformationen verknüpft. Dabei werden manuelle Overrides (`manualDeparture` / `manualArrival`) priorisiert behandelt.

### UI-Komponenten
Die Timeline wurde modular aufgebaut (`StopoverItem`), um verschiedene Zustände flexibel abzubilden:
-   **Berechnete Progress-Lines:** Die Fortschrittslinie zwischen den Haltestellen wird dynamisch basierend auf der aktuellen Zeit und dem Fahrplan berechnet.
-   **Zustandsbasierte Badges:** Automatische Generierung von Hinweisen wie "STARTHALTESTELLE", "ENDSTATION" oder persönliche Markierungen wie "DEIN EINSTIEG".

## 🚀 Vision
Träwelling Android soll die erste Wahl für alle Reisenden sein, die Wert auf Präzision und Ästhetik legen. Diese optimierte Version ist ein großer Schritt in Richtung eines nahtlosen Cross-Platform-Erlebnisses.

---
*Viel Spaß beim Reisen mit Träwelling!*
