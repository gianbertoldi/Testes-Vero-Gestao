package bergs.Bvr.Bvruaajm.test.tasks.conexoes.ofertas;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.conexoes.imagem.Bvruaajm_GaleriaDeImagemPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas.Bvruaajm_SelecaoImagemOfertasPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.edicaoOferta.Bvruaajm_EdicaoOfertaPage;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_EdicaoOfertaTask extends Bvruaajm_TaskMobile{
    
    private Bvruaajm_EdicaoOfertaPage edicaoOfertaPage;
    private Bvruaajm_SelecaoImagemOfertasPage selecaoImagem;
    private Bvruaajm_GaleriaDeImagemPage galeriaImagem;
    
    public Bvruaajm_EdicaoOfertaTask(AppiumDriver<WebElement> driver) {
        super(driver);
        edicaoOfertaPage = new Bvruaajm_EdicaoOfertaPage(driver);
        selecaoImagem = new Bvruaajm_SelecaoImagemOfertasPage(driver);
        galeriaImagem = new Bvruaajm_GaleriaDeImagemPage(driver);
    }
    
    public void alterarDescricao(String novaDescricao) {
        edicaoOfertaPage.campoDeTextoDescricao().preencher(novaDescricao);
        edicaoOfertaPage.botaoSalvar().clicar();
    }
    
    public void alterarNome(String nomeOferta) {
        edicaoOfertaPage.cmapoDeTextoNome().limpar().preencher(nomeOferta);
    }
    
    public void salvarEdicao() {
        edicaoOfertaPage.botaoSalvar().clicar();
    }
    
    public void alteraImagemEdicao(String edicao) {
        edicaoOfertaPage.obterBotaoAlteraImagem().clicar();
        selecaoImagem.obterBotaoEscolherGaleria().clicar();
        definirContextoNativo();
        galeriaImagem.obterImagem(edicao).click();
        definirContextoWebview();
        edicaoOfertaPage.obterBotaoAlteraImagem().clicar();
    }
}
