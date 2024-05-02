package pages;


import static org.example.constants.EressConstants.BASE_URL;

public class SimplePage extends BasePage {

    public void openPage() {
        driver.get(BASE_URL);
    }

}
