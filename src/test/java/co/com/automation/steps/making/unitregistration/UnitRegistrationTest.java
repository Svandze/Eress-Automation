package co.com.automation.steps.making.unitregistration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.parameterization.MakingPageEress;
import co.com.automation.pages.making.parameterization.ParameterizationPageEress;
import co.com.automation.pages.making.unitregistration.UnitRegistrationPageEress;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class UnitRegistrationTest extends BaseTestEress {

    private MakingPageEress makingPage;
    private ParameterizationPageEress parameterizationPage;
    private UnitRegistrationPageEress unitRegistrationPage;

    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPageEress();
        parameterizationPage = new ParameterizationPageEress();
        unitRegistrationPage = new UnitRegistrationPageEress();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.costUnitRegisterIcon);
    }
    @Disabled
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
