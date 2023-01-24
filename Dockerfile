FROM amazoncorretto:17-alpine-jdk

MAINTAINER SebastianSierra

COPY target/Final-0.0.1-SNAPSHOT.jar Final-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/Final-0.0.1-SNAPSHOT.jar"]