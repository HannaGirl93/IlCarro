package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();

        }

    }
    @Test
    public void registrationSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000);
        User user = new User().withName("Anna").withLastName("Kalashnikov").withEmail("annakl"+i+"@mail.com").withPassword("Bunny12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        //Assert.assertEquals(app.getHelperUser().getMessage(),"You are logged in success");

        //Assert
    }
    @Test
    public void registrationWrongEmail(){

        User user = new User().withName("Lisa").withLastName("Simpson").withEmail("lisamail.com").withPassword("Lisa12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        //Assert
    }
    @Test
    public void registrationWrongPassword(){

        User user = new User().withName("Lisa").withLastName("Simpson").withEmail("lisa@mail.com").withPassword("Li");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        //Assert
    }

    @AfterMethod
    public void postCondition(){
        app.getHelperUser().closeDialogContainer();
    }
}
