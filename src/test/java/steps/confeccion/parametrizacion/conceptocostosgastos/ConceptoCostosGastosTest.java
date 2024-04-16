package steps.confeccion.parametrizacion.conceptocostosgastos;


import org.junit.Before;
import org.junit.Test;
import pages.confeccion.parametrizacion.ConfeccionPage;
import pages.confeccion.parametrizacion.ParametrizacionPage;
import pages.confeccion.parametrizacion.conceptocostosgastos.ConceptosCostosGastosPage;

import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomCode;
import static utils.ElementUtils.*;
import static utils.ElementUtils.clickWithJavaScript;

public class ConceptoCostosGastosTest extends BaseTestSeress {
    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private ConceptosCostosGastosPage conceptosCostosGastosPage;

    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        conceptosCostosGastosPage = new ConceptosCostosGastosPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        implicitWait();
        clickWithJavaScript(parametrizacionPage.conceptoCostosGastosIcon);
    }

    @Test
    public void conceptsCostsExpensesManagementTest() {
        String conceptsCostsExpensesCode = randomCode();
        String updateConceptsCostsExpensesCode = randomCode();
        String updateconceptsCostsExpensesConcept = randomCode();
        String updatedConceptsCostsExpensesGroup = "Update Test";
        conceptosCostosGastosPage.addConceptCostsExpenses("Costos directos", conceptsCostsExpensesCode, "Test");
        conceptosCostosGastosPage.editConceptCostsExpenses(conceptsCostsExpensesCode, updatedConceptsCostsExpensesGroup, updateConceptsCostsExpensesCode, updateconceptsCostsExpensesConcept);
        conceptosCostosGastosPage.validateConceptCostsExpenses(updatedConceptsCostsExpensesGroup, updateConceptsCostsExpensesCode, updateconceptsCostsExpensesConcept);
        conceptosCostosGastosPage.deleteConceptCostsExpenses(updateConceptsCostsExpensesCode);
    }
}
