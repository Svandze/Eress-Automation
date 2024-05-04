package co.com.automation.steps.making.parameterization.weave;

import org.junit.Before;
import org.junit.Test;
import co.com.automation.pages.making.parameterization.MakingPage;
import co.com.automation.pages.making.parameterization.ParameterizationPage;
import co.com.automation.pages.making.parameterization.weave.WeavePage;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;
import static utils.ElementUtils.waitAndClick;

public class WeaveTest extends BaseTestEress {



    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private WeavePage weavePage;


    @Before
    public void setup() {
        super.setup();
        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        weavePage = new WeavePage();
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
        weavePage.addWeave(weaveCode,weaveDescription);
        weavePage.editWeave(weaveCode,updateWeaveCode, updatedWeaveDescription);
        weavePage.validateWeave(updateWeaveCode,updateWeaveCode,updatedWeaveDescription);
        weavePage.deleteWeave(updateWeaveCode);
    }
}
