package bergs.Bvr.Bvruaajm.test.tasks.taskBase;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.bmo.bmouaajm.suporte.tasks.Bmouaajm_TaskBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_TaskMisto extends Bmouaajm_TaskBase{

    private String NATIVO = "NATIVE_APP";
    private String WEBVIEW = "";
    Bvruaajm_Esperas esperas;
    protected AppiumDriver<WebElement> driver;

    public Bvruaajm_TaskMisto(AppiumDriver<WebElement> driver) {
        super(driver);
        this.driver = driver;
        Set<String> handles = driver.getContextHandles();
        for (String handle : handles) {
            if (handle.contains("WEBVIEW")) {
                WEBVIEW = handle;
            }
        }
    }
    
    public void fecharAbrirAplicativo() {
        driver.closeApp();
        driver.launchApp();
    }
    
    public void resetarAplicativo(By by) {
        driver.resetApp();
        driver.context(WEBVIEW);
        esperas.visibilidadeDoElemento(by);
    }

    public void definirContextoWebview() {
        driver.context(WEBVIEW);
    }

    public void definirContextoNativo() {
        driver.context(NATIVO);
    }
}
