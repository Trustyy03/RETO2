package Vista.Empresas;

import Modelo.Entidades.Empresa;

import javax.swing.*;
import java.awt.*;

public class BuscarEmpresaPorTecnologia extends JPanel {

    JComboBox<String> tecnologias;
    JList<Empresa> empresas;

    public BuscarEmpresaPorTecnologia(){
        tecnologias = new JComboBox<>();
        empresas = new JList<>();

        setLayout(new BorderLayout());
        add(tecnologias, BorderLayout.NORTH);

        add(new JScrollPane(empresas), BorderLayout.CENTER);
    }

}
