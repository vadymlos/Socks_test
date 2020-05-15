package steps;

import com.codeborne.selenide.Condition;
import pages.MainPage;
import io.qameta.allure.Step;

public class MainStep {
    private MainPage mainPage = new MainPage();

    @Step("Click on Registration button on main page")
    public void clickOnRegistrationButton(){
        mainPage.getRegistrationButton().waitUntil(Condition.visible.because("Registration button not visible"), 6000).click();
    }

    @Step("Click on LogIn button on main page")
    public void clickOnLogInButtonOnMainPage(){
        mainPage.getLoginButton().waitUntil(Condition.visible.because("LogIn button not visible"), 5000).click();
    }

    @Step("Click on Log out button on main page")
    public void clickOnLogOutButtonOnMainPage(){
        mainPage.getLinkForLogOut().waitUntil(Condition.visible.because("LogOut button not visible"), 5000).click();
    }

    @Step("Check user cart after registration")
        public void checkUserCartAfterRegistration(){
            mainPage.getInCartButton().shouldHave(Condition.text("0 items in cart"));

    }
//    @Step("Check user firstName and lastName")
        //   public void checkUserAfterRegistration(String firstName, String lastName){
//        mainPage.getLinkForLogOut().shouldHave(Condition.text(firstName, lastName));

}
