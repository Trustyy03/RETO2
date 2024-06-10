package Vista.Empresas;

import Modelo.Consultas.C1;
import Modelo.Consultas.OperacionesConsultas;
import Modelo.Entidades.Empresa;
import Vista.Estilo;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class DetallesEmpresa extends JPanel {

    public static JLabel nombreEmpresa, nombreTutor, nombreTrabajador, correoTrabajador, telefonoTrabajador;
    public static JTextField rellenarNombreEmpresa, rellenarNombreTutor, rellenarNombreTrabajador,
            rellenarCorreoTrabajador, rellenarTelefonoTrabajador;
    Empresa empresaSeleccionada;

    JLabel labelEmpresa;

    public DetallesEmpresa() {

        this.setLayout(new BorderLayout());
        empresaSeleccionada =  BuscarEmpresa.getEmpresaSeleccionada();

        //Aqui supongo que tienes que crear un C1 = OperacionesConsultas.consultaUno(empresaSeleccionada.getNombre());
        //Y luego llamas al metodo de rellenar datos y listo

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
        rellenarNombreEmpresa = new JTextField(20);
        nombreTutor = Estilo.textoBonito(lenguaje.getProperty("nombreTutor"));
        rellenarNombreTutor = new JTextField(20);
        nombreTrabajador = Estilo.textoBonito(lenguaje.getProperty("nombreTrabajador"));
        rellenarNombreTrabajador = new JTextField(20);
        correoTrabajador = Estilo.textoBonito(lenguaje.getProperty("correoTrabajador"));
        rellenarCorreoTrabajador = new JTextField(20);
        telefonoTrabajador = Estilo.textoBonito(lenguaje.getProperty("telefonoTrabajador"));
        rellenarTelefonoTrabajador = new JTextField(20);

        configurarCoordenadas(panelCentral, gbc, nombreEmpresa, rellenarNombreEmpresa, 0);
        configurarCoordenadas(panelCentral, gbc, nombreTutor, rellenarNombreTutor, 1);
        configurarCoordenadas(panelCentral, gbc, nombreTrabajador, rellenarNombreTrabajador, 2);
        configurarCoordenadas(panelCentral, gbc, correoTrabajador, rellenarCorreoTrabajador, 3);
        configurarCoordenadas(panelCentral, gbc, telefonoTrabajador, rellenarTelefonoTrabajador, 4);

        try {
            C1 nombreEmpresa = OperacionesConsultas.consultaUno(empresaSeleccionada.getNombre());
            rellenarDatos(nombreEmpresa);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

       add(panelNorte, BorderLayout.NORTH);
       add(panelCentral, BorderLayout.CENTER);

    }

    private void configurarCoordenadas(JPanel panel, GridBagConstraints gbc, JLabel label, JTextField textField, int yPos) {
        gbc.gridx = 0;
        gbc.gridy = yPos;
        panel.add(label, gbc);
        gbc.gridx = 1;
        panel.add(textField, gbc);
    }

    private static void rellenarDatos(C1 c1){

        rellenarNombreEmpresa.setText(c1.getNombreEmpresa());
        rellenarNombreTutor.setText(c1.getNombreTutor());
        rellenarNombreTrabajador.setText(c1.getNombreTrabajador());
        rellenarCorreoTrabajador.setText(c1.getCorreoTrabajador());
        rellenarTelefonoTrabajador.setText(c1.getTelefonoTrabajador());

    }


}
