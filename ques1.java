package cc1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ques1 {
	public static void main( String[] args ) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        String cartCount = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a/span")).getText();
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
        String product = "Sauce Labs Backpack";
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Dharanidharan");
        driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Senthilkumar");
        driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("637408");
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        System.out.println("Name of the product: " + driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div")).getText());
        System.out.println("Price of the product: " + driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]")).getText());
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title of the page is: " + actualTitle);
        } else {
            System.out.println("Title of the page is not as expected: " + actualTitle);
        }
        String expectedURL = "https://www.saucedemo.com/checkout-step-two.html";
        String actualURL = driver.getCurrentUrl();
        if (actualURL.equals(expectedURL)) {
            System.out.println("URL of the page is: " + actualURL);
        } else {
            System.out.println("URL of the page is not as expected: " + actualURL);
        }
    } 
}