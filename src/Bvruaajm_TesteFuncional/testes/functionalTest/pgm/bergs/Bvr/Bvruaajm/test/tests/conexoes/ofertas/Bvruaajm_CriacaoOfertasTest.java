package bergs.Bvr.Bvruaajm.test.tests.conexoes.ofertas;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import bergs.Bvr.Bvruaajm.test.tasks.conexoes.ofertas.Bvruaajm_CriacaoOfertasTask;
import bergs.Bvr.Bvruaajm.test.tasks.conexoes.ofertas.Bvruaajm_HomeOfertasTask;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskBag;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobileBag;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBag;
import bergs.Bvr.Bvruaajm.test.utils.constantes.ofertas.Bvruaajm_CriacaoPerfilSucessoConstante;
import bergs.Bvr.Bvruaajm.test.utils.constantes.ofertas.Bvruaajm_DescricaoCriacaoOfertaConstante;
import bergs.Bvr.Bvruaajm.test.utils.constantes.ofertas.Bvruaajm_InstruicoesCriacaoOfertaConstante;
import bergs.Bvr.Bvruaajm.test.utils.constantes.ofertas.Bvruaajm_RegrasUtilizacaoConstante;
import bergs.Bvr.Bvruaajm.test.utils.constantes.ofertas.Bvruaajm_SelecaoImagemConstante;
import bergs.Bvr.Bvruaajm.test.utils.constantes.ofertas.Bvruaajm_SpanHorarioConstante;
import bergs.Bvr.Bvruaajm.test.utils.constantes.ofertas.Bvruaajm_UltimaOfertaCriadaConstante;
import bergs.Bvr.Bvruaajm.test.utils.constantes.ofertas.Bvruaajm_ValoresDaOfertaConstante;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumServidores;
import bergs.Bvr.Bvruaajm.test.utils.enums.conexao.oferta.Bvruaajm_EnumDiasSemanaOfertas;
import bergs.Bvr.Bvruaajm.test.utils.enums.conexao.oferta.Bvruaajm_EnumStatusDaOferta;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;
import bergs.Bvr.Bvruaajm.test.validations.conexoes.ofertas.Bvruaajm_CriacaoOfertasValidation;
import bergs.Bvr.Bvruaajm.test.validations.conexoes.ofertas.Bvruaajm_HomeOfertasValidation;

public class Bvruaajm_CriacaoOfertasTest extends Bvruaajm_TesteBaseMobileBag {


    private Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.Vinicius.obterCartaoAcesso();
    private Bvruaajm_Estabelecimento estabeleciomento = Bvruaajm_EnumEstabelecimentoConveniado.BetosLancheriaLtda.obterEstabelecimento();
    
    private Bvruaajm_HomeOfertasTask home;
    private Bvruaajm_CriacaoOfertasValidation criacaoOfertasValidation; 
    private Bvruaajm_CriacaoOfertasTask criacaoOfertas;
    private Bvruaajm_SqlBag sqlBag;
    private Bvruaajm_TaskBag taskBag;
    private Bvruaajm_HomeOfertasValidation homeValidation;


    @BeforeEach
    public void antesDoTeste() {
        sqlBag = new Bvruaajm_SqlBag();
        sqlBag.deletarOfertaEc(estabeleciomento.obterCnpjZerosAEsquerda());
        taskBag.verificaServidorUsuarioLogado(cartaoAcesso , estabeleciomento , Bvruaajm_EnumServidores.WW27.toString());
    }

    @ParameterizedTest
    @Tag("BAG")
    @Tag("regressaoObrigaotriaBag")
    @CsvFileSource(resources = "/csv/regrasOfertas.csv", delimiter = ';', numLinesToSkip = 1)
    public void criarOfertaPelaHome(String nome , String descricaoOferta , String valorDe , String valorPor , String consumoOferta , String consumoRetirada , String consumoLocal , String intensCouvert , String itensSobremesa , String itensTaxa , String itensBebidas ,  String outrosOfertas , String outrosFeriados , String mensagemConsumo , String mensagemItensNaoInclusos, String mensagemInclusos , String mensagemOutros) {
        List<String> todosDias = Arrays.asList(Bvruaajm_EnumDiasSemanaOfertas.diasDaSemanaAleatorios().toString());
        home.criarUmaOferta();
        criacaoOfertasValidation.validaTelaInformativaOfertas(Bvruaajm_InstruicoesCriacaoOfertaConstante.INSTRUCOES_OFERTAS_TITULO , Bvruaajm_InstruicoesCriacaoOfertaConstante.INSTRUCOES_OFERTAS_SUBTITULO ,  Bvruaajm_InstruicoesCriacaoOfertaConstante.INSTRUCOES_OFERTAS_DETALHES_INFORMACAO , Bvruaajm_InstruicoesCriacaoOfertaConstante.INSTRUCOES_OFERTAS_DEFINA_VALOR , Bvruaajm_InstruicoesCriacaoOfertaConstante.INSTRUCOES_OFERTAS_IMAGEM , Bvruaajm_InstruicoesCriacaoOfertaConstante.INSTRUCOES_OFERTAS_REGRAS , Bvruaajm_InstruicoesCriacaoOfertaConstante.INSTRUCOES_OFERTAS_AGUARDE_APROVACAO);
        criacaoOfertas.avancarEtapaInformativaOferta();
        criacaoOfertasValidation.validaEtapaDescricaoDaOferta(Bvruaajm_DescricaoCriacaoOfertaConstante.DESCRICAO_TITULO , Bvruaajm_DescricaoCriacaoOfertaConstante.DESCRICAO_SUBTITULO , Bvruaajm_DescricaoCriacaoOfertaConstante.DESCRICAO_CANCELAR_CADASTRO);
        criacaoOfertas.preencheEtapaDescricaoOferta(nome, descricaoOferta);
        criacaoOfertas.avancarEtapa();
        criacaoOfertasValidation.valdiaEtapaValoresDaOferta(Bvruaajm_ValoresDaOfertaConstante.TITULO_VALOR, Bvruaajm_ValoresDaOfertaConstante.SUBTITULO_VALOR, Bvruaajm_ValoresDaOfertaConstante.BOTAO_CANCELAR);
        criacaoOfertas.preencherEtapaValorDaOferta(valorDe, valorPor);
        criacaoOfertas.avancarEtapa();
        criacaoOfertas.selecionarImagemDaOferta();
        criacaoOfertasValidation.validaEtapaSelecaoImagemOferta(Bvruaajm_SelecaoImagemConstante.TITULO, Bvruaajm_SelecaoImagemConstante.SUBTITULO);
        criacaoOfertas.avancarEtapaImagem();
        criacaoOfertasValidation.validaEtapaRegrasUtilizacaoOferta(Bvruaajm_RegrasUtilizacaoConstante.TITULO, Bvruaajm_RegrasUtilizacaoConstante.SUBTITULO);
        criacaoOfertas.selecionarRegrasDaOferta(todosDias, consumoOferta  , consumoRetirada , consumoLocal ,  intensCouvert , itensSobremesa , itensTaxa , itensBebidas , outrosOfertas , outrosFeriados);
        criacaoOfertas.avancarEtapa();
        criacaoOfertasValidation.validaRegrasDaOferta(nome , descricaoOferta , mensagemConsumo , mensagemItensNaoInclusos , mensagemInclusos , mensagemOutros );
        criacaoOfertas.avancarEtapa();
        criacaoOfertasValidation.validaTelaSucessoCriacao(Bvruaajm_CriacaoPerfilSucessoConstante.MENSAGEM, Bvruaajm_CriacaoPerfilSucessoConstante.TITULO, Bvruaajm_CriacaoPerfilSucessoConstante.BOTAO_IR, Bvruaajm_CriacaoPerfilSucessoConstante.SPAM);     
        criacaoOfertas.avancarEtapaConfirmacao();
        
        homeValidation.validaUltimaOfertaCriada(nome, valorDe, valorPor,Bvruaajm_EnumStatusDaOferta.ANALISE.toString(), Bvruaajm_UltimaOfertaCriadaConstante.DETALHES_OFERTA, Bvruaajm_UltimaOfertaCriadaConstante.ULTIMA_OFERTA_CRIADA);
    }

    @ParameterizedTest
    @Tag("BAG")
    @CsvFileSource(resources = "/csv/valoresOfertas.csv", delimiter = ';', numLinesToSkip = 2)
    public void validaDadosDosValoresDaOferta(String valorDe, String valorPor, String mensagemDe, String mensagemPor) {
        home.criarUmaOferta();
        criacaoOfertas.avancarEtapaInformativaOferta();
        criacaoOfertas.preencheEtapaDescricaoOferta("teste", "teste");
        criacaoOfertas.avancarEtapa();
        criacaoOfertas.preencherEtapaValorDaOferta(valorDe, valorPor);
        criacaoOfertasValidation.validaMensagemDeValoresIncorretos(mensagemDe, mensagemPor);
    }


    @Test
    @Tag("BAG")
    @DisplayName("Teste para verificar se ao selecionar o 'todos os dias' demais dias serão desmarcado")
    public void regrasOfertaQuandoTodosDias() {
        List<String> diasDaOferta = Arrays.asList(Bvruaajm_EnumDiasSemanaOfertas.SEGUNDA.toString(), Bvruaajm_EnumDiasSemanaOfertas.TERCA.toString(), Bvruaajm_EnumDiasSemanaOfertas.QUARTA.toString(), Bvruaajm_EnumDiasSemanaOfertas.QUINTA.toString(), Bvruaajm_EnumDiasSemanaOfertas.SEXTA.toString(), Bvruaajm_EnumDiasSemanaOfertas.SABADO.toString(), Bvruaajm_EnumDiasSemanaOfertas.DOMINGO.toString());
        List<String> todosDias = Arrays.asList("Todos os dias");
        home.criarUmaOferta();
        criacaoOfertas.criarOfertaRegrasDaOferta("teste", "teste", "100", "099");
        criacaoOfertas.selecionarDiasDaOferta(diasDaOferta);
        criacaoOfertasValidation.validaDiasDaSemanaSelecionado();
        criacaoOfertas.selecionarDiasDaOferta(todosDias);
        criacaoOfertasValidation.validaBotaoDiaSelecionado(Bvruaajm_EnumDiasSemanaOfertas.TODOS_OS_DIAS.toString());
    }

    @Test
    @Tag("BAG")
    @DisplayName("Teste para verificar se é possivel horario final ser menor que o inicial")
    public void regrasOfertaQuandoHorarioFinalMenor() {
        List<String> diasAleatorios = Arrays.asList(Bvruaajm_EnumDiasSemanaOfertas.diasDaSemanaAleatorios().toString());

        home.criarUmaOferta();
        criacaoOfertas.criarOfertaRegrasDaOferta("teste", "teste", "100", "099");
        criacaoOfertas.selecionarDiasDaOferta(diasAleatorios);
        criacaoOfertas.selecionarHorarioInicial("11","35");
        criacaoOfertas.selecionarHorarioFinal("10", "45");
        criacaoOfertasValidation.validaSpamErroHorario(Bvruaajm_SpanHorarioConstante.SPAM);
    }
    
    @Test
    @Tag("BAG")
    @DisplayName("Teste para verificar se o botao horario final esta desabilitado")
    public void regrasOfertaQuandoBotaoHorarioFinal() {
        List<String> diasAleatorios = Arrays.asList(Bvruaajm_EnumDiasSemanaOfertas.diasDaSemanaAleatorios().toString());

        home.criarUmaOferta();
        criacaoOfertas.criarOfertaRegrasDaOferta("teste", "teste", "100", "099");
        criacaoOfertas.selecionarItensIncluso("Couvert" , "Sobremesa" , "Taxa" , "Bebidas");
        criacaoOfertas.selecionarDiasDaOferta(diasAleatorios);
        criacaoOfertasValidation.validaBotaoHorarioFinalDesabilitado();
    }
    
    
}
