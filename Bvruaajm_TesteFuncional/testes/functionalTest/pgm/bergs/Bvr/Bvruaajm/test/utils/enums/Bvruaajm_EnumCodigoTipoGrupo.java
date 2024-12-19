package bergs.Bvr.Bvruaajm.test.utils.enums;

public enum Bvruaajm_EnumCodigoTipoGrupo {

    GrupoADM("GVRADM"),
    GrupoAgencia("GVRAGE"),
    GrupoAtualizaLimiteLink("GVRALI"),
    GrupoUserConsulta("GVRCON"),
    GrupoUserAtualiza("GVRATU");
    
    private String texto;
    
    private Bvruaajm_EnumCodigoTipoGrupo(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return texto;
    }
}
