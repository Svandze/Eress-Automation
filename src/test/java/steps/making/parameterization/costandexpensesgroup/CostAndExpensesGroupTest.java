package steps.making.parameterization.costandexpensesgroup;

import org.junit.Before;
import org.junit.Test;
import pages.making.parameterization.MakingPage;
import pages.making.parameterization.ParameterizationPage;
import pages.making.parameterization.costandexpensesgroup.CostAndExpensesGroupPage;
import steps.BaseTestEress;

import static org.example.constants.EressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;

public class CostAndExpensesGroupTest extends BaseTestEress {

    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private CostAndExpensesGroupPage costAndExpensesGroupPage;

    @Before
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
