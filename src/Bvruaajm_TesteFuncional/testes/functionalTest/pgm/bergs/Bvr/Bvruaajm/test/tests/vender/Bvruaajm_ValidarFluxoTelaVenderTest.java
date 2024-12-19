package bergs.Bvr.Bvruaajm.test.tests.vender;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_VenderTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_VeroXTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;

public class Bvruaajm_ValidarFluxoTelaVenderTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_GenericTask genericTask;
    Bvruaajm_VenderTask venderTask;
    Bvruaajm_VeroXTask veroXtask;
    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.SweetFlavors.obterEstabelecimento();
    Bvruaajm_Estabelecimento estab2 = Bvruaajm_EnumEstabelecimentoConveniado.ConsultoriaInfoteca.obterEstabelecimento();
    String tituloVeroX = "Olá, vamos começar a configurar seu Vero X?";
    String confimacaAdesaoMeiaModalVeroX = "Agora você já pode vender com o Vero X!";

    @BeforeEach
    public void iniciaTeste() {
        genericTask = new Bvruaajm_GenericTask(driver);
        venderTask = new Bvruaajm_VenderTask(driver);
        veroXtask = new Bvruaajm_VeroXTask(driver);
        genericTask.prepararTesteLogado(cartaoAcesso);
    }

    @Tag("SmokeTest")
    @Tag("Vender")
    @DisplayName("Valida acesar tela da Vero Wallet")
    @Test
    public void verificarTelaVeroWallet() {
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        genericTask.clicarBotaoVender();
        venderTask.validaTelaVeroWallet();
    }

    @Tag("Vender")
    @DisplayName("Valida acesar tela da Vero X")
    @Test
    public void verificarTelaVeroX() {
        genericTask.selecionaEstabelecimentoOuConveniado(estab2);
        genericTask.clicarBotaoVender();
        veroXtask.validaTelaVeroX();
    }

    @Tag("Vender")
    @DisplayName("Valida o fluxo de adesao ao Vero X")
    @Test
    public void verificarFluxoAdesaoAoVeroX() {
        genericTask.selecionaEstabelecimentoOuConveniado(estab2);
        genericTask.clicarBotaoVender();
        venderTask.clicarBotaoVeroX();
        veroXtask.validaFluxoAdesaoVeroX(tituloVeroX, confimacaAdesaoMeiaModalVeroX);
    }
}
