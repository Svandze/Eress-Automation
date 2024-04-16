package pages.confeccion.parametrizacion;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ConfeccionPage extends BasePage {

    @FindBy(xpath = "//a[@class='card-pink-nav active'][1]")
    public WebElement parameterizationIcon;

}
