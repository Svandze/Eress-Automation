package co.com.automation.steps.making.unitregistration;

import org.junit.Before;
import org.junit.Test;
import co.com.automation.pages.making.parameterization.MakingPage;
import co.com.automation.pages.making.parameterization.ParameterizationPage;
import co.com.automation.pages.making.unitregistration.UnitRegistrationPage;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class UnitRegistrationTest extends BaseTestEress {

    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private UnitRegistrationPage unitRegistrationPage;

    @Before
    public void setup() {
        super.setup();
        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        unitRegistrationPage = new UnitRegistrationPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.costUnitRegisterIcon);
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
        unitRegistrationPage.addNewUnitRegister(dayOfTheMonth, producedUnits, turnMin, extraMin, nPersons);
        unitRegistrationPage.editRegisteredUnit(producedUnitsForUpdate, turnMinForUpdate, extraMinForUpdate, nPersonsForUpdate);
        unitRegistrationPage.validateUnitInformation(producedUnitsForUpdate, turnMinForUpdate, extraMinForUpdate, nPersonsForUpdate);
        unitRegistrationPage.deleteUnit();
    }
}
