package pages;


import static org.example.constants.SeressConstants.BASE_URL;

public class SimplePage extends BasePage {

    public void openPage() {
        driver.get(BASE_URL);
    }

}
