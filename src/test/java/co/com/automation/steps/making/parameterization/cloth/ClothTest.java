package co.com.automation.steps.making.parameterization.cloth;

import org.junit.Before;
import org.junit.Test;
import co.com.automation.pages.making.parameterization.MakingPage;
import co.com.automation.pages.making.parameterization.ParameterizationPage;
import co.com.automation.pages.making.parameterization.cloth.ClothPage;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;
import static utils.ElementUtils.waitAndClick;

public class ClothTest extends BaseTestEress {



    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private ClothPage clothPage;


    @Before
    public void setup() {
        super.setup();
        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        clothPage = new ClothPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        scrollToElement(parameterizationPage.maestroTejidosIcon);
        waitAndClick(parameterizationPage.maestroTejidosIcon);

    }

    @Test
    public void weaveStylesManagementTest() {
        String weaveCode = randomCode();
        String weaveDescription = "Test";
        String updateWeaveCode = randomCode();
        String updatedWeaveDescription = "Update Test";
        clothPage.addWeave(weaveCode,weaveDescription);
        clothPage.editWeave(weaveCode,updateWeaveCode, updatedWeaveDescription);
        clothPage.validateWeave(updateWeaveCode,updateWeaveCode,updatedWeaveDescription);
        clothPage.deleteWeave(updateWeaveCode);
    }
}
