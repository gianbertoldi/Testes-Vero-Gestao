package bergs.Bvr.Bvruaajm.test.utils.enums.conexao.oferta;

public enum Bvruaajm_EnumStatusDaOferta {

    ANALISE("Em an�lise"),
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
