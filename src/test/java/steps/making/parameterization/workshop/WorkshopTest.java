package steps.making.parameterization.workshop;

import org.junit.Before;
import org.junit.Test;
import pages.making.parameterization.MakingPage;
import pages.making.parameterization.ParameterizationPage;
import pages.making.parameterization.workshop.WorkshopPage;
import steps.BaseTestEress;

import static org.example.constants.EressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;
import static utils.ElementUtils.waitAndClick;

public class WorkshopTest extends BaseTestEress {

    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private WorkshopPage workshopPage;

    @Before
    public void setup() {
        super.setup();
        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        workshopPage = new WorkshopPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        scrollToElement(parameterizationPage.tipoMovimientoIcon);
        waitAndClick(parameterizationPage.tallerIcon);
    }

    @Test
    public void workshopManagementsTest() {
        String workshopCod = randomCode();
        String updateCustomerWorkshop = "NOMBRE1";
        String updateWorkshopCode = randomCode();
        String updatedWorkshopDescription = "Update Test";
        String updateWorkshopOTIF = "12.0000";
        String updateWorkshopPersons= "2";
        String updateWorkshopStyle= "PANT";
        String updateWorkshopMachine ="PL1AE";
        String updateWorkshopAmount = "2";
        workshopPage.addWorkshop("LUIS LONDONO", workshopCod, "Descripcion Test", "5", "2", "CAM", "PL1A", "10");
        workshopPage.editWorkshop(workshopCod,updateCustomerWorkshop, updateWorkshopCode, updatedWorkshopDescription,updateWorkshopOTIF,updateWorkshopPersons,updateWorkshopStyle,updateWorkshopMachine,updateWorkshopAmount);
        workshopPage.validateWorkshop(updateCustomerWorkshop, updateWorkshopCode, updatedWorkshopDescription,updateWorkshopOTIF,updateWorkshopPersons,updateWorkshopStyle,updateWorkshopMachine,updateWorkshopAmount);
        workshopPage.deleteWorkshop(updateWorkshopCode);
    }
}
