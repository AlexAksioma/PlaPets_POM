package screens;

import models.UserModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginRegistrationPage extends BasePage{

    @FindBy(xpath = "//div[text()='Cancel']")
    WebElement buttonCansel;

    @FindBy(xpath = "//div[text()='Submit']")
    WebElement buttonSubmit;

    @FindBy(xpath = "//div[@class='sc-edoYdd cZhezb']")
    WebElement buttonSignIn;

    @FindBy(xpath = "//div[@class='sc-edoYdd WPXJZ']")
    WebElement buttonSignUp;

    @FindBy(xpath = "//input[@placeholder='Peter']")
    WebElement name;

    @FindBy(xpath = "//input[@placeholder='peter@gmail.com']")
    WebElement email;

    @FindBy(xpath = "//div[@class='sc-jlIlqL CnIuH']/div[3]/input")
    WebElement password;

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordLogin;

    @FindBy(xpath = "//div[@class='sc-jlIlqL CnIuH']/div[4]/input")
    WebElement confirmPassword;

    @FindBy(xpath = "//div[@class='sc-fxNMLY bXYHzn']")
    WebElement buttonForgotPassword;

    @FindBy(xpath = "//div[text()='Email not valid']")
    WebElement errorMessage_WrongEmail;

    @FindBy(xpath = "//div[@class='sc-hYAvtR exMbkk']")
    WebElement errorMessage_PasNotMatch;

    @FindBy(xpath = "//div[@class='sc-hYAvtR exMbkk']")
    WebElement errorMessage_UserExist;

    @FindBy(xpath = "//div[@class='sc-dkaWRx ikqQip']")
    WebElement text_PasswordMustHave;
    public LoginRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public StartPage clickButtonCansel(){
        buttonCansel.click();
        return new StartPage(driver);
    }

    public boolean isPresent_buttonSubmit(){
        return isElementPresent(By.xpath("//div[text()='Submit']"));
    }


    public LoginRegistrationPage clickButtonSignUpForm() {
        buttonSignUp.click();
        return this;
    }

    public LoginRegistrationPage fillRegistrationForm(UserModel model) {
        type(name, model.getName());
        type(email, model.getEmail());
        type(password, model.getPassword());
        type(confirmPassword, model.getConfirmPassword());
        return this;
    }

    public HomePage clickButtonSubmit() {
        buttonSubmit.click();
        return new HomePage(driver);
    }

    public LoginRegistrationPage clickButtonSubmitNegative() {
        buttonSubmit.click();
        return this;
    }

    public boolean isErrorMessagePresent_EmailNotValid() {
        return isTextInElementPresent(errorMessage_WrongEmail, "Email not valid", 3);
    }

    public boolean isErrorMessagePresent_PasswordsNotMatch() {
        return isTextInElementPresent(errorMessage_PasNotMatch, "Passwords not match", 3);
    }

    public boolean isPresentText_PasswordMustHave() {
        pause(5);
        return isTextInElementPresent(text_PasswordMustHave, "Password must have", 3);
    }

    public boolean isErrorMessagePresent_UserAlreadyExist() {
        return isTextInElementPresent(errorMessage_UserExist, "User with this email already exists",3);
    }

    public LoginRegistrationPage fillLoginForm(UserModel user) {
        type(email, user.getEmail());
        type(passwordLogin, user.getPassword());
        return this;
    }

    public boolean isPresentText_ForgotPassword() {
        return isTextInElementPresent(buttonForgotPassword, "Forgot password?", 1);
    }
}
