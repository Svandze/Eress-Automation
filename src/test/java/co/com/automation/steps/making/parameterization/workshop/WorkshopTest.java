package co.com.automation.steps.making.parameterization.workshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.parameterization.MakingPageEress;
import co.com.automation.pages.making.parameterization.ParameterizationPageEress;
import co.com.automation.pages.making.parameterization.workshop.WorkshopPageEress;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;
import static utils.ElementUtils.waitAndClick;

public class WorkshopTest extends BaseTestEress {

    private MakingPageEress makingPage;
    private ParameterizationPageEress parameterizationPage;
    private WorkshopPageEress workshopPage;

    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPageEress();
        parameterizationPage = new ParameterizationPageEress();
        workshopPage = new WorkshopPageEress();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        scrollToElement(parameterizationPage.tipoMovimientoIcon);
        waitAndClick(parameterizationPage.tallerIcon);
    }

    @Disabled
    @Test
    public void workshopManagementsTest() {
        String workshopCod = randomCode();
        String updateCustomerWorkshop = "NOMBRE1";
        String updateWorkshopCode = randomCode();
        String updatedWorkshopDescription = "Update Test";
        String updateWorkshopOTIF = "12.0000";
        String updateWorkshopPersons = "2";
        String updateWorkshopStyle = "PANT";
        String updateWorkshopMachine = "PL1AE";
        String updateWorkshopAmount = "2";
        workshopPage.addWorkshop("LUIS LONDONO", workshopCod, "Descripcion Test", "5", "2", "CAM", "PL1A", "10");
        workshopPage.editWorkshop(workshopCod, updateCustomerWorkshop, updateWorkshopCode, updatedWorkshopDescription, updateWorkshopOTIF, updateWorkshopPersons, updateWorkshopStyle, updateWorkshopMachine, updateWorkshopAmount);
        workshopPage.validateWorkshop(updateCustomerWorkshop, updateWorkshopCode, updatedWorkshopDescription, updateWorkshopOTIF, updateWorkshopPersons, updateWorkshopStyle, updateWorkshopMachine, updateWorkshopAmount);
        workshopPage.deleteWorkshop(updateWorkshopCode);
    }
}
