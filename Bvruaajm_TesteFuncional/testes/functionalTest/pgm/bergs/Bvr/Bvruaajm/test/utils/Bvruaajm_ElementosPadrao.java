package bergs.Bvr.Bvruaajm.test.utils;

import org.openqa.selenium.By;

public class Bvruaajm_ElementosPadrao {

    public static By processando = By.cssSelector(".ui-loader-verbose");
    public static By body = By.cssSelector("body");
    public static By autenticando = By.xpath("//android.widget.TextView[@text='Autenticando']");
    public static By carregando = By.xpath("//android.widget.TextView[@text='Carregando']");
    public static By botaoCompartilhar = By.xpath("//android.widget.ImageButton[@content-desc='Compartilhar']");
    public static By botaoAllowNativo = By.xpath("//android.widget.Button[@text='ALLOW' or @text='PERMITIR']");
    public static By carregandoInformacoes = By.id("descricaoEstado");
    public static By overlay = By.xpath("//div[contains(@class, 'blockOverlay') and contains(@class, 'blockUI') and contains(@style, 'z-index: 1000')]");
    public static By prcessandoFimDePagina = By.id("indicadorCarregamento");
}
