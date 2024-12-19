package bergs.Bvr.Bvruaajm.test.validations.conexoes.ofertas;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas.Bvruaajm_CriacaoOfertaSucessoPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas.Bvruaajm_DescricaoOfertasPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas.Bvruaajm_GenericOfertasPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas.Bvruaajm_InformativoOfertasPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas.Bvruaajm_RegrasUtilizacaoOfertaPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas.Bvruaajm_RevisaoOfertaPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas.Bvruaajm_SelecaoImagemOfertasPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas.Bvruaajm_ValorDaOfertaPage;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_FileOperations;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Formatador;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_CriacaoOfertasValidation {

    private Bvruaajm_InformativoOfertasPage informativoOfertasPage;
    private Bvruaajm_DescricaoOfertasPage descricaoOfertas;
    private Bvruaajm_ValorDaOfertaPage valorDaOferta;
    private Bvruaajm_GenericOfertasPage genericOfertasPage;
    private Bvruaajm_SelecaoImagemOfertasPage selecaoImagem;
    private Bvruaajm_RegrasUtilizacaoOfertaPage regrasOfertasPage;
    private Bvruaajm_RevisaoOfertaPage revisaoOfertaPage;
    private Bvruaajm_CriacaoOfertaSucessoPage criacaoSucessoPage;

    public Bvruaajm_CriacaoOfertasValidation(AppiumDriver<WebElement> driver) {
        informativoOfertasPage = new Bvruaajm_InformativoOfertasPage(driver);
        descricaoOfertas = new Bvruaajm_DescricaoOfertasPage(driver);
        genericOfertasPage = new Bvruaajm_GenericOfertasPage(driver);
        valorDaOferta = new Bvruaajm_ValorDaOfertaPage(driver);
        selecaoImagem = new Bvruaajm_SelecaoImagemOfertasPage(driver);
        regrasOfertasPage = new Bvruaajm_RegrasUtilizacaoOfertaPage(driver);
        revisaoOfertaPage = new Bvruaajm_RevisaoOfertaPage(driver);
        criacaoSucessoPage = new Bvruaajm_CriacaoOfertaSucessoPage(driver);
    }

    public void validaTelaInformativaOfertas(String informativoTitulo , String informativoSubtitulo , String informativoDetalhes , String informativoDefinaValor , String informativoImagem , String informativoRegras , String informativoAguardeAprovacao ) {
        assertAll(
                () -> assertEquals(informativoTitulo , informativoOfertasPage.obterTitulo().obterTexto()),
                () -> assertEquals(informativoSubtitulo ,informativoOfertasPage.obterSubtitulo().obterTexto()),
                () -> assertEquals(informativoDetalhes , informativoOfertasPage.obterLabelSobreOfertaPrimeiro().obterTexto()),
                () -> assertEquals(informativoDefinaValor , informativoOfertasPage.obterLabelSobreOfertaSegundo().obterTexto()),
                () -> assertEquals(informativoImagem ,informativoOfertasPage.obterLabelSobreOfertasTerceiro().obterTexto()),
                () -> assertEquals(informativoRegras ,informativoOfertasPage.obterLabelSobreOfertasQuarto().obterTexto()),
                () -> assertEquals(informativoAguardeAprovacao ,informativoOfertasPage.obterLabelSobreOfertasQuinto().obterTexto()),

                () -> {
                    for (int i = 1; i <= 5; i++) {
                        assertTrue(informativoOfertasPage.obterIcones(i).estaVisivel());
                    }
                });
    }

    public void validaEtapaDescricaoDaOferta(String titulo , String subtitulo , String botaoCancelar) {
        assertAll(
                () -> assertEquals(titulo, descricaoOfertas.obterLabelTitulo().obterTexto()),
                () -> assertEquals(subtitulo,descricaoOfertas.obterLabelSubtitulo().obterTexto()),
                () -> assertTrue(descricaoOfertas.obterCampoTextoNomeOferta().estaVisivel()),
                () -> assertTrue(descricaoOfertas.obterCampoTextoDescricaoOferta().estaVisivel()),
                () -> assertTrue(genericOfertasPage.obterBotaoContinuar().getAttribute("disabled") != null),
                () -> assertEquals(botaoCancelar, genericOfertasPage.obterBotaoCancelar().obterTexto()));
    }

    public void valdiaEtapaValoresDaOferta(String tituloValor, String subtituloValor, String botaoCancelar) {
        assertAll(
                () -> assertEquals(tituloValor, valorDaOferta.obterLabelTituloValorOferta().obterTexto()),
                () -> assertEquals(subtituloValor,valorDaOferta.obterLabelSubtitulo().obterTexto()),
                () -> assertTrue(genericOfertasPage.obterBotaoContinuar().getAttribute("disabled") != null),
                () -> assertEquals(botaoCancelar, genericOfertasPage.obterBotaoCancelar().obterTexto()));
    }

    public void validaMensagemDeValoresIncorretos(String mensagemDe, String mensagemPor) {
        assertAll(
                () -> assertEquals(mensagemDe, valorDaOferta.obterLabelMensagemErroCampoDe().obterTexto()),
                () -> assertEquals(mensagemPor, valorDaOferta.obterLabelMensagemErroCampoPor().obterTexto()),
                () -> assertTrue(genericOfertasPage.obterBotaoContinuar().getAttribute("disabled") != null));
    }

    public void validaEtapaSelecaoImagemOferta(String titulo, String subtitulo) {
        assertAll(
                () -> assertEquals(titulo, selecaoImagem.obterLabelTituloImagem().obterTexto()),
                () -> assertEquals(subtitulo, selecaoImagem.obterLabelSubtituloImagem().obterTexto()),
                () -> assertFalse(selecaoImagem.obterSrcImagem().obterAtributo("src").equals("/bvr/multimidia/bvrdvcia_sem_imagem_selecionada.svg")));

    }

    public void validaEtapaRegrasUtilizacaoOferta(String titulo, String subtitulo) {
        assertAll(
                () -> assertEquals(titulo, regrasOfertasPage.obterTitulo().obterTexto()),
                () -> assertEquals(subtitulo, regrasOfertasPage.obrterSubtitulo().obterTexto()));
    }

    public void validaRegrasDaOferta(String nome , String descricaoOferta , String mensagemConsumo , String itensNaoInclusos , String mensagemInclusos , String mensagemOutros ) {
        assertAll(
                () -> assertTrue(revisaoOfertaPage.obterImagemCabecalho().estaVisivel()),
                () -> assertTrue(revisaoOfertaPage.obterIconeEc().estaVisivel()),
                () -> assertEquals(revisaoOfertaPage.obterNomeOferta().obterTexto(), nome),
                () -> assertEquals(revisaoOfertaPage.obterLabelHorario().scrollIntoView().obterTexto(), "Horário: " + Bvruaajm_FileOperations.obterPropriedade("regrasOfertas").getProperty("horarioInicial") + " às " + Bvruaajm_FileOperations.obterPropriedade("regrasOfertas").getProperty("horarioFinal")),
                () -> assertEquals(revisaoOfertaPage.obterLabelDescricao().scrollIntoView().obterTexto(), descricaoOferta),
                () -> assertEquals(revisaoOfertaPage.obterLabelRegrasValidas().obterTexto(), mensagemConsumo),
                () -> {  
                        if(!itensNaoInclusos.equals("null")) {
                           assertEquals(revisaoOfertaPage.obterLabelRegrasNaoInclui().scrollIntoView().obterTexto(), itensNaoInclusos);
                         }
                },
                () -> {
                        if(!mensagemInclusos.equals("null")) {
                           assertEquals(revisaoOfertaPage.obterLabelRegrasItensInclusos().obterTexto(), mensagemInclusos);  
                        }
                },
                () -> assertEquals(revisaoOfertaPage.obterLabelRegrasOutros().scrollIntoView().obterTexto() + revisaoOfertaPage.obterLabelRegrasOutrosSegundoTexto().obterTexto(), mensagemOutros));
    }

    public void validaBotaoContinuarDesabilitado() {
        assertTrue(genericOfertasPage.obterBotaoContinuar().getAttribute("disabled") != null);
    }

    public void validaConsumoNoLocalSelecionado() {
        assertEquals("bag-filter-button ativo", regrasOfertasPage.obterFormaConsumoLocal().obterAtributo("class"));
    }

    public void validaConsumoMultiplosSelecionado() {
        assertAll(
                () -> assertEquals("bag-filter-button ativo", regrasOfertasPage.obterFormaConsumoLocal().obterAtributo("class")),
                () -> assertEquals("bag-filter-button ativo", regrasOfertasPage.obterFormaRetirada().obterAtributo("class")),
                () -> assertEquals("bag-filter-button ativo", regrasOfertasPage.obterFormaEntregre().obterAtributo("class")));
    }

    public void validaDiasDaSemanaSelecionado() {
        assertAll(
                () -> assertEquals("bag-filter-button ativo", regrasOfertasPage.obterBotaoQuandoSegunda().obterAtributo("class")),
                () -> assertEquals("bag-filter-button ativo", regrasOfertasPage.obterBotaoQuandoTerca().obterAtributo("class")),
                () -> assertEquals("bag-filter-button ativo", regrasOfertasPage.obterBotaoQuandoQuarta().obterAtributo("class")),
                () -> assertEquals("bag-filter-button ativo", regrasOfertasPage.obterBotaoQuandoQuinta().obterAtributo("class")),
                () -> assertEquals("bag-filter-button ativo", regrasOfertasPage.obterBotaoQuandoSexta().obterAtributo("class")),
                () -> assertEquals("bag-filter-button ativo", regrasOfertasPage.obterBotaoQuandoSabado().obterAtributo("class")),
                () -> assertEquals("bag-filter-button ativo", regrasOfertasPage.obterBotaoQuandoDomingo().obterAtributo("class")),
                () -> assertEquals("bag-filter-button", regrasOfertasPage.obterBotaoQuandoTodosDias().obterAtributo("class")));
    }

    public void validaBotaoDiaSelecionado(String dia) {
        assertAll(
                () -> assertTrue(regrasOfertasPage.obterLabelDiasSemana(dia).obterAtributo("class").contains("ativo"))
                );
    }
    
    public void validaBotaoDiaNaoSelecionado(String dia) {
        assertAll(
                () -> assertFalse(regrasOfertasPage.obterLabelDiasSemana(dia).obterAtributo("class").contains("ativo"))
                );
    }

    public void validaSpamErroHorario(String spam) {
        assertAll(
                () -> assertTrue(genericOfertasPage.obterBotaoContinuar().getAttribute("disabled") != null),
                () -> assertTrue(regrasOfertasPage.obterSpamHorario().estaVisivel()),
                () -> assertEquals(spam ,regrasOfertasPage.obterSpamHorario().obterTexto()));
    }

    public void validaBotaoHorarioFinalDesabilitado() {
        assertFalse(regrasOfertasPage.obterBotaoHoraFinal().estaHabilitado());
    }

    public void validaTootlTip(String toolTip) {
        assertEquals(toolTip, regrasOfertasPage.obterTooltip().obterTexto());
    }
    
    public void validaTelaSucessoCriacao(String mensagem, String titulo, String botaoIr, String spam) {
        assertAll(
                () -> assertEquals(mensagem , criacaoSucessoPage.obterLabelMensagem().obterTexto()),
                () -> assertEquals(titulo, criacaoSucessoPage.obterLabelTitulo().obterTexto()),
                () -> assertTrue(criacaoSucessoPage.obterIcone().estaVisivel()),
                () -> assertEquals(botaoIr, criacaoSucessoPage.obterBotaoIrParaOPrograma().obterTexto()),
                () -> assertEquals(spam, criacaoSucessoPage.obterSpam().obterTexto())
        );
    }
    
    public void validaEdicaoDeDescricao(String novaDescrcao) {
        assertFalse(revisaoOfertaPage.obterLabelDescricao().scrollIntoView().obterTexto().equals(novaDescrcao));
    }
    
    public void validaEdicaoDiasOferta(String dia) {
        assertEquals("ativo", revisaoOfertaPage.obterDiaDaSemana(dia).obterAtributo("class"));
    }
    
    public void validaEdicaoHorarioOferta() {
        assertEquals(revisaoOfertaPage.obterLabelHorario().scrollIntoView().obterTexto(), "Horário: " + Bvruaajm_FileOperations.obterPropriedade("regrasOfertas").getProperty("horarioInicial") + " às " + Bvruaajm_FileOperations.obterPropriedade("regrasOfertas").getProperty("horarioFinal"));
    }
    
    public void validaEdicaoDoNomeOferta(String novoNome , String nomeAntigo) {
        assertEquals(novoNome , revisaoOfertaPage.obterNomeOferta().scrollIntoView().obterTexto());
        assertFalse(revisaoOfertaPage.obterNomeOferta().scrollIntoView().obterTexto().equals(nomeAntigo));
    }
    
    public void validaEdicaoRegrasDaOferta(String mensagemConsumoNova, String mensagemOutrosPrimeiraNova, String mensagemOutrosSegundaNova,String mensagemConsumoAntiga,String mensagemOutrosPrimeiraAntiga, String mensagemOutrosSegundaAntiga) {
        assertAll(
                () -> assertEquals(revisaoOfertaPage.obterLabelRegrasValidas().scrollIntoView().obterTexto(), mensagemConsumoNova),
                () -> assertEquals(revisaoOfertaPage.obterLabelRegrasOutros().scrollIntoView().obterTexto(), mensagemOutrosPrimeiraNova),
                () -> assertEquals(revisaoOfertaPage.obterLabelRegrasOutrosSegundoTexto().obterTexto(), mensagemOutrosSegundaNova),
                () -> assertFalse(revisaoOfertaPage.obterLabelRegrasValidas().scrollIntoView().obterTexto().equals(mensagemConsumoAntiga)),
                () -> assertFalse(revisaoOfertaPage.obterLabelRegrasOutros().scrollIntoView().obterTexto().equals(mensagemOutrosPrimeiraAntiga)),
                () -> assertFalse(revisaoOfertaPage.obterLabelRegrasOutrosSegundoTexto().obterTexto().equals(mensagemOutrosSegundaAntiga))
                );
    }
    
    public void validaEdicaoValoresOferta(String valorDeNovo, String valorPorNovo, String valorAnteriorAntigo, String valorDepoisAntigo) {
        assertAll(
                () -> assertEquals(revisaoOfertaPage.obterLabelValorAnterior().scrollIntoView().obterTexto(),"R$ "+ Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(Double.parseDouble(valorPorNovo)/100)),
                () -> assertEquals(revisaoOfertaPage.obterLabelValorDepois().scrollIntoView().obterTexto(), "R$ "+ Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(Double.parseDouble(valorDeNovo)/100)),
                () -> assertFalse(revisaoOfertaPage.obterLabelValorAnterior().obterTexto().equals("R$ "+ Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(Double.parseDouble(valorDepoisAntigo)/100))),
                () -> assertFalse(revisaoOfertaPage.obterLabelValorDepois().obterTexto().equals("R$ "+ Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(Double.parseDouble(valorAnteriorAntigo)/100)))                
                );
    }
    
    public void validaEdicaoDaImagem(String primeiraImagem, String segundaImagem) {
        assertAll(
                () -> assertTrue(revisaoOfertaPage.obterImagemCabecalho().estaVisivel()),
                () -> assertFalse(primeiraImagem.equals(segundaImagem))
                );
    }
}