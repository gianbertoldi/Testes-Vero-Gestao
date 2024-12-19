package bergs.Bvr.Bvruaajm.test.tasks.vender;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.home.Bvruaajm_HomePage;
import bergs.Bvr.Bvruaajm.test.pages.vender.Bvruaajm_LinkPgtoPsrPage;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.validations.Bvruaajm_GenericValidation;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_SolicitacaoLinkPgtoPsrTask extends Bvruaajm_TaskMobile {

    Bvruaajm_LinkPgtoPsrPage linkPsrPage;
    Bvruaajm_HomePage homePage;
    Bvruaajm_GenericValidation genericValidation;
    Bvruaajm_JsExecutor jsExecutor;
    String linkPgtoExplicacao = "O Link de Pagamento � uma forma pr�tica, r�pida e segura de receber pagamentos de forma 100% digital.";
    String linkPgtoVendaCartao = "Venda via cart�o de cr�dito, em at� 18 vezes, e sem nenhum custo de ades�o ou taxa adicional!";
    String linkPgtoAcompanheVenda = "Acompanhe suas vendas em tempo real e tenha acesso a um hist�rico completo de todos os links criados.";
    String linkPgtoQuemUsaAprova = "Quem usa, aprova: mais de 92% dos nossos usu�rios aprovam o link pela praticidade e agilidade!";
    String textoFooterFaciliteVendas = "Facilite suas vendas com o Link de Pagamento da Vero! Entre em contato conosco para impulsionar suas vendas :)";
    String txtConversarVero = "Como voc� prefere conversar com a Vero?";

    public Bvruaajm_SolicitacaoLinkPgtoPsrTask(AppiumDriver<WebElement> driver) {
        super(driver);
        linkPsrPage = new Bvruaajm_LinkPgtoPsrPage(driver);
        homePage = new Bvruaajm_HomePage(driver);
        genericValidation = new Bvruaajm_GenericValidation(driver);
        jsExecutor = new Bvruaajm_JsExecutor(driver);
    }

    public void validaSolicitacaoLinkPgtoPsr() {
        genericValidation.validarTextosEsperadoEAtual(linkPgtoExplicacao, linkPsrPage.obterTextoCardAtualCarrossel().obterTexto());

        jsExecutor.sliderCarrosselBloqueioLinkPgtoPsr();
        genericValidation.validarTextosEsperadoEAtual(linkPgtoVendaCartao, linkPsrPage.obterTextoCardAtualCarrossel().obterTexto());

        jsExecutor.sliderCarrosselBloqueioLinkPgtoPsr();
        genericValidation.validarTextosEsperadoEAtual(linkPgtoAcompanheVenda, linkPsrPage.obterTextoCardAtualCarrossel().obterTexto());

        jsExecutor.sliderCarrosselBloqueioLinkPgtoPsr();
        genericValidation.validarTextosEsperadoEAtual(linkPgtoQuemUsaAprova, linkPsrPage.obterTextoCardAtualCarrossel().obterTexto());

        genericValidation.validarTextosEsperadoEAtual(textoFooterFaciliteVendas, linkPsrPage.obterTextoFaciliteSuasVendas().obterTexto());

        linkPsrPage.obterBotaoEuQuero().clicar();

        genericValidation.validarTextosEsperadoEAtual(txtConversarVero, homePage.obterTituloConversarComVero().obterTexto());
    }
}
