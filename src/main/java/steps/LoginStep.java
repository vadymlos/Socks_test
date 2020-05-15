package steps;

import entity.User;
import io.qameta.allure.Step;
import pages.LoginModal;

public class LoginStep {
    LoginModal loginModal = new LoginModal();

    @Step
    public void loginUser(User user) {
        loginModal.getLogInPasswordField().setValue(user.getName());
        loginModal.getLogInPasswordField().setValue(user.getPwd());
        loginModal.getLogInButton().click();
    }
}
