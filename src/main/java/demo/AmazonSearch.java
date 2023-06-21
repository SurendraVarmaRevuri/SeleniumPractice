package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class AmazonSearch {
    ChromeDriver driver;
    public AmazonSearch()
    {
        System.out.println("Constructor: AmazonSearch");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    public void endTest()
    {
        System.out.println("End Test: Amazon Search");
        driver.close();
        driver.quit();

    }

    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
       WebElement searchBar = driver.findElement(By.name("q"));
       searchBar.sendKeys("Amazon");
       Actions actions = new Actions(driver);
       actions.sendKeys(Keys.ENTER).perform();
      WebElement amazonCom = driver.findElement(By.xpath("//h3[text()='Amazon.in']"));
      if(amazonCom.isDisplayed()){
          System.out.println("Amazon.Com is Visible");
      }

    }
}
