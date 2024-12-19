package bergs.Bvr.Bvruaajm.test.utils;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;

import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.util.Bmouaajm_Formatador;
import bergs.bmo.bmouaajm.suporte.util.Bmouaajm_Javascript;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_JsExecutor extends Bmouaajm_Javascript {

    public Bvruaajm_JsExecutor(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    public void removerFocusElementoAtual() {
        executeScript("document.querySelector(':focus').blur()", "");
    }

    public void scrollIntoView(WebElement el) {
        executeScript("$(arguments[0])[0].scrollIntoView()", el);
    }

    public void scrollIntoView(Bmouaajm_Elemento el) {
        executeScript("$(arguments[0])[0].scrollIntoView()", el);
    }

    public void deletarQuantidadeDeLinksCriadosLocalStoragePorCpf(Bvruaajm_CartaoAcesso cartaoAcesso) {
        String cpf = String.valueOf(cartaoAcesso.obterCpf());
        cpf = Bmouaajm_Formatador.formatarCPF(cpf);
        executeScript("window.localStorage.removeItem('bvr-num-links-" + cpf + "', '')");
    }

    public String obterIdLinkPgtoCriado() {
        Object idLink = executeScript("return top.ojLink.dados.registrousuario.cod_link_pgto");
        return idLink.toString();
    }

    public String retornaLocalStorageAtualizaEmailCadastrado(String cpf) {
        Object obj = executeScript("return window.localStorage.getItem('bvr-exibiuModal-email-" + cpf + "', 'ok')");
        return String.valueOf(obj);
    }

    /**
     * Limpa local Storage que define se o e-mail cadastrado esta atualizado
     * 
     */
    public void removeLocalStorageEmailAtualizadoCpf(String cpf) {
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(2));
            executeScript("window.localStorage.removeItem('bvr-email-atualizado-data-" + cpf + "', '')");
        } catch (InterruptedException e) {
            //TODO: Catch deve ter tratamento.
        }
    }
    
    public void removeLocalStorageExibiuModalEmailCpf(String cpf) {
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(2));
            executeScript("window.localStorage.removeItem('bvr-exibiuModal-email-" + cpf + "', '')");
        } catch (InterruptedException e) {
            //TODO: Catch deve ter tratamento.
        }
    }

    public void abreBarraModalWallet(Bmouaajm_Elemento obterBarraModalMovelWallet, Bmouaajm_Elemento obterTituloBarraModalMovelWallet) {
        StringBuilder sb = new StringBuilder();
        sb.append("var container = $(arguments[0]), clicado = $(arguments[1]);");
        sb.append("var top = clicado.position().top; ");
        sb.append("var mockEv = {preventDefault: function(){}, touches:[{clientY: top}]}; ");
        sb.append("container[0].ontouchstart(mockEv); ");
        sb.append("container[0].ontouchend(mockEv); ");
        executeScript(sb.toString(), obterBarraModalMovelWallet, obterTituloBarraModalMovelWallet);
    }
    
    public String obterValorCampoApelido() {
        Object descri = executeScript("return window.document.getElementById('cadCliApelido').value");
        return String.valueOf(descri);
    }
    
    public void alterarValorLinkPgtoTelaResumoLink() {
        executeScript("document.getElementById('bvr-ve-valor-texto').value = '5000,02'");
    }
    
    public void removerLocalStorageViuTelaParcelaMinima() {
        executeScript("window.localStorage.removeItem('bvr-viu-aviso-parcela-minima', '')");
    }
    
    public void sliderCarrosselBloqueioLinkPgtoPsr() {
        executeScript("oInfra.getTela().dispararEventoCarrossel('bvr-pix-onboarding-carousel', 'next')");
    }
}
