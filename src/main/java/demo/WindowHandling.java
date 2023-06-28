package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandling {
    ChromeDriver driver;
    public WindowHandling()
    {
        System.out.println("Constructor: WindowHandling");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: WindowHandling");
        driver.close();
        driver.quit();

    }


    public  void testCase07() throws IOException {
        System.out.println("Start Test case: testCase07");
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

        //switch to the frame
        driver.switchTo().frame("iframeResult");

        //Click on "Try it" button
        driver.findElement(By.xpath("//button[text()='Try it']")).click();

        String originalWindow = driver.getWindowHandle();

        Set<String> childWinds = driver.getWindowHandles();

        for(String eachWind : childWinds){
           if(!eachWind.equals(originalWindow)) {
               driver.switchTo().window(eachWind);

               //Get the URl
               String URL = driver.getCurrentUrl();
               System.out.println("Current Page URL : " + URL);

               //Print Title
               System.out.println("Title of the page  : " + driver.getTitle());


               File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
               File destinationFile = new File("screenshots/"+"screenshot.png");
               try {
                   FileUtils.copyFile(screenshotFile, destinationFile);
               } catch (IOException e) {
                   e.printStackTrace();
               }

               driver.close();

           }

           driver.switchTo().window(originalWindow);

           }
        }



    }

