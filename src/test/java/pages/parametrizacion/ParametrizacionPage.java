package pages.parametrizacion;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ParametrizacionPage extends BasePage {
    @FindBy(xpath = "//a[@href='/parametrizacion/maquinas']")
    public WebElement maestroDeMaquinasIcon;

    @FindBy(xpath ="//a[@href='/parametrizacion/grupo-movimientos']")
    public WebElement grupoMovimientosIcon;

    @FindBy(xpath ="//a[@href='/parametrizacion/generos']")
    public WebElement maestroGenerosIcon;

    @FindBy(xpath ="//a[@href='/parametrizacion/clientes']")
    public WebElement maestroClientesIcon;
}
