package bergs.Bvr.Bvruaajm.test.tests.perfil.gerenciarUsuario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.perfil.Bvruaajm_GerenciarUsuariosTask;
import bergs.Bvr.Bvruaajm.test.tasks.perfil.Bvruaajm_PerfilTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBvr;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;

public class Bvruaajm_GerenciarUsuarioTest extends Bvruaajm_TesteBaseMobile {
    
    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_CartaoAcesso cartaoAcesso2 = Bvruaajm_EnumCartaoAcesso.TesteQA.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.Alberto.obterEstabelecimento();

    Bvruaajm_GerenciarUsuariosTask gerenciarUsuarioTask;
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_PerfilTask perfilTask;
    Bvruaajm_SqlBvr sqlBvr;
    
    @BeforeEach
    public void iniciaTest() {
        sqlBvr = new Bvruaajm_SqlBvr();
        genericTask = new Bvruaajm_GenericTask(driver);
        perfilTask = new Bvruaajm_PerfilTask(driver);
        sqlBvr.excluirEstabelecimentoDeUmUsuario(cartaoAcesso2, estab);
        gerenciarUsuarioTask = new Bvruaajm_GerenciarUsuariosTask(driver);
        genericTask.prepararTesteLogado(cartaoAcesso);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        genericTask.clicarBotaoPerfil();
        perfilTask.acessarMeusNegocios();
    }
    
    @Tag("Perfil")
    @DisplayName("Teste de inclusao e exclusao de um usuario em um estabelecimento")
    @Test
    public void inserirExcluirUsuarioTest() {
        gerenciarUsuarioTask.validaIncluirExcluirUsuario(cartaoAcesso2);
    }
}
