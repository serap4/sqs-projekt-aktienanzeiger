# Verwende ein Basis-Image mit Java
FROM openjdk:17-jdk-slim

# Installiere Maven
RUN apt-get update && apt-get install -y maven

# Setze das Arbeitsverzeichnis
WORKDIR /app

# Kopiere pom.xml und Maven Skript
COPY pom.xml ./

# Installiere Maven Abhängigkeiten und gehe offline
RUN mvn dependency:go-offline

# Kopiere den restlichen Code
COPY src ./src

# Baue das Projekt
RUN mvn package -DskipTests

# Setze das Arbeitsverzeichnis für die JAR-Ausführung
WORKDIR /app/target

# Exponiere den Port
EXPOSE 8080

# Startpunkt des Containers
CMD ["java", "-jar", "aktienanzeiger-0.0.1-SNAPSHOT.jar"]
