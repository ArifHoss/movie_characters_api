# Start with a base image that includes Java and Maven
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app

# Copy the project files to the container
COPY . .

# Build the project using Maven
RUN mvn clean install -DskipTests

# Use a smaller image for runtime
FROM openjdk:17-jdk-alpine3.14
WORKDIR /app

# Copy the built artifact from the previous stage
COPY --from=build /app/target/movie_characters_api-0.0.1-SNAPSHOT.jar .

# Expose the default port used by the application
EXPOSE 8080

# Set the command to run the application when the container starts
CMD ["java", "-jar", "movie_characters_api-0.0.1-SNAPSHOT.jar"]
