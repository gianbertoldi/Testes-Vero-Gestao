package bergs.Bvr.Bvruaajm.test.tests.mm.gestao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.mm.genericMM.Bvruaajm_GenericMMTask;
import bergs.Bvr.Bvruaajm.test.tasks.mm.gestao.Bvruaajm_ConsultaMMAcessosTask;
import bergs.Bvr.Bvruaajm.test.tasks.mm.menuLateral.Bvruaajm_MenuLateralTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMM;

public class Bvruaajm_ConsutaMMAcessosTests extends Bvruaajm_TesteBaseMM {

    Bvruaajm_GenericMMTask genericMMTask;
    Bvruaajm_MenuLateralTask menuLateralTask;
    Bvruaajm_ConsultaMMAcessosTask consultaMMAcessosTask;
    String numeroRegistros;

    @BeforeEach
    public void iniciaTest() {
        genericMMTask = new Bvruaajm_GenericMMTask(driver);
        consultaMMAcessosTask = new Bvruaajm_ConsultaMMAcessosTask(driver);
        menuLateralTask = new Bvruaajm_MenuLateralTask(driver);
        menuLateralTask.acessarMenuGestaoAnaliseEventos();
        genericMMTask.clicarBotaoLimpar();
    }

    @Tag("MM5Gestao")
    @DisplayName("Valida a pesquisa da consuta por ambos Ecs e coveniados")
    @Test
    public void validaNumeroDeRegitroDaCosultaAcessosTipoLogistaAmbosTest() {
        numeroRegistros = "188";
        consultaMMAcessosTask.validaNumeroDeRegitroDaCosultaAcessosTipoLogistaAmbos(numeroRegistros);
    }

    @Tag("MM5Gestao")
    @DisplayName("Valida a pesquisa da consuta por tipo coveniados")
    @Test
    public void validaNumeroDeRegitroDaCosultaAcessosTipoLogistaCoveniadoTest() {
        numeroRegistros = "164";
        consultaMMAcessosTask.validaNumeroDeRegitroDaCosultaAcessosTipoLogistaCoveniado(numeroRegistros);
    }

    @Tag("MM5Gestao")
    @DisplayName("Valida a pesquisa da consuta por tipo estabelecimento")
    @Test
    public void validaNumeroDeRegitroDaCosultaAcessosTipoLogistaEstabelecimentoTest() {
        numeroRegistros = "24";
        consultaMMAcessosTask.validaNumeroDeRegitroDaCosultaAcessosTipoLogistaEstabelecimento(numeroRegistros);
    }

    @Tag("MM5Gestao")
    @DisplayName("Valida a pesquisa por pela selecao de tipo de acessos")
    @Test
    public void validaPesquisaPorTipoDeAcesso() {
        numeroRegistros = "75";
        consultaMMAcessosTask.validaPesquisaPorTipoDeAcesso(numeroRegistros);
    }

    @Tag("MM5Gestao")
    @DisplayName("Valida a pesquisa por tipo pessoa Fisica")
    @Test
    public void validaPesquisaPorTipoPessoaFisica() {
        numeroRegistros = "17";
        consultaMMAcessosTask.validaPesquisaPorTipoPessoaFisica(numeroRegistros);
    }

    @Tag("MM5Gestao")
    @DisplayName("Valida a pesquisa por tipo pessoa juridica")
    @Test
    public void validaPesquisaPorTipoJurudica() {
        numeroRegistros = "20";
        consultaMMAcessosTask.validaPesquisaPorTipoJuridica(numeroRegistros);
    }

    @Tag("MM5Gestao")
    @DisplayName("Valida a funcao voltar apos uma pesquisa")
    @Test
    public void validaVoltarAposAPesquisa() {
        numeroRegistros = "188";
        consultaMMAcessosTask.validaVoltarAposAPesquisa(numeroRegistros);
    }

    @Tag("MM5Gestao")
    @DisplayName("Valida a pesquisa por tipo pessoa juridica com filtro usuario")
    @Test
    public void validaPesquisaPorTipoJurudicaComFiltroUsuario() {
        numeroRegistros = "122";
        consultaMMAcessosTask.validaPesquisaPorTipoJuridicaPeloUsuario(numeroRegistros);
    }

    @Tag("MM5Gestao")
    @DisplayName("Valida a pesquisa por tipo pessoa juridica com filtro usuario")
    @Test
    public void validaPesquisaPorTipoFisicaComFiltroUsuario() {
        numeroRegistros = "1";
        consultaMMAcessosTask.validaPesquisaPorTipoFisicaPeloUsuario(numeroRegistros);
    }

    @Tag("MM5Gestao")
    @DisplayName("Valida a pesquisa com todos tipos de filtro aplicado")
    @Test
    public void validaPesquisaComTodosFiltrosAplicados() {
        numeroRegistros = "12";
        consultaMMAcessosTask.validaPesquisaComTodosFiltrosAplicados(numeroRegistros);
    }
}
