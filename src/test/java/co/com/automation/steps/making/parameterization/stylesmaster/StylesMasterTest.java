package co.com.automation.steps.making.parameterization.stylesmaster;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.parameterization.MakingPageEress;
import co.com.automation.pages.making.parameterization.ParameterizationPageEress;
import co.com.automation.pages.making.parameterization.stylesmaster.StylesMasterPageEress;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;

public class StylesMasterTest extends BaseTestEress {



    private MakingPageEress makingPage;
    private ParameterizationPageEress parameterizationPage;
    private StylesMasterPageEress stylesMasterPage;


    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPageEress();
        parameterizationPage = new ParameterizationPageEress();
        stylesMasterPage = new StylesMasterPageEress();
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
