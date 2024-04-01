package steps.parametrizacion.maestrogeneros;

import org.junit.Before;
import org.junit.Test;
import pages.parametrizacion.ConfeccionPage;
import pages.parametrizacion.ParametrizacionPage;
import pages.parametrizacion.maestrogeneros.MaestroGeneros;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomMachineCode;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class MaestroGenerosTest extends BaseTestSeress {

    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private MaestroGeneros maestroGeneros;

    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        maestroGeneros = new MaestroGeneros();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        waitAndClick(parametrizacionPage.maestroGenerosIcon);
    }

    @Test
    public void MasterGenresManagementTest() throws InterruptedException {
        String masterGenresCode = randomMachineCode();
        String masterGenresDescription = "Test";
        String updateMasterGenresCode = randomMachineCode();
        String updatedMasterGenresDescription = "Update Test";
        maestroGeneros.addMasterGenresCode(masterGenresCode, masterGenresDescription);
        maestroGeneros.editMasterGenres(masterGenresCode,updateMasterGenresCode,updatedMasterGenresDescription);
        maestroGeneros.validateMasterGenres(updateMasterGenresCode, updateMasterGenresCode, updatedMasterGenresDescription);
        maestroGeneros.deleteMasterGenres(updateMasterGenresCode);


    }
}
