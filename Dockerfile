# Use an official Maven image to build the application
FROM maven:3.9.3-eclipse-temurin-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the project files into the container
COPY pom.xml .
COPY src ./src

# Build the application and package it as a JAR file
RUN mvn clean package -DskipTests

# Use a lightweight JDK image to run the application
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/TPFinSessionGestionVelo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which the application will run
EXPOSE 8080

# Set the entry point to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
