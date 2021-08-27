package steps;

import net.thucydides.core.annotations.Step;
import pages.HeaderPage;

public class HeaderSteps {
    private HeaderPage headerPage;

    @Step
    public void goToCategory(String category){
        headerPage.clickOnCategory(category);
    }
}
