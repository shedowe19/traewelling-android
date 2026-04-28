# UI: Theme

## Zweck

Dokumentation des Farbschemas und der Typografie.

## Markenfarben

| Name | Hex | Verwendung |
|------|-----|------------|
| TraewellingRed | #C72730 | Logo, primäre Akzente |
| TraewellingRedDark | #A51F27 | Dunklere Variante |

## Erweiterte Palette

### Primär (Deep Indigo)
- DeepIndigo: #1A237E (TopAppBar, aktive Akzente)
- IndigoLight: #534BAE (Primary Container)

### Sekundär (Teal)
- TealAccent: #00897B (Fortschritt, Start/End-Badges)
- TealLight: #B2DFDB (Container)
- TealDark: #00695C (auf Container)

### Tertiär (Amber)
- AmberAccent: #FF8F00 (persönliche Marker)
- AmberLight: #FFF8E1 (Container)
- AmberDark: #E65100 (auf Container)

### Semantische Farben
- SuccessGreen: #2E7D32 (pünktlich/früh)
- WarningOrange: #E65100 (Verspätung)
- ErrorRed: #C62828 (Ausfall/Fehler)

## Material3 ColorScheme

```kotlin
private val LightColorScheme = lightColorScheme(
    primary = DeepIndigo,
    secondary = TealAccent,
    tertiary = AmberAccent,
    error = ErrorRed,
    background = SurfaceBlue (#FAFBFF),
    surface = SurfaceCard (#FFFFFF)
)
```

## Typografie

Standard Material3 Typography (Roboto).

## TransportColors

Farben für Verkehrsmittel-Kategorien (siehe [Komponenten](./komponenten.md)).

## Verwandte Seiten

- [Komponenten](./komponenten.md)