package steps.making.parameterization.jobpositions;

import org.junit.Before;
import org.junit.Test;
import pages.making.parameterization.MakingPage;
import pages.making.parameterization.ParameterizationPage;
import pages.making.parameterization.genresmaster.GenresMasterPage;
import steps.BaseTestEress;

import static org.example.constants.EressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class JobPositionsTest extends BaseTestEress {

    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private GenresMasterPage genresMasterPage;

    @Before
    public void setup() {
        super.setup();
        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        genresMasterPage = new GenresMasterPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        waitAndClick(parameterizationPage.maestroGenerosIcon);
    }

    @Test
    public void jobRolesManagementTest()  {
        String jobRolesCode = randomCode();
        String jobRolesDescription = "Test";
        String updateJobRolesCode = randomCode();
        String updatedJobRolesDescription = "Update Test";
        genresMasterPage.addMasterGenresCode(jobRolesCode, jobRolesDescription);
        genresMasterPage.editMasterGenres(jobRolesCode,updateJobRolesCode,updatedJobRolesDescription);
        genresMasterPage.validateMasterGenres(updateJobRolesCode, updateJobRolesCode, updatedJobRolesDescription);
        genresMasterPage.deleteMasterGenres(updateJobRolesCode);


    }

}
