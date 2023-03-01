package screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public StartPage clickButtonLogout(){
        buttonLogout.click();
        return new StartPage(driver);
    }

    @FindBy(xpath = "//div[@class='sc-fvhFOF eMfMFQ']")
    WebElement buttonLogout;

    public boolean isTextElementPresent_Logout() {
        return isTextInElementPresent(buttonLogout, "Logout", 3);
    }
}
