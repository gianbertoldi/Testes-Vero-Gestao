package bergs.Bvr.Bvruaajm.test.tests.servicos.simulador;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.servicos.Bvruaajm_ServicosTask;
import bergs.Bvr.Bvruaajm.test.tasks.servicos.simulador.Bvruaajm_SimuladorTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;

public class Bvruaajm_ValidaSimuladorBanricardTests extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.SweetFlavors.obterEstabelecimento();
    Bvruaajm_ServicosTask servicoTask;
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_SimuladorTask simuladorTask;
    int tipoCartao = 2;
    int tipoModalidade, parcela;
    double valor, valorCalculado, mdr, antecipacao;

    @BeforeEach
    public void iniciaTeste() {
        servicoTask = new Bvruaajm_ServicosTask(driver);
        genericTask = new Bvruaajm_GenericTask(driver);
        simuladorTask = new Bvruaajm_SimuladorTask(driver);
        taskMobile.definirContextoWebview();
        genericTask.prepararTesteLogado(cartaoAcesso);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        genericTask.clicarBotaoServicos();
        servicoTask.acessarPaginaSimulador();
    }

    @Tag("Simulador")
    @Test
    @Disabled("testes do simulador esta com varicao no calculos(backend)")
    @DisplayName("Teste Valida a simulação de venda no Banricard alimentaçao")
    public void validaBanricardAlimentacao() {
        tipoModalidade = 1;
        valor = 50;
        valorCalculado = 46.04;
        mdr = 4.90;
        antecipacao = 3;
        simuladorTask.validacaoSimulacaoSemValorIntegral(valor, tipoCartao, tipoModalidade, mdr, antecipacao);
    }

    @Tag("Simulador")
    @Test
    @Disabled("testes do simulador esta com varicao no calculos(backend)")
    @DisplayName("Teste Valida a simulação de venda no Banricard alimentaçao recebendo valor integral")
    public void validaBanricardAlimentacaoReceberValorIntegral() {
        tipoModalidade = 1;
        valor = 50;
        valorCalculado = 54.14;
        mdr = 4.90;
        antecipacao = 3;
        simuladorTask.validacaoSimulacaoValorIntegral(valor, tipoCartao, tipoModalidade, mdr, antecipacao);
    }

    @Tag("Simulador")
    @Test
    @Disabled("testes do simulador esta com varicao no calculos(backend)")
    @DisplayName("Teste Valida a simulação de venda no Banricard refeição")
    public void validaBanricardRefeicao() {
        tipoModalidade = 2;
        valor = 100.00;
        valorCalculado = 93.09;
        mdr = 4.90;
        antecipacao = 3;
        simuladorTask.validacaoSimulacaoSemValorIntegral(valor, tipoCartao, tipoModalidade, mdr, antecipacao);
    }

    @Tag("Simulador")
    @Test
    @Disabled("testes do simulador esta com varicao no calculos(backend)")
    @DisplayName("Teste Valida a simulação de venda no Banricard refeiçãoo recebendo valor integral")
    public void validaBanricardRefeicaoReceberValorIntegrar() {
        tipoModalidade = 2;
        valor = 100.00;
        valorCalculado = 107.28;
        mdr = 4.90;
        antecipacao = 3;
        simuladorTask.validacaoSimulacaoValorIntegral(valor, tipoCartao, tipoModalidade, mdr, antecipacao);
    }

}
