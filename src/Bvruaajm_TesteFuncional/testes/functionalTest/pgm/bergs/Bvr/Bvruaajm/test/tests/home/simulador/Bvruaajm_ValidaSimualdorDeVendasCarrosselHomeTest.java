package bergs.Bvr.Bvruaajm.test.tests.home.simulador;

import org.junit.jupiter.api.BeforeEach;
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

public class Bvruaajm_ValidaSimualdorDeVendasCarrosselHomeTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.SweetFlavors.obterEstabelecimento();
    Bvruaajm_ServicosTask servicoTask;
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_SimuladorTask simuladorTask;
    int tipoCartao, tipoModalidade, parcela;
    double valor, valorCalculado;

    @BeforeEach
    public void iniciaTeste() {
        servicoTask = new Bvruaajm_ServicosTask(driver);
        genericTask = new Bvruaajm_GenericTask(driver);
        simuladorTask = new Bvruaajm_SimuladorTask(driver);
        taskMobile.definirContextoWebview();
        genericTask.prepararTesteLogado(cartaoAcesso);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        simuladorTask.clicarBotaoSimuladorCarrosselHome();
    }

    @Tag("simulador")
    @Test
    @DisplayName("Teste Valida o valor minimo do simulador atraves do carrossel da home")
    public void testeValorMinimo() {
        simuladorTask.validaValorMinimo(0.99);
    }

    @Tag("simulador")
    @Test
    @DisplayName("Teste faz uma simulação e selecionacia a Nova Simulação atraves do carrossel da home")
    public void novaSimulacao() {
        valor = 200;
        tipoCartao = 4;
        tipoModalidade = 1;
        simuladorTask.validaNovaSimulacao(valor, tipoCartao, tipoModalidade);
    }
}
