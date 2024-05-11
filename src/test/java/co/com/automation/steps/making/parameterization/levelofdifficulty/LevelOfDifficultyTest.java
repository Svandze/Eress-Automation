package co.com.automation.steps.making.parameterization.levelofdifficulty;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.parameterization.MakingPageEress;
import co.com.automation.pages.making.parameterization.ParameterizationPageEress;
import co.com.automation.pages.making.parameterization.levelofdifficulty.LevelOfDifficultyPageEress;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;

public class LevelOfDifficultyTest extends BaseTestEress {


    private MakingPageEress makingPage;
    private ParameterizationPageEress parameterizationPage;
    private LevelOfDifficultyPageEress levelOfDifficultyPage;

    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPageEress();
        parameterizationPage = new ParameterizationPageEress();
        levelOfDifficultyPage = new LevelOfDifficultyPageEress();
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
