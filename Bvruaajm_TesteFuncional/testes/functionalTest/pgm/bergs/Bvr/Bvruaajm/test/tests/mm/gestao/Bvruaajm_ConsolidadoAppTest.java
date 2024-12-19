package bergs.Bvr.Bvruaajm.test.tests.mm.gestao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.mm.genericMM.Bvruaajm_GenericMMTask;
import bergs.Bvr.Bvruaajm.test.tasks.mm.gestao.Bvruaajm_ConsolidadoAppMMTask;
import bergs.Bvr.Bvruaajm.test.tasks.mm.menuLateral.Bvruaajm_MenuLateralTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMM;

public class Bvruaajm_ConsolidadoAppTest extends Bvruaajm_TesteBaseMM {

    Bvruaajm_GenericMMTask genericMMTask;
    Bvruaajm_MenuLateralTask menuLateralTask;
    Bvruaajm_ConsolidadoAppMMTask consolidadoAppMMTask;
    String modalMesAnoNaoInformado = "Campo Mês/Ano não foi informado.";
    String modalDataNaoInformado = "Campo Data não foi informado.";


    @BeforeEach
    public void iniciaTest() {
        genericMMTask = new Bvruaajm_GenericMMTask(driver);
        consolidadoAppMMTask = new Bvruaajm_ConsolidadoAppMMTask(driver);
        menuLateralTask = new Bvruaajm_MenuLateralTask(driver);
        menuLateralTask.acessarMenuGestaoConsolidadoApp();
    }

    
    @Tag("MM5Gestao")
    @DisplayName("Valida consulta consolidado do app MM5 por mes/ano")
    @Test
    public void validaConsultaConsolidadoAppMMPorMesAnoTest() {
        String estabelecimentoDistinto = "37 Estabelecimentos";
        String usuariosDistinto = "24 Usuários";
        String totalAcessos = "1793 Acessos";
        consolidadoAppMMTask.validaConsultaListaConsolidadoPorMesAnoTask(estabelecimentoDistinto, usuariosDistinto, totalAcessos);
    }

    @Tag("MM5Gestao")
    @DisplayName("Valida consulta consolidado do app MM5 por data")
    @Test
    public void validaConsultaConsolidadoAppMMPorDataTest() {
        String estabelecimentoDistinto = "10 Estabelecimentos";
        String usuariosDistinto = "7 Usuários";
        String totalAcessos = "68 Acessos";
        consolidadoAppMMTask.validaConsultaListaConsolidadoPorDataTask(estabelecimentoDistinto, usuariosDistinto, totalAcessos);
    }
    
    @Tag("MM5Gestao")
    @DisplayName("Valida consulta consolidado do app MM5 modal de ano mes não informado")
    @Test
    public void validaConsultaConsolidadoMesAnoNaoInformadoTest() {
        consolidadoAppMMTask.validaConsultaListaConsolidadoModalMesAnosNaoInfomadoTask(modalMesAnoNaoInformado);
    }
    
    @Tag("MM5Gestao")
    @DisplayName("Valida consulta consolidado do app MM5 modal de ano mes não informado")
    @Test
    public void validaConsultaConsolidadoDataNaoInformadoTest() {
        consolidadoAppMMTask.validaConsultaListaConsolidadoModalDataNaoInfomadoTask(modalDataNaoInformado);
    }
}
