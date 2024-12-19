package bergs.Bvr.Bvruaajm.test.tasks.login;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.generic.Bvruaajm_GenericPage;
import bergs.Bvr.Bvruaajm.test.pages.login.Bvruaajm_AceiteDigitalPage;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.Bvr.Bvruaajm.test.validations.login.Bvruaajm_LoginlValidations;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_AceiteDigitalTask extends Bvruaajm_TaskMobile {
    
    Bvruaajm_GenericPage genericPage;
    Bvruaajm_LoginlValidations aceiteValidations;
    Bvruaajm_AceiteDigitalPage aceitePage;
    Bvruaajm_Esperas esperas;
    
    public Bvruaajm_AceiteDigitalTask(AppiumDriver<WebElement> driver) {
        super(driver);
        genericPage = new Bvruaajm_GenericPage(driver);
        aceitePage = new Bvruaajm_AceiteDigitalPage(driver);
        esperas = new Bvruaajm_Esperas(driver);
        aceiteValidations = new Bvruaajm_LoginlValidations(driver);
    }

    public void efetuarFluxoAceiteDigital() {
        aceitePage.obterInputContatoVero().clicar();
        esperas.aguardarTextoProcessandoDesaparecer();
        aceitePage.obterInputPropAdesaoVero().clicar();
        esperas.aguardarTextoProcessandoDesaparecer();
        aceitePage.obterInputTermoAdesaoCartaoPrePago().clicar();
        esperas.aguardarTextoProcessandoDesaparecer();
        aceitePage.obterBotaoAvancarAceite().clicar();
        aceiteValidations.validarModalCredeciamentoCpf();
        genericPage.obterBotaoMeiaModalEntendi().clicar();
    }
}
