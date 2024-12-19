package bergs.Bvr.Bvruaajm.test.utils;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_Esperas {

    private AppiumDriver<WebElement> driver;

    public Bvruaajm_Esperas(AppiumDriver<WebElement> driver) {
        this.driver = driver;

    }

    /**
     * 
     * METODO EFETUAR ELEMENTE EXISTE NA TELA E AGUARDA ESTAR DISPONIVEL COM UM TEMPO MAXIMO DE 30 SEGUNDOS
     */
    public WebElement visibilidadeDoElemento(By by) {
        return visibilidadeDoElemento(by, 30);
    }

    /**
     * 
     * METODO EFETUAR ELEMENTE EXISTE NA TELA E AGUARDA ESTAR DISPONIVEL COM UM TEMPO MAXIMO DE INFORMADO PELO USUÁRIO
     */
    public WebElement visibilidadeDoElemento(By by, int timeoutEmSegundos) {
        FluentWait<AppiumDriver<WebElement>> wait = new FluentWait<AppiumDriver<WebElement>>(driver)
                .withTimeout(Duration.ofSeconds(timeoutEmSegundos))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(WebDriverException.class);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * METODO QUE AGUARDA ELEMENTO FICAR INVISIVEL NA TELA UTILIZANDO FLUENTWAIT
     * 
     */
    public boolean aguardarElementoDesaparecer(By by) {
        FluentWait<AppiumDriver<WebElement>> wait = new FluentWait<AppiumDriver<WebElement>>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(WebDriverException.class);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    
    public boolean aguardarElementoDesaparecer(Bmouaajm_Elemento el) {
        FluentWait<AppiumDriver<WebElement>> wait = new FluentWait<AppiumDriver<WebElement>>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(WebDriverException.class);
        return wait.until(ExpectedConditions.invisibilityOf(el.getWrappedElement()));
    }

    /**
     * Executa uma espera por certo tempo
     */
    public Object esperarAte(ExpectedCondition<?> expectedCondition, int timeoutEmSegundos) {
        return esperarAte(expectedCondition, timeoutEmSegundos, 1000);
    }

    /**
     * Executa uma espera por certo tempo fazendo validação a cada tempo
     */
    public Object esperarAte(ExpectedCondition<?> expectedCondition, int timeoutEmSegundos, int pollingDurationMillis) {
        FluentWait<AppiumDriver<WebElement>> wait = new FluentWait<AppiumDriver<WebElement>>(driver)
                .withTimeout(Duration.ofSeconds(timeoutEmSegundos))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(WebDriverException.class);
        return wait.until(expectedCondition);
    }

    /** ESPERAS DE AGUARDAR INFORMAÇÕES NATIVAR DESAPARECEREM **/

    /**
     * ESPERAR TEXTO INFORMAÇÕES DESAPARECER
     */
    public void aguardarTextoCarregandoInformacoesDesaparecer() {
        try {
            if (this.driver.findElements(Bvruaajm_ElementosPadrao.carregandoInformacoes).size() == 0) {
                esperarAte(ExpectedConditions.visibilityOfElementLocated(Bvruaajm_ElementosPadrao.carregandoInformacoes), 10);
            }
            esperarAte(ExpectedConditions.invisibilityOfElementLocated(Bvruaajm_ElementosPadrao.carregandoInformacoes), 30);
        } catch (Exception e) {
            System.err.println("Erro aguardando o texto Carregando informações: " + e.getMessage());
        }
    }

    /**
     * ESPERAR PROCESSAMENTO INFRA DESAPARECER
     */
    public void aguardarTextoProcessandoDesaparecer() {
        try {
            if (this.driver.findElements(Bvruaajm_ElementosPadrao.processando).size() == 0) {
                esperarAte(ExpectedConditions.visibilityOfElementLocated(Bvruaajm_ElementosPadrao.processando), 10);
            }
            esperarAte(ExpectedConditions.invisibilityOfElementLocated(Bvruaajm_ElementosPadrao.processando), 60);
        } catch (Exception e) {
        }
        try {
            if (this.driver.findElements(Bvruaajm_ElementosPadrao.overlay).size() == 0) {
                esperarAte(ExpectedConditions.visibilityOfElementLocated(Bvruaajm_ElementosPadrao.overlay), 3);
            }
            esperarAte(ExpectedConditions.invisibilityOfElementLocated(Bvruaajm_ElementosPadrao.overlay), 10);
        } catch (Exception e) {

        }
    }
    
    public void aguardarPorcessandoFimDePaginaDesaparecer() {
        try {
            if (this.driver.findElements(Bvruaajm_ElementosPadrao.prcessandoFimDePagina).size() == 0) {
                esperarAte(ExpectedConditions.visibilityOfElementLocated(Bvruaajm_ElementosPadrao.prcessandoFimDePagina), 10);
            }
            esperarAte(ExpectedConditions.invisibilityOfElementLocated(Bvruaajm_ElementosPadrao.prcessandoFimDePagina), 60);
        } catch (Exception e) {
            System.err.println("Erro aguardando o texto Carregando informações: " + e.getMessage());
        }
        
    }
}
