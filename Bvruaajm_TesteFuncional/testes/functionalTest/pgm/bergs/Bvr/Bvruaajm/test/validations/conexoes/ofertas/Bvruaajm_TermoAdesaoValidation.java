package bergs.Bvr.Bvruaajm.test.validations.conexoes.ofertas;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.termoAdesao.Bvruaajm_TermoDeAdesaoPage;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_TermoAdesaoValidation {
    
    private Bvruaajm_TermoDeAdesaoPage termoAdesaoPage;

    public Bvruaajm_TermoAdesaoValidation(AppiumDriver<WebElement>driver) {
        termoAdesaoPage = new Bvruaajm_TermoDeAdesaoPage(driver);
    }

    public void validaTelaTermoDeAdesao(String titulo, String subtitulo) {
        assertAll(
                () -> assertEquals(titulo, termoAdesaoPage.obterLabelTitulo().obterTexto()),
                () -> assertEquals(subtitulo,termoAdesaoPage.obterLabelSubtitulo().obterTexto()),
                () -> assertTrue(termoAdesaoPage.obterLinkTermoAdesao().obterAtributo("onclick").contains("TermoAdesao.downloadPDF") , "Não contem function termo de adesao")
                );

    }
    
    public void validaModalTermoMaisUmaAssinatura(String tituloModal,String subtituloModal) {
        assertAll(
                () -> assertEquals(tituloModal, termoAdesaoPage.obterTituloModal().obterTexto()),
                () -> assertEquals(subtituloModal, termoAdesaoPage.obterSubtituloModal().obterTexto())
                );
    }
}
