package co.com.automation.steps.making.parameterization.genremaster;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.parameterization.MakingPageEress;
import co.com.automation.pages.making.parameterization.ParameterizationPageEress;
import co.com.automation.pages.making.parameterization.jobpositions.JobPositionsPageEress;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;

public class GenresMasterTest extends BaseTestEress {

    private MakingPageEress makingPage;
    private ParameterizationPageEress parameterizationPage;
    private JobPositionsPageEress jobPositionsPage;

    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPageEress();
        parameterizationPage = new ParameterizationPageEress();
        jobPositionsPage = new JobPositionsPageEress();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        clickWithJavaScript(parameterizationPage.cargosLaboralesIcon);
    }

    @Test
    public void MasterGenresManagementTest()  {
        String masterGenresCode = randomCode();
        String masterGenresDescription = "Test";
        String updateMasterGenresCode = randomCode();
        String updatedMasterGenresDescription = "Update Test";
        jobPositionsPage.addJobRoles(masterGenresCode, masterGenresDescription);
        jobPositionsPage.editJobRoles(masterGenresCode,updateMasterGenresCode,updatedMasterGenresDescription);
        jobPositionsPage.validateJobRoles(updateMasterGenresCode, updateMasterGenresCode, updatedMasterGenresDescription);
        jobPositionsPage.deleteJobRoles(updateMasterGenresCode);


    }
}
