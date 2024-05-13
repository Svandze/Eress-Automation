package co.com.automation.steps.making.parameterization.movementgroup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.parameterization.MakingPageEress;
import co.com.automation.pages.making.parameterization.ParameterizationPageEress;
import co.com.automation.pages.making.parameterization.movementgroup.MovementGroupPageEress;
import co.com.automation.steps.BaseTestEress;


import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class MovementGroupTest extends BaseTestEress {


    private MakingPageEress makingPage;
    private ParameterizationPageEress parameterizationPage;
    private MovementGroupPageEress grupoMovimientos;

    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPageEress();
        parameterizationPage = new ParameterizationPageEress();
        grupoMovimientos = new MovementGroupPageEress();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        waitAndClick(parameterizationPage.grupoMovimientosIcon);
    }

    @Test
    public void MovementsGroupManagementTest() {
        String movementGroupCode = randomCode();
        String movementGroupDescription = "Test";
        String updateMovementGroupCode = randomCode();
        String updatedMovementGruopDescription = "Update Test";
        grupoMovimientos.addMovementGroup(movementGroupCode,movementGroupDescription);
        grupoMovimientos.editMovementGroup(movementGroupCode,updateMovementGroupCode,updatedMovementGruopDescription);
        grupoMovimientos.validateMovementGroup(updateMovementGroupCode,updateMovementGroupCode,updatedMovementGruopDescription);
        grupoMovimientos.deleteMovementGroup(updateMovementGroupCode);
    }
}
