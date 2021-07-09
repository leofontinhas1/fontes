FROM openjdk:11

ARG JAR_FILE=target/fontes-0.0.1-SNAPSHOT.jar

VOLUME /tmp
ENV JAVA_OPTS=""

ADD $JAR_FILE app.jar
ENTRYPOINT exec java $JAVA_OPTS -Duser.timezone=America/Sao_Paulo -jar /app.jar
EXPOSE 8080