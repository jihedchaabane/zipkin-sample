FROM openjdk:21
WORKDIR /var/lib/jenkins/workspace/zipkin-sample--docker-create-images/jars
ADD target/gr-conf-zipkin-client-ms2-0.0.1-SNAPSHOT.jar gr-conf-zipkin-client-ms2.jar
COPY target/gr-conf-zipkin-client-ms2-0.0.1-SNAPSHOT.jar gr-conf-zipkin-client-ms2-0.0.1-SNAPSHOT.jar
EXPOSE 1112
ENTRYPOINT ["java", "-jar", "gr-conf-zipkin-client-ms2-0.0.1-SNAPSHOT.jar"]
