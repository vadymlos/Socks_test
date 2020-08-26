package steps.ui;


import entity.User;
import io.qameta.allure.Step;
import pages.LoginModal;

public class LoginStep {
    private LoginModal loginModal = new LoginModal();

    @Step("Click in Username field in the login modal and put value")
    public void setValueInUsernameFieldInTheRegistrationModal(String value){
        loginModal.getLogInUsernameField().click();
        loginModal.getLogInUsernameField().setValue(value);
    }

    @Step("Click in Password field in the login modal and put value")
    public void setValueInPasswordFieldInTheRegistrationModal(String value){
        loginModal.getLogInPasswordField().setValue(value);
    }

    @Step("Click on button LogIn in the login modal")
    public void clickOnButtonLogInInTheLoginModal(){

        loginModal.getLogInButton().click();
    }

    @Step("Login user")
    public void loginUser(User user){
        loginModal.getLogInUsernameField().setValue(user.getUsername());
        loginModal.getLogInPasswordField().setValue(user.getPassword());
        loginModal.getLogInButton().click();
    }
}
