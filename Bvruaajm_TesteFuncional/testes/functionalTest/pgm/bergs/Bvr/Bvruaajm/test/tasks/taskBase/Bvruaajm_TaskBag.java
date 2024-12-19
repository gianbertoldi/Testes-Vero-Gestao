package bergs.Bvr.Bvruaajm.test.tasks.taskBase;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil.Bvruaajm_InformativoPerfilPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil.Bvruaajm_OnboardingConexoesPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.homeOfertas.Bvruaajm_HomeOfertasPage;
import bergs.Bvr.Bvruaajm.test.pages.generic.Bvruaajm_ElementoNativoPage;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.home.Bvruaajm_HomeTask;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBag;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_TaskBag extends Bvruaajm_TaskMobile{

    private Bvruaajm_HomeTask homeTask;
    private Bvruaajm_TaskMobile taskMobile;
    private Bvruaajm_GenericTask genericTask;
    private Bvruaajm_InformativoPerfilPage informativoPage;
    private Bvruaajm_OnboardingConexoesPage onboarding;
    private Bvruaajm_SqlBag sqlBag;
    private Bvruaajm_ElementoNativoPage elementoNativo;
    private Bvruaajm_HomeOfertasPage homeOfertasPage;

    public Bvruaajm_TaskBag(AppiumDriver<WebElement> driver) {
        super(driver);
        informativoPage = new Bvruaajm_InformativoPerfilPage(driver);
        sqlBag = new Bvruaajm_SqlBag();
        genericTask = new Bvruaajm_GenericTask(driver);
        taskMobile = new Bvruaajm_TaskMobile(driver);
        homeTask = new Bvruaajm_HomeTask(driver);
        onboarding = new Bvruaajm_OnboardingConexoesPage(driver);
        elementoNativo = new Bvruaajm_ElementoNativoPage(driver);
        homeOfertasPage = new Bvruaajm_HomeOfertasPage(driver);
        esperas = new Bvruaajm_Esperas(driver);
    }
    
    public void verificaServidorUsuarioLogado(Bvruaajm_CartaoAcesso cartaoAcesso , Bvruaajm_Estabelecimento estabeleciomento , String servidor) {
        trocaServiador(servidor);
      
        genericTask.prepararTesteLogado(cartaoAcesso);
        taskMobile.definirContextoWebview();
        genericTask.selecionaEstabelecimentoOuConveniado(estabeleciomento);
        homeTask.clicarCardConexoes();
                   
        if(telasInformativa() || telasOboarding()) {
            sqlBag.incluirEc(estabeleciomento.obterCnpjZerosAEsquerda()  ,"J" , 1, "S" , "A");
            fecharAbrirAplicativo();
           
            genericTask.prepararTesteLogado(cartaoAcesso);
            taskMobile.definirContextoWebview();
            genericTask.selecionaEstabelecimentoOuConveniado(estabeleciomento);
            homeTask.clicarCardConexoes();
        }        
    }
    
    public void trocaServiador(String texto) {
        definirContextoNativo();
        elementoNativo.obterBotaoEsquerdo().click();
        if(!elementoNativo.obterServidorMenu().getText().contains(texto)) {
            elementoNativo.obterServidorMenu().click();
            elementoNativo.obterServidor(texto).click();

        }else {
            elementoNativo.obterBotaoEsquerdo().click();

        }
        definirContextoWebview();
    }
    
    public void criarNovaOferta() {
        if(telaHomeVazia()) {
            homeOfertasPage.obterBotaoOferta().clicar();
        }else {
            homeOfertasPage.obterCardNovaOferta().clicar();
        }
        
    }
    
    public boolean telasInformativa() {
        try {
            esperas.esperarAte(driver -> informativoPage.obterBotaoVamosLa().estaVisivel(), 30);
            if(informativoPage.obterBotaoVamosLa().obterTexto().equals("Revisar informações")) {
                return false;
            }else {
            return true;
            }
        }catch(Exception e) {
            return false;
        }
    }
    
    public boolean telasOboarding() {
        try {
            esperas.esperarAte(driver -> onboarding.obterTitulo(1).estaVisivel(), 30);
            return true;
        }catch(Exception e) {
            return false;
        }
    }
    
    public boolean telaHomeVazia() {
        try {
            homeOfertasPage.obterBotaoOferta().estaVisivel();
            return true;
        }catch(Exception e) {
            return false;
        }
    }
}
