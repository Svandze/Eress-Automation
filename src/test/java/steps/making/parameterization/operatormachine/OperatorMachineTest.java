package steps.making.parameterization.operatormachine;


import org.junit.Before;
import org.junit.Test;
import pages.making.parameterization.MakingPage;
import pages.making.parameterization.ParameterizationPage;
import pages.making.parameterization.operatormachine.OperatorMachinePage;
import steps.BaseTestEress;

import static org.example.constants.EressConstants.CONFECCIONES_WINDOW;
import static utils.ElementUtils.*;

public class OperatorMachineTest extends BaseTestEress {
    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private OperatorMachinePage operatorMachinePage;

    @Before
    public void setup() {
        super.setup();
        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        operatorMachinePage = new OperatorMachinePage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        clickWithJavaScript(parameterizationPage.maquinasOperarioIcon);
    }

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
