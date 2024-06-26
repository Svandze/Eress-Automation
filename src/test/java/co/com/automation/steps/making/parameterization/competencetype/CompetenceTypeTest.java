package co.com.automation.steps.making.parameterization.competencetype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.parameterization.MakingPageEress;
import co.com.automation.pages.making.parameterization.ParameterizationPageEress;
import co.com.automation.pages.making.parameterization.competencetype.CompetenceTypePageEress;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;
import static utils.ElementUtils.waitAndClick;

public class CompetenceTypeTest extends BaseTestEress {

    private MakingPageEress makingPage;
    private ParameterizationPageEress parameterizationPage;
    private CompetenceTypePageEress competenceTypePage;

    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPageEress();
        parameterizationPage = new ParameterizationPageEress();
        competenceTypePage = new CompetenceTypePageEress();
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
