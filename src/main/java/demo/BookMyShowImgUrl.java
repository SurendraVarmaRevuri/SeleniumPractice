package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
       for(WebElement movie : recommendedMvs){

           String imgUrl = movie.getAttribute("src");
           System.out.println("Recommended Movie Image URL: " + imgUrl);

       }
       Thread.sleep(2000);

       List<WebElement> primerMvs = driver.findElements(By.xpath("(//div[contains(@class,'iVNURo')])[3]//img"));
       System.out.println(primerMvs.size());


    }
}
