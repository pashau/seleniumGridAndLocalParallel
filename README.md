# Modern Selenium Parallel Framework 🚀

A Test Automation Framework built with **Java 21**, **Selenium 4**, and **JUnit 5**. This project serves as a blueprint for scalable UI testing, emphasizing stability, thread-safety, and modern architectural patterns.

## 🛠️ Tech Stack

- **Language:** Java 21 (LTS)
- **Test Framework:** JUnit 5.11 (Jupiter)
- **Automation Tool:** Selenium 4.23.0
- **Build Tool:** Apache Maven
- **Logging:** Log4j 2.24.1
- **Design Pattern:** Page Object Model (POM)
- **Execution:** Parallel Execution via JUnit Platform (Dynamic Strategy)

## ✨ Key Features

- **Automatic Driver Management:** Leverages **Selenium Manager** to eliminate the need for manual driver binaries (e.g., chromedriver.exe).
- **Thread-Safe Parallelism:** Uses a `ThreadLocalDriverFactory` to ensure complete isolation between parallel test threads, preventing session clashes.
- **Synchronization Stability:** Replaced implicit waits with **Explicit Waits** (`WebDriverWait`) to handle asynchronous UI elements and CSS animations reliably.
- **Current Dependency Stack:** All core libraries are kept up-to-date to ensure compatibility with the latest browser versions and security patches.
- **Generic Demo Workflow:** Configured to run against [SauceDemo](https://www.saucedemo.com/), showcasing a complete E2E flow (Login -> Dashboard -> Logout).

## 🚀 Quick Start

### Prerequisites
- **JDK 21** installed and `JAVA_HOME` configured.
- **Apache Maven** installed.
- A modern browser (Chrome or Firefox) installed.

### Running the Tests

1. **Run all tests in parallel:**
   ```bash
   mvn clean test
   ```

2. **Run a specific test class:**
   ```bash
   mvn test -Dtest=Login1_Test
   ```

## 📂 Project Structure

- `src/main/java/helper`: Core engine (Driver Factory, Constants, Configuration).
- `src/main/java/objects/pages`: Page Object Model implementation.
- `src/test/java/tests`: Test cases and BaseTest configuration.
- `src/test/java/suites`: Test suites for grouped execution.
- `src/test/resources`: Configuration files (`config.properties`, `junit-platform.properties`).

## ⚙️ Configuration

- **Parallelism:** Managed via `src/test/resources/junit-platform.properties` and the `@Suite` configuration.
- **Environment:** Defined in `src/test/resources/config.properties`.