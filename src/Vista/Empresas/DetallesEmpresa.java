package Vista.Empresas;

import Modelo.Entidades.Empresa;
import Vista.Estilo;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;

public class DetallesEmpresa extends JPanel {

    public static JLabel cif, nombre, telefono, numEmpleados, sector, direccion;
    public static JLabel rellenarCif, rellenarNombre, rellenarTelefono,
            rellenarNumEmpleados, rellenarSector, rellenarDireccion;
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


        cif = Estilo.textoBonito(lenguaje.getProperty("cif"));
        rellenarCif = Estilo.textoBonitoInfo("");
        nombre = Estilo.textoBonito(lenguaje.getProperty("nombreEmpresa"));
        rellenarNombre = Estilo.textoBonitoInfo("");
        telefono = Estilo.textoBonito(lenguaje.getProperty("telefonoEmpresa"));
        rellenarTelefono = Estilo.textoBonitoInfo("");
        numEmpleados = Estilo.textoBonito(lenguaje.getProperty("numEmpleadoEmpresa"));
        rellenarNumEmpleados = Estilo.textoBonitoInfo("");
        sector = Estilo.textoBonito(lenguaje.getProperty("sectorEmpresa"));
        rellenarSector = Estilo.textoBonitoInfo("");
        direccion = Estilo.textoBonito(lenguaje.getProperty("direccionEmpresa"));
        rellenarDireccion = Estilo.textoBonitoInfo("");

        configurarCoordenadas(panelCentral, gbc, cif, rellenarCif, 0);
        configurarCoordenadas(panelCentral, gbc, nombre, rellenarNombre, 1);
        configurarCoordenadas(panelCentral, gbc, telefono, rellenarTelefono, 2);
        configurarCoordenadas(panelCentral, gbc, numEmpleados, rellenarNumEmpleados, 3);
        configurarCoordenadas(panelCentral, gbc, sector, rellenarSector, 4);
        configurarCoordenadas(panelCentral, gbc, direccion, rellenarDireccion, 5);

        rellenarDatos(empresaSeleccionada);

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

    private static void rellenarDatos(Empresa empresa){
        rellenarCif.setText(empresa.getCif());
        rellenarNombre.setText(empresa.getNombre());
        rellenarTelefono.setText(empresa.getTelefono());
        rellenarNumEmpleados.setText(String.valueOf(empresa.getNumEmpleados()));
        rellenarSector.setText(empresa.getSector());
        rellenarDireccion.setText(empresa.getDireccion());
    }


}
