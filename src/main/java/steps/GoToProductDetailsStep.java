package steps;

import net.thucydides.core.annotations.Step;
import pages.CategoryPage;
import pages.HeaderPage;
import pages.SubcategoryPage;

public class GoToProductDetailsStep {
    private HeaderPage headerPage;
    private CategoryPage categoryPage;
    private SubcategoryPage subcategoryPage;

    @Step
    public void goToProductDetails(String category,String subcategory,String productName){
        headerPage.clickOnCategory(category);
        categoryPage.clickOnSubcategory(subcategory);
        subcategoryPage.clickOnProduct(productName);
        //verify
    }
}
