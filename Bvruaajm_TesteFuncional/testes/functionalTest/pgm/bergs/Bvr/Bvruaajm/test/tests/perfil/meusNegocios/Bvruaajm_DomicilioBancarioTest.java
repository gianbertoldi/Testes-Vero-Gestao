package bergs.Bvr.Bvruaajm.test.tests.perfil.meusNegocios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.perfil.Bvruaajm_PerfilTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;

public class Bvruaajm_DomicilioBancarioTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.ConsultoriaInfoteca.obterEstabelecimento();
    Bvruaajm_Estabelecimento estab2 = Bvruaajm_EnumEstabelecimentoConveniado.SweetFlavors.obterEstabelecimento();

    Bvruaajm_GenericTask genericTask;
    Bvruaajm_PerfilTask perfilTask;

    @BeforeEach
    public void iniciaTest() {
        genericTask = new Bvruaajm_GenericTask(driver);
        perfilTask = new Bvruaajm_PerfilTask(driver);
        taskMobile.definirContextoWebview();
        genericTask.prepararTesteLogado(cartaoAcesso);
    }

    @Tag("SmokeTest")
    @Tag("Perfil")
    @Test
    @DisplayName("Verifica ISPB visivel em Domicilio Bancário")
    public void verificaISPBDomicilioBancario() {
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        genericTask.clicarBotaoPerfil();
        perfilTask.validarISPBDomicilioBancario();
    }

    @Tag("Perfil")
    @Test
    @DisplayName("Verifica ISPB visivel em Domicilio Bancário Cartão Pré Pago")
    public void verificaISPBDomicilioBancarioCartaoPrePago() {
        genericTask.selecionaEstabelecimentoOuConveniado(estab2);
        genericTask.clicarBotaoPerfil();
        perfilTask.validarISPBDomicilioBancarioContaPrePago();
    }
}
