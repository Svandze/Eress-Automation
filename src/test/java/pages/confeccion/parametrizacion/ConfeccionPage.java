package pages.confeccion.parametrizacion;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ConfeccionPage extends BasePage {

    @FindBy(xpath = "//a[@class='card-pink-nav active'][1]")
    public WebElement parameterizationIcon;
    @FindBy(xpath = "//h4[normalize-space()='Costos y gastos']")
    public WebElement costExpensesIcon;

    @FindBy(xpath = "(//h4[normalize-space()='Listado de operaciones'])[1]")
    public WebElement operationListIcon;

    @FindBy(xpath = "//a[@href='/parametrizacion/operaciones']//div[@class='card__projects-body-content']")
    public WebElement operacionesIcon;
    @FindBy(xpath = "(//h4[normalize-space()='Registro unidades diarias de producción'])[1]")
    public WebElement costUnitRegisterIcon;

}
