package Vista.Idioma;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Lenguaje extends Properties {
    public static final int spanish = 0;
    public static final int english = 1;
    public Lenguaje(int lang){

        //Modificar si quieres añadir mas idiomas
        switch(lang){
            case spanish:
                getProperties("./src/Vista/Idioma/espanol.properties");
                break;
            case english:
                getProperties("./src/Vista/Idioma/ingles.properties");
                break;
            default:
                getProperties("./src/Vista/Idioma/espanol.properties");
        }

    }

    private void getProperties(String langFile) {
        try {
            //  this.load( getClass().getResourceAsStream(langFile) );
            this.load( new FileInputStream(new File(langFile)));
        } catch (IOException ex) {

        }
    }
}

