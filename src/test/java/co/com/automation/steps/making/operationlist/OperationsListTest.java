package co.com.automation.steps.making.operationlist;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.operationlist.OperationListPageEress;
import co.com.automation.pages.making.parameterization.MakingPageEress;
import co.com.automation.pages.making.parameterization.ParameterizationPageEress;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class OperationsListTest extends BaseTestEress {

    private MakingPageEress makingPage;
    private ParameterizationPageEress parameterizationPage;
    private OperationListPageEress operationListPage;


    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPageEress();
        parameterizationPage = new ParameterizationPageEress();
        operationListPage = new OperationListPageEress();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.operationListIcon);
    }

    @Disabled
    @Test
    public void operationsListManagementTest()  {
        Faker faker = new Faker();
        String operationListCode = randomCode();
        String operationListName = faker.name().username();
        String updateOperationListCode = randomCode();
        String updateOperationListName = faker.name().username();
        String updateOperationListCustomer = "LUIS LONDONO";
        String updateOperationListReference = "CAMISETA BASICA BLANCA";
        String updateOperationListElaborate = "Enequipo";
        String updateOperationListAprobate = "Pruebas QA";
        String updateOperationListOperation = "COSER Y UNIR A MANO";
        operationListPage.addOperationsList(operationListCode, operationListName, "LUIS LONDONO","CAMISETA NEGRA ESTAMPADA", "admin", "admin", "UNIR HOMBROS");
        operationListPage.editOperationsList(operationListCode, updateOperationListCode,updateOperationListName, updateOperationListCustomer,updateOperationListReference, updateOperationListElaborate, updateOperationListAprobate, updateOperationListOperation);
        operationListPage.validateOperationsList(updateOperationListCode, updateOperationListName, updateOperationListCustomer,updateOperationListReference, updateOperationListElaborate, updateOperationListAprobate, updateOperationListOperation);
        operationListPage.deleteOperationsList(updateOperationListCode);
    }
}
