# 프로젝트 Java 버전에 맞는 openjdk 이미지 설정
FROM openjdk:21-jdk-slim

# db Dependencies 설정
RUN apt-get update && apt-get install -y mariadb-client

# gradle 빌드를 하면 build/libs 하위에 *.jar 생성됨. 해당 '*.jar'를 'app.jar'로 cpoy
ARG JAR_FILE_PATH=build/libs/*.jar
COPY ${JAR_FILE_PATH} app.jar

# .yaml local/prod 프로필 분리 구조일때 실행할 프로필 지정 prod(=운영)
ENV USE_PROFILE prod

# 이미지 빌드 명령
ENTRYPOINT ["java", "-Dspring.profiles.active=${USE_PROFILE}", "-jar", "app.jar"]