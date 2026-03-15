# Selenium Java E-Commerce Test Automation Framework

## Overview

This project is a **Selenium WebDriver automation framework built using Java, TestNG, and Maven**.
It demonstrates industry-standard automation practices including **Page Object Model (POM), Data-Driven Testing using Excel, configuration management, and HTML reporting**.

The framework automates user journeys on the SauceDemo e-commerce testing website.

---

## Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* Apache POI (Excel Data Driven Testing)
* ExtentReports (HTML Test Reporting)

---

## Framework Design

The project follows the **Page Object Model (POM)** design pattern to keep the test code clean, reusable, and maintainable.

### Project Structure

```
src
 ├── main
 └── test
     ├── java/com/nandini/automation
     │    ├── base
     │    │     BaseTest.java
     │    │
     │    ├── pages
     │    │     LoginPage.java
     │    │     InventoryPage.java
     │    │     CartPage.java
     │    │
     │    ├── tests
     │    │     LoginTests.java
     │    │
     │    └── utils
     │          ConfigReader.java
     │          ExcelReader.java
     │          ExtentManager.java
     │          TestListener.java
     │
     └── resources
          ├── config.properties
          └── testdata
               loginData.xlsx
```

---

## Features Implemented

### Page Object Model

All UI actions are encapsulated inside page classes to separate test logic from UI interaction.

### Data-Driven Testing

Test data is read from Excel using Apache POI and executed using TestNG DataProvider.

Example test data:

```
username        password
standard_user   secret_sauce
problem_user    secret_sauce
```

### Configuration Management

Test configuration such as base URL and credentials are stored in:

```
config.properties
```

This allows easy switching between environments.

### HTML Test Reporting

The framework integrates **ExtentReports** to generate detailed HTML reports after execution.

Reports include:

* Test execution status
* Pass/Fail results
* Execution logs

Report location:

```
/reports/test-report.html
```

---

## Test Scenario Implemented

The automated test flow covers a basic e-commerce user journey:

1. Login to the application
2. Navigate to the inventory page
3. Add product to cart
4. Open cart
5. Verify product in cart

---

## Running the Tests

Clone the repository and run:

```
mvn clean test
```

The tests will execute using TestNG and generate an HTML report.

---

## Future Improvements

Planned enhancements for the framework:

* Screenshot capture on test failure
* Parallel test execution
* CI/CD integration (GitHub Actions / Jenkins)
* Docker container test execution
* Cross-browser testing
* Allure reporting integration

---

