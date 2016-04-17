package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:8090");
        System.out.println(driver.getPageSource());
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        System.out.println("==");

        System.out.println(driver.getPageSource());
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();

        System.out.println("==");
        System.out.println(driver.getPageSource());

        element = driver.findElement(By.linkText("logout"));
        element.click();
        element = driver.findElement(By.linkText("login"));
        element.click();

        //epäonnistunut kirjautuminen: oikea käyttäjätunnus, väärä salasana
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("aep");
        element = driver.findElement(By.name("login"));
        element.submit();

        System.out.println("==");
        try {
            element = driver.findElement(By.linkText("logout"));
        } catch (NoSuchElementException e) {
            System.out.println("Success");
            element = null;
        }
        if (element != null) {
            System.out.println("Fail!!!");
            element.click();
            element = driver.findElement(By.linkText("login"));
            element.click();
        }

        //epäonnistunut kirjautuminen: ei-olemassaoleva käyttäjätunnus
        element = driver.findElement(By.name("username"));
        element.sendKeys("jukka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();

        try {
            element = driver.findElement(By.linkText("logout"));
        } catch (NoSuchElementException e) {
            System.out.println("Success");
            element = null;
        }
        if (element != null) {
            System.out.println("Fail!!!");
            element.click();
            element = driver.findElement(By.linkText("login"));
            element.click();
        }
        element = driver.findElement(By.linkText("back to home"));
        element.click();

        //uuden käyttäjätunnuksen luominen
        element = driver.findElement(By.linkText("register new user"));
        element.click();
        System.out.println(driver.getPageSource());

        element = driver.findElement(By.name("username"));
        element.sendKeys("jukka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akk1eptest");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akk1eptest");
        element = driver.findElement(By.name("add"));
        element.submit();

        //uuden käyttäjätunnuksen luomisen jälkeen tapahtuva ulkoskirjautuminen sovelluksesta
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        element = driver.findElement(By.linkText("logout"));
        element.click();
    }
}
