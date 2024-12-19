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

public class Bvruaajm_NotificacoesMeiaModalTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_NotificacoesTask notificaTask;
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_SqlBvr sqlBvr;
    LocalDateTime dataCriacao = LocalDateTime.now();
    LocalDateTime dataExpirada = LocalDateTime.now().plusDays(3);
    LocalDateTime dataUltimaAtualizacao = LocalDateTime.now();
    String codMsg = "9998";
    String tituloMsg = "TESTE TITULO";
    String descricaoMsg = "TESTE DESCRICAO";

    @BeforeEach
    public void preparaTest() {
        notificaTask = new Bvruaajm_NotificacoesTask(driver);
        genericTask = new Bvruaajm_GenericTask(driver);
        sqlBvr = new Bvruaajm_SqlBvr();
        sqlBvr.inserirNotificacaoNaTabelaMensagem(codMsg, tituloMsg, descricaoMsg, dataExpirada, dataCriacao, dataUltimaAtualizacao);
        
    }

    @AfterEach
    public void finalizarTest() {
        sqlBvr = new Bvruaajm_SqlBvr();
        sqlBvr.deletarNotificaDaTabelaControleMensagem(codMsg);
        sqlBvr.deletarNotificaDaTabelaMensagem(codMsg);
    }

    @Tag("home")
    @Test
    @DisplayName("Valida se meia modal de um mensagem nova abre ao acessar no apos seu envio")
    public void validaMeiaModalNotificacaoHome() {
        taskMobile.definirContextoWebview();
        genericTask.prepararTesteLogado(cartaoAcesso);
        notificaTask.validaSeMeiaModalNotificacaoAbreMesagemMaisRecenteNaHome();
    }

    @Tag("home")
    @Test
    @DisplayName("Valida se ao entrar em notificações acessar a ultima mensagem abrir ela e confirma se ela fica como lida")
    public void validaNotificacaoNaoLida() {
        sqlBvr = new Bvruaajm_SqlBvr();
        taskMobile.definirContextoWebview();
        genericTask.prepararTesteLogado(cartaoAcesso);
        notificaTask.validaSeMeiaModalNotificacaoAbreMesagemMaisRecenteNaHome();
        sqlBvr.atualizarNotificacaoControleMsgNaoLido("N", codMsg);
        notificaTask.validaMensagemNaoLida(1);
    }

}
