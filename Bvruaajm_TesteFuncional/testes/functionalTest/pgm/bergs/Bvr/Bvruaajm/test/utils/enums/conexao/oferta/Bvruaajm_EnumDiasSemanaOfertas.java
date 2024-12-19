package bergs.Bvr.Bvruaajm.test.utils.enums.conexao.oferta;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Bvruaajm_EnumDiasSemanaOfertas {

    SEGUNDA("Segunda"),
    TERCA("Terca"),
    QUARTA("Quarta"),
    QUINTA("Quinta"),
    SEXTA("Sexta"),
    SABADO("Sabado"),
    DOMINGO("Domingo"),
    TODOS_OS_DIAS("Todos os dias");
   
    private static final List<Bvruaajm_EnumDiasSemanaOfertas> valores = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int tamanho = valores.size();
    private static final Random random = new Random();
    
    private String texto;
    
    private Bvruaajm_EnumDiasSemanaOfertas(String texto) {
        this.texto = texto;
    }

    public static Bvruaajm_EnumDiasSemanaOfertas diasDaSemanaAleatorios() { 
        return valores.get(random.nextInt(tamanho));
    }
    
    @Override
    public String toString() {
        return texto;
    }
}
