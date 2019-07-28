FROM openjdk:8
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp


CMD ["java", "Main"]