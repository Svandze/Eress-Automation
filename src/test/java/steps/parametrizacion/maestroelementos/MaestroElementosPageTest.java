package steps.parametrizacion.maestroelementos;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import pages.parametrizacion.ConfeccionPage;
import pages.parametrizacion.ParametrizacionPage;

import pages.parametrizacion.maestroelementos.MaestroElementosPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomCode;
import static utils.ElementUtils.*;

public class MaestroElementosPageTest extends BaseTestSeress {



    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private MaestroElementosPage maestroElementosPage;

    @Before
    public void setup() {
        super.setup();

        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        maestroElementosPage = new MaestroElementosPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        ScrollToElement(parametrizacionPage.maestroElementosoIcon);
        waitAndClick(parametrizacionPage.maestroElementosoIcon);
    }

    @Test
    public void MovementsGroupManagementTest() {
        Faker faker = new Faker();
        String masterElementsCode = randomCode();
        String masterElementsCodeUpdated = randomCode();
        String masterElementsDescriptionUpdated = faker.business() + "Test";
        String masterElementsGroupMovementsUpdated = "CUT";
        String masterElementsTypeMovmentsUpdated = "MAQUINA";
        String masterElementsDistanceUpdated = "D00";
        String masterElementsTimeUpdated = String.valueOf(faker.number().randomDigit());
        Boolean masterElementesCheck = true;
        maestroElementosPage.addMasterElements(masterElementsCode,faker.business() + "Test","CUT","MAQUINA","D00", String.valueOf(faker.number().randomDigit()), false);
        maestroElementosPage.editMasterElements(masterElementsCode,masterElementsCodeUpdated,masterElementsDescriptionUpdated, masterElementsGroupMovementsUpdated, masterElementsTypeMovmentsUpdated, masterElementsDistanceUpdated, masterElementsTimeUpdated, masterElementesCheck);
        maestroElementosPage.validateMasterElements(masterElementsCodeUpdated,masterElementsDescriptionUpdated, masterElementsGroupMovementsUpdated, masterElementsTypeMovmentsUpdated, masterElementsDistanceUpdated, masterElementsTimeUpdated, masterElementesCheck);
        maestroElementosPage.deleteMasterElements(masterElementsCodeUpdated);
    }
}
