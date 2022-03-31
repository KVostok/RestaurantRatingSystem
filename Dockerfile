## Делаем образ на основе текущего проекта
## Version: 0.0.1
#FROM openjdk:16
#MAINTAINER Kane Bold <koboll1985@gmail.com>
#COPY target/*.war target/dependency/*.jar app/
#WORKDIR /app
#CMD java -DREST_ROOT="/app" -jar webapp-runner.jar *.war --port 8080
#EXPOSE 8080

# Загружаем готовый образ с dockerhub
# https://hub.docker.com/r/kvostok/restaurantsimage
# Version: 0.0.1
FROM kvostok/restaurantsimage:latest