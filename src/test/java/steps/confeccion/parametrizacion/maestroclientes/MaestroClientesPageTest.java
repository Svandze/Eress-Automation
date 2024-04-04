package steps.confeccion.parametrizacion.maestroclientes;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import pages.confeccion.parametrizacion.ConfeccionPage;
import pages.confeccion.parametrizacion.ParametrizacionPage;
import pages.confeccion.parametrizacion.maestroclientes.MaestroClientesPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomCode;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class MaestroClientesPageTest extends BaseTestSeress {


    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private MaestroClientesPage maestroClientesPage;

    private Faker faker;

    @Before
    public void setup() {
        super.setup();
        faker = new Faker();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        maestroClientesPage = new MaestroClientesPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        waitAndClick(parametrizacionPage.maestroClientesIcon);
    }

    @Test
    public void masterCustomerManagementTest() {
        String masterCustomerCod = randomCode();
        String masterCustomerCodUpdate = randomCode();
        String masterCustomerDocumentTypeUpdated = "NIT";
        String masterCustomerDocumentUpdated = faker.number().digits(8) + "Test";
        String masterCustomerBusinessNameUpdated = faker.company().name();
        String masterCustomerFirstNameUpdated = faker.name().firstName();
        String masterCustomerSecondNameUpdated = faker.name().firstName();
        String masterCustomerLastNameUpdated = faker.name().lastName();
        String masterCustomerSecondLastNameUpdated = faker.name().lastName();
        String masterCustomerAddressnOneUpdated = faker.address().streetAddress();
        String masterCustomerAddressnTwoUpdated = faker.address().secondaryAddress();
        String masterCustomerPhoneOneUpdated = faker.phoneNumber().phoneNumber();
        String masterCustomerPhoneTwoUpdated = faker.phoneNumber().phoneNumber();
        String masterCustomerEmailUpdated = faker.internet().emailAddress();
        String masterCustomerRegionUpdated = "LA ESTRELLA";
        maestroClientesPage.addMasterCustomer(masterCustomerCod, "CC", faker.number().digits(8) + "CodTest", faker.company().name(), faker.name().firstName(), faker.name().firstName(), faker.name().lastName(), faker.name().lastName(), faker.address().streetAddress(), faker.address().secondaryAddress(), faker.phoneNumber().phoneNumber(), faker.phoneNumber().phoneNumber(), faker.internet().emailAddress(), "MEDELLIN");
        maestroClientesPage.editMasterCustomerName(masterCustomerCod, masterCustomerCodUpdate, masterCustomerDocumentTypeUpdated, masterCustomerDocumentUpdated, masterCustomerBusinessNameUpdated, masterCustomerFirstNameUpdated, masterCustomerSecondNameUpdated, masterCustomerLastNameUpdated, masterCustomerSecondLastNameUpdated, masterCustomerAddressnOneUpdated, masterCustomerAddressnTwoUpdated, masterCustomerPhoneOneUpdated, masterCustomerPhoneTwoUpdated, masterCustomerEmailUpdated, masterCustomerRegionUpdated);
        maestroClientesPage.validateMovementGroup(masterCustomerCodUpdate, masterCustomerDocumentTypeUpdated, masterCustomerDocumentUpdated, masterCustomerBusinessNameUpdated, masterCustomerFirstNameUpdated, masterCustomerSecondNameUpdated, masterCustomerLastNameUpdated, masterCustomerSecondLastNameUpdated, masterCustomerAddressnOneUpdated, masterCustomerAddressnTwoUpdated, masterCustomerPhoneOneUpdated, masterCustomerPhoneTwoUpdated, masterCustomerEmailUpdated, masterCustomerRegionUpdated);
        maestroClientesPage.deleteMasterCustomer(masterCustomerCodUpdate);
    }
}
