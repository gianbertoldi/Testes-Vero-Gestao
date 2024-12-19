package bergs.Bvr.Bvruaajm.test.validations.home;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.home.Bvruaajm_NotificacoesPage;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_NotificacoesValidations {

    Bvruaajm_NotificacoesPage notificacoesPage;
    
    private static final String TITULO_MSG = "TESTE TITULO";
    private static final String DESCRICAO_MSG = "TESTE DESCRICAO";
    private static final String TITULO_NOTIFICACAO_TELA_CHEIA = "Sua tela inicial está de cara nova!";
    private static final String DESCRICAO_NOTIFICACAO_TELA_CHEIA = "Agora ficou mais fácil de acessar as principais funcionalidades do app ;)";

    public Bvruaajm_NotificacoesValidations(AppiumDriver<WebElement> driver) {
        notificacoesPage = new Bvruaajm_NotificacoesPage(driver);
    }

    private boolean verificaSeBolinhaNotificaFoiLida(int numNotificacao) {
        try {
            notificacoesPage.obterStatusNotificacaoNaoLida();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void statusNotificacaoNaoLida(int numNotificacao) {
        Assertions.assertTrue(verificaSeBolinhaNotificaFoiLida(numNotificacao));
    }

    public void statusNotificacaoLida(int numNotificacao) {
        Assertions.assertFalse(verificaSeBolinhaNotificaFoiLida(numNotificacao));
    }
    
    public void validaImagemEstaNaTela(Bmouaajm_Elemento el) {
        Assertions.assertTrue(el.obterPropriedade("src").toString().contains("/data/bvrdmsim_12780"), "A imagem não esta na tela");
    }
    
    public void validarNotificacaoTelaCheia() {
        Assertions.assertEquals(TITULO_NOTIFICACAO_TELA_CHEIA, notificacoesPage.obterTextoTituloTelaCheia().obterTexto(), "Texto incoerente");
        Assertions.assertEquals(DESCRICAO_NOTIFICACAO_TELA_CHEIA, notificacoesPage.obterDescricaoTelaCheia().obterTexto(), "Texto incoerente");
    }
    
    public void validarNotificacao() {
        Assertions.assertEquals(TITULO_MSG, notificacoesPage.obterTextoMeiaModalNotificacaoTitulo().obterTexto(), "Texto incoerente");
        Assertions.assertEquals(DESCRICAO_MSG, notificacoesPage.obterTextoMeiaModalNotificacaoDescricao().obterTexto(), "Texto incoerente");
    }

}
