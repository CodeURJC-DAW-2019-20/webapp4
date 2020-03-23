FROM openjdk:8-alpine

COPY ./docker/urjcShare.jar ./urjcShare.jar

COPY ./images ./images

COPY ./files_users ./files_users

CMD ["java", "-jar", "urjcShare.jar"]
