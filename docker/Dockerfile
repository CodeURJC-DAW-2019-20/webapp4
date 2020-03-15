FROM openjdk:8-alpine

COPY ./docker/urjcShare.jar ./urjcShare.jar

COPY ./src/main/resources/static/images ./src/main/resources/static/images

COPY ./src/main/resources/static/files_users ./src/main/resources/static/files_users

CMD ["java", "-jar", "urjcShare.jar"]
