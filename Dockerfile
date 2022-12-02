FROM openjdk:17
ADD target/tripsBackend.jar tripsBackend.jar
ENV DATABASEPORT 3306
ENTRYPOINT ["java","-DDatabasePort=${DATABASEPORT}","-jar","/tripsBackend.jar"]
