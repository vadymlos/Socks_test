package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class RegistrationModal {
    private final SelenideElement registrationModal = $("#register-modal");
    private final SelenideElement registrationButton = $x("//div[@id='register-modal']//button[@class='btn btn-primary']");
    private final SelenideElement usernameField = $("#register-username-modal");
    private final SelenideElement firstNameField = $("#register-first-modal");
    private final SelenideElement lastNameField = $("#register-last-modal");
    private final SelenideElement emailField = $("#register-email-modal");
    private final SelenideElement passwordFiled = $("#register-password-modal");

}
