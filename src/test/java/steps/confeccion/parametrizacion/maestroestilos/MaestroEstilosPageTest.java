package steps.confeccion.parametrizacion.maestroestilos;

import org.junit.Before;
import org.junit.Test;
import pages.making.parametrizacion.ConfeccionPage;
import pages.making.parametrizacion.ParametrizacionPage;
import pages.making.parametrizacion.maestroestilos.MaestroEstilosPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomCode;
import static utils.ElementUtils.*;

public class MaestroEstilosPageTest extends BaseTestSeress {



    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private MaestroEstilosPage maestroEstilosPage;


    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        maestroEstilosPage = new MaestroEstilosPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        scrollToElement(parametrizacionPage.maestroEstilosIcon);
        waitAndClick(parametrizacionPage.maestroEstilosIcon);
    }

    @Test
    public void masterStylesManagementTest() {
        String masterStylesCode = randomCode();
        String masterStylesDescription = "Test";
        String updateMasterStylesCode = randomCode();
        String updatedMasterStylesDescription = "Update Test";
        maestroEstilosPage.addMasterStyles(masterStylesCode,masterStylesDescription);
        maestroEstilosPage.editMasterStyles(masterStylesCode,updateMasterStylesCode, updatedMasterStylesDescription);
        maestroEstilosPage.validateMasterStyles(updateMasterStylesCode,updateMasterStylesCode,updatedMasterStylesDescription);
        maestroEstilosPage.deleteMasterStyles(updateMasterStylesCode);


    }
}
