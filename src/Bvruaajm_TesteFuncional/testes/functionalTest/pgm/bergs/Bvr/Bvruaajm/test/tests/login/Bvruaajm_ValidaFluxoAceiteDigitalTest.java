package bergs.Bvr.Bvruaajm.test.tests.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.login.Bvruaajm_AceiteDigitalTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBdk;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBvr;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;

public class Bvruaajm_ValidaFluxoAceiteDigitalTest extends Bvruaajm_TesteBaseMobile{

    Bvruaajm_SqlBdk sqlBdk;
    Bvruaajm_SqlBvr sqlBvr;
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_AceiteDigitalTask aceiteTask;
    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.CpfAceiteDigital.obterCartaoAcesso();
    
    @BeforeEach
    public void prepara() {
        sqlBdk = new Bvruaajm_SqlBdk();
        sqlBvr = new Bvruaajm_SqlBvr();
        aceiteTask = new Bvruaajm_AceiteDigitalTask(driver);
        genericTask = new Bvruaajm_GenericTask(driver);
        taskMobile.definirContextoWebview();
        this.getDriver().resetApp();
        sqlBdk.atualizaPropostaCpfCnpjBdk(String.valueOf(cartaoAcesso.obterCpf()));
        sqlBvr.atualizaTipoPerfilAcessoLojistaParaAceiteDigitalPorCpf(String.valueOf(cartaoAcesso.obterCpf()));
        genericTask.prepararTesteLogado(cartaoAcesso);
    }
    
    @DisplayName("Efetuar aceite digital e faz validação")
    @Tag("Login")
    @Test
    public void validaFluxoAceiteDigital() {
        aceiteTask.efetuarFluxoAceiteDigital();
    }
}
