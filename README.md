# Aktienanzeiger

## Einführung und Ziele

Der Zweck der Aktienanzeiger-Webanwendung ist es, Benutzern täglich aktuelle Aktienkurse und umfassende Unternehmensinformationen wie den Marktwert bereitzustellen. Über eine benutzerfreundliche Weboberfläche können die Benutzer gezielt verschiedene Aktien auswählen und die relevanten Daten in einer übersichtlichen Tabelle anzeigen lassen. Zur Steigerung der Effizienz und Reduzierung der Antwortzeiten nutzt die Anwendung eine intelligente Caching-Strategie. Das Backend der Anwendung ist in Java unter Verwendung des Spring Boot Frameworks entwickelt, was eine robuste und skalierbare Backend-Architektur ermöglicht. Das Frontend basiert auf React, einer modernen JavaScript-Bibliothek, die für eine dynamische und interaktive Benutzererfahrung sorgt. Als Datenbank wird Redis verwendet, bekannt für seine hohe Leistung und Fähigkeit, häufig abgefragte Daten zu cachen. Die benötigten Aktieninformationen und Marktdaten werden von der Polygon.io API (https://polygon.io) abgerufen und in der Redis-Datenbank zwischengespeichert, um wiederholte Anfragen effizient zu bearbeiten.

### Aufgabenstellung

Ziel dieser Aufgabe ist es, ein detailliertes und umfassendes Testkonzept für eine Softwareanwendung zu entwickeln und erfolgreich umzusetzen. Diese Softwareanwendung besteht aus mehreren Schichten und Komponenten, darunter ein benutzerfreundliches UI-Frontend, das eine intuitive und reaktionsschnelle Benutzeroberfläche bietet, sowie eine komplexe Business-Logik-Schicht, die die Kernlogik und Geschäftsprozesse der Anwendung verwaltet. Des Weiteren umfasst die Anwendung eine leistungsfähige Datenbank, die für die Speicherung und effiziente Abfrage großer Datenmengen verantwortlich ist, und die Integration mit verschiedenen Drittanbieter-Backends, die zusätzliche Funktionalitäten und Datenquellen bereitstellen. Jede dieser Komponenten muss gründlich getestet werden, um sicherzustellen, dass die gesamte Anwendung nahtlos und zuverlässig funktioniert.

![Assignment Details](https://github.com/serap4/sqs-projekt-aktienanzeiger/blob/master/Bilder/Assignment%20Details%20SQS2024.png)

### Qualitätsziele
 
| Qualitätskriterium | Beschreibung      | Ziele      | Maßnahmen       |
| -------------- | -------------- | -------------- | -------------- |
| Portability - Übertragbarkeit | Die Fähigkeit des Systems, in verschiedenen Umgebungen oder Plattformen betrieben zu werden.| - Effiziente Ressourcennutzung <br>- Plattformunabhängige Nutzbarkeit <br> Reduzierung externer Abhängigkeiten | - End-to-End-Tests mit Playwright <br>- Nutzung von Docker zur Containerisierung, um Laufzeitumgebungen zu isolieren und Plattformunabhängigkeit zu gewährleisten <br>- Docker-Compose-Datei zum Starten der Services |
| Usability - Benutzerfreundlichkeit | Die Einfachheit und Effizienz, mit der Benutzer das System verwenden und ihre Aufgaben erledigen können. |- Klar strukturierte Benutzeroberfläche <br>- Einfache Bedienbarkeit| - UI-Tests <br>- End-to-End-Tests mit Playwright|
| Reliability - Zuverlässigkeit | Die Fähigkeit des Systems, unter festgelegten Bedingungen korrekt zu funktionieren. | - Hohe Stabilität unter hoher Last <br>- Robuste Verarbeitung von Benutzereingaben|- Integrationstests <br>- Umfassende Abdeckung durch Unit-Tests <br>- Lasttests mit Artillery|

  
### Stakeholder

| Rolle                    | Kontakt                                | Erwartungshaltung                                   |
| ------------------------ | ---------------------------------------| --------------------------------------------------- |
| Prüfer                   | Mario-Leander Reimer (mario-leander.reimer@th-rosenheim.de)  | Es wird erwartet, dass das Softwareprogramm und dessen Qualität überzeugend sind, um eine gute Note zu vergeben.|
| Prüfer                   | Gerd Beneken (gerd.beneken@th-rosenheim.de)                  | Es wird erwartet, dass das Softwareprogramm und dessen Qualität überzeugend sind, um eine gute Note zu vergeben.|
| Stundent (Entwickler)    | Serap Kaya (serap.kaya@stud.th-rosenheim.de) | Es wird erwartet, dass die Architektur geplant, der Code entwickelt, die Tests geplant und durchgeführt sowie die Dokumentation erstellt wird. | 
| Anwender   |  | Es wird erwartet, dass die Anwendung schnell, zuverlässig und benutzerfreundlich ist, damit Benutzer Aktieninformationen auswählen und anzeigen können. | 
| Polygon API  | https://polygon.io/ | Es wird erwartet, dass die angebotenen Dienste verantwortungsvoll und effizient genutzt werden. | 

## Randbedingungen

### Technische Randbedingungen
-	**Plattformanforderungen:**

 	Windows, Linux oder macOS

- **Hardwareanforderung:**

  PC oder Laptop


- **Software- und Framework-Abhängigkeiten:**

  Java 17, Spring Boot 3.3.0, Maven 3.9.8, Redis 0.7.3, React 18.3.1


- **Integrationsanforderungen:**

  Redis, Polygon.io API

- **Netzwerk- und Kommunikationsanforderungen:**
  
  Externe API-Aufrufe sind ausschließlich über HTTPS abzuwickeln.

  
- **Entwicklungs- und Deployment-Anforderungen:**
  
  Einrichtung einer CI/CD-Pipeline mit GitHub Actions für automatisiertes Testen und Deployment.
  
  Verwendung von GitHub für die Versionskontrolle.
  
  Einsatz von Docker zur Containerisierung und Verwaltung der Laufzeitumgebungen.


### Organisatorische Randbedingungen

- **Zeitvorgabe:**

  Abgabetermin ist der 23.06.2024

- **Budget:**

  Es besteht kein finanzielles Interesse.

- **Kommunikationsweg:**
  
  Wöchentliche Besprechung: Jeden Montag während der Vorlesung.

  Alternativ per E-Mail an: mario-leander.reimer@th-rosenheim.de.

- **Abnahmekriterien:**

  Erfüllung der Aufgabenstellung.

- **Dokumentationsanforderungen:**

  Verwendung des arc42 Templates für die Projektdokumentation.


## Kontextabgrenzung

### Fachlicher Kontext
![Fachlicher Kontext](https://github.com/serap4/sqs-projekt-aktienanzeiger/blob/master/Bilder/Fachlicher%20Kontext.PNG)

| Kommunikationsbeziehung                    | Eingabe                                | Ausgabe                                   |
| ------------------------------- | ---------------------------------------| --------------------------------------------------- |
| User --> Aktienanzeiger                 | Aktien und Datum auswählen| - | 
| Aktienanzeiger --> Polygon API                 | Suchanfrage mit Aktien und Datum | - |
| Polygon API --> Aktienanzeiger                | - | Übermittlung der Aktiendaten für dieses Datum|
| Aktienanzeiger --> User                 | -  | Darstellung der Aktieninformationen |

### Technischer- oder Verteilungskontext

## Lösungsstrategie

Die grundlegende Entwurfsstrategie dieses Projekts basiert auf einer Reihe wesentlicher Technologieentscheidungen und Systemdesigns, die gezielt auf die spezifischen Anforderungen, Rahmenbedingungen und Qualitätsziele zugeschnitten sind. Diese strategischen Entscheidungen sind darauf ausgerichtet, die Anforderungen des Projekts optimal zu erfüllen und eine robuste, skalierbare und benutzerfreundliche Lösung zu gewährleisten.

### Technologieentscheidungen

**Backend:**

- **Technologie:** Java mit Spring Boot
- **Begründung:** Spring Boot bietet eine robuste und skalierbare Architektur, die schnelle Entwicklung und einfache Integration mit verschiedenen Datenbanken und externen APIs ermöglicht. Es hat eine breite Unterstützung in der Entwicklergemeinschaft und umfangreiche Dokumentation.
  
**Frontend:**

- **Technologie:** React
- **Begründung:** React wurde gewählt, weil es die Erstellung dynamischer und interaktiver Benutzeroberflächen ermöglicht. Es unterstützt eine modulare und wiederverwendbare Komponentenarchitektur und bietet eine hohe Performance durch virtuelle DOM-Funktionen. React ist weit verbreitet und hat eine starke Community-Unterstützung, was die langfristige Wartung und Erweiterung der Anwendung erleichtert.

**Datenbank:**

- **Technologie:** Redis
- **Begründung:** Redis ist eine In-Memory-Datenbank, die für ihre hohe Leistung und Skalierbarkeit bekannt ist. Sie unterstützt schnelle Datenzugriffe und effizientes Caching, was die Antwortzeiten der Anwendung reduziert. Redis ist ideal für Anwendungen, die schnelle Verarbeitungsgeschwindigkeiten erfordern und bietet zudem umfangreiche Funktionen zur Datenpersistenz.

**Externe API:**

- **Technologie:** Polygon.io API
- **Begründung:** Die Polygon.io API bietet umfassende und aktuelle Marktdaten, die für die Funktionalität der Aktienanzeiger-Webanwendung unerlässlich sind. Sie ist zuverlässig, gut dokumentiert und ermöglicht die einfache Integration von Echtzeit-Marktdaten.


**Versionskontrolle:**

- **Technologie:** GitHub
- **Begründung:** GitHub wird für die Versionskontrolle verwendet, da es eine weit verbreitete und bewährte Plattform ist. Es unterstützt kollaborative Entwicklung, ermöglicht einfaches Verwalten von Code-Repositories und bietet umfassende Integrationen mit anderen Tools und Diensten.

**CI/CD:**

- **Technologie:** GitHub Actions
- **Begründung:** GitHub Actions wird für die Einrichtung einer CI/CD-Pipeline verwendet, um automatisiertes Testing und Deployment zu gewährleisten. Dies ermöglicht eine kontinuierliche Integration und Bereitstellung, was die Qualität und Stabilität der Anwendung erhöht.

**Containerisierung:**

- **Technologie:** Docker
- **Begründung:** Docker wird zur Containerisierung und Verwaltung der Laufzeitumgebungen eingesetzt. Es stellt sicher, dass die Anwendung plattformunabhängig und in isolierten Umgebungen ausgeführt werden kann, was die Konsistenz und Zuverlässigkeit der Deployments erhöht.

**Code-Qualitätssicherung:**

**Technologie:** SonarCloud
**Begründung:** SonarCloud wird zur Überwachung und Verbesserung der Codequalität verwendet. Es bietet statische Codeanalyse, entdeckt Schwachstellen, Sicherheitslücken und Code-Smells und hilft dabei, die Wartbarkeit und Sicherheit des Codes zu erhöhen. SonarCloud lässt sich nahtlos in GitHub Actions integrieren und ermöglicht eine kontinuierliche Codequalitätssicherung im CI/CD-Prozess.




### Top-Level-Zerlegung des Systems

- **Präsentationsschicht (Frontend):** Die Präsentationsschicht ist verantwortlich für die Benutzerinteraktion und Darstellung der Daten. Sie wird in React implementiert und kommuniziert über REST-APIs mit dem Backend. Diese Schicht ist darauf ausgelegt, eine intuitive und reaktionsschnelle Benutzeroberfläche zu bieten, die es den Benutzern ermöglicht, schnell und effizient mit der Anwendung zu interagieren.
  
- **Geschäftslogik-Schicht (Backend):** Die Geschäftslogik-Schicht verarbeitet Anfragen vom Frontend, führt die Geschäftslogik aus und kommuniziert mit der Datenbank sowie externen APIs. Sie wird in Java mit Spring Boot entwickelt und stellt das Herzstück der Anwendung dar. Diese Schicht sorgt dafür, dass alle Geschäftsprozesse korrekt ausgeführt werden und die Datenintegrität gewahrt bleibt.

- **Datenzugriffsschicht (Datenbank):** Die Datenzugriffsschicht verwaltet die Speicherung und den effizienten Zugriff auf Daten. Redis wird als schnelle und skalierbare Datenbanklösung genutzt. Diese Schicht gewährleistet, dass Daten effizient gespeichert und abgerufen werden können, und unterstützt gleichzeitig die Caching-Strategie der Anwendung, um die Leistung zu optimieren.

- **Integrationsschicht:** Die Integrationsschicht ist für die Kommunikation mit der externen Polygon.io API verantwortlich und stellt sicher, dass die abgerufenen Daten stets aktuell sind. Diese Schicht gewährleistet eine zuverlässige und effiziente Integration externer Datenquellen, was für die Bereitstellung aktueller und genauer Aktieninformationen unerlässlich ist.


### Qualitätsanforderungen

### Organisatorische Entscheidungen

## Bausteinsicht

### Whitebox Gesamtsystem
#### Übersichtsdiagramm

![Whitebox Gesamtsystem](https://github.com/serap4/sqs-projekt-aktienanzeiger/blob/master/Bilder/Whitbox%20Gesamtsystem.PNG)

**Begründung:**
#### Erhaltene Bausteine
#### Wichtige Schnittstellen
### Ebene 2

## Laufzeitsicht

### Laufzeitszenario 1 

### Laufzeitszenario 2

## Verteilungssicht

### Infrastruktur Ebene 1

### Infrastruktur Ebene 2

## Querschnittliche Konzepte

### Fachlich Struktur und Modelle

### Architektur- und Entwurfsmuster

### Unter-der-Haube

### User Experience

## Entwurfsentscheidungen

### Entwurfsentscheidung 1

### Entwurfsentscheidung 2

## Qualitätsanforderung

### Qualitätsbaum

### Qualitätszenarien

## Risiken und technische Schulden

## Glossar
| Begriff                         | Beschreibung                           | 
| ------------------------------- | ---------------------------------------|
| Spring Boot                     |                                        |
| React                           |                                        |
| Redis                           |                                        |
| GitHub Actions                  |                                        |
| SonarCloud                      |                                        |
| CI/CD-Pipeline                  |                                        |
| Caching                         |                                        |
| JUnit                           |                                        |
| Artillery                       |                                        |
| ArchUnit                        |                                        |
| Playwright                      |                                        |
| Docker                          |                                        |
| Docker-Compose                  |                                        |
| Unit-Test                       |                                        |
| Integrationstest                |                                        |
| End-to-End-Test                 |                                        |
| Statische Code Analyse          |                                        |
|                                 |                                        |
|                                 |                                        |
|                                 |                                        |
|                                 |                                        |
|                                 |                                        |
|                                 |                                        |
|                                 |                                        |







