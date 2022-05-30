FROM openjdk:18-alpine

ENV APP_HOME /usr/app

WORKDIR $APP_HOME

COPY target/todo-service*.jar .

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java -jar todo-service-1.0-SNAPSHOT.jar"]
