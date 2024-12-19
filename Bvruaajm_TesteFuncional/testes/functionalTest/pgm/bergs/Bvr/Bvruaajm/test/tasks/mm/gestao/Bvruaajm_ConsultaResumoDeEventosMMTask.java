package bergs.Bvr.Bvruaajm.test.tasks.mm.gestao;

import org.openqa.selenium.remote.RemoteWebDriver;

import bergs.Bvr.Bvruaajm.test.pages.mm.genericMM.Bvruaajm_GenericMMPage;
import bergs.Bvr.Bvruaajm.test.pages.mm.gestao.Bvruaajm_ConsultaResumoDeEventosMMPage;
import bergs.Bvr.Bvruaajm.test.tasks.mm.genericMM.Bvruaajm_GenericMMTask;
import bergs.Bvr.Bvruaajm.test.tasks.mm.genericMM.Bvruaajm_ModaMMTask;
import bergs.Bvr.Bvruaajm.test.validations.mm.Bvruaajm_GenericMMValidations;
import bergs.Bvr.Bvruaajm.test.validations.mm.gestao.Bvruaajm_ConsultaResumoDeEventosMMValidation;
import bergs.bmo.bmouaajm.suporte.tasks.Bmouaajm_TaskBase;
import bergs.bmo.bmouaajm.suporte.util.Bmouaajm_Javascript;

public class Bvruaajm_ConsultaResumoDeEventosMMTask extends Bmouaajm_TaskBase {
    
    Bvruaajm_GenericMMTask genericMMTask;
    Bvruaajm_GenericMMPage genericMMPage;
    Bvruaajm_ModaMMTask modalMMTask;
    Bvruaajm_ConsultaResumoDeEventosMMPage resumoEventoPage;
    Bvruaajm_ConsultaResumoDeEventosMMValidation resumoEventosValidations;
    Bvruaajm_GenericMMValidations genericMMAValidation;
    Bvruaajm_ModaMMTask modalTask;
    Bmouaajm_Javascript jsExecutor;
   
    public Bvruaajm_ConsultaResumoDeEventosMMTask(RemoteWebDriver driver) {
        super(driver);
        genericMMTask = new Bvruaajm_GenericMMTask(driver);
        genericMMPage = new Bvruaajm_GenericMMPage(driver);
        modalMMTask = new Bvruaajm_ModaMMTask(driver);
        genericMMAValidation = new Bvruaajm_GenericMMValidations(driver);
        resumoEventoPage =  new Bvruaajm_ConsultaResumoDeEventosMMPage(driver);
        resumoEventosValidations = new Bvruaajm_ConsultaResumoDeEventosMMValidation(driver);
        modalTask = new Bvruaajm_ModaMMTask(driver);
        jsExecutor =  new Bmouaajm_Javascript(driver);
    }

    public void validarLinhaDaTabelaDeConsultaResumosEventos(String dataInicial, String dataFinal, String linha) {
        entradaDatasEPsequisa(dataInicial,dataFinal);
        resumoEventosValidations.validarElementoNaLinhaDaTabelaDeResumoEventos(linha);
    }
    
    public void validaModalDeRetornoDataInicialMenorQueFinal(String dataInicial, String dataFinal, String mensagemModalRetorno) {
        entradaDatasEPsequisa(dataInicial,dataFinal);
        modalMMTask.validarTextoModal(mensagemModalRetorno);
    }
    
    public void validaModalDeRetornoDataInicialVazia(String mensagemModalRetorno) {
        genericMMTask.clicarBotaoLimpar();
        genericMMTask.clicarBotaoPesquisar();
        modalMMTask.validarTextoModal(mensagemModalRetorno);
    }
    
    public void validaModalDeRetornoDataFinalVazia(String dataInicial, String mensagemModalRetorno) {
        genericMMTask.clicarBotaoLimpar();
        resumoEventoPage.obterInputDataInicial().definirPropriedade("value", dataInicial);
        genericMMTask.clicarBotaoPesquisar();
        modalMMTask.validarTextoModal(mensagemModalRetorno);
    }
    
    private void entradaDatasEPsequisa(String dataInicial, String dataFinal) {
        resumoEventoPage.obterInputDataInicial().definirPropriedade("value", dataInicial);
        resumoEventoPage.obterInputDataFinal().definirPropriedade("value", dataInicial);
        genericMMTask.clicarBotaoPesquisar();
    }

}
