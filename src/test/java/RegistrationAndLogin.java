import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;


public class RegistrationAndLogin {

    String username = "Vadym" + new Date().getTime();

    @Test(description = "Registration new user, check that the user is logged in after registration")

    public void userCanRegistration(){

        open("http://localhost/index.html");

        $("#register").click();
        $("#register-modal").waitUntil(text("Register"), 5000);
        $x("//div[@id='register-modal']//button[@class='btn btn-primary']").waitUntil(visible, 5000);

        $("#register-username-modal").click();
        $("#register-username-modal").sendKeys(username);
        $("#register-first-modal").setValue("Vadym5");
        $("#register-last-modal").setValue("Los5");
        $("#register-email-modal").setValue("mem7@gmail.com");
        $("#register-password-modal").setValue("autotest");

        $x("//div[@id='register-modal']//button[@class='btn btn-primary']").click();

        $x("//a[text()='Logged in as Vadym5 Los5']").shouldHave(text("Logged in as Vadym5 Los5"));
        $x("//a[text()='Logout']").shouldHave(text("Logout"));
        $("#numItemsInCart").shouldHave(text("0 items in cart"));
    }

    @Test(description = "Log out, Log in and check that the user is logged in")

    public void userCanLogIn(){

        $x("//a[text()='Logout']").shouldHave(text("Logout")).click();
        $x("//a[text()='Login']").shouldHave(text("Login")).click();
        $("#Login").waitUntil(text("Customer login"), 5000);
        $x("//div[@id='login-modal']//button[@class='btn btn-primary']").waitUntil(visible, 5000);
        $("#username-modal").click();
        $("#username-modal").sendKeys(username);
        $("#password-modal").setValue("autotest");

        $x("//div[@id='login-modal']//button[@class='btn btn-primary']").click();

        $x("//a[text()='Logged in as Vadym5 Los5']").shouldHave(text("Logged in as Vadym5 Los5"));
        $x("//a[text()='Logout']").shouldHave(text("Logout"));
        $("#numItemsInCart").shouldHave(text("0 items in cart"));

    }
}
