FROM tomcat:9.0.27-jdk8-openjdk

MAINTAINER Lucas Rocha "lucas.marcelino@outlook.com"

COPY /home/lucas/DEV/mysql-connector-java-8.0.17.jar:/usr/local/tomcat/lib/mysql-connector-java-8.0.17.jar

COPY /home/lucas/DEV/mysql-connector-java-8.0.11.jar:/usr/local/tomcat/lib/mysql-connector-java-8.0.11.jar 

COPY /home/lucas/DEV/mysql-connector-java-5.1.34.jar:/usr/local/tomcat/lib/mysql-connector-java-5.1.34.jar

COPY /home/lucas/DEV/benchmark.war:/usr/local/tomcat/webapps/benchmark.war

CMD ["catalina.sh","run"]