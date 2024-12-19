package bergs.Bvr.Bvruaajm.test.tests.conexoes.ofertas;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.conexoes.ofertas.Bvruaajm_CriacaoOfertasTask;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskBag;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobileBag;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBag;
import bergs.Bvr.Bvruaajm.test.utils.constantes.ofertas.Bvruaajm_TermoAdesaoConstante;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumServidores;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;
import bergs.Bvr.Bvruaajm.test.validations.conexoes.ofertas.Bvruaajm_TermoAdesaoValidation;

public class Bvruaajm_TermoDeAdesaoTest extends Bvruaajm_TesteBaseMobileBag{
    
    private Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.Matheus.obterCartaoAcesso();
    private Bvruaajm_Estabelecimento estabeleciomento = Bvruaajm_EnumEstabelecimentoConveniado.LucianeCorreaGarcia.obterEstabelecimento();
    
    private Bvruaajm_TaskBag taskBag;
    private Bvruaajm_CriacaoOfertasTask ofertasTask;
    private Bvruaajm_TermoAdesaoValidation termoAdesao;
    private Bvruaajm_CriacaoOfertasTask criacaoOfertas;
    private Bvruaajm_SqlBag sqlBag;

    @BeforeEach
    public void antesDoTeste() {
        sqlBag = new Bvruaajm_SqlBag();
        sqlBag.deletarOfertaEc(estabeleciomento.obterCnpjZerosAEsquerda());
        sqlBag.atualizarTermoDeAdesao(estabeleciomento.obterCnpjZerosAEsquerda(), "");
        taskBag.verificaServidorUsuarioLogado(cartaoAcesso , estabeleciomento , Bvruaajm_EnumServidores.WW27.toString());
        taskBag.criarNovaOferta();
        ofertasTask.criarOfertaRegrasDaOferta("teste", "teste", "1000", "500");
        ofertasTask.selecionarRegrasDaOferta(Arrays.asList("Segunda"), "" , "Retirada" , "" , "" , "" , "" , "" , "" , "");
        ofertasTask.avancarEtapa();
        ofertasTask.avancarEtapa();
    }
 
    @Test
    @Tag("regressaoObrigatoriaBag")
    @Tag("BAG")
    public void assinarNovamenteTermoAdesao() {
        termoAdesao.validaTelaTermoDeAdesao(Bvruaajm_TermoAdesaoConstante.TITULO, Bvruaajm_TermoAdesaoConstante.SUBTITULO);
        criacaoOfertas.avancarEtapaTermoDeAdesao();
        termoAdesao.validaModalTermoMaisUmaAssinatura(Bvruaajm_TermoAdesaoConstante.TITULO_MODAL, Bvruaajm_TermoAdesaoConstante.SUBTITULO_MODAL);
    }
    
    @AfterEach
    public void depoisDoTeste() {
        sqlBag.atualizarTermoDeAdesao(estabeleciomento.obterCnpjZerosAEsquerda(), "ASSINADO");
    }
}
