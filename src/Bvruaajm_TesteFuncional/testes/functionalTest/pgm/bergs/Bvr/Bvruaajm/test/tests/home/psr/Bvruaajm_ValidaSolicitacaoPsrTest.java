package bergs.Bvr.Bvruaajm.test.tests.home.psr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_OnboardingTask;
import bergs.Bvr.Bvruaajm.test.tasks.home.psr.Bvruaajm_PsrTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBjr;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;

public class Bvruaajm_ValidaSolicitacaoPsrTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_CartaoAcesso cartaoAcesso2 = Bvruaajm_EnumCartaoAcesso.LeopoldinoSilva.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.ConsultoriaInfoteca.obterEstabelecimento();
    Bvruaajm_Estabelecimento estab2 = Bvruaajm_EnumEstabelecimentoConveniado.BancoBergs.obterEstabelecimento();
    Bvruaajm_Estabelecimento estab3 = Bvruaajm_EnumEstabelecimentoConveniado.PsrHabilitado.obterEstabelecimento();
    Bvruaajm_PsrTask psrTask;
    Bvruaajm_OnboardingTask genericonbording;
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_SqlBjr sqlBjr;

    @BeforeEach
    public void iniciaTeste() {
        psrTask = new Bvruaajm_PsrTask(driver);
        genericTask = new Bvruaajm_GenericTask(driver);
        genericonbording = new Bvruaajm_OnboardingTask(driver);
    }


    @Tag("PSR")
    @Test
    @DisplayName("Validar card PSR")
    public void psrVerificaCardTest() {
        genericTask.prepararTesteLogado(cartaoAcesso);
        genericTask.selecionaEstabelecimentoOuConveniado(estab2);
        psrTask.validaPsrIndisponivelPerfilConsulta();
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        genericTask.selecionaEstabelecimentoOuConveniado(estab2);
        psrTask.validaPsrIndisponivelPerfilConsulta();
    }

    @Tag("PSR")
    @Test
    @DisplayName("Validar Nova Solicitacao Psr")
    public void validarNovaSolicitacaoPsr() {
        sqlBjr = new Bvruaajm_SqlBjr();
        sqlBjr.deletarSolicitacaoPSR(cartaoAcesso, estab);
        genericTask.prepararTesteLogado(cartaoAcesso);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        psrTask.acessarPrs();
        genericonbording.verificaPularOnboardingGeneric();
        psrTask.validaNovaSolicitacaoPsrCielo();
    }

    @Tag("PSR")
    @Test
    @DisplayName("Validar Solicitacao Pendete Psr")
    public void validarSolicitacaoPendetePsr() {
        genericTask.prepararTesteLogado(cartaoAcesso);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        psrTask.validarSolicitacaoPendetePrs();
    }
    
    @Tag("PSR")
    @Test
    @DisplayName("Validar Solicitacao Habilitada Psr")
    public void validarSolicacaoHabilitadaPsr() {
        genericTask.prepararTesteLogado(cartaoAcesso2);
        genericTask.selecionaEstabelecimentoOuConveniado(estab3);
        psrTask.acessarPrs();
        genericonbording.verificaPularOnboardingGeneric();
        psrTask.validarSolicitacaoHabilitadaPrs();
    }
}
