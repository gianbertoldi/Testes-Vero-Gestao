package bergs.Bvr.Bvruaajm.test.tests.mm.produtos.gerarQrCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.mm.genericMM.Bvruaajm_GenericMMTask;
import bergs.Bvr.Bvruaajm.test.tasks.mm.menuLateral.Bvruaajm_MenuLateralTask;
import bergs.Bvr.Bvruaajm.test.tasks.mm.produtos.gerarQrCode.Bvruaajm_GerarQrCodeMMTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMM;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;

public class Bvruaajm_ValidarGeraQrCodeMMTest extends Bvruaajm_TesteBaseMM {

    Bvruaajm_GenericMMTask genericMMTask;
    Bvruaajm_MenuLateralTask menuLateralTask;
    Bvruaajm_GerarQrCodeMMTask gerarQrCodeTask;
    Bvruaajm_CartaoAcesso cpfValido = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento cnpjValido = Bvruaajm_EnumEstabelecimentoConveniado.SweetFlavors.obterEstabelecimento();
    Bvruaajm_Estabelecimento cnpjQrCodeDesabilitado = Bvruaajm_EnumEstabelecimentoConveniado.CasaDoPintor2Teste.obterEstabelecimento();
    Bvruaajm_CartaoAcesso cpfInvalido = Bvruaajm_EnumCartaoAcesso.CPFInvalido.obterCartaoAcesso();
    Bvruaajm_Estabelecimento EstabCnpjInvalido = Bvruaajm_EnumEstabelecimentoConveniado.CnpjInvalido.obterEstabelecimento();
    String mensagemModalSemVeroX =  "Este estabelecimento não possui QR Code Vero X pois não aderiu ao serviço.";
    String mensagemModalQrCodeDesabilitado = "O QR Code está desabilitado para este estabelecimento.";
    String mensagemModalTipoPessoaVazio = "Preencha o campo Tipo Pessoa.";
    String retornoCpfInvalido = "* CPF inválido";
    String CnpjInvalido = "* CNPJ inválido";

    @BeforeEach
    public void iniciaTest() {
        genericMMTask = new Bvruaajm_GenericMMTask(driver);
        menuLateralTask = new Bvruaajm_MenuLateralTask(driver);
        gerarQrCodeTask = new Bvruaajm_GerarQrCodeMMTask(driver);
        menuLateralTask.acessarMenuProdutoVeroXWalletGerarQrCode();
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Valida MM a geração do QrCode Pessoa Fisica Vero Wallet")
    @Test
    public void validaGerarQrCodePessoaFisicaVeroWalletTest() {
        gerarQrCodeTask.validaGerarQrCodePessoaFisicaVeroWallet(cpfValido.obterCpfFormatado());
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Valida MM a geração do QrCode Pessoa Juridca Vero Wallet")
    @Test
    public void validaGerarQrCodePessoaJuridicaVeroWalletTest() {
        gerarQrCodeTask.validaGerarQrCodePessoaJuridicaVeroWallet(cnpjValido.obterCnpjZerosAEsquerda());
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Valida MM a geração do QrCode Pessoa Juridca Vero X")
    @Test
    public void validaGerarQrCodePessoaJuridicaVeroXTest() {
        gerarQrCodeTask.validaGerarQrCodePessoaJuridicaVeroX(cnpjValido.obterCnpjZerosAEsquerda());
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Valida MM QrCode Pessoa fisica que não possui Vero X")
    @Test
    public void validaGerarQrCodePessoaFisicaRetornoVeroXTest() {
        gerarQrCodeTask.validaGerarQrCodePessoaFisicaRetornoSemVeroX(cpfValido.obterCpfFormatado(), mensagemModalSemVeroX);
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Valida Cnpj na geracao QrCode MM desabilitado")
    @Test
    public void validaCnpjDeQrCodeDesabilitadoTest() {
        gerarQrCodeTask.validaCnpjDeQrCodeDesabilitado(cnpjQrCodeDesabilitado.obterCnpjZerosAEsquerda(), mensagemModalQrCodeDesabilitado);
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Valida Cnpj invalido na Geracao QrCode MM")
    @Test
    public void validaCnpjInvalidoTest() {
        gerarQrCodeTask.validaCnpjInvalido(EstabCnpjInvalido.obterCnpjZerosAEsquerda(), CnpjInvalido);
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Valida Cpf invalido na Geracao QrCode MM")
    @Test
    public void validaCpfInvalidoTest() {
        gerarQrCodeTask.validaCpfInvalido(cpfInvalido.obterCpfFormatado(), retornoCpfInvalido);
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Valida a modal quando o tipo pessoa não foi preenchido")
    @Test
    public void validaModalTipoPessoaVazioTest() {
        gerarQrCodeTask.validaModalTipoPessoaVazio(mensagemModalTipoPessoaVazio);
    }
}
