package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@class='sc-fbNZge lmTa-DV fa fa-sign-out']")
    WebElement buttonLogout;

    public void pause(int time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean isTextInElementPresent(WebElement element, String text, int time){
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.textToBePresentInElement(element, text));
            return true;
        }catch (Exception e){
            return false;
        }

    }
    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size() > 0;
    }

    public void type(WebElement element, String text){
        if(text!=null) {
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }
}
