FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/nursing-college-website-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8282
CMD ["java", "-jar", "app.jar", "--spring.profiles.active=docker"]