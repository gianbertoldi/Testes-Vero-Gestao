package bergs.Bvr.Bvruaajm.test.tasks.conexoes.ofertas;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.conexoes.imagem.Bvruaajm_GaleriaDeImagemPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas.Bvruaajm_CriacaoOfertaSucessoPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas.Bvruaajm_DescricaoOfertasPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas.Bvruaajm_GenericOfertasPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas.Bvruaajm_InformativoOfertasPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas.Bvruaajm_RegrasUtilizacaoOfertaPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas.Bvruaajm_SelecaoImagemOfertasPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas.Bvruaajm_ValorDaOfertaPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.termoAdesao.Bvruaajm_TermoDeAdesaoPage;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_FileOperations;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Formatador;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_CriacaoOfertasTask extends Bvruaajm_TaskMobile {

    private Bvruaajm_DescricaoOfertasPage descricaoOfertas;
    private Bvruaajm_InformativoOfertasPage informativosPage;
    private Bvruaajm_GenericOfertasPage genericOfertasPage;
    private Bvruaajm_ValorDaOfertaPage valorOferta;
    private Bvruaajm_GaleriaDeImagemPage galeriaImagem;
    private Bvruaajm_SelecaoImagemOfertasPage selecaoImagem;
    private Bvruaajm_RegrasUtilizacaoOfertaPage regrasOfertas;
    private Bvruaajm_CriacaoOfertaSucessoPage criacaoSucessoPage;
    private Bvruaajm_TermoDeAdesaoPage termoAdesao;
    
    public Bvruaajm_CriacaoOfertasTask(AppiumDriver<WebElement> driver) {
        super(driver);
        descricaoOfertas = new Bvruaajm_DescricaoOfertasPage(driver);
        informativosPage = new Bvruaajm_InformativoOfertasPage(driver);
        genericOfertasPage = new Bvruaajm_GenericOfertasPage(driver);
        valorOferta = new Bvruaajm_ValorDaOfertaPage(driver);
        galeriaImagem = new Bvruaajm_GaleriaDeImagemPage(driver);
        selecaoImagem = new Bvruaajm_SelecaoImagemOfertasPage(driver);
        regrasOfertas = new Bvruaajm_RegrasUtilizacaoOfertaPage(driver);
        criacaoSucessoPage = new Bvruaajm_CriacaoOfertaSucessoPage(driver);
        termoAdesao = new Bvruaajm_TermoDeAdesaoPage(driver);
    }

    public void criarOferta(String nomeOferta, String descricao, String deValor, String porValor , List<String> diasDaOferta, String consumoOferta , String consumoRetirada , String consumoLocal , String intensCouvert , String itensSobremesa , String itensTaxa , String itensBebidas ,  String outrosOfertas , String outrosFeriados) {
        criarOfertaRegrasDaOferta(nomeOferta, descricao, deValor, porValor);
        selecionarRegrasDaOferta(diasDaOferta, consumoOferta , consumoRetirada , consumoLocal , intensCouvert , itensSobremesa , itensTaxa , itensBebidas , outrosOfertas , outrosFeriados);
        avancarEtapa();
        avancarEtapa();
        avancarEtapaConfirmacao();
    }
    
    public void avancarEtapaInformativaOferta() {
        informativosPage.obterBotaoVamosLa().clicar();
    }

    public void preencheEtapaDescricaoOferta(String nomeOferta, String descricao) {
        descricaoOfertas.obterCampoTextoNomeOferta().preencher(nomeOferta);
        descricaoOfertas.obterCampoTextoDescricaoOferta().preencher(descricao);
        fecharTeclado();

    }

    public void preencherEtapaValorDaOferta(String deValor, String porValor) {
        valorOferta.obterCampoTextoDeValor().limpar().preencher(deValor);
        valorOferta.obterCampoTextoPorValor().limpar().preencher(porValor);
        fecharTeclado();
    }

    public void selecionarImagemDaOferta() {
        selecaoImagem.obterBotaoEscolherImagem().clicar();
        selecaoImagem.obterBotaoEscolherGaleria().clicar();
        definirContextoNativo();
        galeriaImagem.obterImagem("banrisul").click();
        definirContextoWebview();
    }

    public void selecionarRegrasDaOferta(List<String> diasDaOferta, String consumoOferta , String consumoRetirada , String consumoLocal , String intensCouvert , String itensSobremesa , String itensTaxa , String itensBebidas ,  String outrosOfertas , String outrosFeriados) {
        selecionarDiasDaOferta(diasDaOferta);
        definirHorario();
        selecionarFormaDeConsumo(consumoOferta , consumoRetirada , consumoLocal);
        selecionarItensIncluso(intensCouvert , itensSobremesa , itensTaxa , itensBebidas );
        selecionarOutrasOpcoes(outrosOfertas , outrosFeriados);
    }

    public void selecionarDiasDaOferta(List<String> diasDaOferta) {
        if(diasDaOferta.contains("Todos os dias")) {
            regrasOfertas.obterBotaoQuandoTodosDias().clicar();

        }if(diasDaOferta.contains("Segunda")) {
            regrasOfertas.obterBotaoQuandoSegunda().clicar();
            
        }if(diasDaOferta.contains("Terca")) {
            regrasOfertas.obterBotaoQuandoTerca().clicar();
            
        }if(diasDaOferta.contains("Quarta")) {
            regrasOfertas.obterBotaoQuandoQuarta().clicar();
            
        }if(diasDaOferta.contains("Quinta")) {
            regrasOfertas.obterBotaoQuandoQuinta().clicar();
            
        }if(diasDaOferta.contains("Sexta")) {
            regrasOfertas.obterBotaoQuandoSexta().clicar();

        }if(diasDaOferta.contains("Sabado")) {
            regrasOfertas.obterBotaoQuandoSabado().clicar();

        }if(diasDaOferta.contains("Domingo")) {
            regrasOfertas.obterBotaoQuandoDomingo().clicar();

        }
    }

    public void definirHorario() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value = '11:11';", regrasOfertas.obterPeriodoInicial());
        executor.executeScript("arguments[0].value = '13:10';", regrasOfertas.obterPeriodoFinal());
        Bvruaajm_FileOperations.definirPropriedade("regrasOfertas", "horarioInicial", "11:11");
        Bvruaajm_FileOperations.definirPropriedade("regrasOfertas", "horarioFinal", "13:10");
    }


    public void selecionarFormaDeConsumo(String consumoEntrega, String consumoRetirada, String consumoLocal) {
         
        if(consumoEntrega.equals("Entrega")) {
            regrasOfertas.obterFormaEntregre().clicar();      
            
        } if(consumoRetirada.equals("Retirada")) {
            regrasOfertas.obterFormaRetirada().clicar();
            
        } if(consumoLocal.equals("null")) {
            regrasOfertas.obterFormaConsumoLocal().clicar();
        }
    }

    public void selecionarOutrasOpcoes(String outrosOfertas , String outrosFeriado) {

        if(outrosOfertas.equals("Ofertas")) { 
            regrasOfertas.obterOutroOfertas().scrollIntoView().clicar();
            
        }if(outrosFeriado.equals("Feriado")) {
            regrasOfertas.obterOutroFeriados().scrollIntoView().clicar();
            
        }
    }

    public void selecionarItensIncluso(String itensCouvert, String itensSobremesas , String itensTaxaServico , String itensBebidas) {
        
        if(itensCouvert.equals("Couvert")) {
            regrasOfertas.obterInclusoCouvert().scrollIntoView().clicar();
            
        } if(itensSobremesas.equals("Sobremesa")) {
            regrasOfertas.obterInclusoSobremesas().scrollIntoView().clicar();
            
        } if(itensTaxaServico.equals("Taxa")) {
            regrasOfertas.obterInclusoTaxasServicos().scrollIntoView().clicar();
            
        } if(itensBebidas.equals("Bebidas")) {
            regrasOfertas.obterInclusoBebidas().scrollIntoView().clicar();
        }
    }

    public void avancarEtapa() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", genericOfertasPage.obterBotaoContinuar());
        genericOfertasPage.obterBotaoContinuar().click();

    }

    public void avancarEtapaImagem() {
        genericOfertasPage.obterBotaoContinuarEtapaImagem().clicar();
    }

    public void criarOfertaRegrasDaOferta(String nomeOferta, String descricao, String deValor, String porValor) {
        avancarEtapaInformativaOferta();
        preencheEtapaDescricaoOferta(nomeOferta, descricao);
        avancarEtapa();
        preencherEtapaValorDaOferta(deValor, porValor);
        avancarEtapa();
        selecionarImagemDaOferta();
        avancarEtapaImagem();

    }

    public void selecionarHorarioInicial(String horas, String minutos) {
        regrasOfertas.obterBotaoHoraInicial().clicar();
        definirContextoNativo();
        if (Integer.valueOf(horas) < 12) {
            regrasOfertas.obterBotaoAmRelogio().click();
            regrasOfertas.obterPonteiro(horas).click();
            regrasOfertas.obterPonteiro(minutos).click();
        }else {
            String horasPm = String.valueOf(Integer.valueOf(horas) - 12);
            regrasOfertas.obterBotaoPmRelogio().click();
            regrasOfertas.obterPonteiro(horasPm).click();
            regrasOfertas.obterPonteiro(minutos).click();
        }
        regrasOfertas.obterBotaoSetRelogio().click();
        definirContextoWebview();
        horas = Bvruaajm_Formatador.formatarTempo(Integer.valueOf(horas));
        Bvruaajm_FileOperations.definirPropriedade("regrasOfertas", "horaInical", horas + ":" + minutos);
    }

    public void selecionarHorarioFinal(String horas, String minutos) {
        regrasOfertas.obterBotaoHoraFinal().clicar();
        definirContextoNativo();
        if (Integer.valueOf(horas) < 12) {
            regrasOfertas.obterBotaoAmRelogio().click();
            regrasOfertas.obterPonteiro(horas).click();
            regrasOfertas.obterPonteiro(minutos).click();
        }else {
            String horasPm = String.valueOf(Integer.valueOf(horas) - 12);
            regrasOfertas.obterBotaoPmRelogio().click();
            regrasOfertas.obterPonteiro(horasPm).click();
            regrasOfertas.obterPonteiro(minutos).click();
        }
        regrasOfertas.obterBotaoSetRelogio().click();
        definirContextoWebview();
        horas = Bvruaajm_Formatador.formatarTempo(Integer.valueOf(horas));
        Bvruaajm_FileOperations.definirPropriedade("regrasOfertas", "horaFinal", horas + ":" + minutos);
    }

    public void selecionarHorarioRandomico() {
        Random random = new Random();
        String horaInicial = Integer.toString(random.nextInt(22));
        String minutosInicial = Bvruaajm_Formatador.formatarTempo(random.nextInt(11) * 5);
        String horaFinal = Integer.toString(random.nextInt(24 - Integer.parseInt(horaInicial)) + Integer.parseInt(horaInicial));
        String minutosFinal = Bvruaajm_Formatador.formatarTempo(random.nextInt(11) * 5);
        
        selecionarHorarioInicial(horaInicial, minutosInicial);
        selecionarHorarioFinal(horaFinal, minutosFinal);
    }

    public void selecionarTooltip() {
        regrasOfertas.obterTooltip().clicar();
    }
    
    public void avancarEtapaTermoDeAdesao() {
        termoAdesao.obterBotaoLiAceito().clicar();
    }
    
    public void avancarEtapaConfirmacao() {
        criacaoSucessoPage.obterBotaoIrParaOPrograma().clicar();
    }
    

}
