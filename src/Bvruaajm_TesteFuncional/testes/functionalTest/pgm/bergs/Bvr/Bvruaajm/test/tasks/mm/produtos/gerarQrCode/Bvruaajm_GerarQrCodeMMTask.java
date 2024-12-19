package bergs.Bvr.Bvruaajm.test.tasks.mm.produtos.gerarQrCode;

import org.openqa.selenium.remote.RemoteWebDriver;

import bergs.Bvr.Bvruaajm.test.pages.mm.genericMM.Bvruaajm_GenericMMPage;
import bergs.Bvr.Bvruaajm.test.pages.mm.produtos.gerarQrCode.Bvruaajm_GerarQrCodeMMPage;
import bergs.Bvr.Bvruaajm.test.tasks.mm.genericMM.Bvruaajm_GenericMMTask;
import bergs.Bvr.Bvruaajm.test.tasks.mm.genericMM.Bvruaajm_ModaMMTask;
import bergs.Bvr.Bvruaajm.test.validations.mm.Bvruaajm_GenericMMValidations;
import bergs.bmo.bmouaajm.suporte.tasks.Bmouaajm_TaskBase;
import bergs.bmo.bmouaajm.suporte.util.Bmouaajm_Javascript;

public class Bvruaajm_GerarQrCodeMMTask extends Bmouaajm_TaskBase {

    Bvruaajm_GerarQrCodeMMPage geraQrCodeMMPage;
    Bvruaajm_GenericMMTask genericMMTask;
    Bvruaajm_GenericMMValidations genericMMValidation;
    Bvruaajm_GenericMMPage genericMMPage;
    Bvruaajm_ModaMMTask modalMMTask;
    Bmouaajm_Javascript jsExecutor;
    String imagemQrCode = "/bvr/data/bvr";

    public Bvruaajm_GerarQrCodeMMTask(RemoteWebDriver driver) {
        super(driver);
        geraQrCodeMMPage = new Bvruaajm_GerarQrCodeMMPage(driver);
        genericMMTask = new Bvruaajm_GenericMMTask(driver);
        genericMMValidation = new Bvruaajm_GenericMMValidations(driver);
        genericMMPage = new Bvruaajm_GenericMMPage(driver);
        modalMMTask = new Bvruaajm_ModaMMTask(driver);
        jsExecutor = new Bmouaajm_Javascript(driver);
    }

    public void validaGerarQrCodePessoaFisicaVeroWallet(String obterCpf) {
        geraQrCodeMMPage.obterPessoaFisica().clicar();
        geraQrCodeMMPage.obterInputPessoaFisica().preencherLento(obterCpf);
        genericMMTask.clicarBotaoPesquisar();
        genericMMValidation.validaImagemEstaNaTela(geraQrCodeMMPage.obterImagemQrCode(), imagemQrCode);
    }

    public void validaGerarQrCodePessoaJuridicaVeroWallet(String obterCnpj) {
        geraQrCodeMMPage.obterPessoaJuridica().clicar();
        geraQrCodeMMPage.obterInputPessoaJuridica().preencherLento(obterCnpj);
        genericMMTask.clicarBotaoPesquisar();
        genericMMValidation.validaImagemEstaNaTela(geraQrCodeMMPage.obterImagemQrCode(), imagemQrCode);
    }
    
    public void validaGerarQrCodePessoaJuridicaVeroX(String obterCnpj) {
        geraQrCodeMMPage.obterPessoaJuridica().clicar();
        geraQrCodeMMPage.obterInputPessoaJuridica().preencherLento(obterCnpj);
        genericMMTask.clicarBotaoPesquisar();
        geraQrCodeMMPage.obterVeroX().clicar();
        genericMMValidation.validaImagemEstaNaTela(geraQrCodeMMPage.obterImagemQrCode(), imagemQrCode);
    }

    public void validaGerarQrCodePessoaFisicaRetornoSemVeroX(String obterCpf, String modalSemVeroX) {
        geraQrCodeMMPage.obterPessoaFisica().clicar();
        geraQrCodeMMPage.obterInputPessoaFisica().preencherLento(obterCpf);
        genericMMTask.clicarBotaoPesquisar();
        geraQrCodeMMPage.obterVeroX().clicar();
        modalMMTask.validarTextoModal(modalSemVeroX);
    }

    public void validaCnpjDeQrCodeDesabilitado(String obterCnpj, String mensagemModalQrCodeDesabilitado) {
        geraQrCodeMMPage.obterPessoaJuridica().clicar();
        geraQrCodeMMPage.obterInputPessoaJuridica().preencherLento(obterCnpj);
        genericMMTask.clicarBotaoPesquisar();
        modalMMTask.validarTextoModal(mensagemModalQrCodeDesabilitado);
    }

    public void validaCnpjInvalido(String obterCnpj, String retornoCnpjInvalido) {
        geraQrCodeMMPage.obterPessoaJuridica().clicar();
        geraQrCodeMMPage.obterInputPessoaJuridica().preencherLento(obterCnpj);
        jsExecutor.executeScript("document.querySelector(':focus').blur()", "");
        genericMMValidation.validarTextosEsperadoEAtual(retornoCnpjInvalido, genericMMPage.obterMensagemErroCnpj().obterTexto());
    }
    
    public void validaCpfInvalido(String obterCpf, String retornoCpfInvalido) {
        geraQrCodeMMPage.obterPessoaFisica().clicar();
        geraQrCodeMMPage.obterInputPessoaFisica().preencherLento(obterCpf);
        jsExecutor.executeScript("document.querySelector(':focus').blur()", "");
        genericMMValidation.validarTextosEsperadoEAtual(retornoCpfInvalido, genericMMPage.obterMensagemErroCpf().obterTexto());
    }

    public void validaModalTipoPessoaVazio(String mensagemModalTipoPessoaVazio) {
        genericMMTask.clicarBotaoPesquisar();
        modalMMTask.validarTextoModal(mensagemModalTipoPessoaVazio);
    }
}
