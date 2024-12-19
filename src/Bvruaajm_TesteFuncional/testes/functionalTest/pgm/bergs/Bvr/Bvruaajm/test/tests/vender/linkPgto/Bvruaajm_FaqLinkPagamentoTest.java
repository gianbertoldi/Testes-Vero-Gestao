package bergs.Bvr.Bvruaajm.test.tests.vender.linkPgto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_OnboardingTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_LinkPagamentoTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_VenderTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;

public class Bvruaajm_FaqLinkPagamentoTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.ConsultoriaInfoteca.obterEstabelecimento();
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_VenderTask venderTask;
    Bvruaajm_OnboardingTask onboardingTask;
    Bvruaajm_LinkPagamentoTask linkTask;
    String textoPesquisa = "Mastercard";
    String textoCancelaLink = "Para cancelamento no mesmo dia da venda, entrar no menu";
    String textoFuncionario = "Você pode cadastrar funcionários no app Vero Gestão acessando";
    String textoPesquisaSemResultado = "Não existem resultados para esta pesquisa.";
    String pergunta = "Posso cadastrar funcionários para vender via link?";
    String pergunta2 = "Como cancelar uma venda realizada via link?";

    
    @BeforeEach
    public void preparaTest() {
        genericTask = new Bvruaajm_GenericTask(driver);
        linkTask = new Bvruaajm_LinkPagamentoTask(driver);
        venderTask = new Bvruaajm_VenderTask(driver);
        onboardingTask = new Bvruaajm_OnboardingTask(driver);
        taskMobile.definirContextoWebview();
        genericTask.prepararTesteLogado(cartaoAcesso);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        genericTask.clicarBotaoVender();
        venderTask.clicarBotaoLinkPagamento();
        onboardingTask.verificaPularOnboardingGeneric();
    }

    @Tag("SmokeTest")
    @Tag("LinkPgto")
    @Test
    @DisplayName("Valida Quantidade de Perguntas Faq Link")
    public void testVerificaQuantidadePerguntasFaqLink() {
        linkTask.validarQuantidadePerguntasFaqLinkPagamento(14);
    }

    @Tag("LinkPgto")
    @Test
    @DisplayName("Valida Existencia Pergunta Faq Link")
    public void testVerificaSeExistePerguntaFaqLink() {
        String pergunta = "Quais sao as taxas para vender por link?";
        linkTask.validarPerguntasFaqLinkPagamentoExistente(pergunta);
    }

    @Tag("LinkPgto")
    @Test
    @DisplayName("Valida Tela inicial pesquisa pergunta FAQ Link Pgto")
    public void testVerificaTelaInicialPesquisaFaqLinkPgto() {
        linkTask.validarTelaInicialPesquisaPerguntasFaqLinkPagamento();
    }

    @Tag("LinkPgto")
    @Test
    @DisplayName("Valida Tela sem resultado na pesquisa do FAQ link Pagamento")
    public void testVerificaTelaSemResultadoPesquisaFaqLinkPgto() {
        linkTask.validarTelaSemResultadoPesquisaPerguntasFaqLinkPagamento(textoPesquisaSemResultado);
    }

    @Tag("LinkPgto")
    @Test
    @DisplayName("Valida tela resultado da pesquisa do FAQ link Pagamento")
    public void testVerificaTelaResultadoPesquisaFaqLinkPgto() {
        linkTask.validarTelaComResultadoPesquisaFaqLinkPgto(textoPesquisa);
    }

    @Tag("LinkPgto")
    @Test
    @DisplayName("Valida Existencia das novas Pergunta Faq Link Cadastrar funcionario")
    public void testVerificaSeExistePerguntaFaqLinkPgtoNaoAprovado() {
        linkTask.validarPerguntasFaqLinkPagamentoExistente(pergunta);
    }

    @Tag("LinkPgto")
    @Test
    @DisplayName("Valida Existencia das novas Pergunta Faq Link Cancelar uma venda")
    public void testVerificaSeExistePerguntaFaqLinkEntregaMercadoria() {
        linkTask.validarPerguntasFaqLinkPagamentoExistente(pergunta2);
    }
    
    @Tag("LinkPgto")
    @Test
    @DisplayName("Valida tela resultado da pesquisa do FAQ link Cancelamento Link Pago")
    public void testVerificaTelaResultadoPesquisaFaqCancelamentoLinkPago() {
        linkTask.validarTelaComResultadoPesquisaFaqLinkPgto(textoCancelaLink);
    }
    
    @Tag("LinkPgto")
    @Test
    @DisplayName("Valida tela resultado da pesquisa do FAQ link Cadastro funcionario")
    public void testVerificaTelaResultadoPesquisaFaqCadastroFuncionario() {
        linkTask.validarTelaComResultadoPesquisaFaqLinkPgto(textoFuncionario);
    }
}
