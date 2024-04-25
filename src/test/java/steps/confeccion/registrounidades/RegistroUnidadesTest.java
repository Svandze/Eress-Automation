package steps.confeccion.registrounidades;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.confeccion.costosygastos.CostosGastosPage;
import pages.confeccion.parametrizacion.ConfeccionPage;
import pages.confeccion.parametrizacion.ParametrizacionPage;
import pages.confeccion.registrounidades.RegistroUnidadesPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class RegistroUnidadesTest extends BaseTestSeress {

    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private RegistroUnidadesPage registroUnidadesPage;

    @FindBy(xpath = "(//h4[normalize-space()='Registro unidades diarias de producción'])[1]")
    public WebElement costExpensesIcon;
    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        registroUnidadesPage= new RegistroUnidadesPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(costExpensesIcon);
    }

    @Test
    public void unitsRegistrationManagementTest()  {
        Faker faker = new Faker();


    }
}
