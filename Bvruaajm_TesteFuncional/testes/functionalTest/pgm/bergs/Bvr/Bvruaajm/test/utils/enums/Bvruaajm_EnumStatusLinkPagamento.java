package bergs.Bvr.Bvruaajm.test.utils.enums;

public enum Bvruaajm_EnumStatusLinkPagamento {

    PAGO("P"),
    ATIVO("A"),
    BLOQUEADO("B"),
    CANCELADO("C");
    
    private String opcao;
    
    private Bvruaajm_EnumStatusLinkPagamento(String opcao){
        this.opcao = opcao;
    }
    
    @Override
    public String toString() {
        return opcao;
    }
}
