FROM openjdk:16-alpine3.13
MAINTAINER aliarasio.github.io
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} ReadingIsGood.jar
ENTRYPOINT ["java","-jar","ReadingIsGood.jar"]