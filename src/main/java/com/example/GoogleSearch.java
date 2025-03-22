package com.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import org.openqa.selenium.SessionNotCreatedException;
import java.time.Duration;
import java.io.IOException;

public class GoogleSearch {
    public static void main(String[] args) throws Exception {
        // Set desired capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("appPackage", "com.google.android.googlequicksearchbox");
        caps.setCapability("appActivity", "com.google.android.googlequicksearchbox.SearchActivity");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("noReset", true);

        // Initialize driver
        AndroidDriver driver = null;
        try {
            // Fallback: Explicitly launch the Google app activity using adb
            try {
                System.out.println("Launching Google app activity via adb...");
                ProcessBuilder pb = new ProcessBuilder("adb", "shell", "am", "start", "-n", "com.google.android.googlequicksearchbox/com.google.android.googlequicksearchbox.SearchActivity");
                Process process = pb.start();
                process.waitFor(); // Wait for the command to complete
                System.out.println("Google app activity launched.");
            } catch (IOException | InterruptedException e) {
                System.err.println("Failed to launch Google app via adb: " + e.getMessage());
            }

            // Connect to Appium
            URL appiumUrl = URI.create("http://127.0.0.1:4723").toURL();
            System.out.println("Connecting to Appium at: " + appiumUrl);
            driver = new AndroidDriver(appiumUrl, caps);
            System.out.println("Session created successfully");

            // Wait for the search bar (update ID after inspecting with Appium Inspector)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("com.google.android.googlequicksearchbox:id/googleapp_search_box") // Replace with actual ID
            )).sendKeys("Appium automation");

            // Press the Enter key to search
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));

            // Wait to observe the search results
            Thread.sleep(5000);

            // Close the session
            driver.quit();
        } catch (MalformedURLException e) {
            System.err.println("Invalid Appium URL: " + e.getMessage());
            throw e;
        } catch (SessionNotCreatedException e) {
            System.err.println("Appium session failed: " + e.getMessage());
            throw e;
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
