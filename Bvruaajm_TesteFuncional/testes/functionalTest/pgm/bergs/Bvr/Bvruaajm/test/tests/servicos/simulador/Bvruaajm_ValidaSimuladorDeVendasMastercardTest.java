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

public class Bvruaajm_ValidaSimuladorDeVendasMastercardTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.SweetFlavors.obterEstabelecimento();
    Bvruaajm_Estabelecimento estab2 = Bvruaajm_EnumEstabelecimentoConveniado.ConsultoriaInfoteca.obterEstabelecimento();
    Bvruaajm_ServicosTask servicoTask;
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_SimuladorTask simuladorTask;
    int tipoCartao, tipoModalidade, parcela;
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

    @Tag("SmokeTest")
    @Tag("Simulador")
    @Test
    @Disabled("testes do simulador esta com varicao no calculos(backend)")
    @DisplayName("Teste Valida a simulação de venda no mastercard debito")
    public void validaMastercardDebito() {
        tipoCartao = 3;
        tipoModalidade = 1;
        valor = 200;
        valorCalculado = 196.42;
        simuladorTask.validacaoSimulacaoSemValorIntegralDebito(valor, tipoCartao, tipoModalidade, valorCalculado);
    }

    @Tag("Simulador")
    @Test
    @Disabled("testes do simulador esta com varicao no calculos(backend)")
    @DisplayName("Teste Valida a simulação de venda no mastercard debito recebendo valor integral")
    public void validaMastercardDebitoReceberValorIntegral() {
        tipoCartao = 3;
        tipoModalidade = 1;
        valor = 1000;
        valorCalculado = 1018.22;
        simuladorTask.validacaoSimulacaoValorIntegralDebito(valor, tipoCartao, tipoModalidade, valorCalculado);
    }

    @Tag("Simulador")
    @Test
    @Disabled("testes do simulador esta com varicao no calculos(backend)")
    @DisplayName("Teste Valida a simulação de venda no mastercard Credito a vista")
    public void validaMastercardCreditoAVista() {
        tipoCartao = 3;
        tipoModalidade = 2;
        valor = 2000.00;
        mdr = 1.99;
        antecipacao = 1.69;
        simuladorTask.validacaoSimulacaoSemValorIntegral(valor, tipoCartao, tipoModalidade, mdr, antecipacao);
    }

    @Tag("Simulador")
    @Test
    @Disabled("testes do simulador esta com varicao no calculos(backend)")
    @DisplayName("Teste Valida a simulação de venda no mastercard Credito a vista recebendo valor integral")
    public void validaMastecardCreditoAVistaReceberValorIntegral() {
        tipoCartao = 3;
        tipoModalidade = 2;
        valor = 1500.00;
        mdr = 1.99;
        antecipacao = 1.69;
        simuladorTask.validacaoSimulacaoValorIntegral(valor, tipoCartao, tipoModalidade, mdr, antecipacao);
    }

    @Tag("Simulador")
    @Test
    @Disabled("testes do simulador esta com varicao no calculos(backend)")
    @DisplayName("Teste Valida a simulação de venda no mastercard credito Pareclado em 4x")
    public void validacaoMastecardCreditoParcelado() {
        tipoCartao = 3;
        tipoModalidade = 4;
        parcela = 4;
        valor = 2000.00;
        mdr = 2.19;
        simuladorTask.validacaoSimulacaoCreditoParceladoSemValorIntegral(valor, tipoCartao, tipoModalidade, parcela, mdr);
    }

    @Tag("Simulador")
    @Test
    @Disabled("testes do simulador esta com varicao no calculos(backend)")
    @DisplayName("Teste Valida a simulação de venda no mastercard credito Pareclado em 4x recebendo valor integral")
    public void validacaoMastecardCreditoParceladoReceberValorIntegral() {
        tipoCartao = 3;
        tipoModalidade = 4;
        valor = 2000.00;
        parcela = 4;
        mdr = 2.19;
        // simuladorTask.validacaoSimulacaoCreditoParceladoValorIntegral(valor, tipoCartao, tipoModalidade, parcela, mdr);
    }

    @Tag("Simulador")
    @Test
    @Disabled("testes do simulador esta com varicao no calculos(backend)")
    @DisplayName("Teste Valida a simulação de venda no mastercard credito Pareclado em 12x")
    public void validacaoMastecardCreditoParceladoMaisDeSeisVezes() {
        tipoCartao = 3;
        tipoModalidade = 4;
        valor = 3000.00;
        parcela = 12;
        mdr = 2.19;
        simuladorTask.validacaoSimulacaoCreditoParceladoSemValorIntegral(valor, tipoCartao, tipoModalidade, parcela, mdr);
    }

    @Tag("Simulador")
    @Test
    @Disabled("testes do simulador esta com varicao no calculos(backend)")
    @DisplayName("Teste Valida a simulação de venda no mastercard credito Pareclado em 12x recebendo valor integral")
    public void validacaoMastecardCreditoParceladoMaisDeSeisVezesReceberValorIntegral() {
        tipoCartao = 3;
        tipoModalidade = 4;
        valor = 3000.00;
        parcela = 12;
        mdr = 2.19;
        // simuladorTask.validacaoSimulacaoCreditoParceladoValorIntegral(valor, tipoCartao, tipoModalidade, parcela, mdr);
    }

    @Tag("SmokeTest")
    @Tag("Simulador")
    @Disabled("testes do simulador esta com varicao no calculos(backend)")
    @Test
    @DisplayName("Teste Valida a simulação de venda no mastercard credito Pareclado em 12x")
    public void validacaoMastecardCreditoParceladoMaisDeSeisVezesSemAntecipacao() {
        genericTask.selecionaEstabelecimentoOuConveniado(estab2);
        tipoCartao = 3;
        tipoModalidade = 4;
        valor = 3000.00;
        parcela = 12;
        mdr = 5.5;
        simuladorTask.validacaoSimulacaoCreditoParceladoSemValorIntegral(valor, tipoCartao, tipoModalidade, parcela, mdr);
        simuladorTask.validaQuantidadeParcelasSimulada(parcela);
    }
}
