package bergs.Bvr.Bvruaajm.test.tasks.perfil;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.generic.Bvruaajm_GenericPage;
import bergs.Bvr.Bvruaajm.test.pages.perfil.Bvruaajm_GerenciarUsuarioPage;
import bergs.Bvr.Bvruaajm.test.pages.perfil.Bvruaajm_PerfilPage;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.validations.perfil.Bvruaajm_PerfilValidation;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_GerenciarUsuariosTask extends Bvruaajm_TaskMobile {
    
    Bvruaajm_PerfilPage perfilPage;
    Bvruaajm_GerenciarUsuarioPage gerenciarUsuarioPage;
    Bvruaajm_GenericPage genericPage;
    Bvruaajm_Esperas esperas;
    Bvruaajm_PerfilValidation perfilValidation;

    public Bvruaajm_GerenciarUsuariosTask(AppiumDriver<WebElement> driver) {
        super(driver);
        perfilPage = new Bvruaajm_PerfilPage(driver);
        gerenciarUsuarioPage = new Bvruaajm_GerenciarUsuarioPage(driver);
        genericPage = new Bvruaajm_GenericPage(driver);
        esperas = new Bvruaajm_Esperas(driver);
        perfilValidation = new Bvruaajm_PerfilValidation(driver);
    }

    public void validaIncluirExcluirUsuario(Bvruaajm_CartaoAcesso cartaoAcesso) {
        perfilPage.menuGerenciarUsuario().clicar();
        gerenciarUsuarioPage.obterBotaoIncluirUsuario().clicar();
        incluirNovoUsuario(cartaoAcesso);
        genericPage.obterBotaoAvancar().clicar();
        esperas.aguardarTextoProcessandoDesaparecer();
        genericPage.obterBotaoMeiaModalEntendi().clicar();
        gerenciarUsuarioPage.obterExcluirUsuario(Long.toString(cartaoAcesso.obterCpf())).clicar();
        genericPage.obterBotaoPrimarioMeiaModal().clicar();
        esperas.aguardarTextoProcessandoDesaparecer();
        genericPage.obterBotaoPrimarioMeiaModal().clicar();
    }

    
    private void incluirNovoUsuario(Bvruaajm_CartaoAcesso cartaoAcesso) {
        gerenciarUsuarioPage.obterInputCpf().preencherLento(cartaoAcesso.obterCpfFormatado());
        esperas.aguardarTextoProcessandoDesaparecer();
        if (perfilValidation.validarDadosUsuarioSalvos() == false) {
            gerenciarUsuarioPage.obterInputNome().preencherLento(cartaoAcesso.obterApelido());
            gerenciarUsuarioPage.obterInputCeluar().preencherLento(cartaoAcesso.obterTelefone());
            gerenciarUsuarioPage.obterInputEmail().preencherLento(cartaoAcesso.obterEmail());
        }  
    }
    
}
