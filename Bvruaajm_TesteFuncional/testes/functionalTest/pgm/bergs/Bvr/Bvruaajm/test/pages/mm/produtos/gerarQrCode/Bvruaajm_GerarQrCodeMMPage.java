package bergs.Bvr.Bvruaajm.test.pages.mm.produtos.gerarQrCode;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;

public class Bvruaajm_GerarQrCodeMMPage extends Bmouaajm_PaginaBase {

    public Bvruaajm_GerarQrCodeMMPage(RemoteWebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean estaPronto() {
        return false;
    }

    public Bmouaajm_Elemento obterPessoaFisica() {
        return body().procurarElemento(By.id("txtFiltroTipoPessoaEstab_F"));
    }

    public Bmouaajm_Elemento obterPessoaJuridica() {
        return body().procurarElemento(By.id("txtFiltroTipoPessoaEstab_J"));
    }

    public Bmouaajm_Elemento obterInputPessoaFisica() {
        return body().procurarElemento(By.id("txtFiltroCpfEstab"));
    }

    public Bmouaajm_Elemento obterInputPessoaJuridica() {
        return body().procurarElemento(By.id("txtFiltroCnpjEstab"));
    }

    public Bmouaajm_Elemento obterVeroX() {
        return body().procurarElemento(By.id("txtTipoQrVeroX"));
    }
    
    public Bmouaajm_Elemento obterVeroWallet() {
        return body().procurarElemento(By.id("txtTipoQrWallet"));
    }

    public Bmouaajm_Elemento obterImagemQrCode() {
        return body().procurarElemento(By.id("bvr-img-qr-code"));
    }

}
