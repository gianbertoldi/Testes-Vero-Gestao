package bergs.Bvr.Bvruaajm.test.tests.conexoes.ofertas;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.conexoes.ofertas.Bvruaajm_CriacaoOfertasTask;
import bergs.Bvr.Bvruaajm.test.tasks.conexoes.ofertas.Bvruaajm_EdicaoOfertaTask;
import bergs.Bvr.Bvruaajm.test.tasks.conexoes.ofertas.Bvruaajm_RevisaoOfertaTask;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskBag;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobileBag;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_FakeGenerator;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumServidores;
import bergs.Bvr.Bvruaajm.test.utils.enums.conexao.oferta.Bvruaajm_EnumDiasSemanaOfertas;
import bergs.Bvr.Bvruaajm.test.utils.enums.conexao.oferta.Bvruaajm_EnumEdicaoOferta;
import bergs.Bvr.Bvruaajm.test.utils.enums.conexao.oferta.Bvruaajm_EnumOpcoesEdicaoOferta;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;
import bergs.Bvr.Bvruaajm.test.validations.conexoes.ofertas.Bvruaajm_CriacaoOfertasValidation;
import bergs.Bvr.Bvruaajm.test.validations.conexoes.ofertas.Bvruaajm_EdicaoOfertaValidation;


public class Bvruajm_EdicaoDaOfertaTeste extends Bvruaajm_TesteBaseMobileBag {

    private Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.Vinicius.obterCartaoAcesso();
    private Bvruaajm_Estabelecimento estabelecimento = Bvruaajm_EnumEstabelecimentoConveniado.BetosLancheriaLtda.obterEstabelecimento();
    private Bvruaajm_FakeGenerator faker;
    
    private Bvruaajm_TaskBag taskBag;
    private Bvruaajm_CriacaoOfertasTask criacaoOferta;
    private Bvruaajm_RevisaoOfertaTask revisaoTask;
    private Bvruaajm_EdicaoOfertaValidation edicaoOfertaValidation;
    private Bvruaajm_EdicaoOfertaTask edicaoOfertaTask;
    private Bvruaajm_CriacaoOfertasValidation criacaoOfetaValidation;
    
    @BeforeEach
    public void antesDoTeste() {
        List<String> diasDaOferta = Arrays.asList(Bvruaajm_EnumDiasSemanaOfertas.TODOS_OS_DIAS.toString());
        taskBag.verificaServidorUsuarioLogado(cartaoAcesso, estabelecimento, Bvruaajm_EnumServidores.WW27.toString());
        taskBag.criarNovaOferta();
        criacaoOferta.avancarEtapaInformativaOferta();
        criacaoOferta.preencheEtapaDescricaoOferta("Teste","teste");
        criacaoOferta.avancarEtapa();
        criacaoOferta.preencherEtapaValorDaOferta("1000","200");
        criacaoOferta.avancarEtapa();
        criacaoOferta.selecionarImagemDaOferta();
        criacaoOferta.avancarEtapaImagem();
        criacaoOferta.selecionarRegrasDaOferta(diasDaOferta,"","Retirada","","","","","","","");
        criacaoOferta.avancarEtapa();
    }
    
    @SuppressWarnings("static-access")
    @Tag("BAG")
    @Tag("Edicao_Oferta")
    @Test
    @DisplayName("Alteracao da Descricao da Oferta")
    public void alterarDescricaoDaOferta() {
        String novaDescricao = faker.obterDescricaoLorem();

        revisaoTask.editarInformacoesOferta(Bvruaajm_EnumOpcoesEdicaoOferta.EDICAO_DESCRICAO.toString());
        edicaoOfertaValidation.validaTelaEdicaoDaOferta(Bvruaajm_EnumEdicaoOferta.TITULO_DESCRICAO.toString(), Bvruaajm_EnumEdicaoOferta.SUBTITULO_DESCRICAO.toString());  
        edicaoOfertaTask.alterarDescricao(novaDescricao);
        criacaoOfetaValidation.validaEdicaoDeDescricao(novaDescricao);
    }
    
    @Tag("BAG")
    @Tag("Edicao_Oferta")
    @Test
    @DisplayName("Alteracao dos dias da Oferta")
    public void alterarRegrasDaOfertaDias() {
        List<String> diasDaOferta = Arrays.asList(Bvruaajm_EnumDiasSemanaOfertas.SEGUNDA.toString());
        revisaoTask.editarInformacoesOferta(Bvruaajm_EnumOpcoesEdicaoOferta.EDICAO_DIAS_HORA.toString());
        edicaoOfertaValidation.validaTelaEdicaoDiasDaOferta(Bvruaajm_EnumEdicaoOferta.TITULO_REGRAS.toString(), Bvruaajm_EnumEdicaoOferta.SUBTITULO_REGRAS.toString());  
        criacaoOferta.selecionarDiasDaOferta(diasDaOferta);
        edicaoOfertaTask.salvarEdicao();
        criacaoOfetaValidation.validaEdicaoDiasOferta(Bvruaajm_EnumDiasSemanaOfertas.SEGUNDA.toString().toLowerCase());
    }
    
    @Tag("BAG")
    @Tag("Edicao_Oferta")
    @Test
    @DisplayName("Alteracao dos horarios da Oferta")
    public void alterarRegrasDaOfertaHorarios() {

        revisaoTask.editarInformacoesOferta(Bvruaajm_EnumOpcoesEdicaoOferta.EDICAO_DIAS_HORA.toString());
        edicaoOfertaValidation.validaTelaEdicaoDiasDaOferta(Bvruaajm_EnumEdicaoOferta.TITULO_REGRAS.toString(), Bvruaajm_EnumEdicaoOferta.SUBTITULO_REGRAS.toString());  
        criacaoOferta.selecionarHorarioInicial("8","30");
        criacaoOferta.selecionarHorarioFinal("10","45");
        edicaoOfertaTask.salvarEdicao();
        criacaoOfetaValidation.validaEdicaoHorarioOferta();
        
    }
    
    @Tag("BAG")
    @Tag("Edicao_Oferta")
    @Test
    @DisplayName("Alteracao do nome da Oferta")
    public void alterarRegrasDaOfertaNome() {
        String nome = Bvruaajm_FakeGenerator.obterNomeSobrenome();
        
        revisaoTask.editarInformacoesOferta(Bvruaajm_EnumOpcoesEdicaoOferta.EDICAO_NOME.toString());
        edicaoOfertaValidation.validaTelaEdicaoNome(Bvruaajm_EnumEdicaoOferta.TITULO_NOME.toString(), Bvruaajm_EnumEdicaoOferta.SUBTITULO_NOME.toString());  
        edicaoOfertaTask.alterarNome(nome);
        edicaoOfertaTask.salvarEdicao();
        criacaoOfetaValidation.validaEdicaoDoNomeOferta(nome , "Teste");
        
    }
    
    @Tag("BAG")
    @Tag("Edicao_Oferta")
    @Test
    @DisplayName("Alteracao das regras para utilizacao da Oferta")
    public void alterarRegrasDeUtilizacaoOferta() {
        String ofertaConsumoNova = "Válido para consumo no local, entrega e retirada no local.";
        String ofertaValidaPrimeiraNova = "Válida com outras ofertas.";
        String OfertaValidaSegundaNova = "Válida para feriados.";
        String ofertaConsumoAntiga = "Válido para consumo no local e retirada no local.";
        String ofertaValidaPrimeiraAntiga = "Não válida com outras ofertas.";
        String OfertaValidaSegundaAntiga ="Não válida para feriados.";
        
                
        revisaoTask.editarInformacoesOferta(Bvruaajm_EnumOpcoesEdicaoOferta.EDICAO_REGRAS.toString());
        edicaoOfertaValidation.validaTelaEdicaoRegras(Bvruaajm_EnumEdicaoOferta.TITULO_REGRAS.toString(),Bvruaajm_EnumEdicaoOferta.SUBTITULO_REGRAS.toString());
        criacaoOferta.selecionarFormaDeConsumo("Entrega","","");
        criacaoOferta.selecionarOutrasOpcoes("Ofertas", "Feriado");
        edicaoOfertaTask.salvarEdicao();
        criacaoOfetaValidation.validaEdicaoRegrasDaOferta(ofertaConsumoNova, ofertaValidaPrimeiraNova, OfertaValidaSegundaNova, ofertaConsumoAntiga, ofertaValidaPrimeiraAntiga, OfertaValidaSegundaAntiga);
    }
    
    @Tag("BAG")
    @Tag("Edicao_Oferta")
    @Test
    @DisplayName("Alteracao dos valores da Oferta")
    public void alterarValoresDaOferta() {
        String valorPorAntigo = "1000";
        String valorDeAntigo = "200";
        String valorPorNovo = "9000";
        String valorDeNovo = "8000";
        
        revisaoTask.editarInformacoesOferta(Bvruaajm_EnumOpcoesEdicaoOferta.VALOR.toString());
        criacaoOferta.preencherEtapaValorDaOferta(valorPorNovo, valorDeNovo);
        edicaoOfertaTask.salvarEdicao();

        criacaoOfetaValidation.validaEdicaoValoresOferta(valorDeNovo, valorPorNovo,  valorDeAntigo, valorPorAntigo);
    }
    
    /*
     * Para rodar o teste é preciso ter uma uma imagem com o nome hamburger dentro da mesma area que a imagem de 
     * criacao da oferta
     */
    @Tag("BAG")
    @Tag("Edicao_Oferta")
    @Test
    @DisplayName("Alteracao da imagem da oferta")
    public void alterarImagemDaOferta() {
        String primeiraImagem = revisaoTask.obterSrcImagem();
        revisaoTask.editarImagemOferta();
        edicaoOfertaValidation.validaTelaEdicaoImagem(Bvruaajm_EnumEdicaoOferta.TITULO_IMAGEM.toString(),Bvruaajm_EnumEdicaoOferta.SUBTITULO_IMAGEM.toString());
        edicaoOfertaTask.alteraImagemEdicao("Hamburguer");

        String segundaImagem = revisaoTask.obterSrcImagem();
        criacaoOfetaValidation.validaEdicaoDaImagem(primeiraImagem, segundaImagem);
    }
    
}
