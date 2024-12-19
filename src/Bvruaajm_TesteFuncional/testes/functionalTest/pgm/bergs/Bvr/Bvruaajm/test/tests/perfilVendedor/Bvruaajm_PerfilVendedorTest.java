package bergs.Bvr.Bvruaajm.test.tests.perfilVendedor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.perfilVendedor.Bvruaajm_PerfilVendedorTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;

public class Bvruaajm_PerfilVendedorTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_GenericTask genericTask;
    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.PerfilVendedor.obterCartaoAcesso();
    Bvruaajm_PerfilVendedorTask vendedorTask;

    @BeforeEach
    public void iniciarTest() {
        genericTask = new Bvruaajm_GenericTask(driver);
        vendedorTask = new Bvruaajm_PerfilVendedorTask(driver);
        taskMobile.definirContextoWebview();
        genericTask.prepararTesteLogado(cartaoAcesso);
    }

    @Tag("PerfilVendedor")
    @Test
    @DisplayName("Verifica titulo Pagina Receber Pagamento Perfil Vendedor")
    public void validaTituloTelaReceberPagamento() {
        vendedorTask.validaTituloPageReceberPagamento();
    }
}
