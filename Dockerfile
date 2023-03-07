# Build stage
FROM maven:3.8.5-openjdk-17 AS build
COPY ./pom.xml /home/app/
RUN mvn -f /home/app/pom.xml verify clean  -DskipTests --fail-never
COPY src /home/app/src
RUN mvn clean package -DskipTests
#RUN mvn -f /home/app/pom.xml -DskipTests package

# Run stage
FROM openjdk:17
COPY ./target/movie_characters_api-0.0.1-SNAPSHOT.jar /usr/src/movie_characters_api/
WORKDIR /usr/src/movie_characters_api/
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app/movie_characters_api-0.0.1-SNAPSHOT.jar"]
