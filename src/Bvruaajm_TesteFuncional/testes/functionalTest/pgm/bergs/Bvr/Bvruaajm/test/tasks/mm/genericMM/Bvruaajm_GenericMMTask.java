package bergs.Bvr.Bvruaajm.test.tasks.mm.genericMM;

import org.openqa.selenium.remote.RemoteWebDriver;

import bergs.Bvr.Bvruaajm.test.pages.mm.genericMM.Bvruaajm_GenericMMPage;
import bergs.Bvr.Bvruaajm.test.pages.mm.menuLateral.Bvruaajm_MenuLateralMMPage;
import bergs.bmo.bmouaajm.suporte.tasks.Bmouaajm_TaskBase;

public class Bvruaajm_GenericMMTask extends Bmouaajm_TaskBase {
    
    Bvruaajm_MenuLateralMMPage menuLateral;
    Bvruaajm_GenericMMPage genericPage;
    
    public Bvruaajm_GenericMMTask(RemoteWebDriver driver) {
        super(driver);
        menuLateral = new Bvruaajm_MenuLateralMMPage(driver);
        genericPage = new Bvruaajm_GenericMMPage(driver);
    }
    
    public void clicarBotaoPesquisar() {
        genericPage.obterBotaoPesquisar().clicar();
    }
    
    public void clicarBotaoLimpar() {
        genericPage.obterBotaoLimpar().clicar();
    }

    public void clicarBotaoIncluirCadastro() {
        genericPage.obterBotaoIncluirCadastro().clicar();
    }
    
    public void clicarBotaoSalvarCadastro() {
        genericPage.obterBotaoSalvarCadastro().clicar();
    }
    
    public void clicarBotaoVoltar() {
        genericPage.obterBotaoVoltar().clicar();
    }
    
    public void clicarBotaoExportar() {
        genericPage.obterBotaoExportar().clicar();
    }
}
