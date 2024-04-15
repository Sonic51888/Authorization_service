
FROM openjdk:8-jdk-alpine

EXPOSE 8080

COPY C:/Java/99Repositories/Authorizationservice/target/Authorizationservice-0.0.1-SNAPSHOT.jar  app.jar

CMD ["java", "-war", "app.war"]

