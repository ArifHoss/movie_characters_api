FROM maven:3.8.4-openjdk-17-slim AS maven
WORKDIR /app
COPY . .
RUN mvn clean package

FROM openjdk:17 AS runtime
WORKDIR /app

ENV SPRING_PROFILE "prod"
ENV DDL_AUTO "none"
ENV INIT_MODE "always"
ENV SHOW_JPA_SQL "false"

COPY --from=maven /app/target/movie_characters_api-0.0.1-SNAPSHOT.jar /app/app.jar
RUN chown -R 1000:1000 /app
USER 1000:1000
ENTRYPOINT ["java", "-jar", "movie_characters_api-0.0.1-SNAPSHOT.jar"]
