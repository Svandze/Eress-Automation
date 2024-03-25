package steps;


import org.junit.Test;
import pages.BasePage;
import pages.SimplePage;

public class SimplePageStepsTest extends BasePage {

@Test
    public void simplePage(){
    SimplePage simplePage = new SimplePage();
    simplePage.openPage();
}
}
