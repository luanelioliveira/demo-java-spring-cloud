FROM openjdk:11

VOLUME /tmp

EXPOSE 8765

ADD ./target/hr-gateway-server-0.0.1-SNAPSHOT.jar hr-gateway-server.jar

ENTRYPOINT ["java","-jar","/hr-gateway-server.jar"]