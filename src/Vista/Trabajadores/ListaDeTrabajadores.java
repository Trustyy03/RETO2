package Vista.Trabajadores;

import Modelo.Consultas.C6;
import Modelo.Entidades.Empresa;
import Vista.ComponentesGridBagLayout;
import Vista.MostrarDatosTablas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

import static Modelo.Consultas.OperacionesConsultas.consultaSeis;

public class ListaDeTrabajadores extends JPanel implements ComponentesGridBagLayout {

    GridBagConstraints constraints;
    JTable datosFCT;
    DefaultTableModel modelo;


    public ListaDeTrabajadores() {
        setLayout(new BorderLayout());
        constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        String[] nombresCampos = new String[]{"CIF Empresa", "Nombre Empresa", "Alumnos Pedidos", "Ciclo"};
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(nombresCampos);
        datosFCT = new JTable(modelo);
        colocarComponentes();


    }


    @Override
    public void colocarComponentes() {

    }
}
