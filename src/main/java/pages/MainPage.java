package pages;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


@Getter
public class MainPage {
    private SelenideElement registrationButton = $("#register");
    private SelenideElement linkToAccount = $x("//div[@id='topbar']");
    private SelenideElement linkForLogOut = $(byText("Logout"));
    private SelenideElement inCartButton = $("#numItemsInCart");
    private SelenideElement loginButton = $(byText("Login"));
}
