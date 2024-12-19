package bergs.Bvr.Bvruaajm.test.tests.perfil.meusNegocios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_OnboardingTask;
import bergs.Bvr.Bvruaajm.test.tasks.perfil.Bvruaajm_PerfilTask;
import bergs.Bvr.Bvruaajm.test.tasks.perfil.Bvruaajm_TaxasTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_LinkPagamentoTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBvr;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;

public class Bvruaajm_TaxasTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.SweetFlavors.obterEstabelecimento();
    Bvruaajm_Estabelecimento estab2 = Bvruaajm_EnumEstabelecimentoConveniado.TesteGustavoImagens.obterEstabelecimento();
    Bvruaajm_Estabelecimento estabPsr = Bvruaajm_EnumEstabelecimentoConveniado.BancoBergs.obterEstabelecimento();
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_PerfilTask perfilTask;
    Bvruaajm_TaxasTask taxasTask;
    Bvruaajm_LinkPagamentoTask linkTask;
    Bvruaajm_OnboardingTask onboardingTask;
    Bvruaajm_SqlBvr sqlBvr;

    @BeforeEach
    public void iniciaTest() {
        genericTask = new Bvruaajm_GenericTask(driver);
        perfilTask = new Bvruaajm_PerfilTask(driver);
        taxasTask = new Bvruaajm_TaxasTask(driver);
        linkTask = new Bvruaajm_LinkPagamentoTask(driver);
        onboardingTask = new Bvruaajm_OnboardingTask(driver);
        genericTask.prepararTesteLogado(cartaoAcesso);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        
    }

    @Tag("Taxas")
    @DisplayName("Acessa as taxas e valida as taxas do banricompras")
    @Test
    public void testeTaxasBanricomprasMaquinnha() {
        String debito = "1,29";
        String taxaPreDatado = "1,89";
        genericTask.clicarBotaoPerfil();
        taxasTask.validaDuasLinhasTaxas(1, debito, taxaPreDatado);
    }

    @Tag("Taxas")
    @DisplayName("Acessa e valida as taxas do cartao")
    @Test
    public void testeTaxasMastercardMaquinnha() {
        String taxaDebito = "1,79";
        String taxaCreditoVista = "1,99";
        String taxaParceladoMenosSeisVezes = "2,19";
        String taxaParceladoMaisSeisVezes = "2,19";
        String taxaParceldoCliente = "1,99";
        String taxaRePay = "1,99";
        genericTask.clicarBotaoPerfil();
        taxasTask.validaOpcoesPgtoTaxas(2, taxaDebito, taxaCreditoVista, 
                taxaParceladoMenosSeisVezes, taxaParceladoMaisSeisVezes, taxaParceldoCliente, taxaRePay);
    }

    @Tag("Taxas")
    @DisplayName("Acessa o menu de taxas e valida as taxas do Banricard")
    @Test
    public void testeTaxasBanriCardMaquinnha() {
        String alimentacao = "4,90";
        String refeicao = "4,90";
        genericTask.clicarBotaoPerfil();
        taxasTask.validaDuasLinhasTaxas(6, alimentacao, refeicao);
    }

    @Tag("Taxas")
    @DisplayName("Acessa o menu de taxas e valida a taxa do Pix")
    @Test
    public void testPix() {
        String debito = "1,15";
        genericTask.clicarBotaoPerfil();
        taxasTask.validaDuasLinhasTaxas(5, debito, "");
    }

    @Tag("Taxas")
    @DisplayName("Acessa e valida as taxas do link de Pgto")
    @Test
    public void testeTaxasMastercardLinkPgto() {
        String taxaDebito = "2,25";
        String taxaCreditoVista = "3,25";
        String taxaParceladoMenosSeisVezes = "3,35";
        String taxaParceladoMaisSeisVezes = "3,45";
        genericTask.clicarBotaoPerfil();
        taxasTask.validarTaxasLinkPgto(1, taxaDebito, taxaCreditoVista,
                taxaParceladoMenosSeisVezes, taxaParceladoMaisSeisVezes);
    }

    @Tag("Taxas")
    @DisplayName("Acessa e valida nas taxas do link de Pgto o fluxo de queero aderir")
    @Test
    public void testQueroAderirPelasTaxasLinkPgto() {
        sqlBvr = new Bvruaajm_SqlBvr();
        sqlBvr.deletarLojistaTabelaEstabelecimento(String.valueOf(estab2.obterCpfCnpj()));
        genericTask.selecionaEstabelecimentoOuConveniado(estab2);
        genericTask.clicarBotaoPerfil();
        taxasTask.acessarAreasDeTaxas();
        taxasTask.validaLinkNaoAderido();
        onboardingTask.verificaPularOnboardingGeneric();
        linkTask.validaTelaTermoAdesaoAderindoAoLinkPgtoTela12h();
        sqlBvr.deletarLojistaTabelaEstabelecimento(String.valueOf(estab2.obterCpfCnpj()));
    }
    
    @Tag("Taxas")
    @DisplayName("Acessa e valida a tela minhas taxas")
    @Test
    public void testValidaTabTaxaLinkETaxaMaquininha() {
        genericTask.clicarBotaoPerfil();
        taxasTask.validaTagsDeTaxaLinkEMaquininha();
    }
    
    @Tag("Taxas")
    @DisplayName("Acessa e valida que o card outras credenciadoras não aparce para estabelecimento que sao apenas da vero")
    @Test
    public void testValidaQueOCardOutrasCredenciadorarEstaEscondidoEcApenasVero() {
        genericTask.clicarBotaoPerfil();
        taxasTask.acessarAreasDeTaxas();
        taxasTask.validaCardOutrasCredenciadorasNaoAparece();
    }
    
    @Tag("Taxas")
    @DisplayName("Acessa e valida as taxas de outras credeciadora PRS")
    @Test
    public void testValidaTaxasOutrasCredenciadoras() {
        String taxaDebito = "1,75";
        String preDatado = "2,59";
        String taxaParceladoMenosSeisVezes = "2,99";
        String taxaParceladoMaisSeisVezes = "2,99";
        genericTask.selecionaEstabelecimentoOuConveniado(estabPsr);
        genericTask.clicarBotaoPerfil();
        taxasTask.acessarAreasDeTaxas();
        taxasTask.validaTaxasOutrasCredenciadoras(taxaDebito, preDatado,
                taxaParceladoMenosSeisVezes, taxaParceladoMaisSeisVezes);
    }
    
    @Tag("Taxas")
    @DisplayName("Acessa e valida que o card todos os card das taxas")
    @Test
    public void testValidaCardsMenuTaxas() {
        genericTask.selecionaEstabelecimentoOuConveniado(estabPsr);
        genericTask.clicarBotaoPerfil();
        taxasTask.acessarAreasDeTaxas();
        taxasTask.validaCardMenuTaxas();
    }
}
