#!/bin/sh
cd `dirname $0`
cd ..

docker-compose down
VNAME=`docker volume ls -qf "name=vol-learning-java-db"`
docker volume rm $VNAME
