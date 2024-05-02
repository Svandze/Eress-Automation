package co.com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static co.com.eress.automation.constants.EressConstants.BASE_URL;

public class HomePage extends BasePage{

    @FindBy(xpath = "(//a[@target=\"_blank\"])[1]")
    public WebElement confeccionesButton;

    public void openPage() {
        driver.get(BASE_URL);
    }
}
