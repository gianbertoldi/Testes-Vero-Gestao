package bergs.Bvr.Bvruaajm.test.tests.conexoes.ofertas;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.homeOfertas.Bvruaajm_HomeOfertasPage;
import bergs.Bvr.Bvruaajm.test.tasks.conexoes.ofertas.Bvruaajm_CriacaoOfertasTask;
import bergs.Bvr.Bvruaajm.test.tasks.conexoes.ofertas.Bvruaajm_HomeOfertasTask;
import bergs.Bvr.Bvruaajm.test.tasks.conexoes.ofertas.Bvruaajm_RevisaoOfertaTask;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskBag;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobileBag;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_FileOperations;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Formatador;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBag;
import bergs.Bvr.Bvruaajm.test.utils.constantes.ofertas.Bvruaajm_DetalhesOfertaRecusadaConstante;
import bergs.Bvr.Bvruaajm.test.utils.constantes.ofertas.Bvruaajm_HomeOfertaDesativada;
import bergs.Bvr.Bvruaajm.test.utils.constantes.ofertas.Bvruaajm_HomeOfertaExpiradaConstante;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumServidores;
import bergs.Bvr.Bvruaajm.test.utils.enums.conexao.oferta.Bvruaajm_EnumDiasSemanaOfertas;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;
import bergs.Bvr.Bvruaajm.test.validations.conexoes.ofertas.Bvruaajm_DetalhesDaOfertaValidation;
import bergs.Bvr.Bvruaajm.test.validations.conexoes.ofertas.Bvruaajm_HomeOfertasValidation;

public class Bvruaajm_DetalhesDaOfertaTeste extends Bvruaajm_TesteBaseMobileBag{
    
    private Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.Vinicius.obterCartaoAcesso();
    private Bvruaajm_Estabelecimento estabeleciomento = Bvruaajm_EnumEstabelecimentoConveniado.BetosLancheriaLtda.obterEstabelecimento();
    
    private Bvruaajm_HomeOfertasTask home;
    private Bvruaajm_CriacaoOfertasTask criacaoOfertas;
    private Bvruaajm_SqlBag sqlBag;
    private Bvruaajm_TaskBag taskBag;
    private Bvruaajm_DetalhesDaOfertaValidation detalhesOfertaValidation;
    private Bvruaajm_HomeOfertasValidation homeValidation;
    private Bvruaajm_RevisaoOfertaTask revisaoOferta;

    private Bvruaajm_HomeOfertasPage homeOfertas = new Bvruaajm_HomeOfertasPage(driver);
    
    @BeforeEach
    public void antesDeTodosTeste() {
        List<String> todosDias = Arrays.asList(Bvruaajm_EnumDiasSemanaOfertas.diasDaSemanaAleatorios().toString());
        sqlBag = new Bvruaajm_SqlBag();
        sqlBag.deletarOfertaEc(estabeleciomento.obterCnpjZerosAEsquerda());
        taskBag.verificaServidorUsuarioLogado(cartaoAcesso , estabeleciomento , Bvruaajm_EnumServidores.WW27.toString());
        home.criarUmaOferta();
        criacaoOfertas.criarOferta("Teste", "teste", "2000", "1000", todosDias , "Entrega", "null", "null", "null", "null", "null", "null", "null", "null");
        home.criarUmaNovaOferta();
        criacaoOfertas.criarOferta("Teste", "teste", "2000", "1000", todosDias , "Entrega", "null", "null", "null", "null", "null", "null", "null", "null");
    }

    @ParameterizedTest
    @Tag("BAG")
    @CsvFileSource(resources = "/csv/detalhesDaOferta.csv", delimiter = ';', numLinesToSkip = 2)
    @DisplayName("Teste para validar os detalhes com status da oferta ativa no listar")
    public void detalhesOfertaListar(String status, String nome, String descricaoOferta, String formaConsumo, String itensOferta, String mensagemOutros, String informativo, String expirou) {
        
        if(expirou.equals("S")){
            informativo = "Esta oferta foi desativada e expirou.\nConvidamos você a criar uma nova oferta.";
        }else if (status.equals("H")){
            informativo = "Essa oferta está ativa e sendo exibida no aplicativo do Banrisul.\nTenha sua equipe preparada para receber os clientes :)";
        }else if(status.equals("E")) {
            informativo = "Essa oferta ficou ativa por 30 dias e expirou.\nConvidamos você a criar uma nova oferta.";
        }
        
        Bvruaajm_FileOperations.definirPropriedade("regrasOfertas", "idCardOferta", Bvruaajm_Formatador.obterCaracteresNumericos(homeOfertas.obterCardListaOfertas("A").obterAtributo("id")));
       
        if(expirou.equals("S")) {
            sqlBag.atualizarStatusDaOferta("D", Bvruaajm_FileOperations.obterPropriedade("regrasOfertas").getProperty("idCardOferta"));
        }
        
        sqlBag.atualizarStatusDaOferta(status, Bvruaajm_FileOperations.obterPropriedade("regrasOfertas").getProperty("idCardOferta"));
      
        taskBag.fecharAbrirAplicativo();
        taskBag.verificaServidorUsuarioLogado(cartaoAcesso , estabeleciomento , Bvruaajm_EnumServidores.WW27.toString());    
        
        if(status.equals("D")) {
            home.avancarParaOfertasDesativadas();
        }else if(status.equals("E") || expirou.equals("S")) {
            home.avancarParaOfertasExpiradas();
        }
        
        home.cardDaOferta(Bvruaajm_FileOperations.obterPropriedade("regrasOfertas").getProperty("idCardOferta"));        
        detalhesOfertaValidation.validaRegrasDaOferta(nome, informativo, descricaoOferta, formaConsumo, itensOferta, "nao", mensagemOutros, status, Bvruaajm_Formatador.obterDataAtualFormatadaDiaMesAno(LocalDateTime.now()), Bvruaajm_Formatador.obterDataAtualFormatadaDiaMesAno(LocalDateTime.now().plusDays(30)), expirou);
    }
    
    @ParameterizedTest
    @Tag("BAG")
    @CsvFileSource(resources = "/csv/detalhesDaOferta.csv", delimiter = ';', numLinesToSkip = 2)
    @DisplayName("Teste para validar os detalhes com status da ultima oferta")
    public void detalhesOfertaUltimaOferta(String status, String nome, String descricaoOferta, String formaConsumo, String itensOferta, String mensagemOutros, String informativo, String expirou) {
        if (status.equals("H")){
            informativo = "Essa oferta está ativa e sendo exibida no aplicativo do Banrisul.\nTenha sua equipe preparada para receber os clientes :)";
        }
        
        Bvruaajm_FileOperations.definirPropriedade("regrasOfertas", "idCardOferta", Bvruaajm_Formatador.obterCaracteresNumericos(homeOfertas.obterDetalhesDaOferta().obterAtributo("href")));
        if(expirou.equals("S")) {
            sqlBag.atualizarStatusDaOferta("D", Bvruaajm_FileOperations.obterPropriedade("regrasOfertas").getProperty("idCardOferta"));
        }
        sqlBag.atualizarStatusDaOferta(status, Bvruaajm_FileOperations.obterPropriedade("regrasOfertas").getProperty("idCardOferta"));
        taskBag.fecharAbrirAplicativo();
        taskBag.verificaServidorUsuarioLogado(cartaoAcesso , estabeleciomento , Bvruaajm_EnumServidores.WW27.toString());       
        home.detalhesUltimaOferta();
        detalhesOfertaValidation.validaRegrasDaOferta(nome, informativo, descricaoOferta, formaConsumo, itensOferta, "nao", mensagemOutros, status, Bvruaajm_Formatador.obterDataAtualFormatadaDiaMesAno(LocalDateTime.now()), Bvruaajm_Formatador.obterDataAtualFormatadaDiaMesAno(LocalDateTime.now().plusDays(30)), expirou);
    } 
    

    @Test
    @Tag("BAG")
    @DisplayName("Teste para validar o listar vazio das ofertas Desativadas")
    public void ofertasDesativadasVazia() {
        home.avancarParaOfertasDesativadas();
        homeValidation.validaHomeOfertaDesativadaVazia(Bvruaajm_HomeOfertaDesativada.OFERTA_DESATIVADA_VAZIA, Bvruaajm_HomeOfertaDesativada.MENSAGEM_OFERTA_DESATIVADA_VAZIA);
    }
    
    @Test
    @Tag("BAG")
    @DisplayName("Teste para validar o listar vazio das ofertas Expiradas")
    public void ofertasExpiradasVazia() {
        home.avancarParaOfertasExpiradas();
        homeValidation.validaHomeOfertaExpiradaVazia(Bvruaajm_HomeOfertaExpiradaConstante.TITULO_EXPIRADAS_VAZIA, Bvruaajm_HomeOfertaExpiradaConstante.MENSAGEM_EXPIRADAS_VAZIA);
    }
    
    @Test
    @Tag("BAG")
    @DisplayName("Teste para desativar uma oferta Ativa")
    public void desativarOferta() {
        Bvruaajm_FileOperations.definirPropriedade("regrasOfertas", "idCardOferta", Bvruaajm_Formatador.obterCaracteresNumericos(homeOfertas.obterDetalhesDaOferta().obterAtributo("href")));
        sqlBag.atualizarStatusDaOferta("H", Bvruaajm_FileOperations.obterPropriedade("regrasOfertas").getProperty("idCardOferta"));
        taskBag.fecharAbrirAplicativo();
        
        taskBag.verificaServidorUsuarioLogado(cartaoAcesso , estabeleciomento , Bvruaajm_EnumServidores.WW27.toString()); 
        home.detalhesUltimaOferta();
        revisaoOferta.desativarOferta();
        detalhesOfertaValidation.validaOfertaDesativada(Bvruaajm_Formatador.obterDataAtualFormatadaDiaMesAno(LocalDateTime.now()));
    }
    
    @Test
    @Tag("BAG")
    @DisplayName("Teste para recusar uma oferta")
    public void ofertaRecusada() {
        
        Bvruaajm_FileOperations.definirPropriedade("regrasOfertas", "idCardOferta", Bvruaajm_Formatador.obterCaracteresNumericos(homeOfertas.obterDetalhesDaOferta().obterAtributo("href")));
        sqlBag.atualizarStatusDaOferta("R", Bvruaajm_FileOperations.obterPropriedade("regrasOfertas").getProperty("idCardOferta"));
        taskBag.fecharAbrirAplicativo();
        taskBag.verificaServidorUsuarioLogado(cartaoAcesso , estabeleciomento , Bvruaajm_EnumServidores.WW27.toString()); 
        home.detalhesUltimaOferta();
        detalhesOfertaValidation.validaOfertaRecusada(Bvruaajm_Formatador.obterDataAtualFormatadaDiaMesAno(LocalDateTime.now()) , "Teste", Bvruaajm_DetalhesOfertaRecusadaConstante.icone);
        
    }
    
}
