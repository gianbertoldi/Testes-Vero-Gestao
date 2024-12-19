package bergs.Bvr.Bvruaajm.test.utils;

import java.text.DecimalFormat;
import java.text.Normalizer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import bergs.bmo.bmouaajm.suporte.util.Bmouaajm_Formatador;

public class Bvruaajm_Formatador extends Bmouaajm_Formatador {

    public static String formatarNumeroDuasCasasComVirgula(double valor) {
        DecimalFormat formato = new DecimalFormat("#,##0.00");
        return formato.format(valor);
    }

    public static double formatarDeStringParaDouble(String valor) {
        String valorComPonto = valor
                .replaceAll("[^\\d,]", "")
                .replace(",", "."); 
        return Double.parseDouble(valorComPonto);
    }

    public static String obterDataAtualFormatadaDB(LocalDateTime data) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return data.format(formato);
    }

    public static String obterDataAtualFormatadaDetalhamentoLink(LocalDateTime data) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");
        return data.format(formato);
    }

    public static String obterDataAtualFormatadaDiaMesAno(LocalDateTime data) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formato);
    }

    public static String formatarNomeAbreviar(String nome) {
        String[] parteNome = nome.split(" ");
        String primeroNome = parteNome[0];
        StringBuilder ultimoNomeAbreviado = new StringBuilder();
        if (parteNome.length > 1) {
            String ultimoNome = parteNome[parteNome.length - 1];
            ultimoNomeAbreviado.append(ultimoNome.charAt(0)).append(".");
        }
        return primeroNome + " " + ultimoNomeAbreviado.toString();
    }

    public static String formatarNumCartao(String cartao) {
        cartao = Bvruaajm_Formatador.preencherAEsquerda(cartao, 16, "0");
        return cartao.replaceAll("(\\d{4})(\\d{4})(\\d{4})(\\d{4})", "$1 $2 $3 $4");
    }

    public static String removeAcentoPalavraString(String value) {
        String normalized = Normalizer.normalize(value, Normalizer.Form.NFD);
        return normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
    
    public static String formatarTempo(int tempo) {
        if (tempo < 10) {
            return String.format("%02d", tempo);
        }
        return String.format("%d", tempo);
    }
    
    public static String obterCaracteresNumericos(String texto) {   
        texto = texto.replaceAll("[^-?0-9]+", ""); 
        return texto;
    }
}
