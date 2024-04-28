package steps.confeccion.parametrizacion.empleados;

import org.junit.Before;
import org.junit.Test;
import pages.confeccion.parametrizacion.ConfeccionPage;
import pages.confeccion.parametrizacion.ParametrizacionPage;
import pages.confeccion.parametrizacion.empleados.EmpleadosPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static utils.ElementUtils.clickWithJavaScript;
import static utils.ElementUtils.implicitWait;
import static utils.ElementUtils.scrollToElement;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.waitAndSendKeys;
import static utils.ElementUtils.windowHandler;

public class EmpleadosTest extends BaseTestSeress {
    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private EmpleadosPage empleadosPage;

    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        empleadosPage = new EmpleadosPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        implicitWait();
        clickWithJavaScript(parametrizacionPage.empleadosIcon);
    }

    @Test
    public void EmployeesTest(){
        waitAndClick(empleadosPage.addNewEmployee);
        implicitWait();
        waitAndClick(empleadosPage.idDropdown);
        waitAndClick(empleadosPage.getFirstDropdownOption);
        waitAndSendKeys(empleadosPage.documentInput, "123456");
        waitAndSendKeys(empleadosPage.namesInput, "la bestia");
        waitAndSendKeys(empleadosPage.surnameInput, "gutierrez" );
        waitAndClick(empleadosPage.isEmployee);
        waitAndSendKeys(empleadosPage.firstPhoneNumberInput, "123456");
        waitAndSendKeys(empleadosPage.secondPhoneNumberInput, "123456");
        waitAndSendKeys(empleadosPage.firstAddressInput, "123456");
        waitAndSendKeys(empleadosPage.secondAddressInput, "123456");
        waitAndSendKeys(empleadosPage.emailInput, "123456@gmail.com");
        scrollToElement(empleadosPage.selectPositionDropdown);
        waitAndClick(empleadosPage.selectPositionDropdown);
        waitAndClick(empleadosPage.getFirstDropdownOption);
        waitAndClick(empleadosPage.selectSexDropdown);
        waitAndClick(empleadosPage.getFirstDropdownOption);
        waitAndClick(empleadosPage.selectShiftDropdown);
        waitAndClick(empleadosPage.getFirstDropdownOption);
        empleadosPage.setCalendarDate(empleadosPage.admissionDateCalendar, 2020, 2025);
//        empleadosPage.setCalendarDate(empleadosPage.admissionDateCalendar, "04/17/2024");
//        empleadosPage.setCalendarDate(empleadosPage.birthDateCalendar, "03/02/1996");
        waitAndClick(empleadosPage.selectBirthPlaceDropdown);

        waitAndClick(empleadosPage.getFirstDropdownOption);
        waitAndClick(empleadosPage.selectMaritalStatusDropdown);
        waitAndClick(empleadosPage.getFirstDropdownOption);
        waitAndClick(empleadosPage.confirmNewEmployeeButton);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
