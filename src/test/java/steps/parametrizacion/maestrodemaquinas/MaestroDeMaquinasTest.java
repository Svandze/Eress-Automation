package steps.parametrizacion.maestrodemaquinas;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.parametrizacion.ConfeccionPage;
import pages.parametrizacion.maestrodemaquinas.MaestroDeMaquinasPage;
import pages.parametrizacion.ParametrizacionPage;
import steps.BaseTestSeress;


import java.util.Random;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.waitAndSendKeys;
import static utils.ElementUtils.windowHandler;

public class MaestroDeMaquinasTest extends BaseTestSeress {

    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private MaestroDeMaquinasPage maestroDeMaquinasPage;

    @Before
    public void setup() throws InterruptedException {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        maestroDeMaquinasPage = new MaestroDeMaquinasPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        waitAndClick(parametrizacionPage.maestroDeMaquinasIcon);
    }


    @Test
    public void addMachineTest() throws InterruptedException {
        String machine = new Random().ints(4, 'A', 'Z' + 1)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        waitAndClick(maestroDeMaquinasPage.addButton);
        waitAndSendKeys(maestroDeMaquinasPage.addMachineCodeInputForm, machine);
        maestroDeMaquinasPage.setMachineData("PLANA 1 AGU", "5", "6", "23");
        maestroDeMaquinasPage.findMachine(machine);
        waitAndClick(maestroDeMaquinasPage.getEditButtonForMachine(machine));
        maestroDeMaquinasPage.setMachineData("PLANA 3 AGU", "8", "12", "45");
        maestroDeMaquinasPage.findMachine(machine);
        waitAndClick(maestroDeMaquinasPage.getDetailsButtonForMachine(machine));
        maestroDeMaquinasPage.validateMachineInfo(machine);
        waitAndClick(maestroDeMaquinasPage.cancelButton);
        maestroDeMaquinasPage.findMachine(machine);
        waitAndClick(maestroDeMaquinasPage.getDeleteButtonForMachine());
        waitAndClick(maestroDeMaquinasPage.confirmButtonDelete);
        Thread.sleep(5000);
    }


}
