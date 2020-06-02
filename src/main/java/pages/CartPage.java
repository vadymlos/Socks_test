package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class CartPage {
    private SelenideElement productItem = $x("//tbody[@id = 'cart-list']//input[@min = '1']");
    private SelenideElement buttonItemsInCart = $x("//div[@id = 'basket-overview']//span[@id = 'numItemsInCart']");
    private SelenideElement buttonRefresh = $x("//div[@class = 'pull-right']//a[@class = 'btn btn-default']");
}
