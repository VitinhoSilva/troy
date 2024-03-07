FROM ubuntu:latest AS build

RUN apt-get update && apt-get install -y \
    openjdk-21-jdk \
    wget \
    unzip

# Instalação do Gradle
WORKDIR /usr/local
RUN wget https://services.gradle.org/distributions/gradle-8.5-bin.zip
RUN unzip gradle-8.5-bin.zip
ENV GRADLE_HOME=/usr/local/gradle-8.5
ENV PATH=$PATH:$GRADLE_HOME/bin

WORKDIR /app
COPY build.gradle.kts settings.gradle.kts ./
COPY gradle ./gradle
COPY src ./src
RUN gradle build && ls /app/build/libs


FROM openjdk:21-jdk-slim

EXPOSE 8080

WORKDIR /app
COPY --from=build /app/build/libs/troy-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
