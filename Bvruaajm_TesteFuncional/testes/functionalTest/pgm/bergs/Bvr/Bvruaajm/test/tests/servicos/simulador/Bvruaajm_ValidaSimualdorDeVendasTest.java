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

public class Bvruaajm_ValidaSimualdorDeVendasTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.SweetFlavors.obterEstabelecimento();
    Bvruaajm_ServicosTask servicoTask;
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_SimuladorTask simuladorTask;
    int tipoCartao, tipoModalidade, parcela;
    double valor, valorCalculado, mdr, antecipacao;
    String modalidadeLiberada;

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
    @DisplayName("Teste Valida o valor minimo do simulador")
    public void testeValorMinimo() {
        simuladorTask.validaValorMinimo(0.99);
    }

    @Tag("Simulador")
    @Test
    @DisplayName("Teste faz uma simulação e selecionacia a Nova Simulação e verifica o comportamento correto")
    public void novaSimulacao() {
        valor = 200;
        tipoCartao = 4;
        tipoModalidade = 1;
        simuladorTask.validaNovaSimulacao(valor, tipoCartao, tipoModalidade);
    }

    @Tag("Simulador")
    @Test
    @DisplayName("Teste Valida campo Credito parcelado lojista e info")
    public void testeModalidadeCreditoParceladoLojista() {
        valor = 200;
        tipoCartao = 3;
        tipoModalidade = 3;
        simuladorTask.validaDescricaoEInfoParcelamentoLojista(valor, tipoCartao, tipoModalidade);
    }

    @Tag("Simulador")
    @Test
    @Disabled("testes do simulador esta com varicao no calculos(backend)")
    @DisplayName("Teste Valida simulador banricompras pre-datado")
    public void testeModalidadeBanricomprasPreDatado() {
        tipoModalidade = 2;
        tipoCartao = 1;
        valor = 100.00;
        mdr = 1.89;
        antecipacao = 2;
        simuladorTask.validacaoSimulacaoSemValorIntegral(valor, tipoCartao, tipoModalidade, mdr, antecipacao);
    }

    @Tag("Simulador")
    @Test
    @Disabled("testes do simulador esta com varicao no calculos(backend)")
    @DisplayName("Teste Valida simulador banricompras pre-datado Receber Valor Integral")
    public void testeModalidadeBanricomprasPreDatadoReceberValorIntegral() {
        tipoModalidade = 2;
        tipoCartao = 1;
        valor = 100.00;
        mdr = 1.89;
        antecipacao = 2;
        simuladorTask.validacaoSimulacaoValorIntegral(valor, tipoCartao, tipoModalidade, mdr, antecipacao);
    }

    @Tag("Simulador")
    @Disabled("testes do simulador esta com varicao no calculos(backend)")
    @Test
    @DisplayName("Teste Valida a simulação de venda no VerdeCard credito Pareclado em 4x")
    public void validacaoVerdeCardCreditoParcelado() {
        tipoCartao = 6;
        tipoModalidade = 3;
        parcela = 4;
        valor = 2000.00;
        valorCalculado = 1999.80;
        mdr = 0.01;
        simuladorTask.validacaoSimulacaoCreditoParceladoSemValorIntegral(valor, tipoCartao, tipoModalidade, parcela, mdr);
        simuladorTask.validarResumoSemAntecipacao(valor, tipoCartao, tipoModalidade, parcela, valorCalculado);
    }

    @Tag("Simulador")
    @Test
    @DisplayName("Teste para validar se no simulador o link credito a vista esta indisponivel")
    public void testeValidaSimuladorCreditoAVistaEstaIndisponivel() {
        valor = 3;
        tipoCartao = 3;
        modalidadeLiberada = "4";
        simuladorTask.validaLinkIndiponivel(valor, tipoCartao, modalidadeLiberada);
    }

    @Tag("Simulador")
    @Test
    @DisplayName("Teste para validar se no simulador o link credito parcelado esta indisponivel")
    public void testeValidaSimuladorCreditoParceladoEstaIndisponivel() {
        valor = 15.00;
        tipoCartao = 3;
        modalidadeLiberada = "5";
        simuladorTask.validaLinkIndiponivel(valor, tipoCartao, modalidadeLiberada);
    }

    @Tag("Simulador")
    @Test
    @DisplayName("Teste para validar se no simulador o link credito parcelado atende a parcela minima exigida")
    public void testeValidaSimuladorMinimoParcelasLinkPgto() {
        valor = 20.00;
        tipoCartao = 3;
        tipoModalidade = 5;
        String paracelaIndisponivel = "4";
        simuladorTask.validaDisponibilidadeDeParcelasLinkPgto(valor, tipoCartao, tipoModalidade, paracelaIndisponivel);
    }
}
