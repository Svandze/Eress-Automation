package co.com.automation.steps.making.costandexpenses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.costsandexpenses.CostAndExpensesPage;
import co.com.automation.pages.making.parameterization.MakingPage;
import co.com.automation.pages.making.parameterization.ParameterizationPage;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class CostAndExpensesTest extends BaseTestEress {

    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private CostAndExpensesPage costAndExpensesPage;


    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        costAndExpensesPage = new CostAndExpensesPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.costExpensesIcon);
    }

    @Test
    public void costExpensesManagementTest()  {
        String costExpensesWorkShop = "Taller para Test E2E";
        int year = 2027;
        String costExpensesGroupCost = "Costos directos";
        String costExpensesConcept = "Concepto 2";
        String costExpensesValue = "200";
        costAndExpensesPage.addCostExpenses(costExpensesWorkShop ,2027,"Costos indirectos", "Concepto 1", 2027, "150");
        costAndExpensesPage.editCostExpenses(costExpensesWorkShop, costExpensesWorkShop, 0, costExpensesGroupCost, costExpensesConcept, year, costExpensesValue);
        costAndExpensesPage.validateCostExpenses(costExpensesWorkShop,  0, costExpensesGroupCost, costExpensesConcept, year, costExpensesValue);
        costAndExpensesPage.deleteCostExpenses(costExpensesWorkShop);
    }
}
