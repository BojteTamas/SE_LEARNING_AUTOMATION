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







    /*
      @Test
      public void secondTest() {

          WebElement menuButton =
             chromeDriver.findElement(By.cssSelector("#whiteMenu > div > div > ul:nth-child(2) > li:nth-child(3) > div.bsd-open-subcat-content > a")); // asa gasim un element
          menuButton.click();
          waitSomeTime(2);

        List<WebElement> listaProduse =
          //  chromeDriver.findElements(By.cssSelector("#whiteMenu > div > div > ul:nth-child(2) > li:nth-child(3) > div.bsd-menu-desktop-subcat-content > div.bsd-menu-sub-links > ul > li:nth-child(1) > a"));
          chromeDriver.findElements(By.cssSelector("#whiteMenu > div > div > ul:nth-child(2)"));

        for (WebElement webElement : listaProduse) {
          colorTheElementInRed(webElement);
          waitSomeTime(1);
        }

        for (int i = 0; i < listaProduse.size(); i++) {
          colorTheElement(listaProduse.get(i), "blue");
          waitSomeTime(1);
        }
      }


     */
//here wanted to color each item from the menu but did not manage to find selector, same for 3rd test

/*
         @Test
         public void thirdTest() {
           List<WebElement> listaProduse =
               chromeDriver.findElements(By.cssSelector("ul[class='bsd-menu-desktop-cat'] li[class='bsd-open-subcat-content']"));

           for (WebElement webElement : listaProduse) {
             colorTheElementInRed(webElement);
             waitSomeTime(1);
             if (webElement.getText().equals("Buchete de flori")) {
               webElement.click();
               break;
             }
           }

           WebElement pageTitle = chromeDriver.findElement(By.cssSelector("ul[class='bsd-menu-desktop-cat'] li[class='bsd-open-subcat-content']"));
           Assertions.assertTrue(pageTitle.isDisplayed());
           Assertions.assertEquals("altele", pageTitle.getText());

         }





 */


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
