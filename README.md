# Introduction
This is a basic Java EE project, created for learning purposes. We are using a Payara Micro Server to deploy our project to.

# Build
```
mvn package
```

# RUN
```
java -jar path/to/payara/payara-micro-5.183.jar --deploy path/to/project/root/target/hello-todo.war --port 8080
```
