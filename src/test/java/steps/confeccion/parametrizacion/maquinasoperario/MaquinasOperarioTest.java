package steps.confeccion.parametrizacion.maquinasoperario;


import org.junit.Before;
import org.junit.Test;
import pages.making.parametrizacion.ConfeccionPage;
import pages.making.parametrizacion.ParametrizacionPage;
import pages.making.parametrizacion.maquinasoperario.MaquinasOperarioPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static utils.ElementUtils.*;

public class MaquinasOperarioTest extends BaseTestSeress {
    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private MaquinasOperarioPage maquinasOperarioPage;

    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        maquinasOperarioPage = new MaquinasOperarioPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        clickWithJavaScript(parametrizacionPage.maquinasOperarioIcon);
    }

    @Test
    public void machinesOperatorTest() {
        String employeeDocument="12345";
        String updateEmployeeDocument="1234567";
        String updateMachinesOperatorEmployee= "Empleado2";
        String updateMachinesOperatorMachine="PL2A";
        String updateMachinesOperatorAssignment="Ref";
        String updateMachinesOperatorMachines="PLANA 2 AGUJAS ";
        maquinasOperarioPage.addMachinesOperator("Empleado", "PL1A", "ASIG","PLANA 1 AGU");
        maquinasOperarioPage.editMachinesOperator(employeeDocument,updateMachinesOperatorEmployee,updateMachinesOperatorMachine,updateMachinesOperatorAssignment,updateMachinesOperatorMachines);
        maquinasOperarioPage.validateMachinesOperator(updateEmployeeDocument,updateMachinesOperatorEmployee,updateMachinesOperatorMachine,updateMachinesOperatorAssignment,updateMachinesOperatorMachines);
        maquinasOperarioPage.deleteMachinesOperator(updateEmployeeDocument);
    }
}
