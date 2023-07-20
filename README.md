# Mvc Practice Project

Login Page

## Description

This project is a simple web application demonstrating a login form using HTML, CSS, and Spring Boot with Spring Data JPA. Users can log in using their username and password, and if the credentials are valid, they are redirected to the admin panel. If the login fails, an error message is displayed on the login form.

## Technologies Used

- HTML
- CSS
- Spring Boot
- Spring Data JPA

## Installation

1. Clone the repository to your local machine.
2. Make sure you have Java (JDK) and Maven installed.
3. Build the project using Maven: `mvn clean install`.
4. Run the Spring Boot application: `mvn spring-boot:run`.
5. Access the application in your web browser at `http://localhost:8080`.

## Usage

1. Access the login form at `http://localhost:8080/users/login`.
2. Enter your username and password.
3. Click the "Login" button to submit the form.
4. If the credentials are correct, you will be redirected to the admin panel.
5. If the login fails, an error message will be displayed on the login form.

## Project Structure

- `src/main/java/com/user/mvc/controller`: Contains the Spring MVC controller for handling requests.
- `src/main/java/com/user/mvc/entity`: Contains the `UserDto` Data Transfer Object class.
- `src/main/java/com/user/mvc/entity`: Contains the `User` entity class.
- `src/main/java/com/user/mvc/repository`: Contains the `UserRepository` interface for data access.
- `src/main/java/com/user/mvc/service`: Contains the `UserService` class for business logic.
- `src/main/resources/templates`: Contains the HTML templates for views.
- `src/main/resources/static`: Contains the HTML static templates for views.

## Author

[Rafail Jabbarov](https://github.com/GoldenAkm)

