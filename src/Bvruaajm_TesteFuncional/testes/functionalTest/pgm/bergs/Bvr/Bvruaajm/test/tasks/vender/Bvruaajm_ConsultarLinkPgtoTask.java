package bergs.Bvr.Bvruaajm.test.tasks.vender;

import java.time.LocalDateTime;
import java.util.List;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.generic.Bvruaajm_GenericPage;
import bergs.Bvr.Bvruaajm.test.pages.generic.Bvruaajm_PerfilVendedorPage;
import bergs.Bvr.Bvruaajm.test.pages.vender.Bvruaajm_ConsultarLinkPgtoPage;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_ElementoNativoTask;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Formatador;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.validations.Bvruaajm_GenericValidation;
import bergs.Bvr.Bvruaajm.test.validations.vender.Bvruaajm_ConsultaLinkPgtoValidation;
import bergs.Bvr.Bvruaajm.test.validations.vender.Bvruaajm_LinkPagamentoValidation;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_ConsultarLinkPgtoTask extends Bvruaajm_TaskMobile {

    Bvruaajm_ConsultarLinkPgtoPage consultaLinkPage;
    Bvruaajm_ElementoNativoTask nativoTask;
    Bvruaajm_ConsultaLinkPgtoValidation consultaLinkValidation;
    Bvruaajm_LinkPagamentoValidation linkValidation;
    Bvruaajm_LinkPagamentoTask linkTask;
    Bvruaajm_GenericValidation genericValidation;
    Bvruaajm_PerfilVendedorPage perfilVendedorPage;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_GenericPage genericPage;
    Bvruaajm_Esperas esperas;
    String creditoParcelado = "Crédito parcelado em até 4x";
    String debito = "Débito";
    String excluirLink = "Você deseja confirmar a exclusão deste link?";
    String confirmaExclusao = "Após a exclusão, não será possível acessar esse link novamente.";
    String desbloquearLink = "Você confirma o desbloqueio deste link?";
    String confirmaDesbloquearLink = "Este link foi bloqueado por exceder as tentativas de pagamento.";
    String confirmaCancelamentoLink = "Você deseja confirmar o cancelamento desta venda?";
    String alertaCancelamentoLink = "Esta ação não poderá ser revertida.";
    String vendaCancelada = "Venda cancelada!";
    String cancelamentoComSucesso = "Esta venda foi cancelada com sucesso.";

    public Bvruaajm_ConsultarLinkPgtoTask(AppiumDriver<WebElement> driver) {
        super(driver);
        consultaLinkPage = new Bvruaajm_ConsultarLinkPgtoPage(driver);
        nativoTask = new Bvruaajm_ElementoNativoTask(driver);
        consultaLinkValidation = new Bvruaajm_ConsultaLinkPgtoValidation(driver);
        linkValidation = new Bvruaajm_LinkPagamentoValidation(driver);
        linkTask = new Bvruaajm_LinkPagamentoTask(driver);
        genericValidation = new Bvruaajm_GenericValidation(driver);
        perfilVendedorPage = new Bvruaajm_PerfilVendedorPage(driver);
        jsExecutor = new Bvruaajm_JsExecutor(driver);
        genericPage = new Bvruaajm_GenericPage(driver);
        esperas = new Bvruaajm_Esperas(driver);
    }

    public void validaDetalhesLinkPgtoAtivo(String codigoLink, double valor) {
        acessarDetalhesDoLink(codigoLink);
        String valorFormatado = Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valor);
        consultaLinkValidation.validaTelaDetalhesLinkAtivo(valorFormatado);
        nativoTask.clicarBotaoEsquerdo();
        consultaLinkValidation.validaLinkPgtoEstaVisivel(codigoLink);
    }

    public void validarDetalhesLinkpgtoAtivoParceladoComDescricao(String codigoLink, double valor, String descricao) {
        acessarDetalhesDoLink(codigoLink);
        String valorFormatado = Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valor);
        consultaLinkValidation.validaTelaDetalhesLinkAtivo(valorFormatado);
        genericValidation.validarTextosEsperadoEAtual(creditoParcelado, consultaLinkPage.obterFormaDePagamento().obterTexto());
        genericValidation.validarTextosEsperadoEAtual(descricao, consultaLinkPage.obterDescricaoDetalheDoLink().obterTexto());
        nativoTask.clicarBotaoEsquerdo();
        consultaLinkValidation.validaLinkPgtoEstaVisivel(codigoLink);
    }

    public void validaDetalhesLinkPgtoPago(String codigoLink, double valor, String nome, LocalDateTime data) {
        acessarDetalhesDoLink(codigoLink);
        String valorFormatado = Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valor);
        String nomeFormatado = Bvruaajm_Formatador.formatarNomeAbreviar(nome);
        consultaLinkPage.obterIconMaisMenosInfoDetalheCartaoLinkPgto().clicar();
        consultaLinkValidation.validaTelaDetalhesLinkPago(valorFormatado, nomeFormatado,
                Bvruaajm_Formatador.obterDataAtualFormatadaDetalhamentoLink(data));
        nativoTask.clicarBotaoEsquerdo();
        consultaLinkValidation.validaLinkPgtoEstaVisivel(codigoLink);
    }
    
    public void validaDetalhesLinkPgtoPagoDebito(String codigoLink, double valor) {
        String valorFormatado = Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valor);
        acessarDetalhesDoLink(codigoLink);
        consultaLinkPage.obterIconMaisMenosInfoDetalheCartaoLinkPgto().clicar();
        genericValidation.validarTextosEsperadoEAtual(valorFormatado, consultaLinkPage.obterValorDetalheDoLink().obterTexto());
        genericValidation.validarTextosEsperadoEAtual(debito, consultaLinkPage.obterFormaDePagamento().obterTexto());
        nativoTask.clicarBotaoEsquerdo();
        consultaLinkValidation.validaLinkPgtoEstaVisivel(codigoLink);
    }

    public void validaDetalhesLinkPgtoCancelamentoMaisDeUmDia(String codigoLink, double valor, String nome, LocalDateTime data) {
        acessarDetalhesDoLink(codigoLink);
        String valorFormatado = Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valor);
        String nomeFormatado = Bvruaajm_Formatador.formatarNomeAbreviar(nome);
        consultaLinkPage.obterIconMaisMenosInfoDetalheCartaoLinkPgto().clicar();
        consultaLinkValidation.validaTelaDetalhesLinkPago(valorFormatado, nomeFormatado,
                Bvruaajm_Formatador.obterDataAtualFormatadaDetalhamentoLink(data));
        genericValidation.validaElementoEstaDesabilitado(consultaLinkPage.obterBotaoCancelarPgtoLinkDesabialitado());
    }

    public void validaDetalhesLinkPgtoInfoCancelamentoDesabilitado(String codigoLink, double valor, String nome, LocalDateTime data, String infoContato,
            String tituloContato) {
        acessarDetalhesDoLink(codigoLink);
        String valorFormatado = Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valor);
        String nomeFormatado = Bvruaajm_Formatador.formatarNomeAbreviar(nome);
        consultaLinkPage.obterIconMaisMenosInfoDetalheCartaoLinkPgto().clicar();
        consultaLinkValidation.validaTelaDetalhesLinkPago(valorFormatado, nomeFormatado,
                Bvruaajm_Formatador.obterDataAtualFormatadaDetalhamentoLink(data));
        genericValidation.validarTextosEsperadoEAtual(infoContato, consultaLinkPage.obterTextoinfoComoCancelarFaleComAVero().obterTexto());
        consultaLinkPage.obterBotaoContato().clicar();
        genericValidation.validarTextosEsperadoEAtual(tituloContato, genericPage.obterTituloContatoVero().obterTexto());
    }

    public void validaDetalhesLinkPgtoExpirado(String codigoLink) {
        acessarDetalhesDoLink(codigoLink);
        consultaLinkValidation.validaTelaDetalhesLinkExpirado();
        consultaLinkPage.obterBotaoCriarNovoDetalhesLinkPgto().clicar();
        linkValidation.validarCampoValorEstaVisivel();
    }

    public void validaDetalhesLinkPgtoBloqueado(String codigoLink) {
        acessarDetalhesDoLink(codigoLink);
        consultaLinkValidation.validaTelaDetalhesLinkBloqueado();
        nativoTask.clicarBotaoEsquerdo();
        consultaLinkValidation.validaLinkPgtoEstaVisivel(codigoLink);
    }

    public void validaDetalhesLinkPgtoCancelado(String codigoLink, double valor, String nome, LocalDateTime data) {
        acessarDetalhesDoLink(codigoLink);
        String valorFormatado = Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valor);
        String nomeFormatado = Bvruaajm_Formatador.formatarNomeAbreviar(nome);
        consultaLinkPage.obterIconMaisMenosInfoDetalheCartaoLinkPgto().clicar();
        consultaLinkValidation.validaTelaDetalhesLinkCancelado(valorFormatado, nomeFormatado,
                Bvruaajm_Formatador.obterDataAtualFormatadaDetalhamentoLink(data));
        nativoTask.clicarBotaoEsquerdo();
        consultaLinkValidation.validaLinkPgtoEstaVisivel(codigoLink);
    }

    public void validaExclusaoLinkPgtoExpirado(String codLink, String statusLink) {
        acessarDetalhesDoLink(codLink);
        consultaLinkPage.obterBotaoExcluirLinkPgtoExpirado().clicar();
        consultaLinkValidation.validaBotoesMeiaModalExclusaoLinkVisivel();
        consultaLinkPage.obterBotaoSecundarioMeiaModalNaoCancelar().clicar();
        genericValidation.validarTextosEsperadoEAtual(statusLink, consultaLinkPage.obterStatusDetalheDoLink().obterTexto());
        jsExecutor.scrollIntoView(consultaLinkPage.obterBotaoExcluirLinkPgtoExpirado());
        consultaLinkPage.obterBotaoExcluirLinkPgtoExpirado().clicar();
        genericValidation.validarTextosEsperadoEAtual(excluirLink, consultaLinkPage.obterTituloMeiaModalDinamicaAcao().obterTexto());
        genericValidation.validarTextosEsperadoEContains(confirmaExclusao, consultaLinkPage.obterDescricaoMeiaModalDinamicaAcao().obterTexto());
        consultaLinkPage.obterBotaoPrimarioMeiaModalExcluirLink().clicar();
        nativoTask.clicarBotaoEsquerdo();
        linkTask.clicarBotaoConsultarLinkPgto();
        consultaLinkValidation.validaLinkExcluidoNaLista(codLink);
    }

    public void validaExclusaoLinkPgtoAtivo(String codLink, String statusLink) {
        nativoTask.clicarBotaoEsquerdo();
        linkTask.clicarBotaoConsultarLinkPgto();
        consultaLinkPage.obterLinkPgtoPorCodigo(codLink).clicar();
        consultaLinkPage.obterBotaoExcluirLinkPgtoAtivo().clicar();
        consultaLinkValidation.validaBotoesMeiaModalExclusaoLinkVisivel();
        consultaLinkPage.obterBotaoSecundarioMeiaModalNaoCancelar().clicar();
        genericValidation.validarTextosEsperadoEAtual(statusLink, consultaLinkPage.obterStatusDetalheDoLink().obterTexto());
        jsExecutor.scrollIntoView(consultaLinkPage.obterBotaoExcluirLinkPgtoAtivo());
        consultaLinkPage.obterBotaoExcluirLinkPgtoAtivo().clicar();
        genericValidation.validarTextosEsperadoEAtual(excluirLink, consultaLinkPage.obterTituloMeiaModalDinamicaAcao().obterTexto());
        genericValidation.validarTextosEsperadoEContains(confirmaExclusao, consultaLinkPage.obterDescricaoMeiaModalDinamicaAcao().obterTexto());
        consultaLinkPage.obterBotaoPrimarioMeiaModalExcluirLink().clicar();
        consultaLinkValidation.validaLinkExcluidoNaLista(codLink);
    }

    public void validaDesbloqueioLinkPgto(String codLink, double valor) {
        acessarDetalhesDoLink(codLink);
        consultaLinkValidation.validaTelaDetalhesLinkBloqueado();
        jsExecutor.scrollIntoView(consultaLinkPage.obterBotaoDesbloquearLink());
        consultaLinkPage.obterBotaoDesbloquearLink().clicar();
        genericValidation.validarTextosEsperadoEAtual(desbloquearLink, consultaLinkPage.obterTituloMeiaModalDinamicaAcao().obterTexto());
        genericValidation.validarTextosEsperadoEContains(confirmaDesbloquearLink, consultaLinkPage.obterDescricaoMeiaModalDinamicaAcao().obterTexto());
        consultaLinkPage.obterBotaoMeiaModalSimDesbloqearLink().clicar();
        String valorFormatado = Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valor);
        esperas.aguardarTextoProcessandoDesaparecer();
        consultaLinkValidation.validaTelaDetalhesLinkAtivo(valorFormatado);
        nativoTask.clicarBotaoEsquerdo();
        consultaLinkValidation.validaLinkPgtoEstaVisivel(codLink);
    }

    public void validaDetalheBloqueioLink(String codLink, double valor, String descStatus, String descDetalBloq) {
        acessarDetalhesDoLink(codLink);
        genericValidation.validarTextosEsperadoEAtual(descStatus, consultaLinkPage.obterStatusDetalheDoLink().obterTexto());
        jsExecutor.scrollIntoView(consultaLinkPage.obterExibirMaiMenosDetalhesBloqueio());
        consultaLinkPage.obterExibirMaiMenosDetalhesBloqueio().clicar();
        esperas.aguardarTextoProcessandoDesaparecer();
        genericValidation.validarTextosEsperadoEAtual(descDetalBloq, consultaLinkPage.obterDescUltimoDetalhesBloqLink().obterTexto());
        nativoTask.clicarBotaoEsquerdo();
        consultaLinkValidation.validaLinkPgtoEstaVisivel(codLink);

    }

    public void validaTentativaSegundoDesbloqueio(String codLink) {
        acessarDetalhesDoLink(codLink);
        consultaLinkValidation.validaTelaDetalhesLinkBloqueado();
        jsExecutor.scrollIntoView(consultaLinkPage.obterBotaoDesbloquearLink());
        genericValidation.validaElementoEstaDesabilitado(consultaLinkPage.obterBotaoDesbloquearLink());
        nativoTask.clicarBotaoEsquerdo();
    }

    public void validaTabLinkPgtoBloqueado(String codLink, int tabFiltros) {
        acessarDetalhesLinkPeloFiltro(tabFiltros);
        consultaLinkPage.obterLinkPgtoPorCodigo(codLink).clicar();
        consultaLinkValidation.validaTelaDetalhesLinkBloqueado();
        nativoTask.clicarBotaoEsquerdo();
        consultaLinkValidation.validaLinkPgtoEstaVisivel(codLink);
    }

    public void validaDebloqueioDoLinkMudancaTabParaTodos(String codLink, int tabFiltros) {
        acessarDetalhesLinkPeloFiltro(tabFiltros);
        consultaLinkValidation.validaLinkPgtoEstaVisivel(codLink);
        consultaLinkPage.obterLinkPgtoPorCodigo(codLink).clicar();
        consultaLinkPage.obterBotaoDesbloquearLink().clicar();
        consultaLinkPage.obterBotaoMeiaModalSimDesbloqearLink().clicar();
        nativoTask.clicarBotaoEsquerdo();
        consultaLinkValidation.validaLinkPgtoNaoEstaVisivel(codLink);
        List<Bmouaajm_Elemento> tabFiltroConsulta = consultaLinkPage.obterTabFiltros();
        tabFiltroConsulta.get(0).clicar();
        consultaLinkValidation.validaLinkPgtoEstaVisivel(codLink);
    }

    public void validaCancelamentoLinkPago(String codLink) {
        acessarDetalhesDoLink(codLink);
        consultaLinkPage.obterBotaoCancelarPgtoLink().clicar();
        genericValidation.validarTextosEsperadoEAtual(confirmaCancelamentoLink, consultaLinkPage.obterTituloMeiaModalDinamicaAcao().obterTexto());
        genericValidation.validarTextosEsperadoEAtual(alertaCancelamentoLink, consultaLinkPage.obterDescricaoMeiaModalDinamicaAcao().obterTexto());
        consultaLinkPage.obterBotaoPrimarioMeiaModalCancelarLink().clicar();
        esperas.aguardarTextoProcessandoDesaparecer();
        genericValidation.validarTextosEsperadoEAtual(vendaCancelada, consultaLinkPage.obterTituloMeiaModalDinamicaAcao().obterTexto());
        genericValidation.validarTextosEsperadoEAtual(cancelamentoComSucesso, consultaLinkPage.obterDescricaoMeiaModalDinamicaAcao().obterTexto());
        consultaLinkPage.obterBotaoMeiaModalEntendi().clicar();
        nativoTask.clicarBotaoEsquerdo();
        consultaLinkValidation.validaLinkPgtoEstaVisivel(codLink);
    }
    
    public void validaDetalheLinkAcessoPelaNotificacao(double valor, String descStatus) {
        String valorFormatado = Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valor);
        genericValidation.validarTextosEsperadoEAtual(valorFormatado, consultaLinkPage.obterValorDetalheDoLink().obterTexto());
        genericValidation.validarTextosEsperadoEAtual(descStatus, consultaLinkPage.obterStatusDetalheDoLink().obterTexto());
    }
    
    public String acessarDetalhesLinkPgtoPagoEObterNsu(String codigoLink) {
        acessarDetalhesDoLink(codigoLink);
        consultaLinkPage.obterIconMaisMenosInfoDetalheCartaoLinkPgto().clicar();
        String nsu = consultaLinkPage.obterNsuPagamentoDetalheLinkPgto().obterTexto();
        nativoTask.clicarBotaoEsquerdo();
        return nsu;
    }

    /** METODOS PRIVADOS **/

    private void acessarDetalhesDoLink(String codigoLink) {
        nativoTask.clicarBotaoEsquerdo();
        if (consultaLinkValidation.validaSeEstaNoPerfilVendedor()) {
            perfilVendedorPage.obterBotaoLinkPefilVendedor().clicar();
        }
        linkTask.clicarBotaoConsultarLinkPgto();
        consultaLinkPage.obterLinkPgtoPorCodigo(codigoLink).clicar();
    }

    private void acessarDetalhesLinkPeloFiltro(int tabFiltros) {
        nativoTask.clicarBotaoEsquerdo();
        if (consultaLinkValidation.validaSeEstaNoPerfilVendedor()) {
            perfilVendedorPage.obterBotaoLinkPefilVendedor().clicar();
        }
        linkTask.clicarBotaoConsultarLinkPgto();
        List<Bmouaajm_Elemento> tabFiltroConsulta = consultaLinkPage.obterTabFiltros();
        tabFiltroConsulta.get(tabFiltros - 1).clicar();
    }

}
