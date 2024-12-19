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

/**
 * ID_8910 - Ajuste na inclusão do e-mail no app
 * 
 * @author B41722
 *
 */
public class Bvruaajm_VerificEmailNaoCadastradoTest extends Bvruaajm_TesteBaseMobile {

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
        sql.atualizarEmailUsuarioParaNull(dataAtualizaAntiga, cartaoAcesso);
        perfilTask.verificaAtualizacaoCadastroLocalStorage(cartaoAcesso);
        this.getDriver().closeApp();
        this.getDriver().launchApp();
        genericTask.prepararTesteLogado(cartaoAcesso);

    }

    @AfterEach
    public void finalizaTest() {
        sql = new Bvruaajm_SqlBvr();
        LocalDate dataAtualizaAtual = LocalDate.now();
        sql.atualizarEmailUsuarioEmailGenerico(dataAtualizaAtual, cartaoAcesso);
    }

    @DisplayName("Valida meia modal E-mail não cadastrado e clicar em Não cadastrar agora")
    @Tag("Perfil")
    @Test
    public void validaMeiaModalEmailNaoCadastradoClicandoBotaoAgoraNao() {
        perfilTask.validaMeiaModalBotaoAgoraNao();
    }

    @DisplayName("Valida meia modal E-mail não cadastrado e clicar em Cadastrar agora")
    @Tag("Perfil")
    @Test
    public void validaMeiaModalEmailNaoCadastradoClicandoBotaoCadastrarAgora() {
        perfilTask.validaMeiaModalBotaoCadastrarAgora(preencherEmail);
    }

}
