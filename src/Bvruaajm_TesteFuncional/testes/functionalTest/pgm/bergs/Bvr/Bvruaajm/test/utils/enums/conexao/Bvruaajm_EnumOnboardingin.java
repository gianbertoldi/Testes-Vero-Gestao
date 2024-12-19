package bergs.Bvr.Bvruaajm.test.utils.enums.conexao;

public enum Bvruaajm_EnumOnboardingin {

    ONBOARDING_PRIMEIRO_ACESSO_TITULO1("Junte-se a nós no Vero Ofertas"),
    ONBOARDING_PRIMEIRO_ACESSO_MENSAGEM("Faça parte do Vero Ofertas, conquiste e fidelize clientes do Banrisul para o seu negócio."),
    
    ONBOARDING_PRIMEIRO_ACESSO_TITULO2("Divulgue e cresça"),
    ONBOARDING_PRIMEIRO_ACESSO_MENSAGEM2("Crie o seu perfil, cadastre ofertas para os clientes do Banrisul e faça parte desse ecossistema."),
    
    ONBOARDING_PRIMEIRO_ACESSO_TITULO3("Impulsione o seu negócio"),
    ONBOARDING_PRIMEIRO_ACESSO_MENSAGEM3("Tenha as suas ofertas divulgadas no aplicativo do Banrisul e impulsione o seu negócio através dessa parceria.");
    
    private String opcao;
    
    private Bvruaajm_EnumOnboardingin(String opcao) {
        this.opcao = opcao;
    }
    
    @Override
    public String toString() {
        return opcao;
    }
}
