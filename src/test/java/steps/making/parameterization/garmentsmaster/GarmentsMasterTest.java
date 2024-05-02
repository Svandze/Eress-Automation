package steps.making.parameterization.garmentsmaster;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import pages.making.parameterization.MakingPage;
import pages.making.parameterization.ParameterizationPage;
import pages.making.parameterization.garmentsmaster.GarmentsMasterPage;
import steps.BaseTestEress;

import static org.example.constants.EressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.scrollToElement;
import static utils.ElementUtils.windowHandler;
import static utils.ElementUtils.waitAndClick;

public class GarmentsMasterTest extends BaseTestEress {

    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private GarmentsMasterPage garmentsMasterPage;

    @Before
    public void setup() {
        super.setup();
        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        garmentsMasterPage = new GarmentsMasterPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        scrollToElement(parameterizationPage.maestroElementosoIcon);
        waitAndClick(parameterizationPage.maestroPrendasoIcon);
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
        garmentsMasterPage.addMasterClothing(masterClothesCode,faker.business() + "Test","CAM","MA","PL");
        garmentsMasterPage.editMasterClothing(masterClothesCode, masterClothesCodeUpdated, masterClothesDescriptionUpdated, masterClothesStyle, masterClothesGender, masterClothesWeave);
        garmentsMasterPage.validateMasterClothing(masterClothesCodeUpdated, masterClothesDescriptionUpdated, masterClothesStyle, masterClothesGender, masterClothesWeave);
        garmentsMasterPage.deleteMasterClothing(masterClothesCodeUpdated);
    }
}
