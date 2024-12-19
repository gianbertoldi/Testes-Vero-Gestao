package bergs.Bvr.Bvruaajm.test.tests.extrato;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.extrato.Bvruaajm_MenuExtraroTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_ElementoNativoTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;

public class Bvruaajm_DetalhamentoExtratoMinhasVendasTest extends Bvruaajm_TesteBaseMobile {
    
    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.SweetFlavors.obterEstabelecimento();
    Bvruaajm_Estabelecimento estab2 = Bvruaajm_EnumEstabelecimentoConveniado.Alberto.obterEstabelecimento();
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_ElementoNativoTask nativoTask;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_MenuExtraroTask extratoTask;
    String nsu;
    String data;

    @BeforeEach
    public void preparaTest() {
        genericTask = new Bvruaajm_GenericTask(driver);
        nativoTask = new Bvruaajm_ElementoNativoTask(driver);
        jsExecutor = new Bvruaajm_JsExecutor(driver);
        extratoTask = new Bvruaajm_MenuExtraroTask(driver);
        genericTask.prepararTesteLogado(cartaoAcesso);
    }
    
    @Test
    @Tag("Extrato")
    @Disabled("Ainda não esta implantado ")
    @DisplayName("Teste para validar oa info no que o MDR vai esta diponivel no proximo dia util detalhamento da venda")
    public void testValidaInfoMdrDisponivelProximoDiaUtil() {
        data = "08082024";
        nsu = "1730";
        genericTask.selecionaEstabelecimentoOuConveniado(estab2);
        genericTask.clicarBotaoExtratos();       
        extratoTask.validaInfoMdrDiponivelProximoDiaUtil(data, nsu);
    }
    
    @Test
    @Tag("Extrato")
    @Disabled("Ainda não esta implantado ")
    @DisplayName("Teste que valida que o MDR esta diponivel no detalhamento da venda")
    public void testValidaMdrDaVenda() {
        data = "26062024";
        nsu = "1356";
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        genericTask.clicarBotaoExtratos();       
        extratoTask.validaMdrDaVenda(data, nsu);
    }
}
