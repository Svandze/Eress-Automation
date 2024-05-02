package steps.making.parameterization.workshifts;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import pages.making.parameterization.MakingPage;
import pages.making.parameterization.ParameterizationPage;
import pages.making.parameterization.workshifts.WorkShiftsPage;
import steps.BaseTestEress;

import static org.example.constants.EressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;
import static utils.ElementUtils.waitAndClick;

public class WorkShiftsTest extends BaseTestEress {


    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private WorkShiftsPage workShiftsPage;

    @Before
    public void setup() {
        super.setup();
        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        workShiftsPage = new WorkShiftsPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        scrollToElement(parameterizationPage.tipoMovimientoIcon);
        clickWithJavaScript(parameterizationPage.turnosLaboralesIcon);
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

        workShiftsPage.addWorkShifts(workShiftCode, workShiftDescription, faker.number().numberBetween(1,24), faker.number().numberBetween(1,60),faker.number().numberBetween(1,24) ,faker.number().numberBetween(1,60) );
        workShiftsPage.editWorkShifts(workShiftCode, updateWorkShiftCode, updatedWorkShiftDescription,workShiftInitialHour, workShiftInitialMinute, workShiftFinalHour, workShiftFinalMinute);
        workShiftsPage.validateWorkShifts(updateWorkShiftCode, updateWorkShiftCode, updatedWorkShiftDescription, workShiftInitialHour, workShiftInitialMinute, workShiftFinalHour, workShiftFinalMinute);
        workShiftsPage.deleteWorkShifts(updateWorkShiftCode);
    }
}
