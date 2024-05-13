package co.com.automation.steps.making.parameterization.conceptcostsandexpenses;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.parameterization.MakingPageEress;
import co.com.automation.pages.making.parameterization.ParameterizationPageEress;
import co.com.automation.pages.making.parameterization.conceptcostsandexpenses.ConceptOfCostsAndExpensesPageEress;

import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;
import static utils.ElementUtils.clickWithJavaScript;

public class ConceptCostsAndExpensesTest extends BaseTestEress {
    private MakingPageEress makingPage;
    private ParameterizationPageEress parameterizationPage;
    private ConceptOfCostsAndExpensesPageEress conceptOfCostsAndExpensesPage;

    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPageEress();
        parameterizationPage = new ParameterizationPageEress();
        conceptOfCostsAndExpensesPage = new ConceptOfCostsAndExpensesPageEress();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        implicitWait();
        clickWithJavaScript(parameterizationPage.conceptoCostosGastosIcon);
    }

    @Disabled
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
