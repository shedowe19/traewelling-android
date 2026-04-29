# Points-System und 0-Punkte Anzeige

## Zweck

Dieses Dokument beschreibt das Verhalten des Punkte-Systems in Träwelling, insbesondere wenn Nutzer das Punkte-System deaktiviert haben (`pointsEnabled = false`), sowie den Umgang mit Fahrten, die 0 Punkte einbringen.

## Kontext

Die App zeigt Punkte für Fahrten und Benutzerprofile an. Einige Nutzer haben das Sammeln von Punkten in den Einstellungen deaktiviert.

## Verhalten

- Wenn ein Benutzer `pointsEnabled = false` gesetzt hat, sollen in seinem Profil keine Punkte angezeigt werden.
- Wenn eine spezifische Fahrt 0 Punkte ergibt (oft als Nebeneffekt von deaktivierten Punkten oder bestimmten Fahrttypen), wird das "Punkte"-Badge im Feed, in der Detailansicht und im Check-in Screen ausgeblendet, anstatt "0 Pkt" anzuzeigen.

## Verwandte Seiten

- [Datenmodell](../daten/datenmodell.md)
