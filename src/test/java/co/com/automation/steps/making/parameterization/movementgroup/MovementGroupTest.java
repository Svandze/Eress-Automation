package co.com.automation.steps.making.parameterization.movementgroup;

import org.junit.Before;
import org.junit.Test;
import co.com.automation.pages.making.parameterization.MakingPage;
import co.com.automation.pages.making.parameterization.ParameterizationPage;
import co.com.automation.pages.making.parameterization.movementgroup.MovementGroupPage;
import co.com.automation.steps.BaseTestEress;


import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class MovementGroupTest extends BaseTestEress {


    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private MovementGroupPage grupoMovimientos;

    @Before
    public void setup() {
        super.setup();
        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        grupoMovimientos = new MovementGroupPage();
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
