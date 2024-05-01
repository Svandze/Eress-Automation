package steps.confeccion.operaciones;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import pages.making.parametrizacion.ConfeccionPage;
import pages.making.parametrizacion.ParametrizacionPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomCode;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class MaestroOperacionesTest extends BaseTestSeress {
    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private pages.making.operaciones.MaestroOperacionesPage maestroOperacionesPage;


    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        maestroOperacionesPage= new pages.making.operaciones.MaestroOperacionesPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.operacionesIcon);
    }

    @Test
    public void operationManagementTest()  {
        Faker faker = new Faker();
        String operationCode = randomCode();
        String operationDescription = "Test";
        String updateOperationCode = randomCode();
        String updatedOperationDescription = "Update Test";
        maestroOperacionesPage.addOperations(operationCode,operationDescription,"PL1A","4", "6","GD00",  "Pruebas QA", "Pruebas QA", "", "", "");
        maestroOperacionesPage.editOperations(operationCode,updateOperationCode,updatedOperationDescription,"FPS","6", "4", "GD10","Admin","Admin","" ,"","");
        maestroOperacionesPage.validateOperations(updateOperationCode, updatedOperationDescription,"FPS","6", "4", "GD10","Admin","Admin","" ,"","");
        maestroOperacionesPage.deleteOperations(updateOperationCode);
    }
}
