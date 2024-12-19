package bergs.Bvr.Bvruaajm.test.tasks.conexoes.edicaoPerfil;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil.Bvruaajm_PerfilEcPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.edicaoPerfil.Bvruaajm_EdicaoCategoriaDoPerfilPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.edicaoPerfil.Bvruaajm_EdicaoDescricaoPerfilPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.edicaoPerfil.Bvruaajm_EdicaoRedesSociaisPages;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_EdicaoPerfilTask extends Bvruaajm_TaskMobile {

    private Bvruaajm_EdicaoDescricaoPerfilPage descricaoEdicao;
    private Bvruaajm_PerfilEcPage perfilEcPage;
    private Bvruaajm_EdicaoRedesSociaisPages edicaoRedesSociaisPage;
    private Bvruaajm_EdicaoCategoriaDoPerfilPage edicaoCategoriaPage;

    public Bvruaajm_EdicaoPerfilTask(AppiumDriver<WebElement> driver) {
        super(driver);
        descricaoEdicao = new Bvruaajm_EdicaoDescricaoPerfilPage(driver);
        perfilEcPage = new Bvruaajm_PerfilEcPage(driver);
        edicaoRedesSociaisPage = new Bvruaajm_EdicaoRedesSociaisPages(driver);
        edicaoCategoriaPage = new Bvruaajm_EdicaoCategoriaDoPerfilPage(driver);
    }

    public void selecionarDescricaoEdicaoNegocio() {
        perfilEcPage.obterBotaoEditarDescricao().clicar();
    }

    public void selecionarCadastrarDescricaoNegocio() {
        perfilEcPage.obterBotaoCadastrarDescricao().clicar();
    }

    public void preencherDescicaoEdicaoNegocio(String descricaoNegocio) {
        descricaoEdicao.obterCampoTextoEditarDescricao().limpar();
        descricaoEdicao.obterCampoTextoEditarDescricao().preencher(descricaoNegocio);
        descricaoEdicao.obterBotaoSalvar().clicar();
    }

    public void selecionarCadastrarRedesSociais() {
        perfilEcPage.obterBotaoCadastrarRedesSociais().clicar();
    }

    public void selecionarEditarRedesSociais() {
        perfilEcPage.obterBotaoEditarRedesSociais().clicar();
    }

    public void preencherRedesSociais(String instagram, String facebook, String whatsapp) {
        edicaoRedesSociaisPage.obterCampoEditarInstagram().limpar();
        edicaoRedesSociaisPage.obterCampoEditarInstagram().preencher(instagram);
        edicaoRedesSociaisPage.obterCampoEditarFacebook().limpar();
        edicaoRedesSociaisPage.obterCampoEditarFacebook().preencher(facebook);
        edicaoRedesSociaisPage.obterCampoEditarWhatsapp().limpar();
        edicaoRedesSociaisPage.obterCampoEditarWhatsapp().preencher(whatsapp);
        edicaoRedesSociaisPage.obterBotaoSalvar().clicar();
    }

    public void selecionarEditarCategoria() {
        perfilEcPage.obterBotaoEditarCategoria().clicar();
    }

    public void editarCategoria(String categoria) {
        edicaoCategoriaPage.obterCardCategoria(categoria).clicar();
    }
    
    public String retornaCategoriaAtual() {
      return edicaoCategoriaPage.obterSelecaoAtual().obterTexto();
    }
    
}
