package Vista.Empresas;

import Modelo.Consultas.OperacionesConsultas;
import Modelo.Entidades.Empresa;
import Modelo.Consultas.C1;
import Vista.Estilo;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class DetallesEmpresa extends JPanel {

    public static JLabel nombreEmpresa, nombreTutor, nombreTrabajador, correoTrabajador, telefonoTrabajador;
    public static JLabel rellenarNombreEmpresa, rellenarNombreTutor, rellenarNombreTrabajador,
            rellenarCorreoTrabajador, rellenarTelefonoTrabajador;
    Empresa empresaSeleccionada;

    JLabel labelEmpresa;

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
        configurarCoordenadas(panelCentral, gbc, nombreTrabajador, rellenarNombreTrabajador, 2);
        configurarCoordenadas(panelCentral, gbc, correoTrabajador, rellenarCorreoTrabajador, 3);
        configurarCoordenadas(panelCentral, gbc, telefonoTrabajador, rellenarTelefonoTrabajador, 4);

        try {
            C1 c1 = OperacionesConsultas.consultaUno(empresaSeleccionada.getNombre());
            rellenarDatos(c1);
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

    private static void rellenarDatos(C1 c1){
        rellenarNombreEmpresa.setText(c1.getNombreEmpresa());
        rellenarNombreTutor.setText(c1.getNombreTutor());
        rellenarNombreTrabajador.setText(c1.getNombreTrabajador());
        rellenarCorreoTrabajador.setText(c1.getCorreoTrabajador());
        rellenarTelefonoTrabajador.setText(c1.getTelefonoTrabajador());
    }


}
