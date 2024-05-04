package co.com.automation.steps.making.parameterization.costandexpensesgroup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.parameterization.MakingPage;
import co.com.automation.pages.making.parameterization.ParameterizationPage;
import co.com.automation.pages.making.parameterization.costandexpensesgroup.CostAndExpensesGroupPage;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;

public class CostAndExpensesGroupTest extends BaseTestEress {

    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private CostAndExpensesGroupPage costAndExpensesGroupPage;

    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        costAndExpensesGroupPage = new CostAndExpensesGroupPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        clickWithJavaScript(parameterizationPage.grupoCostosGastosIcon);
    }

    @Test
    public void MovementsGroupManagementTest() {
        String costExpenseGroupsCode = randomCode();
        String updatedCostExpenseGroupsCode = randomCode();
        String updatedCostExpenseGroupsDescription = "Costos y gastos Update Test";

        costAndExpensesGroupPage.addCostExpenseGroups(costExpenseGroupsCode, "Costos y gastos test");
        costAndExpensesGroupPage.editCostExpenseGroups(costExpenseGroupsCode, updatedCostExpenseGroupsCode, updatedCostExpenseGroupsDescription);
        costAndExpensesGroupPage.validateCostExpenseGroups(updatedCostExpenseGroupsCode, updatedCostExpenseGroupsCode, updatedCostExpenseGroupsDescription);
        costAndExpensesGroupPage.deleteCostExpenseGroups(updatedCostExpenseGroupsCode);
    }
}
