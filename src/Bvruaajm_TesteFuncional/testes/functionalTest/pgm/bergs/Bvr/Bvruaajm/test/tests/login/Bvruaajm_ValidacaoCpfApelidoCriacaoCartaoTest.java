package bergs.Bvr.Bvruaajm.test.tests.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.login.Bvruaajm_ListaCartoesTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;

public class Bvruaajm_ValidacaoCpfApelidoCriacaoCartaoTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_ListaCartoesTask listaCartaoTask;
    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_CartaoAcesso cartaoAcesso2 = new Bvruaajm_CartaoAcesso(Long.parseLong("13073574077"), "Nao cadastrado", "", "", "", "");
    String cpfInvalido = "12345678901";
    String erroCpfInvalido = "CPF inv�lido";
    String cpfIncompleto = "12345678";
    String erroCpfIncompleto = "CPF incompleto";
    String erroMinimoCaractere = "M�nimo dois caracteres";
    String minimoCaractere = "v";
    String entradaComCaractereEspecial = "V&R� G�%t@0";
    String formatacaoAutomatica = "VRo Get0";

    @BeforeEach
    public void preparaTest() {
        listaCartaoTask = new Bvruaajm_ListaCartoesTask(driver);
        taskMobile.definirContextoWebview();
    }

    @DisplayName("Valida cria��o cart�o com CPF inv�lido")
    @Tag("Login") 
    @Test
    public void testCriarCartaoComCpfInvalido() {
        listaCartaoTask.iniciaCadastroInserindoCpfEApelido(cpfInvalido, cartaoAcesso.obterApelido(), erroCpfInvalido);
    }

    @DisplayName("Valida cria��o cart�o com CPF incompleto")
    @Tag("Login")
    @Test
    public void testCriarCartaoComCpfIncompleto() {
        listaCartaoTask.iniciaCadastroInserindoCpfEApelido(cpfIncompleto, cartaoAcesso.obterApelido(), erroCpfIncompleto);
    }

    @DisplayName("Valida cria��o cart�o j� adicionado")
    @Tag("Login")
    @Test
    public void testCriarCartaoJaExistente() {
        listaCartaoTask.iniciaCadastroCartaoExistenteNaLista(cartaoAcesso);
        listaCartaoTask.preencherDadosCartaoExistente(cartaoAcesso);
    }

    @DisplayName("Valida cria��o cart�o com apelido com um caracter")
    @Tag("Login")
    @Test
    public void testCriarCartaoComApelidoComUmCaracter() {
        listaCartaoTask.iniciaCadastroInserindoCpfEApelido(cartaoAcesso.obterCpfFormatado(),
                minimoCaractere, erroMinimoCaractere);
    }

    @DisplayName("Valida cria��o cart�o inserindo caracter especial no apelido")
    @Tag("Login")
    @Test
    public void testCriarCartaoComApelidoComCaracterEspecial() {
        listaCartaoTask.iniciaCadastroEValidaCampoApelidoComCaracterEspecial(cartaoAcesso.obterCpfFormatado(),
                entradaComCaractereEspecial, formatacaoAutomatica);
    }

    @DisplayName("Valida cria��o cart�o com CPF n�o cadastrado em nenhum EC")
    @Tag("SmokeTest")
    @Tag("Login")
    @Test
    public void testAcessarComCpfNaoCadastrado() {
        listaCartaoTask.validaAcessoCpfNaoCadastrado(cartaoAcesso2);
    }

    @DisplayName("Valida op��o conte a vero na lista de cart�es")
    @Tag("Login")
    @Test
    public void testOpcaoAjudaTelaCartoes() {
        listaCartaoTask.validarTelaContatoComVeroAcesso();
    }

}
