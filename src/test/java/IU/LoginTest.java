package IU;

import entity.User;
import org.testng.annotations.Test;
import steps.ui.LoginStep;
import steps.ui.MainStep;
import steps.ui.RegistrationModalStep;
import utils.Utils;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {
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
