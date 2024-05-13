package co.com.automation.steps.making.parameterization.jobpositions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.parameterization.MakingPageEress;
import co.com.automation.pages.making.parameterization.ParameterizationPageEress;
import co.com.automation.pages.making.parameterization.genresmaster.GenresMasterPageEress;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class JobPositionsTest extends BaseTestEress {

    private MakingPageEress makingPage;
    private ParameterizationPageEress parameterizationPage;
    private GenresMasterPageEress genresMasterPage;

    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPageEress();
        parameterizationPage = new ParameterizationPageEress();
        genresMasterPage = new GenresMasterPageEress();
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
