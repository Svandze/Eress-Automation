package steps.parametrizacion.tiposmovimientos;

import org.junit.Before;
import org.junit.Test;
import pages.parametrizacion.ConfeccionPage;
import pages.parametrizacion.ParametrizacionPage;
import pages.parametrizacion.gradodificultad.GradoDificultadPage;
import pages.parametrizacion.tipomovimientos.TipoMovimientosPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomCode;
import static utils.ElementUtils.*;
import static utils.ElementUtils.waitAndClick;

public class TiposMovimientos extends BaseTestSeress {

    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private TipoMovimientosPage tipoMovimientosPage;

    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        tipoMovimientosPage = new TipoMovimientosPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        ScrollToElement(parametrizacionPage.tipoMovimientoIcon);
        waitAndClick(parametrizacionPage.tipoMovimientoIcon);
    }

    @Test
    public void MovementsGruopManagementTest() {
        String typesMovementsCode = randomCode();
        String typesMovementsDescription = "Test";
        Boolean typesMovementsCheck = true;
        String updateTypesMovementsCode = randomCode();
        String updatedTypesMovementsDescription = "Update Test";
        Boolean updatedTypesMovementsCheck = false;

        tipoMovimientosPage.addTypesMovements(typesMovementsCode, typesMovementsDescription, typesMovementsCheck);
        tipoMovimientosPage.editTypesMovements(typesMovementsCode, updateTypesMovementsCode, updatedTypesMovementsDescription, updatedTypesMovementsCheck);
        tipoMovimientosPage.validateTypesMovements(updateTypesMovementsCode,updateTypesMovementsCode, updatedTypesMovementsDescription, updatedTypesMovementsCheck);
        tipoMovimientosPage.deleteTypesMovements(updateTypesMovementsCode);
    }
}
