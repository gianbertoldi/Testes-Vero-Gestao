package bergs.Bvr.Bvruaajm.test.tests.perfil.ajustes;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.perfil.Bvruaajm_PerfilTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_FakeGenerator;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBvr;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;

public class Bvruaajm_VerificaCadastroEmailTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_SqlBvr sql;
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_PerfilTask perfilTask;
    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.Pannuvia.obterCartaoAcesso();
    String preencherEmail = Bvruaajm_FakeGenerator.obterEmail();

    @BeforeEach
    public void iniciaTest() {
        genericTask = new Bvruaajm_GenericTask(driver);
        perfilTask = new Bvruaajm_PerfilTask(driver);
        genericTask.prepararTesteLogado(cartaoAcesso);
        sql = new Bvruaajm_SqlBvr();
        LocalDate dataAtualizaAntiga = LocalDate.now().minusDays(190);
        sql.atualizarDataAtualizacaoCadastro(dataAtualizaAntiga, cartaoAcesso);
        perfilTask.verificaAtualizacaoCadastroLocalStorage(cartaoAcesso);
        this.getDriver().closeApp();
        this.getDriver().launchApp();
        genericTask.prepararTesteLogado(cartaoAcesso);
    }

    @AfterEach
    public void finalizaTest() {
        sql = new Bvruaajm_SqlBvr();
        LocalDate dataAtualizaAtual = LocalDate.now();
        sql.atualizarDataAtualizacaoCadastro(dataAtualizaAtual, cartaoAcesso);
    }

    @DisplayName("Valida meia modal clicando em Sim, está atualizado o e-mail de cadastro")
    @Tag("Perfil")
    @Test
    public void validaMeiaModalEmailJaEstaCadastrado() {
        perfilTask.validaMeiaModalSimEstaAtualizado();
    }

    @DisplayName("Valida meia modal clicando em Quero Atualizar o e-mail de cadastro")
    @Tag("Perfil")
    @Test
    public void validaMeiaModalEmailQueroAtualizar() {
        perfilTask.validaMeiaModalQueroAtualizar(preencherEmail);
    }

}
