package Vista.Empresas;

import Modelo.Entidades.Empresa;

import javax.swing.*;
import java.awt.*;

public class ListaDeEmpresasConPracticas extends JPanel {

    JList<Empresa> empresasConPracticas;

    public ListaDeEmpresasConPracticas(){

        empresasConPracticas = new JList<>();

        setLayout(new BorderLayout());

        add(new JScrollPane(empresasConPracticas), BorderLayout.CENTER);

    }

}
