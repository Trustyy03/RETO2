package Vista.Trabajadores;

import Modelo.Entidades.Empresa;
import Modelo.Entidades.Trabajador;

import javax.swing.*;
import java.awt.*;

public class HistorialContactosEmpresa extends JPanel {

    JComboBox<Empresa> empresas;
    JList<Trabajador> contactos;

    public HistorialContactosEmpresa(){
        empresas = new JComboBox<>();
        contactos = new JList<>();

        setLayout(new BorderLayout());
        add(empresas, BorderLayout.NORTH);

        add(new JScrollPane(empresas), BorderLayout.CENTER);
    }

}
