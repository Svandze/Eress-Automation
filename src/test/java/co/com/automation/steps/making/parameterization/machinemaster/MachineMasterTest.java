package co.com.automation.steps.making.parameterization.machinemaster;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import co.com.automation.pages.making.parameterization.MakingPage;
import co.com.automation.pages.making.parameterization.ParameterizationPage;
import co.com.automation.pages.making.parameterization.machinemaster.MachineMasterPage;
import co.com.automation.steps.BaseTestEress;
import org.junit.jupiter.api.Test;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

@Epic("Eeress")
@Feature("Machine Master Functionality")
public class MachineMasterTest extends BaseTestEress {

    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private MachineMasterPage machineMasterPage;

    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        machineMasterPage = new MachineMasterPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        waitAndClick(parameterizationPage.maestroDeMaquinasIcon);
    }

    @Description("E2E flow")
    @Story("Valid User Login")
    @Test
    public void machineManagementTest() {
        String machineCode = randomCode();
        String initialType = "PLANA 1 AGU";
        String initialDistance0To5 = "5";
        String initialDistance6To10 = "6";
        String initialDistanceGreaterThan11 = "23";
        String updatedType = "PLANA 3 AGU";
        String updatedDistance0To5 = "8";
        String updatedDistance6To10 = "12";
        String updatedDistanceGreaterThan11 = "45";
        machineMasterPage.addMachine(machineCode, initialType, initialDistance0To5, initialDistance6To10, initialDistanceGreaterThan11);
        machineMasterPage.editMachine(machineCode, updatedType, updatedDistance0To5, updatedDistance6To10, updatedDistanceGreaterThan11);
        machineMasterPage.validateMachine(machineCode, updatedDistance0To5, updatedDistance6To10, updatedDistanceGreaterThan11);
        machineMasterPage.deleteMachine(machineCode);
    }
}
