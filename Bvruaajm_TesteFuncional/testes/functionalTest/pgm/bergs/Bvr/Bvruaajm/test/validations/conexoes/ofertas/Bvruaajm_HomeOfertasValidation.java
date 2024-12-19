package bergs.Bvr.Bvruaajm.test.validations.conexoes.ofertas;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.homeOfertas.Bvruaajm_HomeOfertasPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.homeOfertas.Bvruaajm_OfertasDesativadasExpiradasPage;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Formatador;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_HomeOfertasValidation {

    private Bvruaajm_HomeOfertasPage homeOfertas;
    private Bvruaajm_OfertasDesativadasExpiradasPage ofertasDesativadasExpiradasPage;
    
    public Bvruaajm_HomeOfertasValidation(AppiumDriver<WebElement> driver) {
        homeOfertas = new Bvruaajm_HomeOfertasPage(driver);
        ofertasDesativadasExpiradasPage = new Bvruaajm_OfertasDesativadasExpiradasPage(driver);
    }
    
    public void validaHomeVazia(String titulo, String subtitulo, String botao) {
        assertAll(
                () -> assertEquals(titulo, homeOfertas.obterLabelTituloHomeVazia().obterTexto()),
                () -> assertEquals(subtitulo , homeOfertas.obterLabelSubtitulo().obterTexto()),
                () -> assertEquals(botao , homeOfertas.obterBotaoOferta().obterTexto()),
                () -> assertTrue(homeOfertas.obterIconeHomeVazia().estaVisivel())
                );
    }
    
    public void validaUltimaOfertaCriada(String nomeOferta, String valorDe, String valorPara, String statusDaOferta, String detalhesOferta, String ultimaOferta) {
        assertAll(
                () -> assertEquals(nomeOferta, homeOfertas.obterLabelNomeOferta().obterTexto()),
                () -> assertEquals("De R$ "+ Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(Double.parseDouble(valorDe)/100) + " por R$ "+ Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(Double.parseDouble(valorPara)/100), homeOfertas.obterLabelValoresDaOferta().obterTexto()),       
                () -> assertEquals(statusDaOferta, homeOfertas.obterLabelStatusOferta().obterTexto()),
                () -> assertEquals(detalhesOferta , homeOfertas.obterDetalhesDaOferta().obterTexto()),
                () -> assertTrue(homeOfertas.obterImagemOferta().estaVisivel()),
                () -> assertEquals(ultimaOferta, homeOfertas.obterLabelUltimaOferta().obterTexto())
                );
    }
    
    public void validaListarCardEmAnalise(String idOferta, String status, String nome, String valor ) {
        assertAll(
                () ->{
                    if(status.equals("Expiradas")) {
                        assertEquals("Expiradas", homeOfertas.obterLabelExpiradas().obterTexto());
                    }else {
                        assertEquals( status, homeOfertas.obterLabelCardStatusOferta().obterTexto());
                    }
                },
                () -> assertEquals( nome,homeOfertas.obterLabelCardNomeOferta(idOferta).obterTexto()),
                () -> assertEquals( valor,homeOfertas.obterLabelCardValoresOferta(idOferta).obterTexto())
                );
    }
    
    
    public void validaHomeOfertaDesativadaVazia(String ofertaDesativadaVazia, String mensagemOfertaDesativada) {
        assertAll(
                () -> assertEquals(ofertaDesativadaVazia, ofertasDesativadasExpiradasPage.labelTituloOfertasDesativadasVazia().obterTexto()),
                () -> assertEquals(mensagemOfertaDesativada, ofertasDesativadasExpiradasPage.labelMensagemOfertasDesativadasVazia().obterTexto()),
                () -> assertTrue(ofertasDesativadasExpiradasPage.iconeOfertasDesativadasVazia().estaVisivel())
                );
    }
    
    public void validaHomeOfertaExpiradaVazia(String titulo, String mensagem) {
        assertAll(
                () -> assertEquals(titulo, ofertasDesativadasExpiradasPage.labelTituloOfertasDesativadasVazia().obterTexto()),
                () -> assertEquals(mensagem, ofertasDesativadasExpiradasPage.labelMensagemOfertasDesativadasVazia().obterTexto()),
                () -> assertTrue(ofertasDesativadasExpiradasPage.iconeOfertasDesativadasVazia().estaVisivel())
                );
    }
    

    
}