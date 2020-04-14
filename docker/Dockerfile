FROM openjdk:8-alpine

COPY ./backend/target/urjc_share-0.0.1-SNAPSHOT.jar ./urjcShare.jar

COPY ./images ./images

COPY ./files_users ./files_users

CMD ["java", "-jar", "urjcShare.jar"]
