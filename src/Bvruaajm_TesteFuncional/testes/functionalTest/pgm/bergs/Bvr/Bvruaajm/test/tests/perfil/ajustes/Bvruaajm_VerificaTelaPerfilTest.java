package bergs.Bvr.Bvruaajm.test.tests.perfil.ajustes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.perfil.Bvruaajm_PerfilTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBvr;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;

public class Bvruaajm_VerificaTelaPerfilTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_GenericTask genericTask;
    Bvruaajm_PerfilTask perfilTask;
    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.Pannuvia.obterCartaoAcesso();
    Bvruaajm_SqlBvr sql;
    String dddInvalido = "00999999999";
    String numeroInvalido = "51000000000";
    String erroDddIvalido = "DDD inválido";
    String erroNumeroIvalido = "Celular deve começar por 9";

    @BeforeEach
    public void iniciaTest() {
        genericTask = new Bvruaajm_GenericTask(driver);
        perfilTask = new Bvruaajm_PerfilTask(driver);
        sql = new Bvruaajm_SqlBvr();
        sql.atualizarEmailUsuarioParaCorrespondente(cartaoAcesso);
        genericTask.prepararTesteLogado(cartaoAcesso);
    }

    @DisplayName("Validar dados na tela perfil")
    @Tag("SmokeTest")
    @Tag("Perfil")
    @Test
    public void verificaDadosNaPaginaPerfil() {
        perfilTask.validaTelaPerfil();
    }

    @DisplayName("Valida o acesso a janela fale conosco")
    @Tag("Perfil")
    @Test
    public void verificaFluxoFaleConosco() {
        perfilTask.validarFaleConoscoCredeciadoVero();
    }

    @DisplayName("Valida as mensagens de erro nos meus dados")
    @Tag("Perfil")
    @Test
    public void verificaMsgErrosMeusDadosPerfil() {
        perfilTask.validaMesagemErroNosCamposMeuPerfil();
    }

    @DisplayName("Valida as mensagens de erro onde o DDD é invalido")
    @Tag("Perfil")
    @Test
    public void verificaErrosCelularDddInvalido() {
        perfilTask.validaMsgErroMeusDadosCelular(dddInvalido, erroDddIvalido);
    }

    @DisplayName("Valida as mensagens de erro primeiro numero não é 9")
    @Tag("Perfil")
    @Test
    public void verificaErrosCelularPrimeiroNumeroInvalido() {
        perfilTask.validaMsgErroMeusDadosCelular(numeroInvalido, erroNumeroIvalido);
    }

    @DisplayName("Valida se os texto de ocoes de notificacao esta corretor")
    @Tag("Perfil")
    @Test
    public void verificaSeOpcoesDeNotificacaoEstaoPresentes() {
        perfilTask.validaTextosDeOpcoesDeNotificacao();
    }

}