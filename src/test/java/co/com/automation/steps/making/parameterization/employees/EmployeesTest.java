package co.com.automation.steps.making.parameterization.employees;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.parameterization.MakingPageEress;
import co.com.automation.pages.making.parameterization.ParameterizationPageEress;
import co.com.automation.pages.making.parameterization.employees.EmployeesPageEress;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static utils.ElementUtils.clickWithJavaScript;
import static utils.ElementUtils.implicitWait;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.windowHandler;

public class EmployeesTest extends BaseTestEress {
    private MakingPageEress makingPage;
    private ParameterizationPageEress parameterizationPage;
    private EmployeesPageEress employeesPage;

    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPageEress();
        parameterizationPage = new ParameterizationPageEress();
        employeesPage = new EmployeesPageEress();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        implicitWait();
        clickWithJavaScript(parameterizationPage.empleadosIcon);
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

        employeesPage.createEmployee(id, name, surname, firstPhoneNumber, secondPhoneNumber, firstAddress, secondAddress, email);
        employeesPage.editEmployee(id, idToUpdate, nameToUpdate, surnameToUpdate, firstPhoneNumberToUpdate, secondPhoneNumberToUpdate, firstAddressToUpdate, secondAddressToUpdate, emailToUpdate);
        employeesPage.validateEmployeeDetails(idToUpdate, nameToUpdate);
        employeesPage.deleteEmployee(idToUpdate);
    }
}
