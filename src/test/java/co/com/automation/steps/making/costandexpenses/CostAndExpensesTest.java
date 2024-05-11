package co.com.automation.steps.making.costandexpenses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.costsandexpenses.CostAndExpensesPageEress;
import co.com.automation.pages.making.parameterization.MakingPageEress;
import co.com.automation.pages.making.parameterization.ParameterizationPageEress;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class CostAndExpensesTest extends BaseTestEress {

    private MakingPageEress makingPage;
    private ParameterizationPageEress parameterizationPage;
    private CostAndExpensesPageEress costAndExpensesPage;


    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPageEress();
        parameterizationPage = new ParameterizationPageEress();
        costAndExpensesPage = new CostAndExpensesPageEress();
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
