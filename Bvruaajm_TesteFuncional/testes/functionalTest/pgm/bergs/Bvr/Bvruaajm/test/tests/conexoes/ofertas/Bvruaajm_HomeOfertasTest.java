package bergs.Bvr.Bvruaajm.test.tests.conexoes.ofertas;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.homeOfertas.Bvruaajm_HomeOfertasPage;
import bergs.Bvr.Bvruaajm.test.tasks.conexoes.ofertas.Bvruaajm_CriacaoOfertasTask;
import bergs.Bvr.Bvruaajm.test.tasks.conexoes.ofertas.Bvruaajm_HomeOfertasTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.home.Bvruaajm_HomeTask;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskBag;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobileBag;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_FileOperations;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Formatador;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBag;
import bergs.Bvr.Bvruaajm.test.utils.constantes.ofertas.Bvruaajm_UltimaOfertaCriadaConstante;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumServidores;
import bergs.Bvr.Bvruaajm.test.utils.enums.conexao.oferta.Bvruaajm_EnumDiasSemanaOfertas;
import bergs.Bvr.Bvruaajm.test.utils.enums.conexao.oferta.Bvruaajm_EnumStatusDaOferta;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;
import bergs.Bvr.Bvruaajm.test.validations.conexoes.ofertas.Bvruaajm_HomeOfertasValidation;

public class Bvruaajm_HomeOfertasTest extends Bvruaajm_TesteBaseMobileBag{
    
    private Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.Matheus.obterCartaoAcesso();
    private Bvruaajm_Estabelecimento estabeleciomento = Bvruaajm_EnumEstabelecimentoConveniado.CasaDoPintor7Teste.obterEstabelecimento();
    private Bvruaajm_TaskMobile taskMobile;
    private Bvruaajm_HomeOfertasTask home;
    private Bvruaajm_GenericTask genericTask;
    private Bvruaajm_CriacaoOfertasTask criacaoOfertas;
    private Bvruaajm_HomeOfertasValidation homeValidation;
    private Bvruaajm_TaskBag taskBag;
    private Bvruaajm_SqlBag sqlBag;
    private Bvruaajm_HomeTask homeTask;
    private Bvruaajm_HomeOfertasPage homeOfertas = new Bvruaajm_HomeOfertasPage(driver);

    @BeforeEach
    public void antesDoTeste(){
        sqlBag = new Bvruaajm_SqlBag();
        sqlBag.deletarOfertaEc(estabeleciomento.obterCnpjZerosAEsquerda());
        //taskBag.verificaServidorUsuarioLogado(cartaoAcesso , estabeleciomento , Bvruaajm_EnumServidores.WW27.toString());    
        
        taskBag.trocaServiador(Bvruaajm_EnumServidores.WW27.toString());
        
        genericTask.prepararTesteLogado(cartaoAcesso);
        taskMobile.definirContextoWebview();
        genericTask.selecionaEstabelecimentoOuConveniado(estabeleciomento);
        homeTask.clicarCardConexoes();
                   
        if(taskBag.telasInformativa() || taskBag.telasOboarding()) {
            sqlBag.incluirEc(estabeleciomento.obterCnpjZerosAEsquerda()  ,"J" , 1, "S" , "A");
            sqlBag.criarNovaOferta(estabeleciomento.obterCnpjZerosAEsquerda(), "J", "D", "TESTE", "TESTE TESTE", "A", "S", "S", "S", "S", "S", "S" , "S");
            sqlBag.criarNovaOferta(estabeleciomento.obterCnpjZerosAEsquerda(), "J", "D", "TESTE2", "TESTE TESTE2", "A", "S", "S", "S", "S", "S", "S" , "S");      
            taskMobile.fecharAbrirAplicativo();           
            genericTask.prepararTesteLogado(cartaoAcesso);
            taskMobile.definirContextoWebview();
            genericTask.selecionaEstabelecimentoOuConveniado(estabeleciomento);
            homeTask.clicarCardConexoes();
        } else {
            sqlBag.criarNovaOferta(estabeleciomento.obterCnpjZerosAEsquerda(), "J", "D", "TESTE", "TESTE TESTE", "A", "S", "S", "S", "S", "S", "S" , "S");
            sqlBag.criarNovaOferta(estabeleciomento.obterCnpjZerosAEsquerda(), "J", "D", "TESTE2", "TESTE TESTE2", "A", "S", "S", "S", "S", "S", "S" , "S");   
            taskMobile.fecharAbrirAplicativo();           
            genericTask.prepararTesteLogado(cartaoAcesso);
            taskMobile.definirContextoWebview();
            genericTask.selecionaEstabelecimentoOuConveniado(estabeleciomento);
            homeTask.clicarCardConexoes();
        }
        

    }

    @Test
    @Tag("BAG")
    @DisplayName("Teste para criar Nova Oferta")
    public void criarNovaOferta() {
        List<String> todosDias = Arrays.asList(Bvruaajm_EnumDiasSemanaOfertas.diasDaSemanaAleatorios().toString());
        home.criarUmaNovaOferta();
        criacaoOfertas.criarOferta("Teste", "teste", "2000", "1000", todosDias , "Entrega", "null", "null", "null", "null", "null", "null", "null", "null");
        homeValidation.validaUltimaOfertaCriada("Teste", "2000", "1000",Bvruaajm_EnumStatusDaOferta.ANALISE.toString(), Bvruaajm_UltimaOfertaCriadaConstante.DETALHES_OFERTA, Bvruaajm_UltimaOfertaCriadaConstante.ULTIMA_OFERTA_CRIADA);
    }
    
    @ParameterizedTest
    @Tag("BAG")
    @DisplayName("Valida listar das ofertas para uma oferta de cada status")
    @CsvSource({"A , Em análise","H , Ativas","R , Recusadas","E, Expiradas"})
    public void validaListarParaUmaOfertaPorStatus(String status , String textoStatus) {
        Bvruaajm_FileOperations.definirPropriedade("regrasOfertas", "idCardOferta", Bvruaajm_Formatador.obterCaracteresNumericos(homeOfertas.obterCardListaOfertas("A").obterAtributo("id")));
        
        sqlBag.atualizarStatusDaOferta(status, Bvruaajm_FileOperations.obterPropriedade("regrasOfertas").getProperty("idCardOferta"));
        taskBag.fecharAbrirAplicativo();
        genericTask.prepararTesteLogado(cartaoAcesso);
        homeTask.clicarCardConexoes();
        
        if(status.equals("E")) {
            home.avancarParaOfertasExpiradas();
        } 
        homeValidation.validaListarCardEmAnalise(Bvruaajm_FileOperations.obterPropriedade("regrasOfertas").getProperty("idCardOferta"), textoStatus, "TESTE", "De R$ 99,99 por R$ 98,00");
    }

 
}
