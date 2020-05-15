package pages;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class LoginModal {
    private SelenideElement logInModal = $("#Login");
    private SelenideElement logInButton = $x("//div[@id='login-modal']//button[@class='btn btn-primary']");
    private SelenideElement logInUsernameField = $("#username-modal");
    private SelenideElement logInPasswordField = $("#password-modal");
}
