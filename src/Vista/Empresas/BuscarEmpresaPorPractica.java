package Vista.Empresas;

import Controlador.MainPanelController;
import Vista.ComponentesGridBagLayout;
import Vista.Estilo;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

import static Modelo.Consultas.ConsultasSimples.*;

public class BuscarEmpresaPorPractica extends JPanel implements ComponentesGridBagLayout {

    public static JLabel labelCurso;
    static JComboBox<String> CBCurso,CBCiclo;
    public static JLabel labelCiclo;
    public static JButton botonListaEmpresas;
    GridBagConstraints constraints;

    public BuscarEmpresaPorPractica() throws SQLException {

        setLayout(new GridBagLayout());

        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        labelCurso = Estilo.textoBonitoInicioSesion(lenguaje.getProperty("labelCurso"));
        CBCurso = Estilo.estiloComboBox();
        for (String curso : consultarCursos()) {
            CBCurso.addItem(curso);
        }

        labelCiclo = Estilo.textoBonitoInicioSesion(lenguaje.getProperty("labelCiclo"));
        CBCiclo = Estilo.estiloComboBox();
        for (String ciclo: consultarCiclos()) {
            CBCiclo.addItem(ciclo);
        }

        botonListaEmpresas = Estilo.botonBonito(lenguaje.getProperty("botonListaEmpresas"));
        botonListaEmpresas.addActionListener( e -> {
            MainPanelController.nuevoPanelActivo(new ListaDeEmpresasConPracticas());
        });

        constraints.fill = GridBagConstraints.HORIZONTAL;

        colocarComponentes();

    }
    @Override
    public void colocarComponentes(){

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(labelCurso, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        add(CBCurso, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(labelCiclo, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        add(CBCiclo, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        add(botonListaEmpresas, constraints);

    }

    public static String getCBCiclo() {
        return (String) CBCiclo.getSelectedItem();
    }

    public static String getCBCurso() {
        return (String) CBCurso.getSelectedItem();
    }
}
