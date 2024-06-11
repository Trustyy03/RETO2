package Vista.Trabajadores;

import Controlador.MainPanelController;
import Modelo.Consultas.C6;
import Modelo.Entidades.Empresa;
import Vista.ComponentesGridBagLayout;
import Vista.Estilo;
import Vista.MostrarDatosTablas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

import static Modelo.Consultas.ConsultasSimples.*;
import static Modelo.Consultas.OperacionesConsultas.consultaSeis;


public class BuscarEmpresaCurso extends JPanel implements ComponentesGridBagLayout, MostrarDatosTablas {

    JLabel labelEmpresa;
    public static JComboBox<Empresa> CBListadoEmpresas = Estilo.estiloComboBox();
    JLabel labelCiclo;
    JComboBox<String> ciclo;
    JLabel labelCurso;
    JComboBox<String> cursoEscolar;
    JButton botonListaTrabajadores;
    GridBagConstraints constraints;
    ListaDeTrabajadores listaDeTrabajadores;
    DefaultTableModel modelo;

    public BuscarEmpresaCurso() throws SQLException {
        setLayout(new GridBagLayout());

        listaDeTrabajadores = new ListaDeTrabajadores();

        constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        labelEmpresa = Estilo.textoBonitoInicioSesion("EMPRESA");

        //CBListadoEmpresas.getSelectedItem();

        labelCiclo = Estilo.textoBonitoInicioSesion("CICLO");
        ciclo = Estilo.estiloComboBox();
        for (String cicloh : consultarCiclos()) {
            ciclo.addItem(cicloh);
        }

        labelCurso = Estilo.textoBonitoInicioSesion("CURSO");
        cursoEscolar = Estilo.estiloComboBox();
        for (String curso : consultarCursos()) {
            cursoEscolar.addItem(curso);
        }

        botonListaTrabajadores = Estilo.botonBonito("LISTA DE TRABAJADORES POR EMPRESA / CICLO");
        botonListaTrabajadores.addActionListener(e ->
                MainPanelController.nuevoPanelActivo(listaDeTrabajadores)
        );

        constraints.fill = GridBagConstraints.HORIZONTAL;

        colocarComponentes();

    }
    @Override
    public void colocarComponentes(){

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(labelEmpresa, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        add(CBListadoEmpresas, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(labelCiclo, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        add(ciclo, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        add(labelCurso, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        add(cursoEscolar, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        add(botonListaTrabajadores, constraints);

    }

    @Override
    public void mostrarTablaDatos() {
        modelo.setRowCount(0);

        try {
            for (C6 c6 : consultaSeis((String)CBListadoEmpresas.getSelectedItem(), (String)ciclo.getSelectedItem(), (String)cursoEscolar.getSelectedItem())) {
                Object[] fila = new Object[]{c6.getNombreEmpresa(), c6.getCantidadAlumnos(), c6.getIdCiclo()};
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
