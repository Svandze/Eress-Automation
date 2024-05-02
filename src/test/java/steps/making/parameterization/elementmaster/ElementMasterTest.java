package steps.making.parameterization.elementmaster;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import pages.making.parameterization.MakingPage;
import pages.making.parameterization.ParameterizationPage;

import pages.making.parameterization.elementmaster.ElementMasterPage;
import steps.BaseTestEress;

import static org.example.constants.EressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;

public class ElementMasterTest extends BaseTestEress {



    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private ElementMasterPage elementMasterPage;

    @Before
    public void setup() {
        super.setup();

        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        elementMasterPage = new ElementMasterPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        scrollToElement(parameterizationPage.maestroElementosoIcon);
        waitAndClick(parameterizationPage.maestroElementosoIcon);
    }

    @Test
    public void MovementsGroupManagementTest() {
        Faker faker = new Faker();
        String masterElementsCode = randomCode();
        String masterElementsCodeUpdated = randomCode();
        String masterElementsDescriptionUpdated = faker.business() + "Test";
        String masterElementsGroupMovementsUpdated = "CUT";
        String masterElementsTypeMovmentsUpdated = "MAQUINA";
        String masterElementsDistanceUpdated = "D00";
        String masterElementsTimeUpdated = String.valueOf(faker.number().randomDigit());
        Boolean masterElementesCheck = true;
        elementMasterPage.addMasterElements(masterElementsCode,faker.business() + "Test","CUT","MAQUINA","D00", String.valueOf(faker.number().randomDigit()), false);
        elementMasterPage.editMasterElements(masterElementsCode,masterElementsCodeUpdated,masterElementsDescriptionUpdated, masterElementsGroupMovementsUpdated, masterElementsTypeMovmentsUpdated, masterElementsDistanceUpdated, masterElementsTimeUpdated, masterElementesCheck);
        elementMasterPage.validateMasterElements(masterElementsCodeUpdated,masterElementsDescriptionUpdated, masterElementsGroupMovementsUpdated, masterElementsTypeMovmentsUpdated, masterElementsDistanceUpdated, masterElementsTimeUpdated, masterElementesCheck);
        elementMasterPage.deleteMasterElements(masterElementsCodeUpdated);
    }
}
