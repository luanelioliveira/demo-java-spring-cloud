FROM openjdk:11

VOLUME /tmp

ADD ./target/hr-users-0.0.1-SNAPSHOT.jar hr-users.jar

ENTRYPOINT ["java","-jar","/hr-users.jar"]