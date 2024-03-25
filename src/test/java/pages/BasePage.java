package pages;


import core.DriverManager;

public class BasePage extends DriverManager {

    public void runNavigator(String url){

        getDriver().get(url);
    }

}
