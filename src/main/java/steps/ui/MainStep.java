package steps.ui;

import api.MyCookieJar;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import okhttp3.OkHttpClient;
import org.openqa.selenium.Cookie;
import pages.MainPage;
import io.qameta.allure.Step;
import steps.restassured.ApiStep;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class MainStep {
    private MainPage mainPage = new MainPage();
    private String sessionUser;
    private ApiStep apiStep = new ApiStep();

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

    @Step("Click on catalogue on main menu")
        public void clickOnCatalogueButton(){
        mainPage.getCatalogButton().click();
    }

    @Step("Check that user logged in")
    public void checkThatLogoutLinkIsVisible(){
        mainPage.getLinkForLogOut().waitUntil(Condition.visible.because("LogOut button not visible"), 5000);
    }

    @Step("Set cookie")
    public void setUserCookie(List<Cookie> cookies){
        System.out.println(cookies.toString());
        WebDriverRunner.getWebDriver().manage().addCookie(cookies.get(0));
        WebDriverRunner.getWebDriver().manage().addCookie(cookies.get(1));
    }

    @Step("Set cookie retro")
    public void setUserCookieOk(MyCookieJar myCookieJar){
        System.out.println(myCookieJar.toString());
        WebDriverRunner.getWebDriver().manage().addCookie(myCookieJar.getCookies().get(0));
    }
}
