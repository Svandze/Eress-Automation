package co.com.automation.steps.making.parameterization.weave;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.parameterization.MakingPageEress;
import co.com.automation.pages.making.parameterization.ParameterizationPageEress;
import co.com.automation.pages.making.parameterization.weave.WeavePageEress;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;
import static utils.ElementUtils.waitAndClick;

public class WeaveTest extends BaseTestEress {



    private MakingPageEress makingPage;
    private ParameterizationPageEress parameterizationPage;
    private WeavePageEress weavePage;


    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPageEress();
        parameterizationPage = new ParameterizationPageEress();
        weavePage = new WeavePageEress();
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
