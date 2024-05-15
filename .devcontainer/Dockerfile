FROM hseeberger/scala-sbt:8u222_1.3.5_2.12.10

WORKDIR /workspace

COPY . /workspace

RUN echo "sbt.version=1.3.5" > project/build.properties

RUN sbt sbtVersion
