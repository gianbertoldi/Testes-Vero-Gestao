package bergs.Bvr.Bvruaajm.test.tasks.conexoes.ofertas;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.homeOfertas.Bvruaajm_HomeOfertasPage;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_HomeOfertasTask extends Bvruaajm_TaskMobile {

    private Bvruaajm_HomeOfertasPage home;
    
    public Bvruaajm_HomeOfertasTask(AppiumDriver<WebElement>driver) {
        super(driver);
        home = new Bvruaajm_HomeOfertasPage(driver);
    }
    
    public void criarUmaOferta() {
        home.obterBotaoOferta().clicar();
    }
    
    public void criarUmaNovaOferta() {
        home.obterCardNovaOferta().clicar();
    }
    
    public void detalhesUltimaOferta() {
        home.obterDetalhesDaOferta().clicar();
    }
    
    public void cardDaOferta(String id) {
        home.obterLabelCardNomeOferta(id).clicar();
    }
    
    public void avancarParaOfertasDesativadas() {
        home.obterCardDesativadas().scrollIntoView().clicar();
    }
      
    public void avancarParaOfertasExpiradas() {
        home.obterCardExpiradas().scrollIntoView().clicar();
    }
}
