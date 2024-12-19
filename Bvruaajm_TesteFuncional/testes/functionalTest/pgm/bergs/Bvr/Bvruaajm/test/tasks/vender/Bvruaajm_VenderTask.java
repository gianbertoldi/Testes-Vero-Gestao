package bergs.Bvr.Bvruaajm.test.tasks.vender;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.vender.Bvruaajm_VenderPage;
import bergs.Bvr.Bvruaajm.test.pages.vender.Bvruaajm_VeroWalletPage;
import bergs.Bvr.Bvruaajm.test.pages.vender.Bvruaajm_VeroXPage;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_ElementoNativoTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_OnboardingTask;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.validations.vender.Bvruaajm_VenderValidation;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_VenderTask extends Bvruaajm_TaskMobile {

    Bvruaajm_VenderPage venderPage;
    Bvruaajm_VenderValidation venderValidation;
    Bvruaajm_VeroWalletPage walletPage;
    Bvruaajm_ElementoNativoTask nativoTask;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_VeroXPage veroXPage;
    Bvruaajm_OnboardingTask pularOnbording;

    public Bvruaajm_VenderTask(AppiumDriver<WebElement> driver) {
        super(driver);
        venderPage = new Bvruaajm_VenderPage(driver);
        venderValidation = new Bvruaajm_VenderValidation(driver);
        walletPage = new Bvruaajm_VeroWalletPage(driver);
        nativoTask = new Bvruaajm_ElementoNativoTask(driver);
        jsExecutor = new Bvruaajm_JsExecutor(driver);
        veroXPage = new Bvruaajm_VeroXPage(driver);
        pularOnbording = new Bvruaajm_OnboardingTask(driver);

    }

    public void clicarBotaoLinkPagamento() {
        venderPage.obterBotaoLinkPagamento().clicar();
    }

    public void clicarBotaoVeroWaller() {
        venderPage.obterBotaoVeroWallet().clicar();
    }

    public void clicarBotaoVeroX() {
        venderPage.obterBotaoVeroX().clicar();
    }

    public void validaTelaVeroWallet() {
        clicarBotaoVeroWaller();
        venderValidation.validarQrCodeVisiel();
        jsExecutor.abreBarraModalWallet(walletPage.obterBarraModalMovelWallet(), walletPage.obterTituloBarraModalMovelWallet());
        jsExecutor.abreBarraModalWallet(walletPage.obterBarraModalMovelWallet(), walletPage.obterTituloBarraModalMovelWallet());
        venderValidation.validarIconesModalVendasHoje();
    }

}
