FROM openjdk:18-alpine

#WORKDIR /usr/app

COPY target/notification*.jar .

EXPOSE 8082

ENTRYPOINT ["sh", "-c", "java -jar notification-1.0-SNAPSHOT.jar"]
