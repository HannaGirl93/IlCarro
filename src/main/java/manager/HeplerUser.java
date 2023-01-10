package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeplerUser extends HelperBase {

    public HeplerUser(WebDriver wd) {

        super(wd);
    }

    public void openLoginRegistrationForm() {

        click(By.cssSelector("a[ng-reflect-router-link='login']"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        //for email
        type(By.cssSelector("input#email"), email);
        //for password
        type(By.cssSelector("input#password"), password);
    }

    public void submitLogin() {
        click(By.cssSelector("button[type='submit']"));

    }
}
