FROM ubuntu:latest
LABEL authors="joao kleber"
ARG JAR_FILE=target/*.jar
ENTRYPOINT ["top", "-b"]