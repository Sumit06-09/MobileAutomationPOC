package com.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.io.IOException;

public class AppTest {
    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set desired capabilities for Google Search
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("appPackage", "com.google.android.googlequicksearchbox");
        caps.setCapability("appActivity", "com.google.android.googlequicksearchbox.SearchActivity");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("noReset", true);

        // Initialize driver
        URL appiumUrl = URI.create("http://127.0.0.1:4723").toURL();
        System.out.println("Connecting to Appium at: " + appiumUrl);
        driver = new AndroidDriver(appiumUrl, caps);
        System.out.println("Session created successfully");

        // Initialize wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testGoogleSearchAutomation() {
        // Launch Google app via adb
        try {
            System.out.println("Launching Google app activity via adb...");
            ProcessBuilder pb = new ProcessBuilder("adb", "shell", "am", "start", "-n", "com.google.android.googlequicksearchbox/com.google.android.googlequicksearchbox.SearchActivity");
            Process process = pb.start();
            process.waitFor();
            System.out.println("Google app activity launched.");
        } catch (IOException | InterruptedException e) {
            System.err.println("Failed to launch Google app via adb: " + e.getMessage());
        }

        // Wait for the search bar
        wait.until(ExpectedConditions.presenceOfElementLocated(
            By.id("com.google.android.googlequicksearchbox:id/googleapp_search_box")
        )).sendKeys("Appium automation");

        // Press the Enter key to search
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        // Validate search results
        String resultText = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//android.widget.TextView[contains(@text, 'Appium')]")
        )).getText();
        Assert.assertTrue(resultText.contains("Appium"), "Search results did not contain 'Appium'");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}