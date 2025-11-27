FROM maven:3.9-eclipse-temurin-11 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY README.md .
RUN mvn -q -DskipTests package

FROM eclipse-temurin:11-jre-alpine
WORKDIR /app
ENV APP_PORT=8080
COPY --from=build /app/target/desafio-poo-dio-api-0.1.0.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]

