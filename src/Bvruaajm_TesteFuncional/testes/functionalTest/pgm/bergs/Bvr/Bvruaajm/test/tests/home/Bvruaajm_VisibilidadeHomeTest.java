package bergs.Bvr.Bvruaajm.test.tests.home;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_ElementoNativoTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.home.Bvruaajm_HomeTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;

public class Bvruaajm_VisibilidadeHomeTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_CartaoAcesso cartaoAcesso2 = Bvruaajm_EnumCartaoAcesso.Pannuvia.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.ConsultoriaInfoteca.obterEstabelecimento();
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_HomeTask homeTask;
    Bvruaajm_ElementoNativoTask nativoTask;
    
    @BeforeEach
    public void iniciaTeste() {
        homeTask = new Bvruaajm_HomeTask(driver);
        genericTask =  new Bvruaajm_GenericTask(driver);
        nativoTask = new Bvruaajm_ElementoNativoTask(driver);
        genericTask.definirContextoWebview();    
        genericTask.prepararTesteLogado(cartaoAcesso2);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        nativoTask.clicarBotaoDireito();
    }
    
    @AfterEach
    public void finalizarTest() {
        nativoTask.clicarBotaoDireito();
    }
    
    
    @DisplayName("Teste para validar se os valores da Home estão ocultos")
    @Tag("home")
    @Test
    public void validaIconesOcultos() {       
        homeTask.validaIconesEscondidosHome();        
    }
    
    @DisplayName("Teste para validar se os valores da Home estão ocultos apos mudar de tela e voltar")
    @Tag("home")
    @Test
    public void validaIconesOcultosSeMantemEmTrocaDeTela() {  
        genericTask.clicarBotaoVender();
        nativoTask.clicarBotaoEsquerdo();
        homeTask.validaIconesEscondidosHome();        
    }
}
