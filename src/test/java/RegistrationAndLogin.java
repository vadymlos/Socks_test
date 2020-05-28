import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationAndLogin {

    public static final String username = "Vadym" + new Date().getTime();
    public static final String username2 = "Denis" + new Date().getTime();

    @BeforeClass
    public void BeforeClass(){
        Configuration.baseUrl = "http://localhost/";
    }
    @BeforeMethod
    public void beforeMethod() {
        Selenide.clearBrowserCookies();
        open("index.html");
    }


    @Test(description = "Registration new user, check that the user is logged in after registration")
    public void userCanRegistration() {
        $("#register").waitUntil(visible, 10000).click();
        $("#register-modal").waitUntil(text("Register"), 5000);
        $x("//div[@id='register-modal']//button[@class='btn btn-primary']").waitUntil(visible, 5000);

        $("#register-username-modal").click();
        $("#register-username-modal").setValue(username);
        $("#register-first-modal").setValue("Vadym5");
        $("#register-last-modal").setValue("Los5");
        $("#register-email-modal").setValue("mem7@gmail.com");
        $("#register-password-modal").setValue("autotest");
        $x("//div[@id='register-modal']//button[@class='btn btn-primary']").click();
        $x("//div[@id='topbar']").shouldHave(text("Logged in as Vadym5 Los5"));
        $(byText("Logout")).shouldHave(text("Logout"));
        $("#numItemsInCart").shouldHave(text("0 items in cart"));
    }

    @Test(description = "Log out, Log in and check that the user is logged in")
    public void userCanLogIn() {

        userCanRegistration2();
//        $(byText("Logout")).shouldHave(text("Logout")).click();
        $(byText("Login")).shouldHave(text("Login")).click();
        $("#Login").waitUntil(text("Customer login"), 5000);
        $x("//div[@id='login-modal']//button[@class='btn btn-primary']").waitUntil(visible, 5000);
        $("#username-modal").click();
        $("#username-modal").sendKeys(username2);
        $("#password-modal").setValue("autotest");

        $x("//div[@id='login-modal']//button[@class='btn btn-primary']").click();

        $x("//div[@id='topbar']").shouldHave(text("Logged in as Vadym5 Los5"));
        $(byText("Logout")).shouldHave(text("Logout")).shouldHave(text("Logout"));
        $("#numItemsInCart").shouldHave(text("0 items in cart"));



    }

    public void userCanRegistration2() {
        $("#register").waitUntil(visible, 10000).click();
        $("#register-modal").waitUntil(text("Register"), 5000);
        $x("//div[@id='register-modal']//button[@class='btn btn-primary']").waitUntil(visible, 5000);

        $("#register-username-modal").click();
        $("#register-username-modal").sendKeys(username2);
        $("#register-first-modal").setValue("Vadym5");
        $("#register-last-modal").setValue("Los5");
        $("#register-email-modal").setValue("mem7@gmail.com");
        $("#register-password-modal").setValue("autotest");

        $x("//div[@id='register-modal']//button[@class='btn btn-primary']").click();

        $x("//div[@id='topbar']").shouldHave(text("Logged in as Vadym5 Los5"));
        $(byText("Logout")).shouldHave(text("Logout"));
        $("#numItemsInCart").shouldHave(text("0 items in cart"));
        Selenide.clearBrowserCookies();
        open("http://localhost/index.html");
    }
}
