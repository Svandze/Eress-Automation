package steps.confeccion.parametrizacion.maestroprendas;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import pages.confeccion.parametrizacion.ConfeccionPage;
import pages.confeccion.parametrizacion.ParametrizacionPage;
import pages.confeccion.parametrizacion.maestroprendas.MaestroPrendasPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomCode;
import static utils.ElementUtils.scrollToElement;
import static utils.ElementUtils.windowHandler;
import static utils.ElementUtils.waitAndClick;

public class MaestroPrendasTest extends BaseTestSeress {



    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private MaestroPrendasPage maestroPrendasPage;

    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        maestroPrendasPage = new MaestroPrendasPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        scrollToElement(parametrizacionPage.maestroElementosoIcon);
        waitAndClick(parametrizacionPage.maestroPrendasoIcon);
    }

    @Test
    public void MasterClothesManagementTest() {
        Faker faker = new Faker();
        String masterClothesCode = randomCode();
        String masterClothesCodeUpdated = randomCode();
        String masterClothesDescriptionUpdated = faker.business() + "Test";
        String masterClothesStyle = "BLU";
        String masterClothesGender = "FE";
        String masterClothesWeave = "PT";
        maestroPrendasPage.addMasterClothing(masterClothesCode,faker.business() + "Test","CAM","MA","PL");
        maestroPrendasPage.editMasterClothing(masterClothesCode, masterClothesCodeUpdated, masterClothesDescriptionUpdated, masterClothesStyle, masterClothesGender, masterClothesWeave);
        maestroPrendasPage.validateMasterClothing(masterClothesCodeUpdated, masterClothesDescriptionUpdated, masterClothesStyle, masterClothesGender, masterClothesWeave);
        maestroPrendasPage.deleteMasterClothing(masterClothesCodeUpdated);
    }
}
