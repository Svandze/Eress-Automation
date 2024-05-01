package steps.confeccion.registrounidades;

import org.junit.Before;
import org.junit.Test;
import pages.making.parametrizacion.ConfeccionPage;
import pages.making.parametrizacion.ParametrizacionPage;
import pages.making.registrounidades.RegistroUnidadesPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class RegistroUnidadesTest extends BaseTestSeress {

    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private RegistroUnidadesPage registroUnidadesPage;

    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        registroUnidadesPage = new RegistroUnidadesPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.costUnitRegisterIcon);
    }

    @Test
    public void unitsRegistrationManagementTest() {
        String dayOfTheMonth = "14";
        String producedUnits = "2";
        String turnMin = "2";
        String extraMin = "2";
        String nPersons = "3";
        String producedUnitsForUpdate = "10";
        String turnMinForUpdate = "10";
        String extraMinForUpdate = "10";
        String nPersonsForUpdate = "10";
        registroUnidadesPage.addNewUnitRegister(dayOfTheMonth, producedUnits, turnMin, extraMin, nPersons);
        registroUnidadesPage.editRegisteredUnit(producedUnitsForUpdate, turnMinForUpdate, extraMinForUpdate, nPersonsForUpdate);
        registroUnidadesPage.validateUnitInformation(producedUnitsForUpdate, turnMinForUpdate, extraMinForUpdate, nPersonsForUpdate);
        registroUnidadesPage.deleteUnit();
    }
}
