

// package com.example;

// import io.appium.java_client.android.AndroidDriver;
// import io.appium.java_client.android.nativekey.AndroidKey;
// import io.appium.java_client.android.nativekey.KeyEvent;

// import org.openqa.selenium.By;
// import org.openqa.selenium.remote.DesiredCapabilities;
// import java.net.URI;
// import java.time.Duration;

// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.openqa.selenium.support.ui.ExpectedConditions;

// import com.google.common.collect.ImmutableMap;

// public class GoogleSearch {
//     public static void main(String[] args) throws Exception {
//         // Set desired capabilities
//         DesiredCapabilities caps = new DesiredCapabilities();
//         caps.setCapability("platformName", "Android");
//         caps.setCapability("deviceName", "emulator-5554"); // Check with `adb devices`
//         caps.setCapability("appPackage", "com.google.android.googlequicksearchbox");
//         caps.setCapability("appActivity", "com.google.android.googlequicksearchbox.SearchActivity");
//         caps.setCapability("automationName", "UiAutomator2");
//         caps.setCapability("noReset", true);

//         // Initialize driver with base URL
//         AndroidDriver driver = new AndroidDriver(URI.create("http://127.0.0.1:4723").toURL(), caps);
//         System.out.println("Session created successfully");

//         // Wait for Google app to load
//         Thread.sleep(5000);

//         // Open Google Search using ADB command (Optional if app launch fails)
//         driver.executeScript("mobile: shell", ImmutableMap.of("command", "am start -n com.google.android.googlequicksearchbox/com.google.android.googlequicksearchbox.SearchActivity"));
//         System.out.println("Google Search app opened");

//         // Wait for search bar to be visible
//         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//         By searchBox = By.id("com.google.android.googlequicksearchbox:id/googleapp_search_box");
//         wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).click();
        
//         // Enter a search query
//         driver.findElement(searchBox).sendKeys("Appium automation");

//         // Press Enter key to search
//         driver.pressKey(new KeyEvent(AndroidKey.ENTER));

//         // Wait to observe results
//         Thread.sleep(5000);

//         // Close the session
//         driver.quit();
//         System.out.println("Test completed successfully");
//     }
// }



// package com.example;

// import io.appium.java_client.android.AndroidDriver;
// import io.appium.java_client.android.nativekey.AndroidKey;
// import io.appium.java_client.android.nativekey.KeyEvent;
// import org.openqa.selenium.By;
// import org.openqa.selenium.remote.DesiredCapabilities;
// import java.net.MalformedURLException;
// import java.net.URI;
// import java.net.URL;
// import org.openqa.selenium.SessionNotCreatedException;

// public class GoogleSearch {
//     public static void main(String[] args) throws Exception {
//         // Set desired capabilities
//         DesiredCapabilities caps = new DesiredCapabilities();
//         caps.setCapability("platformName", "Android");
//         caps.setCapability("deviceName", "emulator-5554"); // Check with adb devices
//         caps.setCapability("appPackage", "com.google.android.googlequicksearchbox");
//         caps.setCapability("appActivity", "com.google.android.googlequicksearchbox.SearchActivity");
//         caps.setCapability("automationName", "UiAutomator2");
//         caps.setCapability("noReset", true);

//         // Initialize driver with base URL
//         try {
//             URL appiumUrl = URI.create("http://127.0.0.1:4723").toURL();
//             System.out.println("Connecting to Appium at: " + appiumUrl);
//             AndroidDriver driver = new AndroidDriver(appiumUrl, caps);
//             System.out.println("Session created successfully");

//             // Wait for Google app to load
//             Thread.sleep(5000);

//             // Find the search bar and enter a query
//             driver.findElement(By.id("com.google.android.googlequicksearchbox:id/googleapp_search_box")).sendKeys("Appium automation");

//             // Press the Enter key to search
//             driver.pressKey(new KeyEvent(AndroidKey.ENTER));

//             // Wait to observe the search results
//             Thread.sleep(5000);

//             // Close the session
//             driver.quit();
//         } catch (MalformedURLException e) {
//             System.err.println("Invalid Appium URL: " + e.getMessage());
//             throw e;
//         } catch (SessionNotCreatedException e) {
//             System.err.println("Appium session failed: " + e.getMessage());
//             throw e;
//         }
//     }
//}



// package com.example;

// import io.appium.java_client.android.AndroidDriver;
// import org.openqa.selenium.By;
// import org.openqa.selenium.remote.DesiredCapabilities;
// import java.net.URI;
// import java.net.URL;

// public class App {
//     public static void main(String[] args) throws Exception {
//         // Set desired capabilities using string literals
//         DesiredCapabilities caps = new DesiredCapabilities();
//         caps.setCapability("platformName", "Android");
//         caps.setCapability("deviceName", "emulator-5554"); // Check with `adb devices`
//         caps.setCapability("appPackage", "com.whatsapp");
//         caps.setCapability("appActivity", "com.whatsapp.Main");
//         caps.setCapability("automationName", "UiAutomator2");
//         caps.setCapability("noReset", true); // Avoid resetting app state

//         // Initialize driver with non-deprecated URL construction
//         URL appiumUrl = URI.create("http://127.0.0.1:4723/wd/hub").toURL();
//         AndroidDriver driver = new AndroidDriver(appiumUrl, caps);

//         // Wait for WhatsApp to load
//         Thread.sleep(5000);

//         // Click the "New Chat" button (FAB)
//         driver.findElement(By.id("com.whatsapp:id/fab")).click();

//         // Search for a contact (replace with your test contact name)
//         driver.findElement(By.id("com.whatsapp:id/search_input")).sendKeys("Test Contact");
//         Thread.sleep(2000);

//         // Select the first contact from the list
//         driver.findElement(By.xpath("//android.widget.TextView[@text='Test Contact']")).click();

//         // Type and send a message
//         driver.findElement(By.id("com.whatsapp:id/entry")).sendKeys("Hello from Appium!");
//         driver.findElement(By.id("com.whatsapp:id/send")).click();

//         // Wait to observe the result
//         Thread.sleep(3000);

//         // Close the session
//         driver.quit();
//     }
// }

// package com.example;

// import io.appium.java_client.android.AndroidDriver;
// import org.openqa.selenium.By;
// import org.openqa.selenium.remote.DesiredCapabilities;
// import java.net.URI;
// import java.net.URL;

// public class App {
//     public static void main(String[] args) throws Exception {
//         // Set desired capabilities for Spotify
//         DesiredCapabilities caps = new DesiredCapabilities();
//         caps.setCapability("platformName", "Android");
//         caps.setCapability("deviceName", "emulator-5554"); // Check with `adb devices`
//         caps.setCapability("appPackage", "com.spotify.music");
//         caps.setCapability("appActivity", "com.spotify.music.MainActivity");
//         caps.setCapability("automationName", "UiAutomator2");
//         caps.setCapability("noReset", true); // Avoid resetting app state

//         // Initialize driver
//         URL appiumUrl = URI.create("http://127.0.0.1:4723/wd/hub").toURL();
//         AndroidDriver driver = new AndroidDriver(appiumUrl, caps);

//         // Wait for Spotify to load
//         Thread.sleep(5000);

//         // Click the Search tab (bottom navigation bar)
//         driver.findElement(By.id("com.spotify.music:id/search_tab")).click();

//         // Wait for the search screen to load
//         Thread.sleep(2000);

//         // Find the search input field and enter a song name
//         driver.findElement(By.id("com.spotify.music:id/query_text")).sendKeys("Shape of You");

//         // Wait for search results
//         Thread.sleep(2000);

//         // Optional: Click the first song result (assumes it’s a TextView with the song title)
//         driver.findElement(By.xpath("//android.widget.TextView[@text='Shape of You']")).click();

//         // Wait to observe the result (song should start playing)
//         Thread.sleep(5000);

//         // Close the session
//         driver.quit();
//     }
// }