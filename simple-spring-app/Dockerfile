FROM maven:3-eclipse-temurin-21-alpine AS maven

WORKDIR /build

COPY . .

RUN --mount=type=cache,target=/root/.m2 mvn -B clean package -am -DskipTests


FROM eclipse-temurin:21-jre-alpine AS simple-spring-app

ARG UID=10000
ARG GID=3000

WORKDIR /app

COPY --chmod=755 --from=maven /build/target/simple-spring-app-*.jar app.jar

USER ${UID}:${GID}

ENTRYPOINT ["java", "-jar", "app.jar"]