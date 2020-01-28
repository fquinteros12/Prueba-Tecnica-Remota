FROM openjdk:8u121-jre-alpine

MAINTAINER Francisco Quinteros "franciscoquinterosok@gmail.com"

WORKDIR /var/pruebatecnica-dropwizard
ADD target/pruebatecnica-dropwizard-1.0-SNAPSHOT.jar /var/pruebatecnica-dropwizard/pruebatecnica.jar

ADD config-docker.yml /var/pruebatecnica-dropwizard/config.yml


EXPOSE 9000 9001


ENTRYPOINT ["java", "-jar", "pruebatecnica.jar", "server", "config.yml"]