import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import entity.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import steps.LoginStep;
import steps.MainStep;
import steps.RegistrationModalStep;
import utils.Utils;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationTest extends BaseTest{
    User user = new User(Utils.randomUserName(), "Vadym", "Test", "form@com.com", "123");

    MainStep mainStep = new MainStep();
    RegistrationModalStep registrationModalStep = new RegistrationModalStep();
    LoginStep loginStep = new LoginStep();


    @Test(description = "Registration new user")
    public void shouldCanRegisterUser(){
        mainStep.clickOnRegistrationButton();
        registrationModalStep.checkThatRegistrationModalVisible();
        registrationModalStep.checkThatRegistrationButtonVisibleInTheRegistrationModal();
        registrationModalStep.registrationUser(user);
        registrationModalStep.clickOnButtonRegisterInTheRegistrationModal();
        mainStep.checkUserCartAfterRegistration();
        mainStep.clickOnLogOutButtonOnMainPage();
        mainStep.clickOnLogInButtonOnMainPage();
        loginStep.loginUser(user);
        loginStep.clickOnButtonLogInInTheLoginModal();
        mainStep.checkUserCartAfterRegistration();
    }
}

