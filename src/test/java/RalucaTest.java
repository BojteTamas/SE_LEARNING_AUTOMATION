import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Objects;

public class RalucaTest {


    static ChromeDriver chromeDriver;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.get("https://testautomationu.applitools.com/");
    }

    @AfterAll
    public static void tearDown() {
        chromeDriver.quit();
    }

    @Test
    public void firstTest() {

        WebElement enrollbutton =
            chromeDriver.findElement(By.cssSelector("#app > div.theme-container.no-sidebar > header > div.links > div > div:nth-child(1) > div > a:nth-child(1)"));
        colorTheElementInRed(enrollbutton);
        waitSomeTime(1);
        enrollbutton.click();
        waitSomeTime(1);

        WebElement loginbutton =
            chromeDriver.findElement(By.cssSelector("#firebaseui-auth-container > div > div.firebaseui-card-content > form > ul > li:nth-child(2) > button > span.firebaseui-idp-text.firebaseui-idp-text-long"));
        colorTheElementInRed(loginbutton);
        waitSomeTime(1);
        loginbutton.click();
        waitSomeTime(1);
    }

    @Test
    public void secondTest() {

        WebElement emailInput =
                chromeDriver.findElement(By.cssSelector("#firebaseui-auth-container > div > form > div.firebaseui-card-content > div > div.firebaseui-textfield.mdl-textfield.mdl-js-textfield.mdl-textfield--floating-label.is-upgraded > input")); // input email
        colorTheElementInRed(emailInput);
        emailInput.sendKeys("raluca.ion@hotmail.com");
        waitSomeTime(2);

        WebElement nextbutton =
                chromeDriver.findElement(By.cssSelector("#firebaseui-auth-container > div > form > div.firebaseui-card-actions > div > button.firebaseui-id-submit.firebaseui-button.mdl-button.mdl-js-button.mdl-button--raised.mdl-button--colored"));
        colorTheElementInRed(nextbutton);
        nextbutton.click();
        waitSomeTime(1);

        WebElement passInput =
                chromeDriver.findElement(By.cssSelector("#firebaseui-auth-container > div > form > div.firebaseui-card-content > div:nth-child(3) > input"));
        colorTheElementInRed(passInput);
        passInput.sendKeys("Hell0There!");
        waitSomeTime(1);

        WebElement savebutton =
                chromeDriver.findElement(By.cssSelector("#firebaseui-auth-container > div > form > div.firebaseui-card-actions > div.firebaseui-form-actions > button"));
        colorTheElementInRed(savebutton);
        savebutton.click();
        waitSomeTime(1);


    }


    @Test
    public void thirdTest(){
       /** WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        **/
        //chromeDriver.get("https://testautomationu.applitools.com/");

       // chromeDriver.navigate().refresh();
        chromeDriver.get(chromeDriver.getCurrentUrl());
        waitSomeTime(6);

    }

    @Test
    public void forthTest(){
        WebElement profilebutton =
                chromeDriver.findElement(By.cssSelector("#app > div.theme-container.no-sidebar > header > div.links > div > div:nth-child(1) > div:nth-child(2) > a:nth-child(1)"));
        colorTheElementInRed(profilebutton);
        profilebutton.click();
        waitSomeTime(1);
    }






    private void waitSomeTime(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }

    public void colorTheElementInRed(final WebElement webElement) {

        chromeDriver.executeScript("arguments[0].style.border='3px solid red'", webElement);
    }

    public void colorTheElement(final WebElement webElement, String color) {

        chromeDriver.executeScript(
                String.format("arguments[0].style.border='3px solid %s'", color), webElement);
    }


}


