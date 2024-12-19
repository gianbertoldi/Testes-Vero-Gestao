package bergs.Bvr.Bvruaajm.test.utils.enums.conexao.oferta;

public enum Bvruaajm_EnumStatusDaOferta {

    ANALISE("Em análise"),
    ATIVA("Ativa");
    
    private String opcao;
    
    private Bvruaajm_EnumStatusDaOferta(String opcao) {
        this.opcao = opcao;
    }
    
    @Override
    public String toString() {
        return opcao;
    }
}
