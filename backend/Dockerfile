# Verwende ein Basis-Image mit Java
FROM openjdk:17-jdk-slim

# Setze das Arbeitsverzeichnis
WORKDIR /app

# Kopiere pom.xml und Maven Wrapper Skript
COPY pom.xml ./
COPY mvnw ./
COPY .mvn .mvn

# Installiere Maven Wrapper und gehe offline
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
