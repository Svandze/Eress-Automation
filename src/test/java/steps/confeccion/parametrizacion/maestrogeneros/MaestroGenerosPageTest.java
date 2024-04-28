package steps.confeccion.parametrizacion.maestrogeneros;

import org.junit.Before;
import org.junit.Test;
import pages.confeccion.parametrizacion.ConfeccionPage;
import pages.confeccion.parametrizacion.ParametrizacionPage;
import pages.confeccion.parametrizacion.cargoslaborales.CargosLaboralesPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomCode;
import static utils.ElementUtils.*;

public class MaestroGenerosPageTest extends BaseTestSeress {

    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private CargosLaboralesPage cargosLaboralesPage;

    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        cargosLaboralesPage = new CargosLaboralesPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        clickWithJavaScript(parametrizacionPage.cargosLaboralesIcon);
    }

    @Test
    public void MasterGenresManagementTest()  {
        String masterGenresCode = randomCode();
        String masterGenresDescription = "Test";
        String updateMasterGenresCode = randomCode();
        String updatedMasterGenresDescription = "Update Test";
        cargosLaboralesPage.addJobRoles(masterGenresCode, masterGenresDescription);
        cargosLaboralesPage.editJobRoles(masterGenresCode,updateMasterGenresCode,updatedMasterGenresDescription);
        cargosLaboralesPage.validateJobRoles(updateMasterGenresCode, updateMasterGenresCode, updatedMasterGenresDescription);
        cargosLaboralesPage.deleteJobRoles(updateMasterGenresCode);


    }
}
