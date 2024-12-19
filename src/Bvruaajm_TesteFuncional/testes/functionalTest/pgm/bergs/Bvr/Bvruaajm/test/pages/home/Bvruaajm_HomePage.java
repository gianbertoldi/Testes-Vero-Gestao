package bergs.Bvr.Bvruaajm.test.pages.home;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_HomePage extends Bmouaajm_PaginaBase {

    Bvruaajm_Esperas esperas;

    public Bvruaajm_HomePage(AppiumDriver<WebElement> driver) {
        super(driver);
        esperas = new Bvruaajm_Esperas(driver);
    }

    @Override
    protected boolean estaPronto() {
        return true;
    }

    public Bmouaajm_Elemento obterHomeCarregada() {
        esperas.esperarAte(ExpectedConditions.invisibilityOfElementLocated(By.id("imagem-zero")), 50);
        return body().findElement(By.id("imagem-zero"));
    }

    public Bmouaajm_Elemento obterBotaoPsrTelaHome() {
        return body().procurarElemento(By.id("bvr-home-psr"));
    }

    public Bmouaajm_Elemento obterBotaoAdicionarMinhaMeta() {
        return body().procurarElemento(By.id("linha-botao-metas"));
    }

    public Bmouaajm_Elemento obterCampoNomeMeta() {
        return body().procurarElemento(By.id("nomeMeta"));
    }

    public Bmouaajm_Elemento obterMsgErroNomeMeta() {
        return body().procurarElemento(By.id("nomeMetaMsgErro"));
    }

    public Bmouaajm_Elemento obterCampoValorMeta() {
        return body().procurarElemento(By.id("valorMeta"));
    }

    public Bmouaajm_Elemento obterMsgErroValorMeta() {
        return body().procurarElemento(By.id("valorMetaMsgErro"));
    }

    public Bmouaajm_Elemento obterBotaoCadastrarMeta() {
        return body().procurarElemento(By.id("bvr-botao-modal-cadastrar"));
    }

    public Bmouaajm_Elemento obterBotaoCancelarEdicaoMeta() {
        return body().procurarElemento(By.xpath("//div[contains(@id, 'bvr-modal-mensagem-')]//ds-button[@variant='secondary']"));
    }

    public Bmouaajm_Elemento obterBotaoEditarMinhaMeta() {
        return body().procurarElemento(By.id("editar-metas"));
    }

    public Bmouaajm_Elemento obterValorMinhaMetaHome() {
        return body().procurarElemento(By.id("valor-franquia"));
    }

    public Bmouaajm_Elemento obterBotaoQuantoVendi() {
        return body().procurarElemento(By.xpath("//div[@id='div-origem']/label[@for='rad-vendi']"));
    }

    public Bmouaajm_Elemento obterBotaoQuantoVouReceber() {
        return body().procurarElemento(By.xpath("//div[@id='div-origem']/label[@for='rad-receber']"));
    }

    public Bmouaajm_Elemento obterBotaoQuantoRecebi() {
        return body().procurarElemento(By.xpath("//div[@id='div-origem']/label[@for='rad-recebi']"));
    }

    public Bmouaajm_Elemento obterBeneficiosFechadaQuantoRecebi() {
        return body().procurarElemento(By.xpath("//tr[contains(@class,'aberto')]/td/span[@id='seta-lista-recebiveis-van']"), Duration.ofSeconds(5));
    }

    public List<Bmouaajm_Elemento> obterListaCartaoBeneficios() {
        return body().procurarElementos(By.xpath("//tr[@mm-id='id_linha_bandeira_van']"));
    }

    public Bmouaajm_Elemento obterClickAquiCartaoBeneficio() {
        return body().procurarElemento(By.id("bvr-dv-atendimento"));
    }

    public Bmouaajm_Elemento obterTituloConversarComVero() {
        return body().procurarElemento(By.id("bvr-suporte-titulo"));
    }

    public Bmouaajm_Elemento obterBotaoSimuladorCarrossel() {
        return body().procurarElemento(By.id("bvr-botao-atalho-simulador"));
    }
    
    public Bmouaajm_Elemento obterBotaoGeoLocalizacaoCarrossel() {
        return body().procurarElemento(By.id("bvr-home-geolocalizacao"));
    }

    public Bmouaajm_Elemento obterBotaoPSRCarrossel() {
        return body().procurarElemento(By.id("bvr-home-psr"));
    }
    
    public WebElement procurarBotaoPSRCarrossel() {
        return driver.findElement(By.id("bvr-home-psr"));
    }

    public Bmouaajm_Elemento obterCardIcone(String card) {
        return body().procurarElemento(By.xpath("//*[@id='bvr-botao-atalho-" + card + "']//img"));
    }

    public int obterQuantidadeDeCardsVisiveis() {
        return body().procurarElementos(By.xpath("//div[contains(@class ,'bvr-card-carrossel') and not(contains(@class , 'hide'))]")).size();
    }

    public Bmouaajm_Elemento obterCardTitulo(String card) {
        esperas.aguardarTextoProcessandoDesaparecer();
        return body().procurarElemento(By.xpath("//*[@id='bvr-carrossel-titulo-" + card + "']"));
    }

    public Bmouaajm_Elemento obterCardTexto(String card) {
        return body().procurarElemento(By.xpath("//*[@id='bvr-botao-atalho-" + card + "']//span[2]"));
    }

    public Bmouaajm_Elemento obterCarrosselPai() {
        return body().procurarElemento(By.id("bvr-carrossel-pai"));
    }

    public Bmouaajm_Elemento obterTituloVendaHojeExtrato() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-ext-content']/div/span[@class='ds-u-text-small-normal']"));
    }
    
    public Bmouaajm_Elemento obterSemTrasacaAindaExtrato() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-ext-sem-vendas']//span[@class='ds-u-text-small-normal']"));
    }
    
    public Bmouaajm_Elemento obterValorQuantoVendiHoje() {
        return body().procurarElemento(By.id("bvr-ext-valor-hoje"));
    }
    
    public List<Bmouaajm_Elemento> obterUltimasVendas() {
        return body().procurarElementos(By.xpath("//ul[@id='ul-bvr-ext']/li"));
    }
    
    public Bmouaajm_Elemento obterIconesEscondidosValorTotal() {
        return body().procurarElemento(By.id("recebiveis-escondido"));
    }
    
    public Bmouaajm_Elemento obterIconesEscondidosValorTotalBandeiras() {
        return body().procurarElemento(By.xpath("//span[@class='valor-subtitulo-bandeira bvr-valor-escondido bvr-valor-total-infografico-escondido fright aberto bvr-ske-width-20']"));
    }
    
    public Bmouaajm_Elemento obterIconesEscondidosValorMinhaMeta() {
        return body().procurarElemento(By.id("valor-franquia-escondido"));
    }

    public Bmouaajm_Elemento obterListaExtratoHome() {
        return body().procurarElemento(By.id("bvr-ext-linha"));
    }   
}
