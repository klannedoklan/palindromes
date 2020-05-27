palindromes overview:
This is a simple spring-boot application that finds all palindromes within an
input string and saves them in a H2 database using Hibernate.

1. Prerequisites:
 - java 1.8 or later
 - maven - https://maven.apache.org/

2. How to build and run locally:
 - clone this repository
 - from root directory run > mvn spring-boot:run
 - in your web browser navigate to http://localhost:8080/swagger-ui.html

3. Endpoints:
 - [GET] /getAll - List of all palindromes
    > for example: curl -X GET "http://localhost:8080/getAll" -H  "accept: */*"

 - [POST] /processPalindromes - Searches for all palindromes with size > 1 in a given string and saves them
    > for example: curl -X POST "http://localhost:8080/processPalindromes" -H  "accept: */*" -H  "Content-Type: application/json" -d "piuhwfgepiuohwiwuOOOpiuhwfgepiuohwiwu3244j2touih325ojn23nfkjpfeouinfeoi"