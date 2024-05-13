package co.com.automation.steps.making.parameterization.workshifts;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.parameterization.MakingPageEress;
import co.com.automation.pages.making.parameterization.ParameterizationPageEress;
import co.com.automation.pages.making.parameterization.workshifts.WorkShiftsPageEress;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;
import static utils.ElementUtils.waitAndClick;

public class WorkShiftsTest extends BaseTestEress {


    private MakingPageEress makingPage;
    private ParameterizationPageEress parameterizationPage;
    private WorkShiftsPageEress workShiftsPage;

    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPageEress();
        parameterizationPage = new ParameterizationPageEress();
        workShiftsPage = new WorkShiftsPageEress();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        scrollToElement(parameterizationPage.tipoMovimientoIcon);
        clickWithJavaScript(parameterizationPage.turnosLaboralesIcon);
    }

    @Disabled
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
