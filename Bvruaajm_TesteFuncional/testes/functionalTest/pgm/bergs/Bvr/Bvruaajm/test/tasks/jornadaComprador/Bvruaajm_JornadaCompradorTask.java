package bergs.Bvr.Bvruaajm.test.tasks.jornadaComprador;

import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;

import bergs.Bvr.Bvruaajm.test.pages.jornadaComprador.Bvruaajm_JornadaCompradorDadosPagamentoPage;
import bergs.Bvr.Bvruaajm.test.pages.jornadaComprador.Bvruaajm_JornadaCompradorDadosCompradorPage;
import bergs.Bvr.Bvruaajm.test.pages.jornadaComprador.Bvruaajm_JornadaCompradorResumoPagamentoPage;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_FakeGenerator;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Formatador;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartoesPgto;
import bergs.Bvr.Bvruaajm.test.validations.jornadaComprador.Bvruaajm_JornadaCompradorValidation;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.tasks.Bmouaajm_TaskBase;
import bergs.bmo.bmouaajm.suporte.util.Bmouaajm_Gerador;

public class Bvruaajm_JornadaCompradorTask extends Bmouaajm_TaskBase {

    Bvruaajm_JornadaCompradorDadosCompradorPage compradorPage;
    Bvruaajm_JornadaCompradorDadosPagamentoPage pagamentoPage;
    Bvruaajm_JornadaCompradorResumoPagamentoPage resumoPage;
    Bvruaajm_JornadaCompradorValidation compradorValidation;
    String msgAposAvalicao = "Agradecemos por sua colaboração";
    String pgtoNegado = "Pagamento negado";
    String tentarOutroCartao = "Tentar novamente";

    public Bvruaajm_JornadaCompradorTask(ChromeDriver driver) {
        super(driver);
        compradorPage = new Bvruaajm_JornadaCompradorDadosCompradorPage(driver);
        pagamentoPage = new Bvruaajm_JornadaCompradorDadosPagamentoPage(driver);
        resumoPage = new Bvruaajm_JornadaCompradorResumoPagamentoPage(driver);
        compradorValidation = new Bvruaajm_JornadaCompradorValidation(driver);
    }

    public void efetuarPgtoLinkCompradorSucesso(Bvruaajm_CartoesPgto cartao, boolean debito, String avaliacao) {       
        inicioPgtoComprador();
        preencherDadosCompradorCartaoEndereco(cartao, debito);
        resumoPage.obterInput4Estrelas().clicar();
        resumoPage.obterTxtAreaAvaliacao().preencherLento(avaliacao);
        resumoPage.obterButonEnviarAvaliacao().clicar();
        compradorValidation.validarTextosEsperdoEAtual(msgAposAvalicao, resumoPage.obterTextoSpanAposAvalicao().obterTexto());
    }

    public void efetuarPgtoLinkCompradorFalha(Bvruaajm_CartoesPgto cartao) {
        inicioPgtoComprador();
        preencherDadosCompradorCartaoEndereco(cartao, false);
        compradorValidation.validarTextosEsperdoEAtual(pgtoNegado, resumoPage.obterTextoPgtoNegado().obterTexto());
        compradorValidation.validarTextosEsperdoEAtual(tentarOutroCartao, resumoPage.obterBotaoTentarOutroCartao().obterTexto());
    }

    public void efetuarPagamentoCompradorAteBloquear(Bvruaajm_CartoesPgto cartao, String linkBloqueado) {
        inicioPgtoComprador();
        preencherDadosCompradorCartaoEndereco(cartao, false);
        for (int i = 1; i < 3; i++) {
            resumoPage.obterBotaoTentarOutroCartao().clicar();;
            preencherDadosCompradorCartaoEndereco(cartao, false);
        }
        compradorValidation.validarTextosEsperdoEAtual(linkBloqueado, resumoPage.obterTextoMensagemDeErroLink().obterTexto());
    }
    
    public void ValidaTituloEDescricaoErroLinkPgto(String titulo, String descricao) {
        compradorValidation.validarTextosEsperdoEAtual(titulo, resumoPage.obterTextoMensagemDeErroLink().obterTexto());
        compradorValidation.validarTextosEsperdoEAtual(descricao, resumoPage.obterTextoDescricaoDoErroLink().obterTexto());
    }

    public void validarParcelasPreDefinidasNaTelaDadosPgto(Bvruaajm_CartoesPgto cartao, int parcelas) {
        inicioPgtoComprador();
        pagamentoPage.obterInputNumeroCartao().preencherLento(cartao.NumeroCartaoFormatado());
        pagamentoPage.obterInputNomeCartao().preencherLento(cartao.obterNomeNoCartao());
        pagamentoPage.obterInputValidadeCartao().preencherLento(cartao.obterDataValidade());
        pagamentoPage.obterInputCVVCartao().preencherLento(cartao.obterCvv());
        List<Bmouaajm_Elemento> numParcelas = pagamentoPage.obterParcelasPreDefinidas();
        compradorValidation.validarTextosEsperdoEContains("Crédito em " + parcelas + "x de",
                numParcelas.get(parcelas - 1).obterTexto());
        compradorValidation.validaQuantidadeDeParcelasLinkPgto(parcelas, numParcelas.size());
    }

    /*
     * Metodos de inicilaização privadas
     */
    private void preencherDadosCompradorCartaoEndereco(Bvruaajm_CartoesPgto cartao, boolean debito) {
        pagamentoPage.obterInputNumeroCartao().preencherLento(cartao.NumeroCartaoFormatado());
        pagamentoPage.obterInputNomeCartao().preencherLento(cartao.obterNomeNoCartao());
        pagamentoPage.obterInputValidadeCartao().preencherLento(cartao.obterDataValidade());
        pagamentoPage.obterInputCVVCartao().preencherLento(cartao.obterCvv());
        if (debito == true) {
            List<Bmouaajm_Elemento> cartaoDebito = pagamentoPage.obterParcelasPreDefinidas();
            cartaoDebito.get(0).clicar();
        }
        pagamentoPage.obterInputCEP().preencherLento(cartao.obterCep());
        pagamentoPage.obterInputNumeroEndereco().preencherLento(cartao.obterNumeroResidencial());
        pagamentoPage.obterCampoLogradouroRotuloAcima();
        pagamentoPage.obterBotaoContinuarPagamento().clicar();
        pagamentoPage.obterBotaoConfirmarPagamento().clicar();
    }

    private String inicioPgtoComprador() {
        String nomeComprador = Bvruaajm_FakeGenerator.obterNomeSobrenome();
        compradorPage.obterCampoVendidoPorECPrimeiraTela();
        compradorPage.obterBotaoContinuarInicial().clicar();
        compradorPage.obterInputNomeComprador().preencherLento(nomeComprador);
        compradorPage.obterInputCpfComprador().preencherLento(Bmouaajm_Gerador.gerarCPF());
        compradorPage.obterInputCelularComprador().preencherLento(Bvruaajm_FakeGenerator.obterTelefone());
        compradorPage.obterInputEmailComprador().preencherLento(Bvruaajm_Formatador.removeAcentoPalavraString(nomeComprador.replaceAll(" ", ".") + "@banri.com.br"));
        compradorPage.obterContinuarDadosPessoais().clicar();
        return nomeComprador;
    }

}
