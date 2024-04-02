package steps.parametrizacion.maestrodemaquinas;

import org.junit.Before;
import org.junit.Test;
import pages.parametrizacion.ConfeccionPage;
import pages.parametrizacion.ParametrizacionPage;
import pages.parametrizacion.maestrodemaquinas.MaestroDeMaquinasPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomCode;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class MaestroDeMaquinasTest extends BaseTestSeress {

    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private MaestroDeMaquinasPage maestroDeMaquinasPage;

    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        maestroDeMaquinasPage = new MaestroDeMaquinasPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        waitAndClick(parametrizacionPage.maestroDeMaquinasIcon);
    }

    @Test
    public void MachineManagementTest() {
        String machineCode = randomCode();
        String initialType = "PLANA 1 AGU";
        String initialDistance0To5 = "5";
        String initialDistance6To10 = "6";
        String initialDistanceGreaterThan11 = "23";
        String updatedType = "PLANA 3 AGU";
        String updatedDistance0To5 = "8";
        String updatedDistance6To10 = "12";
        String updatedDistanceGreaterThan11 = "45";
        maestroDeMaquinasPage.addMachine(machineCode, initialType, initialDistance0To5, initialDistance6To10, initialDistanceGreaterThan11);
        maestroDeMaquinasPage.editMachine(machineCode, updatedType, updatedDistance0To5, updatedDistance6To10, updatedDistanceGreaterThan11);
        maestroDeMaquinasPage.validateMachine(machineCode, updatedDistance0To5, updatedDistance6To10, updatedDistanceGreaterThan11);
        maestroDeMaquinasPage.deleteMachine(machineCode);
    }
}
