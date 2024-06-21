# Aktienanzeiger

## Einführung und Ziele

Der Zweck der Aktienanzeiger-Webanwendung ist es, Benutzern täglich aktuelle Aktienkurse und umfassende Unternehmensinformationen wie den Marktwert bereitzustellen. Über eine benutzerfreundliche Weboberfläche können die Benutzer gezielt verschiedene Aktien auswählen und die relevanten Daten in einer übersichtlichen Tabelle anzeigen lassen. Zur Steigerung der Effizienz und Reduzierung der Antwortzeiten nutzt die Anwendung eine intelligente Caching-Strategie. Das Backend der Anwendung ist in Java unter Verwendung des Spring Boot Frameworks entwickelt, was eine robuste und skalierbare Backend-Architektur ermöglicht. Das Frontend basiert auf React, einer modernen JavaScript-Bibliothek, die für eine dynamische und interaktive Benutzererfahrung sorgt. Als Datenbank wird Redis verwendet, bekannt für seine hohe Leistung und Fähigkeit, häufig abgefragte Daten zu cachen. Die benötigten Aktieninformationen und Marktdaten werden von der Polygon.io API (https://polygon.io) abgerufen und in der Redis-Datenbank zwischengespeichert, um wiederholte Anfragen effizient zu bearbeiten.

### Aufgabenstellung

Ziel dieser Aufgabe ist es, ein detailliertes und umfassendes Testkonzept für eine Softwareanwendung zu entwickeln und erfolgreich umzusetzen. Diese Softwareanwendung besteht aus mehreren Schichten und Komponenten, darunter ein benutzerfreundliches UI-Frontend, das eine intuitive und reaktionsschnelle Benutzeroberfläche bietet, sowie eine komplexe Business-Logik-Schicht, die die Kernlogik und Geschäftsprozesse der Anwendung verwaltet. Des Weiteren umfasst die Anwendung eine leistungsfähige Datenbank, die für die Speicherung und effiziente Abfrage großer Datenmengen verantwortlich ist, und die Integration mit verschiedenen Drittanbieter-Backends, die zusätzliche Funktionalitäten und Datenquellen bereitstellen. Jede dieser Komponenten muss gründlich getestet werden, um sicherzustellen, dass die gesamte Anwendung nahtlos und zuverlässig funktioniert.

![Assignment Details](https://github.com/serap4/sqs-projekt-aktienanzeiger/blob/master/Bilder/Assignment%20Details%20SQS2024.png)

### Qualitätsziele

| Qualitätskriterium | Beschreibung      | Ziele      | Maßnahmen       |
| -------------- | -------------- | -------------- | -------------- |
| Inhalt Zeile 1 | Inhalt Zeile 1 | Inhalt Zeile 1 | Inhalt Zeile 1 |
| Inhalt Zeile 2 | Inhalt Zeile 2 | Inhalt Zeile 2 | Inhalt Zeile 2 |
| Inhalt Zeile 3 | Inhalt Zeile 3 | Inhalt Zeile 3 | Inhalt Zeile 3 |
| Inhalt Zeile 4 | Inhalt Zeile 4 | Inhalt Zeile 4 | Inhalt Zeile 4 |

### Stakeholder

| Rolle                    | Kontakt                                | Erwartungshaltung                                   |
| ------------------------ | ---------------------------------------| --------------------------------------------------- |
| Prüfer                   | Mario-Leander Reimer (mario-leander.reimer@th-rosenheim.de)  | Es wird erwartet, dass das Softwareprogramm und dessen Qualität überzeugend sind, um eine gute Note zu vergeben.|
| Prüfer                   | Gerd Beneken (gerd.beneken@th-rosenheim.de)                  | Es wird erwartet, dass das Softwareprogramm und dessen Qualität überzeugend sind, um eine gute Note zu vergeben.|
| Stundent (Entwickler)    | Serap Kaya (serap.kaya@stud.th-rosenheim.de) | Es wird erwartet, dass die Architektur geplant, der Code entwickelt, die Tests geplant und durchgeführt sowie die Dokumentation erstellt wird. | 

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

### Technischer- oder Verteilungskontext

## Lösungsstrategie

Die grundlegende Entwurfsstrategie dieses Projekts basiert auf einer Reihe wesentlicher Technologieentscheidungen und Systemdesigns, die gezielt auf die spezifischen Anforderungen, Rahmenbedingungen und Qualitätsziele zugeschnitten sind. Diese strategischen Entscheidungen sind darauf ausgerichtet, die Anforderungen des Projekts optimal zu erfüllen und eine robuste, skalierbare und benutzerfreundliche Lösung zu gewährleisten.

### Technologieentscheidungen

-	**Backend:** Das Backend wird in Java mit Spring Boot entwickelt, was eine robuste und skalierbare Architektur ermöglicht. Diese Entscheidung beruht auf der Stabilität und Flexibilität, die Spring Boot bietet, sowie der breiten Unterstützung in der Entwicklergemeinschaft.
  
- **Frontend:** Das Frontend wird mit React umgesetzt. Diese JavaScript-Bibliothek wurde aufgrund ihrer Fähigkeit gewählt, dynamische und interaktive Benutzeroberflächen zu erstellen. React ermöglicht eine modulare und wiederverwendbare Komponentenarchitektur, die eine hohe Performance durch virtuelle DOM (=Document Object Model)-Funktionen bietet.  

- **Datenbank:** Redis wird als In-Memory-Datenbank eingesetzt, die für ihre hohe Leistung und Skalierbarkeit bekannt ist. Diese Entscheidung unterstützt die schnelle Datenverarbeitung und effizientes Caching, was die Antwortzeiten reduziert.
  
- **Externe API:** Die benötigten Aktieninformationen werden von der Polygon.io API abgerufen, die umfassende und aktuelle Marktdaten bereitstellt.

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
![Whitebox Gesamtsystem](https://github.com/serap4/sqs-projekt-aktienanzeiger/blob/master/Bilder/Whitebox%20Gesamtbox.PNG)

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
