package Controlador;

import javax.swing.*;

public class InicioSesionController {

    public static boolean camposVacios(JTextField... campos) {
        for (JTextField campo : campos) {
            if (campo.getText().isEmpty()) {
                return true;
            }
        }
        return false;
    }

}
