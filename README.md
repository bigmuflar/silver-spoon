# Java Spring Boot/VueJS OpenNLP Quote

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

<img src="https://i.imgur.com/XBug3Sy.png"/>

<img src="https://i.imgur.com/i263QAT.png"/>

</p>