package steps.confeccion.parametrizacion.tipocompetencia;

import org.junit.Before;
import org.junit.Test;
import pages.making.parametrizacion.ConfeccionPage;
import pages.making.parametrizacion.ParametrizacionPage;
import pages.making.parametrizacion.tipocompetencia.TipoCompetenciaPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomCode;
import static utils.ElementUtils.*;
import static utils.ElementUtils.waitAndClick;

public class TipoCompetenciaTest extends BaseTestSeress {

    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private TipoCompetenciaPage tipoCompetenciaPage;

    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        tipoCompetenciaPage = new TipoCompetenciaPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        scrollToElement(parametrizacionPage.tipoMovimientoIcon);
        waitAndClick(parametrizacionPage.tipoMovimientoIcon);
    }

    @Test
    public void competitionTypeManagementsTest() {
        String competitionTypeCode = randomCode();
        String competitionTypeDescription = "Test";
        Boolean competitionTypeCheck = true;
        String updateCompetitionTypeCode = randomCode();
        String updatedCompetitionTypeDescription = "Update Test";
        Boolean updatedCompetitionTypeCheck = false;
        tipoCompetenciaPage.addCompetitionType(competitionTypeCode, competitionTypeDescription, competitionTypeCheck);
        tipoCompetenciaPage.editCompetitionType(competitionTypeCode, updateCompetitionTypeCode, updatedCompetitionTypeDescription, updatedCompetitionTypeCheck);
        tipoCompetenciaPage.validateCompetitionType(updateCompetitionTypeCode,updateCompetitionTypeCode, updatedCompetitionTypeDescription, updatedCompetitionTypeCheck);
        tipoCompetenciaPage.deleteCompetitionType(updateCompetitionTypeCode);
    }
}
