package co.com.automation.steps.making.operations;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.operations.OperationsPage;
import co.com.automation.pages.making.parameterization.MakingPage;
import co.com.automation.pages.making.parameterization.ParameterizationPage;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class OperationsMasterTest extends BaseTestEress {
    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private OperationsPage operationsPage;


    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        operationsPage = new OperationsPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.operacionesIcon);
    }


    @Disabled
    @Test
    public void operationManagementTest()  {
        Faker faker = new Faker();
        String operationCode = randomCode();
        String operationDescription = "Test";
        String updateOperationCode = randomCode();
        String updatedOperationDescription = "Update Test";
        operationsPage.addOperations(operationCode,operationDescription,"PL1A","4", "6","GD00",  "Pruebas QA", "Pruebas QA", "", "", "");
        operationsPage.editOperations(operationCode,updateOperationCode,updatedOperationDescription,"FPS","6", "4", "GD10","Admin","Admin","" ,"","");
        operationsPage.validateOperations(updateOperationCode, updatedOperationDescription,"FPS","6", "4", "GD10","Admin","Admin","" ,"","");
        operationsPage.deleteOperations(updateOperationCode);
    }
}
