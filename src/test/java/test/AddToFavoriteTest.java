package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;

public class AddToFavoriteTest extends CommonConditions{

    @Test
    public void addToFavorite(){
        boolean favoriteProduct = new HomePage(driver)
                .openPage()
                .findWomenUnit()
                .selectProductsPage()
                .selectProduct()
                .addToFavorite()
                .openFavoritePage()
                .isDisplayedProduct();
        Assert.assertTrue(favoriteProduct);
    }

    @Test
    public void deleteFavorite(){
        boolean findFavoriteButton = new HomePage(driver)
                .openPage()
                .findWomenUnit()
                .selectProductsPage()
                .selectProduct()
                .openFavoritePage()
                .deleteProduct()
                .isDisplayedButton();
        Assert.assertTrue(findFavoriteButton);
    }


}
