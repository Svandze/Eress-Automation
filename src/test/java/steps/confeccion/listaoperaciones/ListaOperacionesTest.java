package steps.confeccion.listaoperaciones;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import pages.making.listaoperaciones.ListaOperacionesPage;
import pages.making.parametrizacion.ConfeccionPage;
import pages.making.parametrizacion.ParametrizacionPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomCode;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class ListaOperacionesTest extends BaseTestSeress {

    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private ListaOperacionesPage listaOperacionesPage;


    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        listaOperacionesPage= new ListaOperacionesPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.operationListIcon);
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
        listaOperacionesPage.addOperationsList(operationListCode, operationListName, "LUIS LONDONO","CAMISETA NEGRA ESTAMPADA", "admin", "admin", "UNIR HOMBROS");
        listaOperacionesPage.editOperationsList(operationListCode, updateOperationListCode,updateOperationListName, updateOperationListCustomer,updateOperationListReference, updateOperationListElaborate, updateOperationListAprobate, updateOperationListOperation);
        listaOperacionesPage.validateOperationsList(updateOperationListCode, updateOperationListName, updateOperationListCustomer,updateOperationListReference, updateOperationListElaborate, updateOperationListAprobate, updateOperationListOperation);
        listaOperacionesPage.deleteOperationsList(updateOperationListCode);
    }
}
