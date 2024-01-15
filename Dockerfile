
#download java
FROM openjdk:18-jdk-alpine

#mysql container name
#create dir
ARG APP_HOME=/opt/deployment
RUN mkdir $APP_HOME

#copy jar file from local to image
COPY build/libs/kubetest-0.0.1-SNAPSHOT.jar ${APP_HOME}/kubetest-0.0.1-SNAPSHOT.jar

#run the application
WORKDIR $APP_HOME
EXPOSE 8080
ENTRYPOINT ["java","-jar","-Ddb.url=${DB_URL}","-Ddb.username=${DB_USERNAME}","-Ddb.password=${DB_PASSWORD}","-Dspring.profiles.active=${ACTIVE_PROFILE}","kubetest-0.0.1-SNAPSHOT.jar"]


# docker run --netwrok=networkname -e DB_USERNAME=root -e DB_PASSWORD='bcmc1234' -e DB_URL='jdbc:mysql://containername:3306/DBname' -e ACTIVE_PROFILE=dev <image_name>