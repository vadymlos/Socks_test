package steps;

import com.codeborne.selenide.Condition;
import pages.MainPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public class MainStep {
    private MainPage mainPage = new MainPage();

    @Step("Click on Registration button on main page")
    public void clickOnRegistrationButton(){
        mainPage.getRegistrationButton().waitUntil(visible.because("Registration button not visible"), 6000).click();
    }

    @Step
    public void openLoginModal(){
        mainPage.getLoginButton().click();
    }

    @Step
    public void checkUserAfterReg(String name){
        mainPage.getLinkToAccount().shouldHave(text(name));
    }
}
