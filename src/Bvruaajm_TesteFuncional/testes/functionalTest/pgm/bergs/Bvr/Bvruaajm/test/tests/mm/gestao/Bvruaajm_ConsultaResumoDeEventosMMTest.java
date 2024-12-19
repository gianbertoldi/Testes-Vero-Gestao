package bergs.Bvr.Bvruaajm.test.tests.mm.gestao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.mm.genericMM.Bvruaajm_GenericMMTask;
import bergs.Bvr.Bvruaajm.test.tasks.mm.gestao.Bvruaajm_ConsultaResumoDeEventosMMTask;
import bergs.Bvr.Bvruaajm.test.tasks.mm.menuLateral.Bvruaajm_MenuLateralTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMM;

public class Bvruaajm_ConsultaResumoDeEventosMMTest extends Bvruaajm_TesteBaseMM {

    Bvruaajm_GenericMMTask genericMMTask;
    Bvruaajm_MenuLateralTask menuLateralTask;
    Bvruaajm_ConsultaResumoDeEventosMMTask resumoEventoTask;
    String dataInicial;
    String dataFinal;
    String dataInvalida = "* Data inválida";
    String retornoModalDatasInvalidas = "A Data Final deve ser mais recente que a Data Inicial.";
    String retornoModalDataInicialVazia = "O campo Data Inicio deve ser informado.";
    String retornoModalDataFinalVazia = "O campo Data Fim deve ser informado.";

    @BeforeEach
    public void iniciaTest() {
        genericMMTask = new Bvruaajm_GenericMMTask(driver);
        menuLateralTask = new Bvruaajm_MenuLateralTask(driver);
        resumoEventoTask = new Bvruaajm_ConsultaResumoDeEventosMMTask(driver);
        menuLateralTask.acessarMenuGestaoResumoEventos();
        genericMMTask.clicarBotaoLimpar();
    }

    @Tag("MM5Gestao")
    @Test
    @DisplayName("valida os dados dentro de uma linha na consulta de lista de eventos")
    public void validarLinhaDaTabelaDeConsultaResumosEventos() {
        dataInicial = "04/08/2024";
        dataFinal = "05/08/2024";
        resumoEventoTask.validarLinhaDaTabelaDeConsultaResumosEventos(dataInicial, dataFinal, "2");
    }
    
    @Tag("MM5Gestao")
    @Test
    @DisplayName("valida modal de retorno data inicial menor que final")
    public void validaModalDeRetornoDataInicialMenorQueFinal() {
        dataInicial = "05/08/2024";
        dataFinal = "04/08/2024";
        resumoEventoTask.validaModalDeRetornoDataInicialMenorQueFinal(dataInicial, dataFinal, retornoModalDatasInvalidas);
    }
    
    @Tag("MM5Gestao")
    @Test
    @DisplayName("valida modal de retorno data inicial vazia")
    public void validaModalDeRetornoDataInicialVazia() {
        resumoEventoTask.validaModalDeRetornoDataInicialVazia(retornoModalDataInicialVazia);
    }
    
    @Tag("MM5Gestao")
    @Test
    @DisplayName("valida modal de retorno data Final vazia")
    public void validaModalDeRetornoDataFinallVazia() {
        dataInicial = "04/08/2024";
        resumoEventoTask.validaModalDeRetornoDataFinalVazia(dataInicial, retornoModalDataFinalVazia);
    }
}
