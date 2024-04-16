
FROM amazoncorretto:17.0.10
WORKDIR /app

EXPOSE 8080

COPY ./target/Authorizationservice-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]

