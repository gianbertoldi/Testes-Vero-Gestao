package bergs.Bvr.Bvruaajm.test.utils.enums;

public enum Bvruaajm_EnumCardsCarrossel {

    CARD_CONEXOES("conexoes"),
    TITULO_CONEXOES("Vero Ofertas"),
    MENSAGEM_CONEXOES("Impulsione suas vendas com a Vero");
    
    private String opcao;
    
    private Bvruaajm_EnumCardsCarrossel(String opcao) {
        this.opcao = opcao;
    }
    
    @Override
    public String toString() {
        return opcao;
    }
}
