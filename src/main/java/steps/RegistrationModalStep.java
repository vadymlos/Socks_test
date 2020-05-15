package steps;

import com.codeborne.selenide.Condition;
import entity.User;
import io.qameta.allure.Step;
import pages.RegistrationModal;

public class RegistrationModalStep {
    private final RegistrationModal registrationModal = new RegistrationModal();

    @Step("Check that registration modal visible")
    public void checkThatRegistrationModalVisible() {
        registrationModal.getRegistrationModal().waitUntil(Condition.visible.because("Registration modal not visible"), 5000);
    }

    @Step("Check that registration button visible in the registration modal")
    public void checkThatRegistrationButtonVisibleInTheRegistrationModal() {
        registrationModal.getRegistrationButton().waitUntil(Condition.visible.because("Registartion button not visible in the registration modal"), 5000);
    }

    @Step("Click in Username field in the registration modal and put value")
    public void clickInUsernameFieldInRegistrationModalAndPutValue(String value) {
        registrationModal.getUsernameField()
                .click();
        registrationModal.getUsernameField()
                .setValue(value);
    }

    @Step("Put value in first name field in the registration modal")
    public void setValueInFirstNameFieldInTheRegistrationModal(String value) {
        registrationModal.getUsernameField().click();
        registrationModal.getUsernameField().setValue(value);
    }

    @Step("Fill register modal test-user {0]")
    public void registerUser(User user) {
        registrationModal.getEmailField().setValue(user.getEmail());
        registrationModal.getFirstNameField().setValue(user.getFirstName());
        registrationModal.getLastNameField().setValue(user.getPwd());
        registrationModal.getPasswordFiled().setValue(user.getPwd());
        registrationModal.getUsernameField().setValue(user.getName());
        registrationModal.getRegistrationButton().click();
    }
    //User - "name", "fisrtName", "pwd", "email"
    //getName, getFirstName...  uswer.getEmail - "email"
    //setName, setFirstName -
    //User testuser = new User("name","fname","pwd,"email");
    //User testUser = new User();
}
