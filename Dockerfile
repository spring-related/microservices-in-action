FROM openjdk:11-slim as build
MAINTAINER Saroj Kumar <kumarsaroj18@gmail.com>
ARG JAR_FILE
COPY target/licensing-service-0.0.1-SNAPSHOT.jar app.jar
RUN (mkdir -p target/dependency) && (cd target/dependency; jar xvf /app.jar)

FROM openjdk:11-slim
VOLUME /tmp
ARG DEPENDENCY=/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java", "-cp", "app:app/lib/*", "com.optimagrowth.license.LicenseServiceApplication"]
