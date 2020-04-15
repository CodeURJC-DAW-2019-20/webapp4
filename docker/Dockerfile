FROM openjdk:8-alpine

COPY ./backend/target/urjc_share-0.0.1-SNAPSHOT.jar ./urjcShare.jar


RUN mkdir -p /images/users

RUN mkdir -p /files_users


CMD ["java", "-jar", "urjcShare.jar"]
