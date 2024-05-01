package steps.confeccion.costosygastos;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import pages.making.costsandexpenses.CostosGastosPage;
import pages.making.parametrizacion.ConfeccionPage;
import pages.making.parametrizacion.ParametrizacionPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class CostosGastosTest extends BaseTestSeress {

    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private CostosGastosPage costosGastosPage;


    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        costosGastosPage= new CostosGastosPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.costExpensesIcon);
    }

    @Test
    public void costExpensesManagementTest()  {
        String costExpensesWorkShop = "Taller para Test E2E";
        int year = 2027;
        String costExpensesGroupCost = "Costos directos";
        String costExpensesConcept = "Concepto 2";
        String costExpensesValue = "200";
        costosGastosPage.addCostExpenses(costExpensesWorkShop ,2027,"Costos indirectos", "Concepto 1", 2027, "150");
        costosGastosPage.editCostExpenses(costExpensesWorkShop, costExpensesWorkShop, 0, costExpensesGroupCost, costExpensesConcept, year, costExpensesValue);
        costosGastosPage.validateCostExpenses(costExpensesWorkShop,  0, costExpensesGroupCost, costExpensesConcept, year, costExpensesValue);
        costosGastosPage.deleteCostExpenses(costExpensesWorkShop);
    }
}
