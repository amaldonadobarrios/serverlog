# serverlog
demo servidor recibe logs



=================================================creacion de Docker MYSQL Server 5.7 y Database y Tabla
//descarga imagen de mysql:5.7
docker pull mysql

//crear contenedor con almacenamiento en el S.O. anfitrion 
C:\Users\31424836>docker run -p 3306:3306 --name mysql2020 -v C:\Users\31424836\Documents\docker_mysql:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=secret -d mysql:5.7 --character-set-server=utf8 --collation-server=utf8_unicode_ci
fede9f05df255c2dfc15a34a8b580a4e09d472d8f30e2cffb69c7d8a188d6162

conectarse al servidor docker mysql por consola
C:\Users\31424836>docker exec -it mysql2020 mysql -uroot -p
Enter password:
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 8
Server version: 8.0.22 MySQL Community Server - GPL

Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.

mysql> create database dblog
    -> ;
Query OK, 1 row affected (0.00 sec)

mysql> use dblog;
Database changed
mysql> CREATE TABLE LOG_VALUES( IDLOG INT NOT NULL AUTO_INCREMENT, MENSAJE VARCHAR(100) NOT NULL,PRIORIDAD VARCHAR(100) NOT NULL,PRIMARY KEY (IDLOG));
Query OK, 0 rows affected (0.05 sec)

============================================================= MICROSERVICIO ENCARGADO DE GUARDAR EL LOG ( pROYECTO SPRING BOOT - JPA  )===========================
@RestController
@RequestMapping(value="/log")
public class SendLog {
	
	@Autowired
	LogService service;
	
	
	@PostMapping(value="/send")
	public String guardarlog(@RequestBody final LogConfig log ){
  ================================================================= JSON DE PRUEBA=========================================================
  	{
        "logToFile": "true",
        "logToConsole": "true",
        "logMessage": "true",
        "logWarning": "true",
        "logError": "true",
        "logToDatabase": "true",
        "initialized": "true",
        "logFileFolder": "D:\\app",
        "messageText": "NO RESPONDE MICROSERVICIO LISTAR VENTAS",
        "warning": "true",
        "message": "false",
        "error": "true"
    }
