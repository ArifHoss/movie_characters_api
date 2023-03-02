# Start with a base image that includes Java and Maven
FROM maven:3.8.4-openjdk-17 AS build

# Copy the project files to the container
COPY . .

# Build the project using Maven
RUN mvn -f pom.xml clean package

# Use a smaller image for runtime
FROM openjdk:17

# Copy the built artifact from the previous stage
COPY --from=build target/movie_characters_api-0.0.1-SNAPSHOT.jar /

WORKDIR usr/src/movie_characters_api/
# Expose the default port used by the application
EXPOSE 8080

# Set the command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "movie_characters_api-0.0.1-SNAPSHOT.jar"]


#docker build -t movie-characters-api .
#docker run -p 8080:8080 movie-characters-api