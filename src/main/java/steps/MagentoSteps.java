package steps;

import net.thucydides.core.annotations.Step;
import pages.HomePage;
import pages.MagentoAdmin;
import tools.constants.MagentoConstants;

public class MagentoSteps {
    private MagentoAdmin magentoAdmin;
    private HomePage homePage;

    @Step
    public void acceptReviewAsAdmin(){
        magentoAdmin.logInAsAdmin(MagentoConstants.ADMIN,MagentoConstants.PASS);
        magentoAdmin.clickOnPendingReview();
        magentoAdmin.editReview();
    }

    @Step
    public void returnToMadison(){
        homePage.navigateToHomePage();
    }
}
