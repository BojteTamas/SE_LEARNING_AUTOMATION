import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {
  static ChromeDriver chromeDriver;

  @BeforeAll
  public static void setup() {
    WebDriverManager.chromedriver().setup();
    chromeDriver = new ChromeDriver();
    chromeDriver.get("https://www.emag.ro/");
  }

  @AfterAll
  public static void tearDown() {
    chromeDriver.quit();
  }

  @Test
  public void firstTest() {

    waitSomeTime(3);

//    WebElement firstElement = chromeDriver.findElement(By.cssSelector("#main-container > div > section:nth-child(1) > div > div > div:nth-child(1) > a > span:nth-child(2)")); //asa gasim un element
//    colorTheElement(firstElement); //coloreaza
//    firstElement.click();//se da click

//    WebElement secondElement = chromeDriver.findElement(By.cssSelector("#searchboxTrigger")); //asa gasim un element
//    secondElement.sendKeys("cautam ceva");



    waitSomeTime(3);


  }

  public void colorTheElement(final WebElement webElement) {

    chromeDriver.executeScript("arguments[0].style.border='3px solid red'", webElement);
  }

  public void waitSomeTime(int seconds) {
    try {
      Thread.sleep(seconds * 1000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
