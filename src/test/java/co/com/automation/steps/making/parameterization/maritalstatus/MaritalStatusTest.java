package co.com.automation.steps.making.parameterization.maritalstatus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.parameterization.MakingPageEress;
import co.com.automation.pages.making.parameterization.ParameterizationPageEress;
import co.com.automation.pages.making.parameterization.maritalstatus.MaritalStatusPageEress;

import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;

public class MaritalStatusTest extends BaseTestEress {

    private MakingPageEress makingPage;
    private ParameterizationPageEress parameterizationPage;
    private MaritalStatusPageEress maritalStatusPage;

    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPageEress();
        parameterizationPage = new ParameterizationPageEress();
        maritalStatusPage = new MaritalStatusPageEress();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        implicitWait();
        clickWithJavaScript(parameterizationPage.estadoCivilIcon);
    }

    @Test
    public void maritalStatusManagementTest()  {
        String maritalStatusCode = randomCode();
        String maritalStatusDescription = "Test";
        String updateMaritalStatusCode = randomCode();
        String updatedMaritalStatusDescription = "Update Test";
        maritalStatusPage.addMaritalStatus(maritalStatusCode, maritalStatusDescription);
        maritalStatusPage.editMaritalStatus(maritalStatusCode,updateMaritalStatusCode,updatedMaritalStatusDescription);
        maritalStatusPage.validateJobRoles(updateMaritalStatusCode, updateMaritalStatusCode, updatedMaritalStatusDescription);
        maritalStatusPage.deleteJobRoles(updateMaritalStatusCode);


    }

}
