import entity.User;
import org.testng.annotations.Test;
import steps.CartStep;
import steps.CatalogueStep;
import steps.MainStep;
import steps.ProductStep;
import utils.Utils;

import java.nio.channels.FileChannel;
import java.util.Random;

public class AddToCartTest extends BaseTest{
    MainStep mainStep = new MainStep();
    CatalogueStep catalogueStep = new CatalogueStep();
    ProductStep productStep = new ProductStep();
    CartStep cartStep = new CartStep();

    @Test(description = "Add product to cart")
    public void shouldCanAddProductToCart(){
        mainStep.clickOnCatalogueButton();
        catalogueStep.clickOnProductName();
        productStep.clickTheButtonAddToCart();
        productStep.clickTheButtonItemsInCart();
        cartStep.checkProductInCart();
        cartStep.checkValueOnTheButtonItemsInCart();
        cartStep.clickTheButtonRefresh();
        cartStep.checkProductInCart();
        cartStep.checkValueOnTheButtonItemsInCart();
    }
}
