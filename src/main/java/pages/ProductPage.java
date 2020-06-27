package pages;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class ProductPage {
    private SelenideElement buttonAddToCart = $x("//a[@id='buttonCart']");
    private SelenideElement buttonItemsInCart = $x("//div[@id = 'basket-overview']");
}
