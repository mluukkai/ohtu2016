package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Main {
    
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        
        cantLoginWithInvalidPassword(driver);
        driver.get("http://localhost:8090");
        cantLoginWithNonExistingUsername(driver);
        driver.get("http://localhost:8090");
        creatingNewUserAndLoggingOut(driver);
        
    }
    
    public static void cantLoginWithInvalidPassword(WebDriver driver) {
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akke");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
    }
    
    public static void cantLoginWithNonExistingUsername(WebDriver driver) {
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekk");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
    }
    
    public static void creatingNewUserAndLoggingOut(WebDriver driver) {
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("johanna");
        element = driver.findElement(By.name("password"));
        element.sendKeys("johanna1");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("johanna1");
        element = driver.findElement(By.name("add"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
        
        element = driver.findElement(By.linkText("continue to application mainpage"));  
        element.click(); 
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
        
        element = driver.findElement(By.linkText("logout"));  
        element.click();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
    }
}
