package bergs.Bvr.Bvruaajm.test.tests.servicos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.servicos.Bvruaajm_MeusChamadosTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;

public class Bvruaajm_MeusChamadosTest extends Bvruaajm_TesteBaseMobile {
    
    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.BancoBergs.obterEstabelecimento();
    Bvruaajm_Estabelecimento estabSemListaChamados = Bvruaajm_EnumEstabelecimentoConveniado.ConsultoriaInfoteca.obterEstabelecimento();
    Bvruaajm_MeusChamadosTask meusChamadosTask;
    Bvruaajm_GenericTask genericTask;

    @BeforeEach
    public void iniciaTeste() {
        meusChamadosTask = new Bvruaajm_MeusChamadosTask(driver);
        genericTask = new Bvruaajm_GenericTask(driver);
        taskMobile.definirContextoWebview();
        genericTask.prepararTesteLogado(cartaoAcesso);
    }
    
    @Tag("Servicos")
    @Test
    @DisplayName("Teste faz a validação da tela central de chamados")
    public void validaTelaCentralDeChamadosTest() {
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        genericTask.clicarBotaoServicos();
        meusChamadosTask.validaTelaCentralDeChamados();
    }

    @Tag("Servicos")
    @Test
    @DisplayName("Teste faz a validação da tela central de chamados sem chamados abertos")
    public void validaTelaCentralDeChamadosSemChamadosAbertosTest() {
        genericTask.selecionaEstabelecimentoOuConveniado(estabSemListaChamados);
        genericTask.clicarBotaoServicos();
        meusChamadosTask.validaTelaCentralDeChamadosSemChamadosAbertos();
    }
    
    @Tag("Servicos")
    @Test
    @DisplayName("Teste faz a validação da tela central de chamados meus chamados")
    public void validarMeuasChamndosTest() {
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        genericTask.clicarBotaoServicos();
        meusChamadosTask.validaMeusChamados();
    }
}
