package steps.confeccion.listaoperaciones;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.confeccion.costosygastos.CostosGastosPage;
import pages.confeccion.listaoperaciones.ListaOperacionesPage;
import pages.confeccion.parametrizacion.ConfeccionPage;
import pages.confeccion.parametrizacion.ParametrizacionPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class ListaOperacionesTest extends BaseTestSeress {

    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private ListaOperacionesPage listaOperacionesPage;

    @FindBy(xpath = "(//h4[normalize-space()='Listado de operaciones'])[1]")
    public WebElement operationListIcon;
    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        listaOperacionesPage= new ListaOperacionesPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(operationListIcon);
    }

    @Test
    public void operationsListManagementTest()  {
        Faker faker = new Faker();


    }
}
