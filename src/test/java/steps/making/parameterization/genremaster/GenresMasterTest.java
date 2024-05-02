package steps.making.parameterization.genremaster;

import org.junit.Before;
import org.junit.Test;
import pages.making.parameterization.MakingPage;
import pages.making.parameterization.ParameterizationPage;
import pages.making.parameterization.jobpositions.JobPositionsPage;
import steps.BaseTestEress;

import static org.example.constants.EressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;

public class GenresMasterTest extends BaseTestEress {

    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private JobPositionsPage jobPositionsPage;

    @Before
    public void setup() {
        super.setup();
        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        jobPositionsPage = new JobPositionsPage();
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
