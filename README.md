# Spring Boot CRUD with Swagger UI
This is Spring Boot demo with CRUD(Create, Read, Update, Delete) operation with Swagger UI

# Procedure on adding Swagger:
	• Add Swagger dependency
		<dependency>
		   <groupId>io.springfox</groupId>
		   <artifactId>springfox-swagger2</artifactId>
		   <version>2.7.0</version>
		</dependency>
		<dependency>
		   <groupId>io.springfox</groupId>
		   <artifactId>springfox-swagger-ui</artifactId>
		   <version>2.7.0</version>
		</dependency>
		
	• Create package common/config and common/constant
  
	• Create Swagger2UiConfiguration class and add the following code:
	![image](https://user-images.githubusercontent.com/102574728/185037865-c5117224-5ac6-4ca0-b367-ba02247e0b43.png)

	• Add spring.mvc.pathmatch.matching-strategy=ant-path-matcher on application properties

