package co.com.automation.steps.making.parameterization.levelofdifficulty;

import org.junit.Before;
import org.junit.Test;
import co.com.automation.pages.making.parameterization.MakingPage;
import co.com.automation.pages.making.parameterization.ParameterizationPage;
import co.com.automation.pages.making.parameterization.levelofdifficulty.LevelOfDifficultyPage;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;

public class LevelOfDifficultyTest extends BaseTestEress {


    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private LevelOfDifficultyPage levelOfDifficultyPage;

    @Before
    public void setup() {
        super.setup();
        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        levelOfDifficultyPage = new LevelOfDifficultyPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        scrollToElement(parameterizationPage.gradoDificultadIcon);
        waitAndClick(parameterizationPage.gradoDificultadIcon);
    }

    @Test
    public void levelOfDifficultyManagementTest() {
        String levelDifficultyCode = randomCode();
        String levelDifficultyDescription = "Test";
        String levelDifficultyValue = "1.0000";
        String updateLevelDifficultyCode = randomCode();
        String updatedLevelDifficultyDescription = "Update Test";
        String updatedLevelDifficultyValue = "2.0000";
        levelOfDifficultyPage.addLevelDifficulty(levelDifficultyCode, levelDifficultyDescription, levelDifficultyValue);
        levelOfDifficultyPage.editLevelDifficulty(levelDifficultyCode, updateLevelDifficultyCode, updatedLevelDifficultyDescription, updatedLevelDifficultyValue);
        levelOfDifficultyPage.validateLevelDifficulty(updateLevelDifficultyCode, updateLevelDifficultyCode, updatedLevelDifficultyDescription, updatedLevelDifficultyValue);
        levelOfDifficultyPage.deleteLevelDifficulty(updateLevelDifficultyCode);


    }
}
