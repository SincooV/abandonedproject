#!/bin/bash


service postgresql start


sleep 5





su - postgres -c "psql -c \"CREATE USER myuser WITH PASSWORD 'XzASrFDs@';\""
su - postgres -c "psql -c \"CREATE DATABASE mydb OWNER myuser;\""



java -jar /app/app.jar
