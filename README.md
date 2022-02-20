<h1 align='center'> <b>Java Spring Boot/VueJS OpenNLP Quote</b><br>
	<img src="https://img.shields.io/badge/Java-ED8B00?style=plastic&logo=java&logoColor=white">
	<img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=plastic&logo=spring&logoColor=white">
	<img src="https://img.shields.io/badge/Vue.js-35495E?style=plastic&logo=vue.js&logoColor=4FC08D">
	<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=plastic&logo=javascript&logoColor=black">
</h1>

A Java full stack application on a MySQL database using VueJS as the Front end Framework and Spring Boot as the Back end REST API.

There are 2 pages displayed on the Vue UI in this application. See details below regarding each page.

1. Main Page
	- This page is all Vue UI and used as a "welcome" page.
2. Quote Page
	- All quote data displayed on this page is generated on Java backend via Spring Data REST.
	- [OpenNLP](https://opennlp.apache.org/) is used to interpret quotes into sentence structures.

## Used technologies:
- Spring Boot
- Spring MVC
- Spring Data REST
- Hibernate
- MySQL
- FlywayDB
- Thymeleaf
- OpenNLP
- Vue.js 2.0 & Axios
- Bootstrap
- HTML / CSS

## To Install and Run Application:
Simply run the following command:
```
./mvnw spring-boot:run
```

## DB Structure:
The MySQL database can be implemented using Flyway along with the sql files available in resources -> db -> migration.  The database uses the below structure:

```
| Columns  | Data Type     |
| --------- | ------------- |
| quote_id  | init AI PK    |
| quote     | varchar(1000) |
| author    | varchar(50)   |
| book      | varchar(100)  |
```


## Screenshots of the application:
<p align="center">

<img src="https://i.imgur.com/966R9cf.png"/>

<img src="https://i.imgur.com/PR7E2h7.png"/>

</p>