package bergs.Bvr.Bvruaajm.test.tests.mm.produtos.linkPgto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.mm.genericMM.Bvruaajm_GenericMMTask;
import bergs.Bvr.Bvruaajm.test.tasks.mm.menuLateral.Bvruaajm_MenuLateralTask;
import bergs.Bvr.Bvruaajm.test.tasks.mm.produtos.linkPgto.Bvruaajm_DadosCricaoLinkPagamentoTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMM;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;

public class Bvruaajm_DadosCriacaoLinkPgtoTest extends Bvruaajm_TesteBaseMM {

    Bvruaajm_GenericMMTask genericMMTask;
    Bvruaajm_MenuLateralTask menuLateralTask;
    Bvruaajm_DadosCricaoLinkPagamentoTask criacaoLinkTask;
    Bvruaajm_CartaoAcesso cpfValido = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_CartaoAcesso cpfInvalido = Bvruaajm_EnumCartaoAcesso.CPFInvalido.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estabCnpjInvalido = Bvruaajm_EnumEstabelecimentoConveniado.CnpjInvalido.obterEstabelecimento();
    Bvruaajm_Estabelecimento estabCpfInvalido = Bvruaajm_EnumEstabelecimentoConveniado.CpfInvalido.obterEstabelecimento();
    Bvruaajm_Estabelecimento estabCnpjValido = Bvruaajm_EnumEstabelecimentoConveniado.ConsultoriaInfoteca.obterEstabelecimento();
    Bvruaajm_Estabelecimento estabSemLink = Bvruaajm_EnumEstabelecimentoConveniado.BetosLancheria2.obterEstabelecimento();
    String dataPesquisa = "11/07/2024";
    String retornoCpfInvalido = "* CPF inválido";
    String retornoCnpjEcInvalido = "* CNPJ inválido";
    
    @BeforeEach
    public void iniciaTest() {
        genericMMTask = new Bvruaajm_GenericMMTask(driver);
        menuLateralTask = new Bvruaajm_MenuLateralTask(driver);
        criacaoLinkTask = new Bvruaajm_DadosCricaoLinkPagamentoTask(driver);
        menuLateralTask.acessarMenuProdutoLinkDadosCriacao();
    }
 
    @Tag("MM5Produtos")
    @DisplayName("Efetuar pesquisa inserindo uma data de criacao")
    @Test
    public void validarPesquisaApenasInserindoUmaDataCriacaoLink() {
        criacaoLinkTask.efetuarPesquisaApenasComDataCriacaoLink(dataPesquisa);
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Efetua pesquisa inserindo cnpj e data criacao")
    @Test
    public void validarPesquisaInformandoCnpjValidoEData() {
        criacaoLinkTask.efetuarPesquisaComCnpjEData(dataPesquisa, estabCnpjValido);
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Efetua pesquisa inserindo cpf user e data criacao")
    @Test
    public void validarPesquisaInformandoCpfUserValidoEData() {
        criacaoLinkTask.efetuarPesquisaComCpfUserEdata(dataPesquisa, cpfValido);
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Efetua pesquisa inserindo cpf user cnpj ec e data criacao e status pago")
    @Test
    public void validarPesquisaInformandoCpfUserCnpjValidoDataStatusPago() {
        String statusLink = "Pago";
        String nroLinkRegistro = "7";
        String valorTotalLinks = "229,00";
        criacaoLinkTask.efetuarPesquisaComCpfDataStatus(dataPesquisa, cpfValido, estabCnpjValido, statusLink, nroLinkRegistro, valorTotalLinks);
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Efetua pesquisa cpg user cnpj ec data e status expirado")
    @Test
    public void validarPesquisaInformandoCpfUserCnpjValidoDataStatusExpirado() {
        String statusLink = "Expirado";
        String nroLinkRegistro = "2";
        String valorTotalLinks = "21,00";
        criacaoLinkTask.efetuarPesquisaComCpfDataStatus(dataPesquisa, cpfValido, estabCnpjValido, statusLink, nroLinkRegistro, valorTotalLinks);
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Efetua pesquisa inserindo periodo")
    @Test
    public void validarPesquisaInformandoPeriodo() {
        String nroLinkRegistro = "399";
        String valorTotalLinks = "59.619,05";
        criacaoLinkTask.efetuarPesquisaPeriodo(nroLinkRegistro, valorTotalLinks);
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Efetua pesquisa inserindo periodo e status link cancelado")
    @Test
    public void validarPesquisaInformandoPeriodoStatusCancelado() {
        String statusLink = "Cancelado";
        String formaPgto = "Todos";
        String nroLinkRegistro = "33";
        String valorTotalLinks = "772,24";
        criacaoLinkTask.efetuarPesquisaPeriodoStatusFormaPagamento(nroLinkRegistro, valorTotalLinks, statusLink, formaPgto);
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Efetua pesquisa inserindo periodo e status link pago e forma pgto a vista")
    @Test
    public void validarPesquisaInformandoPeriodoStatusPagoAvista() {
        String statusLink = "Pago";
        String formaPgto = "Crédito à vista";
        String nroLinkRegistro = "132";
        String valorTotalLinks = "7.623,26";
        criacaoLinkTask.efetuarPesquisaPeriodoStatusFormaPagamento(nroLinkRegistro, valorTotalLinks, statusLink, formaPgto);
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Efetua pesquisa inserindo periodo e status link pago e forma pgto parcelado")
    @Test
    public void validarPesquisaInformandoPeriodoStatusParcelado() {
        String statusLink = "Pago";
        String formaPgto = "Crédito parcelado";
        String nroLinkRegistro = "29";
        String valorTotalLinks = "23.603,73";
        criacaoLinkTask.efetuarPesquisaPeriodoStatusFormaPagamento(nroLinkRegistro, valorTotalLinks, statusLink, formaPgto);
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Efetua validacao mensagem erro cnpj ec")
    @Test
    public void validarCampoCnpjEcInvalido() {
        criacaoLinkTask.validaCampoCpfCnpjEcInvalido(estabCnpjInvalido, retornoCnpjEcInvalido);
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Efetua validacao mensagem erro cpf ec")
    @Test
    public void validarCampoCpfEcInvalido() {
        criacaoLinkTask.validaCampoCpfCnpjEcInvalido(estabCpfInvalido, retornoCpfInvalido);
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Efetua validacao mensagem erro cpf usuario")
    @Test
    public void validarCampoCpfUsuarioInvalido() {
        criacaoLinkTask.validaCampoCpfUserInvalido(cpfInvalido, retornoCpfInvalido);
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Efetua validacao mensagem retorno com nenhum resultado encontrado")
    @Test
    public void validarModalNenhumResultadoEncontrado() {
        String mesInicio = "Maio";
        String mesFim = "Abril";
        String anoInicio = "2023";
        String anoFim = "2024";
        String msgRetorno = "Nenhum resultado encontrado.";
        criacaoLinkTask.validaPesquisasComModalRetorno(estabSemLink, mesInicio, mesFim, anoInicio, anoFim, msgRetorno);
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Efetua validacao mensagem retorno com periodo mes inicio nao informado")
    @Test
    public void validarModalSemPeriodoInicioMes() {
        String mesInicio = "";
        String mesFim = "Abril";
        String anoInicio = "2023";
        String anoFim = "2024";
        String msgPeriodoInicioNaoInformado = "Campo periodo_de_criacao_mes não foi informado.";
        criacaoLinkTask.validaPesquisasComModalRetorno(estabSemLink, mesInicio, mesFim, anoInicio, anoFim, msgPeriodoInicioNaoInformado);
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Efetua validacao mensagem retorno com periodo ano inicio nao informado")
    @Test
    public void validarModalSemPeriodoInicioAno() {
        String mesInicio = "Maio";
        String mesFim = "Abril";
        String anoInicio = "";
        String anoFim = "2024";
        String msgPeriodoInicioAnoNaoInformado = "Campo ano do período de criação não foi informado.";
        criacaoLinkTask.validaPesquisasComModalRetorno(estabSemLink, mesInicio, mesFim, anoInicio, anoFim, msgPeriodoInicioAnoNaoInformado);
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Efetua validacao mensagem retorno com periodo ano fim nao informado")
    @Test
    public void validarModalSemPeriodoFimAno() {
        String mesInicio = "Maio";
        String mesFim = "Abril";
        String anoInicio = "2023";
        String anoFim = "";
        String msgPeriodoFimAnoNaoInformado = "Campo periodo_ate_criacao_ano não foi informado.";
        criacaoLinkTask.validaPesquisasComModalRetorno(estabSemLink, mesInicio, mesFim, anoInicio, anoFim, msgPeriodoFimAnoNaoInformado);
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Efetua validacao mensagem retorno com periodo mes inicio nao informado")
    @Test
    public void validarModalSemPeriodoFimMes() {
        String mesInicio = "Maio";
        String mesFim = "";
        String anoInicio = "2023";
        String anoFim = "2024";
        String msgPeriodoFimMesNaoInformado = "Campo periodo_ate_criacao_mes não foi informado.";
        criacaoLinkTask.validaPesquisasComModalRetorno(estabSemLink, mesInicio, mesFim, anoInicio, anoFim, msgPeriodoFimMesNaoInformado);
    }
    
    @Tag("MM5Produtos")
    @DisplayName("Efetua validacao mensagem retorno com periodo maior que um ano")
    @Test
    public void validarModalPeriodoMaiorUmAno() {
        String mesInicio = "Maio";
        String mesFim = "Maio";
        String anoInicio = "2023";
        String anoFim = "2024";
        String msgPeriodoMaiorUmAno = "O período de consulta deve ser igual ou menor a 1 ano.";
        criacaoLinkTask.validaPesquisasComModalRetorno(estabSemLink, mesInicio, mesFim, anoInicio, anoFim, msgPeriodoMaiorUmAno);
    }
}
