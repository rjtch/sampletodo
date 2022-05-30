FROM openjdk:18-alpine

ENV APP_HOME /usr/app

WORKDIR $APP_HOME

COPY target/notification*.jar .

EXPOSE 8082

ENTRYPOINT ["sh", "-c", "java -jar notification-1.0-SNAPSHOT.jar"]
