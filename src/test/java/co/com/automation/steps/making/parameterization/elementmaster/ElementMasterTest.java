package co.com.automation.steps.making.parameterization.elementmaster;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.parameterization.MakingPageEress;
import co.com.automation.pages.making.parameterization.ParameterizationPageEress;

import co.com.automation.pages.making.parameterization.elementmaster.ElementMasterPageEress;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;

public class ElementMasterTest extends BaseTestEress {



    private MakingPageEress makingPage;
    private ParameterizationPageEress parameterizationPage;
    private ElementMasterPageEress elementMasterPage;

    @BeforeEach
    public void setup() {
        super.setup();

        makingPage = new MakingPageEress();
        parameterizationPage = new ParameterizationPageEress();
        elementMasterPage = new ElementMasterPageEress();
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
