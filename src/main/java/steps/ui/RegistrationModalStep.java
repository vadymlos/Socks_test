package steps.ui;

import com.codeborne.selenide.Condition;
import entity.User;
import io.qameta.allure.Step;
import pages.RegistrationModal;

import java.util.List;

public class RegistrationModalStep {
    private RegistrationModal registrationModal = new RegistrationModal();

    @Step("Check that registration modal visible")
    public void checkThatRegistrationModalVisible(){
        registrationModal.getRegistrationModal().waitUntil(Condition.visible.because("Registration modal not visible"), 5000);
    }

    @Step("Check that registration button visible in the registration modal")
    public void checkThatRegistrationButtonVisibleInTheRegistrationModal(){
        registrationModal.getRegistrationButton().waitUntil(Condition.visible.because("Registartion button not visible in the registration modal"), 5000);
    }

    @Step("Click in Username field in the registration modal and put username")
    public void clickInUserNameFieldInRegistrationModalAndPutValue(String username){
        registrationModal.getUsernameField()
                .click();
        registrationModal.getUsernameField()
                .setValue(username);
    }

    @Step("Click in First name field in the registration modal and put First name")
    public void setValueInFirstNameFieldInTheRegistrationModal(String firstName){
        registrationModal.getFirstNameField()
                .click();
        registrationModal.getFirstNameField()
                .setValue(firstName);
    }

    @Step("Click in Last name field in the registration modal and put value")
    public void setValueInLastNameFieldInTheRegistrationModal(String lastName){
        registrationModal.getLastNameField()
                .click();
        registrationModal.getLastNameField()
                .setValue(lastName);
    }

    @Step("Click in Email field in the registration modal and put value")
    public void setValueInEmailFieldInTheRegistrationModal(String email){
        registrationModal.getEmailField().click();
        registrationModal.getEmailField().setValue(email);
    }

    @Step("Click in Password field in the registration modal and put value")
    public void setValueInPasswordFieldInTheRegistrationModal(String password){
        registrationModal.getPasswordFiled().click();
        registrationModal.getPasswordFiled().setValue(password);
    }

    @Step("Click on button Register in the registration modal")
    public void clickOnButtonRegisterInTheRegistrationModal(){
        registrationModal.getRegistrationButton().click();
    }

    @Step("Fill registration modal step test user")
    public void registrationUser(User user){
        registrationModal.getUsernameField().setValue(user.getUsername());
        registrationModal.getFirstNameField().setValue(user.getFirstName());
        registrationModal.getLastNameField().setValue(user.getLastName());
        registrationModal.getEmailField().setValue(user.getEmail());
        registrationModal.getPasswordFiled().setValue(user.getPassword());
    }
}
