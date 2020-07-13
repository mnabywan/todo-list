FROM openjdk:11
ENV JAVA_HOME /usr/lib/jvm/java-1.11.0-openjdk-amd64
ENV PATH $PATH:/usr/lib/jvm/java-1.11.0-openjdk-amd64/jre/bin:/usr/lib/jvm/java-1.11.0-openjdk-amd64/bin

ENV SBT_VERSION 1.3.13

# Install curl
RUN \
  apt-get update && \
  apt-get -y install curl && \
  apt-get -y install vim

# Install sbt
RUN \
  curl -L -o sbt-$SBT_VERSION.deb https://dl.bintray.com/sbt/debian/sbt-$SBT_VERSION.deb && \
  dpkg -i sbt-$SBT_VERSION.deb && \
  rm sbt-$SBT_VERSION.deb && \
  apt-get update && \
  apt-get -y install sbt

WORKDIR /app
COPY . /app
RUN sbt update
EXPOSE 9000
ENTRYPOINT ["sbt", "run"]