package bergs.Bvr.Bvruaajm.test.tests.home;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.home.Bvruaajm_HomeTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;

public class Bvruaajm_ExtratoHomeTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.Alberto.obterEstabelecimento();
    Bvruaajm_Estabelecimento estab2 = Bvruaajm_EnumEstabelecimentoConveniado.TesteGustavoImagens.obterEstabelecimento();
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_HomeTask homeTask;

    @BeforeEach
    public void iniciaTeste() {
        genericTask = new Bvruaajm_GenericTask(driver);
        homeTask = new Bvruaajm_HomeTask(driver);
        genericTask.definirContextoWebview();
        genericTask.prepararTesteLogado(cartaoAcesso);
    }

    @DisplayName("Teste para validar as mesagens de erro que não transções ainda no extrato da home")
    @Test
    public void validaExtratoHomeSemTrasacoes() {
        genericTask.selecionaEstabelecimentoOuConveniado(estab2);
        homeTask.validaExtratoHomeSemTrasacoes();
    }
    
    
    @DisplayName("Teste para validar Acesso a listagem de venda pela home")
    @Test
    public void validaAcessoAoExtratoDaHome() {
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        homeTask.validaAcessoPeloExtratoDaHome();
    }
}
