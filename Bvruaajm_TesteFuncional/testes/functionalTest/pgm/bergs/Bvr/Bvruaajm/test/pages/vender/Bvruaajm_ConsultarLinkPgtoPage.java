package bergs.Bvr.Bvruaajm.test.pages.vender;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_ConsultarLinkPgtoPage extends Bmouaajm_PaginaBase {

    Bvruaajm_Esperas esperas;

    public Bvruaajm_ConsultarLinkPgtoPage(AppiumDriver<WebElement> driver) {
        super(driver);
        esperas = new Bvruaajm_Esperas(driver);
    }

    @Override
    protected boolean estaPronto() {
        return obterListaLinksCriados().estaVisivel();
    }

    public Bmouaajm_Elemento obterListaLinksCriados() {
        return body().procurarElemento(By.id("bvr-resultado-lista-link"));
    }

    public Bmouaajm_Elemento obterLinksAtivosAbaSuperior() {
        return body().procurarElemento(By.cssSelector("label[for='rd-lista-link-ativos']"));
    }

    public Bmouaajm_Elemento obterLinksPagosAbaSuperior() {
        return body().procurarElemento(By.cssSelector("label[for='rd-lista-link-pagos']"));
    }

    public Bmouaajm_Elemento obterLinksExpiradosAbaSuperior() {
        return body().procurarElemento(By.cssSelector("label[for='rd-lista-link-expirados']"));
    }

    public Bmouaajm_Elemento obterTodosLinksAbaSuperior() {
        return body().procurarElemento(By.cssSelector("label[for='rd-lista-link-todos']"));
    }

    public Bmouaajm_Elemento obterChevronPrimeiroLinkLista() {
        return body().procurarElemento(By.className("bvr-lista-link-chevron"));
    }

    public Bmouaajm_Elemento obterLinkPgtoPorCodigo(String idLink) {
        return body().procurarElemento(By.xpath("//ul[@id='ul-lista-link']/li[contains(@data-link, 'cod_link_pgto\":\"" + idLink + "')]"), Duration.ofSeconds(10));
    }

    public Bmouaajm_Elemento obterTituloDetalheDoLink() {
        return body().procurarElemento(By.id("bvr-detalhe-link-informacoes"));
    }

    public Bmouaajm_Elemento obterStatusDetalheDoLink() {
        return body().procurarElemento(By.id("bvr-detalhe-link-status"));
    }

    public Bmouaajm_Elemento obterValorDetalheDoLink() {
        return body().procurarElemento(By.id("bvr-detalhe-link-valor"));
    }

    public Bmouaajm_Elemento obterFormaDePagamento() {
        return body().procurarElemento(By.id("bvr-detalhe-link-forma-de-pagamento"));
    }

    public Bmouaajm_Elemento obterDescricaoDetalheDoLink() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-detalhe-link-descricao']/div[@class='ds-u-text-medium-normal']"));
    }

    public Bmouaajm_Elemento obterBotaoCopiarLinkDetalheDoLink() {
        return body().procurarElemento(By.id("bvr-detalhe-link-ativo-copiar-link"));
    }

    public Bmouaajm_Elemento obterBotaoCompartilharLinkDetalheDoLink() {
        return body().procurarElemento(By.id("bvr-detalhe-link-ativo-compartilhar-link"));
    }

    public Bmouaajm_Elemento obterUrlDetalhesLinkAtivo() {
        return body().procurarElemento(By.id("bvr-detalhe-link-ativo-url"));
    }

    public Bmouaajm_Elemento obterDataPagamentoDetalheLinkPgto() {
        return body().procurarElemento(By.xpath("//div[@id='div-detalhe-link-P']//div[@mm-html='data_hora_transacao_formatado']"));
    }

    public Bmouaajm_Elemento obterNomePagadorDetalheLinkPgtoPago() {
        return body().procurarElemento(By.xpath("//div[@id='div-detalhe-link-P']//div[@mm-html='nome_comprador']"));
    }

    public Bmouaajm_Elemento obterIconMaisMenosInfoDetalheCartaoLinkPgto() {
        return body().procurarElemento(By.id("bvr-detalhe-link-p-mais-menos"));
    }

    public Bmouaajm_Elemento obterNumeroCartaoDetalheLinkPgto() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-detalhe-link-p-mais']//span[@mm-html='cartao_mascarado']"));
    }

    public Bmouaajm_Elemento obterNsuPagamentoDetalheLinkPgto() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-detalhe-link-p-mais']//div[@mm-html='nsu_bergs']"));
    }

    public Bmouaajm_Elemento obterAutorizadorPagamentoDetalheLinkPgto() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-detalhe-link-p-mais']//div[@mm-html='nsu_autorizador']"));
    }

    public Bmouaajm_Elemento obterBotaoCriarNovoDetalhesLinkPgto() {
        return body().procurarElemento(By.id("bvr-detalhe-link-expirado-criar-link"));
    }

    public Bmouaajm_Elemento obterCampoSobreLinkBloqueado() {
        return body().procurarElemento(By.id("div-detalhe-link-B"));
    }

    public Bmouaajm_Elemento obterTituloCampoCancelamento() {
        return body().procurarElemento(By.xpath("//div[@id='div-detalhe-link-C']/div[@class='ds-u-title-normal']"));
    }

    public Bmouaajm_Elemento obterDataCancelamentoDetalheLinkPgto() {
        return body().procurarElemento(By.xpath("//div[@id='div-detalhe-link-C']//div[@mm-html='data_hora_cancelamento']"));
    }

    public Bmouaajm_Elemento obterExibirMaisLinks() {
        return body().procurarElemento(By.id("bvr-lista-link-exibir-mais"));
    }

    public Bmouaajm_Elemento obterBotaoExcluirLinkPgtoExpirado() {
        return body().procurarElemento(By.id("bvr-detalhe-link-expirado-excluir-link"));
    }

    public Bmouaajm_Elemento obterBotaoExcluirLinkPgtoAtivo() {
        return body().procurarElemento(By.id("bvr-detalhe-link-ativo-excluir-link"));
    }

    public Bmouaajm_Elemento obterBotaoPrimarioMeiaModalExcluirLink() {
        return body().procurarElemento(By.xpath("//ds-button[@label='Sim, excluir']"));
    }

    public Bmouaajm_Elemento obterBotaoSecundarioMeiaModalNaoCancelar() {
        return body().procurarElemento(By.xpath("//ds-button[@label='Não, cancelar']"));
    }

    public Bmouaajm_Elemento obterBotaoDesbloquearLink() {
        return body().procurarElemento(By.id("bvr-detalhe-link-B-desbloquear-link"));
    }

    public Bmouaajm_Elemento obterBotaoMeiaModalSimDesbloqearLink() {
        return body().procurarElemento(By.xpath("//ds-button[@label='Sim, desbloquear']"));
    }

    public Bmouaajm_Elemento obterTituloMeiaModalDinamicaAcao() {
        return body().procurarElemento(By.xpath("//div[contains(@id,'bvr-modal-mensagem-')]//div[contains(@class,'bvr-ds3-modal-titulo')]"));
    }

    public Bmouaajm_Elemento obterDescricaoMeiaModalDinamicaAcao() {
        return body().procurarElemento(By.xpath("//div[contains(@id,'bvr-modal-mensagem-')]//div[contains(@class,'ds-u-text-medium-sub-normal')]"));
    }

    public Bmouaajm_Elemento obterDescUltimoDetalhesBloqLink() {
        return body().procurarElemento(By.xpath("//div[@id='div-detalhe-link-hb-1']//div[@mm-html='descHistBloq']"));
    }

    public Bmouaajm_Elemento obterExibirMaiMenosDetalhesBloqueio() {
        return body().procurarElemento(By.id("bvr-detalhe-link-hb-mais-menos"));
    }

    public List<Bmouaajm_Elemento> obterTabFiltros() {
        return body().procurarElementos(By.xpath("//ul[@id='tab-lista-link']/li"));
    }

    public Bmouaajm_Elemento obterBotaoCancelarPgtoLink() {
        return body().procurarElemento(By.id("bvr-detalhe-link-P-cancelar-venda"));
    }
    
    public Bmouaajm_Elemento obterBotaoCancelarPgtoLinkDesabialitado() {
        return body().procurarElemento(By.xpath("//div[@id='div-detalhe-link-P-incancelavel']//ds-button"));
    }

    public Bmouaajm_Elemento obterBotaoPrimarioMeiaModalCancelarLink() {
        return body().procurarElemento(By.xpath("//ds-button[@label='Sim, cancelar']"));
    }
    
    public Bmouaajm_Elemento obterBotaoMeiaModalEntendi() {
        return body().procurarElemento(By.xpath("//ds-button[@class='bvr-ds2-botao-conteudo']"));
    }
    
    public Bmouaajm_Elemento obterTextoinfoComoCancelarFaleComAVero() {
        return body().procurarElemento(By.xpath("//div[@class='bvr-flex-1 ds-u-caption-normal']"));
    }
    
    public Bmouaajm_Elemento obterBotaoContato() {
        return body().procurarElemento(By.id("bvr-detalhe-link-contato"));
    }
    
}
