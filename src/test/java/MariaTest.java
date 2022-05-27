import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.w3c.dom.html.HTMLInputElement;

import java.util.List;

public class MariaTest {
    static ChromeDriver chromeDriver;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.w3schools.com/");
    }

    @AfterAll
    public static void tearDown() {
        chromeDriver.quit();
    }

    @Test
    public void firstTest() {

        WebElement popup = chromeDriver.findElement(
               By.cssSelector("#accept-choices"));
                 popup.click();

         WebElement loginButton = chromeDriver.findElement(
                        By.cssSelector("#w3loginbtn"));
        loginButton.click();

        waitSomeTime(2);

        WebElement emailInput =
                chromeDriver.findElement(By.cssSelector("#modalusername")); // asa gasim un element
        emailInput.sendKeys("maria_9267@yahoo.com");

        waitSomeTime(2);

        WebElement passwordInput =
                chromeDriver.findElement(By.cssSelector("#current-password")); // asa gasim un element
        passwordInput.sendKeys("Random123");

        waitSomeTime(2);

        WebElement continueButton =
                chromeDriver.findElement(By.cssSelector("#root > div > div > div:nth-child(4) > div.LoginModal_modal__1Yybs.LoginModal_show__F6L8A.LoginModal_full_page__PoJE0 > div > div.LoginModal_cta_bottom_box__wU1AF > div.LoginModal_cta_bottom_box_button_login__5Fbwv > button")); // asa gasim un element
        colorTheElementInRed(continueButton); // coloreaza
        waitSomeTime(2);
        continueButton.click();

        waitSomeTime(6);
    }

    @Test
    public void secondTest() {

        WebElement popup = chromeDriver.findElement(
                By.cssSelector("#accept-choices"));
        popup.click();

        WebElement tutorialButton = chromeDriver.findElement(
                By.cssSelector("#navbtn_tutorials"));
        tutorialButton.click();

        waitSomeTime(10);

        List<WebElement> listaProduse =
                chromeDriver.findElements(By.cssSelector("h3[class='w3-margin-top']"));

        for (WebElement webElement : listaProduse) {
            colorTheElementInRed(webElement);
            waitSomeTime(1);
        }

        for (int i = 0; i < listaProduse.size(); i++) {
            colorTheElement(listaProduse.get(i), "blue");
            waitSomeTime(1);
        }
    }

    @Test
    public void thirdTest() {
        WebElement popup = chromeDriver.findElement(
                By.cssSelector("#accept-choices"));
        popup.click();

        WebElement tutorialButton = chromeDriver.findElement(
                By.cssSelector("#navbtn_tutorials"));
        tutorialButton.click();

        waitSomeTime(5);

        List<WebElement> listaProduse =
                chromeDriver.findElements(By.cssSelector("h3[class='w3-margin-top']"));

        for (WebElement webElement : listaProduse) {
            colorTheElementInRed(webElement);
            waitSomeTime(1);
            if (webElement.getText().equals("Web Building")) {
                webElement.click();
                break;
            }
        }

        WebElement pageTitle = chromeDriver.findElement(By.cssSelector("h1[class='page-title']"));
        Assertions.assertTrue(pageTitle.isDisplayed());
        Assertions.assertEquals("Bacanie", pageTitle.getText());

    }

    public void colorTheElementInRed(final WebElement webElement) {

        chromeDriver.executeScript("arguments[0].style.border='3px solid red'", webElement);
    }

    public void colorTheElement(final WebElement webElement, String color) {

        chromeDriver.executeScript(
                String.format("arguments[0].style.border='3px solid %s'", color), webElement);
    }

    public void waitSomeTime(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

