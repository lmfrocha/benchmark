FROM alpine:latest
MAINTAINER Lucas Rocha <lucas.marcelino@outlook.com>

# Expose Web Port
EXPOSE 8080

# Set environment
ENV JAVA_HOME /opt/jdk
ENV PATH ${PATH}:${JAVA_HOME}/bin
ENV JAVA_PACKAGE server-jre

ENV TOMCAT_VERSION_MAJOR 9
ENV TOMCAT_VERSION_FULL  9.0.27
ENV CATALINA_HOME /opt/tomcat

# Download and install Java
RUN apk --update add openjdk8-jre &&\
    mkdir -p /opt/jdk &&\
    ln -s /usr/lib/jvm/java-1.8-openjdk/bin /opt/jdk

#Install Glances
RUN apk add glances

# Download and install Tomcat
RUN apk add --update curl &&\
  curl -LO http://ftp.unicamp.br/pub/apache/tomcat/tomcat-9/v9.0.27/bin/apache-tomcat-9.0.27.tar.gz &&\
  gunzip -c apache-tomcat-${TOMCAT_VERSION_FULL}.tar.gz | tar -xf - -C /opt &&\
  rm -f apache-tomcat-9.0.27.tar.gz &&\
  ln -s /opt/apache-tomcat-${TOMCAT_VERSION_FULL} /opt/tomcat &&\
  rm -rf /opt/tomcat/webapps/examples /opt/tomcat/webapps/docs &&\
  apk del curl &&\
  rm -rf /var/cache/apk/*

# Launch Tomcat on startup
CMD ${CATALINA_HOME}/bin/catalina.sh run