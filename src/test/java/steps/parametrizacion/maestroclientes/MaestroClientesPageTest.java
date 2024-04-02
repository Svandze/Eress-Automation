package steps.parametrizacion.maestroclientes;

import org.junit.Before;
import org.junit.Test;
import pages.parametrizacion.ConfeccionPage;
import pages.parametrizacion.ParametrizacionPage;
import pages.parametrizacion.maestroclientes.MaestroClientesPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomCode;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class MaestroClientesPageTest extends BaseTestSeress {


    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private MaestroClientesPage maestroClientesPage;

    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        maestroClientesPage = new MaestroClientesPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        waitAndClick(parametrizacionPage.maestroClientesIcon);
    }

    @Test
    public void masterCustomerManagementTest() throws InterruptedException {
        String masterCustomerCod = randomCode();
        String masterCustomerDocumentType = "CC";
        String masterCustomerDocument = randomCode() + "CodTest" ;
        String masterCustomerBusinessName = "RazonSocialTest" ;
        String masterCustomerFirstName = "PrimerNombreTest" ;
        String masterCustomerSecondName = "SegundoNombreTest" ;
        String masterCustomerLastName = "ApellidoTest" ;
        String masterCustomerSecondLastName = "SegundoApellidoTest" ;
        String masterCustomerAddressnOne = "DireccionUnoTest" ;
        String masterCustomerAddressnTwo = "DireccionDosTest" ;
        String masterCustomerPhoneOne = "TelefonoUnoTest" ;
        String masterCustomerPhoneTwo = "TelefonoDosTest" ;
        String masterCustomerEmail= "Email12@"+randomCode()+".com" ;
        String masterCustomerRegion = "La estrella" ;
        String masterCustomerCodUpdate = randomCode();
        String masterCustomerDocumentTypeUpdate = "NIT";
        String masterCustomerDocumentUpdate = randomCode() + "CodTestUpdate" ;
        String masterCustomerBusinessNameUpdate = "RazonSocialTestUpdate" ;
        String masterCustomerFirstNameUpdate = "PrimerNombreTestUpdate" ;
        String masterCustomerSecondNameUpdate = "SegundoNombreTestUpdate" ;
        String masterCustomerLastNameUpdate = "ApellidoTestUpdateUpdate" ;
        String masterCustomerSecondLastNameUpdate = "SegundoApellidoTestUpdateUpdate" ;
        String masterCustomerAddressnOneUpdate = "DireccionUnoTestUpdate" ;
        String masterCustomerAddressnTwoUpdate = "DireccionDosTestUpdate" ;
        String masterCustomerPhoneOneUpdate = "TelefonoUnoTestUpdate" ;
        String masterCustomerPhoneTwoUpdate = "TelefonoDosTestUpdate" ;
        String masterCustomerEmailUpdate= "Email1@"+randomCode()+".comUpdate";
        String masterCustomerRegionUpdate = "La estrella" ;
        maestroClientesPage.addMasterCustomer(masterCustomerCod,
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
         maestroClientesPage.editMasterCustomerName(masterCustomerCod,masterCustomerCodUpdate,
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
        maestroClientesPage.validateMovementGroup(masterCustomerCodUpdate,
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
        maestroClientesPage.deleteMasterCustomer(masterCustomerCodUpdate);

    }



}
