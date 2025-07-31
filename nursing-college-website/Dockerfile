# ===== STAGE 1: Build the application =====
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY nursing-college-website/pom.xml .
COPY nursing-college-website/src ./src
RUN mvn clean package -DskipTests



FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/nursing-college-website-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8282
CMD ["java", "-jar", "app.jar", "--spring.profiles.active=docker"]