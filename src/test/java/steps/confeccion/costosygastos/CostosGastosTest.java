package steps.confeccion.costosygastos;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import pages.confeccion.costosygastos.CostosGastosPage;
import pages.confeccion.parametrizacion.ConfeccionPage;
import pages.confeccion.parametrizacion.ParametrizacionPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class CostosGastosTest extends BaseTestSeress {

    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private CostosGastosPage costosGastosPage;


    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        costosGastosPage= new CostosGastosPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.costExpensesIcon);
    }

    @Test
    public void costExpensesManagementTest()  {
        Faker faker = new Faker();


    }
}
