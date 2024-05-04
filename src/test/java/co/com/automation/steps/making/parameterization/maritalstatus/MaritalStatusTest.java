package co.com.automation.steps.making.parameterization.maritalstatus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.parameterization.MakingPage;
import co.com.automation.pages.making.parameterization.ParameterizationPage;
import co.com.automation.pages.making.parameterization.maritalstatus.MaritalStatusPage;

import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;

public class MaritalStatusTest extends BaseTestEress {

    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private MaritalStatusPage maritalStatusPage;

    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        maritalStatusPage = new MaritalStatusPage();
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
