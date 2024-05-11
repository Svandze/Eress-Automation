package co.com.automation.steps.making.parameterization.machinemaster;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import co.com.automation.pages.making.parameterization.MakingPageEress;
import co.com.automation.pages.making.parameterization.ParameterizationPageEress;
import co.com.automation.pages.making.parameterization.machinemaster.MachineMasterPageEress;
import co.com.automation.steps.BaseTestEress;
import org.junit.jupiter.api.Test;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class MachineMasterTest extends BaseTestEress {

    private MakingPageEress makingPage;
    private ParameterizationPageEress parameterizationPage;
    private MachineMasterPageEress machineMasterPage;

    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPageEress();
        parameterizationPage = new ParameterizationPageEress();
        machineMasterPage = new MachineMasterPageEress();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        waitAndClick(parameterizationPage.maestroDeMaquinasIcon);
    }

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
