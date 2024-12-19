package bergs.Bvr.Bvruaajm.test.tasks.mm.produtos.linkPgto;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import bergs.Bvr.Bvruaajm.test.pages.mm.genericMM.Bvruaajm_GenericMMPage;
import bergs.Bvr.Bvruaajm.test.pages.mm.produtos.linkPgto.Bvruaajm_DadosCriacaoLinkPgtoPage;
import bergs.Bvr.Bvruaajm.test.tasks.mm.genericMM.Bvruaajm_ModaMMTask;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;
import bergs.Bvr.Bvruaajm.test.validations.mm.Bvruaajm_GenericMMValidations;
import bergs.bmo.bmouaajm.suporte.tasks.Bmouaajm_TaskBase;
import bergs.bmo.bmouaajm.suporte.util.Bmouaajm_Javascript;

public class Bvruaajm_DadosCricaoLinkPagamentoTask extends Bmouaajm_TaskBase{

    Bvruaajm_DadosCriacaoLinkPgtoPage criacaoLinkPage;
    Bvruaajm_GenericMMValidations genericValidation;
    Bvruaajm_GenericMMPage genericPage;
    Bmouaajm_Javascript jsExecutor;
    Bvruaajm_ModaMMTask modalTask;
    String mesDe = "Janeiro";
    String mesAte = "Julho";
    String anoDeAte = "2024";
    
    public Bvruaajm_DadosCricaoLinkPagamentoTask(RemoteWebDriver driver) {
        super(driver);
        criacaoLinkPage = new Bvruaajm_DadosCriacaoLinkPgtoPage(driver);
        genericValidation = new Bvruaajm_GenericMMValidations(driver);
        genericPage = new Bvruaajm_GenericMMPage(driver);
        jsExecutor = new Bmouaajm_Javascript(driver);
        modalTask = new Bvruaajm_ModaMMTask(driver);
    }

    public void efetuarPesquisaApenasComDataCriacaoLink(String dataPesquisa) {
        String nroLinkRegistro = "10";
        String valorTotalLinks = "264,72";
        criacaoLinkPage.obterCampoDataCriacao().definirPropriedade("value", dataPesquisa);
        clicarPesquisarValidarQtddRegistroEValores(nroLinkRegistro, valorTotalLinks);
    }

    public void efetuarPesquisaComCnpjEData(String dataPesquisa, Bvruaajm_Estabelecimento estabCnpjValido) {
        String nroLinkRegistro = "10";
        String valorTotalLinks = "264,72";
        criacaoLinkPage.obterInputTextCpfCnpjEc().preencherLento(estabCnpjValido.obterCnpjZerosAEsquerda());
        criacaoLinkPage.obterCampoDataCriacao().definirPropriedade("value", dataPesquisa);
        clicarPesquisarValidarQtddRegistroEValores(nroLinkRegistro, valorTotalLinks);
    }
    
    public void efetuarPesquisaComCpfUserEdata(String dataPesquisa, Bvruaajm_CartaoAcesso cpfUser) {
        String nroLinkRegistro = "9";
        String valorTotalLinks = "250,00";
        criacaoLinkPage.obterInputTextCpfUserApp().preencherLento(String.valueOf(cpfUser.obterCpf()));
        criacaoLinkPage.obterCampoDataCriacao().definirPropriedade("value", dataPesquisa);
        clicarPesquisarValidarQtddRegistroEValores(nroLinkRegistro, valorTotalLinks);
    }

    public void efetuarPesquisaComCpfDataStatus(String dataPesquisa, Bvruaajm_CartaoAcesso cpfValido, Bvruaajm_Estabelecimento estabCnpjValido,
            String status, String nroLinkRegistro, String valorTotalLinks) {
        criacaoLinkPage.obterInputTextCpfCnpjEc().preencherLento(estabCnpjValido.obterCnpjZerosAEsquerda());
        criacaoLinkPage.obterInputTextCpfUserApp().preencherLento(String.valueOf(cpfValido.obterCpf()));
        criacaoLinkPage.obterCampoDataCriacao().definirPropriedade("value", dataPesquisa);
        criacaoLinkPage.obterCheckStatusLinkVariado(status).clicar();
        clicarPesquisarValidarQtddRegistroEValores(nroLinkRegistro, valorTotalLinks);
    }
    
    public void efetuarPesquisaPeriodo(String nroLinkRegistro, String valorTotalLinks) {
        clicarSelecionarPeriodoPesquisa(mesDe, mesAte, anoDeAte, anoDeAte);
        clicarPesquisarValidarQtddRegistroEValores(nroLinkRegistro, valorTotalLinks);
    }
    
    public void efetuarPesquisaPeriodoStatusFormaPagamento(String nroLinkRegistro, String valorTotalLinks, String statusLink, String formaPgto) {
        clicarSelecionarPeriodoPesquisa(mesDe, mesAte, anoDeAte, anoDeAte);
        criacaoLinkPage.obterCheckStatusLinkVariado(statusLink).clicar();
        new Select(criacaoLinkPage.obterComboFormaPgto().getWrappedElement()).selectByVisibleText(formaPgto);
        clicarPesquisarValidarQtddRegistroEValores(nroLinkRegistro, valorTotalLinks);
    }
    
    public void validaCampoCpfCnpjEcInvalido(Bvruaajm_Estabelecimento estabCpfCnpjInvalido, String msgErroCnpjInvalid) {
        criacaoLinkPage.obterInputTextCpfCnpjEc().preencherLento(String.valueOf(estabCpfCnpjInvalido.obterCpfCnpj()));
        jsExecutor.executeScript("document.querySelector(':focus').blur()", "");
        genericValidation.validarTextosEsperadoEAtual(msgErroCnpjInvalid, genericPage.obterMensagemErroCpfCnpjEc().obterTexto());
    }
    
    public void validaCampoCpfUserInvalido(Bvruaajm_CartaoAcesso cpfInvalido, String retornoCpfInvalido) {
        criacaoLinkPage.obterInputTextCpfUserApp().preencherLento(String.valueOf(cpfInvalido.obterCpf()));
        jsExecutor.executeScript("document.querySelector(':focus').blur()", "");
        genericValidation.validarTextosEsperadoEAtual(retornoCpfInvalido, genericPage.obterMensagemErroCpf().obterTexto());
    }
    
    public void validaPesquisasComModalRetorno(Bvruaajm_Estabelecimento estabSemLink, String mesInicio, String mesFim, String anoInicio, String anoFim,
            String msgRetorno) {
        criacaoLinkPage.obterInputTextCpfCnpjEc().preencherLento(String.valueOf(estabSemLink.obterCpfCnpj()));
        clicarSelecionarPeriodoPesquisa(mesInicio, mesFim, anoInicio, anoFim);
        clicaPesquisarValidaTextoModalInfra(msgRetorno);
    }
    
    private void clicaPesquisarValidaTextoModalInfra(String msgRetorno) {
        criacaoLinkPage.obterBotaoPesquisar().clicar();
        modalTask.validarTextoModal(msgRetorno);
    }
    
    private void clicarSelecionarPeriodoPesquisa(String mesInicio, String mesFim, String anoInicio, String anoFim) {
        criacaoLinkPage.obterRadioPeriodoMes().clicar();
        try {
            new Select(criacaoLinkPage.obterComboMesInicio().getWrappedElement()).selectByVisibleText(mesInicio);
        }catch (NoSuchElementException e) {
            jsExecutor.executeScript("document.querySelector(':focus').blur()", "");
        }
        try {
            new Select(criacaoLinkPage.obterComboAnoInicio().getWrappedElement()).selectByVisibleText(anoInicio);
        }catch (NoSuchElementException e) {
            jsExecutor.executeScript("document.querySelector(':focus').blur()", "");
        }
        try {
            new Select(criacaoLinkPage.obterComboMesFim().getWrappedElement()).selectByVisibleText(mesFim);
        }catch (NoSuchElementException e) {
            jsExecutor.executeScript("document.querySelector(':focus').blur()", "");
        }
        try {
            new Select(criacaoLinkPage.obterComboAnoFim().getWrappedElement()).selectByVisibleText(anoFim);
        }catch (NoSuchElementException e) {
            jsExecutor.executeScript("document.querySelector(':focus').blur()", "");
        }
    }
    
    private void clicarPesquisarValidarQtddRegistroEValores(String nroLink, String valorTotalLinks) {
        criacaoLinkPage.obterBotaoPesquisar().clicar();
        genericValidation.validarTextosEsperadoEAtual(nroLink + " links", criacaoLinkPage.obterTextTotalLinks().obterTexto());
        genericValidation.validarTextosEsperadoEAtual("R$ " + valorTotalLinks, criacaoLinkPage.obterTextTotalValor().obterTexto());
        genericValidation.validarTextosEsperadoEAtual("Total de " + nroLink + " registros", genericPage.obterTextoQuantidadeRegistro().obterTexto());
    }

    
}
