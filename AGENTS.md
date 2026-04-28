Du bist ein erfahrener Coding Agent und sollst in diesem bestehenden Projekt ein internes LLM-Wiki einrichten und dauerhaft pflegen.

Ziel:
Erstelle und pflege eine dauerhafte, gut strukturierte Markdown-Wissensbasis für dieses Projekt. Das Wiki soll es später einem LLM, Entwickler oder neuen Teammitglied ermöglichen, das Projekt schnell zu verstehen, wichtige Entscheidungen nachzuvollziehen und wiederkehrende Informationen leicht zu finden.

Wichtig:
- Arbeite im bestehenden Projekt.
- Verändere keinen produktiven Code, außer es ist ausdrücklich notwendig.
- Überschreibe keine bestehenden Dokumente ohne vorher eine Sicherung oder klare Begründung.
- Wenn bereits ein Wiki, ein `docs`-Ordner oder Projekt-Dokumentation existiert, integriere dich dort sinnvoll.
- Falls keine Struktur vorhanden ist, erstelle eine neue unter `docs/wiki/`.
- Schreibe alle Wiki-Inhalte auf Deutsch.
- Nutze Markdown.
- Verwende für alle internen Links relative Markdown-Links im Format `[Text](./pfad/datei.md)`. KEINE `[[Wiki-Syntax]]` verwenden, da GitHub diese nicht interpretiert.
- Halte die Inhalte sachlich, präzise und wartbar.
- Markiere Unsicherheiten klar mit `TODO:`, `Unklar:` oder `Annahme:`.
- Dokumentiere keine erfundenen Details.
- Kopiere niemals echte Secrets, Tokens, Passwörter oder private Schlüssel ins Wiki.

---

# Automatische Wiki-Pflege bei jeder Agent-Ausführung

Dieses Projekt enthält ein internes LLM-Wiki. Der Agent ist verpflichtet, das Wiki bei jeder neuen Arbeitssitzung aktiv mitzupflegen.

## Grundregel

Jedes Mal, wenn diese `AGENTS.md` / `agent.md` geladen wird, muss der Agent prüfen:

1. Welche Aufgabe wird gerade bearbeitet?
2. Welche Dateien, Module, Features oder Entscheidungen sind davon betroffen?
3. Ist dieses Wissen bereits im Wiki dokumentiert?
4. Ist die bestehende Wiki-Dokumentation noch korrekt?
5. Muss eine bestehende Seite aktualisiert oder eine neue Unterseite angelegt werden?

Das Wiki ist kein einmaliges Dokumentationspaket, sondern eine dauerhaft gepflegte Wissensbasis.

---

# Wiki-Pflichtprüfung vor jeder Arbeit

Bevor produktiver Code geändert wird, muss der Agent prüfen, ob die aktuelle Aufgabe Wiki-relevant ist.

Wiki-relevant ist eine Aufgabe, wenn sie mindestens eines betrifft:

- neue Features
- Architekturänderungen
- neue Module oder Services
- Änderungen an bestehenden Modulen
- neue APIs, Endpunkte, Events oder Schnittstellen
- neue Datenmodelle, Tabellen, Schemas oder Migrationen
- neue Konfigurationen oder Umgebungsvariablen
- Build-, Setup-, Test- oder Deployment-Änderungen
- wichtige technische Entscheidungen
- neue Abhängigkeiten
- entfernte oder ersetzte Funktionen
- bekannte Einschränkungen, Risiken oder offene Fragen

Wenn die Aufgabe Wiki-relevant ist, muss das Wiki aktualisiert werden.

---

# Wiki-Pflichtprüfung nach jeder Arbeit

Nach Abschluss einer Änderung muss der Agent erneut prüfen:

- Wurde durch die Arbeit neues Wissen erzeugt?
- Ist eine bestehende Wiki-Seite veraltet?
- Gibt es neue Zusammenhänge zwischen Modulen?
- Müssen neue Seiten oder Unterseiten erstellt werden?
- Müssen Links ergänzt werden?
- Müssen offene Fragen dokumentiert werden?

Wenn ja, aktualisiere das Wiki im selben Arbeitsdurchlauf.

---

# Projekt analysieren

Untersuche die vorhandene Projektstruktur.

Lies wichtige Dateien wie:

- `README.md`
- `build.gradle.kts` / `settings.gradle.kts`
- `app/build.gradle.kts`
- Konfigurationsdateien
- vorhandene Dokumentation
- zentrale Quellcode-Ordner

Erkenne:

- Frameworks
- Programmiersprachen
- Architektur
- wichtige Module
- externe Abhängigkeiten
- Build-, Test- und Deployment-Prozesse

---

# Wiki-Struktur

Das Wiki soll nicht nur aus flachen Einzelseiten bestehen. Es muss sinnvoll in Unterordner und Unterseiten gegliedert werden.

Die Struktur für dieses Android/Kotlin-Projekt:

```text
docs/wiki/
├── index.md
├── projekt/
│   ├── ueberblick.md
│   ├── ziele.md
│   └── begriffe.md
├── architektur/
│   ├── ueberblick.md
│   ├── datenfluss.md
│   ├── module.md
│   ├── entscheidungen.md
│   └── externe-abhaengigkeiten.md
├── entwicklung/
│   ├── setup.md
│   ├── lokale-entwicklung.md
│   ├── tests.md
│   ├── build.md
│   └── deployment.md
├── module/
│   ├── README.md
│   ├── auth.md
│   ├── auth-pkce.md
│   ├── checkin.md
│   ├── feed.md
│   ├── notifications.md
│   ├── profile.md
│   ├── status-detail.md
│   ├── trip-tracking.md
│   ├── user-profile.md
│   ├── user-search.md
│   └── widget.md
├── ui/
│   ├── screens.md
│   ├── komponenten.md
│   └── theme.md
├── api/
│   ├── ueberblick.md
│   ├── interne-schnittstellen.md
│   └── externe-schnittstellen.md
├── daten/
│   ├── datenmodell.md
│   ├── datenbank.md
│   ├── schemas.md
│   └── migrationen.md
├── konfiguration/
│   ├── umgebungsvariablen.md
│   ├── config-dateien.md
│   ├── secrets-und-sicherheit.md
│   └── preferences-manager.md
├── entscheidungen/
│   ├── README.md
│   └── adr-template.md
├── features/
│   └── README.md
├── offene-fragen.md
├── glossar.md
└── wiki-pflege.md
```

Der Agent darf zusätzliche Unterordner anlegen, wenn das Projekt dadurch besser dokumentiert wird.

---

# Verlinkungsregeln

**Wichtig:** Verwende ausschließlich relative Markdown-Links. GitHub unterstützt keine `[[Wiki-Syntax]]`.

```markdown
# Korrekt:
- [Architektur Überblick](./architektur/ueberblick.md)
- [API Overview](./api/ueberblick.md)

# Falsch:
- [[architektur/ueberblick]]
- [[api/ueberblick]]
```

Jede Wiki-Seite soll am Ende einen Abschnitt "Verwandte Seiten" enthalten:

```markdown
## Verwandte Seiten

- [Architektur Überblick](./architektur/ueberblick.md)
- [API Überblick](./api/ueberblick.md)
```

---

# Vorlage für neue Seiten

Jede neue Seite soll mindestens enthalten:

```markdown
# Seitentitel

## Zweck

Kurze Erklärung, wofür dieses Modul, Feature oder Konzept da ist.

## Kontext

Wo wird es im Projekt verwendet?

## Wichtige Dateien

- `app/src/main/kotlin/de/traewelling/app/module/File.kt`

## Verhalten

Was macht dieser Teil des Systems?

## Abhängigkeiten

Welche anderen Module, Services oder APIs werden verwendet?

## Offene Fragen

- TODO: ...

## Verwandte Seiten

- [Architektur Überblick](./architektur/ueberblick.md)
- [API Überblick](./api/ueberblick.md)
```

---

# Automatische Aktualisierung bestehender Seiten

Wenn eine passende Wiki-Seite bereits existiert, soll der Agent sie aktualisieren statt eine doppelte Seite zu erstellen.

Vor dem Erstellen einer neuen Seite immer prüfen:

- Gibt es bereits eine Seite zum selben Modul?
- Gibt es eine übergeordnete Seite, die erweitert werden sollte?
- Ist eine Unterseite sinnvoller als ein neuer Hauptartikel?
- Müssen Links im `index.md` ergänzt werden?
- Müssen bestehende verwandte Seiten ergänzt werden?

Doppelte Dokumentation vermeiden.

---

# Index-Pflege

Der Agent muss `docs/wiki/index.md` aktuell halten.

Wenn neue wichtige Seiten oder Unterordner entstehen, müssen sie im Index verlinkt werden.

Der Index soll als Einstiegspunkt dienen und die Wiki-Struktur erklären.

---

# Entscheidungsdokumentation

Wenn während der Arbeit eine technische Entscheidung getroffen oder sichtbar wird, muss sie dokumentiert werden.

Für größere Entscheidungen eine eigene ADR-Datei anlegen:

```text
docs/wiki/entscheidungen/YYYY-MM-DD-kurzer-titel.md
```

Kleinere Entscheidungen können in `docs/wiki/architektur/entscheidungen.md` zusammengefasst werden.

---

# Offene Fragen und Unsicherheiten

Wenn der Agent etwas nicht sicher aus dem Code ableiten kann, darf er es nicht erfinden.

Stattdessen muss er es dokumentieren:

```markdown
Unklar: ...
TODO: ...
Annahme: ...
```

Offene Punkte zusätzlich in `docs/wiki/offene-fragen.md` sammeln.

---

# Keine Secrets dokumentieren

Der Agent darf niemals echte geheime Werte ins Wiki schreiben.

Nicht dokumentieren:

- API Keys
- Tokens
- Passwörter
- Private Keys
- echte Zugangsdaten
- geheime URLs, sofern sicherheitskritisch

Erlaubt ist nur die Beschreibung der benötigten Variable:

```markdown
- `DATABASE_URL`: Verbindungsstring zur Datenbank. Wert nicht dokumentieren.
- `API_KEY`: Secret für externen Dienst. Wert nicht dokumentieren.
```

---

# Verhalten bei kleinen Änderungen

Nicht jede kleine Änderung braucht eine neue Wiki-Seite.

Aber der Agent soll prüfen, ob eine bestehende Seite angepasst werden muss.

Beispiele:

- Kleine Bugfixes ohne Architekturänderung: meistens keine Wiki-Änderung nötig.
- Neuer API-Endpunkt: Wiki aktualisieren.
- Neue Config-Variable: Wiki aktualisieren.
- Neues Modul: Wiki aktualisieren.
- Änderung am Setup: Wiki aktualisieren.
- Neuer Testbefehl: Wiki aktualisieren.
- Neue Abhängigkeit: Wiki aktualisieren.
- Entferntes Feature: Wiki aktualisieren.

---

# README ergänzen

Falls passend, ergänze im Haupt-`README.md` einen kurzen Abschnitt:

```markdown
## Projekt-Wiki

Die interne Projektdokumentation befindet sich unter:

- [Projekt-Wiki](docs/wiki/index.md)
```

---

# Wiki-Pflege-Seite

Die Datei `docs/wiki/wiki-pflege.md` enthält:

- Wie neue Informationen ergänzt werden
- Wann bestehende Seiten aktualisiert werden sollen
- Wie Unsicherheiten markiert werden
- Wie neue Seiten benannt werden
- Wie Unterordner genutzt werden
- Dass produktiver Code nicht automatisch aus Wiki-Inhalten verändert werden darf
- Dass Code die Quelle der Wahrheit ist
- Dass das Wiki bei jeder Agent-Ausführung geprüft werden muss
- Dass relative Markdown-Links verwendet werden (KEINE `[[Wiki-Syntax]]`)

---

# Abschluss jeder Aufgabe

Am Ende jeder Aufgabe muss der Agent im Abschlussbericht angeben:

```text
Wiki-Prüfung:
- Geprüfte Wiki-Seiten:
- Aktualisierte Wiki-Seiten:
- Neu erstellte Wiki-Seiten:
- Keine Wiki-Änderung nötig, weil:
- Offene Wiki-TODOs:
```

Wenn keine Wiki-Änderung nötig war, muss der Grund genannt werden.

---

# Qualität

- Schreibe keine erfundenen Details.
- Wenn etwas nicht eindeutig aus dem Projekt ableitbar ist, schreibe `Unklar: ...`.
- Keine geheimen Werte, Tokens, Passwörter oder privaten Schlüssel dokumentieren.
- Dokumentiere nur Struktur, Zweck und erkennbare Zusammenhänge.
- Halte jede Seite lesbar und nicht unnötig lang.
- Nutze Tabellen nur, wenn sie wirklich helfen.
- Vermeide doppelte Dokumentation.
- Halte Links aktuell.
- Nutze klare deutsche Sprache.
- Verwende relative Markdown-Links (`[Text](./pfad/datei.md)`), keine `[[Wiki-Syntax]]`.

---

# Arbeitsprinzip

Der Agent soll das Wiki so behandeln, als wäre es das Langzeitgedächtnis des Projekts.

Code ist die Quelle der Wahrheit.
Das Wiki erklärt die Quelle der Wahrheit.

Bei jeder relevanten Änderung müssen Code und Wiki gemeinsam aktuell gehalten werden.