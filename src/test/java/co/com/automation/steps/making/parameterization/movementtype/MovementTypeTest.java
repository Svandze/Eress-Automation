package co.com.automation.steps.making.parameterization.movementtype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.parameterization.MakingPageEress;
import co.com.automation.pages.making.parameterization.ParameterizationPageEress;
import co.com.automation.pages.making.parameterization.movementtype.MovementTypePageEress;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;
import static utils.ElementUtils.waitAndClick;

public class MovementTypeTest extends BaseTestEress {

    private MakingPageEress makingPage;
    private ParameterizationPageEress parameterizationPage;
    private MovementTypePageEress movementTypePage;

    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPageEress();
        parameterizationPage = new ParameterizationPageEress();
        movementTypePage = new MovementTypePageEress();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        scrollToElement(parameterizationPage.tipoMovimientoIcon);
        waitAndClick(parameterizationPage.tipoMovimientoIcon);
    }

    @Test
    public void TypesMovementsManagementsTest() {
        String typesMovementsCode = randomCode();
        String typesMovementsDescription = "Test";
        Boolean typesMovementsCheck = true;
        String updateTypesMovementsCode = randomCode();
        String updatedTypesMovementsDescription = "Update Test";
        Boolean updatedTypesMovementsCheck = false;
        movementTypePage.addTypesMovements(typesMovementsCode, typesMovementsDescription, typesMovementsCheck);
        movementTypePage.editTypesMovements(typesMovementsCode, updateTypesMovementsCode, updatedTypesMovementsDescription, updatedTypesMovementsCheck);
        movementTypePage.validateTypesMovements(updateTypesMovementsCode,updateTypesMovementsCode, updatedTypesMovementsDescription, updatedTypesMovementsCheck);
        movementTypePage.deleteTypesMovements(updateTypesMovementsCode);
    }
}
