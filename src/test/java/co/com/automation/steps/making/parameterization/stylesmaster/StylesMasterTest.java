package co.com.automation.steps.making.parameterization.stylesmaster;

import org.junit.Before;
import org.junit.Test;
import co.com.automation.pages.making.parameterization.MakingPage;
import co.com.automation.pages.making.parameterization.ParameterizationPage;
import co.com.automation.pages.making.parameterization.stylesmaster.StylesMasterPage;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;

public class StylesMasterTest extends BaseTestEress {



    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private StylesMasterPage stylesMasterPage;


    @Before
    public void setup() {
        super.setup();
        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        stylesMasterPage = new StylesMasterPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        scrollToElement(parameterizationPage.maestroEstilosIcon);
        waitAndClick(parameterizationPage.maestroEstilosIcon);
    }

    @Test
    public void masterStylesManagementTest() {
        String masterStylesCode = randomCode();
        String masterStylesDescription = "Test";
        String updateMasterStylesCode = randomCode();
        String updatedMasterStylesDescription = "Update Test";
        stylesMasterPage.addMasterStyles(masterStylesCode,masterStylesDescription);
        stylesMasterPage.editMasterStyles(masterStylesCode,updateMasterStylesCode, updatedMasterStylesDescription);
        stylesMasterPage.validateMasterStyles(updateMasterStylesCode,updateMasterStylesCode,updatedMasterStylesDescription);
        stylesMasterPage.deleteMasterStyles(updateMasterStylesCode);


    }
}
