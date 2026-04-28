# Entwicklung: Lokale Entwicklung

## Zweck

Hinweise für den Entwicklungsalltag.

## Richtlinien

- Keine sensiblen Daten (Test-User, JWT Tokens, API Keys) in den Code committen.
- Compose Guidelines beachten (kein komplexes Re-Composing, `remember` nutzen).
- API-Daten immer validieren/deduplizieren, bevor sie in Compose-Listen (`LazyColumn`) mit `key` gerendert werden.

## Verwandte Seiten

- [[entwicklung/setup]]
