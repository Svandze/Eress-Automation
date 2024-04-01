package steps.parametrizacion.maestroclientes;

import org.junit.Before;
import org.junit.Test;
import pages.parametrizacion.ConfeccionPage;
import pages.parametrizacion.ParametrizacionPage;
import pages.parametrizacion.maestroclientes.MaestroClientes;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomMachineCode;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class MaestroClientesTest extends BaseTestSeress {


    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private MaestroClientes maestroClientes;

    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        maestroClientes  = new MaestroClientes();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        waitAndClick(parametrizacionPage.maestroClientesIcon);
    }

    @Test
    public void MovementsGruopManagementTest() throws InterruptedException {
        String masterCustomerCod = randomMachineCode();
        String masterCustomerDocumentType = "CC";
        String masterCustomerDocument = "CodTest";
        String masterCustomerBusinessName = "RazonSocialTest" ;
        String masterCustomerFirstName = "PrimerNombreTest" ;
        String masterCustomerSecondName = "SegundoNombreTest" ;
        String masterCustomerLastName = "ApellidoTest" ;
        String masterCustomerSecondLastName = "SegundoApellidoTest" ;
        String masterCustomerAddressnOne = "DireccionUnoTest" ;
        String masterCustomerAddressnTwo = "DireccionDosTest" ;
        String masterCustomerPhoneOne = "TelefonoUnoTest" ;
        String masterCustomerPhoneTwo = "TelefonoDosTest" ;
        String masterCustomerEmail= "Email@test.com" ;
        String masterCustomerRegion = "Medellin" ;
        String masterCustomerCodUpdate = randomMachineCode();
        String masterCustomerDocumentTypeUpdate = "NIT";
        String masterCustomerDocumentUpdate = "CodTestUpdate";
        String masterCustomerBusinessNameUpdate = "RazonSocialTestUpdate" ;
        String masterCustomerFirstNameUpdate = "PrimerNombreTestUpdate" ;
        String masterCustomerSecondNameUpdate = "SegundoNombreTestUpdate" ;
        String masterCustomerLastNameUpdate = "ApellidoTestUpdateUpdate" ;
        String masterCustomerSecondLastNameUpdate = "SegundoApellidoTestUpdateUpdate" ;
        String masterCustomerAddressnOneUpdate = "DireccionUnoTestUpdate" ;
        String masterCustomerAddressnTwoUpdate = "DireccionDosTestUpdate" ;
        String masterCustomerPhoneOneUpdate = "TelefonoUnoTestUpdate" ;
        String masterCustomerPhoneTwoUpdate = "TelefonoDosTestUpdate" ;
        String masterCustomerEmailUpdate= "Email@test.comUpdate" ;
        String masterCustomerRegionUpdate = "La estrella" ;
        maestroClientes.addMasterCustomer(masterCustomerCod,
                masterCustomerDocumentType,
                masterCustomerDocument,
                masterCustomerBusinessName,
                masterCustomerFirstName,
                masterCustomerSecondName,
                masterCustomerLastName,
                masterCustomerSecondLastName,
                masterCustomerAddressnOne,
                masterCustomerAddressnTwo,
                masterCustomerPhoneOne,
                masterCustomerPhoneTwo,
                masterCustomerEmail,
                masterCustomerRegion);
         maestroClientes.editMasterCustomerName(masterCustomerCod,masterCustomerCodUpdate,
                masterCustomerDocumentTypeUpdate,
                masterCustomerDocumentUpdate,
                masterCustomerBusinessNameUpdate,
                masterCustomerFirstNameUpdate,
                masterCustomerSecondNameUpdate,
                masterCustomerLastNameUpdate,
                masterCustomerSecondLastNameUpdate,
                masterCustomerAddressnOneUpdate,
                masterCustomerAddressnTwoUpdate,
                masterCustomerPhoneOneUpdate,
                masterCustomerPhoneTwoUpdate,
                masterCustomerEmailUpdate,
                masterCustomerRegionUpdate);
        maestroClientes.validateMovementGroup(masterCustomerCodUpdate,
                masterCustomerDocumentTypeUpdate,
                masterCustomerDocumentUpdate,
                masterCustomerBusinessNameUpdate,
                masterCustomerFirstNameUpdate,
                masterCustomerSecondNameUpdate,
                masterCustomerLastNameUpdate,
                masterCustomerSecondLastNameUpdate,
                masterCustomerAddressnOneUpdate,
                masterCustomerAddressnTwoUpdate,
                masterCustomerPhoneOneUpdate,
                masterCustomerPhoneTwoUpdate,
                masterCustomerEmailUpdate,
                masterCustomerRegionUpdate);
        maestroClientes.deleteMasterCustomer(masterCustomerCodUpdate);

    }



}
