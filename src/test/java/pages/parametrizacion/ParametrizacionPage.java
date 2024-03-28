package pages.parametrizacion;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ParametrizacionPage extends BasePage {
    @FindBy(xpath = "//a[@href='/parametrizacion/maquinas']")
    public WebElement maestroDeMaquinasIcon;
}
