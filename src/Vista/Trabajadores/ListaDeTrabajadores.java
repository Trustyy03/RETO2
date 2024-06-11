package Vista.Trabajadores;

import Modelo.Entidades.Empresa;

import javax.swing.*;
import java.awt.*;

public class ListaDeTrabajadores extends JPanel {
    JList<Empresa> trabajadores;

    public ListaDeTrabajadores() {
        setLayout(new BorderLayout());

        //trabajadores = new JTable<>();
        //add(trabajadores, BorderLayout.CENTER);

    }

}
