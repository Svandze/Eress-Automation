package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "(//a[@target=\"_blank\"])[1]")
    public WebElement confeccionesButton;

}
