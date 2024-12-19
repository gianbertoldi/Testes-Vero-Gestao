package bergs.Bvr.Bvruaajm.test.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

import com.github.javafaker.Faker;

public class Bvruaajm_FakeGenerator {
    
    private static Faker faker = new Faker(new Locale("pt-BR"));
    
    public static String obterDescricaoLorem() {
        return faker.lorem().characters(1,150);
    }

    public static String obterFacebook() {
        try {
            URI url = new URI("https" ,"//www.facebook.com/" , null);
            return url + faker.name().firstName().toLowerCase().replaceAll("\\s+", "").replaceAll("[^\\w\\s-]", "");
        } catch (URISyntaxException e) {
            System.out.println("Erro ao montar URL facebook " + e);
            return null;
        }  
    }
    
    public static String obterInstagram() {
        return "@"+ faker.name().lastName().toLowerCase().replaceAll("\\s+", "").replaceAll("[^\\w\\s-]", ""); 
    }
    
    public static String obterTelefone() {
        return faker.phoneNumber().cellPhone();
    }
    
    public static String obterNomeSobrenome() {
        return faker.name().firstName() + " " + faker.name().lastName();
    }
      
    public static String obterEmail() {
        return faker.internet().emailAddress();
    }
    
    public static String obterTelefoneFixo() {
        return faker.phoneNumber().phoneNumber();
    }
    
}
