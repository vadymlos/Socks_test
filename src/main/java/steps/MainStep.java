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
}
