import dataprovider.DataProviderForRegistration;
import models.UserModel;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.HomePage;
import screens.LoginRegistrationPage;
import screens.StartPage;

import java.util.Random;

public class RegistrationTests extends TestBase {

    @Test(dataProvider = "DpFile_registrationPositiveTest", dataProviderClass = DataProviderForRegistration.class)
    public void registrationPositiveTest(UserModel user) {
        Assert.assertTrue(new StartPage(driver)
                .openLogRegPage_buttonJoin()
                .clickButtonSignUpForm()
                .fillRegistrationForm(UserModel.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .confirmPassword(user.getConfirmPassword())
                        .build())
                .clickButtonSubmit()
                .isTextElementPresent_Logout())
        ;
    }

    @Test(dataProvider = "DpFile_registrationNegativeTest_WrongEmail", dataProviderClass = DataProviderForRegistration.class)
    public void registrationNegativeTest_WrongEmail(UserModel user) {
        Assert.assertTrue(new StartPage(driver)
                .openLogRegPage_buttonJoin()
                .clickButtonSignUpForm()
                .fillRegistrationForm(UserModel.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .confirmPassword(user.getConfirmPassword())
                        .build())
                .clickButtonSubmitNegative()
                .isErrorMessagePresent_EmailNotValid())
        ;
    }

    @Test(dataProvider = "DpFile_registrationNegativeTest_DuplicateEmail", dataProviderClass = DataProviderForRegistration.class)
    public void registrationNegativeTest_DuplicateEmail(UserModel user) {
        Assert.assertTrue(new StartPage(driver)
                .openLogRegPage_buttonJoin()
                .clickButtonSignUpForm()
                .fillRegistrationForm(UserModel.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .confirmPassword(user.getConfirmPassword())
                        .build())
                .clickButtonSubmitNegative()
                .isErrorMessagePresent_UserAlreadyExist())
        ;

    }

    @Test(dataProvider = "DpFile_registrationNegativeTest_WrongPassword", dataProviderClass = DataProviderForRegistration.class)
    public void registrationNegativeTest_WrongPassword(UserModel user) {
        Assert.assertTrue(new StartPage(driver)
                .openLogRegPage_buttonJoin()
                .clickButtonSignUpForm()
                .fillRegistrationForm(UserModel.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .confirmPassword(user.getConfirmPassword())
                        .build())
                .clickButtonSubmitNegative()
                .isPresentText_PasswordMustHave())//!!!!!
        ;
    }

    @Test(dataProvider = "DpFile_registrationNegativeTest_PasswordsNotMatch", dataProviderClass = DataProviderForRegistration.class)
    public void registrationNegativeTest_PasswordsNotMatch(UserModel user) {
        Assert.assertTrue(new StartPage(driver)
                .openLogRegPage_buttonJoin()
                .clickButtonSignUpForm()
                .fillRegistrationForm(UserModel.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .confirmPassword(user.getConfirmPassword())
                        .build())
                .clickButtonSubmitNegative()
                .isErrorMessagePresent_PasswordsNotMatch())
        ;
    }

    @AfterMethod
    public void postCondition() {
        HomePage homePage = new HomePage(driver);
        if (homePage.isTextElementPresent_Logout())
            homePage.clickButtonLogout();
        else new LoginRegistrationPage(driver).clickButtonCansel();
    }

}
