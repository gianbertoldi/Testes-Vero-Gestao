package bergs.Bvr.Bvruaajm.test.tasks.taskBase;

import java.util.Set;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.bmo.bmouaajm.suporte.tasks.Bmouaajm_TaskBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_TaskMobile extends Bmouaajm_TaskBase {

    protected AppiumDriver<WebElement> driver;
    private String NATIVO = "NATIVE_APP";
    private String WEBVIEW = "";
    Bvruaajm_Esperas esperas;


    public Bvruaajm_TaskMobile(AppiumDriver<WebElement> driver) {
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

    public void resetarAplicativo() {
        driver.resetApp();
        driver.context(WEBVIEW);
    }

    public void definirContextoWebview() {
        driver.context(WEBVIEW);
    }

    public void definirContextoNativo() {
        driver.context(NATIVO);
    }

    public void fecharTeclado() {
        driver.hideKeyboard();  
    }
}
