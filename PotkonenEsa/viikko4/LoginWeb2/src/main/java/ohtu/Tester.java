package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {
    public static void main(String[] args) {
        Tester t = new Tester();
        t.login("pekka", "akkep");
        t.login("pekka", "akkepx");
        t.login("pekkax", "akkep");
        WebDriver driver = new HtmlUnitDriver();
        t.addUser(driver, "esaxxx", "12345asdfg");
        t.login("esaxxx", "12345asdfg");
        driver = new HtmlUnitDriver();
        t.addUser(driver, "esaxxxx", "12345asdfg");
        t.logout(driver);
    }
    private void login(String user, String passw) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys(user);
        element = driver.findElement(By.name("password"));
        element.sendKeys(passw);
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
        
    }
    private void addUser(WebDriver driver,String user, String passw) {
 
        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click(); 
        
        System.out.println("==Register");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys(user);
        element = driver.findElement(By.name("password"));
        element.sendKeys(passw);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passw);
        
        element = driver.findElement(By.name("add"));
        element.submit();
        
        System.out.println("==Add");
        System.out.println( driver.getPageSource() );
     
        element = driver.findElement(By.linkText("continue to application mainpage"));       
        element.click(); 

        System.out.println("==Continue");
        System.out.println( driver.getPageSource() );
    }
    private void logout(WebDriver driver) {
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("logout"));       
        element.click(); 
        System.out.println("==Logout");
        System.out.println( driver.getPageSource() );
    }
 }
