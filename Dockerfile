# -------- Stage 1: Build --------
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app

# Copy source code
COPY nursing-college-website/pom.xml .
COPY nursing-college-website/src ./src

# Build the JAR
RUN mvn clean package -DskipTests

# -------- Stage 2: Run --------
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy built JAR from previous stage
COPY --from=build /app/target/nursing-college-website-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8282
CMD ["java", "-jar", "app.jar", "--spring.profiles.active=docker"]
