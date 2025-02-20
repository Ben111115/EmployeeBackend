# Schritt 1: Verwende ein Basis-Image mit OpenJDK 17
FROM openjdk:17-slim AS build

# Schritt 2: Installiere Maven im Container
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Schritt 3: Setze das Arbeitsverzeichnis im Container
WORKDIR /app

# Schritt 4: Kopiere die pom.xml und den Quellcode ins Container-Verzeichnis
COPY pom.xml .
COPY src ./src

# Schritt 5: Baue das Projekt mit Maven
RUN mvn clean package -DskipTests

# Schritt 6: Verwende das OpenJDK 17-Image für den finalen Container
FROM openjdk:17-jre-slim

# Schritt 7: Kopiere das JAR-File aus dem Build-Container
COPY --from=build /app/target/*.jar /app/app.jar

# Schritt 8: Setze den Start-Befehl
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
