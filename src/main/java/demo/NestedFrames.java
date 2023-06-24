package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class NestedFrames {
    ChromeDriver driver;
    public NestedFrames()
    {
        System.out.println("Constructor: NestedFrames");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    public void endTest()
    {
        System.out.println("End Test: NestedFrames");
        driver.close();
        driver.quit();

    }

    public  void testCase05(){
        System.out.println("Start Test case: testCase05");
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        //Switch into the top frame
        driver.switchTo().frame("frame-top");
        // switch into the left frame
        driver.switchTo().frame("frame-left");
        //locate the text inside the left and get the text
        String textInsideLeftFrame = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText();
        System.out.println("Text Inside the Left Frame : "+ textInsideLeftFrame);

        //Switch to Parent frame
        driver.switchTo().parentFrame();
        //Switch to Middle Frame
        driver.switchTo().frame("frame-middle");
        //locate the text inside the middle and get the text
        String textInsideMidFrame = driver.findElement(By.xpath("//div[text()='MIDDLE']")).getText();
        System.out.println("Text Inside the Middle Frame : "+ textInsideMidFrame);

        //Switch to Parent frame
        driver.switchTo().parentFrame();
        //Switch to Middle Frame
        driver.switchTo().frame("frame-right");
        String textInsideRytFrame = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]")).getText();
        System.out.println("Text Inside the Right Frame : "+ textInsideRytFrame);

        //Switch to default
        driver.switchTo().defaultContent();

        //Switch to Bottom frame
        driver.switchTo().frame("frame-bottom");
        String textInsideBottomFrame = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]")).getText();
        System.out.println("Text Inside the Bottom Frame : "+ textInsideBottomFrame);

        //Switch back to default content
        driver.switchTo().defaultContent();

    }
}
