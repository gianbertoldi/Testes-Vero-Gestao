package bergs.Bvr.Bvruaajm.test.pages.jornadaComprador;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;

public class Bvruaajm_JornadaCompradorResumoPagamentoPage extends Bmouaajm_PaginaBase {

    public Bvruaajm_JornadaCompradorResumoPagamentoPage(ChromeDriver driver) {
        super(driver);
    }

    @Override
    protected boolean estaPronto() {
        return body().procurarElemento(By.id("avaliacao"), Duration.ofSeconds(50)).estaVisivel();
    }

    public Bmouaajm_Elemento obterInput4Estrelas() {
        return body().procurarElemento(By.id("star4"), Duration.ofSeconds(50));
    }

    public Bmouaajm_Elemento obterTxtAreaAvaliacao() {
        return body().procurarElemento(By.id("txtDissertativa"));
    }

    public Bmouaajm_Elemento obterButonEnviarAvaliacao() {
        return body().procurarElemento(By.id("enviarAvaliacao"));
    }

    public Bmouaajm_Elemento obterTextoPgtoNegado() {
        return body().procurarElemento(By.xpath("//div[text()='Pagamento negado']"), Duration.ofSeconds(50));
    }

    public Bmouaajm_Elemento obterBotaoTentarOutroCartao() {
        return body().procurarElemento(By.cssSelector(".bvr-redirect"));
    }

    // Usado o mesmo metodo para link bloqueado e indisponivel
    public Bmouaajm_Elemento obterTextoMensagemDeErroLink() {
        return body().procurarElemento(By.xpath("//div[@class='ds-u-title-normal spacer-16']"));
    }

    public Bmouaajm_Elemento obterTextoDescricaoDoErroLink() {
        return body().procurarElemento(By.xpath("//div[@class='ds-u-text-medium-normal']"));
    }

    public Bmouaajm_Elemento obterTextoSpanAposAvalicao() {
        return body().procurarElemento(By.xpath("//div[@id='obrigado']//span"));
    }
}
