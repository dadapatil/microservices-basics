# Use a lightweight OpenJDK base image
#FROM openjdk:17-jdk-alpine
# Eclipse Temurin (Adoptium) replacement
FROM eclipse-temurin:17-jdk-alpine

# Define an argument for the JAR file path
ARG JAR_FILE=target/*.jar

# Copy the application JAR into the container with the name 'app.jar'
COPY ${JAR_FILE} gateway-service.jar

# Define the command to run the application when the container starts
ENTRYPOINT ["java","-jar","/gateway-service.jar"]
EXPOSE 8060