package bergs.Bvr.Bvruaajm.test.tests.home;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.home.Bvruaajm_NotificacoesTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBvr;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;

public class Bvruaajm_NotificacaoTelaCheiaTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_NotificacoesTask notificaTask;
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_SqlBvr sqlBvr;
    String codMsg = "12780";
    

    @BeforeEach
    public void preparaTest() {
        notificaTask = new Bvruaajm_NotificacoesTask(driver);
        genericTask = new Bvruaajm_GenericTask(driver);
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime dataCriacao = LocalDateTime.now();
        LocalDateTime dataExpirada = LocalDateTime.now().plusDays(3);
        sqlBvr.deletarNotificaDaTabelaControleMensagem(codMsg);
        sqlBvr.atualizarNotificacaoTelaCheiaComImagem(dataExpirada, dataCriacao, codMsg);
        taskMobile.definirContextoWebview();
        genericTask.prepararTesteLogado(cartaoAcesso);
    }

    @AfterEach
    public void finalizarTest() {
        sqlBvr = new Bvruaajm_SqlBvr();
        sqlBvr.deletarNotificaDaTabelaControleMensagem(codMsg);
        LocalDateTime dataCriacao = LocalDateTime.now().minusDays(4);
        LocalDateTime dataExpirada = LocalDateTime.now().minusDays(2);
        sqlBvr.atualizarNotificacaoTelaCheiaComImagem(dataCriacao, dataExpirada, codMsg);
    }

    @Tag("home")
    @Test
    @DisplayName("Teste para validar a notificação de tela cheia com imagem")
    public void validaNotificacaoTelaCheia() {
        notificaTask.validaModalTelaCheiaNaHome();
    }

}
