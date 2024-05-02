package steps.making.parameterization.competencetype;

import org.junit.Before;
import org.junit.Test;
import pages.making.parameterization.MakingPage;
import pages.making.parameterization.ParameterizationPage;
import pages.making.parameterization.competencetype.CompetenceTypePage;
import steps.BaseTestEress;

import static org.example.constants.EressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;
import static utils.ElementUtils.waitAndClick;

public class CompetenceTypeTest extends BaseTestEress {

    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private CompetenceTypePage competenceTypePage;

    @Before
    public void setup() {
        super.setup();
        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        competenceTypePage = new CompetenceTypePage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        scrollToElement(parameterizationPage.tipoMovimientoIcon);
        waitAndClick(parameterizationPage.tipoMovimientoIcon);
    }

    @Test
    public void competitionTypeManagementsTest() {
        String competitionTypeCode = randomCode();
        String competitionTypeDescription = "Test";
        Boolean competitionTypeCheck = true;
        String updateCompetitionTypeCode = randomCode();
        String updatedCompetitionTypeDescription = "Update Test";
        Boolean updatedCompetitionTypeCheck = false;
        competenceTypePage.addCompetitionType(competitionTypeCode, competitionTypeDescription, competitionTypeCheck);
        competenceTypePage.editCompetitionType(competitionTypeCode, updateCompetitionTypeCode, updatedCompetitionTypeDescription, updatedCompetitionTypeCheck);
        competenceTypePage.validateCompetitionType(updateCompetitionTypeCode,updateCompetitionTypeCode, updatedCompetitionTypeDescription, updatedCompetitionTypeCheck);
        competenceTypePage.deleteCompetitionType(updateCompetitionTypeCode);
    }
}
