package co.com.automation.steps.making.parameterization.operatormachine;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.parameterization.MakingPageEress;
import co.com.automation.pages.making.parameterization.ParameterizationPageEress;
import co.com.automation.pages.making.parameterization.operatormachine.OperatorMachinePageEress;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static utils.ElementUtils.*;

public class OperatorMachineTest extends BaseTestEress {
    private MakingPageEress makingPage;
    private ParameterizationPageEress parameterizationPage;
    private OperatorMachinePageEress operatorMachinePage;

    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPageEress();
        parameterizationPage = new ParameterizationPageEress();
        operatorMachinePage = new OperatorMachinePageEress();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        clickWithJavaScript(parameterizationPage.maquinasOperarioIcon);
    }

    @Disabled
    @Test
    public void machinesOperatorTest() {
        String employeeDocument="12345";
        String updateEmployeeDocument="1234567";
        String updateMachinesOperatorEmployee= "Empleado2";
        String updateMachinesOperatorMachine="PL2A";
        String updateMachinesOperatorAssignment="Ref";
        String updateMachinesOperatorMachines="PLANA 2 AGUJAS ";
        operatorMachinePage.addMachinesOperator("Empleado", "PL1A", "ASIG","PLANA 1 AGU");
        operatorMachinePage.editMachinesOperator(employeeDocument,updateMachinesOperatorEmployee,updateMachinesOperatorMachine,updateMachinesOperatorAssignment,updateMachinesOperatorMachines);
        operatorMachinePage.validateMachinesOperator(updateEmployeeDocument,updateMachinesOperatorEmployee,updateMachinesOperatorMachine,updateMachinesOperatorAssignment,updateMachinesOperatorMachines);
        operatorMachinePage.deleteMachinesOperator(updateEmployeeDocument);
    }
}
