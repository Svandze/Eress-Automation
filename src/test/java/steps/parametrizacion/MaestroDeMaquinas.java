package steps.parametrizacion;

import org.junit.Test;
import pages.parametrizacion.ConfeccionPage;
import steps.BaseTestSeress;

import static utils.ElementUtils.waitAndClick;

public class MaestroDeMaquinas extends BaseTestSeress {

    private ConfeccionPage confeccionPage;


    @Test
    public void addMachineTest() throws InterruptedException {
        confeccionPage = new ConfeccionPage();

        waitAndClick(confeccionPage.parameterizationIcon);
    }
}
