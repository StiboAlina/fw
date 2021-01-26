package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;


public class SearchTest extends CommonConditions {

    @Test
    public void searchWithNoCorrectData(){
        String invalidRequest = new HomePage(driver)
                .openPage()
    //            .closeCookie()
                .findSearchInput("fssdfs")
                .noCorrectRequestResult();
        Assert.assertEquals(invalidRequest, "НЕТ СООТВЕТСТВУЮЩИХ ТОВАРОВ");
    }
    @Test
    public void searchWithCorrectData(){
        boolean isFoundProducts = new HomePage(driver)
                .openPage()
  //              .closeCookie()
                .findSearchInput("Футболка")
                .notFoundProduct();
        Assert.assertTrue(isFoundProducts);
    }

}
