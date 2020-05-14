package steps;

import com.codeborne.selenide.Condition;
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
    public void clickInUsernameFieldInRegistrationModalAndPutValue(){
        registrationModal.getUsernameField()
                .click()
                .setValue();
    }

    @Step("Put value in first name field in the registration modal")
    public void setValueInFirstNameFieldInTheRegistrationModal(List<String> items){
        registrationModal.getFirstNameField().getItem;
    }
}
