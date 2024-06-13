package Vista.Empresas;

import Modelo.Consultas.Consulta7;
import Vista.Estilo;
import Vista.Idioma.Lenguaje;
import Vista.MostrarDatosTablas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import static Modelo.Consultas.ConsultasSimples.consultarTecnologias;
import static Modelo.Consultas.OperacionesConsultas.consultaSiete;

public class BuscarEmpresaPorTecnologia extends JPanel implements MostrarDatosTablas {

    JComboBox<String> tecnologias;
    JTable empresaPorTecnologia;
    static DefaultTableModel modelo;

    public static String nombreEmpresa,cifEmpresa;

   static String[] nombresCampos;


    public BuscarEmpresaPorTecnologia(){

        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);
        nombreEmpresa = lenguaje.getProperty("nombreEmpresa");
        cifEmpresa = lenguaje.getProperty("cifEmpresa");


        tecnologias = Estilo.estiloComboBox();
        for (String tecnologia : consultarTecnologias()){
            tecnologias.addItem(tecnologia);
        }

        nombresCampos = new String[]{nombreEmpresa,cifEmpresa};
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(nombresCampos);
        empresaPorTecnologia = new JTable(modelo);


        setLayout(new BorderLayout());
        add(tecnologias, BorderLayout.NORTH);

        tecnologias.addActionListener(e -> mostrarTablaDatos());

        add(new JScrollPane(empresaPorTecnologia), BorderLayout.CENTER);
        this.revalidate();
    }

    public void mostrarTablaDatos() {
        modelo.setRowCount(0);

        for (Consulta7 consulta7 : consultaSiete((String)tecnologias.getSelectedItem())){
            Object[] fila = new Object[]{consulta7.getNombreEmpresa(), consulta7.getCif()};
            modelo.addRow(fila);
        }
    }

    public static void actualizarIdiomaCabecera(int newLang){
        Lenguaje lenguaje = new Lenguaje(newLang);

        nombreEmpresa = lenguaje.getProperty("nombreEmpresa");
        cifEmpresa = lenguaje.getProperty("cifEmpresa");
        nombresCampos = new String[]{nombreEmpresa,cifEmpresa};
        modelo.setColumnIdentifiers(nombresCampos);
    }


}
