package bergs.Bvr.Bvruaajm.test.pages.jornadaComprador;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;

public class Bvruaajm_JornadaCompradorDadosPagamentoPage extends Bmouaajm_PaginaBase {

    public Bvruaajm_JornadaCompradorDadosPagamentoPage(ChromeDriver driver) {
        super(driver);
    }

    @Override
    protected boolean estaPronto() {
        return true;
    }

    public Bmouaajm_Elemento obterInputNumeroCartao() {
        return body().procurarElemento(By.id("billing-cc-number"));
    }

    public Bmouaajm_Elemento obterInputNomeCartao() {
        return body().procurarElemento(By.id("billing-cc-name"));
    }

    public Bmouaajm_Elemento obterInputValidadeCartao() {
        return body().procurarElemento(By.id("billing-cc-exp"));
    }

    public Bmouaajm_Elemento obterInputCVVCartao() {
        return body().procurarElemento(By.id("billing-cc-csc"));
    }

    public Bmouaajm_Elemento obterInputCEP() {
        return body().procurarElemento(By.id("billing-postal-code"));
    }

    public Bmouaajm_Elemento obterInputNumeroEndereco() {
        return body().procurarElemento(By.id("billing-address-line2"));
    }

    public Bmouaajm_Elemento obterCheckBoxSemNumero() {
        return body().procurarElemento(By.id("sem-numero"));
    }

    public Bmouaajm_Elemento obterCampoLogradouroRotuloAcima() {
        return body()
                .procurarElemento(By.xpath("//div[@id='dados-endereco']//label[@class='bvr-label rotulo acima' and @for='billing-address-line1']"));
    }

    public Bmouaajm_Elemento obterBotaoContinuarPagamento() {
        return body().procurarElemento(By.id("btn-avancar"));
    }

    public Bmouaajm_Elemento obterBotaoConfirmarPagamento() {
        return body().procurarElemento(By.id("btn-confirmar"));
    }

    public List<Bmouaajm_Elemento> obterParcelasPreDefinidas() {
        return body().procurarElementos(By.xpath("//select[@id='forma-pagamento']/option"), Duration.ofSeconds(10));
    }
}
