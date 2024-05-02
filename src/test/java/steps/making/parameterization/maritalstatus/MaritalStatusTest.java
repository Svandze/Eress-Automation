package steps.making.parameterization.maritalstatus;

import org.junit.Before;
import org.junit.Test;
import pages.making.parameterization.MakingPage;
import pages.making.parameterization.ParameterizationPage;
import pages.making.parameterization.maritalstatus.MaritalStatusPage;

import steps.BaseTestEress;

import static org.example.constants.EressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;

public class MaritalStatusTest extends BaseTestEress {

    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private MaritalStatusPage maritalStatusPage;

    @Before
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
