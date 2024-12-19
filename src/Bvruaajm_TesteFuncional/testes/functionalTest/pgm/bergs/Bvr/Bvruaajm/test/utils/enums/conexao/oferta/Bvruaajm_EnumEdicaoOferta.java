package bergs.Bvr.Bvruaajm.test.utils.enums.conexao.oferta;

public enum Bvruaajm_EnumEdicaoOferta {

    TITULO_DESCRICAO("Qual a descri��o da oferta?"),
    SUBTITULO_DESCRICAO("Insira uma descri��o detalhada que ser� exibida aos clientes para destacar as caracter�sticas da oferta."),
    TITULO_REGRAS("Regras para a utiliza��o da oferta"),
    SUBTITULO_REGRAS("Selecione as regras que se aplicam para os clientes utilizarem a oferta."),
    TITULO_NOME("Qual o nome da oferta?"),
    SUBTITULO_NOME("Insira um nome que ser� exibido aos clientes para destacar as caracter�sticas da oferta."),
    TITULO_IMAGEM("Adicione uma imagem do item da oferta"),
    SUBTITULO_IMAGEM("Este � o momento crucial para conquistar seus clientes. Selecione a melhor foto para valorizar a sua oferta.");

    private String texto;
    
    private Bvruaajm_EnumEdicaoOferta(String texto) {
        this.texto = texto;
    }
    
    @Override
    public String toString() {
        return texto;
    }
}
