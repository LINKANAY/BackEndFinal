FROM amazoncorretto:17-alpine-jdk

MAINTAINER SebastianSierra

COPY target/Final-0.0.1-SNAPSHOT.jar backendfinal-sebas.jar

ENTRYPOINT ["java","-jar","/backendfinal-sebas.jar"]