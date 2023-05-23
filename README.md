# Selenium Java AutomationExercise Project

This project is a Selenium automation script for practicing web automation on the AutomationExercise website (https://automationexercise.com/), using the Java programming language and following the Page Object Model (POM) design pattern. It utilizes the TestNG testing framework and Maven build tool for project management.


## Table of Contents
- [Project Overview](#project-overview)
- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)


## Project Overview
The AutomationExercise website provides a platform for practicing web automation using Selenium. This project demonstrates how to automate various tasks on the website using Selenium in Java and follows the Page Object Model design pattern. Each web page in the application has its corresponding Java class, which encapsulates the page's elements and related actions. Additionally, the project includes separate packages for different test scenarios, such as login, registration, and product-related tests.

The main purpose of this project is to provide a reference implementation of the Page Object Model (POM) design pattern for Selenium automation in Java. It showcases how to organize and structure your automation code using page classes, improving code maintainability, reusability, and readability. The test packages demonstrate how to write specific test scenarios for different functionality areas of the website.

## Requirements
To run this project, you need to have the following requirements installed on your system:
- Java Development Kit (JDK) (version 8 or higher)
- Selenium Java dependancy
- TestNG dependancy
- Maven build tool

## Installation
1. Clone the project repository to your local machine:
 git clone https://github.com/your-username/selenium-automationexercise.git
 
2. Import the project into your preferred Java IDE (e.g., Eclipse, IntelliJ IDEA).

3. Configure the Selenium Java in your project:
- Add the Selenium Java library to your project's classpath.


## Project Structure
The project structure is organized as follows:

- The `pages` directory contains the page classes corresponding to each web page in the AutomationExercise website. Each page class encapsulates the elements and actions related to a specific page.
- The `tests` directory contains separate packages for different test scenarios:
  - The `login_tests` package contains test scripts related to login functionality.
  - The `register_tests` package contains test scripts related to registration functionality.
  - The `products_tests` package contains test scripts related to product-related functionality.
- The `utils` directory contains utility classes, such as `WebDriverUtils.java`, which provides common methods and functions related to the WebDriver setup and configuration.


