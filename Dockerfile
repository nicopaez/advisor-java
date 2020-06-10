FROM fabric8/java-alpine-openjdk8-jdk
WORKDIR /
COPY ./app.jar /deployments/app.jar
EXPOSE 8080
USER 405