package co.com.automation.pages.making.parameterization;

import co.com.automation.pages.BasePageEress;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ParameterizationPageEress extends BasePageEress {
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

    @FindBy(xpath ="//article[@class='mt-4 grid__modules__nav']/seress-ui-link-card[12]/a/div")
    public WebElement tallerIcon;
    @FindBy(xpath ="//article[@class='mt-4 grid__modules__nav']/seress-ui-link-card[13]/a/div")
    public WebElement cargosLaboralesIcon;
    @FindBy(xpath ="(//h4[normalize-space()='Estado Civil'])[1]")
    public WebElement estadoCivilIcon;

    @FindBy(xpath ="(//h4[normalize-space()='Tipo de documentos'])[1]")
    public WebElement tipoDocumentoIcon;


    @FindBy(xpath ="(//h4[normalize-space()='Localización por regiones'])[1]")
    public WebElement localizacionRegionesIcon;

    @FindBy(xpath ="(//h4[normalize-space()='Máquinas por operario'])[1]")
    public WebElement maquinasOperarioIcon;

    @FindBy(xpath ="(//h4[normalize-space()='Grupos de costos y gastos'])[1]")
    public WebElement grupoCostosGastosIcon;

    @FindBy(xpath ="(//h4[normalize-space()='Conceptos de costos y gastos'])[1]")
    public WebElement conceptoCostosGastosIcon;

    @FindBy(xpath ="(//h4[normalize-space()='Turnos Laborales'])[1]")
    public WebElement turnosLaboralesIcon;

    @FindBy(xpath ="(//h4[normalize-space()='Empleados'])[1]")
    public WebElement empleadosIcon;
}
