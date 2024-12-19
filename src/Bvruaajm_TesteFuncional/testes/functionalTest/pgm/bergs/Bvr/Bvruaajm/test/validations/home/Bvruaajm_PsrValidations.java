package bergs.Bvr.Bvruaajm.test.validations.home;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.home.Bvruaajm_HomePage;
import bergs.Bvr.Bvruaajm.test.pages.home.psr.Bvruaajm_PsrPage;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_PsrValidations {

    Bvruaajm_PsrPage psrPage;
    Bvruaajm_HomePage homePage;
    private static final String TITULO_SOLICITACAO_ENVIADA = "Solicita��o enviada!";
    private static final String TEXTO_SOLICITACAO_ENVIADA = "Sua solicita��o foi enviada para:";
    private static final String SOLICITACAO_PARA_CIELO = "Cielo";
    private static final String SOLICITACAO_GETNET_PENDENTE = "Sua solicita��o est� pendente.";
    private static final String SOLICITACAO_CIELO_HABILITADO = "Voc� j� pode vender via Banricompras.";

    public Bvruaajm_PsrValidations(AppiumDriver<WebElement> driver) {
        psrPage = new Bvruaajm_PsrPage(driver);
        homePage = new Bvruaajm_HomePage(driver);
    }

    public void solicitacaoCieloEnviada() {
        Assertions.assertTrue(psrPage.obterTituloSolicitacaoEnviadaPsr().obterTexto().contains(TITULO_SOLICITACAO_ENVIADA), "Texto incoerente");
        Assertions.assertTrue(psrPage.obterTextoSolicitacaoEnviadaPsr().obterTexto().contains(TEXTO_SOLICITACAO_ENVIADA), "Texto incoerente");
        Assertions.assertTrue(psrPage.obterTextoSolicitacaoEnviadaPsr().obterTexto().contains(SOLICITACAO_PARA_CIELO), "Texto incoerente");
    }

    public void solicitacaoGetNetPendente() {
        Assertions.assertTrue(psrPage.obterTextoMinhaSolicitacaoPendenteGetNet().obterTexto().contains(SOLICITACAO_GETNET_PENDENTE), "Texto incoerente");
    }
    
    public void solicitacaoCieloHabilitada() {
        Assertions.assertTrue(psrPage.obterTextoMinhaSolicitacaoHabilitadaCielo().obterTexto().contains(SOLICITACAO_CIELO_HABILITADO), "Texto incoerente");
    }

}
