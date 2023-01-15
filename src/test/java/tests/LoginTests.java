package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeTest
    public void preCondition(){
        if(app.getHeplerUser().isLogged()){
            app.getHeplerUser().logout();
        }
    }

    @Test
    public void loginSuccess(){

        app.getHeplerUser().openLoginRegistrationForm();
        app.getHeplerUser().fillLoginRegistrationForm("bunny@mail.com", "Bunny12345$");
        app.getHeplerUser().submitLogin();
        Assert.assertEquals(app.getHeplerUser().getMessage(),"Logged in success");
        app.getHeplerUser().closeDialogContainer();

    }

    @Test
    public void loginWrongEmail(){

    }

    @Test
    public void loginWrongPassword(){

    }

    @Test
    public void loginUnregisterUser(){

    }
}
