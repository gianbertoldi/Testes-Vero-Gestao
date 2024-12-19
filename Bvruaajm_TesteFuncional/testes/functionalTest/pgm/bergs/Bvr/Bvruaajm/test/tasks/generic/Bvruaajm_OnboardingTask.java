package bergs.Bvr.Bvruaajm.test.tasks.generic;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.generic.Bvruaajm_OnboardingPage;
import bergs.Bvr.Bvruaajm.test.pages.vender.Bvruaajm_VeroXPage;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.validations.generic.Bvruaajm_OnboardingValidationVero;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_OnboardingTask extends Bvruaajm_TaskMobile{

    Bvruaajm_OnboardingPage onboardingPage;
    Bvruaajm_OnboardingValidationVero onboardingValidation;
    Bvruaajm_VeroXPage veroXPage;
    
    public Bvruaajm_OnboardingTask(AppiumDriver<WebElement> driver) {
        super(driver);
        onboardingPage = new Bvruaajm_OnboardingPage(driver);
        onboardingValidation = new Bvruaajm_OnboardingValidationVero(driver);
        veroXPage = new Bvruaajm_VeroXPage(driver);
    }
    
    /**
     * METODOS PUBLICOS
     */
    public void verificaPularOnboardingGeneric() {
        if(onboardingValidation.onboardingEstaVisivel()) {
            pularOnboarding();
        }
    }
    
    public void avancarEtapaOnboarding() {
        onboardingPage.obterBtnAvancarOnboarding().clicar();
    }
    /**
     * METODOS PRIVADOS
     * @return
     */
    
    private void pularOnboarding() {
        while(onboardingValidation.botaoProxTelaVisivel()) {
            try {
                onboardingPage.obterBtnAvancarOnboarding().clicar();
            }catch (Exception e) {
                System.out.println("Botao pular onboarding gerou erro: " + e.getMessage());
            }
        }
    }
    
    public void verificaPularOnboardingVeroX() {
        if(onboardingValidation.onbordingVeroXEstaVisivel()) {
            pularOnboardingVeroX();
        }
    }
    
    public void pularOnboardingVeroX() {
        while(onboardingValidation.botaoOnbordingVeroXEstaVisivel()) {
            try {
                onboardingPage.btnDoOnbordingVeroX().clicar();
            }catch (Exception e) {
                System.out.println("Botao pular onboarding gerou erro: " + e.getMessage());
            }
        }
    }
}
