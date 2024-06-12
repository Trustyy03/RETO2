package Vista.Empresas;

import Modelo.Consultas.OperacionesConsultas;
import Modelo.Entidades.Empresa;
import Modelo.Consultas.Consulta1;
import Vista.Estilo;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

import static Modelo.Consultas.OperacionesConsultas.consultaUno;

public class DetallesEmpresa extends JPanel {

    public static JLabel nombreEmpresa, nombreTutor, nombreTrabajador, correoTrabajador, telefonoTrabajador;
    public static JLabel rellenarNombreEmpresa, rellenarNombreTutor, rellenarNombreTrabajador,
            rellenarCorreoTrabajador, rellenarTelefonoTrabajador;
    Empresa empresaSeleccionada;

    JLabel labelEmpresa;
    JComboBox<String> CBtrabajadores = Estilo.estiloComboBox();

    public DetallesEmpresa() {

        this.setLayout(new BorderLayout());
        empresaSeleccionada =  BuscarEmpresa.getEmpresaSeleccionada();


        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        JPanel panelNorte = new JPanel();
        labelEmpresa = new JLabel("INFORMACIÓN DE LA EMPRESA", JLabel.CENTER);
        labelEmpresa.setFont(new Font("Arial", Font.BOLD, 24));
        panelNorte.add(labelEmpresa);


        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;


        nombreEmpresa = Estilo.textoBonito(lenguaje.getProperty("nombreEmpresa"));
        rellenarNombreEmpresa = Estilo.textoBonitoInfo("");
        nombreTutor = Estilo.textoBonito(lenguaje.getProperty("nombreTutor"));
        rellenarNombreTutor = Estilo.textoBonitoInfo("");
        nombreTrabajador = Estilo.textoBonito(lenguaje.getProperty("nombreTrabajador"));
        rellenarNombreTrabajador = Estilo.textoBonitoInfo("");
        correoTrabajador = Estilo.textoBonito(lenguaje.getProperty("correoTrabajador"));
        rellenarCorreoTrabajador = Estilo.textoBonitoInfo("");
        telefonoTrabajador = Estilo.textoBonito(lenguaje.getProperty("telefonoTrabajador"));
        rellenarTelefonoTrabajador = Estilo.textoBonitoInfo("");

        configurarCoordenadas(panelCentral, gbc, nombreEmpresa, rellenarNombreEmpresa, 0);
        configurarCoordenadas(panelCentral, gbc, nombreTutor, rellenarNombreTutor, 1);
        configurarCoordenadasCB(panelCentral, gbc, nombreTrabajador, CBtrabajadores, 2);
        configurarCoordenadas(panelCentral, gbc, correoTrabajador, rellenarCorreoTrabajador, 3);
        configurarCoordenadas(panelCentral, gbc, telefonoTrabajador, rellenarTelefonoTrabajador, 4);

        try {
            for (Consulta1 c1 : consultaUno(empresaSeleccionada.getNombre())) {
                rellenarDatos(c1);
                CBtrabajadores.addItem(c1.getNombreTrabajador());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

       add(panelNorte, BorderLayout.NORTH);
       add(panelCentral, BorderLayout.CENTER);

    }

    private void configurarCoordenadas(JPanel panel, GridBagConstraints gbc, JLabel label, JLabel label1, int yPos) {
        gbc.gridx = 0;
        gbc.gridy = yPos;
        panel.add(label, gbc);
        gbc.gridx = 1;
        panel.add(label1, gbc);
    }

    private void configurarCoordenadasCB(JPanel panel, GridBagConstraints gbc, JLabel label, JComboBox cb, int yPos) {
        gbc.gridx = 0;
        gbc.gridy = yPos;
        panel.add(label, gbc);
        gbc.gridx = 1;
        panel.add(cb, gbc);
    }

    private static void rellenarDatos(Consulta1 consulta1){
        rellenarNombreEmpresa.setText(consulta1.getNombreEmpresa());
        rellenarNombreTutor.setText(consulta1.getNombreTutor());
        //rellenarNombreTrabajador.setText(consulta1.getNombreTrabajador());
        rellenarCorreoTrabajador.setText(consulta1.getCorreoTrabajador());
        rellenarTelefonoTrabajador.setText(consulta1.getTelefonoTrabajador());
    }


}
