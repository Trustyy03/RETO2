package Modelo;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * @see <a href="https://stackoverflow.com/questions/6567839/if-i-use-a-singleton-class-for-a-database-connection-can-one-user-close-the-con">Stackoverflow Singleton</a>
 * Patron Singleton
 * ================
 * Este patrón de diseño está diseñado para restringir la creación de objetos
 * pertenecientes a una clase. Su intención consiste en garantizar que una clase
 * sólo tenga una instancia y proporcionar un punto de acceso global a ella.
 * El patrón Singleton se implementa creando en nuestra clase un método que crea
 * una instancia del objeto sólo si todavía no existe alguna.
 * Para asegurar que la clase no puede ser instanciada nuevamente se regula el
 * alcance del constructor haciéndolo privado.
 * Las situaciones más habituales de aplicación de este patrón son aquellas en
 * las que dicha clase ofrece un conjunto de utilidades comunes para todas las
 * capas (como puede ser el sistema de log, conexión a la base de datos, ...) o
 * cuando cierto tipo de datos debe estar disponible para todos los demás objetos
 * de la aplicación.
 * El patrón Singleton provee una única instancia global gracias a que:
 * - La propia clase es responsable de crear la única instancia.
 * - Permite el acceso global a dicha instancia mediante un método de clase.
 * - Declara el constructor de clase como privado para que no sea instanciable
 * directamente.
 */
public class ConexionBDD{
    private static ConexionBDD dbInstance; //Variable para almacenar la unica instancia de la clase
    private static java.sql.Connection con;

    private static  String host = "";
    private static String username = "";
    private static String password= "";


    private ConexionBDD() {
        // El Constructor es privado!!
    }

    public static void ConfigurarConnection(){
        Properties properties = new Properties();
        File file = new File("src/Modelo/connection.config");
        try {InputStream input = new FileInputStream(file);
            properties.load(input);
            setHost(properties.getProperty("database.host"));
            setUsername(properties.getProperty("database.username"));
            setPassword(properties.getProperty("database.password"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void setPassword(String password) {
        ConexionBDD.password = password;
    }

    public static String getHost() {
        return host;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    private static void setUsername(String username) {
        ConexionBDD.username = username;
    }

    private static void setHost(String host) {
        ConexionBDD.host = host;
    }

    public static ConexionBDD getInstance(){
        //Si no hay ninguna instancia...
        if(dbInstance==null){
            dbInstance= new ConexionBDD();
        }
        return dbInstance;
    }

    public static java.sql.Connection getConnection(){

        if(con==null){
            try {
                String host = getHost();
                String username = getUsername();
                String password = getPassword();
                con = java.sql.DriverManager.getConnection( host, username, password );
                System.out.println("Conexión realizada");
            } catch (java.sql.SQLException ex) {
                System.out.println("Se ha producido un error al conectar: " + ex.getMessage());
            }
        }
        return con;
    }
}
