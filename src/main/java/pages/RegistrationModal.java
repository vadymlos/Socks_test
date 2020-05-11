package pages;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class RegistrationModal {
    private SelenideElement registrationModal = $("#register-modal");
    private SelenideElement registrationButton = $x("//div[@id='register-modal']//button[@class='btn btn-primary']");
    private SelenideElement usernameField = $("#register-username-modal");
    private SelenideElement firstNameField = $("#register-first-modal");
    private SelenideElement secondNameField = $("#register-last-modal");
    private SelenideElement emailField = $("#register-email-modal");
    private SelenideElement passwordFiled = $("#register-password-modal");

}
