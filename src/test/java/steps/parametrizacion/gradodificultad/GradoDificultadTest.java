package steps.parametrizacion.gradodificultad;

import org.junit.Before;
import org.junit.Test;
import pages.parametrizacion.ConfeccionPage;
import pages.parametrizacion.ParametrizacionPage;
import pages.parametrizacion.gradodificultad.GradoDificultadPage;
import pages.parametrizacion.grupomovimientos.GrupoMovimientosPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomCode;
import static utils.ElementUtils.*;

public class GradoDificultadTest extends BaseTestSeress {


    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private GradoDificultadPage gradoDificultadPage;

    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        gradoDificultadPage = new GradoDificultadPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        ScrollToElement(parametrizacionPage.gradoDificultadIcon);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitAndClick(parametrizacionPage.gradoDificultadIcon);
    }

    @Test
    public void MovementsGruopManagementTest() throws InterruptedException {
        String levelDifficultyCode = randomCode();
        String levelDifficultyDescription = "Test";
        String levelDifficultyValue = "1.0000";
        String updateLevelDifficultyCode = randomCode();
        String updatedLevelDifficultyDescription = "Update Test";
        String updatedLevelDifficultyValue = "2.0000";
        gradoDificultadPage.addLevelDifficulty(levelDifficultyCode, levelDifficultyDescription ,levelDifficultyValue);
        gradoDificultadPage.editLevelDifficulty(levelDifficultyCode, updateLevelDifficultyCode, updatedLevelDifficultyDescription, updatedLevelDifficultyValue);
        gradoDificultadPage.validateLevelDifficulty(updateLevelDifficultyCode,updateLevelDifficultyCode,  updatedLevelDifficultyDescription, updatedLevelDifficultyValue);
        gradoDificultadPage.deleteLevelDifficulty(updateLevelDifficultyCode);


    }
}
