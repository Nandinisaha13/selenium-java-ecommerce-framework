# Selenium Java E-Commerce Automation Framework

This project is a **Selenium WebDriver automation framework built using Java, TestNG, and Maven** to automate end-to-end test scenarios for a sample e-commerce application.

The framework demonstrates **industry-standard automation practices** such as Page Object Model design, modular test structure, and maintainable test architecture.

The application under test is **SauceDemo**, a widely used demo platform for automation practice.

---

# Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* WebDriverManager
* Git & GitHub

---

# Project Structure

src/test/java/com/nandini/automation

base
    BaseTest.java

pages
    LoginPage.java

tests
    LoginTest.java

utils

---

# Framework Components

### BaseTest

Responsible for:

* WebDriver initialization
* Browser setup
* Opening the application URL
* Test teardown after execution

### Page Object Classes

Each page of the application is represented by a **Page Object Class** which contains:

* Web element locators
* Page actions

Example:
LoginPage.java

### Test Classes

Contain the actual test logic and assertions.

Example:
LoginTest.java

---

# Design Pattern Used

### Page Object Model (POM)

Page Object Model improves:

* Code reusability
* Maintainability
* Readability of test scripts

Each webpage is represented as a class containing the elements and methods related to that page.

---

# How to Run the Tests

Clone the repository:

git clone https://github.com/nandinisaha13/selenium-java-ecommerce-framework.git

Navigate to the project folder and run:

mvn test

This will execute the TestNG test suite and launch the browser.

---

# Future Enhancements

* Add Cart and Checkout automation
* Data-Driven Testing using Excel
* Test Reporting using Extent Reports
* CI/CD integration using Jenkins or GitHub Actions
* Cross-browser execution

---

# Author

Nandini Saha
Senior QA Engineer | Automation Enthusiast
