package tests;

import models.Car;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().withEmail("bunny@gmail.com").withPassword("Bunny12345$"));
        }
    }

    @Test
    public void addNewCarSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;

        Car car = Car.builder()
                .location("Rehovot, Israel")
                .manufacture("Mazda")
                .model("6")
                .year("2020")
                .fuel("Petrol")
                .seats("4")
                .clasS("C")
                .carRegNumber("53300" + i)
                .price("650")
                .about("very very nice car")
                .build();


        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("C:\\Users\\hanna\\QA36_GitHub\\IlCarro\\MAZDA6_SEDAN_100th_Anniversary_Special_Edition.jpg");
        app.getHelperCar().submit();

        Assert.assertTrue(app.getHelperCar().isTitleMessageContains("Car added"));
    }
}
