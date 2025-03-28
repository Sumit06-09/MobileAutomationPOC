# Mobile Automation Proof of Concept (PoC)

This project demonstrates mobile automation using **Appium**, **Java**, and **TestNG** on an Android emulator. The primary focus is automating a Google Search on the Google app, with an additional script for WhatsApp automation included for reference. The project includes scripts to launch apps, interact with UI elements, and validate results.

## Project Structure

- **src/main/java/com/example/**
  - `GoogleSearch.java`: Standalone script to automate a Google Search (types "Appium automation" and validates results).
  - `App.java`: Standalone script to automate WhatsApp (sends a message to a contact; currently not part of the test suite).
- **src/test/java/com/example/**
  - `AppTest.java`: TestNG test class that runs the Google Search automation with validation.
- **testng.xml**: TestNG configuration file to run the test suite.
- **pom.xml**: Maven configuration file with dependencies and plugins.

## Prerequisites

Before running the project, ensure the following are installed and configured:

1. **Java Development Kit (JDK)**:
   - Version: 22 (or compatible with your system).
   - Set `JAVA_HOME` environment variable to the JDK path (e.g., `C:\Program Files\Java\jdk-22`).
   - Add `JAVA_HOME\bin` to your PATH.

2. **Maven**:
   - Install Maven (e.g., via `choco install maven` on Windows or download from [Maven website](https://maven.apache.org/download.cgi)).
   - Verify: `mvn -version`.

3. **Android SDK**:
   - Install Android Studio or standalone Android SDK.
   - Set `ANDROID_HOME` environment variable (e.g., `C:\Users\pc\AppData\Local\Android\Sdk`).
   - Add `ANDROID_HOME\platform-tools` to your PATH.
   - Verify: `adb --version`.

4. **Appium**:
   - Install Appium globally via npm:  npm install -g appium
   - Install the `uiautomator2` driver:  appium driver install uiautomator2
   - Verify: `appium --version` (should be 2.17.1 or later).

5. **Android Emulator**:
- Create an emulator via Android Studio (AVD Manager) with API level 35 (Android 15).
- Emulator name: `emulator-5554` (or update `deviceName` in scripts if different).
- Ensure the Google app (`com.google.android.googlequicksearchbox`) is installed on the emulator.

6. **Appium Inspector** (Optional):
- Download from [GitHub](https://github.com/appium/appium-inspector/releases) to inspect UI elements.
- Used to find the `resource-id` for the Google app’s search bar.

## Setup Instructions

1. **Clone the Repository**:
- Clone or download this project to your local machine: git clone <repository-url>
cd whatsapp-automation


2. **Install Dependencies**:
- Run Maven to install dependencies defined in `pom.xml`:  mvn clean install


3. **Start the Emulator**:
- Launch your emulator:  emulator -avd emulator-5554
- Verify it’s running: adb devices


4. **Start Appium Server**:
- In a terminal, start Appium:  appium

- Ensure it runs on `http://127.0.0.1:4723`.

## Running the Tests

### Run the Test Suite (Google Search)
The primary test suite (`AppTest.java`) automates a Google Search and validates the results.

1. **Run Tests**:
- Execute the TestNG suite:  mvn test
- This uses `testng.xml` to run the Google Search test.

2. **Expected Output**:
- Terminal: Connecting to Appium at: http://127.0.0.1:4723
Session created successfully
Launching Google app activity via adb...
Google app activity launched.
[TestNG] Running:
GoogleSearchTests 

- Emulator: The Google app opens, types "Appium automation," searches, and shows results.
- Test passes if results contain "Appium".

### Run the Standalone Google Search Script
You can also run `GoogleSearch.java` directly without TestNG:

1. **Run the Script**:
- In VS Code: Right-click `GoogleSearch.java` > **Run Java**.
- Or in terminal:  mvn compile
mvn exec:java -Dexec.mainClass="com.example.GoogleSearch"


2. **Expected Output**:
- Terminal: Launching Google app activity via adb...
Google app activity launched.
Connecting to Appium at: http://127.0.0.1:4723
Session created successfully

- Emulator: Same behavior as the test suite.

### WhatsApp Automation (Optional)
The `App.java` script automates WhatsApp but is not part of the test suite. To run it:

1. **Run the Script**:
- In VS Code: Right-click `App.java` > **Run Java**.
- Or in terminal:  mvn compile
mvn exec:java -Dexec.mainClass="com.example.App"


2. **Expected Behavior**:
- Sends a message to "Test Contact" on WhatsApp (update the contact name to a real contact).

## Troubleshooting

- **Appium Connection Issues**:
- Ensure Appium is running on `http://127.0.0.1:4723`.
- Check port availability:  netstat -aon | findstr 4723

- If occupied, use a different port: `appium --port 4724` and update scripts.

- **Emulator Not Found**:
- Verify the emulator is running: `adb devices`.
- Update `deviceName` in scripts if different (e.g., `emulator-5556`).

- **NoSuchElementException**:
- If the search bar ID (`com.google.android.googlequicksearchbox:id/googleapp_search_box`) fails, use Appium Inspector to find the correct ID.
- Update the ID in `GoogleSearch.java` and `AppTest.java`.

- **ADB Command Fails**:
- Ensure `adb` is in your PATH: `adb --version`.
- Add `ANDROID_HOME\platform-tools` to PATH if missing.

- **Test Fails on Validation**:
- Adjust the result validation XPath in `AppTest.java`:
```java
By.xpath("//android.widget.TextView[contains(@text, 'Appium')]")

Inspect the results page with Appium Inspector for a better locator.

Project Details
Appium Version: 2.17.1
Java Version: 22
Android API Level: 35 (Android 15)
Emulator: emulator-5554 (Google Pixel emulator)
Dependencies:
io.appium:java-client:9.2.2
org.testng:testng:7.10.2
org.seleniumhq.selenium:selenium-java:4.25.0
Future Enhancements
Add more Google Search tests (e.g., click a specific result).
Reintegrate WhatsApp automation into the test suite.
Parameterize search queries via command-line arguments.
Add reporting with TestNG or Allure.#   M o b i l e A u t o m a t i o n P O C  
 