package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CountOfHyperLinks {
    ChromeDriver driver;
    public CountOfHyperLinks()
    {
        System.out.println("Constructor: CountOfHyperLinks");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    public void endTest()
    {
        System.out.println("End Test: CountOfHyperLinks");
        driver.close();
        driver.quit();

    }

    public  void testCase02(){
        System.out.println("Start Test case: testCase02");
        driver.get(" https://in.bookmyshow.com/explore/home/chennai");
        List<WebElement> allHyperLinks = driver.findElements(By.tagName("a"));
        int sizeOfHyperLinks = allHyperLinks.size();
        System.out.println("Count of Hyperlinks in Book My Show page : " +sizeOfHyperLinks);


        }

    }

