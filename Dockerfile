FROM fabric8/java-alpine-openjdk8-jdk
ARG JAR_FILE
COPY ${JAR_FILE} /deployments/app.jar
EXPOSE 8080
USER 405