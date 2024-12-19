package bergs.Bvr.Bvruaajm.test.tests.home;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.home.Bvruaajm_HomeTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;

public class Bvruaajm_ValidaBandeiraBeneficioHomeTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.JonathanBarbiero.obterEstabelecimento();
    Bvruaajm_HomeTask homeTask;
    Bvruaajm_GenericTask genericTask;

    @BeforeEach
    public void preparaTest() {
        homeTask = new Bvruaajm_HomeTask(driver);
        genericTask =  new Bvruaajm_GenericTask(driver);
        genericTask.prepararTesteLogado(cartaoAcesso);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
    }

    @Tag("home")
    @DisplayName("Valida dentro dos cartoes beneficio a opcao de contatar a vero")
    @Test
    public void validaCartaoBeneficioContatoVero() {
        homeTask.validaCartaoBeneficioContatoVeroTask();
    }
}
