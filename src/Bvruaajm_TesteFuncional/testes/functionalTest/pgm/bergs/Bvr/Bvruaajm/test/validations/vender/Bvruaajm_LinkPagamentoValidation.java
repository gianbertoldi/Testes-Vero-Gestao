package bergs.Bvr.Bvruaajm.test.validations.vender;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.generic.Bvruaajm_ElementoNativoPage;
import bergs.Bvr.Bvruaajm.test.pages.vender.Bvruaajm_LinkPagamentoPage;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Formatador;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_LinkPagamentoValidation {

    Bvruaajm_LinkPagamentoPage linkPage;
    Bvruaajm_ElementoNativoPage nativoPage;
    Bvruaajm_TaskMobile taskMobile;
    private static final String txtParcelas = "Parcelas de R$";
    Bmouaajm_Elemento elementos;

    public Bvruaajm_LinkPagamentoValidation(AppiumDriver<WebElement> driver) {

        linkPage = new Bvruaajm_LinkPagamentoPage(driver);
        nativoPage = new Bvruaajm_ElementoNativoPage(driver);
        taskMobile = new Bvruaajm_TaskMobile(driver);
    }

    public void validarUrlLinkPgtoCriado() {
        Assertions.assertTrue(validarUrlLinkPgtoEstaVisivel());
    }

    private boolean validarUrlLinkPgtoEstaVisivel() {
        try {
            linkPage.obterUrlLinkPgto();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void meiaModalAvaliacaoLinkEstaVisivel() {
        Assertions.assertTrue(linkPage.obterMeiaModalAvaliacaoLink().estaVisivel(), "Modal deveria estar visivel.");
    }

    public boolean validaTextoMsgAvaliacaoUmaOuDuasEstrelas() {
        return linkPage.obterTextoOquePodemosMelhorarAvaliacaoLink().estaVisivel();
    }

    public boolean validaTextoMsgAvaliacaoDeTresACincoEstrelas() {
        return linkPage.obterTextoLegalAvaliacaoLink().estaVisivel();
    }

    public void validarCampoValorEstaVisivel() {
        linkPage.obterCampoValorLink().estaVisivel();
    }

    public void validaIconeFaqLinkDireitaoVisivel() {
        taskMobile.definirContextoNativo();
        Assertions.assertTrue(nativoPage.obterBotaoDireito2().isDisplayed(), "Botão FAQ não esta visivel.");
        taskMobile.definirContextoWebview();
    }

    public void validarQuantidadePerguntasFaqLink(int qdtPergunta, int tamanhoList) {
        Assertions.assertEquals(qdtPergunta, tamanhoList, "Quantidade itens na lista diferente.");
    }

    public void validarQuantidadeParcelasLiberadas(int numeroParcelas, int tamanhoList) {
        Assertions.assertEquals(numeroParcelas, tamanhoList, "Quantidade itens na lista diferente.");
    }

    public void validarValorDaParcelar(double valor, int numParcelas) {
        String valorDaParcela = Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valor / numParcelas);        
        elementos = linkPage.obterNumeroDeParcelasLinkPgto().get(numParcelas -2);
        Assertions.assertEquals(txtParcelas + valorDaParcela, linkPage.valorDaParcela(elementos).obterTexto(), "valores não são iguais");
    }
    
}
