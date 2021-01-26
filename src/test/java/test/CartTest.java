package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;

public class CartTest extends CommonConditions {

//    @Test
    public void addToCart(){
        boolean isEnableCheckout = new HomePage(driver)
                .openPage()
                .findWomenUnit()
                .selectProductsPage()
                .selectProduct()
                .openSizeList()
                .selectSize()
                .addToCart()
                .goToCart()
               .isEnableCheck();
        Assert.assertTrue(isEnableCheckout);
    }

    @Test
    public void deleteProductInCart(){
        boolean isDeletedProduct = new HomePage(driver)
                .openPage()
                .findWomenUnit()
                .selectProductsPage()
                .selectProduct()
                .openSizeList()
                .selectSize()
                .addToCart()
                .goToCart()
                .deleteProduct()
                .isEnableCheck();
        Assert.assertFalse(isDeletedProduct);
    }

}
