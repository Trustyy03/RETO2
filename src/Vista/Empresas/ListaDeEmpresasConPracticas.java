package Vista.Empresas;

import Modelo.Consultas.*;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

import static Modelo.Consultas.OperacionesConsultas.consultaDos;

public class ListaDeEmpresasConPracticas extends JPanel {

    JTable empresasConPracticas;
    DefaultTableModel modelo;

    public static String ciclo;

    public ListaDeEmpresasConPracticas() {


        empresasConPracticas = new JTable();


        add(mostrarTablaDatos());
        add(new JScrollPane(empresasConPracticas), BorderLayout.CENTER);

    }

    public JPanel mostrarTablaDatos() {
        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);
        JPanel panelDatos = new JPanel(new BorderLayout());

        String[] nombresCampos = new String[]{lenguaje.getProperty("ciclo"), "Curso escolar", "CIF empresa", "Nombre empresa", "Numero alumnos"};

        modelo = new DefaultTableModel();

        modelo.setColumnIdentifiers(nombresCampos);

        empresasConPracticas = new JTable(modelo);

        try {
            for (C2 c2 : consultaDos(BuscarEmpresaPorPractica.getCBCiclo(), BuscarEmpresaPorPractica.getCBCurso())){
                Object[] fila = new Object[] {c2.getNombreEmpresa(), c2.getCif(), c2.getCursoEscolar(), c2.getIdCiclo(), c2.getNumPracticas()};
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        JScrollPane scrollPane = new JScrollPane(empresasConPracticas);
        panelDatos.add(scrollPane, BorderLayout.CENTER);
        panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        return panelDatos;
    }

}
