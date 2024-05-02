package co.com.automation.steps.making.parameterization.conceptcostsandexpenses;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import co.com.automation.pages.making.parameterization.MakingPage;
import co.com.automation.pages.making.parameterization.ParameterizationPage;
import co.com.automation.pages.making.parameterization.conceptcostsandexpenses.ConceptOfCostsAndExpensesPage;

import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;
import static utils.ElementUtils.clickWithJavaScript;

public class ConceptCostsAndExpensesTest extends BaseTestEress {
    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private ConceptOfCostsAndExpensesPage conceptOfCostsAndExpensesPage;

    @Before
    public void setup() {
        super.setup();
        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        conceptOfCostsAndExpensesPage = new ConceptOfCostsAndExpensesPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        implicitWait();
        clickWithJavaScript(parameterizationPage.conceptoCostosGastosIcon);
    }

    @Ignore
    @Test
    public void conceptsCostsExpensesManagementTest() {
        String conceptsCostsExpensesCode = randomCode();
        String updateConceptsCostsExpensesCode = randomCode();
        String updateconceptsCostsExpensesConcept = randomCode();
        String updatedConceptsCostsExpensesGroup = "Costos indirectos";
        conceptOfCostsAndExpensesPage.addConceptCostsExpenses("Costos directos", conceptsCostsExpensesCode, "Test");
        conceptOfCostsAndExpensesPage.editConceptCostsExpenses(conceptsCostsExpensesCode, updatedConceptsCostsExpensesGroup, updateConceptsCostsExpensesCode, updateconceptsCostsExpensesConcept);
        conceptOfCostsAndExpensesPage.validateConceptCostsExpenses(updatedConceptsCostsExpensesGroup, updateConceptsCostsExpensesCode, updateconceptsCostsExpensesConcept);
        conceptOfCostsAndExpensesPage.deleteConceptCostsExpenses(updateConceptsCostsExpensesCode);
    }
}
