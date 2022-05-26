import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
public class CarmenTest {
    static ChromeDriver chromeDriver;
    static ChromeDriver chromeDriver2;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();

        chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.magnolia.ro/");


    }

    @AfterAll
    public static void tearDown() {
        chromeDriver.quit();

    }


    @Test
    public void firstTest() {

        WebElement loginButton =
                chromeDriver.findElement(By.cssSelector("#menuContainer > div > ul > li:nth-child(4) > a > i")); // asa gasim un element
        loginButton.click();
        waitSomeTime(2);

        WebElement emailInput =
                chromeDriver.findElement(By.cssSelector("#contact > div:nth-child(3) > input")); // asa gasim un element
        emailInput.sendKeys("carmen.hobinca@gmail.com");

        WebElement passwordInput =
                chromeDriver.findElement(By.cssSelector("#contact > div:nth-child(4) > input")); // asa gasim un element
        passwordInput.sendKeys("Magnolia30");
        WebElement loginButton2 =
                chromeDriver.findElement(By.cssSelector("#contact > div:nth-child(5) > button")); // asa gasim un element
        loginButton2.click();

        waitSomeTime(2);

    }



      @Test
      public void secondTest() {

          WebElement menuButton =
             chromeDriver.findElement(By.cssSelector("#whiteMenu > div > div > ul:nth-child(2) > li:nth-child(3) > div.bsd-open-subcat-content > a")); // asa gasim un element
          menuButton.click();
          waitSomeTime(3);

        List<WebElement> listaProduse =
              //  chromeDriver.findElements(By.className( "bsd-menu-desktop-cat-link")); found this initially, but did not give up and manage to find with css selector. yey!!!!!
          chromeDriver.findElements(By.cssSelector("div[class='bsd-menu home'] div[class='container'] div[class='bsd-menu-desktop'] ul[class='bsd-menu-desktop-cat'] li div[class='bsd-open-subcat-content']"));



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
           List<WebElement> listaProduse =
               chromeDriver.findElements(By.cssSelector("div[class='bsd-menu home'] div[class='container'] div[class='bsd-menu-desktop'] ul[class='bsd-menu-desktop-cat'] li div[class='bsd-open-subcat-content']"));

           for (WebElement webElement : listaProduse) {
             colorTheElementInRed(webElement);
             waitSomeTime(1);
             if (webElement.getText().equals("Buchete de flori")) {
               webElement.click();
               break;
             }
           }

           WebElement pageTitle = chromeDriver.findElement(By.cssSelector("#whiteMenu > div > div > ul:nth-child(2) > li:nth-child(1) > div > a > span"));
           Assertions.assertTrue(pageTitle.isDisplayed());
           Assertions.assertEquals("Flori de primăvară", pageTitle.getText());
           //Assertions.assertEquals("Flori de primavara", pageTitle.getText());

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
