package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LinkedInImgPost {
    ChromeDriver driver;
    public LinkedInImgPost()
    {
        System.out.println("Constructor: LinkedInImgPost");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    public void endTest()
    {
        System.out.println("End Test: LinkedInImgPost");
        driver.close();
        driver.quit();

    }
    public  void testCase09() {

        System.out.println("Start Test case: testCase01");
        driver.get("https://www.linkedin.com/home");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement emailElement = driver.findElement(By.xpath("//input[@id='session_key']"));
        emailElement.sendKeys("varmarevuri53@gmail.com");
        WebElement passwordElement = driver.findElement(By.xpath("//input[@id='session_password']"));
        passwordElement.sendKeys("VARMA.143");
        WebElement signinButton = driver.findElement(By.xpath("//button[@data-id='sign-in-form__submit-btn']"));
        signinButton.click();
        WebElement photobutton = driver.findElement(By.xpath("//span[text()='Photo']"));
        photobutton.click();
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        String imagePath = "C:\\Users\\varma\\OneDrive\\Pictures\\exam.jpg";
        fileInput.sendKeys(imagePath);
        //Click done button
        driver.findElement(By.xpath("//span[text()='Done']")).click();
        //Click post
        driver.findElement(By.xpath("//span[text()='Post']")).click();
        System.out.println("end Test case: testCase02");

//        System.out.println("Start Test case: testCase09");
//        driver.get("https://in.linkedin.com/");
//        //Click on Sign in
//        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
//        //Enter User name
//        driver.findElement(By.id("username")).sendKeys("varmarevuri53@gmail.com");
//        //Enter Password
//        driver.findElement(By.id("password")).sendKeys("");
//        //Click sign in button
//        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
//
//        WebElement startPostBtn = driver.findElement(By.xpath("//a[@class='ember-view']/following-sibling::button"));
//        startPostBtn.click();
//         driver.findElement(By.xpath("(//button[contains(@class,'share-promoted-detour-button')])[1]")).click();
//        WebElement imgToSend = driver.findElement(By.xpath("//label[text()='Select images to share']"));
//        String filePath ="C:\\Users\\varma\\OneDrive\\Pictures\\exam.jpg";
//        imgToSend.sendKeys(filePath);

    }
}
