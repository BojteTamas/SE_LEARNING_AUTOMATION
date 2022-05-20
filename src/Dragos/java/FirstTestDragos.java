import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class FirstTestDragos {
  static ChromeDriver chromeDriver;

  @BeforeAll
  public static void setup() {
    WebDriverManager.chromedriver().setup();
    chromeDriver = new ChromeDriver();
    chromeDriver.get("https://www.evomag.ro/");
  }

  @AfterAll
  public static void tearDown() {
    chromeDriver.quit();
  }

  @Test
  public void firstTest() {

    WebElement loginButtonHover =
        chromeDriver.findElement(By.cssSelector("#personal_header > .account_header > .c_header")); // asa gasim un element
    WebElement loginButtonClick =
            chromeDriver.findElement(By.cssSelector(".BtnLoginHead"));
    Actions action = new Actions(chromeDriver);
    action.moveToElement(loginButtonHover).moveToElement(loginButtonClick).click().perform();
    waitSomeTime(2);

//aici am ramas
    WebElement emailInput =
        chromeDriver.findElement(By.cssSelector("#user_login_email")); // asa gasim un element
    emailInput.sendKeys("ceva@ceva.com");



    waitSomeTime(2);

    WebElement continueButton =
        chromeDriver.findElement(By.cssSelector("#user_login_continue")); // asa gasim un element
    colorTheElementInRed(continueButton); // coloreaza
    waitSomeTime(2);
    continueButton.click();

    waitSomeTime(6);
  }

  @Test
  public void secondTest() {
    List<WebElement> listaProduse =
        chromeDriver.findElements(By.cssSelector("ul[class='megamenu-list'] li[data-id]"));

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
        chromeDriver.findElements(By.cssSelector("ul[class='megamenu-list'] li[data-id]"));

    for (WebElement webElement : listaProduse) {
      colorTheElementInRed(webElement);
      waitSomeTime(1);
      if (webElement.getText().equals("Fashion")) {
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
