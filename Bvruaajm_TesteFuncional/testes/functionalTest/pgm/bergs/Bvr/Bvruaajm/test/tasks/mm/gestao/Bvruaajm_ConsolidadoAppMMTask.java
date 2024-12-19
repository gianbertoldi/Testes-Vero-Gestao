package bergs.Bvr.Bvruaajm.test.tasks.mm.gestao;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import bergs.Bvr.Bvruaajm.test.pages.mm.genericMM.Bvruaajm_GenericMMPage;
import bergs.Bvr.Bvruaajm.test.pages.mm.gestao.Bvruaajm_ConsolidadoAppMMPage;
import bergs.Bvr.Bvruaajm.test.tasks.mm.genericMM.Bvruaajm_GenericMMTask;
import bergs.Bvr.Bvruaajm.test.tasks.mm.genericMM.Bvruaajm_ModaMMTask;
import bergs.Bvr.Bvruaajm.test.validations.mm.Bvruaajm_GenericMMValidations;
import bergs.bmo.bmouaajm.suporte.tasks.Bmouaajm_TaskBase;

public class Bvruaajm_ConsolidadoAppMMTask extends Bmouaajm_TaskBase{

    Bvruaajm_GenericMMTask genericMMTask;
    Bvruaajm_GenericMMPage genericMMPage;
    Bvruaajm_ConsolidadoAppMMPage consolidadoAppMMPage;
    Bvruaajm_GenericMMValidations genericMMAValidation;
    Bvruaajm_ModaMMTask modalTask;
    String data = "01/07/2024";
     
    public Bvruaajm_ConsolidadoAppMMTask(RemoteWebDriver driver) {
        super(driver);
        consolidadoAppMMPage = new Bvruaajm_ConsolidadoAppMMPage(driver);
        genericMMTask = new Bvruaajm_GenericMMTask(driver);
        genericMMPage = new Bvruaajm_GenericMMPage(driver);
        genericMMAValidation = new Bvruaajm_GenericMMValidations(driver);
        modalTask = new Bvruaajm_ModaMMTask(driver);
    }
    
    public void validaConsultaListaConsolidadoPorMesAnoTask(String EstabelecimentoDistinto, String usuariosDistinto, String totalAcessos) {
        consolidadoAppMMPage.obterRadioMesAno().clicar();
        new Select(consolidadoAppMMPage.obterSelecaoMesAno().getWrappedElement()).selectByVisibleText("07/2024");
        genericMMTask.clicarBotaoPesquisar();
        genericMMAValidation.validarTextosEsperadoEAtual(EstabelecimentoDistinto , consolidadoAppMMPage.obterTotalEstabelecimentosDistintos().obterTexto());
        genericMMAValidation.validarTextosEsperadoEAtual(usuariosDistinto , consolidadoAppMMPage.obterTotalUsuariosDistintos().obterTexto());
        genericMMAValidation.validarTextosEsperadoEAtual(totalAcessos , consolidadoAppMMPage.obterTotalAcessos().obterTexto());
    }
    
    public void validaConsultaListaConsolidadoPorDataTask(String EstabelecimentoDistinto, String usuariosDistinto, String totalAcessos) {
        new Select(consolidadoAppMMPage.obterSelecaoMesAno().getWrappedElement()).selectByVisibleText("07/2024");
        consolidadoAppMMPage.obterRadioData().clicar(); 
        consolidadoAppMMPage.obterInputData().definirPropriedade("value", data);
        genericMMTask.clicarBotaoPesquisar();
        genericMMAValidation.validarTextosEsperadoEAtual(EstabelecimentoDistinto , consolidadoAppMMPage.obterTotalEstabelecimentosDistintos().obterTexto());
        genericMMAValidation.validarTextosEsperadoEAtual(usuariosDistinto , consolidadoAppMMPage.obterTotalUsuariosDistintos().obterTexto());
        genericMMAValidation.validarTextosEsperadoEAtual(totalAcessos , consolidadoAppMMPage.obterTotalAcessos().obterTexto());
    }
    
    public void validaConsultaListaConsolidadoModalMesAnosNaoInfomadoTask(String mesAnoNaoInfomado) {
        consolidadoAppMMPage.obterRadioMesAno().clicar();
        genericMMTask.clicarBotaoPesquisar();
        modalTask.validarTextoModal(mesAnoNaoInfomado);
    }
    
    public void validaConsultaListaConsolidadoModalDataNaoInfomadoTask(String mesAnoNaoInfomado) {
        consolidadoAppMMPage.obterRadioMesAno().clicar();
        new Select(consolidadoAppMMPage.obterSelecaoMesAno().getWrappedElement()).selectByVisibleText("07/2024");
        consolidadoAppMMPage.obterRadioData().clicar();
        genericMMTask.clicarBotaoPesquisar();
        modalTask.validarTextoModal(mesAnoNaoInfomado);
    }
}
