package bergs.Bvr.Bvruaajm.test.pages.mm.genericMM;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;

public class Bvruaajm_GenericMMPage extends Bmouaajm_PaginaBase{

    public Bvruaajm_GenericMMPage(RemoteWebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean estaPronto() {
        return false;
    }

    public Bmouaajm_Elemento obterBotaoPesquisar() {
        return body().procurarElemento(By.id("btnFiltroPesquisar"));
    }
    
    public Bmouaajm_Elemento obterBotaoLimpar() {
        return body().procurarElemento(By.id("btnFiltroLimpar"));
    }
    
    public Bmouaajm_Elemento obterBotaoVoltar() {
        return body().procurarElemento(By.id("btnVoltar"));
    }
    
    public Bmouaajm_Elemento obterBotaoExportar() {
        return body().procurarElemento(By.id("btnExportar"));
    }
    
    public Bmouaajm_Elemento obterBotaoSalvarCadastro() {
        return body().procurarElemento(By.id("btnCadastroSalvar"));
    }
    
    public Bmouaajm_Elemento obterBotaoIncluirCadastro() {
        return body().procurarElemento(By.id("btnCadastroIncluir"));
    }
    
    public Bmouaajm_Elemento obterTextoQuantidadeRegistro() {
        return body().procurarElemento(By.id("paginacaoAuxiliar"));
    }
    
    public Bmouaajm_Elemento obterMensagemErroCpf() {
        return body().procurarElemento(By.xpath("//div[@class='erro erro-type-cpf']"));
    }
    
    public Bmouaajm_Elemento obterMensagemErroCnpj() {
        return body().procurarElemento(By.xpath("//div[@class='erro erro-type-cnpj']"));
    }
    
    public Bmouaajm_Elemento obterMensagemErroCpfCnpjEc() {
        return body().procurarElemento(By.xpath("//div[@class='erro erro-type-cpf-cnpj']"));
    }

}
