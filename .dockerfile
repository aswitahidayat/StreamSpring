# Use the official Maven image to build the application
FROM maven:3.8.4-jdk-11 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

# Use the official OpenJDK image to create a runtime image
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/stream-with-spring-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
