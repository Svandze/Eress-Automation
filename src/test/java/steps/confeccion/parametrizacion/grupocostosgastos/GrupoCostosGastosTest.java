package steps.confeccion.parametrizacion.grupocostosgastos;

import org.junit.Before;
import org.junit.Test;
import pages.making.parametrizacion.ConfeccionPage;
import pages.making.parametrizacion.ParametrizacionPage;
import pages.making.parametrizacion.grupocostosgastos.GrupoCostosGastosPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomCode;
import static utils.ElementUtils.*;

public class GrupoCostosGastosTest extends BaseTestSeress {

    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private GrupoCostosGastosPage grupoCostosGastosPage;

    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        grupoCostosGastosPage = new GrupoCostosGastosPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        clickWithJavaScript(parametrizacionPage.grupoCostosGastosIcon);
    }

    @Test
    public void MovementsGroupManagementTest() {
        String costExpenseGroupsCode = randomCode();
        String updatedCostExpenseGroupsCode = randomCode();
        String updatedCostExpenseGroupsDescription = "Costos y gastos Update Test";

        grupoCostosGastosPage.addCostExpenseGroups(costExpenseGroupsCode, "Costos y gastos test");
        grupoCostosGastosPage.editCostExpenseGroups(costExpenseGroupsCode, updatedCostExpenseGroupsCode, updatedCostExpenseGroupsDescription);
        grupoCostosGastosPage.validateCostExpenseGroups(updatedCostExpenseGroupsCode, updatedCostExpenseGroupsCode, updatedCostExpenseGroupsDescription);
        grupoCostosGastosPage.deleteCostExpenseGroups(updatedCostExpenseGroupsCode);
    }
}
