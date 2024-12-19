package bergs.Bvr.Bvruaajm.test.tests.servicos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.servicos.Bvruaajm_ServicosTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;

public class Bvruaajm_ValidaGeolocalizacaoTest extends Bvruaajm_TesteBaseMobile {
    
    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.ConsultoriaInfoteca.obterEstabelecimento();
    Bvruaajm_ServicosTask servicoTask;
    Bvruaajm_GenericTask genericTask;
    String txtEstabeleciomento = "Selecione o estabelecimento";
    String nomeFantasia = "CONSULTORIA INFOTECA";
    String lougadouro = "RUA CALDAS JUNIOR";
    String tituloContato = "3. Contato";
    String tituloInfoAtividade = "4. Informações da Atividade";

    @BeforeEach
    public void iniciaTeste() {
        servicoTask = new Bvruaajm_ServicosTask(driver);
        genericTask = new Bvruaajm_GenericTask(driver);
        taskMobile.definirContextoWebview();
        genericTask.prepararTesteLogado(cartaoAcesso);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
    }
    
    @Tag("Servicos")
    @Test
    @DisplayName("Teste faz o Fluxo completo das paginas da geolocalização")
    public void validaFluxoGeolocalizacao() {
        genericTask.clicarBotaoServicos();
        servicoTask.fluxoValidaGeolocalizacao(txtEstabeleciomento, nomeFantasia, lougadouro, tituloContato, tituloInfoAtividade);
    }
    
    @Tag("Servicos")
    @Test
    @DisplayName("Teste verifica o funcionamento do botão da geolocalização no carrosel da home")
    public void validaGeolocalizaCarroselHome() {
        servicoTask.verificaGeolocalizacaoCarroselHome(txtEstabeleciomento);
    }
}
