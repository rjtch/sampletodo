FROM openjdk:18-alpine

WORKDIR /usr/app

COPY target/user-service*.jar .

EXPOSE 8081

ENTRYPOINT ["sh", "-c", "java -jar user-service-1.0-SNAPSHOT.jar"]
