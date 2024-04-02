package steps.parametrizacion.tejidos;

import org.junit.Before;
import org.junit.Test;
import pages.parametrizacion.ConfeccionPage;
import pages.parametrizacion.ParametrizacionPage;
import pages.parametrizacion.tejidos.TejidosPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomCode;
import static utils.ElementUtils.*;
import static utils.ElementUtils.waitAndClick;

public class TejidosPageTest extends BaseTestSeress {



    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private TejidosPage tejidosPage;


    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        tejidosPage = new TejidosPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        ScrollToElement(parametrizacionPage.maestroTejidosIcon);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitAndClick(parametrizacionPage.maestroTejidosIcon);

    }

    @Test
    public void MasterStilesManagementTest() throws InterruptedException {
        String weaveCode = randomCode();
        String weaveDescription = "Test";
        String updateWeaveCode = randomCode();
        String updatedWeaveDescription = "Update Test";
        tejidosPage.addWeave(weaveCode,weaveDescription);
        tejidosPage.editWeave(weaveCode,updateWeaveCode, updatedWeaveDescription);
        tejidosPage.validateWeave(updateWeaveCode,updateWeaveCode,updatedWeaveDescription);
        tejidosPage.deleteWeave(updateWeaveCode);


    }
}
