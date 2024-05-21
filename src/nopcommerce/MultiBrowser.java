package nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowser {
    static String browser = "Edge";
    static String baseUrl = "https://demo.nopcommerce.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        //1. Setup multi browser
        if (browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }else {
            System.out.println("You have enter wrong browser name");
        }

        //2. Open the URL into browser
        driver.get(baseUrl);

        //Maximise the browser window
        driver.manage().window().maximize();

        //We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3. Print the title of the page
        System.out.println("Main Title of the page is: " + driver.getTitle());

        //4. Print the current url.
        System.out.println("Current URL is: " + driver.getCurrentUrl());

        //5. Print the page source.
        System.out.println("This the Page source: " + driver.getPageSource());

        //6. Navigate to Url. “https://demo.nopcommerce.com/login?returnUrl=%2F”
        String navUrl ="https://demo.nopcommerce.com/login?returnUrl=%2F";
        driver.navigate().to(navUrl);

         //7. Print the current URL
        System.out.println("Current URL is: " + driver.getCurrentUrl());

        //8.Navigate back to the home page
        driver.navigate().back();

        //9.Navigate to the login page.
        driver.findElement(By.linkText("Log in")).click();

        //10. Print the current Url.
        System.out.println("Current URL is: " + driver.getCurrentUrl());

        //11.Refresh the page.
        driver.navigate().refresh();

        //12. Enter the email to email field.
        WebElement emilField = driver.findElement(By.id("Email"));
        emilField.sendKeys("admin@gmail.com");

        //13. Enter the password to password field.
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Admin@123");

        //14. Click on login button
        driver.findElement(By.className("login-button")).click();

        //15. Close the browser.
        driver.quit();

    }
}
