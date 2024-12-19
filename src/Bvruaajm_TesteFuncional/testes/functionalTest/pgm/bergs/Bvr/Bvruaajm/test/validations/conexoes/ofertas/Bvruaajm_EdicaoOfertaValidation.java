package bergs.Bvr.Bvruaajm.test.validations.conexoes.ofertas;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.edicaoOferta.Bvruaajm_EdicaoOfertaPage;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_EdicaoOfertaValidation {

    private Bvruaajm_EdicaoOfertaPage edicaoOfertaPage;
    
    public Bvruaajm_EdicaoOfertaValidation(AppiumDriver<WebElement> driver) {
        edicaoOfertaPage = new Bvruaajm_EdicaoOfertaPage(driver);
    }
    
    public void validaTelaEdicaoDaOferta(String titulo , String subtitulo) {
        assertAll(
                () -> assertEquals(titulo , edicaoOfertaPage.labelTitulo().obterTexto()),
                () -> assertEquals(subtitulo , edicaoOfertaPage.labelSubtitulo().obterTexto()),
                () -> assertTrue(edicaoOfertaPage.botaoSalvar().estaHabilitado())
                );
    }
    
    public void validaTelaEdicaoRegras(String titulo, String subtitulo) {
        assertAll(
                () -> assertEquals(titulo , edicaoOfertaPage.labelTituloRegras().obterTexto()),
                () -> assertEquals(subtitulo , edicaoOfertaPage.labelSubtituloRegras().obterTexto()),
                () -> assertTrue(edicaoOfertaPage.botaoSalvar().estaHabilitado())
                );
    }
    
    public void validaTelaEdicaoNome(String titulo, String subtitulo) {
        assertAll(
                () -> assertEquals(titulo , edicaoOfertaPage.labelTitulo().obterTexto()),
                () -> assertEquals(subtitulo , edicaoOfertaPage.labelSubtitulo().obterTexto()),
                () -> assertTrue(edicaoOfertaPage.botaoSalvar().estaHabilitado())
                );
    }
    
    public void validaTelaEdicaoImagem(String titulo, String subtitulo) {
        assertAll(
                () -> assertEquals(titulo , edicaoOfertaPage.obterTituloImagem().obterTexto()),
                () -> assertEquals(subtitulo , edicaoOfertaPage.obterSubTituloImagem().obterTexto()),
                () -> assertTrue(edicaoOfertaPage.obterBotaoAlteraImagem().estaHabilitado())
                );
    }
    
    public void validaTelaEdicaoDiasDaOferta(String titulo, String subtitulo) {
        assertAll(
                () -> assertEquals(titulo , edicaoOfertaPage.labelTituloDiasDaOferta().obterTexto()),
                () -> assertEquals(subtitulo , edicaoOfertaPage.labelSubtituloDiasDaOferta().obterTexto()),
                () -> assertTrue(edicaoOfertaPage.botaoSalvar().estaHabilitado())
                );
    }


}
