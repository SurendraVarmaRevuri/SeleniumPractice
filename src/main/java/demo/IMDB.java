package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IMDB {
    ChromeDriver driver;
    public IMDB()
    {
        System.out.println("Constructor: IMDB");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: IMDB");
        driver.close();
        driver.quit();

    }


    public  void testCase06(){
       driver.get(" https://www.imdb.com/chart/top");
       // What is the highest rated movie on IMDb
        String  hrm = driver.findElement(By.xpath("((//td[contains(@class,'imdbRating')])[1]/preceding-sibling::td/a)[2]")).getText();
        System.out.println("Highest rated movie on IMDb :" +hrm);

        //How many movies are included in the table?
        List<WebElement> allMvs = driver.findElements(By.xpath("//td[@class='titleColumn']"));
        System.out.println("Count of all movies in IMDB : "+ allMvs.size());


        //What is the oldest movie on the list?
        WebElement oldestMovieElement = driver.findElement(By.xpath("(//td[@class='titleColumn'])[last()]/a"));
        String oldestMovieTitle = oldestMovieElement.getText().trim();
        System.out.println("Oldest movie on the list: " + oldestMovieTitle);

        //What is the most recent movie on the list?
        WebElement recentMovieElement = driver.findElement(By.xpath("(//td[@class='titleColumn'])[1]/a"));
        String recentMovieTitle = recentMovieElement.getText().trim();
        System.out.println("Most recent movie on the list: " + recentMovieTitle);

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement mostRatingsMovie = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='ratingColumn']/strong/following-sibling::a")));
        String mostRatingsMovieTitle = mostRatingsMovie.getText().trim();
        System.out.println("Movie with the most user ratings: " + mostRatingsMovieTitle);
    }
}
