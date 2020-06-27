package pages;


import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class CataloguePage {
    private SelenideElement linkToProductPage = $(byText("Colourful"));
}
