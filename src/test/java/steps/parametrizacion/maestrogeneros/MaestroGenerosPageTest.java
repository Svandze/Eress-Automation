package steps.parametrizacion.maestrogeneros;

import org.junit.Before;
import org.junit.Test;
import pages.parametrizacion.ConfeccionPage;
import pages.parametrizacion.ParametrizacionPage;
import pages.parametrizacion.maestrogeneros.MaestroGenerosPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomCode;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class MaestroGenerosPageTest extends BaseTestSeress {

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
    public void MasterGenresManagementTest() throws InterruptedException {
        String masterGenresCode = randomCode();
        String masterGenresDescription = "Test";
        String updateMasterGenresCode = randomCode();
        String updatedMasterGenresDescription = "Update Test";
        maestroGenerosPage.addMasterGenresCode(masterGenresCode, masterGenresDescription);
        maestroGenerosPage.editMasterGenres(masterGenresCode,updateMasterGenresCode,updatedMasterGenresDescription);
        maestroGenerosPage.validateMasterGenres(updateMasterGenresCode, updateMasterGenresCode, updatedMasterGenresDescription);
        maestroGenerosPage.deleteMasterGenres(updateMasterGenresCode);


    }
}
