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
        chromeDriver.get("https://www.tvfanatic.com/");
    }

    @AfterAll
    public static void tearDown() {
        chromeDriver.quit();
    }

    @Test
    public void firstTest() {

        WebElement consentbutton =
                chromeDriver.findElement(By.cssSelector("body > div:nth-child(4) > div > div")); // consent form
        consentbutton.click();

        waitSomeTime(2);

        WebElement acceptconsent =
                chromeDriver.findElement(By.cssSelector("body > div:nth-child(4) > div > div > div.sc-crHmcD.fAEZdU > div > div.sc-pVTFL.kqpfpj")); // accept consent
        acceptconsent.click();

        waitSomeTime(2);

        WebElement accountbutton =
                chromeDriver.findElement(By.cssSelector("#navbar > div.navbar-header > div:nth-child(2) > button > i")); //account button
        accountbutton.click();
        waitSomeTime(2);



        WebElement loginButton =
                chromeDriver.findElement(By.cssSelector("#navbar > div.navbar-header > div.dropdown.navbar-button.open > ul > li > a")); // login button
        loginButton.click();

        waitSomeTime(2);

        WebElement emailInput =
                chromeDriver.findElement(By.cssSelector("#user_email")); // input email
        emailInput.sendKeys("ceva@ceva.com");

        waitSomeTime(2);

        WebElement passwInput =
                chromeDriver.findElement(By.cssSelector("#user_password")); // input password
        passwInput.sendKeys("ParolaMea");

        waitSomeTime(2);

        WebElement continueButton =
                chromeDriver.findElement(By.cssSelector("#new_user > div.panel-footer > div.pull-right > input")); // signIn button
        colorTheElementInRed(continueButton); // coloreaza
        waitSomeTime(2);
        continueButton.click();

        waitSomeTime(6);

    }

    @Test
    public void secondTest() {

        WebElement menubutton =
                chromeDriver.findElement(By.cssSelector("#navbar > div.navbar-header > button > i")); // menu button
        colorTheElementInRed(menubutton); //coloreaza
        waitSomeTime(2);
        menubutton.click();

        waitSomeTime(2);
        List<WebElement> listaProduse =
                chromeDriver.findElements(By.cssSelector("ul[class='nav navbar-nav'] li"));

        for (WebElement webElement : listaProduse) {
            colorTheElementInRed(webElement);
        }
        waitSomeTime(1);


        for (int i = 0; i < listaProduse.size(); i++) {
            colorTheElement(listaProduse.get(i), "blue");
            waitSomeTime(1);
        }
    }

    @Test
    public void thirdTest(){


        List<WebElement> listaProduse1 =
                chromeDriver.findElements(By.cssSelector("#footer > span > ul:nth-child(2) li"));

        for (WebElement webElement : listaProduse1) {
            colorTheElementInRed(webElement);
            if (webElement.getText().equals("The Resident")) {
                webElement.click();
                break;
            }
        }

        WebElement pageTiTle = chromeDriver.findElement(By.cssSelector("#show_banner > div.title > h1 > a"));
        Assertions.assertTrue(pageTiTle.isDisplayed());
        Assertions.assertEquals("Exclusives",pageTiTle.getText());


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


