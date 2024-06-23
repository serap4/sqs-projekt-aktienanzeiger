FROM openjdk:17-jdk-slim
WORKDIR /app
COPY pom.xml ./
COPY mvnw ./
COPY .mvn .mvn
RUN chmod +x mvnw && ./mvnw dependency:go-offline -B
COPY src ./src
RUN ./mvnw package -DskipTests
WORKDIR /app/target
EXPOSE 8080
CMD ["java", "-jar", "aktienanzeiger-0.0.1-SNAPSHOT.jar"]
