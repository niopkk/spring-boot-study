FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD spring-boot-mybits-1.0-SNAPSHOT.jar spring-boot-mybits-1.0.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-boot-mybits-1.0.jar"]