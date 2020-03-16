#!/bin/bash
docker network create urjcShare-network 

docker container run --name mysqldb --network urjcShare-network -e MYSQL_ROOT_PASSWORD=pass -e MYSQL_DATABASE=urjc_share -d mysql:8

docker container run --network urjcShare-network --name urjcShare -p 8443:8443 -d davidtb10/urjcshare

docker container stop urjcShare
docker container stop mysqldb
