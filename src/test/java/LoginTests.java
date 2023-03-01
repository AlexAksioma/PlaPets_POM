import dataprovider.DataProviderForLogin;
import dataprovider.DataProviderForRegistration;
import models.UserModel;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.HomePage;
import screens.LoginRegistrationPage;
import screens.StartPage;

public class LoginTests extends  TestBase{

    @Test(dataProvider = "DpFile_loginPositiveTest", dataProviderClass = DataProviderForLogin.class)
    public void loginPositiveTest(UserModel user){
        Assert.assertTrue(new StartPage(driver)
                .openLogRegPage_buttonSignIn()
                .fillLoginForm(UserModel.builder()
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .build())
                .clickButtonSubmit()
                .isTextElementPresent_Logout())
                ;
    }

    @Test(dataProvider = "DpFile_loginNegativeTest_WrongEmail", dataProviderClass = DataProviderForLogin.class)
    public void loginNegativeTest_WrongEmail(UserModel user){
        Assert.assertTrue(new StartPage(driver)
                .openLogRegPage_buttonSignIn()
                .fillLoginForm(UserModel.builder()
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .build())
                .clickButtonSubmitNegative()
                .isPresentText_ForgotPassword())
                ;
    }

    @Test(dataProvider = "DpFile_loginNegativeTest_WrongPassword", dataProviderClass = DataProviderForLogin.class)
    public void loginNegativeTest_WrongPassword(UserModel user){
        Assert.assertTrue(new StartPage(driver)
                .openLogRegPage_buttonSignIn()
                .fillLoginForm(UserModel.builder()
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .build())
                .clickButtonSubmitNegative()
                .isPresentText_ForgotPassword())
                ;
    }

    @Test(dataProvider = "DpFile_loginNegativeTest_UnregisteredUser", dataProviderClass = DataProviderForLogin.class)
    public void loginNegativeTest_UnregisteredUser(UserModel user){
        Assert.assertTrue(new StartPage(driver)
                .openLogRegPage_buttonSignIn()
                .fillLoginForm(UserModel.builder()
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .build())
                .clickButtonSubmitNegative()
                .isPresentText_ForgotPassword())
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
