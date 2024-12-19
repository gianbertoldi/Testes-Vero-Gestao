package bergs.Bvr.Bvruaajm.test.tests.home.conexoes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCardsCarrossel;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.validations.home.Bvruaajm_HomeValidation;

public class Bvruaajm_ValidaConexoesCarrosel extends Bvruaajm_TesteBaseMobile{

    private Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.Matheus.obterCartaoAcesso();
    
    private Bvruaajm_GenericTask genericTask;
    private Bvruaajm_HomeValidation homeValidation;
    private Bvruaajm_TaskMobile taskMobile;
    
    @BeforeEach
    public void antesDoTeste() {
        genericTask.prepararTesteLogado(cartaoAcesso);     
        taskMobile.definirContextoWebview();
    }
    
    @Tag("BAG")
    @Test
    @DisplayName("Valida Card para usuario habilitado")
    public void validaCardConexoesNaHome() {
        genericTask.selecionaEstabelecimentoOuConveniado(Bvruaajm_EnumEstabelecimentoConveniado.CasaDoPintor7Teste.obterEstabelecimento());
        homeValidation.validaCarrosel(Bvruaajm_EnumCardsCarrossel.CARD_CONEXOES.toString(), Bvruaajm_EnumCardsCarrossel.TITULO_CONEXOES.toString(), Bvruaajm_EnumCardsCarrossel.MENSAGEM_CONEXOES.toString());
    }
    
    @Tag("BAG")
    @Test
    @DisplayName("Valida Card desabilitado para usuarios")
    public void validaCardConexoesDesabilitadoNaHome() {
        genericTask.selecionaEstabelecimentoOuConveniado(Bvruaajm_EnumEstabelecimentoConveniado.CasaDoPintor2Teste.obterEstabelecimento());
        homeValidation.validaBloqueioDaVisualizacao();
    }
}
