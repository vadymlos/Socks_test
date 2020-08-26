package steps.ui;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.conditions.Text;
import io.qameta.allure.Step;
import pages.CartPage;

public class CartStep {
    private CartPage cartPage = new CartPage();

    @Step("Check product item in cart")
    public void checkProductInCart(){
        cartPage.getProductItem().shouldHave(Condition.value("1"));
    }

    @Step("Check value on the button items in cart")
    public void checkValueOnTheButtonItemsInCart(){
        cartPage.getButtonItemsInCart().shouldHave(Condition.text("1 item(s) in cart"));
    }

    @Step("Click the button refresh")
    public void clickTheButtonRefresh(){
        cartPage.getButtonRefresh().click();
    }
}
