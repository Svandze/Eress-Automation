package co.com.automation.steps.making.parameterization.clientmaster;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.parameterization.MakingPage;
import co.com.automation.pages.making.parameterization.ParameterizationPage;
import co.com.automation.pages.making.parameterization.clientmaster.ClientMasterPage;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class ClientMasterTest extends BaseTestEress {


    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private ClientMasterPage clientMasterPage;

    private Faker faker;

    @BeforeEach
    public void setup() {
        super.setup();
        faker = new Faker();
        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        clientMasterPage = new ClientMasterPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        waitAndClick(parameterizationPage.maestroClientesIcon);
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
        clientMasterPage.addMasterCustomer(masterCustomerCod, "CC", faker.number().digits(8) + "CodTest", faker.company().name(), faker.name().firstName(), faker.name().firstName(), faker.name().lastName(), faker.name().lastName(), faker.address().streetAddress(), faker.address().secondaryAddress(), faker.phoneNumber().phoneNumber(), faker.phoneNumber().phoneNumber(), faker.internet().emailAddress(), "MEDELLIN");
        clientMasterPage.editMasterCustomerName(masterCustomerCod, masterCustomerCodUpdate, masterCustomerDocumentTypeUpdated, masterCustomerDocumentUpdated, masterCustomerBusinessNameUpdated, masterCustomerFirstNameUpdated, masterCustomerSecondNameUpdated, masterCustomerLastNameUpdated, masterCustomerSecondLastNameUpdated, masterCustomerAddressnOneUpdated, masterCustomerAddressnTwoUpdated, masterCustomerPhoneOneUpdated, masterCustomerPhoneTwoUpdated, masterCustomerEmailUpdated, masterCustomerRegionUpdated);
        clientMasterPage.validateMovementGroup(masterCustomerCodUpdate, masterCustomerDocumentTypeUpdated, masterCustomerDocumentUpdated, masterCustomerBusinessNameUpdated, masterCustomerFirstNameUpdated, masterCustomerSecondNameUpdated, masterCustomerLastNameUpdated, masterCustomerSecondLastNameUpdated, masterCustomerAddressnOneUpdated, masterCustomerAddressnTwoUpdated, masterCustomerPhoneOneUpdated, masterCustomerPhoneTwoUpdated, masterCustomerEmailUpdated, masterCustomerRegionUpdated);
        clientMasterPage.deleteMasterCustomer(masterCustomerCodUpdate);
    }
}
