package steps.confeccion.parametrizacion.estadocivil;

import org.junit.Before;
import org.junit.Test;
import pages.confeccion.parametrizacion.ConfeccionPage;
import pages.confeccion.parametrizacion.ParametrizacionPage;
import pages.confeccion.parametrizacion.estadocivil.EstadoCivilPage;

import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomCode;
import static utils.ElementUtils.*;

public class EstadoCivilTest extends BaseTestSeress {

    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private EstadoCivilPage estadoCivilPage;

    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        estadoCivilPage = new EstadoCivilPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        implicitWait();
        clickWithJavaScript(parametrizacionPage.estadoCivilIcon);
    }

    @Test
    public void maritalStatusManagementTest()  {
        String maritalStatusCode = randomCode();
        String maritalStatusDescription = "Test";
        String updateMaritalStatusCode = randomCode();
        String updatedMaritalStatusDescription = "Update Test";
        estadoCivilPage.addMaritalStatus(maritalStatusCode, maritalStatusDescription);
        estadoCivilPage.editMaritalStatus(maritalStatusCode,updateMaritalStatusCode,updatedMaritalStatusDescription);
        estadoCivilPage.validateJobRoles(updateMaritalStatusCode, updateMaritalStatusCode, updatedMaritalStatusDescription);
        estadoCivilPage.deleteJobRoles(updateMaritalStatusCode);


    }

}
