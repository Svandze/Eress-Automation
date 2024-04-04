package steps.confeccion.parametrizacion.tiposmovimientos;

import org.junit.Before;
import org.junit.Test;
import pages.confeccion.parametrizacion.ConfeccionPage;
import pages.confeccion.parametrizacion.ParametrizacionPage;
import pages.confeccion.parametrizacion.tipomovimientos.TipoMovimientosPage;
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
    public void TypesMovementsManagementsTest() {
        String typesMovementsCode = randomCode();
        String typesMovementsDescription = "Test";
        Boolean typesMovementsCheck = false;
        String updateTypesMovementsCode = randomCode();
        String updatedTypesMovementsDescription = "Update Test";
        Boolean updatedTypesMovementsCheck = true;

        tipoMovimientosPage.addTypesMovements(typesMovementsCode, typesMovementsDescription, typesMovementsCheck);
        tipoMovimientosPage.editTypesMovements(typesMovementsCode, updateTypesMovementsCode, updatedTypesMovementsDescription, updatedTypesMovementsCheck);
        tipoMovimientosPage.validateTypesMovements(updateTypesMovementsCode,updateTypesMovementsCode, updatedTypesMovementsDescription, updatedTypesMovementsCheck);
        tipoMovimientosPage.deleteTypesMovements(updateTypesMovementsCode);
    }
}
