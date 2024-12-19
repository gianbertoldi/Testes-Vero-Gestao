package bergs.Bvr.Bvruaajm.test.tests.vender.linkPgto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_OnboardingTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_LinkPagamentoTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_VenderTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBvr;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;

public class Bvruaajm_ValidarTermoAdesaoLinkPgtoTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.AdesaoLink.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.CasaDoPintor7Teste.obterEstabelecimento();
    Bvruaajm_Estabelecimento estab2 = Bvruaajm_EnumEstabelecimentoConveniado.TesteGustavoImagens.obterEstabelecimento();
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_VenderTask venderTask;
    Bvruaajm_LinkPagamentoTask linkTask;
    Bvruaajm_OnboardingTask onboardingTask;
    Bvruaajm_SqlBvr sqlBvr;

    @BeforeEach
    public void iniciaTeste() {
        genericTask = new Bvruaajm_GenericTask(driver);
        linkTask = new Bvruaajm_LinkPagamentoTask(driver);
        venderTask = new Bvruaajm_VenderTask(driver);
        onboardingTask = new Bvruaajm_OnboardingTask(driver);
        genericTask.definirContextoWebview();
        genericTask.prepararTesteLogado(cartaoAcesso);
    }

    @Tag("LinkPgto")
    @Test
    @DisplayName("Efetua adesão ao link e cai na tela de aguardar 12h liberação")
    public void testeValidaAdesaoLinkSucessoAguardeAprovacao() {
        sqlBvr = new Bvruaajm_SqlBvr();
        sqlBvr.deletarLojistaTabelaEstabelecimento(String.valueOf(estab2.obterCpfCnpj()));
        genericTask.selecionaEstabelecimentoOuConveniado(estab2);
        genericTask.clicarBotaoVender();
        venderTask.clicarBotaoLinkPagamento();
        onboardingTask.verificaPularOnboardingGeneric();
        linkTask.validaTelaTermoAdesaoAderindoAoLinkPgtoTela12h();
        sqlBvr.deletarLojistaTabelaEstabelecimento(String.valueOf(estab2.obterCpfCnpj()));
    }

    @Tag("LinkPgto")
    @Test
    @DisplayName("Valida a não adesão ao link clicando em não quero aderir")
    public void testeValidaNaoQueroAderirAoLinkPgto() {
        sqlBvr = new Bvruaajm_SqlBvr();
        sqlBvr.deletarTransacaoLojistaCpfCnpj(String.valueOf(estab.obterCpfCnpj()));
        sqlBvr.deletarLojistaTabelaEstabelecimento(String.valueOf(estab.obterCpfCnpj()));
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        genericTask.clicarBotaoVender();
        venderTask.clicarBotaoLinkPagamento();
        onboardingTask.verificaPularOnboardingGeneric();
        linkTask.validaTelaTermoAdesaoNaoQueroAderirLinkPgto();
    }

    @Tag("SmokeTest")
    @Tag("LinkPgto")
    @Test
    @DisplayName("Valida adesão ao link indo para tela o que deseja fazer")
    public void testeValidaAdesaoLink() {
        sqlBvr = new Bvruaajm_SqlBvr();
        sqlBvr.deletarTransacaoLojistaCpfCnpj(String.valueOf(estab.obterCpfCnpj()));
        sqlBvr.deletarLojistaTabelaEstabelecimento(String.valueOf(estab.obterCpfCnpj()));
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        genericTask.clicarBotaoVender();
        venderTask.clicarBotaoLinkPagamento();
        onboardingTask.verificaPularOnboardingGeneric();
        linkTask.validaTelaTermoAdesaoQueroAderirLinkPgto();
        sqlBvr.deletarTransacaoLojistaCpfCnpj(String.valueOf(estab.obterCpfCnpj()));
        sqlBvr.deletarLojistaTabelaEstabelecimento(String.valueOf(estab.obterCpfCnpj()));
    }
}
