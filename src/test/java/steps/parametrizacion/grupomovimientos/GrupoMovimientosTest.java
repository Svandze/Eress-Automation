package steps.parametrizacion.grupomovimientos;

import org.junit.Before;
import org.junit.Test;
import pages.parametrizacion.ConfeccionPage;
import pages.parametrizacion.ParametrizacionPage;
import pages.parametrizacion.grupomovimientos.GrupoMovimientosPage;
import steps.BaseTestSeress;


import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomCode;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class GrupoMovimientosTest extends BaseTestSeress {


    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private GrupoMovimientosPage grupoMovimientos;

    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        grupoMovimientos = new GrupoMovimientosPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        waitAndClick(parametrizacionPage.grupoMovimientosIcon);
    }

    @Test
    public void MovementsGruopManagementTest() throws InterruptedException {
        String movementGroupCode = randomCode();
        String movementGruopDescription = "Test";
        String updateMovementGroupCode = randomCode();
        String updatedMovementGruopDescription = "Update Test";
        grupoMovimientos.addMovementGroup(movementGroupCode,movementGruopDescription);
        grupoMovimientos.editMovementGroup(movementGroupCode,updateMovementGroupCode,updatedMovementGruopDescription);
        grupoMovimientos.validateMovementGroup(updateMovementGroupCode,updateMovementGroupCode,updatedMovementGruopDescription);
        grupoMovimientos.deleteMovementGroup(updateMovementGroupCode);

    }
}
