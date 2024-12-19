package bergs.Bvr.Bvruaajm.test.utils.enums;

public enum Bvruaajm_EnumServidores {
    
    WW4("WW4"),
    WW27("WW27");
    
    private String texto;
    
    private Bvruaajm_EnumServidores(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return texto;
    }
}
