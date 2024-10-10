# Use the official OpenJDK image as the base image
FROM openjdk:17-jdk-alpine
ARG JAR_FILE=build/*.jar
# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the host to the container
# COPY target/your-app-name.jar app.jar   # For Maven
COPY build/libs/mysql.jar app.jar

# Expose the port the application runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]