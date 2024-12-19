package bergs.Bvr.Bvruaajm.test.pages.perfil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_GerenciarUsuarioPage extends Bmouaajm_PaginaBase{
    
    public Bvruaajm_GerenciarUsuarioPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    @Override
    protected boolean estaPronto() {
        return true;
    }
    
    public Bmouaajm_Elemento obterBotaoIncluirUsuario() {
        return body().procurarElemento(By.id("btnAdicionarUsuario"));
    }
    
    public Bmouaajm_Elemento obterInputCpf() {
        return body().procurarElemento(By.id("cadCliCpf"));
    }
    
    public Bmouaajm_Elemento obterInputNome() {
        return body().procurarElemento(By.id("cadCliApelido"));
    }
    
    public Bmouaajm_Elemento obterInputCeluar() {
        return body().procurarElemento(By.id("telefoneConfirma"));
    }
    
    public Bmouaajm_Elemento obterInputEmail() {
        return body().procurarElemento(By.id("emailConfirma"));
    }
    
    public Bmouaajm_Elemento obterExcluirUsuario(String cpf) {
        return body().procurarElemento(By.id("exclui-usuario-" + cpf));
    }
}
