package Vista.Empresas;

import Modelo.Consultas.Consulta5;
import Modelo.Consultas.ConsultasSimples;
import Modelo.Consultas.OperacionesConsultas;
import Vista.Estilo;
import Vista.Idioma.Lenguaje;
import Vista.MostrarDatosTablas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class IncidenciasCurso extends JPanel implements MostrarDatosTablas{

    JComboBox<String> curso;
    JTable incidenciasPorCurso;
    static DefaultTableModel modelo;
    static String[] nombresCampos;
    public static String idIncidencia,cifEmpresa,descripcion,nombreEmpresa;

    public IncidenciasCurso(){
        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);
        idIncidencia = lenguaje.getProperty("idIndicencia");
        cifEmpresa = lenguaje.getProperty("cifEmpresa");
        descripcion = lenguaje.getProperty("descripcion");
        nombreEmpresa = lenguaje.getProperty("nombreEmpresa");

        curso = Estilo.estiloComboBox();
        cargarCursos();

        nombresCampos = new String[]{idIncidencia, cifEmpresa,descripcion,nombreEmpresa};
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(nombresCampos);
        incidenciasPorCurso = new JTable(modelo);
        Estilo.estiloJTable(incidenciasPorCurso);

        setLayout(new BorderLayout());
        add(curso, BorderLayout.NORTH);

        curso.addActionListener(e -> mostrarTablaDatos());

        add(new JScrollPane(incidenciasPorCurso), BorderLayout.CENTER);
    }

    private void cargarCursos() {
        //De parte de Aymen por si no lo entendeis: esto es para recorrer los
        //cursos y añadirlos al comboBox por cada item.
        //con un metodo esta más organizado :-)
        ArrayList<String> cursos = ConsultasSimples.consultarCursos();
        for (String curso : cursos) {
            this.curso.addItem(curso);
        }
    }

    private void limpiarTabla() {
        //para actualizar (ns la vrd)
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

    }
    @Override
    public void mostrarTablaDatos() {
        String cursoSeleccionado = (String) curso.getSelectedItem();

        limpiarTabla();

        ArrayList<Consulta5> incidencias = OperacionesConsultas.consultaCinco(cursoSeleccionado);
        for (Consulta5 incidencia : incidencias) {
            Object[] fila = {incidencia.getIdIncidencia(), incidencia.getCif(), incidencia.getCursoEscolar(), incidencia.getDescripcion()};
            modelo.addRow(fila);
        }
    }

    public static void actualizarIdiomaCabecera(int newLang){
        Lenguaje lenguaje = new Lenguaje(newLang);

        idIncidencia = lenguaje.getProperty("idIncidencia");
        cifEmpresa = lenguaje.getProperty("cifEmpresa");
        descripcion = lenguaje.getProperty("descripcion");
        nombreEmpresa = lenguaje.getProperty("nombreEmpresa");

        nombresCampos = new String[]{idIncidencia,cifEmpresa,descripcion,nombreEmpresa};
        modelo.setColumnIdentifiers(nombresCampos);
    }
}
