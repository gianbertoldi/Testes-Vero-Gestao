package bergs.Bvr.Bvruaajm.test.validations.perfil;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.generic.Bvruaajm_GenericPage;
import bergs.Bvr.Bvruaajm.test.pages.perfil.Bvruaajm_GerenciarUsuarioPage;
import bergs.Bvr.Bvruaajm.test.pages.perfil.Bvruaajm_PerfilPage;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_PerfilValidation {

    Bvruaajm_PerfilPage perfilPage;
    Bvruaajm_GenericPage genericPage;
    Bvruaajm_GerenciarUsuarioPage gerenciarUsuarioPage;
    public static final String COD_BANCO = "041";
    public static final String ISPB = "92702067";
    public static final String PRE_PAGO = "Pré-Pago";
    public static final String NOME = "Pannuvia";
    public static final String EMAIL = "teste@teste.com";
    public static final String TELEFONE = "(51) 99999-9999";
    public static final String ERRO_NOME = "O nome precisa ter, pelo menos, 2 caracteres";
    public static final String ERRO_TELEFONE = "Insira um celular válido";
    public static final String ERRO_EMAIL = "Insira um e-mail válido";    
    public static final String DESCRICAO_PUSH = "No momento, enviamos apenas notificações de vendas realizadas via Link de Pagamento";
    public static final String CELULAR_PUSH = "No celular (push)";
    public static final String EMAIL_PUSH = "Via e-mail";
    public static final String TENHO_MAQUININHA = "Tenho Maquininha Vero";
    
    public Bvruaajm_PerfilValidation(AppiumDriver<WebElement> driver) {
        perfilPage = new Bvruaajm_PerfilPage(driver);
        genericPage = new Bvruaajm_GenericPage(driver);
        gerenciarUsuarioPage = new Bvruaajm_GerenciarUsuarioPage(driver);
    }

    public void validaVisibilidadeMeiaModalAtualizaEmail() {
        Assertions.assertTrue(perfilPage.obterMeiaModalSeuEmailEstaAtualizado().estaVisivel());
    }

    public void validarDomicioBancarioMeusNegocios() {
        assertAll(
                () -> assertEquals(COD_BANCO, perfilPage.obterCampoBancoPrimeiroCartao().obterTexto(), "Codigo banco esta diferente."),
                () -> assertEquals(ISPB, perfilPage.obterCampoISPBPrimeiroCartao().obterTexto(), "ISPB esta diferente."),
                () -> assertEquals(4, perfilPage.obterCampoAgenciaPrimeiroCartao().obterTexto().length(), "Tamanho do campo esta diferente."));
    }

    public void validarDomicioBancarioMeusNegociosContaPrePago() {
        assertAll(
                () -> assertEquals(COD_BANCO, perfilPage.obterCampoBancoPrimeiroCartao().obterTexto(), "Codigo banco esta diferente."),
                () -> assertEquals(ISPB, perfilPage.obterCampoISPBPrimeiroCartao().obterTexto(), "ISPB esta diferente."),
                () -> assertEquals("-", perfilPage.obterCampoAgenciaPrimeiroCartao().obterTexto(), "Campo agencia deveria estar vazio '-'"),
                () -> assertEquals(PRE_PAGO, perfilPage.obterCampoContaPrimeiroCartao().obterTexto(), "Campo conta esta diferente"));
    }

    public void validarDadosPerfilEstaComoEsperado() {
        assertAll(
                () -> assertEquals(NOME, perfilPage.obterNomePerfil().obterTexto(), "Nome esta Diferente"),
                () -> assertEquals(EMAIL, perfilPage.obterEmailPerfil().obterTexto(), "E-mail esta Diferente"),
                () -> assertEquals(TELEFONE, perfilPage.obterCelularPerfil().obterTexto(), "Celular esta Diferente"),
                () -> assertEquals("Administrador", perfilPage.obterTipoPerfil().obterTexto(), "Tipo perfil esta Diferente"));
    }

    public void validarCamposMeusDadosMensagensErro() {
        assertAll(
                () -> assertEquals(ERRO_NOME, perfilPage.obterMsgErroNome().obterTexto(), "Nome esta Diferente"),
                () -> assertEquals(ERRO_TELEFONE, perfilPage.obterMsgErroCelular().obterTexto(), "Celular esta Diferente"),
                () -> assertEquals(ERRO_EMAIL, perfilPage.obterMsgErroEmail().obterTexto(), "E-mail esta Diferente"));
    }
    
    public void validarTextosOpcoesNotificacao() {
        String tituloPush = "Notificações de vendas";
        assertAll(
                () -> assertEquals(tituloPush, perfilPage.obterTxtTituloPush().obterTexto(), "Titulo esta Diferente"),
                () -> assertEquals(DESCRICAO_PUSH, perfilPage.obterTxtDescricaoPush().obterTexto(), "Descricao esta Diferente"),
                () -> assertEquals(CELULAR_PUSH, perfilPage.obterTxtCelularPush().obterTexto(), "Texto do celular esta Diferente"),
                () -> assertEquals(EMAIL_PUSH, perfilPage.obterTxtEmailPush().obterTexto(), "Texto do e-mail esta Diferente"));
    }
    
    public void validaMeusDadosCpfDesabilitado() {
        Assertions.assertFalse(perfilPage.obterCampoCpfMeusDados().estaHabilitado());
    }
    
    public void validarCardsFaleConosco() {
        Assertions.assertEquals(TENHO_MAQUININHA, genericPage.obterTituloTenhoMaquininha().obterTexto());
    }
    
    public boolean validarDadosUsuarioSalvos() {
        if (gerenciarUsuarioPage.obterInputNome().obterAtributo("Disabled") != null){
            return true;
        } else {
            return false;
        }
    }

}
