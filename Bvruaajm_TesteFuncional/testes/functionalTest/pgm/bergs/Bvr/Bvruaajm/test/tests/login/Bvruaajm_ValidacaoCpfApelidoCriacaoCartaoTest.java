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
    String erroCpfInvalido = "CPF inválido";
    String cpfIncompleto = "12345678";
    String erroCpfIncompleto = "CPF incompleto";
    String erroMinimoCaractere = "Mínimo dois caracteres";
    String minimoCaractere = "v";
    String entradaComCaractereEspecial = "V&Rö Gê%t@0";
    String formatacaoAutomatica = "VRo Get0";

    @BeforeEach
    public void preparaTest() {
        listaCartaoTask = new Bvruaajm_ListaCartoesTask(driver);
        taskMobile.definirContextoWebview();
    }

    @DisplayName("Valida criação cartão com CPF inválido")
    @Tag("Login") 
    @Test
    public void testCriarCartaoComCpfInvalido() {
        listaCartaoTask.iniciaCadastroInserindoCpfEApelido(cpfInvalido, cartaoAcesso.obterApelido(), erroCpfInvalido);
    }

    @DisplayName("Valida criação cartão com CPF incompleto")
    @Tag("Login")
    @Test
    public void testCriarCartaoComCpfIncompleto() {
        listaCartaoTask.iniciaCadastroInserindoCpfEApelido(cpfIncompleto, cartaoAcesso.obterApelido(), erroCpfIncompleto);
    }

    @DisplayName("Valida criação cartão já adicionado")
    @Tag("Login")
    @Test
    public void testCriarCartaoJaExistente() {
        listaCartaoTask.iniciaCadastroCartaoExistenteNaLista(cartaoAcesso);
        listaCartaoTask.preencherDadosCartaoExistente(cartaoAcesso);
    }

    @DisplayName("Valida criação cartão com apelido com um caracter")
    @Tag("Login")
    @Test
    public void testCriarCartaoComApelidoComUmCaracter() {
        listaCartaoTask.iniciaCadastroInserindoCpfEApelido(cartaoAcesso.obterCpfFormatado(),
                minimoCaractere, erroMinimoCaractere);
    }

    @DisplayName("Valida criação cartão inserindo caracter especial no apelido")
    @Tag("Login")
    @Test
    public void testCriarCartaoComApelidoComCaracterEspecial() {
        listaCartaoTask.iniciaCadastroEValidaCampoApelidoComCaracterEspecial(cartaoAcesso.obterCpfFormatado(),
                entradaComCaractereEspecial, formatacaoAutomatica);
    }

    @DisplayName("Valida criação cartão com CPF não cadastrado em nenhum EC")
    @Tag("SmokeTest")
    @Tag("Login")
    @Test
    public void testAcessarComCpfNaoCadastrado() {
        listaCartaoTask.validaAcessoCpfNaoCadastrado(cartaoAcesso2);
    }

    @DisplayName("Valida opção conte a vero na lista de cartões")
    @Tag("Login")
    @Test
    public void testOpcaoAjudaTelaCartoes() {
        listaCartaoTask.validarTelaContatoComVeroAcesso();
    }

}
