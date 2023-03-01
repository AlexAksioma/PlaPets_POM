import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver driver;

    @BeforeSuite
    public void init(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("https://propetscom.herokuapp.com/");
    }

    @AfterSuite
    public void tearDown(){
        //driver.quit();
    }
}
