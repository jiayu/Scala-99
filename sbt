#!/bin/bash

root=$(
  cd $(dirname $(readlink $0 || echo $0))/..
  /bin/pwd
)

sbtjar=sbt-launch.jar

function testjar()
{
    echo "3ccc8b4291f211517c898901b3190555c450f03cc0ad5d73f87c125ecb4e4413  $sbtjar" | shasum -a256 -c
    return $?
}

function downloadjar()
{
  echo 'downloading '$sbtjar 1>&2
  curl -O http://typesafe.artifactoryonline.com/typesafe/ivy-releases/org.scala-sbt/sbt-launch/0.13.0/$sbtjar
}

testjar || downloadjar

test -f ~/.sbtconfig && . ~/.sbtconfig

java -ea                          \
  $SBT_OPTS                       \
  $JAVA_OPTS                      \
  -Djava.net.preferIPv4Stack=true \
  -XX:+AggressiveOpts             \
  -XX:+UseParNewGC                \
  -XX:+UseConcMarkSweepGC         \
  -XX:+CMSParallelRemarkEnabled   \
  -XX:+CMSClassUnloadingEnabled   \
  -XX:MaxPermSize=1024m           \
  -XX:SurvivorRatio=128           \
  -XX:MaxTenuringThreshold=0      \
  -Xss8M                          \
  -Xms1G                          \
  -Xmx1G                          \
  -server                         \
  -jar $sbtjar "$@"
