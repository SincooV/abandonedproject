
FROM openjdk:17-jdk-slim


RUN apt-get update && apt-get install -y postgresql


COPY build/libs/demo6-0.0.1-SNAPSHOT.jar /app/app.jar

COPY init-db.sh /init-db.sh

RUN chmod +x /init-db.sh

ENV POSTGRES_USER=myuser
ENV POSTGRES_PASSWORD=XzASrFDs@
ENV POSTGRES_DB=mydb

EXPOSE 8080

CMD ["/init-db.sh"]
