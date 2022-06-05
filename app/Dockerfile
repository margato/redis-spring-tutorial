FROM adoptopenjdk/openjdk11:alpine

ENV TZ=GMT-3
ARG JAR_FILE=target/*.jar

RUN mkdir app

COPY ${JAR_FILE} /app/redistutorial.jar

ENTRYPOINT ["java", "-jar", "./app/redistutorial.jar"]