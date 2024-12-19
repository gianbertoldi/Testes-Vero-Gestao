package bergs.Bvr.Bvruaajm.test.tasks.servicos;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.generic.Bvruaajm_GenericPage;
import bergs.Bvr.Bvruaajm.test.pages.home.Bvruaajm_HomePage;
import bergs.Bvr.Bvruaajm.test.pages.servicos.Bvruaajm_MeusChamadosPage;
import bergs.Bvr.Bvruaajm.test.pages.servicos.Bvruaajm_ServicosPage;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.Bvr.Bvruaajm.test.validations.Bvruaajm_GenericValidation;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_MeusChamadosTask extends Bvruaajm_TaskMobile {

    Bvruaajm_ServicosPage servicoPage;
    Bvruaajm_GenericValidation genericValidation;
    Bvruaajm_GenericPage genericPage;
    Bvruaajm_HomePage homePage;
    Bvruaajm_MeusChamadosPage meusChamadosPage;
    Bvruaajm_Esperas esperas;
    String tituloCentralChamados = "Central de chamados";
    String cardMeusChamados = "Meus chamados";
    String cardNovoChamado = "Novo chamado";
    String classificacao = "Classificação:";

    public Bvruaajm_MeusChamadosTask(AppiumDriver<WebElement> driver) {
        super(driver);
        servicoPage = new Bvruaajm_ServicosPage(driver);
        genericValidation = new Bvruaajm_GenericValidation(driver);
        genericPage = new Bvruaajm_GenericPage(driver);
        homePage = new Bvruaajm_HomePage(driver);
        esperas = new Bvruaajm_Esperas(driver);
        meusChamadosPage = new Bvruaajm_MeusChamadosPage(driver);
    }
    
    public void validaTelaCentralDeChamados() {
        servicoPage.obterBotaoMeusChamados().clicar();
        genericValidation.validarTextosEsperadoEAtual(tituloCentralChamados, meusChamadosPage.obterTituloCentralDeChamados().obterTexto());
        genericValidation.validarTextosEsperadoEAtual(cardMeusChamados,  meusChamadosPage.obterTituloCardMeusChamados().obterTexto());
        genericValidation.validarTextosEsperadoEAtual(cardNovoChamado,  meusChamadosPage.obterTituloCardNovoChamado().obterTexto());
    }
    
    public void validaTelaCentralDeChamadosSemChamadosAbertos() {
        servicoPage.obterBotaoMeusChamados().clicar();
        genericValidation.validarTextosEsperadoEAtual(tituloCentralChamados, meusChamadosPage.obterTituloCentralDeChamados().obterTexto());
        genericValidation.validarTextosEsperadoEAtual(cardNovoChamado,  meusChamadosPage.obterTituloCardNovoChamado().obterTexto());
        esperas.aguardarTextoProcessandoDesaparecer();
        genericValidation.validaElementoEstaInvisivel(meusChamadosPage.obterCardMeusChamado());
    }
    
    public void validaMeusChamados() {
        servicoPage.obterBotaoMeusChamados().clicar();
        meusChamadosPage.obterBotaoMeusChamados().clicar();
        meusChamadosPage.obterMaisDetalhes().clicar();
        genericValidation.validarTextosEsperadoEAtual(classificacao, meusChamadosPage.obterTextoClassificao().obterTexto());
    }
}
