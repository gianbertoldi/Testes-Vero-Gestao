package bergs.Bvr.Bvruaajm.test.tasks.vender;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.generic.Bvruaajm_GenericPage;
import bergs.Bvr.Bvruaajm.test.pages.generic.Bvruaajm_PerfilVendedorPage;
import bergs.Bvr.Bvruaajm.test.pages.vender.Bvruaajm_LinkPagamentoPage;
import bergs.Bvr.Bvruaajm.test.pages.vender.Bvruaajm_VenderPage;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_ElementoNativoTask;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Formatador;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.validations.Bvruaajm_GenericValidation;
import bergs.Bvr.Bvruaajm.test.validations.vender.Bvruaajm_LinkPagamentoValidation;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_LinkPagamentoTask extends Bvruaajm_TaskMobile {

    Bvruaajm_LinkPagamentoPage linkPage;
    Bvruaajm_Esperas esperar;
    Bvruaajm_LinkPagamentoValidation linkValidation;
    Bvruaajm_ElementoNativoTask nativoTask;
    Bvruaajm_GenericValidation genericValidation;
    Bvruaajm_PerfilVendedorPage perfilVendedorPage;
    Bvruaajm_GenericPage genericPage;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_VenderPage venderPage;
    String pgtoDebito = "Débito";
    String pgtoCreditoVista = "Crédito à vista";
    String palavraChaveFaq = "Utilize palavras-chave para realizar a sua pesquisa.";
    String semResultado = "Não existem resultados para esta pesquisa.";
    String valorMinimoMaximoErro = "O valor do Link de Pagamento deve ser maior que R$ 5,00 e menor que R$ 5000,00.";
    String comoQuerVender = "Como você quer vender?";
    String solicitacaoEnviada = "Solicitação enviada com sucesso";
    String podeVenderViaLink = "Agora você já pode vender via link de pagamento!";
    String avisoParcelaMinima = "Agora o link possui uma parcela mínima de R$ 5,00";

    public Bvruaajm_LinkPagamentoTask(AppiumDriver<WebElement> driver) {
        super(driver);
        linkPage = new Bvruaajm_LinkPagamentoPage(driver);
        nativoTask = new Bvruaajm_ElementoNativoTask(driver);
        esperar = new Bvruaajm_Esperas(driver);
        linkValidation = new Bvruaajm_LinkPagamentoValidation(driver);
        genericValidation = new Bvruaajm_GenericValidation(driver);
        perfilVendedorPage = new Bvruaajm_PerfilVendedorPage(driver);
        jsExecutor = new Bvruaajm_JsExecutor(driver);
        genericPage = new Bvruaajm_GenericPage(driver);
        venderPage = new Bvruaajm_VenderPage(driver);
    }

    /**
     * METODOS PUBLICOS QUE PODEM SER UTILIZADOS
     */
    public String criarLinkPagamento(double valor) {
        iniciarCriacaoLinkPagamentoAVista(valor);
        String url = finalizarCriacaoDoLinkPgto();
        return url;
    }

    public String criarLinkPagamentoParcelado(double valor, int numPacelas, String descricao) {
        criarLinkPgtoInicioParcelado(valor);
        linkPage.obterListaDeParcelasLinkPgto();
        List<Bmouaajm_Elemento> numeroParecela = linkPage.obterNumeroDeParcelasLinkPgto();
        numeroParecela.get((numPacelas - 2)).clicar();
        linkValidation.validarValorDaParcelar(valor, numPacelas);
        linkPage.obterBotaoSalvarParcelas().clicar();
        adicionarDescricaoLinkPgto(descricao);
        String url = finalizarCriacaoDoLinkPgto();
        return url;
    }

    /**
     * metodo para gera um link generico para valicao de links expirados
     */
    public void gerarLinkComExpiracaoEditada(double valor, int expiracao) {
        iniciarCriacaoLinkPagamentoAVista(valor);
        criarlinkExpirado(expiracao);
        finalizarCriacaoDoLinkPgto();
    }

    /**
     * Metodo que gera 3 link pagamento para exibir meia modal de avaliaï¿½ï¿½o
     */
    public List<String> gerarAvaliacaoLinkPagamento(double valor) {
        List<String> codigoLink = new ArrayList<String>();
        for (int i = 0; i < 3; i++) {
            iniciarCriacaoLinkPagamentoAVista(valor);
            finalizarCriacaoDoLinkPgto();
            String var = jsExecutor.obterIdLinkPgtoCriado();
            codigoLink.add(i, var);
            nativoTask.clicarBotaoEsquerdo();
        }
        return codigoLink;
    }

    /**
     * ESSE METODO EFETUA O PROCESSO DE AVALIAï¿½ï¿½O DO LINK QUANDO HOUVER
     */
    public void efetuarAvaliacaoLinkPelaQuantidadeDeEstrela(int estrela, String avaliacao) {
        String stringEstrela = Integer.toString(estrela);
        linkValidation.meiaModalAvaliacaoLinkEstaVisivel();
        linkPage.obterEstrelaAvaliacaoConformeQtdIndicada(stringEstrela).clicar();
        if (estrela < 3) {
            linkValidation.validaTextoMsgAvaliacaoUmaOuDuasEstrelas();
        } else {
            linkValidation.validaTextoMsgAvaliacaoDeTresACincoEstrelas();
        }
        prencherCampoDescricaoAvaliacao(avaliacao);
    }

    public void clicarBotaoConsultarLinkPgto() {
        linkPage.obterBotaoConsultarLinksCriados().clicar();
    }

    /**
     * 
     * OS PROXIMOS METODOS INTERAGEM COM O FAQ
     * 
     * ESSE METODO BUSCAR TODAS AS PERGUNTAS E VALIDA SE A QUANTIDADE ESTï¿½ CORRETA
     * 
     */
    public void validarQuantidadePerguntasFaqLinkPagamento(int qdtPerguntas) {
        nativoTask.clicarBotaoDireito2();
        List<Bmouaajm_Elemento> listaPerguntasFaq = linkPage.obterPerguntasFaqLinkPagamento();
        linkValidation.validarQuantidadePerguntasFaqLink(qdtPerguntas, listaPerguntasFaq.size());
    }

    public void validarPerguntasFaqLinkPagamentoExistente(String pergunta) {
        nativoTask.clicarBotaoDireito2();
        List<Bmouaajm_Elemento> listaPerguntasFaq = linkPage.obterPerguntasFaqLinkPagamento();
        for (int i = 0; i < listaPerguntasFaq.size(); i++) {
            if (listaPerguntasFaq.get(i).obterTexto().contains(pergunta)) {
                genericValidation.validarTextosEsperadoEAtual(pergunta, listaPerguntasFaq.get(i).obterTexto());
                break;
            }
        }
    }

    public void validarTelaComResultadoPesquisaFaqLinkPgto(String textoPesquisa) {
        nativoTask.clicarBotaoDireito2();
        nativoTask.clicarBotaoDireito2();
        linkPage.obterCampoPesquisaFaqLinkPagamento().clicar().preencherLento(textoPesquisa);
        genericValidation.validarTextosEsperadoEAtual(textoPesquisa, linkPage.obterTextoResultadoPesquisaFaqLinkPgto().obterTexto());
    }

    public void validarTelaInicialPesquisaPerguntasFaqLinkPagamento() {
        nativoTask.clicarBotaoDireito2();
        nativoTask.clicarBotaoDireito2();
        genericValidation.validarTextosEsperadoEAtual(palavraChaveFaq, linkPage.obterTextoInicialPesquisaFaqLinkPagamento().obterTexto());
    }

    public void validarTelaSemResultadoPesquisaPerguntasFaqLinkPagamento(String textoPesquisa) {
        nativoTask.clicarBotaoDireito2();
        nativoTask.clicarBotaoDireito2();
        linkPage.obterCampoPesquisaFaqLinkPagamento().clicar().preencherLento(textoPesquisa);
        genericValidation.validarTextosEsperadoEAtual(semResultado, linkPage.obterTextoSemResultadoPesquisaFaqLinkPgto().obterTexto());
    }

    public void validarDefinirDescricaoLinkPgto(double valor, String descricao) {
        iniciarCriacaoLinkPagamentoAVista(valor);
        adicionarDescricaoLinkPgto(descricao);
        genericValidation.validarTextosEsperadoEAtual(descricao, linkPage.obterTextoDescricaoTelaRusumo().obterTexto());
        finalizarCriacaoDoLinkPgto();
    }

    public void validarEditarValorTelaResumoSemSalvar(double valor, double valorEditado) {
        iniciarCriacaoLinkPagamentoAVista(valor);
        linkPage.obterBotaoEditarValorVendaLink().clicar();
        linkPage.obterCampoValorLink().limpar().preencherLento(Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valorEditado));
        nativoTask.clicarBotaoEsquerdo();
        genericValidation.validarTextosEsperadoEAtual(Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valor),
                linkPage.obterTextoValorResumoLinkPgto().obterTexto());
        finalizarCriacaoDoLinkPgto();
    }

    public void validarEditarFormaPagamento(double valor, int numPacelas) {
        iniciarCriacaoLinkPagamentoAVista(valor);
        linkPage.obterBotaoEditarFormaPagamentoLink().clicar();
        linkPage.obterBotaoCreditoParceladoLink().clicar();
        linkPage.obterListaDeParcelasLinkPgto();
        List<Bmouaajm_Elemento> numeroParecela = linkPage.obterNumeroDeParcelasLinkPgto();
        numeroParecela.get((numPacelas - 2)).clicar();
        nativoTask.clicarBotaoEsquerdo();
        nativoTask.clicarBotaoEsquerdo();
        genericValidation.validarTextosEsperadoEAtual(pgtoCreditoVista, linkPage.obterTextoFormaPagamentoResumoLink().obterTexto());
        finalizarCriacaoDoLinkPgto();
    }

    public void validarEditarDescricaoLink(int valor, String descricao, String descricaoAlterada) {
        iniciarCriacaoLinkPagamentoAVista(valor);
        adicionarDescricaoLinkPgto(descricao);
        linkPage.obterBotaoInserirDescricaoLink().clicar();
        linkPage.obterCampoDescricaoVenda().limpar().preencherLento(descricaoAlterada);
        nativoTask.clicarBotaoEsquerdo();
        genericValidation.validarTextosEsperadoEAtual(descricao, linkPage.obterTextoDescricaoTelaRusumo().obterTexto());
        finalizarCriacaoDoLinkPgto();
    }

    public void validarEditarDataExpiracao(int valor, int expiracao, String tempoExpicaoTxt) {
        iniciarCriacaoLinkPagamentoAVista(valor);
        linkPage.obterEditarDataExpiracao().clicar();
        List<Bmouaajm_Elemento> tempoExpiracao = linkPage.obterDataExpiracao();
        tempoExpiracao.get(expiracao - 1).clicar();
        nativoTask.clicarBotaoEsquerdo();
        genericValidation.validarTextosEsperadoEAtual(tempoExpicaoTxt, linkPage.obterTextoData().obterTexto());
        finalizarCriacaoDoLinkPgto();
    }

    public void validarModalValorIncorretoLinkPgto(double valor) {
        iniciarCriacaoLinkPagamentoAVista(valor);
        Bvruaajm_JsExecutor jsExecutor = new Bvruaajm_JsExecutor(driver);
        jsExecutor.alterarValorLinkPgtoTelaResumoLink();
        linkPage.obterBotaoCriarLinkPagamento().clicar();
        genericValidation.validarTextosEsperadoEAtual(valorMinimoMaximoErro, linkPage.obterTextoModalFalhaComunicacaoLink().obterTexto());
    }

    public void validarValorMaximoLinkPgto(double valor, String mensagemErro) {
        linkPage.obterBotaoCriarLink().clicar();
        linkPage.obterCampoValorLink().preencherLento(Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valor));
        jsExecutor.removerFocusElementoAtual();
        genericValidation.validarTextosEsperadoEAtual(mensagemErro, linkPage.obterMensagemErroLimite().obterTexto());
        genericValidation.validaElementoEstaDesabilitado(linkPage.obterBotaoContinuarLink());
    }

    public void validarExpiracaoLinkPgtoSeisHoras(double valor, int expiracao, String tempoExpicaoTxt) {
        iniciarCriacaoLinkPagamentoAVista(valor);
        criarlinkExpirado(expiracao);
        genericValidation.validarTextosEsperadoEAtual(tempoExpicaoTxt, linkPage.obterTextoData().obterTexto());
        finalizarCriacaoDoLinkPgto();
    }

    public void validaSolicitacaoAdesaoEnviada() {
        genericValidation.validarTextosEsperadoEAtual(solicitacaoEnviada, linkPage.obterTextoSolicitacaoEnviada().obterTexto());
        linkPage.obterBotaoEntendiSolicitacaoEnviada().clicar();
        genericValidation.validarTextosEsperadoEAtual(comoQuerVender, venderPage.obterTituloPagina().obterTexto());
    }

    public String obterTextoLinkPgto() {
        return linkPage.obterUrlLinkPgto().obterTexto();
    }

    public void acessarReceberPgtoLinkPefilVendedor() {
        perfilVendedorPage.obterBotaoReceberPagamento().clicar();
        perfilVendedorPage.obterBotaoLinkPefilVendedor().clicar();
    }

    public void acessarLinkPgtoPerfilVendedor() {
        perfilVendedorPage.obterBotaoLinkPefilVendedor().clicar();
    }

    public void criarLinkValorMenorDezReais(Double valor) {
        linkPage.obterBotaoCriarLink().clicar();
        linkPage.obterCampoValorLink().preencherLento(Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valor));
        linkPage.obterBotaoContinuarLink().clicar();
        linkPage.obterBotaoCreditoAVistaLink().clicar();
        genericValidation.validaElementoEstaDesabilitado(linkPage.obterBotaoEditarFormaPagamentoLink());
        finalizarCriacaoDoLinkPgto();
    }

    public void criarLinkPagamentoParceladoMenosQueQuinzeReais(double valor) {
        criarLinkPgtoInicioParcelado(valor);
        finalizarCriacaoDoLinkPgto();
    }

    public void validaQuantidadeDeParcelasDisponiveis(double valor, int numParcelas) {
        criarLinkPgtoInicioParcelado(valor);
        List<Bmouaajm_Elemento> numeroParcela = linkPage.obterNumeroDeParcelasLinkPgto();
        numeroParcela.get((numParcelas - 2)).clicar();
        linkValidation.validarQuantidadeParcelasLiberadas(numParcelas, numeroParcela.size());
    }

    public void validaEditarValorLinkPgtoMinimoParecela(double valor, int numParcelas, double valorEditado, int numParcelas2) {
        criarLinkPgtoInicioParcelado(valor);
        linkPgtoEditarValorTelaResumo(numParcelas, valorEditado);
        linkPage.obterBotaoCreditoParceladoLink().clicar();
        List<Bmouaajm_Elemento> numeroParcela2 = linkPage.obterNumeroDeParcelasLinkPgto();
        numeroParcela2.get((numParcelas2 - 2)).clicar();
        linkValidation.validarQuantidadeParcelasLiberadas(numParcelas2, numeroParcela2.size());
    }

    public void validaEditarValorLinkPgtoMinimoPulaParcela(double valor, int numParcelas, double valorEditado) {
        criarLinkPgtoInicioParcelado(valor);
        linkPgtoEditarValorTelaResumo(numParcelas, valorEditado);
        linkPage.obterBotaoCreditoAVistaLink().clicar();
        genericValidation.validaElementoEstaDesabilitado(linkPage.obterBotaoEditarFormaPagamentoLink());
    }

    public void validaTelaTermoAdesaoAderindoAoLinkPgtoTela12h() {
        linkPage.obterTextoDicaAceiteTermoLinkPgto();
        linkPage.obterCheckboxTermoAdesaoLinkPgto().clicar();
        linkPage.obterBotaoAderirAoLinkPgtoLiAceito().clicar();
        validaSolicitacaoAdesaoEnviada();
    }

    public void validaTelaTermoAdesaoNaoQueroAderirLinkPgto() {
        linkPage.obterTextoDicaAceiteTermoLinkPgto();
        linkPage.obterCheckboxTermoAdesaoLinkPgto().clicar();
        linkPage.obterBotaoNaoAderirLinkPgto().clicar();
        genericValidation.validarTextosEsperadoEAtual(comoQuerVender, venderPage.obterTituloPagina().obterTexto());
    }

    public void validaTelaTermoAdesaoQueroAderirLinkPgto() {
        linkPage.obterTextoDicaAceiteTermoLinkPgto();
        linkPage.obterCheckboxTermoAdesaoLinkPgto().clicar();
        linkPage.obterBotaoAderirAoLinkPgtoLiAceito().clicar();
        genericValidation.validarTextosEsperadoEAtual(podeVenderViaLink, genericPage.obterTituloMeiaModal().obterTexto());
        genericPage.obterBotaoPrimarioMeiaModal().clicar();
    }

    public void validarInterfaceValorMinimoParcelaLink() {
        linkPage.obterBotaoCriarLink().clicar();
        genericValidation.validarTextosEsperadoEAtual(avisoParcelaMinima,
                linkPage.obterTextoTituloParcelaMinima().obterTexto());
        linkPage.obterBotaoEntendiParcelaMinima().clicar();
        linkValidation.validarCampoValorEstaVisivel();
    }

    public void validaInfoRecebimentoAVistaParcelado(double valor, String info, String descricaoMeiaModal) {
        linkPage.obterBotaoCriarLink().clicar();
        linkPage.obterCampoValorLink().preencherLento(Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valor));
        linkPage.obterBotaoContinuarLink().clicar();
        genericValidation.validarTextosEsperadoEAtual(info, linkPage.obterTextoSaibaMaisComoReceber().obterTexto());
        linkPage.obterBotaoSaibaMaisComoReceber().clicar();
        genericValidation.validarTextosEsperadoEAtual(descricaoMeiaModal, genericPage.obterDescricaoMeiaModalModalConteudo().obterTexto());
    }

    /**
     * METODOS PRIVADOS PARA EXECUï¿½ï¿½O DE TAREFAS
     */

    private void prencherCampoDescricaoAvaliacao(String avalicao) {
        linkPage.obterCampoDescricaoAvaliacao().clicar().limpar().preencherLento(avalicao + Keys.ENTER);
        linkPage.obterBotaoEnviarAvaliacao().clicar();
    }

    private void iniciarCriacaoLinkPagamentoAVista(double valor) {
        linkPage.obterBotaoCriarLink().clicar();
        linkPage.obterCampoValorLink().preencherLento(Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valor));
        linkPage.obterBotaoContinuarLink().clicar();
        linkPage.obterBotaoCreditoAVistaLink().clicar();
    }

    private String finalizarCriacaoDoLinkPgto() {
        linkPage.obterBotaoCriarLinkPagamento().clicar();
        linkValidation.validarUrlLinkPgtoCriado();
        return linkPage.obterUrlLinkPgto().obterTexto();
    }

    private void adicionarDescricaoLinkPgto(String descricao) {
        linkPage.obterBotaoInserirDescricaoLink().clicar();
        linkPage.obterCampoDescricaoVenda().limpar().preencherLento(descricao);
        linkPage.obterBotaoSalvarDescricao().clicar();
    }

    private void criarlinkExpirado(int tempoExpiracao) {
        linkPage.obterEditarDataExpiracao().clicar();
        List<Bmouaajm_Elemento> expiracao = linkPage.obterDataExpiracao();
        expiracao.get(tempoExpiracao - 1).clicar();
        linkPage.obterBotaoSalvarExpiracao().clicar();
    }

    private void criarLinkPgtoInicioParcelado(double valor) {
        linkPage.obterBotaoCriarLink().clicar();
        linkPage.obterCampoValorLink().preencherLento(Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valor));
        linkPage.obterBotaoContinuarLink().clicar();
        linkPage.obterBotaoCreditoParceladoLink().clicar();
    }

    private void linkPgtoEditarValorTelaResumo(int numParcelas, double valorEditado) {
        List<Bmouaajm_Elemento> numeroParcela = linkPage.obterNumeroDeParcelasLinkPgto();
        numeroParcela.get((numParcelas - 2)).clicar();
        linkPage.obterBotaoSalvarParcelas().clicar();
        linkPage.obterBotaoEditarValorVendaLink().clicar();
        linkPage.obterCampoValorLink().limpar().preencherLento(Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valorEditado));
        linkPage.obterBtnSalvarValor().clicar();
    }
}
