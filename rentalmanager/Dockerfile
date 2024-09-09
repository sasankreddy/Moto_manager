# Use a base image with OpenJDK
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/rentalmanager.jar /app/rentalmanager.jar

# Expose the port the app runs on
EXPOSE 8081

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/rentalmanager.jar"]
