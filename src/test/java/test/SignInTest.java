package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import service.UserCreator;

public class SignInTest extends CommonConditions {


 //   @Test
    public void signIn(){
        User testUser = UserCreator.withCredentialsFromProperty();
        boolean signInWithCorrectData = new HomePage(driver)
                .openPage()
                .logIntoAccount(testUser)
                .profileIsEnable();
        Assert.assertTrue(signInWithCorrectData);
    }
//    @Test
    public void signInWithNoCorrectData(){
        User testUser = UserCreator.withoutCredentialsFromProperty();
        boolean NoCorrectData = new HomePage(driver)
                .openPage()
                .logIntoAccount(testUser)
                .invalidDataSignIn();
        Assert.assertTrue(NoCorrectData);
    }


}
