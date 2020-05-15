import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import entity.User;
import entity.User2;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.LoginStep;
import steps.MainStep;
import steps.RegistrationModalStep;
import utils.Utils;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest{
    User user = new User(Utils.randomUserName(), "Vadym", "Test", "form2@com.com", "123");
    MainStep mainStep = new MainStep();
    RegistrationModalStep registrationModalStep = new RegistrationModalStep();
    LoginStep loginStep = new LoginStep();

    @Test(priority = 1, description = "Registration new user")
    public void shouldCanRegisterUser(){
        mainStep.clickOnRegistrationButton();
        registrationModalStep.checkThatRegistrationModalVisible();
        registrationModalStep.checkThatRegistrationButtonVisibleInTheRegistrationModal();
        registrationModalStep.registrationUser(user);
        registrationModalStep.clickOnButtonRegisterInTheRegistrationModal();
        mainStep.checkUserCartAfterRegistration();
        mainStep.clickOnLogOutButtonOnMainPage();
    }

    @Test(priority = 2, description = "Login user")
    public void shouldCanLoginUser(){
        mainStep.clickOnLogInButtonOnMainPage();
        loginStep.loginUser(user);
        loginStep.clickOnButtonLogInInTheLoginModal();
        mainStep.checkUserCartAfterRegistration();
    }
}
