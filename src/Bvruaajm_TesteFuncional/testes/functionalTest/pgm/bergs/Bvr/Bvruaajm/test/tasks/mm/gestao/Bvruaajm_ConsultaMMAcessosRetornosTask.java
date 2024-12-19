package bergs.Bvr.Bvruaajm.test.tasks.mm.gestao;

import org.openqa.selenium.remote.RemoteWebDriver;

import bergs.Bvr.Bvruaajm.test.pages.mm.genericMM.Bvruaajm_GenericMMPage;
import bergs.Bvr.Bvruaajm.test.pages.mm.gestao.Bvruaajm_ConsultaAcessosPage;
import bergs.Bvr.Bvruaajm.test.tasks.mm.genericMM.Bvruaajm_GenericMMTask;
import bergs.Bvr.Bvruaajm.test.tasks.mm.genericMM.Bvruaajm_ModaMMTask;
import bergs.Bvr.Bvruaajm.test.validations.mm.Bvruaajm_GenericMMValidations;
import bergs.bmo.bmouaajm.suporte.tasks.Bmouaajm_TaskBase;

public class Bvruaajm_ConsultaMMAcessosRetornosTask extends Bmouaajm_TaskBase {
    
    Bvruaajm_GenericMMTask genericMMTask;
    Bvruaajm_GenericMMPage genericMMPage;
    Bvruaajm_ConsultaAcessosPage consultaAcessosPage;
    Bvruaajm_GenericMMValidations genericConsultaMMAValidation;
    Bvruaajm_ModaMMTask modalTask;
    String dataInicial = "30/07/2024";
    String dataFinal = "30/07/2024";
    
    public Bvruaajm_ConsultaMMAcessosRetornosTask(RemoteWebDriver driver) {
        super(driver);
        genericMMTask = new Bvruaajm_GenericMMTask(driver);
        genericMMPage = new Bvruaajm_GenericMMPage(driver);
        consultaAcessosPage = new Bvruaajm_ConsultaAcessosPage(driver);
        genericConsultaMMAValidation = new Bvruaajm_GenericMMValidations(driver);
        modalTask = new Bvruaajm_ModaMMTask(driver);
    }

    public void validaModalSemDataInicialSelecionada(String cpf, String textoModalSemDataInicial) {
        consultaAcessosPage.obterInputCpfUsuario().preencherLento(cpf);
        genericMMTask.clicarBotaoPesquisar();
        modalTask.validarTextoModal(textoModalSemDataInicial);
        modalTask.clicarBotaoOk();
    }
    
    public void validaModalSemFitroSelecionado(String textoModalSemFiltro) {
        consultaAcessosPage.obterInputDataInicial().definirPropriedade("value", dataInicial);
        consultaAcessosPage.obterInputDataFinal().definirPropriedade("value", dataInicial);
        genericMMTask.clicarBotaoPesquisar();
        modalTask.validarTextoModal(textoModalSemFiltro);
        modalTask.clicarBotaoOk();
    }
    
    public void validaModalSemDataFinalSelecionada(String cpf, String textoModalSemDataFinal) {
        consultaAcessosPage.obterInputCpfUsuario().preencherLento(cpf);
        consultaAcessosPage.obterInputDataInicial().definirPropriedade("value", dataInicial);
        genericMMTask.clicarBotaoPesquisar();
        modalTask.validarTextoModal(textoModalSemDataFinal);
        modalTask.clicarBotaoOk();
    }

    public void validaRetornoCpfUsuariosInvalido(String cpf, String cpfinvalido) {
        consultaAcessosPage.obterInputCpfUsuario().preencherLento(cpf);
        consultaAcessosPage.obterTipoLojistaAmbos().clicar();
        genericConsultaMMAValidation.validarTextosEsperadoEAtual(cpfinvalido, genericMMPage.obterMensagemErroCpf().obterTexto());
    }

    public void validaRetornoCnpjTipoPessoaInvalido(String Cnpj, String cnpjInvalido) {
        consultaAcessosPage.obterTipoPessoaJuridica().clicar();
        consultaAcessosPage.obterInputCnpjLojista().preencherLento(Cnpj);
        consultaAcessosPage.obterTipoLojistaAmbos().clicar();
        genericConsultaMMAValidation.validarTextosEsperadoEAtual(cnpjInvalido, genericMMPage.obterMensagemErroCnpj().obterTexto());
    }

    public void validaRetornoCpfTipoPessoaInvalido(String cpf, String retornoCpfInvalido) {
        consultaAcessosPage.obterTipoPessoaFisica().clicar();
        consultaAcessosPage.obterInputCpfLojista().preencherLento(cpf);
        consultaAcessosPage.obterTipoLojistaAmbos().clicar();
        genericConsultaMMAValidation.validarTextosEsperadoEAtual(retornoCpfInvalido, genericMMPage.obterMensagemErroCpf().obterTexto());
    }
}
