
# Challenge automation framework

This is a Java-based automation framework for testing web applications using selenium and TestNG and RestAssured for api tests. It is built using Maven as a project management and build tool. This README file provides an overview of the framework, its features, and instructions for getting started.

## Features

- **Maven Project Structure:** The framework is structured as a Maven project, making it easy to manage dependencies and build the project.

- **TestNG Integration:** TestNG is used as the test framework, providing features like test parallelization, data-driven testing, and reporting.

- **WebDriverManager:** WebDriver is used for browser automation, allowing you to write tests for various web browsers. The automation framework handles the web driver configuration automatically

- **Selenium:** Selenium is used to do the UI web automation.

- **RestAssured:** Selenium is used to do the UI web automation.

- **Page Object Model (POM):** The framework follows the Page Object Model design pattern, promoting code reusability and maintainability.

- **Logging:** Logging is implemented using a logging framework (e.g., Log4j) to capture detailed test execution logs.

- **Reporting:** Test results are generated in HTML format using TestNG reports, making it easy to analyze test results.

- **Configuration Management:** Test configuration parameters (e.g., browser type, URLs) are managed in configuration files (e.g., properties files).

## Prerequisites

Before you begin using this framework, ensure that you have the following installed:

- Java Development Kit (JDK)
- Java 11
- Apache Maven(This is very important, take into consideration to check if you have it installed, newer OS version of mac don't have it installed by default, you will need to use homebrew to install maven)


## Getting Started

1. Clone this repository to your local machine:

   ```shell
   git clone https://github.com/fernando1496/qa-challenge-main.git

2. Open the project in Eclipse or intelliJ
3.  Wait for all the dependecies to be downloaded.

## Automation framework tests execution 
The structure of this automation framework support execution from shell scrips(maven) and individual test and classes execution.

1. To run full regression suite using a shell command in terminal you can use:

   ```shell
   mvn clean test
2. To generate and open tests results after execution you can use:
   ```shell
   allure serve allure-results

## CircleCI

In config.yml we have all the configurations, you can set it up in your own github repo and link it to circleCI