package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookMyShowImgUrl {
    ChromeDriver driver;
    public BookMyShowImgUrl()
    {
        System.out.println("Constructor: BookMyShowImgUrl");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    public void endTest()
    {
        System.out.println("End Test: BookMyShowImgUrl");
        driver.close();
        driver.quit();

    }

    public  void testCase04() throws InterruptedException {
       driver.get("https://in.bookmyshow.com/explore/home/chennai");
        driver.findElement(By.xpath("(//div[contains(@class,'hxrBcw')])[1]")).click();
        Thread.sleep(2000);
        List<WebElement> recommendedMvs = driver.findElements(By.xpath("(//div[contains(@class,'hCzkOF')])[1]//img"));

        System.out.println(recommendedMvs.size());
               for(WebElement movie : recommendedMvs){

           String imgUrl = movie.getAttribute("src");
           System.out.println("Recommended Movie Image URL: " + imgUrl);
       }
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Uthami']"))));


       List<WebElement> premiumMvs = driver.findElements(By.xpath("//div[contains(@class, 'hgSytF')]/div/a"));
       System.out.println(premiumMvs.size());




    }
}
