package com.my.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App 
{
    public static void main( String[] args )
    {
        // Initialize the Firefox Browser
        WebDriver driver = new FirefoxDriver();

        try {
            // Open the herokuapp login page
            driver.get("https://the-internet.herokuapp.com/login");

            // Locate the fields and button
            WebElement userNameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.cssSelector("button.radius"));

            // Send the credentials and click login
            userNameField.sendKeys("tomsmith");
            passwordField.sendKeys("SuperSecretPassword!");
            loginButton.click();

            // Verify the login was successful
            WebElement successMessage = driver.findElement(By.id("flash"));
            String messageText = successMessage.getText();

            if (messageText.contains("You logged into a secure area!")) {
                System.out.println("Test Passed: Login Successful!");
            } else {
                System.err.println("Test Failed: Couldn't login!");
            }
        } catch (Exception e) {
            System.out.println("An error occurred during the test: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
