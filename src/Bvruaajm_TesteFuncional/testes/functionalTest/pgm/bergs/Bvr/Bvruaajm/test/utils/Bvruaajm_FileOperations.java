package bergs.Bvr.Bvruaajm.test.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Properties;

public class Bvruaajm_FileOperations {

    private static final String DIR_PATH_PROPERTIES = System.getProperty("user.dir") + File.separator  + "resources" + File.separator + "propriedades";
    
    public static Properties obterPropriedade(String nomeDoArquivo) { 
        InputStream input = null;
        Properties propriedade = new Properties();
        
        try { 
            
            input = new FileInputStream(DIR_PATH_PROPERTIES + File.separator + nomeDoArquivo + ".properties");
            propriedade.load( new InputStreamReader(input , Charset.forName("UTF-8")));
            input.close();
            
        }catch(IOException e) {
            e.printStackTrace();
        }
        
        return propriedade;
    }
    
    
    public static void definirPropriedade(String nomeArquivo , String propriedadeChave , String propriedadeValor) {
        
        Properties propriedade = obterPropriedade(nomeArquivo);
        
        try { 
            OutputStream outputStream = new FileOutputStream(DIR_PATH_PROPERTIES + File.separator + nomeArquivo + ".properties");
            propriedade.setProperty(propriedadeChave, propriedadeValor);
            propriedade.store(outputStream, null);
            
            outputStream.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}