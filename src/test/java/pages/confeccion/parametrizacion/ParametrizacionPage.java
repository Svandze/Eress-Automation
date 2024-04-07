package pages.confeccion.parametrizacion;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ParametrizacionPage extends BasePage {
    @FindBy(xpath = "//a[@href='/parametrizacion/maquinas']")
    public WebElement maestroDeMaquinasIcon;//article[@class='mt-4 grid__modules__nav']/seress-ui-link-card[5]/a/div

    @FindBy(xpath ="//a[@href='/parametrizacion/grupo-movimientos']")
    public WebElement grupoMovimientosIcon;

    @FindBy(xpath ="//a[@href='/parametrizacion/generos']")
    public WebElement maestroGenerosIcon;

    @FindBy(xpath ="//a[@href='/parametrizacion/clientes']")
    public WebElement maestroClientesIcon;

    @FindBy(xpath ="//article[@class='mt-4 grid__modules__nav']/seress-ui-link-card[5]/a/div")
    public WebElement maestroEstilosIcon;

    @FindBy(xpath ="//article[@class='mt-4 grid__modules__nav']/seress-ui-link-card[6]/a/div")
    public WebElement maestroTejidosIcon;

    @FindBy(xpath ="//article[@class='mt-4 grid__modules__nav']/seress-ui-link-card[7]/a/div")
    public WebElement gradoDificultadIcon;

    @FindBy(xpath ="//article[@class='mt-4 grid__modules__nav']/seress-ui-link-card[8]/a/div")
    public WebElement tipoMovimientoIcon;

    @FindBy(xpath ="//article[@class='mt-4 grid__modules__nav']/seress-ui-link-card[9]/a/div")
    public WebElement maestroElementosoIcon;

    @FindBy(xpath ="//article[@class='mt-4 grid__modules__nav']/seress-ui-link-card[10]/a/div")
    public WebElement maestroPrendasoIcon;

    @FindBy(xpath ="//article[@class='mt-4 grid__modules__nav']/seress-ui-link-card[11]/a/div")
    public WebElement calendarioIcon;
}
