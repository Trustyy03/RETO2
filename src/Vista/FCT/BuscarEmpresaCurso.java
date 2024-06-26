package Vista.FCT;

import Controlador.MainPanelController;
import Modelo.Consultas.Consulta6;
import Modelo.Entidades.Empresa;
import Vista.ComponentesGridBagLayout;
import Vista.Estilo;
import Vista.Idioma.Lenguaje;
import Vista.MostrarDatosTablas;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

import static Modelo.Consultas.ConsultasSimples.*;
import static Modelo.Consultas.OperacionesConsultas.consultaSeis;


public class BuscarEmpresaCurso extends JPanel implements ComponentesGridBagLayout, MostrarDatosTablas {

    public static JLabel labelEmpresa,labelCiclo,labelCurso;
    public static JComboBox<Empresa> CBListadoEmpresas = Estilo.estiloComboBox();
    JComboBox<String> ciclo;
    JComboBox<String> cursoEscolar;
    public static JButton botonListaTrabajadores;
    GridBagConstraints constraints;
    ListaDeTrabajadores listaDeTrabajadores;


    public BuscarEmpresaCurso() throws SQLException {
        setLayout(new GridBagLayout());
        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);


        constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        labelEmpresa = Estilo.textoBonitoInicioSesion(lenguaje.getProperty("labelEmpresa"));

        labelCiclo = Estilo.textoBonitoInicioSesion(lenguaje.getProperty("labelCiclo"));
        ciclo = Estilo.estiloComboBox();
        for (String cicloh : consultarCiclos()) {
            ciclo.addItem(cicloh);
        }

        labelCurso = Estilo.textoBonitoInicioSesion(lenguaje.getProperty("labelCurso"));
        cursoEscolar = Estilo.estiloComboBox();
        for (String curso : consultarCursos()) {
            cursoEscolar.addItem(curso);
        }

        botonListaTrabajadores = Estilo.botonBonito(lenguaje.getProperty("botonListaTrabajadores"));
        botonListaTrabajadores.addActionListener(e -> {
            listaDeTrabajadores = new ListaDeTrabajadores();
            mostrarTablaDatos();
            MainPanelController.nuevoPanelActivo(listaDeTrabajadores);
        });

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
        ListaDeTrabajadores.modelo.setRowCount(0);
        Empresa empresa = (Empresa) CBListadoEmpresas.getSelectedItem();
        try {
            for (Consulta6 consulta6 : consultaSeis(empresa.getNombre(), (String)ciclo.getSelectedItem(), (String)cursoEscolar.getSelectedItem())) {
                Object[] fila = new Object[]{consulta6.getCifEmpresa(), consulta6.getNombreEmpresa(), consulta6.getCantidadAlumnos(), consulta6.getIdCiclo()};
                ListaDeTrabajadores.modelo.addRow(fila);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
