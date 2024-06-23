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

![Technischerkontext](https://github.com/serap4/sqs-projekt-aktienanzeiger/blob/master/Bilder/UML-Deployment-Diagramm.png)
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

- **Technologie:** SonarCloud
- **Begründung:** SonarCloud wird zur Überwachung und Verbesserung der Codequalität verwendet. Es bietet statische Codeanalyse, entdeckt Schwachstellen, Sicherheitslücken und Code-Smells und hilft dabei, die Wartbarkeit und Sicherheit des Codes zu erhöhen. SonarCloud lässt sich nahtlos in GitHub Actions integrieren und ermöglicht eine kontinuierliche Codequalitätssicherung im CI/CD-Prozess.

### Top-Level-Zerlegung des Systems

- **Präsentationsschicht (Frontend):** Die Präsentationsschicht ist verantwortlich für die Benutzerinteraktion und Darstellung der Daten. Sie wird in React implementiert und kommuniziert über REST-APIs mit dem Backend. Diese Schicht ist darauf ausgelegt, eine intuitive und reaktionsschnelle Benutzeroberfläche zu bieten, die es den Benutzern ermöglicht, schnell und effizient mit der Anwendung zu interagieren.
  
- **Geschäftslogik-Schicht (Backend):** Die Geschäftslogik-Schicht verarbeitet Anfragen vom Frontend, führt die Geschäftslogik aus und kommuniziert mit der Datenbank sowie externen APIs. Sie wird in Java mit Spring Boot entwickelt und stellt das Herzstück der Anwendung dar. Diese Schicht sorgt dafür, dass alle Geschäftsprozesse korrekt ausgeführt werden und die Datenintegrität gewahrt bleibt.

- **Datenzugriffsschicht (Datenbank):** Die Datenzugriffsschicht verwaltet die Speicherung und den effizienten Zugriff auf Daten. Redis wird als schnelle und skalierbare Datenbanklösung genutzt. Diese Schicht gewährleistet, dass Daten effizient gespeichert und abgerufen werden können, und unterstützt gleichzeitig die Caching-Strategie der Anwendung, um die Leistung zu optimieren.

- **Integrationsschicht:** Die Integrationsschicht ist für die Kommunikation mit der externen Polygon.io API verantwortlich und stellt sicher, dass die abgerufenen Daten stets aktuell sind. Diese Schicht gewährleistet eine zuverlässige und effiziente Integration externer Datenquellen, was für die Bereitstellung aktueller und genauer Aktieninformationen unerlässlich ist.


### Qualitätsanforderungen

**Übertragbarkeit (Portability):**
Die Fähigkeit des Systems, in verschiedenen Umgebungen oder Plattformen betrieben zu werden, ist von entscheidender Bedeutung. Das Ziel ist es, eine effiziente Ressourcennutzung und plattformunabhängige Nutzbarkeit zu gewährleisten und externe Abhängigkeiten zu reduzieren. Um dies zu erreichen, werden End-to-End-Tests mit Playwright durchgeführt, die Nutzung von Docker zur Containerisierung implementiert, um Laufzeitumgebungen zu isolieren und Plattformunabhängigkeit sicherzustellen, sowie Docker-Compose-Dateien verwendet, um die Services zu starten.

**Benutzerfreundlichkeit (Usability):**
Die Anwendung muss einfach und effizient zu bedienen sein, damit Benutzer das System problemlos verwenden und ihre Aufgaben schnell erledigen können. Ziele sind eine klar strukturierte Benutzeroberfläche und eine einfache Bedienbarkeit. Maßnahmen zur Erreichung dieser Ziele umfassen UI-Tests und End-to-End-Tests mit Playwright, um sicherzustellen, dass die Benutzeroberfläche intuitiv und benutzerfreundlich gestaltet ist.

**Zuverlässigkeit (Reliability):**
Das System muss in der Lage sein, unter festgelegten Bedingungen korrekt zu funktionieren und eine hohe Stabilität bei starker Nutzung zu gewährleisten. Um dies zu erreichen, werden Integrations- und umfassende Unit-Tests durchgeführt, um die Zuverlässigkeit und Stabilität des Systems zu überprüfen. Darüber hinaus werden Lasttests mit Artillery eingesetzt, um sicherzustellen, dass das System auch unter hoher Last stabil bleibt und die robuste Verarbeitung von Benutzereingaben gewährleistet ist.

### Organisatorische Entscheidungen

**CI/CD-Pipeline mit GitHub Actions:**
Ein zentraler Bestandteil dieser Entscheidungen ist die Einrichtung einer CI/CD-Pipeline mithilfe von GitHub Actions. Diese Pipeline automatisiert den gesamten Entwicklungsprozess von der Code-Einreichung bis zur Bereitstellung und ermöglicht eine kontinuierliche Integration und Auslieferung neuer Funktionen und Verbesserungen. Bei jedem Commit oder Pull-Request wird der Code automatisch gebaut und durch eine Reihe von Tests überprüft. Dazu gehören Unit-Tests, Integrationstests und End-to-End-Tests, die sicherstellen, dass die Anwendung sowohl funktional als auch stabil bleibt.

**Testing-Strategien:**
Speziell für das Frontend werden Tests durchgeführt, um sicherzustellen, dass die Benutzeroberfläche den Anforderungen entspricht und eine positive Nutzererfahrung bietet. Im Backend kommen ArchUnit-Tests zum Einsatz, um die Einhaltung von Architekturprinzipien zu gewährleisten. Zudem werden die Dockerfiles gelintet, um ihre syntaktische Korrektheit sicherzustellen. Ein weiteres wichtiges Tool in diesem Entwicklungsprozess ist SonarCloud. Es wird verwendet, um den Code kontinuierlich zu analysieren und sicherzustellen, dass er den Qualitätsstandards entspricht. Sicherheitslücken, Code-Smells und andere potenzielle Probleme werden so frühzeitig erkannt und behoben. Um die Anwendung auf ihre Leistungsfähigkeit und Stabilität unter hoher Last zu testen, werden automatisierte Lasttests mit Artillery durchgeführt. Diese Tests helfen dabei, die Belastbarkeit des Systems zu überprüfen und sicherzustellen, dass es auch bei intensiver Nutzung zuverlässig funktioniert.

**Verwendung von Docker:**
Docker wird zur Containerisierung und Verwaltung der Laufzeitumgebungen eingesetzt. Diese Entscheidung ermöglicht es, die Anwendung in isolierten Containern zu entwickeln und bereitzustellen, was die Konsistenz zwischen Entwicklungs-, Test- und Produktionsumgebungen sicherstellt. Docker-Compose wird verwendet, um die verschiedenen Services der Anwendung einfach zu starten und zu verwalten. Diese Vorgehensweise erleichtert die Einrichtung und den Betrieb der gesamten Entwicklungsumgebung und reduziert potenzielle Konflikte zwischen Abhängigkeiten. Nach Abschluss der Tests werden Docker-Container erstellt und in einer Registry gespeichert. Diese Container ermöglichen eine konsistente Bereitstellung der Anwendung in verschiedenen Umgebungen.

**Versionskontrolle mit GitHub:**
Für die Versionskontrolle wird GitHub verwendet. Diese Plattform ermöglicht eine effiziente Verwaltung des Codes, indem alle Änderungen in einem zentralen Repository nachverfolgt werden. Dies erleichtert die Sicherung der Entwicklungsfortschritte und ermöglicht bei Bedarf eine einfache Wiederherstellung früherer Versionen.

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

**Übertragbarkeit (Portability):**
Die Fähigkeit des Systems, in verschiedenen Umgebungen oder Plattformen betrieben zu werden, ist von entscheidender Bedeutung. Das Ziel ist es, eine effiziente Ressourcennutzung und plattformunabhängige Nutzbarkeit zu gewährleisten und externe Abhängigkeiten zu reduzieren. Um dies zu erreichen, werden End-to-End-Tests mit Playwright durchgeführt, die Nutzung von Docker zur Containerisierung implementiert, um Laufzeitumgebungen zu isolieren und Plattformunabhängigkeit sicherzustellen, sowie Docker-Compose-Dateien verwendet, um die Services zu starten.

**Benutzerfreundlichkeit (Usability):**
Die Anwendung muss einfach und effizient zu bedienen sein, damit Benutzer das System problemlos verwenden und ihre Aufgaben schnell erledigen können. Ziele sind eine klar strukturierte Benutzeroberfläche und eine einfache Bedienbarkeit. Maßnahmen zur Erreichung dieser Ziele umfassen UI-Tests und End-to-End-Tests mit Playwright, um sicherzustellen, dass die Benutzeroberfläche intuitiv und benutzerfreundlich gestaltet ist.

**Zuverlässigkeit (Reliability):**
Das System muss in der Lage sein, unter festgelegten Bedingungen korrekt zu funktionieren und eine hohe Stabilität bei starker Nutzung zu gewährleisten. Um dies zu erreichen, werden Integrations- und umfassende Unit-Tests durchgeführt, um die Zuverlässigkeit und Stabilität des Systems zu überprüfen. Darüber hinaus werden Lasttests mit Artillery eingesetzt, um sicherzustellen, dass das System auch unter hoher Last stabil bleibt und die robuste Verarbeitung von Benutzereingaben gewährleistet ist.
### Qualitätsbaum
![Qualitätsbaum](https://github.com/serap4/sqs-projekt-aktienanzeiger/blob/master/Bilder/Qualit%C3%A4tsbaum.PNG)

### Qualitätszenarien
| Attribut                  | Szenario                                | Maßnahme                                  |
| ------------------------------- | ---------------------------------------| --------------------------------------------------- |
| Portability - Übertragbarkeit | Nutzungsszenario: Die Anwendung wird in Docker-Containern betrieben und auf unterschiedlichen Plattformen ausgeführt.| Verwendung von Docker Compose für die Koordination und Docker für die Containerisierung. |
|  | Anwendungsszenario: Unterstützung und Tests für neue Container-Umgebungen werden durchgeführt.| Isolierte Ausführungsumgebung|
|  | Nutzungsszenario: Die Anwendung ist in verschiedenen Browsern einwandfrei funktionsfähig.| End-to-End-Tests mit Playwright |
|  | Änderungsszenario: Unterstützung und Tests für kommende Browser-Versionen werden durchgeführt.| Regelmäßige Aktualisierungen und Prüfungen mit Playwright |
| Usability - Benutzerfreundlichkeit | Nutzungsszenario: Anwender können Aktien leicht finden und die Suchergebnisse anzeigen lassen.| Intuitives UI-Design und benutzerfreundliche Navigation. Durchführung von End-to-End-Tests mit Playwright. |
|  | Änderungsszenario: Optimierungen der Benutzeroberfläche werden stetig durchgeführt.| Einholung und Implementierung von Benutzerfeedback, Durchführung von UI-Tests.|
| | Nutzungsszenario: Das System präsentiert relevante Aktieninformationen deutlich und übersichtlich.| Strukturierte Gestaltung, einheitliche Präsentation der Informationen. |
| | Änderungsszenario: Neue Designanforderungen von Nutzern werden fortlaufend eingebunden.| Kontinuierliche Evaluierung und Anpassung an die Bedürfnisse der Nutzer.|
| Reliability - Zuverlässigkeit| Nutzungsszenario: Zur Sicherstellung der Zuverlässigkeit wird das System gründlich geprüft.| End-to-End-Tests, Unit-Tests, Integrationstests, Lasttests |
|  | Änderungsszenario: Das Testkonzept wird bei jeder Codeänderung regelmäßig überarbeitet.| Weitreichende Testabdeckung |
|  | Nutzungsszenario: Das System bleibt auch bei hoher Auslastung zuverlässig und reagiert zügig.| Lasttests mit Artillery |
|  | Änderungsszenario: Zusätzliche Anforderungen machen Anpassungen und erneute Prüfungen der Systemstabilität erforderlich.| Überarbeitung der Tests |

## Risiken und technische Schulden

| Risiko/Technische Schuld | Beschreibung      | 	Maßnahme zur Risikovermeidung/Risikominimierung/Abbau der technischen Schuld	      | Priorität      |
| -------------- | -------------- | -------------- | -------------- |
| Skalierungsprobleme | Herausforderungen bei der Handhabung vieler gleichzeitiger Benutzer während Marktspitzen, da das Spring Boot Backend unter hoher Last an seine Grenzen stoßen könnte.| Regelmäßig Lasttests durchführen, Skalierungstechniken implementieren und horizontales Skalieren unterstützen.| Hoch |
| Sicherheitsschwachstellen | Mögliche Sicherheitslücken im Code, die zu Datenverlust oder unbefugtem Zugriff führen könnten. | Regelmäßige Sicherheitsprüfungen, Implementierung von Authentifizierung und Autorisierung, Einsatz von Verschlüsselungstechniken| Hoch |
| Unzureichende Testabdeckung | Fehlende oder unvollständige Tests, die die Wahrscheinlichkeit von unentdeckten Fehlern erhöhen.| Erhöhung der Testabdeckung durch Unit-, Integrations- und End-to-End-Tests | Hoch |
| Performance-Probleme	 | Langsame Reaktionszeiten der Anwendung unter hoher Last oder bei komplexen Anfragen. | Implementierung von Performance-Monitoring, Optimierung der Datenbankabfragen, Einsatz von Caching-Techniken | Hoch |
| Abhängigkeit von Drittanbieter-APIs | Risiken durch Änderungen oder Ausfälle der externen APIs, die die Anwendung nutzt. |Implementierung von Fallback-Mechanismen, regelmäßige Überwachung der API-Verfügbarkeit| Hoch |
| Docker-Komplexität | Die Komplexität der Docker-Umgebungen kann zu Konfigurationsfehlern und Schwierigkeiten bei der Verwaltung führen. | Bereitstellung umfassender Dokumentation und Schulungen, Einsatz von Best Practices für Docker-Container und Orchestrierung mit Docker Compose| Mittel |
| Wartungsaufwand | Erhöhter Wartungsaufwand durch ständige Updates und Modifikationen der Abhängigkeiten sowie Dockerfiles. | Automatisierung von Wartungsprozessen, regelmäßige Inspektion und Erneuerung der Abhängigkeiten. | Mittel |


## Glossar
| Begriff                         | Beschreibung                           | 
| ------------------------------- | ---------------------------------------|
| Spring Boot                     |                                        |
| React                           |                                        |
| Redis                           |                                        |
| GitHub Actions                  |                                        |
| GitHub                          |                                        |
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







