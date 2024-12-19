package bergs.Bvr.Bvruaajm.test.tests.conexoes.cricaoPerfil;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.conexoes.criacaoPerfil.Bvruaajm_CadastroPerfilEcTask;
import bergs.Bvr.Bvruaajm.test.tasks.conexoes.edicaoPerfil.Bvruaajm_EdicaoPerfilTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_OnboardingTask;
import bergs.Bvr.Bvruaajm.test.tasks.home.Bvruaajm_HomeTask;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskBag;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobileBag;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_FakeGenerator;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBag;
import bergs.Bvr.Bvruaajm.test.utils.constantes.criacaoPerfil.Bvruaajm_CriacaoPerfilConstante;
import bergs.Bvr.Bvruaajm.test.utils.constantes.ofertas.Bvruaajm_HomeOfertasVaziaConstante;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumServidores;
import bergs.Bvr.Bvruaajm.test.utils.enums.conexao.Bvruaajm_EnumCategoriaNegocio;
import bergs.Bvr.Bvruaajm.test.utils.enums.conexao.Bvruaajm_EnumOnboardingin;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;
import bergs.Bvr.Bvruaajm.test.validations.conexoes.Bvruaajm_OnboardingValidation;
import bergs.Bvr.Bvruaajm.test.validations.conexoes.criacaoPerfil.Bvruaajm_PrimeiroAcessoValidation;
import bergs.Bvr.Bvruaajm.test.validations.conexoes.ofertas.Bvruaajm_HomeOfertasValidation;

public class Bvruaajm_CriacaoDoPerfilTest extends Bvruaajm_TesteBaseMobileBag {

    private Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.Vinicius.obterCartaoAcesso();
    private Bvruaajm_Estabelecimento estabeleciomento = Bvruaajm_EnumEstabelecimentoConveniado.CasaDoPintor7Teste.obterEstabelecimento();

    private Bvruaajm_GenericTask genericTask;
    private Bvruaajm_TaskMobile taskMobile;
    private Bvruaajm_HomeTask homeTask;
    private Bvruaajm_OnboardingValidation onboardingValidation;
    private Bvruaajm_OnboardingTask onboardingTask;
    private Bvruaajm_CadastroPerfilEcTask cadastroPerfilEc;
    private Bvruaajm_PrimeiroAcessoValidation primeiroAcessoValidation;
    private Bvruaajm_EdicaoPerfilTask edicaoPerfil;
    private Bvruaajm_SqlBag sqlBag;
    private Bvruaajm_HomeOfertasValidation homeValidation;
    private Bvruaajm_TaskBag taskBag;
    

    @BeforeEach
    public void antesDoTeste() {
        homeTask.resetarAplicativo();
        sqlBag = new Bvruaajm_SqlBag();
        sqlBag.deletarOfertaEc(estabeleciomento.obterCnpjZerosAEsquerda());
        sqlBag.deletarEc(estabeleciomento.obterCnpjZerosAEsquerda());
        taskBag.trocaServiador(Bvruaajm_EnumServidores.WW27.toString());
        genericTask.prepararTesteLogado(cartaoAcesso);
        taskMobile.definirContextoWebview();
        genericTask.selecionaEstabelecimentoOuConveniado(Bvruaajm_EnumEstabelecimentoConveniado.CasaDoPintor7Teste.obterEstabelecimento());
        genericTask.selecionaEstabelecimentoOuConveniado(estabeleciomento);
        homeTask.clicarCardConexoes();
    }

    @Test
    @Tag("BAG")
    @Tag("regressaoObrigatoriaBag")
    @DisplayName("Teste de primeiro acesso e criacao do perfil EC")
    public void primeiroAcessoAPlataforma() {
        String descricao = Bvruaajm_FakeGenerator.obterDescricaoLorem();
        String face = Bvruaajm_FakeGenerator.obterFacebook();
        String instagram = Bvruaajm_FakeGenerator.obterInstagram();
        List<String> redesSociais = Arrays.asList(instagram, face);

        onboardingValidation.validaOnboarding(1, Bvruaajm_EnumOnboardingin.ONBOARDING_PRIMEIRO_ACESSO_TITULO1.toString(),Bvruaajm_EnumOnboardingin.ONBOARDING_PRIMEIRO_ACESSO_MENSAGEM.toString());
        onboardingTask.avancarEtapaOnboarding();
        onboardingValidation.validaOnboarding(2, Bvruaajm_EnumOnboardingin.ONBOARDING_PRIMEIRO_ACESSO_TITULO2.toString(),Bvruaajm_EnumOnboardingin.ONBOARDING_PRIMEIRO_ACESSO_MENSAGEM2.toString());
        onboardingTask.avancarEtapaOnboarding();
        onboardingValidation.validaOnboarding(3, Bvruaajm_EnumOnboardingin.ONBOARDING_PRIMEIRO_ACESSO_TITULO3.toString(),Bvruaajm_EnumOnboardingin.ONBOARDING_PRIMEIRO_ACESSO_MENSAGEM3.toString());
        onboardingTask.avancarEtapaOnboarding();
        cadastroPerfilEc.avancarEtapaInformativoPerfil();
        cadastroPerfilEc.selecionarTipoCategoria(Bvruaajm_EnumCategoriaNegocio.PADARIA.toString());
        cadastroPerfilEc.preencherDescricaoNegocio(descricao);
        cadastroPerfilEc.preencherRedesSociais(instagram, face, "");
        cadastroPerfilEc.escolherLogoMarca("");
        primeiroAcessoValidation.validaPerfilEcCompleto("CASA DO PINTOR", Bvruaajm_EnumCategoriaNegocio.PADARIA.toString(), descricao,"Rua Alberto Zolin Filho\nHipica, Porto Alegre - RS", redesSociais);
        cadastroPerfilEc.finalizarCriacaoPerfil();
        primeiroAcessoValidation.validaCriacaoPerfil(Bvruaajm_CriacaoPerfilConstante.CRIACAO_PERFIL_TITULO , Bvruaajm_CriacaoPerfilConstante.CRIACAO_PERFIL_MENSAGEM_SUCESSO , Bvruaajm_CriacaoPerfilConstante.CRIACAO_PERFIL_TEXTO_BOTAO_CADASTRO , Bvruaajm_CriacaoPerfilConstante.CRIACAO_PERFIL_TEXTO_BOTAO_HOME);
        cadastroPerfilEc.irParaHome();
        homeValidation.validaHomeVazia(Bvruaajm_HomeOfertasVaziaConstante.TITULO, Bvruaajm_HomeOfertasVaziaConstante.SUBTITULO, Bvruaajm_HomeOfertasVaziaConstante.BOTAO);
    }

    @Test
    @Tag("BAG")
    @Tag("EdicaoPerfil")
    @DisplayName("Teste para editar descricao do negocio")
    public void edicaoDaDescricaoDoNegocio() {
        String descricao = Bvruaajm_FakeGenerator.obterDescricaoLorem();
        String novaDescricao = Bvruaajm_FakeGenerator.obterDescricaoLorem();
        String face = Bvruaajm_FakeGenerator.obterFacebook();
        String instagram = Bvruaajm_FakeGenerator.obterInstagram();
        List<String> redesSociais = Arrays.asList(instagram, face);
        onboardingTask.verificaPularOnboardingGeneric();
        cadastroPerfilEc.criarPerfilEcCompleto(Bvruaajm_EnumCategoriaNegocio.PADARIA.toString(), descricao, instagram, face, "", "");
        edicaoPerfil.selecionarDescricaoEdicaoNegocio();
        edicaoPerfil.preencherDescicaoEdicaoNegocio(novaDescricao);
        primeiroAcessoValidation.validaPerfilEcCompleto("CASA DO PINTOR", Bvruaajm_EnumCategoriaNegocio.PADARIA.toString(), novaDescricao,"Rua Alberto Zolin Filho\nHipica, Porto Alegre - RS", redesSociais);
    }

    @Test
    @Tag("BAG")
    @Tag("EdicaoPerfil")
    @DisplayName("Teste para cadastrar descricao do negocio")
    public void cadastroDaDescricaoDoNegocio() {
        String descricao = Bvruaajm_FakeGenerator.obterDescricaoLorem();
        String face = Bvruaajm_FakeGenerator.obterFacebook();
        String instagram = Bvruaajm_FakeGenerator.obterInstagram();
        List<String> redesSociais = Arrays.asList(instagram, face);
        onboardingTask.verificaPularOnboardingGeneric();
        cadastroPerfilEc.criarPerfilEcCompleto(Bvruaajm_EnumCategoriaNegocio.PADARIA.toString(), "", instagram, face, "", "");
        edicaoPerfil.selecionarCadastrarDescricaoNegocio();
        edicaoPerfil.preencherDescicaoEdicaoNegocio(descricao);
        primeiroAcessoValidation.validaPerfilEcCompleto("CASA DO PINTOR", Bvruaajm_EnumCategoriaNegocio.PADARIA.toString(), descricao,"Rua Alberto Zolin Filho\nHipica, Porto Alegre - RS", redesSociais);
    }

    @Test
    @Tag("BAG")
    @Tag("EdicaoPerfil")
    @DisplayName("Teste para cadastrar descricao em branco")
    public void cadastroDescricaoEmBranco() {
        String descricao = Bvruaajm_FakeGenerator.obterDescricaoLorem();
        String face = Bvruaajm_FakeGenerator.obterFacebook();
        String instagram = Bvruaajm_FakeGenerator.obterInstagram();
        List<String> redesSociais = Arrays.asList(instagram, face);
        onboardingTask.verificaPularOnboardingGeneric();
        cadastroPerfilEc.criarPerfilEcCompleto(Bvruaajm_EnumCategoriaNegocio.PADARIA.toString(), descricao, instagram, face, "", "");
        edicaoPerfil.selecionarDescricaoEdicaoNegocio();
        edicaoPerfil.preencherDescicaoEdicaoNegocio("");
        primeiroAcessoValidation.validaPerfilEcCompleto("CASA DO PINTOR", Bvruaajm_EnumCategoriaNegocio.PADARIA.toString(), "","Rua Alberto Zolin Filho\nHipica, Porto Alegre - RS", redesSociais);
    }
    
    @Test
    @Tag("BAG")
    @Tag("EdicaoPerfil")
    @DisplayName("Teste para cadastrar Redes sociais em branco")
    public void cadastroRedesSociaisEmBranco(){
        String descricao = Bvruaajm_FakeGenerator.obterDescricaoLorem();
        String face = Bvruaajm_FakeGenerator.obterFacebook();
        String instagram = Bvruaajm_FakeGenerator.obterInstagram();
        String whatsApp = Bvruaajm_FakeGenerator.obterTelefone();
        onboardingTask.verificaPularOnboardingGeneric();
        cadastroPerfilEc.criarPerfilEcCompleto(Bvruaajm_EnumCategoriaNegocio.PADARIA.toString(), descricao, instagram, face, whatsApp, "");
        edicaoPerfil.selecionarEditarRedesSociais();
        edicaoPerfil.preencherRedesSociais("","","");
        List<String> redesSociais = Arrays.asList("","","");
        primeiroAcessoValidation.validaPerfilEcCompleto("CASA DO PINTOR", Bvruaajm_EnumCategoriaNegocio.PADARIA.toString(), descricao,
                "Rua Alberto Zolin Filho\nHipica, Porto Alegre - RS", redesSociais);
    }
    
    @Test
    @Tag("BAG")
    @Tag("EdicaoPerfil")
    @DisplayName("Teste para editar Redes sociais")
    public void edicaoRedesSociais(){
        String descricao = Bvruaajm_FakeGenerator.obterDescricaoLorem();
        String face = Bvruaajm_FakeGenerator.obterFacebook();
        String instagram = Bvruaajm_FakeGenerator.obterInstagram();
        String whatsApp = Bvruaajm_FakeGenerator.obterTelefone();
        String novoFace = Bvruaajm_FakeGenerator.obterFacebook();
        String novoInstagram = Bvruaajm_FakeGenerator.obterInstagram();
        String novoWhatsApp = Bvruaajm_FakeGenerator.obterTelefone();
        onboardingTask.verificaPularOnboardingGeneric();
        cadastroPerfilEc.criarPerfilEcCompleto(Bvruaajm_EnumCategoriaNegocio.PADARIA.toString(), descricao, instagram, face, whatsApp, "");
        edicaoPerfil.selecionarEditarRedesSociais();
        edicaoPerfil.preencherRedesSociais(novoInstagram, novoFace, novoWhatsApp);
        List<String> redesSociais = Arrays.asList(novoInstagram, novoFace, novoWhatsApp);
        primeiroAcessoValidation.validaPerfilEcCompleto("CASA DO PINTOR", Bvruaajm_EnumCategoriaNegocio.PADARIA.toString(), descricao,
                "Rua Alberto Zolin Filho\nHipica, Porto Alegre - RS", redesSociais);
    }
    
    @Test
    @Tag("BAG")
    @Tag("EdicaoPerfil")
    @DisplayName("Teste para cadastrar Redes Sociais")
    public void cadastrarRedesSociais(){
        String descricao = Bvruaajm_FakeGenerator.obterDescricaoLorem();
        String face = Bvruaajm_FakeGenerator.obterFacebook();
        String instagram = Bvruaajm_FakeGenerator.obterInstagram();
        String whatsApp = Bvruaajm_FakeGenerator.obterTelefone();
        onboardingTask.verificaPularOnboardingGeneric();
        cadastroPerfilEc.criarPerfilEcCompleto(Bvruaajm_EnumCategoriaNegocio.PADARIA.toString(), descricao, "", "", "", "");
        edicaoPerfil.selecionarCadastrarRedesSociais();
        edicaoPerfil.preencherRedesSociais(instagram, face, whatsApp);
        List<String> redesSociais = Arrays.asList(instagram, face, whatsApp);
        primeiroAcessoValidation.validaPerfilEcCompleto("CASA DO PINTOR", Bvruaajm_EnumCategoriaNegocio.PADARIA.toString(), descricao,
                "Rua Alberto Zolin Filho\nHipica, Porto Alegre - RS", redesSociais);
    }
    
    @Test
    @Tag("BAG")
    @Tag("EdicaoPerfil")
    @DisplayName("Teste para editar categoria do negocio")
    public void editarCategoriaDoNegocio(){
        String descricao = Bvruaajm_FakeGenerator.obterDescricaoLorem();
        String face = Bvruaajm_FakeGenerator.obterFacebook();
        String instagram = Bvruaajm_FakeGenerator.obterInstagram();
        List<String> redesSociais = Arrays.asList(instagram, face);
        onboardingTask.verificaPularOnboardingGeneric();
        cadastroPerfilEc.criarPerfilEcCompleto(Bvruaajm_EnumCategoriaNegocio.CAFETERIA.toString(), descricao, instagram, face, "", "");
        edicaoPerfil.selecionarEditarCategoria();
        edicaoPerfil.editarCategoria(Bvruaajm_EnumCategoriaNegocio.RESTAURENTE.toString());
        primeiroAcessoValidation.validaPerfilEcCompleto("CASA DO PINTOR", Bvruaajm_EnumCategoriaNegocio.RESTAURENTE.toString(), descricao,
                "Rua Alberto Zolin Filho\nHipica, Porto Alegre - RS", redesSociais);
    }   
    
    @Test
    @Tag("BAG")
    @Tag("EdicaoPerfil")
    @DisplayName("Teste cadastrar whats com numero fixo")
    public void cadastrarWhatsappFixo(){
        String descricao = Bvruaajm_FakeGenerator.obterDescricaoLorem();
        String whatsApp = Bvruaajm_FakeGenerator.obterTelefoneFixo();
        List<String> redesSociais = Arrays.asList(whatsApp);
        onboardingTask.verificaPularOnboardingGeneric();
        cadastroPerfilEc.criarPerfilEcCompleto(Bvruaajm_EnumCategoriaNegocio.PADARIA.toString(), descricao, "", "", whatsApp, "");
        primeiroAcessoValidation.validaPerfilEcCompleto("CASA DO PINTOR", Bvruaajm_EnumCategoriaNegocio.PADARIA.toString(), descricao,
                "Rua Alberto Zolin Filho\nHipica, Porto Alegre - RS", redesSociais);
    }
}