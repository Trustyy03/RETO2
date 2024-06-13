package Vista.Empresas;

import Modelo.Consultas.Consulta8;
import Modelo.Entidades.Empresa;
import Vista.Estilo;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

import static Modelo.Consultas.ConsultasSimples.consultarNombresEmpresas;
import static Modelo.Consultas.OperacionesConsultas.consultaOcho;

public class HistorialContactosEmpresa extends JPanel {

    public static JComboBox<Empresa> CBListadoEmpresas = new JComboBox<>();
    static String[] nombresCampos;
    JTable contactosPorEmpresa;
    static DefaultTableModel modelo;
    public static String headerNombreEmpresa, headerNombreTutor, headerDescripcion, headerFecha;

    public HistorialContactosEmpresa(){
        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);
        headerNombreEmpresa = lenguaje.getProperty("nombreEmpresa");
        headerNombreTutor = lenguaje.getProperty("nombreTutor");
        headerDescripcion = lenguaje.getProperty("descripcion");
        headerFecha = lenguaje.getProperty("fecha");

        nombresCampos = new String[]{headerNombreEmpresa, headerNombreTutor, headerDescripcion, headerFecha};
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(nombresCampos);
        contactosPorEmpresa = new JTable(modelo);
        Estilo.estiloJTable(contactosPorEmpresa);

        CBListadoEmpresas.addActionListener(e -> mostrarTablaDatos());

        setLayout(new BorderLayout());
        add(CBListadoEmpresas, BorderLayout.NORTH);

        add(new JScrollPane(contactosPorEmpresa), BorderLayout.CENTER);
    }

    public void mostrarTablaDatos() {
        modelo.setRowCount(0);
        Empresa empresa = (Empresa) CBListadoEmpresas.getSelectedItem();

        for (Consulta8 c8 : consultaOcho(empresa.getNombre())){
            Object[] fila = new Object[]{c8.getNombreEmpresa(), c8.getNombreTutor(), c8.getDescripcion(), c8.getFecha()};
            modelo.addRow(fila);
        }
    }

    public static void actualizarIdiomaCabecera(int newLang){
        Lenguaje lenguaje = new Lenguaje(newLang);

        headerNombreEmpresa = lenguaje.getProperty("nombreEmpresa");
        headerNombreTutor = lenguaje.getProperty("nombreTutor");
        headerDescripcion = lenguaje.getProperty("descripcion");
        headerFecha = lenguaje.getProperty("fecha");

        nombresCampos = new String[]{headerNombreEmpresa,headerNombreTutor,headerDescripcion,headerFecha};
        modelo.setColumnIdentifiers(nombresCampos);
    }

}
