## Requirements

First, it is necessary to have a database where there are two tables:


* Projects: record data from different blockchain aplications: id, name, url o address, description.
* Users: platform user list: id, username, password, token, rol.

To create a new database:

* Install docker: https://www.docker.com/products/docker-desktop

* Generate database:

````
docker run -d -p 3306:3306 --name FidesolBlockchain -e MYSQL_ROOT_PASSWORD=contraseña mysql:5.7 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
docker exec -it FidesolBlockchain mysql -uroot -p;
create database FidesolBlockchain;
````  
* Install Mysql Workbench: https://www.mysql.com/products/workbench/

* To access the database from Mysql it is neccesary execute:
*server -> data* import and add the .sql file.


## Execute

Run project