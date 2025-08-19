FROM eclipse-temurin:23-jdk-alpine AS builder

WORKDIR /home/app

COPY mvnw .
COPY mvnw.cmd .
COPY .mvn .mvn
RUN chmod +x mvnw

COPY pom.xml .
RUN ./mvnw dependency:go-offline -B

COPY src ./src

RUN ./mvnw clean package -DskipTests

RUN mkdir -p /home/layer \
    && cd /home/layer \
    && cp /home/app/target/signing-simulator-*.jar ./app-signing-simulator.jar \
    && java -Djarmode=tools -jar app-signing-simulator.jar extract --layers --launcher



FROM eclipse-temurin:23-jre-alpine

WORKDIR /home/app


RUN addgroup -S spring  \
    && adduser -S spring-app -G spring  \
    && chown -R spring-app:spring /home/app
USER spring-app:spring

#RUN mkdir -p /home/app/src/main/resources/logs  \
#    && touch /home/app/src/main/resources/logs/signing-simulator.log

COPY --from=builder /home/layer/app-signing-simulator/dependencies .
COPY --from=builder /home/layer/app-signing-simulator/spring-boot-loader .
COPY --from=builder /home/layer/app-signing-simulator/snapshot-dependencies .
COPY --from=builder /home/layer/app-signing-simulator/application .


EXPOSE 8080


CMD ["java", "org.springframework.boot.loader.launch.JarLauncher"]