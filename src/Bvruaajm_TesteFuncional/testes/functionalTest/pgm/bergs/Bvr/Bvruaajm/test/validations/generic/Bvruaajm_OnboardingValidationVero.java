package bergs.Bvr.Bvruaajm.test.validations.generic;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.generic.Bvruaajm_OnboardingPage;
import bergs.Bvr.Bvruaajm.test.pages.vender.Bvruaajm_VeroXPage;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_OnboardingValidationVero {

    Bvruaajm_OnboardingPage onboardingPage;
    Bvruaajm_VeroXPage veroXPage;
    
    public Bvruaajm_OnboardingValidationVero(AppiumDriver<WebElement> driver) {
        onboardingPage = new Bvruaajm_OnboardingPage(driver);
        veroXPage = new Bvruaajm_VeroXPage(driver);
    }

    public boolean onboardingEstaVisivel() {
        try {
            onboardingPage.obterTelaOnboarding();
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    
    public boolean botaoProxTelaVisivel() {
        try {
            onboardingPage.obterBtnAvancarOnboarding();
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    
    public boolean onbordingVeroXEstaVisivel() {
        try {
            onboardingPage.telaOnbordigVeroX();
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    
    public boolean botaoOnbordingVeroXEstaVisivel() {
        try {
            onboardingPage.btnDoOnbordingVeroX();
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
