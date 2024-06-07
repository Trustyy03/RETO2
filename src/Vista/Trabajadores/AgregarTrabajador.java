package Vista.Trabajadores;

import Vista.Estilo;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;

public class AgregarTrabajador extends JPanel{

    public static JLabel nuevoIdTrabajador,nuevoCifTrabajador, nuevoNombreTrabajador,
            nuevoApellidosTrabajador,nuevoCorreoTrabajador,cartelInformativo;
    public static JTextField nuevoRellenarId,nuevoRellenarCif, nuevoRellenarNombreTrabajador, nuevoRellenarApellidosTrabajador,
            nuevoRellenarCorreoTrabajador;

    public static JButton btnGuardarTrabajador;

    public AgregarTrabajador(){

        this.setLayout(new BorderLayout());
        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        JPanel panelNorte = new JPanel();
        cartelInformativo = Estilo.cartelInformativoBonito(lenguaje.getProperty("cartelInformacaionTrabajador"));
        panelNorte.add(cartelInformativo);

        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        nuevoIdTrabajador = Estilo.textoBonito(lenguaje.getProperty("idTrabajador"));
        nuevoRellenarId = new JTextField(20);
        nuevoCifTrabajador = Estilo.textoBonito(lenguaje.getProperty("cif"));
        nuevoRellenarCif = new JTextField(20);
        nuevoNombreTrabajador = Estilo.textoBonito(lenguaje.getProperty("nombreTrabajador"));
        nuevoRellenarNombreTrabajador = new JTextField(20);
        nuevoApellidosTrabajador = Estilo.textoBonito(lenguaje.getProperty("apellidosTrabajador"));
        nuevoRellenarApellidosTrabajador = new JTextField(20);
        nuevoCorreoTrabajador = Estilo.textoBonito(lenguaje.getProperty("correoEmpleado"));
        nuevoRellenarCorreoTrabajador = new JTextField(20);

        configurarCoordenadas(panelCentral, gbc, nuevoIdTrabajador, nuevoRellenarId, 0);
        configurarCoordenadas(panelCentral, gbc, nuevoCifTrabajador, nuevoRellenarCif, 1);
        configurarCoordenadas(panelCentral, gbc, nuevoNombreTrabajador, nuevoRellenarNombreTrabajador, 2);
        configurarCoordenadas(panelCentral, gbc, nuevoApellidosTrabajador, nuevoRellenarApellidosTrabajador, 3);
        configurarCoordenadas(panelCentral, gbc, nuevoCorreoTrabajador, nuevoRellenarCorreoTrabajador, 4);

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



}
