FROM maven:3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-alpine
COPY --from=build /target/PGD-app-0.0.1-SNAPSHOT.jar PGD-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "PGD-app.jar"]