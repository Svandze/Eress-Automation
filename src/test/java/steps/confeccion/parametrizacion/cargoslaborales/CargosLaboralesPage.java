package steps.confeccion.parametrizacion.cargoslaborales;

import org.junit.Before;
import org.junit.Test;
import pages.making.parametrizacion.ConfeccionPage;
import pages.making.parametrizacion.ParametrizacionPage;
import pages.making.parametrizacion.maestrogeneros.MaestroGenerosPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomCode;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class CargosLaboralesPage extends BaseTestSeress {

    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private MaestroGenerosPage maestroGenerosPage;

    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        maestroGenerosPage = new MaestroGenerosPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        waitAndClick(parametrizacionPage.maestroGenerosIcon);
    }

    @Test
    public void jobRolesManagementTest()  {
        String jobRolesCode = randomCode();
        String jobRolesDescription = "Test";
        String updateJobRolesCode = randomCode();
        String updatedJobRolesDescription = "Update Test";
        maestroGenerosPage.addMasterGenresCode(jobRolesCode, jobRolesDescription);
        maestroGenerosPage.editMasterGenres(jobRolesCode,updateJobRolesCode,updatedJobRolesDescription);
        maestroGenerosPage.validateMasterGenres(updateJobRolesCode, updateJobRolesCode, updatedJobRolesDescription);
        maestroGenerosPage.deleteMasterGenres(updateJobRolesCode);


    }

}
