FROM openjdk:18-alpine

ENV APP_HOME /usr/app

WORKDIR $APP_HOME

COPY target/user-service*.jar .

EXPOSE 8081

ENTRYPOINT ["sh", "-c", "java -jar user-service-1.0-SNAPSHOT.jar"]
