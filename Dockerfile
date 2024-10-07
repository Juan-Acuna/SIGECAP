 FROM eclipse-temurin:22.0.1_8-jdk-alpine

 RUN mkdir -p /home/app

 COPY ./target/sigecap-0.0.1-SNAPSHOT.jar /home/app/app.jar

 WORKDIR /home/app

 EXPOSE ${APP_PORT}

 CMD ["java","-jar","app.jar"]