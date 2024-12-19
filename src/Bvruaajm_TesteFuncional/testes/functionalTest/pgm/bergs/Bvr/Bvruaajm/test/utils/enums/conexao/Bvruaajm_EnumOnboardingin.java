package bergs.Bvr.Bvruaajm.test.utils.enums.conexao;

public enum Bvruaajm_EnumOnboardingin {

    ONBOARDING_PRIMEIRO_ACESSO_TITULO1("Junte-se a n�s no Vero Ofertas"),
    ONBOARDING_PRIMEIRO_ACESSO_MENSAGEM("Fa�a parte do Vero Ofertas, conquiste e fidelize clientes do Banrisul para o seu neg�cio."),
    
    ONBOARDING_PRIMEIRO_ACESSO_TITULO2("Divulgue e cres�a"),
    ONBOARDING_PRIMEIRO_ACESSO_MENSAGEM2("Crie o seu perfil, cadastre ofertas para os clientes do Banrisul e fa�a parte desse ecossistema."),
    
    ONBOARDING_PRIMEIRO_ACESSO_TITULO3("Impulsione o seu neg�cio"),
    ONBOARDING_PRIMEIRO_ACESSO_MENSAGEM3("Tenha as suas ofertas divulgadas no aplicativo do Banrisul e impulsione o seu neg�cio atrav�s dessa parceria.");
    
    private String opcao;
    
    private Bvruaajm_EnumOnboardingin(String opcao) {
        this.opcao = opcao;
    }
    
    @Override
    public String toString() {
        return opcao;
    }
}
