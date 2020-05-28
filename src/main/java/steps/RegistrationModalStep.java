package steps;

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

    @Step("Click in Username field in the registration modal and put value")
    public void clickInUsernameFieldInRegistrationModalAndPutValue(String value){
        registrationModal.getUsernameField()
                .click();
        registrationModal.getUsernameField()
                .setValue(value);
    }

    @Step("Click in First name field in the registration modal and put value")
    public void setValueInFirstNameFieldInTheRegistrationModal(String value){
        registrationModal.getFirstNameField()
                .click();
        registrationModal.getFirstNameField()
                .setValue(value);
    }

    @Step("Click in Last name field in the registration modal and put value")
    public void setValueInLastNameFieldInTheRegistrationModal(String value){
        registrationModal.getLastNameField()
                .click();
        registrationModal.getLastNameField()
                .setValue(value);
    }

    @Step("Click in Email field in the registration modal and put value")
    public void setValueInEmailFieldInTheRegistrationModal(String value){
        registrationModal.getEmailField().click();
        registrationModal.getEmailField().setValue(value);
    }

    @Step("Click in Password field in the registration modal and put value")
    public void setValueInPasswordFieldInTheRegistrationModal(String value){
        registrationModal.getPasswordFiled().click();
        registrationModal.getPasswordFiled().setValue(value);
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
