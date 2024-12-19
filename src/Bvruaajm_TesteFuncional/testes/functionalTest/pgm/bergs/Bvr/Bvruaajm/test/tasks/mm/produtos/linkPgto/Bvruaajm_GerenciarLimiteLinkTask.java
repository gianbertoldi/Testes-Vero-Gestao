package bergs.Bvr.Bvruaajm.test.tasks.mm.produtos.linkPgto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.remote.RemoteWebDriver;

import bergs.Bvr.Bvruaajm.test.pages.mm.genericMM.Bvruaajm_GenericMMPage;
import bergs.Bvr.Bvruaajm.test.pages.mm.produtos.linkPgto.Bvruaajm_GerenciaLimiteLinkPage;
import bergs.Bvr.Bvruaajm.test.tasks.mm.genericMM.Bvruaajm_ModaMMTask;
import bergs.Bvr.Bvruaajm.test.validations.mm.Bvruaajm_GenericMMValidations;
import bergs.Bvr.Bvruaajm.test.validations.mm.Bvruaajm_GerenciarLimiteLinkValidation;
import bergs.bmo.bmouaajm.suporte.tasks.Bmouaajm_TaskBase;
import bergs.bmo.bmouaajm.suporte.util.Bmouaajm_Javascript;

public class Bvruaajm_GerenciarLimiteLinkTask extends Bmouaajm_TaskBase{

    Bvruaajm_GerenciaLimiteLinkPage gerenciaLimitePage;
    Bvruaajm_GenericMMValidations genericValidation;
    Bvruaajm_GerenciarLimiteLinkValidation limiteLinkValidation;
    Bvruaajm_GenericMMPage genericPage;
    Bmouaajm_Javascript jsExecutor;
    Bvruaajm_ModaMMTask modalTask;
    String sucessoAlteracao = "Alteração realizada com sucesso!";
    
    public Bvruaajm_GerenciarLimiteLinkTask(RemoteWebDriver driver) {
        super(driver);
        gerenciaLimitePage = new Bvruaajm_GerenciaLimiteLinkPage(driver);
        genericValidation = new Bvruaajm_GenericMMValidations(driver);
        limiteLinkValidation = new Bvruaajm_GerenciarLimiteLinkValidation(driver);
        genericPage = new Bvruaajm_GenericMMPage(driver);
        jsExecutor = new Bmouaajm_Javascript(driver);
        modalTask = new Bvruaajm_ModaMMTask(driver);
    }

    public void validaLimiteLinkCadastrado(String obterCnpjZerosAEsquerda) {
        efetuaConsultaCpfCnpjEc(obterCnpjZerosAEsquerda);
        limiteLinkValidation.verificaPresencaTabelaELinhasAlteracaoNaPagina(gerenciaLimitePage.obterTabelaHistoricoAlteracao(), gerenciaLimitePage.obterLinhasTabela().size() - 1);
    }

    public void validaRetornoCpfCnpjSemCadastroLinkPgto(String obterCpfCnpjFormatado, String registroNaoEncontrado) {
        efetuaConsultaCpfCnpjEc(obterCpfCnpjFormatado);
        modalTask.validarTextoModal(registroNaoEncontrado);
        modalTask.clicarBotaoOk();
    }
    
    public void validaEcSemHistoricoAlteracao(String obterCpfCnpjFormatado) {
        efetuaConsultaCpfCnpjEc(obterCpfCnpjFormatado);
        limiteLinkValidation.verificaSeTabelaEstaInvisivel(gerenciaLimitePage.obterTabelaHistoricoAlteracao());
    }
    
    public void validaEdicaoValorLimite(String obterCpfCnpjFormatado, String valor) {
        efetuaConsultaCpfCnpjEc(obterCpfCnpjFormatado);
        gerenciaLimitePage.obterBotaoEditar().clicar();
        gerenciaLimitePage.obterInputValorMaxCriacaoLink().limpar().preencherLento(valor);
        gerenciaLimitePage.obterBotaoSalvarAlteracao().clicar();
        modalTask.validarTextoModal(sucessoAlteracao);
        modalTask.clicarBotaoOk();
        LocalDateTime data = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        limiteLinkValidation.validaColunaValorMaxEDataHora(gerenciaLimitePage.obterColunasPrimeiraLinhaTabela(), valor, data.format(formatter));
    }
    
    private void efetuaConsultaCpfCnpjEc(String obterCpfCnpjFormatado) {
        gerenciaLimitePage.obterInputCpfCnpjEc().preencherLento(obterCpfCnpjFormatado);
        gerenciaLimitePage.obterBotaoConsultar().clicar();
    }

    public void validaRetornoEditarValor(String obterCpfCnpjFormatado, String valor, String mensagemDaModal) {
        efetuaConsultaCpfCnpjEc(obterCpfCnpjFormatado);
        gerenciaLimitePage.obterBotaoEditar().clicar();
        gerenciaLimitePage.obterInputValorMaxCriacaoLink().limpar().preencherLento(valor);
        gerenciaLimitePage.obterBotaoSalvarAlteracao().clicar();
        modalTask.validarTextoModal(mensagemDaModal);
        modalTask.clicarBotaoOk();
    }

    public void validaRetornoCnpjCpfInvalido(String obterCpfCnpjFormatado, String retornoCpfCnpjInvalido) {
        gerenciaLimitePage.obterInputCpfCnpjEc().preencherLento(obterCpfCnpjFormatado);
        jsExecutor.executeScript("document.querySelector(':focus').blur()", "");
        genericValidation.validarTextosEsperadoEAtual(retornoCpfCnpjInvalido, genericPage.obterMensagemErroCpfCnpjEc().obterTexto());       
    }    
}
