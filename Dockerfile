# Schritt 1: Verwende ein Basis-Image mit Maven und JDK 23
FROM maven:3.8-openjdk-23-slim AS build

# Schritt 2: Setze das Arbeitsverzeichnis im Container
WORKDIR /app

# Schritt 3: Kopiere die pom.xml und den Quellcode ins Container-Verzeichnis
COPY pom.xml .
COPY src ./src

# Schritt 4: Baue das Projekt mit Maven
RUN mvn clean package -DskipTests

# Schritt 5: Verwende ein OpenJDK 23-Image für den finalen Container
FROM openjdk:23-jre-slim

# Schritt 6: Kopiere das JAR-File aus dem Build-Container
COPY --from=build /app/target/*.jar /app/app.jar

# Schritt 7: Setze den Start-Befehl
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
