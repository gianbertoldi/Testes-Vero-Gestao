package bergs.Bvr.Bvruaajm.test.validations.conexoes.ofertas;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas.Bvruaajm_DetalhesOfertaRecusadaPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas.Bvruaajm_RevisaoOfertaPage;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_FileOperations;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_DetalhesDaOfertaValidation {

    private Bvruaajm_RevisaoOfertaPage revisaoOfertaPage;
    private Bvruaajm_DetalhesOfertaRecusadaPage ofertaRecusadaPage;

    public Bvruaajm_DetalhesDaOfertaValidation(AppiumDriver<WebElement> driver) {
        revisaoOfertaPage = new Bvruaajm_RevisaoOfertaPage(driver);
        ofertaRecusadaPage = new Bvruaajm_DetalhesOfertaRecusadaPage(driver);
    }

    public void validaRegrasDaOferta(String nome,String informativo, String descricaoOferta, String mensagemConsumo, String itensNaoInclusos, String mensagemInclusos,
            String mensagemOutros, String statusOferta, String dataCriacao, String dataExpiracao, String desativada) {
        assertAll(
                () -> assertTrue(revisaoOfertaPage.obterIconeEc().estaVisivel()),
                () -> assertEquals(revisaoOfertaPage.obterLabelTextoInformativo().obterTexto(), informativo),
                () -> assertTrue(revisaoOfertaPage.obterImagemCabecalho().estaVisivel()),
                () -> assertTrue(revisaoOfertaPage.obterIconeEc().estaVisivel()),
                () -> assertEquals(revisaoOfertaPage.obterNomeOferta().obterTexto(), nome),
                () -> assertEquals(revisaoOfertaPage.obterLabelHorario().scrollIntoView().obterTexto(),"Horário: " + Bvruaajm_FileOperations.obterPropriedade("regrasOfertas").getProperty("horarioInicial") + " às " + Bvruaajm_FileOperations.obterPropriedade("regrasOfertas").getProperty("horarioFinal")),
                () -> assertEquals(revisaoOfertaPage.obterLabelDescricao().scrollIntoView().obterTexto(), descricaoOferta),
                () -> assertEquals(revisaoOfertaPage.obterLabelRegrasValidasDetalhes().obterTexto(), mensagemConsumo),
                () -> {
                    if (!itensNaoInclusos.equals("null")) {
                        assertEquals(revisaoOfertaPage.obterLabelRegrasNaoIncluiDetalhes().scrollIntoView().obterTexto(), itensNaoInclusos);
                    }
                }, 
                () -> {
                    if (!mensagemInclusos.equals("nao")) {
                        assertEquals(revisaoOfertaPage.obterLabelRegrasItensInclusos().obterTexto(), mensagemInclusos);
                    }
                },
                () -> assertEquals(revisaoOfertaPage.obterLabelRegrasOutros().scrollIntoView().obterTexto() + revisaoOfertaPage.obterLabelRegrasOutrosSegundoTexto().obterTexto(), mensagemOutros),
                () -> assertEquals(revisaoOfertaPage.obterLabelDataCriacao().scrollIntoView().obterTexto(), "Criada em: " + dataCriacao),
                () -> {
                    if(statusOferta.equals("H")){
                        assertEquals(revisaoOfertaPage.obterLabelDataExpiracao().scrollIntoView().obterTexto(), "Essa oferta irá expirar em: " + dataExpiracao);
                    }else if(statusOferta.equals("E")){
                        assertEquals(revisaoOfertaPage.obterLabelDataExpirada().scrollIntoView().obterTexto(), "Expirada em: " + dataCriacao);
                    }
                },
                () -> {
                    if(desativada.equals("S") || statusOferta.equals("D")) {
                        assertEquals(revisaoOfertaPage.obterLabelDataDesativacao().scrollIntoView().obterTexto(), "Desativada em: " + dataCriacao);
                    }
                }
                );
    }
    
    public void validaOfertaDesativada(String dataDesativacao) {
        assertAll(
                () -> assertEquals(revisaoOfertaPage.obterLabelDataDesativacao().scrollIntoView().obterTexto(), "Desativada em: " + dataDesativacao),
                () -> assertEquals(revisaoOfertaPage.obterLabelTextoInformativo().obterTexto(), "Essa oferta foi desativada. Não é possível reativar no momento, mas você pode criar uma nova oferta.")

                );

    }

    public void validaOfertaRecusada(String dataRecusada , String nomeOferta, String icone ) {
        assertAll(
                () -> assertTrue(ofertaRecusadaPage.obterIcone().estaVisivel()),
                () -> assertEquals(icone, ofertaRecusadaPage.obterLabelTitulo().obterTexto()),
                () -> assertEquals("Sua oferta " + nomeOferta + ", criada em "+dataRecusada+", não foi aprovada pois possui itens considerados impróprios para divulgação. Não é possível fazer ajustes, mas lhe convidamos a criar uma nova oferta." , ofertaRecusadaPage.obterLabelMensagem().obterTexto())
                );
    }
}
