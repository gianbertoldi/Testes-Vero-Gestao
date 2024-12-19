package bergs.Bvr.Bvruaajm.test.tasks.mm.gestao;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import bergs.Bvr.Bvruaajm.test.pages.mm.genericMM.Bvruaajm_GenericMMPage;
import bergs.Bvr.Bvruaajm.test.pages.mm.gestao.Bvruaajm_ConsultaAcessosPage;
import bergs.Bvr.Bvruaajm.test.tasks.mm.genericMM.Bvruaajm_GenericMMTask;
import bergs.Bvr.Bvruaajm.test.validations.mm.Bvruaajm_GenericMMValidations;
import bergs.bmo.bmouaajm.suporte.tasks.Bmouaajm_TaskBase;

public class Bvruaajm_ConsultaMMAcessosTask extends Bmouaajm_TaskBase {

    Bvruaajm_GenericMMTask genericMMTask;
    Bvruaajm_GenericMMPage genericMMPage;
    Bvruaajm_ConsultaAcessosPage consultaAcessosPage;
    Bvruaajm_GenericMMValidations genericConsultaMMAValidation;
    String dataInicial = "30/07/2024";
    String dataFinal = "30/07/2024";
    String cpfUsuario = "00000000191";
    String cnpj = "00110560000107";
    String cpf = "05599636020";
    String tituloFiltros = ":: Informe os campos e pressione Pesquisar ::";
     
    public Bvruaajm_ConsultaMMAcessosTask(RemoteWebDriver driver) {
        super(driver);
        genericMMTask = new Bvruaajm_GenericMMTask(driver);
        genericMMPage = new Bvruaajm_GenericMMPage(driver);
        consultaAcessosPage = new Bvruaajm_ConsultaAcessosPage(driver);
        genericConsultaMMAValidation = new Bvruaajm_GenericMMValidations(driver);
    }
    
    private void EfueturaPesquisaDeAcessos(String numeroRegistros) {
        consultaAcessosPage.obterInputDataInicial().definirPropriedade("value", dataInicial);
        consultaAcessosPage.obterInputDataFinal().definirPropriedade("value", dataInicial);
        genericMMTask.clicarBotaoPesquisar();
        genericConsultaMMAValidation.validarTotalResultadoDaPesquisa(numeroRegistros, genericMMPage.obterTextoQuantidadeRegistro().obterTexto());
    }
    
    public void validaNumeroDeRegitroDaCosultaAcessosTipoLogistaAmbos(String numeroRegistros) {
        consultaAcessosPage.obterTipoLojistaAmbos().clicar();
        consultaAcessosPage.obterInputCpfUsuario().preencherLento(cpfUsuario);
        EfueturaPesquisaDeAcessos(numeroRegistros);
    }
    
    public void validaNumeroDeRegitroDaCosultaAcessosTipoLogistaCoveniado(String numeroRegistros) {
        consultaAcessosPage.obterTipoLojistaConveniado().clicar();
        consultaAcessosPage.obterInputCpfUsuario().preencherLento(cpfUsuario);
        EfueturaPesquisaDeAcessos(numeroRegistros);
    }
    
    public void validaNumeroDeRegitroDaCosultaAcessosTipoLogistaEstabelecimento(String numeroRegistros) {
        consultaAcessosPage.obterTipoLojistaEstabelecimento().clicar();
        consultaAcessosPage.obterInputCpfUsuario().preencherLento(cpfUsuario);
        EfueturaPesquisaDeAcessos(numeroRegistros);
    }
    
    public void validaPesquisaPorTipoDeAcesso(String numeroRegistros) {
        consultaAcessosPage.obterSelecionartFiltroEvento().clicar();
        new Select(consultaAcessosPage.obterSelecionartFiltroEvento().getWrappedElement()).selectByVisibleText("Acesso");
        EfueturaPesquisaDeAcessos(numeroRegistros);
    }   
    
    public void validaPesquisaPorTipoPessoaFisica(String numeroRegistros) {
        consultaAcessosPage.obterSelecionartFiltroEvento().clicar();
        new Select(consultaAcessosPage.obterSelecionartFiltroEvento().getWrappedElement()).selectByVisibleText("Acesso");
        consultaAcessosPage.obterTipoPessoaFisica().clicar();
        consultaAcessosPage.obterInputCpfLojista().preencherLento(cpfUsuario);
        EfueturaPesquisaDeAcessos(numeroRegistros);
    }   
    
    public void validaPesquisaPorTipoJuridica(String numeroRegistros) {
        consultaAcessosPage.obterSelecionartFiltroEvento().clicar();
        new Select(consultaAcessosPage.obterSelecionartFiltroEvento().getWrappedElement()).selectByVisibleText("Acesso");
        consultaAcessosPage.obterTipoPessoaJuridica().clicar();
        consultaAcessosPage.obterInputCnpjLojista().preencherLento(cnpj);
        EfueturaPesquisaDeAcessos(numeroRegistros);
    }   
    
    public void validaVoltarAposAPesquisa(String numeroRegistros) {
        consultaAcessosPage.obterTipoLojistaAmbos().clicar();
        consultaAcessosPage.obterInputCpfUsuario().preencherLento(cpfUsuario);
        EfueturaPesquisaDeAcessos(numeroRegistros);
        genericMMTask.clicarBotaoVoltar();
        genericConsultaMMAValidation.validarTextosEsperadoEAtual(tituloFiltros, consultaAcessosPage.obterTextoTituloPaginaFiltrosAcesso().obterTexto());
    }   

    public void validaPesquisaPorTipoJuridicaPeloUsuario(String numeroRegistros) {
        consultaAcessosPage.obterTipoPessoaJuridica().clicar();
        consultaAcessosPage.obterInputCnpjLojista().preencherLento(cnpj);
        consultaAcessosPage.obterInputCpfUsuario().preencherLento(cpfUsuario);
        EfueturaPesquisaDeAcessos(numeroRegistros);
    }   
    
    public void validaPesquisaPorTipoFisicaPeloUsuario(String numeroRegistros) {
        consultaAcessosPage.obterTipoPessoaFisica().clicar();
        consultaAcessosPage.obterInputCpfLojista().preencherLento(cpf);
        consultaAcessosPage.obterInputCpfUsuario().preencherLento(cpfUsuario);
        EfueturaPesquisaDeAcessos(numeroRegistros);
    }   
    
    public void validaPesquisaComTodosFiltrosAplicados(String numeroRegistros) {;
        consultaAcessosPage.obterSelecionartFiltroEvento().clicar();
        new Select(consultaAcessosPage.obterSelecionartFiltroEvento().getWrappedElement()).selectByVisibleText("Acesso");
        consultaAcessosPage.obterTipoLojistaConveniado().clicar();
        consultaAcessosPage.obterTipoPessoaJuridica().clicar();
        consultaAcessosPage.obterInputCnpjLojista().preencherLento(cnpj);
        consultaAcessosPage.obterInputCpfUsuario().preencherLento(cpfUsuario);
        EfueturaPesquisaDeAcessos(numeroRegistros);
    }   
}
