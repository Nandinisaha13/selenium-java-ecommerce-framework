# 🧪 Selenium Java E-Commerce Automation Framework

A scalable and maintainable Selenium automation framework built using Java, TestNG, and Page Object Model (POM) design. This project demonstrates real-world QA automation practices including data-driven testing, dynamic locators, and reporting.

---

## 🚀 Tech Stack

* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **Test Framework:** TestNG
* **Build Tool:** Maven
* **Reporting:** ExtentReports
* **Data Handling:** Apache POI (Excel)
* **Utilities:** Apache Commons IO

---

## 🏗️ Framework Architecture

```
TestNG
   ↓
Test Classes
   ↓
Page Object Model (POM)
   ↓
Utility Classes (Waits, Config, Excel, Screenshot)
   ↓
Selenium WebDriver
   ↓
Browser
```

---

## ✨ Features Implemented

### ✅ Core Framework

* Page Object Model (POM) for maintainability
* TestNG for test execution and assertions
* Maven for dependency management

### ✅ Data-Driven Testing

* Excel-based test data using Apache POI
* TestNG DataProvider integration
* Supports multiple user scenarios dynamically

### ✅ Dynamic Locator Strategy

* Product selection using dynamic ID generation
* Scalable design for handling multiple products
* Reduced hardcoding of locators

### ✅ Wait Handling

* Explicit waits using WebDriverWait
* Centralized WaitUtils class
* Improved test stability and reduced flakiness

### ✅ Reporting & Debugging

* ExtentReports for HTML reporting
* Screenshot capture on test failure using TestNG Listeners
* Clear logging of pass/fail status

### ✅ Configuration Management

* External config.properties file
* Supports environment-based execution

---

## 🧪 Test Scenarios Covered

* Login with multiple users (Data-driven)
* Add product to cart
* Validate cart count
* Multiple test executions using DataProvider

---

## 📁 Project Structure

```
src
 ├── main
 └── test
     ├── java
     │   └── com.nandini.automation
     │       ├── base
     │       ├── pages
     │       ├── tests
     │       └── utils
     └── resources
         ├── testdata
         └── config.properties
```

---

## ▶️ How to Run

```bash
mvn clean test
```

Reports will be generated in:

```
/reports/test-report.html
```

---

## 📸 Reporting

* HTML report generated after execution
* Screenshots captured automatically on test failure
* Easy debugging with visual evidence

---

## ⚠️ Known Improvements (Planned Enhancements)

* Implement checkout flow automation
* Add parallel test execution (ThreadLocal WebDriver)
* Add CI/CD integration (GitHub Actions / Jenkins)
* Add API + UI combined testing
* Retry mechanism for flaky tests

---

## 💡 Key Learnings

* Handling dynamic web elements using locator strategies
* Designing scalable automation frameworks
* Avoiding stale element issues using By locators
* Improving reliability using explicit waits
* Building reusable utilities for real-world testing

---


## ⭐ Why This Project?

This project reflects real-world automation practices expected in QA roles, focusing on scalability, maintainability, and robustness rather than just basic Selenium scripting.

---
