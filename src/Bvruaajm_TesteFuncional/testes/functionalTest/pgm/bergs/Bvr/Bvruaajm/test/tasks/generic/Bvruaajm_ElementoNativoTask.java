package bergs.Bvr.Bvruaajm.test.tasks.generic;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.generic.Bvruaajm_ElementoNativoPage;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_ElementoNativoTask extends Bvruaajm_TaskMobile{

    Bvruaajm_ElementoNativoPage nativoPage;
    
    public Bvruaajm_ElementoNativoTask(AppiumDriver<WebElement> driver) {
        super(driver);
        nativoPage = new Bvruaajm_ElementoNativoPage(driver);
    }

    public void clicarBotaoEsquerdo() {
        definirContextoNativo();
        nativoPage.obterBotaoEsquerdo().click();
        definirContextoWebview();
    }
    
    public void clicarBotaoDireito() {
        definirContextoNativo();
        nativoPage.obterBotaoDireito().click();
        definirContextoWebview();
    }
    
    public void clicarBotaoDireito2() {
        definirContextoNativo();
        nativoPage.obterBotaoDireito2().click();
        definirContextoWebview();
    }
}
