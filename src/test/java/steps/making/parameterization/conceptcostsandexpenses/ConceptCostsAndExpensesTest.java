package steps.making.parameterization.conceptcostsandexpenses;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import pages.making.parameterization.MakingPage;
import pages.making.parameterization.ParameterizationPage;
import pages.making.parameterization.conceptcostsandexpenses.ConceptOfCostsAndExpensesPage;

import steps.BaseTestEress;

import static org.example.constants.EressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.randomCodeBuilder.randomCode;
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
