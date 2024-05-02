package steps.making.operationlist;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import pages.making.operationlist.OperationListPage;
import pages.making.parameterization.MakingPage;
import pages.making.parameterization.ParameterizationPage;
import steps.BaseTestEress;

import static org.example.constants.EressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class OperationsListTest extends BaseTestEress {

    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private OperationListPage operationListPage;


    @Before
    public void setup() {
        super.setup();
        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        operationListPage = new OperationListPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.operationListIcon);
    }

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
