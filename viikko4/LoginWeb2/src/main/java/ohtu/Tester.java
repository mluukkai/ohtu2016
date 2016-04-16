package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {
    static WebDriver driver;
    public static void main(String[] args) throws Exception {
        driver = new FirefoxDriver();
        Tester.logiWith("pekka", "akkep");
        Tester.assertElementExists(By.linkText("logout"), "Logout button");
        Tester.logiWith("pekka", "pass");
        Tester.assertElementExists(Tester.byText("wrong username or password"), "Invalid login text");
        Tester.logiWith("user", "akkep");
        Tester.assertElementExists(Tester.byText("wrong username or password"), "Invalid login text");
        Tester.registerUser("alonguser", "p@ssword");
        Tester.assertElementExists(Tester.byText("info for newbie"), "Info for newbies text.");
        
        WebElement element = driver.findElement(By.linkText("continue to application mainpage"));       
        element.click(); 
        Tester.assertElementExists(By.linkText("logout"), "Logout button");
        element = driver.findElement(By.linkText("logout"));       
        element.click(); 
        
        Tester.assertElementExists(Tester.byText("Ohtu App"), "Has logged out");
    }
        
    
    public static By byText(String text) {
        return By.xpath("//*[contains(text(), '" + text + "')]");
    }
    
    public static void logiWith(String username, String password) {
        driver.get("http://localhost:8090");
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();
    }
    public static void registerUser(String username, String pass) {
        Tester.registerUser(username, pass, pass);
    }
    public static void registerUser(String username, String pass1, String pass2) {
        driver.get("http://localhost:8090");
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click(); 
        
        element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(pass1);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(pass2);
        element.submit();
    }
    
    public static void assertElementExists(By by, String msg) throws Exception {
        if (driver.findElements(by).size() == 0) throw new Exception("Failed to find: " + msg);
    }
}
