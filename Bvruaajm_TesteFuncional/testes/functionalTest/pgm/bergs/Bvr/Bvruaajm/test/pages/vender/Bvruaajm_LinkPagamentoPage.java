package bergs.Bvr.Bvruaajm.test.pages.vender;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_LinkPagamentoPage extends Bmouaajm_PaginaBase {

    Bvruaajm_Esperas esperas;

    public Bvruaajm_LinkPagamentoPage(AppiumDriver<WebElement> driver) {
        super(driver);
        esperas = new Bvruaajm_Esperas(driver);
    }

    @Override
    protected boolean estaPronto() {
        return true;
    }

    public Bmouaajm_Elemento obterBotaoCriarLink() {
        return body().procurarElemento(By.id("bvr-ve-vender-link-novo"));
    }

    public Bmouaajm_Elemento obterBotaoConsultarLinksCriados() {
        return body().procurarElemento(By.id("bvr-ve-vender-link-lista"));
    }

    public Bmouaajm_Elemento obterCampoValorLink() {
        return body().procurarElemento(By.id("bvr-ve-valor-texto"));
    }

    public Bmouaajm_Elemento obterBotaoContinuarLink() {
        return body().procurarElemento(By.id("bvr-ve-valor-salvar"));
    }

    public Bmouaajm_Elemento obterBotaoCreditoAVistaLink() {
        return body().procurarElemento(By.id("bvr-ve-formapagamento-credito-vista"));
    }

    public Bmouaajm_Elemento obterBotaoCreditoParceladoLink() {
        return body().procurarElemento(By.id("bvr-ve-formapagamento-credito-parcelado"));
    }

    public Bmouaajm_Elemento obterBotaoCriarLinkPagamento() {
        return body().procurarElemento(By.id("bvr-ve-resumo-continuar"));
    }

    public Bmouaajm_Elemento obterBotaoEditarValorVendaLink() {
        return body().procurarElemento(By.id("bvr-ve-resumo-edita-valor"));
    }

    public Bmouaajm_Elemento obterBotaoEditarFormaPagamentoLink() {
        return body().procurarElemento(By.id("bvr-ve-resumo-edita-pagamento"));
    }

    public Bmouaajm_Elemento obterBotaoInserirDescricaoLink() {
        return body().procurarElemento(By.id("bvr-ve-resumo-edita-descricao"));
    }

    public Bmouaajm_Elemento obterIconeSucesso() {
        return body().procurarElemento(By.id("bvr-ve-link-sucesso"));
    }

    public Bmouaajm_Elemento obterMeiaModalAvaliacaoLink() {
        return body().procurarElemento(By.id("artInfo"));
    }

    public Bmouaajm_Elemento obterEstrelaAvaliacaoConformeQtdIndicada(String estrela) {
        return body().procurarElemento(By.id("star" + estrela));
    }

    public Bmouaajm_Elemento obterTextoOquePodemosMelhorarAvaliacaoLink() {
        return body().procurarElemento(By.cssSelector("#artInfo .js-negativo"));
    }

    public Bmouaajm_Elemento obterTextoLegalAvaliacaoLink() {
        return body().procurarElemento(By.cssSelector("#artInfo .js-positivo"));
    }

    public Bmouaajm_Elemento obterCampoDescricaoAvaliacao() {
        return body().procurarElemento(By.id("txtDissertativa"));
    }

    public Bmouaajm_Elemento obterBotaoEnviarAvaliacao() {
        return body().procurarElemento(By.id("btnSubmit"));
    }

    public Bmouaajm_Elemento obterUrlLinkPgto() {
        esperas.visibilidadeDoElemento(By.id("bvr-ve-li-link"));
        return body().procurarElemento(By.id("bvr-ve-li-link"));
    }

    public List<Bmouaajm_Elemento> obterPerguntasFaqLinkPagamento() {
        return body().procurarElementos(By.cssSelector("#bvr-lista-faq-link .bvr-faq-pergunta span"));
    }

    public Bmouaajm_Elemento obterTextoInicialPesquisaFaqLinkPagamento() {
        return body().procurarElemento(By.id("bvr-pesquisa-faqlink-filtro-vazio"));
    }

    public Bmouaajm_Elemento obterCampoPesquisaFaqLinkPagamento() {
        return body().procurarElemento(By.id("bvr-input-pesquisa-faqlink"));
    }

    public Bmouaajm_Elemento obterTextoSemResultadoPesquisaFaqLinkPgto() {
        return body().procurarElemento(By.id("bvr-pesquisa-faqlink-sem-resultado"));
    }

    public Bmouaajm_Elemento obterTextoResultadoPesquisaFaqLinkPgto() {
        return body().procurarElemento(By.xpath("//ul[@id='bvr-lista-faq-link']//span[@class='bvr-texto-destacado']"));
    }

    public Bmouaajm_Elemento obterTextoValorResumoLinkPgto() {
        return body().procurarElemento(By.id("bvr-ve-resumo-valor"));
    }

    public Bmouaajm_Elemento obterListaDeParcelasLinkPgto() {
        esperas.visibilidadeDoElemento(By.id("lista-parcela-link-pagamento"), 10);
        return body().findElement(By.id("lista-parcela-link-pagamento"));
    }

    public List<Bmouaajm_Elemento> obterNumeroDeParcelasLinkPgto() {
        return body().procurarElementos(By.xpath("//ul[@id='lista-parcela-link-pagamento']/li"));
    }

    public Bmouaajm_Elemento valorDaParcela(Bmouaajm_Elemento element) {
        return element.findElement(By.cssSelector(".ds-u-caption-normal-sub"));
    }

    public Bmouaajm_Elemento obterTextoFormaPagamentoResumoLink() {
        return body().procurarElemento(By.id("bvr-ve-resumo-forma-pagamento"));
    }

    public Bmouaajm_Elemento obterCampoDescricaoVenda() {
        return body().procurarElemento(By.id("bvr-ve-descricao-input"));
    }

    public Bmouaajm_Elemento obterBotaoSalvarDescricao() {
        return body().procurarElemento(By.id("bvr-ve-descricao-salvar"));
    }

    public Bmouaajm_Elemento obterTextoDescricaoTelaRusumo() {
        return body().procurarElemento(By.id("bvr-ve-resumo-descricao"));
    }

    public Bmouaajm_Elemento obterBotaoSalvarParcelas() {
        return body().procurarElemento(By.id("bvr-ve-parcela-continuar"));
    }

    public Bmouaajm_Elemento obterEditarDataExpiracao() {
        return body().procurarElemento(By.id("bvr-ve-resumo-edita-expiracao"));
    }

    public List<Bmouaajm_Elemento> obterDataExpiracao() {
        return body().procurarElementos(By.xpath("//ul[@id='lista-expiracao-link-pagamento']/li"));
    }

    public Bmouaajm_Elemento obterBotaoSalvarExpiracao() {
        return body().procurarElemento(By.id("bvr-ve-expiracao-salvar"));
    }

    public Bmouaajm_Elemento obterTextoData() {
        return body().procurarElemento(By.id("bvr-ve-resumo-expiracao"));
    }

    public Bmouaajm_Elemento obterTextoModalFalhaComunicacaoLink() {
        return body().procurarElemento(By.xpath(
                "//div[@class='bvr-ds2-modal-conteudo']//div[@class='bvr-ds2-modal-texto bvr-caixa-texto bvr-caixa-48 bvr-ds2-margin-bottom-24 ds-u-text-medium-sub-normal']"));
    }

    public Bmouaajm_Elemento obterTextoSolicitacaoEnviada() {
        return body().procurarElemento(By.xpath(
                "//div[@class='bvr-ds3-modal-conteudo']/div[@class='bvr-ds3-modal-titulo ds-u-title-normal bvr-ds2-margin-bottom-16 bvr-ds3-modal-texto-centrado']"));
    }

    public Bmouaajm_Elemento obterBotaoEntendiSolicitacaoEnviada() {
        return body().procurarElemento(By.xpath("//ds-button[@label='Entendi' and @class]"));
    }

    public Bmouaajm_Elemento obterBtnSalvarValor() {
        return body().procurarElemento(By.id("bvr-ve-valor-salvar"));
    }

    public Bmouaajm_Elemento obterCheckboxTermoAdesaoLinkPgto() {
        return body().procurarElemento(By.xpath("//label[@for='bvr-ta-checkbox']"));
    }

    public Bmouaajm_Elemento obterBotaoNaoAderirLinkPgto() {
        return body().procurarElemento(By.id("bvr-ta-nao-quero-aderir"));
    }

    public Bmouaajm_Elemento obterBotaoAderirAoLinkPgtoLiAceito() {
        return body().procurarElemento(By.id("bvr-ta-avancar"));
    }

    public Bmouaajm_Elemento obterTextoDicaAceiteTermoLinkPgto() {
        return body().procurarElemento(By.id("bvr-valor-link-dica"));
    }

    public Bmouaajm_Elemento obterTextoTituloParcelaMinima() {
        return body().procurarElemento(By.id("bvr-titulo-aviso-parcela-minima"));
    }

    public Bmouaajm_Elemento obterBotaoEntendiParcelaMinima() {
        return body().procurarElemento(By.id("bvr-apm-entendi"));
    }

    public Bmouaajm_Elemento obterBotaoSaibaMaisComoReceber() {
        return body().procurarElemento(By.id("bvr-lp-btn-saiba-mais"));
    }

    public Bmouaajm_Elemento obterTextoSaibaMaisComoReceber() {
        return body().procurarElemento(By.id("bvr-texto-info"));
    }
    
    public Bmouaajm_Elemento obterMensagemErroLimite() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-ve-container-valor']//span"));
    }
}
