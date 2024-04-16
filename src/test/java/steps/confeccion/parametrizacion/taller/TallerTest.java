package steps.confeccion.parametrizacion.taller;

import org.junit.Before;
import org.junit.Test;
import pages.confeccion.parametrizacion.ConfeccionPage;
import pages.confeccion.parametrizacion.ParametrizacionPage;
import pages.confeccion.parametrizacion.taller.TallerPage;
import pages.confeccion.parametrizacion.tipomovimientos.TipoMovimientosPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomCode;
import static utils.ElementUtils.*;
import static utils.ElementUtils.waitAndClick;

public class TallerTest extends BaseTestSeress {

    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private TallerPage tallerPage;

    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        tallerPage = new TallerPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        scrollToElement(parametrizacionPage.tipoMovimientoIcon);
        waitAndClick(parametrizacionPage.tallerIcon);
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
        tallerPage.addWorkshop("LUIS LONDONO", workshopCod, "Descripcion Test", "5", "2", "CAM", "PL1A", "10");
        tallerPage.editWorkshop(workshopCod,updateCustomerWorkshop, updateWorkshopCode, updatedWorkshopDescription,updateWorkshopOTIF,updateWorkshopPersons,updateWorkshopStyle,updateWorkshopMachine,updateWorkshopAmount);
        tallerPage.validateWorkshop(updateCustomerWorkshop, updateWorkshopCode, updatedWorkshopDescription,updateWorkshopOTIF,updateWorkshopPersons,updateWorkshopStyle,updateWorkshopMachine,updateWorkshopAmount);
        tallerPage.deleteWorkshop(updateWorkshopCode);
    }
}
