package pages;

public class SimplePage extends BasePage{

    public String url = "https://www.google.com/";
    public void openPage(){
        runNavigator(url);
    }

}
