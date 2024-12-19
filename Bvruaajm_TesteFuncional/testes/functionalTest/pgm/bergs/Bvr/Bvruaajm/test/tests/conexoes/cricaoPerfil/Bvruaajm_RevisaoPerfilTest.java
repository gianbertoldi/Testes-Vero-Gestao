package bergs.Bvr.Bvruaajm.test.tests.conexoes.cricaoPerfil;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.conexoes.criacaoPerfil.Bvruaajm_CadastroPerfilEcTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_OnboardingTask;
import bergs.Bvr.Bvruaajm.test.tasks.home.Bvruaajm_HomeTask;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskBag;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobileBag;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_FakeGenerator;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBag;
import bergs.Bvr.Bvruaajm.test.utils.constantes.criacaoPerfil.Bvruaajm_AnalisePerfilConstante;
import bergs.Bvr.Bvruaajm.test.utils.constantes.criacaoPerfil.Bvruaajm_RecusarPerfilConstante;
import bergs.Bvr.Bvruaajm.test.utils.constantes.ofertas.Bvruaajm_HomeOfertasVaziaConstante;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumServidores;
import bergs.Bvr.Bvruaajm.test.utils.enums.conexao.Bvruaajm_EnumCategoriaNegocio;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;
import bergs.Bvr.Bvruaajm.test.validations.conexoes.criacaoPerfil.Bvruaajm_PrimeiroAcessoValidation;
import bergs.Bvr.Bvruaajm.test.validations.conexoes.ofertas.Bvruaajm_HomeOfertasValidation;

public class Bvruaajm_RevisaoPerfilTest extends Bvruaajm_TesteBaseMobileBag{

    private Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.Vinicius.obterCartaoAcesso();
    private Bvruaajm_Estabelecimento estabeleciomento = Bvruaajm_EnumEstabelecimentoConveniado.BetosLancheriaLtda.obterEstabelecimento();
    
    private Bvruaajm_GenericTask genericTask;
    private Bvruaajm_TaskMobile taskMobile;
    private Bvruaajm_HomeTask homeTask;
    private Bvruaajm_OnboardingTask onboardingTask;
    private Bvruaajm_CadastroPerfilEcTask cadastroPerfilEc;
    private Bvruaajm_SqlBag sqlBag;
    private Bvruaajm_HomeOfertasValidation homeValidation;
    private Bvruaajm_TaskBag taskBag;
    private Bvruaajm_PrimeiroAcessoValidation primeiroAcessoValidation;

    
    @BeforeEach
    public void antesDoTeste() {
        sqlBag = new Bvruaajm_SqlBag();
        sqlBag.deletarOfertaEc(estabeleciomento.obterCnpjZerosAEsquerda());
        sqlBag.deletarEc(estabeleciomento.obterCnpjZerosAEsquerda());
        genericTask.prepararTesteLogado(cartaoAcesso);
        taskMobile.definirContextoWebview();
        genericTask.selecionaEstabelecimentoOuConveniado(Bvruaajm_EnumEstabelecimentoConveniado.CasaDoPintor7Teste.obterEstabelecimento());
        genericTask.selecionaEstabelecimentoOuConveniado(estabeleciomento);
        homeTask.clicarCardConexoes();
        onboardingTask.verificaPularOnboardingGeneric();
        cadastroPerfilEc.criarPerfilEcCompleto(Bvruaajm_EnumCategoriaNegocio.CAFETERIA.toString(), Bvruaajm_FakeGenerator.obterDescricaoLorem(), "", "", "", "");
       
        sqlBag.atualizarStatusEcPerfil("R", estabeleciomento.obterCnpjZerosAEsquerda());
        taskBag.fecharAbrirAplicativo();
        taskBag.verificaServidorUsuarioLogado(cartaoAcesso , estabeleciomento , Bvruaajm_EnumServidores.WW27.toString());
    }
   
    @Test
    @Tag("BAG")
    @Tag("regressaoObrigatoriaBag")
    @Tag("RevisaoPerfil")
    @DisplayName("Teste para mudar o status do EC para recusado")
    public void recusarPerfil() {  
        primeiroAcessoValidation.validaPerfilRecusado(Bvruaajm_RecusarPerfilConstante.PERFIL_RECUSADO_TITULO , Bvruaajm_RecusarPerfilConstante.PERFIL_RECUSADO_TEXTO_INFORMATIVO);
        cadastroPerfilEc.avancarRevisarOferta();
        cadastroPerfilEc.finalizarCriacaoPerfil();
        primeiroAcessoValidation.validaPerfilEmAnalise(Bvruaajm_AnalisePerfilConstante.PERFIL_ANALISE_TITULO , Bvruaajm_AnalisePerfilConstante.PERFIL_ANALISE_MENSAGEM_RETORNO , Bvruaajm_AnalisePerfilConstante.PERFIL_ANALISE_TEXTO_BOTAO_HOME);
        cadastroPerfilEc.irParaHome();
        homeValidation.validaHomeVazia(Bvruaajm_HomeOfertasVaziaConstante.TITULO, Bvruaajm_HomeOfertasVaziaConstante.SUBTITULO, Bvruaajm_HomeOfertasVaziaConstante.BOTAO);
    }
    
    @AfterEach
    public void depoisDoTeste() {
        sqlBag.atualizarStatusEcPerfil("A", estabeleciomento.obterCnpjZerosAEsquerda());
    }
}
