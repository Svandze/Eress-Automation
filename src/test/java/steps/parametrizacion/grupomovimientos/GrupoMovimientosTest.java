package steps.parametrizacion.grupomovimientos;

import org.junit.Before;
import org.junit.Test;
import pages.parametrizacion.ConfeccionPage;
import pages.parametrizacion.ParametrizacionPage;
import pages.parametrizacion.grupomovimientos.GrupoMovimientos;
import steps.BaseTestSeress;


import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomMachineCode;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class GrupoMovimientosTest extends BaseTestSeress {


    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private GrupoMovimientos grupoMovimientos;

    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        grupoMovimientos = new GrupoMovimientos();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        waitAndClick(parametrizacionPage.grupoMovimientosIcon);
    }

    @Test
    public void MovementsGruopManagementTest() throws InterruptedException {
        String movementGroupCode = randomMachineCode();
        String movementGruopDescription = "Test";
        String updateMovementGroupCode = randomMachineCode();
        String updatedMovementGruopDescription = "Update Test";
        grupoMovimientos.addMovementGroupCode(movementGroupCode,movementGruopDescription);
        grupoMovimientos.editMovementGroup(movementGroupCode,updateMovementGroupCode,updatedMovementGruopDescription);
        grupoMovimientos.validateMovementGroup(updateMovementGroupCode,updateMovementGroupCode,updatedMovementGruopDescription);
        grupoMovimientos.deleteMovementGroup(updateMovementGroupCode);

    }
}
