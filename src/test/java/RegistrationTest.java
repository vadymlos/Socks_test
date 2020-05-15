import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import entity.User;
import org.testng.annotations.*;
import steps.LoginStep;
import steps.MainStep;
import steps.RegistrationModalStep;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationTest {

    private static final User user = User.builder()
            .email("test")
            .firstName("sdd")
            .name("sdf")
            .pwd("23ewq")
            .build();
    MainStep mainStep = new MainStep();
    RegistrationModalStep regStep = new RegistrationModalStep();
    LoginStep loginStep = new LoginStep();

    @BeforeMethod
    public void beforeMethod() {
        Configuration.baseUrl = "http://localhost/";
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "chrome";
        Configuration.fastSetValue  = true;
        Selenide.clearBrowserCookies();
        open("/");
    }

    @Test(description = "Registration new user and login this user in system")
    public void shouldCanRegisterUser() {
        mainStep.clickOnRegistrationButton();
        regStep.checkThatRegistrationButtonVisibleInTheRegistrationModal();
        regStep.registerUser(user);
        mainStep.openLoginModal();
        loginStep.loginUser(user);
        mainStep.checkUserAfterReg(user.getName());
    }
}
