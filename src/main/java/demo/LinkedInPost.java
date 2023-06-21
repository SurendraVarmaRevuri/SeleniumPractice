package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LinkedInPost {
    ChromeDriver driver;
    public LinkedInPost()
    {
        System.out.println("Constructor: LinkedInPost");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    public void endTest()
    {
        System.out.println("End Test: LinkedInPost");
        driver.close();
        driver.quit();

    }

    public  void testCase03(){
        System.out.println("Start Test case: testCase03");
        driver.get("https://in.linkedin.com/");
        //Click on Sign in
        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        //Enter User name
        driver.findElement(By.id("username")).sendKeys("varmarevuri@gmail.com");
        //Enter Password
        driver.findElement(By.id("password")).sendKeys("VARMA.143");
        //Click sign in button
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();

        //count of `Who's viewed your profile
        WebElement profileViewsElement = driver.findElement(By.xpath("(//span[@class='feed-identity-widget-item__stat']/strong)[1]"));
        System.out.println("Count of Who's viewed your profile: " +profileViewsElement.getText());


        //count of Impressions of your post
        WebElement impressionElement = driver.findElement(By.xpath("(//span[@class='feed-identity-widget-item__stat']/strong)[2]"));
        System.out.println("Count of Impressions of your post : " +impressionElement.getText());

        WebElement startPostBtn = driver.findElement(By.xpath("//a[@class='ember-view']/following-sibling::button"));
        startPostBtn.click();

        WebElement postShareSelection = driver.findElement(By.xpath("//span[text()='Surendra Revuri']"));
        postShareSelection.click();

        //Selecting connections only
        driver.findElement(By.xpath("//strong[text()='Connections only']")).click();
        //Select Done
        driver.findElement(By.xpath("//span[text()='Done']")).click();

        //Click image icon
//        driver.findElement(By.xpath("(//button[contains(@class,'share-promoted-detour-button')])[1]")).click();

        WebElement textToSend = driver.findElement(By.xpath("//div[@data-placeholder='What do you want to talk about?']"));
        textToSend.sendKeys("Hello, Everyone");

        //Click Post button
        driver.findElement(By.xpath("//span[text()='Post']")).click();












    }

}

