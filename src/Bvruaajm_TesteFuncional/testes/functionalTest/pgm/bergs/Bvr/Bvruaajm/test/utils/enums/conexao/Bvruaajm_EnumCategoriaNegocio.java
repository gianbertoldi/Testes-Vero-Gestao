package bergs.Bvr.Bvruaajm.test.utils.enums.conexao;

public enum Bvruaajm_EnumCategoriaNegocio {
    
    RESTAURENTE("Restaurante"),
    PADARIA("Padaria"),
    ARMAZEM("Armazém"),
    CAFETERIA("Cafeteria"),
    BAR("Bar"),
    OUTROS("Outros");
    
    private String opcao;
    
    private Bvruaajm_EnumCategoriaNegocio(String opcao) {
        this.opcao = opcao;
    }
    
    @Override
    public String toString() {
        return opcao;
    }
}
