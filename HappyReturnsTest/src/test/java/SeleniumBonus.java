import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumBonus {

    @Test
    public void searchHappyReturnsOnGoogle(){
        String URL = "https://google.com";


        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get(URL);
        WebElement searchbox = driver.findElement(By.xpath("//input[@title='Search']"));
        searchbox.sendKeys("Happy Returns");
        searchbox.sendKeys(Keys.ENTER);
        Assert.assertEquals(driver.findElement(By.xpath("//h3[@class='LC20lb DKV0Md']")).getText(), "Happy Returns makes returns beautiful for retailers, shoppers ...");



    }
}

