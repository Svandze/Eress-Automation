package steps.confeccion.parametrizacion.empleados;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import pages.confeccion.parametrizacion.ConfeccionPage;
import pages.confeccion.parametrizacion.ParametrizacionPage;
import pages.confeccion.parametrizacion.empleados.EmpleadosPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static utils.ElementUtils.clickWithJavaScript;
import static utils.ElementUtils.implicitWait;
import static utils.ElementUtils.waitAndClick;
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
    public void EmployeesTest() {
        Faker faker = new Faker();
        String id = faker.number().digits(6);
        String idToUpdate = faker.number().digits(6);
        String name = faker.name().firstName();
        String nameToUpdate = faker.name().firstName();
        String surname = faker.name().lastName();
        String surnameToUpdate = faker.name().lastName();
        String firstPhoneNumber = faker.phoneNumber().phoneNumber();
        String firstPhoneNumberToUpdate = faker.phoneNumber().phoneNumber();
        String secondPhoneNumber = faker.phoneNumber().cellPhone();
        String secondPhoneNumberToUpdate = faker.phoneNumber().cellPhone();
        String firstAddress = faker.address().streetAddress();
        String firstAddressToUpdate = faker.address().streetAddress();
        String secondAddress = faker.address().streetAddress();
        String secondAddressToUpdate = faker.address().streetAddress();
        String email = faker.internet().emailAddress();
        String emailToUpdate = faker.internet().emailAddress();

        empleadosPage.createEmployee(id, name, surname, firstPhoneNumber, secondPhoneNumber, firstAddress, secondAddress, email);
        empleadosPage.editEmployee(id, idToUpdate, nameToUpdate, surnameToUpdate, firstPhoneNumberToUpdate, secondPhoneNumberToUpdate, firstAddressToUpdate, secondAddressToUpdate, emailToUpdate);
        empleadosPage.validateEmployeeDetails(idToUpdate, nameToUpdate);
        empleadosPage.deleteEmployee(idToUpdate);
    }
}
