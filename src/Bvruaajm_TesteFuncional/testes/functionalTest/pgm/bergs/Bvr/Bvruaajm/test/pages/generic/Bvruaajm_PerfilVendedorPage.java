package bergs.Bvr.Bvruaajm.test.pages.generic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_PerfilVendedorPage extends Bmouaajm_PaginaBase {


    public Bvruaajm_PerfilVendedorPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    @Override
    protected boolean estaPronto() {
        return false;
    }

    public Bmouaajm_Elemento obterBotaoReceberPagamento() {
        return body().procurarElemento(By.id("bvr-pv-li-receber"));
    }

    public Bmouaajm_Elemento obterBotaoConsultarVendas() {
        return body().procurarElemento(By.id("bvr-pv-li-ver-vendas"));
    }

    public Bmouaajm_Elemento obterTituloOqueDesejaFazer() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-pv-menu']/h2"));
    }

    public Bmouaajm_Elemento obterTituloPageReceberPagamento() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-pv-receber']/h2"), Duration.ofSeconds(5));
    }

    public Bmouaajm_Elemento obterBotaoLinkPefilVendedor() {
        return body().procurarElemento(By.id("bvr-pv-li-vender-link-pgto"));
    }
    
    public Bmouaajm_Elemento obterCaixaDeTextoConsultaVendas() {
        return body().procurarElemento(By.id("bvr-pv-vendas-pesquisa-input"));
    }
    
    public Bmouaajm_Elemento obterTxtPesquisaSemResultado() {
        return body().procurarElemento(By.id("div-texto-busca-sem-resultado"));
    }
    
    public Bmouaajm_Elemento obterResultaDaPesquisaFiltro() {
        return body().procurarElemento(By.xpath("//div[@class='ds-u-label-medium-normal']//span[@class='bvr-ds-color-action']"));
    }
    
    public Bmouaajm_Elemento obterVendaConsultaVendasPerfilVendedor(String nome) {
        return body().procurarElemento(By.xpath("//span[contains(text(), '" + nome + "')]"));
    }
    
    public Bmouaajm_Elemento obterStatusDePgtoDetalhesConsultaPerfilVendesdor() {
        return body().procurarElemento(By.xpath("//div[@class='dv-cv-status-format']//span"));
    }
    
    public Bmouaajm_Elemento obterTipoPgtoDetalhesConsultaPerfilVendesdor() {
        return body().procurarElemento(By.xpath("//div[@id='div-cv-pagamento-completo']//div[@mm-html='forma_de_pagamento']"));
    }
    
    public Bmouaajm_Elemento obterBotaoAtualizarVendasHoje() {
        return body().procurarElemento(By.id("bvr-pv-atualizar-hoje"));
    }
}
