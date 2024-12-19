package bergs.Bvr.Bvruaajm.test.pages.mm.menuLateral;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;

public class Bvruaajm_MenuLateralMMPage extends Bmouaajm_PaginaBase{

    public Bvruaajm_MenuLateralMMPage(RemoteWebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean estaPronto() {
        return false;
    }
    
    public Bmouaajm_Elemento obterBotaoGestao() {
        return body().procurarElemento(By.xpath("//div[@title='Gestão']"));
    }
    
    public Bmouaajm_Elemento obterBotaoProduto() {
        return body().procurarElemento(By.xpath("//div[@title='Produtos']"));
    }
    
    public Bmouaajm_Elemento obterBotaoGestaoConsolidadoApp() {
        return body().procurarElemento(By.xpath("//div[@title='Consolidado Do App']"));
    }
        
    public Bmouaajm_Elemento obterBotaoGestaoResumoEventos() {
        return body().procurarElemento(By.xpath("//div[@title='Resumo De Eventos']"));
    }
    
    public Bmouaajm_Elemento obterBotaoGestaoAnaliseEventos() {
        return body().procurarElemento(By.xpath("//div[@title='Análise De Eventos']"));
    }
    
    public Bmouaajm_Elemento obterBotaoGestaoConsultaIncluirUser() {
        return body().procurarElemento(By.xpath("//div[@title='Consultar E Incluir Usuários']"));
    }
    
    public Bmouaajm_Elemento obterBotaoGestaoCriarConsultaNotificacao() {
        return body().procurarElemento(By.xpath("//div[@title='Criar Ou Consultar Notificações']"));
    }

    public Bmouaajm_Elemento obterBotaoProdutosVeroXWallet() {
        return body().procurarElemento(By.xpath("//div[@title='Verox E Vero Wallet']"));
    }
    
    public Bmouaajm_Elemento obterBotaoProdutoVeroXWalletGerarQrCode() {
        return body().procurarElemento(By.xpath("//div[@title='Gerar Qrcode']"));
    }

    public Bmouaajm_Elemento obterBotaoProdutoLinkPgto() {
        return body().procurarElemento(By.xpath("//div[@title='Link De Pagamento']"));
    }
    
    public Bmouaajm_Elemento obterBotaoDadosCriacaoLinkPgto() {
        return body().procurarElemento(By.xpath("//div[@title='Dados De Criação Do Link']"));
    }
    
    public Bmouaajm_Elemento obterBotaoDadosTransacaoLinkPgto() {
        return body().procurarElemento(By.xpath("//div[@title='Dados De Transações Do Link']"));
    }
    
    public Bmouaajm_Elemento obterBotaoGerenciaLimiteLinkPgto() {
        return body().procurarElemento(By.xpath("//div[@title='Gerenciamento De Limites']"));
    }
    
}
