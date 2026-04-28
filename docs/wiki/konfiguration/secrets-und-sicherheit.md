# Konfiguration: Secrets und Sicherheit

## Zweck

Sicherheitsrelevante Vorgaben für die Entwicklung.

## Regeln

- Niemals Test-User-Credentials, JWT Tokens oder Client Secrets in den Code oder das Git-Repository (und schon gar nicht hier ins Wiki!) pushen.
- Lokale `local.properties` verwenden, falls API-Keys für Entwickler-Builds benötigt werden, diese Datei ist standardmäßig in der `.gitignore`.

## Verwandte Seiten

- [Umgebungsvariablen](./umgebungsvariablen.md)