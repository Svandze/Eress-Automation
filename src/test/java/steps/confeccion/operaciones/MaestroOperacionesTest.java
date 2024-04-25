package steps.confeccion.operaciones;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.confeccion.parametrizacion.ConfeccionPage;
import pages.confeccion.parametrizacion.ParametrizacionPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomCode;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class MaestroOperacionesTest extends BaseTestSeress {
    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private pages.confeccion.operaciones.MaestroOperacionesPage maestroOperacionesPage;

    @FindBy(xpath = "//a[@href='/parametrizacion/operaciones']//div[@class='card__projects-body-content']")
    public WebElement operacionesIcon;
    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        maestroOperacionesPage= new pages.confeccion.operaciones.MaestroOperacionesPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(operacionesIcon);
    }

    @Test
    public void operationManagementTest()  {
        Faker faker = new Faker();
        String operationCode = randomCode();
        String operationDescription = "Test";
        String updateOperationCode = randomCode();
        String updatedOperationDescription = "Update Test";
        maestroOperacionesPage.addOperations(operationCode,operationDescription,"PL1A","4", "6","GD00",  "Pruebas QA", "Pruebas QA", "GET04", "6-15", "");

    }
}
