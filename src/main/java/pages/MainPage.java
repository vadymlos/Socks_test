package pages;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


@Getter
public class MainPage {
    private SelenideElement registrationButton = $("#register");
    private SelenideElement linkToAccount = $x("//a[text()='Logged in as Vadym5 Los5']");
    private SelenideElement linkForLogOut = $x("//a[text()='Logout']");
    private SelenideElement inCartButton = $("#numItemsInCart");
    private SelenideElement loginButton = $x("//a[text()='Login']");
}
