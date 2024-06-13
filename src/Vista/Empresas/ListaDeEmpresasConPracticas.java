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
    static DefaultTableModel modelo;
    static String[] nombresCampos;
    public static String headerCiclo, headerCursoEscolar, headerCifEmpresa, headerNombreEmpresa, headerNumeroAlumnos;

    public ListaDeEmpresasConPracticas() {
        empresasConPracticas = new JTable();

        add(mostrarTablaDatos());
        JScrollPane scrollPane = new JScrollPane(empresasConPracticas);
        scrollPane.setPreferredSize(new Dimension(700,700));
        empresasConPracticas.setRowHeight(50);
        add(scrollPane, BorderLayout.CENTER);
    }

    public JPanel mostrarTablaDatos() {
        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);
        headerNombreEmpresa = lenguaje.getProperty("nombreEmpresa");
        headerCifEmpresa = lenguaje.getProperty("cifEmpresa");
        headerCursoEscolar = lenguaje.getProperty("cursoEscolarFCT");
        headerCiclo = lenguaje.getProperty("ciclo");
        headerNumeroAlumnos = lenguaje.getProperty("numAlumnosFCT");

        JPanel panelDatos = new JPanel(new BorderLayout());

        nombresCampos = new String[]{headerNombreEmpresa, headerCifEmpresa, headerCursoEscolar, headerCiclo, headerNumeroAlumnos};
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(nombresCampos);
        empresasConPracticas = new JTable(modelo);

        try {
            for (Consulta2 consulta2 : consultaDos(BuscarEmpresaPorPractica.getCBCiclo(), BuscarEmpresaPorPractica.getCBCurso())){
                Object[] fila = new Object[] {consulta2.getNombreEmpresa(), consulta2.getCif(), consulta2.getCursoEscolar(), consulta2.getIdCiclo(), consulta2.getNumPracticas()};
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

    public static void actualizarIdiomaCabecera(int newLang){
        Lenguaje lenguaje = new Lenguaje(newLang);

        headerNombreEmpresa = lenguaje.getProperty("nombreEmpresa");
        headerCifEmpresa = lenguaje.getProperty("cifEmpresa");
        headerCursoEscolar = lenguaje.getProperty("cursoEscolarFCT");
        headerCiclo = lenguaje.getProperty("ciclo");
        headerNumeroAlumnos = lenguaje.getProperty("numAlumnosFCT");
        nombresCampos = new String[]{headerNombreEmpresa,headerCifEmpresa,headerCursoEscolar,headerCiclo,headerNumeroAlumnos};
        modelo.setColumnIdentifiers(nombresCampos);
    }

}
