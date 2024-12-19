package bergs.Bvr.Bvruaajm.test.tasks.servicos;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.generic.Bvruaajm_GenericPage;
import bergs.Bvr.Bvruaajm.test.pages.home.Bvruaajm_HomePage;
import bergs.Bvr.Bvruaajm.test.pages.servicos.Bvruaajm_GeolocalizacaoPage;
import bergs.Bvr.Bvruaajm.test.pages.servicos.Bvruaajm_ServicosPage;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.validations.Bvruaajm_GenericValidation;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_ServicosTask extends Bvruaajm_TaskMobile {

    Bvruaajm_ServicosPage servicoPage;
    Bvruaajm_GeolocalizacaoPage  geolocalizacaoPage;
    Bvruaajm_GenericValidation genericValidation;
    Bvruaajm_GenericPage genericPage;
    Bvruaajm_HomePage homePage;

    public Bvruaajm_ServicosTask(AppiumDriver<WebElement> driver) {
        super(driver);
        servicoPage = new Bvruaajm_ServicosPage(driver);
        geolocalizacaoPage = new Bvruaajm_GeolocalizacaoPage(driver);
        genericValidation = new Bvruaajm_GenericValidation(driver);
        genericPage = new Bvruaajm_GenericPage(driver);
        homePage = new Bvruaajm_HomePage(driver);
    }

    public void acessarPaginaSimulador() {
        servicoPage.obterBotaoSimulador().clicar();
    }
    
    public void fluxoValidaGeolocalizacao(String txtEstabeleciomento, String nomeFantasia, String lougadouro, String tituloContato, String tituloInfoAtividade) {
        servicoPage.obterBotaoGeolocalizacao().clicar();
        genericValidation.validarTextosEsperadoEAtual(txtEstabeleciomento, geolocalizacaoPage.obterTextoEstabelecimento().obterTexto());
        geolocalizacaoPage.obterAbrirSelecaoEstabelecimento().clicar();
        definirContextoNativo();
        geolocalizacaoPage.selecionarEstabelecimento().click();
        definirContextoWebview();
        genericValidation.validarTextosEsperadoEAtual(nomeFantasia, geolocalizacaoPage.obterTextoNomeFantasia().obterTexto());
        geolocalizacaoPage.obterBotaoAvancarInicio().clicar();
        geolocalizacaoPage.obterChevronLocalizacaoFixa().clicar();
        genericValidation.validarTextosEsperadoEAtual(lougadouro, geolocalizacaoPage.obterTextoLongadouro().obterTexto());
        geolocalizacaoPage.obterBotaoAvancar().clicar();
        genericValidation.validarTextosEsperadoEAtual(tituloContato, geolocalizacaoPage.obterTituloContato().obterTexto());
        geolocalizacaoPage.obterBotaoAvancar().clicar();
        genericValidation.validarTextosEsperadoEAtual(tituloInfoAtividade, geolocalizacaoPage.obterTituloFuncionamento().obterTexto());
        geolocalizacaoPage.obterBotaoSalvar().clicar();
        definirContextoNativo();
        geolocalizacaoPage.obterBotaoConfirmo().click();
        definirContextoWebview();
        genericPage.obterBotaoEntendi().clicar();
        genericValidation.validarTextosEsperadoEAtual(nomeFantasia, geolocalizacaoPage.obterTextoNomeFantasia().obterTexto());
    }
    
    public void verificaGeolocalizacaoCarroselHome(String txtEstabeleciomento) {
        homePage.obterBotaoGeoLocalizacaoCarrossel().clicar();
        genericValidation.validarTextosEsperadoEAtual(txtEstabeleciomento, geolocalizacaoPage.obterTextoEstabelecimento().obterTexto());
    }
}
