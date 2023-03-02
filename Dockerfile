FROM maven:3.8.5-openjdk-17-slim AS build
COPY src /home/app/src/
COPY pom.xml /home/app/
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:17
COPY --from=build /home/app/target/movie_characters_api-0.0.1-SNAPSHOT.jar /usr/src/movie_characters_api/
WORKDIR /usr/src/movie_characters_api/
EXPOSE 8088
ENTRYPOINT ["java", "-jar", "movie_characters_api-0.0.1-SNAPSHOT.jar"]
