package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Tester {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        element = driver.findElement(By.name("username"));
        element.sendKeys("matti");
        element = driver.findElement(By.name("password"));
        element.sendKeys("ittam1234");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("ittam1234");
        element = driver.findElement(By.name("add"));
        element.submit();
        /*WebElement element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();*/
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
        
    }
}
