FROM mcr.microsoft.com/openjdk/jdk:21-ubuntu

WORKDIR /demo

COPY /build/libs/Demo-0.0.1-SNAPSHOT.jar demo-app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar","demo-app.jar"]

