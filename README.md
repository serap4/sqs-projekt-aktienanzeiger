# Aktienanzeiger

## Einführung und Ziele

Der Zweck der Aktienanzeiger-Webanwendung ist es, Benutzern täglich aktuelle Aktienkurse und umfassende Unternehmensinformationen wie den Marktwert bereitzustellen. Über eine benutzerfreundliche Weboberfläche können die Benutzer gezielt verschiedene Aktien auswählen und die relevanten Daten in einer übersichtlichen Tabelle anzeigen lassen. Zur Steigerung der Effizienz und Reduzierung der Antwortzeiten nutzt die Anwendung eine intelligente Caching-Strategie. Das Backend der Anwendung ist in Java unter Verwendung des Spring Boot Frameworks entwickelt, was eine robuste und skalierbare Backend-Architektur ermöglicht. Das Frontend basiert auf React, einer modernen JavaScript-Bibliothek, die für eine dynamische und interaktive Benutzererfahrung sorgt. Als Datenbank wird Redis verwendet, bekannt für seine hohe Leistung und Fähigkeit, häufig abgefragte Daten zu cachen. Die benötigten Aktieninformationen und Marktdaten werden von der Polygon.io API (https://polygon.io) abgerufen und in der Redis-Datenbank zwischengespeichert, um wiederholte Anfragen effizient zu bearbeiten.

### Aufgabenstellung

Ziel dieser Aufgabe ist es, ein detailliertes und umfassendes Testkonzept für eine Softwareanwendung zu entwickeln und erfolgreich umzusetzen. Diese Softwareanwendung besteht aus mehreren Schichten und Komponenten, darunter ein benutzerfreundliches UI-Frontend, das eine intuitive und reaktionsschnelle Benutzeroberfläche bietet, sowie eine komplexe Business-Logik-Schicht, die die Kernlogik und Geschäftsprozesse der Anwendung verwaltet. Des Weiteren umfasst die Anwendung eine leistungsfähige Datenbank, die für die Speicherung und effiziente Abfrage großer Datenmengen verantwortlich ist, und die Integration mit verschiedenen Drittanbieter-Backends, die zusätzliche Funktionalitäten und Datenquellen bereitstellen. Jede dieser Komponenten muss gründlich getestet werden, um sicherzustellen, dass die gesamte Anwendung nahtlos und zuverlässig funktioniert.

![Assignment Details](https://github.com/serap4/sqs-projekt-aktienanzeiger/blob/master/Bilder/Assignment%20Details%20SQS2024.png)
### Qualitätsziele

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

### Konventionen

## Lösungsstrategie

## Bausteinsicht

### Ebene 1

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
