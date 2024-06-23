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
| User --> Aktienanzeiger                 | Aktien und Datum auswählen|  Benutzeroberflächenaktualisierungen | 
| Aktienanzeiger --> Polygon API                 | Suchanfrage mit Aktien und Datum | - |
| Polygon API --> Aktienanzeiger                | - | Übermittlung der Aktiendaten für dieses Datum|
| Aktienanzeiger --> User                 | Benutzeroberflächenaktualisierungen  | Darstellung der Aktieninformationen |

### Technischer- oder Verteilungskontext
Das System ruft Aktieninformationen über die externe Polygon API im Spring Boot Backend ab. Diese Daten werden in der Redis-Datenbank zwischengespeichert und über die React-Webanwendung den Benutzern zur Verfügung gestellt.

#### UML Deployment Diagramm
![Technischerkontext](https://github.com/serap4/sqs-projekt-aktienanzeiger/blob/master/Bilder/UML-Deployment-Diagramm.png)


| Technischer Kanal                    | Eingabe                                | Ausgabe                                  |
| ------------------------ | ---------------------------------------| --------------------------------------------------- |
| User --> React Frontend | Benutzeraktion (z. B.: Aktien und Datum | Aktualisierung der Benutzeroberfläche |
| React Frontend --> StockController | HTTP Request (Akten und Datum) | HTTP Response (Aktieninformation) |
| StockController --> StockService | API Requesst (Aktien und Datum) | Ergebnis der Datenabfrage |
| StockService --> ApiCommunicationService | API Requesst (Aktien und Datum)| Ergebnis der Datenabfrage |
| ApiCommunicationService --> Polygon API | HTTP Request (Aktien und Datum| HTTP Response (Aktieninformation) |
| Polygon API --> ApiCommunicationService | | HTTP Response (Aktieninformationen) |
| StockService --> CacheService | Datenabfrage | Daten speichern und abrufen |
| CacheService --> Redis Cache | Datenabfrage| Datenübertragung (Aktieninformation) |
| Redis Cache --> DataProcessingService || Datenübertragung (Aktieninformation) |
| DataProcessingService --> StockService | Datenkonvertierung	| Datenübertragung |
| StockService --> StockControlller | Datenabfrage | Datenübertragung (Aktieninformation) |
| StockService --> React Frontend |  HTTP Response | Aktualisierte Benutzeroberfläche |
### Schnittstelle zum Spring Boot Backend
Die Klasse `StockController` stellt die Schnittstelle zwischen dem Frontend und dem Backend dar. Sie verarbeitet die HTTP-Anfragen vom Frontend und leitet sie an den `StockService` weiter, der die Geschäftslogik ausführt und die Datenverarbeitung durchführt.
Innerhalb von `StockController` werden die folgenden Endpunkte definiert:

- `HTTP GET /stock/{symbol}/{date}`: Ruft die Aktieninformationen für das angegebene Symbol und Datum ab.
- `HTTP GET /stock/delete/{symbol}/{date}`: Löscht die Aktieninformationen für das angegebene Symbol und Datum.

Die unterschiedlichen Parameter sind wie folgt definiert:

- `{symbol}`: Das Symbol der Aktie, für die die Informationen abgerufen oder gelöscht werden sollen.
- `{date}`: Das Datum, für das die Aktieninformationen abgerufen oder gelöscht werden sollen.

Die Klasse gibt dem Frontend verschiedene HTTP-Statuscodes zurück, die wie folgt definiert sind:

- `200 OK`: Die Anfrage wurde erfolgreich bearbeitet.
- `400 Bad Request`: Die Anfrage war fehlerhaft oder unvollständig.
- `500 Internal Server Error`: Ein interner Serverfehler ist aufgetreten.
- Rückgabe der Aktieninformationen im JSON-Format.

### Externe Schnittstelle Polygon API
Die Polygon API ist eine externe Datenquelle, die Echtzeit- und historische Aktieninformationen bereitstellt. Sie wird vom Backend verwendet, um aktuelle und genaue Aktieninformationen abzurufen. Die API bietet verschiedene Endpunkte, die es ermöglichen, Aktieninformationen für bestimmte Symbole und Daten abzurufen. Die Daten werden im JSON-Format übermittelt und enthalten Informationen wie den Eröffnungs- und Schlusskurs, das Handelsvolumen und andere relevante Marktdaten.
Die Klasse `ApiCommunicationService` ist für die Kommunikation mit der Polygon API verantwortlich. Sie initiiert HTTP-Anfragen an die API-Endpunkte und verarbeitet die empfangenen Daten. Die Klasse stellt sicher, dass die Daten korrekt abgerufen und verarbeitet werden und dass die Aktieninformationen in einem geeigneten Format an das Backend übermittelt werden.
Polygon API besitzt folgende Endpunkte:
- `HTTP GET https://api.polygon.io/v1/open-close/{symbol}/{date}?adjusted=true&apiKey=apikey`: Endpunkt zum Abrufen der Aktieninformationen für das angegebene Symbol und Datum.

Die parameter sind wie folgt definiert:
- `{symbol}`: Das Symbol der Aktie, für die die Informationen abgerufen werden sollen.
- `{date}`: Das Datum, für das die Aktieninformationen abgerufen werden sollen.
- `adjusted=true`: Gibt an, ob die Daten angepasst werden sollen. Dieser Wert ist standardmäßig auf `true` gesetzt, damit die Daten bereinigt und korrigiert werden von der API.
- `apiKey`: Der API-Schlüssel, der für die Authentifizierung bei der Polygon API verwendet wird.
- Rückgabe der Aktieninformationen im JSON-Format.

Die Dokumentation der Polygon API ist unter folgendem Link verfügbar: https://polygon.io/docs/get_v1_open_close__symbol___date__anchor

### Mapping fachlicher auf technische Schnittstellen

- Fachliche Schnittstelle: Benutzereingabe im Frontend  -> Technische Schnittstelle: HTTP Request an StockController
- Fachliche Rückmeldung: Anzeige der Aktieninformationen im Frontend -> Technische Rückmeldung: HTTP Response von StockController
- 

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

**Begründung:** Die Unterteilung des Gesamtsystems in verschiedene Komponenten erfolgt nach den Prinzipien der Modularität und der Verantwortlichkeitstrennung. Dies erleichtert die Wartung und Erweiterung des Systems.

#### Erhaltene Bausteine
| Name                         | Verantwortung                           | 
| ------------------------------- | ---------------------------------------|
| React Frontend | Auslieferung der Benutzeroberfläche-|
| Spring Boot Backend | Implementierung der Geschäftslogik und Bereitstellung der API-Schnittstellen|
| Redis Datenbank | Datenhaltung und -verwaltung|
| Polygon API | Externe Datenquelle für Brauereiinformationen |

#### Wichtige Schnittstellen
| Schnittstelle                          | Beschreibung                          | 
| ------------------------------- | ---------------------------------------|
| Backend-Externe API | Kommunikationsschnittstelle zwischen dem React-Frontend und dem Spring Boot-Backend |
| Backend-Datenbank | Kommunikatonsschnittstelle zwischen den Spring Boot Backend und Redis Datenbank |
| Frontend-Backend  | Kommunikationsschnittstelle zwischen Spring Boot Backend und Polygon API|

### React Frontend
**Zweck/Verantwortung:** Das React Frontend ist für die Darstellung der Benutzeroberfläche und die Interaktion mit dem Benutzer verantwortlich. Es ermöglicht es den Benutzern, Aktien auszuwählen und die entsprechenden Informationen anzuzeigen.

**Schnittstellen:**
- `HTTP GET /stock/{symbol}/{date}`: Ruft die Aktieninformationen für das angegebene Symbol und Datum ab.
- `HTTP GET /stock/delete/{symbol}/{date}`: Löscht die Aktieninformationen für das angegebene Symbol und Datum.

### Spring Boot Backend
**Zweck/Verantwortung:** Das Spring Boot Backend ist für die Implementierung der Geschäftslogik und die Bereitstellung der API-Schnittstellen verantwortlich. Es verarbeitet die Anfragen vom Frontend, kommuniziert mit der Datenbank und der externen API und stellt die Aktieninformationen bereit.

**Schnittstellen:**
- `HTTP GET /stock/{symbol}/{date}`: Ruft die Aktieninformationen für das angegebene Symbol und Datum ab.
- `HTTP GET /stock/delete/{symbol}/{date}`: Löscht die Aktieninformationen für das angegebene Symbol und Datum.
-  `CacheService`: Schnittstelle zur Redis-Datenbank für das Caching von Aktieninformationen.

### Redis Datenbank
**Zweck/Verantwortung:** Die Redis-Datenbank ist für die Speicherung und Verwaltung der Aktieninformationen verantwortlich. Sie dient als Zwischenspeicher für häufig abgerufene Daten und ermöglicht eine schnelle und effiziente Datenabfrage.

**Schnittstellen:**
- `CacheService`: Schnittstelle zum Backend für das Caching von Aktieninformationen.

### Polygon API
**Zweck/Verantwortung:** Die Polygon API ist eine externe Datenquelle, die Echtzeit- und historische Aktieninformationen bereitstellt. Sie wird vom Backend verwendet, um aktuelle und genaue Aktieninformationen abzurufen.

**Schnittstellen:**
- `HTTP GET https://api.polygon.io/v1/open-close/{symbol}/{date}`: Endpunkt zum Abrufen der Aktieninformationen für das angegebene Symbol und Datum.


## Laufzeitsicht

### Szenario 1: Abruf von Aktieninformationen (Cache-Hit) 
1. **Benutzeranfrage im Frontend:** Ein Benutzer durchstöbert die React basierte Webanwendung und selektiert eine Aktie sowie ein Datum, um die zugehörigen Aktieninformationen abzurufen.
2. **Anfrage an das Backend:** Das Frontend übermittelt eine HTTP-GET-Anfrage an das Spring Boot-Backend. Der entsprechende Endpunkt lautet /stock/{symbol}/{date}.
3. **Überprüfung des Caches im Backend:** Das Backend kontrolliert, ob die Aktieninformationen für die ausgewählte Aktie und das angegebene Datum bereits im Redis-Cache gespeichert sind.
4. **Cache-Hit:** Falls die Informationen im Cache gespeichert sind, werden sie aus dem Cache an das Backend übertragen.
5. **Antwort an das Frontend:** Das Backend übermittelt die Aktieninformationen an das Frontend.
6. **Anzeige der Daten:** Das Frontend präsentiert dem Benutzer die erhaltenen Aktieninformationen.

### Laufzeitdiagramm
![Szenario 1](https://github.com/serap4/sqs-projekt-aktienanzeiger/blob/master/Bilder/Laufzeitdiagramm%201.PNG)

### Szenario 2: 

1. **Benutzeranfrage im Frontend:** Ein Benutzer durchstöbert die React basierte Webanwendung und selektiert eine Aktie sowie ein Datum, um die zugehörigen Aktieninformationen abzurufen.
2. **Anfrage an das Backend:** Das Frontend übermittelt eine HTTP-GET-Anfrage an das Spring Boot-Backend. Der entsprechende Endpunkt lautet /stock/{symbol}/{date}.
3. **Überprüfung des Caches im Backend:** Das Backend kontrolliert, ob die Aktieninformationen für die ausgewählte Aktie und das angegebene Datum bereits im Redis-Cache gespeichert sind.
4.  **Cache-Miss**: Falls die Informationen nicht im Cache verfügbar sind, wird eine Anfrage an die externe Polygon API gesendet.
5.  **Anfrage an die API der Polygon:** Das Backend initiiert eine HTTP-GET-Anfrage an die Polygon API, um die Aktieninformationen für die gewählte Aktie und das ausgewählte Datum zu erhalten.
6.  **Empfang und Speicherung der Daten**: Die Polygon API übermittelt die Daten im JSON-Format. Diese Informationen werden vom Backend in der Redis-Datenbank zwischengespeichert.
7.  **Antwort an das Frontend:** Das Backend übermittelt die Aktieninformationen an das Frontend.
8.  **Anzeiger der Daten:** Das Frontend präsentiert die abgerufenen Aktieninformationen dem Benutzer.

### Laufzeitdiagramm
![Szenario 2](https://github.com/serap4/sqs-projekt-aktienanzeiger/blob/master/Bilder/Laufzeitdiagramm%202%20.PNG)

### Szenario 3: Löschung von Aktieninformationen

1. **Benutzeranfrage im Frontend:** Ein Benutzer durchstöbert die React basierte Webanwendung und selektiert eine Aktie sowie ein Datum, um die zugehörigen Aktieninformationen abzurufen.
2. **Anfrage an das Backend:** Das Frontend übermittelt eine HTTP-GET-Anfrage an das Spring Boot-Backend. Der entsprechende Endpunkt lautet /stock/delete{symbol}/{date}.
3. **Überprüfung des Caches im Backend:** Das Backend kontrolliert, ob die Aktieninformationen für die ausgewählte Aktie und das angegebene Datum bereits im Redis-Cache gespeichert sind.
4. **Löschung der Aktieninformation aus der Datenbank:** Falls die Informationen im Cache gespeichert sind, werden sie aus dem Cache gelöscht.
5. **Antwort an das Frontend:** Das Backend bestätigt, dass die ausgewählte Nachricht gelöscht wurde.
6.  **Anzeiger der Daten:** Eine leere Tabelle wird dargestellt.

### Laufzeitdiagramm
![Szenario 3](https://github.com/serap4/sqs-projekt-aktienanzeiger/blob/master/Bilder/Laufzeitdiagramm%203.PNG)

## Verteilungssicht

### Infrastruktur Ebene 1

### Infrastruktur Ebene 2

## Querschnittliche Konzepte

### Fachlich Struktur und Modelle

### Architektur- und Entwurfsmuster

### Unter-der-Haube

### User Experience

## Architekturentscheidung

### Technologieauswahl:

In diesem Projekt kamen die folgenden Technologien zum Einsatz:

- Spring Boot: Dient zur Implementierung des Backends aufgrund seiner Robustheit und Skalierbarkeit, sowie der einfachen Integration von Microservices. 

- React: Wird für die Entwicklung des Frontends verwendet, da es eine dynamische und reaktive Benutzeroberfläche ermöglicht und durch seine Komponentenstruktur die Wartbarkeit verbessert.

- Redis: Wird als In-Memory-Datenbank eingesetzt, um schnelle Zugriffszeiten und effizientes Caching zu gewährleisten, was die Performance der Anwendung erhöht.

- Polygon API: Diese API liefert Echtzeit- und historische Marktdaten, die für die Anwendung benötigt werden, um aktuelle Aktieninformationen bereitzustellen.

- Playwright: Ein Framework für End-to-End-Tests, das sicherstellt, dass die gesamte Anwendung von Anfang bis Ende korrekt funktioniert und eine gute Benutzererfahrung bietet.

- Docker Compose: Wird zur Orchestrierung von Multi-Container-Docker-Anwendungen verwendet, um eine einfache Verwaltung und Koordination der verschiedenen Services zu ermöglichen.

- Docker: Ermöglicht die Containerisierung der Anwendung, was für konsistente Laufzeitumgebungen sorgt und die Portabilität und Skalierbarkeit verbessert.

- ArchUnit: Ein Framework zur Überprüfung der Einhaltung von Architekturregeln im Java-Code, um sicherzustellen, dass die Architektur konsistent und wartbar bleibt.

- GitHub Actions: Dient zur Implementierung der CI/CD-Pipeline, um automatisierte Builds, Tests und Deployments zu ermöglichen und somit die Effizienz und Zuverlässigkeit der Entwicklungsprozesse zu steigern.

- SonarCloud: Ein Tool zur statischen Codeanalyse, das zur Verbesserung der Codequalität und zur Erkennung von Sicherheitslücken und Code-Smells eingesetzt wird.

- Artillery: Wird für Last- und Performance-Tests verwendet, um die Belastbarkeit und Leistungsfähigkeit der Anwendung unter verschiedenen Bedingungen sicherzustellen.

- JUnit: Ein Framework für Unit-Tests in Java, das zur Überprüfung der einzelnen Komponenten der Anwendung eingesetzt wird, um deren Funktionalität sicherzustellen.


### Schichtenmodell
- **Präsentationsschicht (Frontend)** 
Die Präsentationsschicht ist verantwortlich für die Benutzerinteraktion und Darstellung der Daten. Sie wird in React implementiert und kommuniziert über REST-APIs mit dem Backend. Diese Schicht ist darauf ausgelegt, eine intuitive und reaktionsschnelle Benutzeroberfläche zu bieten, die es den Benutzern ermöglicht, schnell und effizient mit der Anwendung zu interagieren.
  
- **Geschäftslogik-Schicht (Backend):** Die Geschäftslogik-Schicht verarbeitet Anfragen vom Frontend, führt die Geschäftslogik aus und kommuniziert mit der Datenbank sowie externen APIs. Sie wird in Java mit Spring Boot entwickelt und stellt das Herzstück der Anwendung dar. Diese Schicht sorgt dafür, dass alle Geschäftsprozesse korrekt ausgeführt werden und die Datenintegrität gewahrt bleibt.

- **Datenzugriffsschicht (Datenbank):** Die Datenzugriffsschicht verwaltet die Speicherung und den effizienten Zugriff auf Daten. Redis wird als schnelle und skalierbare Datenbanklösung genutzt. Diese Schicht gewährleistet, dass Daten effizient gespeichert und abgerufen werden können, und unterstützt gleichzeitig die Caching-Strategie der Anwendung, um die Leistung zu optimieren.

- **Integrationsschicht:** Die Integrationsschicht ist für die Kommunikation mit der externen Polygon.io API verantwortlich und stellt sicher, dass die abgerufenen Daten stets aktuell sind. Diese Schicht gewährleistet eine zuverlässige und effiziente Integration externer Datenquellen, was für die Bereitstellung aktueller und genauer Aktieninformationen unerlässlich ist.

### Entwicklungsprozess

Der Entwicklungsprozess für die Aktienanzeiger-Webanwendung wurde sorgfältig strukturiert und in mehreren Phasen durchgeführt, um eine hohe Qualität und Effizienz zu gewährleisten.

**1. Backend-Entwicklung:**
Der Prozess begann mit der Entwicklung des Backends, das mit Java und dem Spring Boot Framework umgesetzt wurde. Diese Phase umfasste die Implementierung der Geschäftslogik und der Datenzugriffsschicht. Dabei wurden die grundlegenden Funktionalitäten der Anwendung, wie die Verarbeitung von Benutzeranfragen und die Verwaltung der Datenbank, entwickelt. Es wurde besonderer Wert auf eine robuste und skalierbare Architektur gelegt, um zukünftige Erweiterungen und Anpassungen zu erleichtern.

**2. Frontend-Entwicklung:**
Nach Abschluss der Backend-Entwicklung wurde die Frontend-Entwicklung mit React gestartet. Diese Phase konzentrierte sich auf die Gestaltung einer benutzerfreundlichen und intuitiven Benutzeroberfläche. Es wurde eine klare und strukturierte Navigation implementiert, die es den Benutzern ermöglicht, Aktieninformationen schnell und einfach zu finden. Die Benutzeroberfläche wurde so gestaltet, dass sie responsiv ist und auf verschiedenen Geräten und Bildschirmgrößen optimal funktioniert.

**3. API-Integration:**
Anschließend wurde die Verbindung zur externen Polygon API hergestellt, um Echtzeit- und historische Marktdaten zu integrieren. Diese Phase umfasste die Implementierung der Schnittstellen zur externen API, die Datenabfrage und -verarbeitung sowie die Sicherstellung der Datenintegrität und Aktualität. Es wurden Fallback-Mechanismen implementiert, um die Zuverlässigkeit der Anwendung auch bei Ausfällen der externen API zu gewährleisten.

**4. Testen:**
Nach der erfolgreichen Integration der API wurde eine umfassende Testphase durchgeführt. Dabei kamen verschiedene Testmethoden zum Einsatz, einschließlich Unit-Tests, Integrationstests und End-to-End-Tests, um die Funktionalität, Zuverlässigkeit und Leistung der Anwendung sicherzustellen. Zusätzlich wurden Usability-Tests durchgeführt, um die Benutzerfreundlichkeit der Benutzeroberfläche zu überprüfen und zu optimieren.

**5. Implementierung der CI/CD-Pipeline:**
Zum Abschluss des Entwicklungsprozesses wurde eine CI/CD-Pipeline mithilfe von GitHub Actions eingerichtet. Diese Pipeline automatisiert den gesamten Build-, Test- und Deployment-Prozess. Bei jedem Push oder Pull-Request wird der Code automatisch gebaut und durch die definierten Tests geprüft. Nach erfolgreicher Prüfung wird die Anwendung in Docker-Containern gepackt und bereitgestellt. Diese Automatisierung gewährleistet eine kontinuierliche Integration und Auslieferung neuer Funktionen und Verbesserungen, was die Effizienz und Zuverlässigkeit der Bereitstellungsprozesse erheblich erhöht.

### Technologische Eigenschaften des Projekts

**Backend**

| Begriff                         | Beschreibung                           | 
| ------------------------------- | ---------------------------------------|
| Technologie | Version|
| Java | 17 |
| Spring Boot | 3.3.0 |
| Maven  | 3.9.8|

**Frontend**
| Begriff                         | Beschreibung                           | 
| ------------------------------- | ---------------------------------------|
| Technologie | Version|
| React | 18.3.1 |
| Node | 18 |


**Database**
| Begriff                         | Beschreibung                           | 
| ------------------------------- | ---------------------------------------|
| Technologie | Version|
| Redis | 0.7.3 |

**Testing**
| Begriff                         | Beschreibung                           | 
| ------------------------------- | ---------------------------------------|
| ArchUnit | 0.22.0|
| Artillery | latest |
| JUnit | 5|
| Playwright |	latest |




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
| Spring Boot                     | Ein Framework zur Erstellung von Microservices und autonomen Anwendungen in Java, das eine einfache Konfiguration und schnelles Setup ermöglicht.|
| React                           | Eine JavaScript-Bibliothek zur Entwicklung von Benutzeroberflächen, die durch komponentenbasierte Architektur und hohe Performance besticht. |
| Redis                           | Eine In-Memory-Datenbank, die hohe Geschwindigkeit und Skalierbarkeit für Caching und schnelle Datenzugriffe bietet. |
| GitHub Actions                  | Ein CI/CD-Dienst, der es ermöglicht, automatisierte Workflows für Builds, Tests und Deployments direkt in GitHub zu erstellen und auszuführen.|
| GitHub                          | Eine Plattform zur Versionskontrolle und Zusammenarbeit, die das Verwalten von Code-Repositories und die Nachverfolgung von Änderungen erleichtert.|
| SonarCloud                      | Ein Tool zur statischen Codeanalyse, das Codequalität, Sicherheitslücken und Code-Smells erkennt und Bericht erstattet.|
| CI/CD-Pipeline                  | Ein automatisierter Workflow, der Continuous Integration und Continuous Deployment unterstützt, um Code-Änderungen schnell und zuverlässig bereitzustellen.|
| Caching                         |   Ein Mechanismus zur Zwischenspeicherung von Daten, um die Zugriffszeiten zu verkürzen und die Leistung zu verbessern. |
| JUnit                           | Ein Framework zum Erstellen und Ausführen von Unit-Tests in Java, das die Überprüfung der einzelnen Komponenten einer Anwendung ermöglicht.|
| Artillery                       | Ein Test-Tool zur Durchführung von Last- und Performance-Tests, um die Belastbarkeit und Leistung einer Anwendung zu überprüfen.|
| ArchUnit                        | Ein Test-Framework zur Überprüfung der Einhaltung von Architekturregeln in Java-Code.|
| Playwright                      | Ein End-to-End-Testframework, das browserübergreifende Tests ermöglicht, um die Funktionalität von Webanwendungen sicherzustellen. |
| Docker                          | Eine Plattform zur Containerisierung von Anwendungen, die eine konsistente Laufzeitumgebung bietet und das Deployment vereinfacht. |
| Docker-Compose                  | Ein Tool zum Definieren und Verwalten von Multi-Container-Docker-Anwendungen, das eine einfache Orchestrierung der Services ermöglicht.|
| Unit-Test                       | Ein Test, der die kleinsten Testbaren Teile einer Anwendung, wie einzelne Funktionen oder Methoden, isoliert prüft.|
| Integrationstest                | Ein Test, der das Zusammenspiel mehrerer Komponenten einer Anwendung überprüft, um sicherzustellen, dass sie korrekt zusammenarbeiten.|
| End-to-End-Test                 | Ein Test, der die gesamte Anwendung von Anfang bis Ende prüft, um sicherzustellen, dass alle Teile des Systems zusammen funktionieren.|
| Statische Code Analyse          | Eine Methode zur Analyse des Quellcodes ohne dessen Ausführung, um potenzielle Fehler und Schwachstellen frühzeitig zu erkennen. |
| Fallback-Mechanismus            | Ein Prozess, der sicherstellt, dass eine Anwendung weiterhin funktioniert, selbst wenn ein Teil des Systems ausfällt, indem alternative Wege genutzt werden.|
| Lasttest                        | Ein Test, der die Performance einer Anwendung unter hoher Belastung prüft, um sicherzustellen, dass sie unter extremen Bedingungen stabil bleibt.|
| Polygon API                     | Ein Dienst, der Echtzeit- und historische Marktdaten für Finanzanwendungen bereitstellt.|






