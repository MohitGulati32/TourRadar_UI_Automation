FROM maven:3.8.6-jdk-11

WORKDIR /opt

COPY Config ./Config

COPY Driver ./Driver

COPY Reports ./Reports

COPY excel ./excel

COPY src ./src

COPY pom.xml .

COPY testng.xml .

RUN mvn -f pom.xml clean test -DskipTests=true