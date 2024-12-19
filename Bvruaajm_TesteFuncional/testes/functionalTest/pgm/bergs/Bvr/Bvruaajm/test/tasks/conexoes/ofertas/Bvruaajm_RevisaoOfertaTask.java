package bergs.Bvr.Bvruaajm.test.tasks.conexoes.ofertas;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas.Bvruaajm_RevisaoOfertaPage;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_RevisaoOfertaTask extends Bvruaajm_TaskMobile{
    
    private Bvruaajm_RevisaoOfertaPage revisaoOfertaPage;
    
    public Bvruaajm_RevisaoOfertaTask(AppiumDriver<WebElement>driver) {
        super(driver);
        revisaoOfertaPage = new Bvruaajm_RevisaoOfertaPage(driver);
    }
    
    public void editarInformacoesOferta(String campoSerEditado) {
        espera.aguardarCondicao(driver -> revisaoOfertaPage.obterIconeEdicaoDosCampos(campoSerEditado).clicar() ,30);
    }
    
    public void desativarOferta() {
        revisaoOfertaPage.obterBotaoDesativarOferta().clicar();
        revisaoOfertaPage.obterBotaoConfirmarDesativar().clicar();
    }
    public void editarImagemOferta() {
        espera.aguardarCondicao(driver -> revisaoOfertaPage.obterBotaoEditarImagem().clicar() ,30);
    }
    
    public String obterSrcImagem() {
        String srcImagem = revisaoOfertaPage.obterImagemCabecalho().obterAtributo("src").toString();
        return srcImagem.substring(Math.max(0, srcImagem.length() - 20));
    }
}
