FROM openjdk:8-jdk-alpine
MAINTAINER sandilembatha89@gmail.com
VOLUME /tmp
ADD target/report-ms-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar
EXPOSE 9001