package bergs.Bvr.Bvruaajm.test.tests.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.login.Bvruaajm_CriarCartaoVirtualTask;
import bergs.Bvr.Bvruaajm.test.tasks.login.Bvruaajm_ListaCartoesTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;

public class Bvruaajm_ValidarSenhaCartaoTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_CartaoAcesso cartaoAcessoSenhaInvalida = new Bvruaajm_CartaoAcesso(Long.parseLong("00000000191"), "Gera Qr Code", "pf@teste.com",
            "51999999999", "111111", "12345678");
    Bvruaajm_ListaCartoesTask listaCartoesTask;
    Bvruaajm_CriarCartaoVirtualTask criarCartao;
    String senhaCorreta = "teste0102";
    String senhaIncorreta = "teste0101";
    String codigoIncorreto = "123456";
    String senhaPequena = "teste";
    String senhaSequencia = "1234teste";
    String senhaDigitosIguais = "1111teste";
    String erroSenhaMinimoCaractere = "A senha deve conter no m�nimo 8 caracteres";
    String erroSenhaNaoConsidem = "As senhas n�o coincidem";
    String erroSenhaSequencia = "A senha n�o deve conter 4 caracteres sequenciais";
    String erroSenhaIgual = "A senha n�o deve conter 4 caracteres repetidos";

    @BeforeEach
    public void prepara() {
        taskMobile.definirContextoWebview();
        this.getDriver().resetApp();
        listaCartoesTask = new Bvruaajm_ListaCartoesTask(driver);
        criarCartao = new Bvruaajm_CriarCartaoVirtualTask(driver);
    }

    @DisplayName("Valida cria��o cart�o com c�digo ativa��o incorreto")
    @Test
    @Tag("Login")
    public void testCriarCartaoCodigoAtivacaoIncorreto() {
        criarCartao.efetuarCadastraAteInserirCodAtivacao(cartaoAcesso, codigoIncorreto, senhaCorreta, senhaCorreta);
    }

    @DisplayName("Valida cria��o cart�o reenviar c�digo ativa��o")
    @Tag("Login")
    @Test
    public void testCriarCartaoReenviarCodigoAtivacao() {
        criarCartao.validarReenviarCodigoDeAtivacao(cartaoAcesso.obterCpfFormatado(), cartaoAcesso.obterApelido());
    }

    @DisplayName("Valida cria��o cart�o com senha menor que oito digitos")
    @Tag("Login")
    @Test
    public void testCriarCartaoSenhaMenorOitoDigitos() {
        criarCartao.efetuarCadastraAteInserirSenha(cartaoAcesso, cartaoAcesso.obterCodigoAtivacao(), senhaPequena, senhaPequena,
                erroSenhaMinimoCaractere);
    }

    @DisplayName("Valida cria��o cart�o com senhas diferentes")
    @Tag("Login")
    @Test
    public void testCriarCartaoSenhaDiferentes() {
        criarCartao.efetuarCadastraAteInserirSenha(cartaoAcesso, cartaoAcesso.obterCodigoAtivacao(), senhaCorreta, senhaIncorreta,
                erroSenhaNaoConsidem);
    }

    @DisplayName("Valida cria��o cart�o com senha com quatro n�meros sequenciais")
    @Tag("Login")
    @Test
    public void testCriarCartaoSenhaQuatroNumerosSequenciais() {
        criarCartao.efetuarCadastraAteInserirSenha(cartaoAcesso, cartaoAcesso.obterCodigoAtivacao(), senhaSequencia, senhaSequencia,
                erroSenhaSequencia);
    }

    @DisplayName("Valida cria��o cart�o com senha com quatro caracteres iguais")
    @Tag("Login")
    @Test
    public void testCriarCartaoSenhaQuatroCaracteresIguais() {
        criarCartao.efetuarCadastraAteInserirSenha(cartaoAcesso, cartaoAcesso.obterCodigoAtivacao(), senhaDigitosIguais, senhaDigitosIguais,
                erroSenhaIgual);
    }

    @DisplayName("Valida acessar cart�o com senha inv�lida")
    @Tag("SmokeTest")
    @Tag("Login")
    @Test
    public void validaAcessoCartaoComSenhaInvalida() {
        listaCartoesTask.iniciaCadastroCartaoExistenteNaLista(cartaoAcesso);
        listaCartoesTask.inserirSenhaInvalida(cartaoAcessoSenhaInvalida);
    }

    @DisplayName("Valida troca de senha do cart�o cadastrado")
    @Tag("Login")
    @Test
    public void validaTrocarSenhaDoCartao() {
        listaCartoesTask.iniciaCadastroCartaoExistenteNaLista(cartaoAcesso);
        this.driver.closeApp();
        this.driver.launchApp();
        listaCartoesTask.validarTrocarSenhaDoCartao(cartaoAcesso);
    }

    @DisplayName("Valida adicionar cart�o sem finalizar fluxo de cadastro")
    @Tag("Login")
    @Test
    public void validaAddCartaoSemTerminarFluxoCadastro() {
        criarCartao.efetuarCadastraAteInserirCodAtivacao(cartaoAcesso, codigoIncorreto, senhaCorreta, senhaCorreta);
        this.driver.closeApp();
        this.driver.launchApp();
        criarCartao.validaSeOCartaoExiste();
    }
}
