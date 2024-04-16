package steps.confeccion.parametrizacion.turnoslaborales;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import pages.confeccion.parametrizacion.ConfeccionPage;
import pages.confeccion.parametrizacion.ParametrizacionPage;
import pages.confeccion.parametrizacion.tipocompetencia.TipoCompetenciaPage;
import pages.confeccion.parametrizacion.turnoslaborales.TurnosLaboralesPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomCode;
import static utils.ElementUtils.*;
import static utils.ElementUtils.waitAndClick;

public class TurnosLaboralesTest extends BaseTestSeress {


    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private TurnosLaboralesPage turnosLaboralesPage;

    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        turnosLaboralesPage = new TurnosLaboralesPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        scrollToElement(parametrizacionPage.tipoMovimientoIcon);
        clickWithJavaScript(parametrizacionPage.turnosLaboralesIcon);
    }

    @Test
    public void workShiftManagementsTest() {
        Faker faker = new Faker();
        String workShiftCode = randomCode();
        String workShiftDescription = "Test";
        String updateWorkShiftCode = randomCode();
        String updatedWorkShiftDescription = "Update Test";
        int workShiftInitialHour = faker.number().numberBetween(1,24);
        int workShiftInitialMinute = faker.number().numberBetween(1,60);
        int workShiftFinalHour = faker.number().numberBetween(1,24);
        int workShiftFinalMinute = faker.number().numberBetween(1,60);

        turnosLaboralesPage.addWorkShifts(workShiftCode, workShiftDescription, faker.number().numberBetween(1,24), faker.number().numberBetween(1,60),faker.number().numberBetween(1,24) ,faker.number().numberBetween(1,60) );
        turnosLaboralesPage.editWorkShifts(workShiftCode, updateWorkShiftCode, updatedWorkShiftDescription,workShiftInitialHour, workShiftInitialMinute, workShiftFinalHour, workShiftFinalMinute);
        turnosLaboralesPage.validateWorkShifts(updateWorkShiftCode, updateWorkShiftCode, updatedWorkShiftDescription, workShiftInitialHour, workShiftInitialMinute, workShiftFinalHour, workShiftFinalMinute);
        turnosLaboralesPage.deleteWorkShifts(updateWorkShiftCode);
    }
}
