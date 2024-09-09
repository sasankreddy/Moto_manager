# Use a base image with OpenJDK
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/usermanager.jar /app/usermanager.jar

# Expose the port the app runs on
EXPOSE 8080

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/usermanager.jar"]
