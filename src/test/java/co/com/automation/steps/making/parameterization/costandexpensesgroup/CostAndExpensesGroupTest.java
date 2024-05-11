package co.com.automation.steps.making.parameterization.costandexpensesgroup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.parameterization.MakingPageEress;
import co.com.automation.pages.making.parameterization.ParameterizationPageEress;
import co.com.automation.pages.making.parameterization.costandexpensesgroup.CostAndExpensesGroupPageEress;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;

public class CostAndExpensesGroupTest extends BaseTestEress {

    private MakingPageEress makingPage;
    private ParameterizationPageEress parameterizationPage;
    private CostAndExpensesGroupPageEress costAndExpensesGroupPage;

    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPageEress();
        parameterizationPage = new ParameterizationPageEress();
        costAndExpensesGroupPage = new CostAndExpensesGroupPageEress();
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
