package Vista.Empresas;

import Modelo.Entidades.Empresa;
import Vista.Estilo;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;

public class AgregarEmpresa extends JPanel {

    public static JLabel nuevoCif,  nuevoNombre,  nuevoTelefono,  nuevoNumEmpleados,  nuevoSector,  nuevoDireccion, cartelInformacion;
    public static JTextField  nuevoRellenarCif,  nuevoRellenarNombre,  nuevoRellenarTelefono,
            nuevoRellenarNumEmpleados,  nuevoRellenarSector,  nuevoRellenarDireccion;

    public static JButton btnGuardarEmpresa;

    static Empresa empresaNueva;

    public AgregarEmpresa(){

        this.setLayout(new BorderLayout());
        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        JPanel panelNorte = new JPanel();
        cartelInformacion = Estilo.cartelInformativoBonito(lenguaje.getProperty("cartelInformacaionEmpresa"));
        panelNorte.add(cartelInformacion);

        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        nuevoCif = Estilo.textoBonito(lenguaje.getProperty("cif"));
        nuevoRellenarCif = new JTextField(20);
        nuevoNombre = Estilo.textoBonito(lenguaje.getProperty("nombreEmpresa"));
        nuevoRellenarNombre = new JTextField(20);
        nuevoTelefono = Estilo.textoBonito(lenguaje.getProperty("telefonoEmpresa"));
        nuevoRellenarTelefono = new JTextField(20);
        nuevoNumEmpleados = Estilo.textoBonito(lenguaje.getProperty("numEmpleadoEmpresa"));
        nuevoRellenarNumEmpleados = new JTextField(20);
        nuevoSector = Estilo.textoBonito(lenguaje.getProperty("sectorEmpresa"));
        nuevoRellenarSector = new JTextField(20);
        nuevoDireccion = Estilo.textoBonito(lenguaje.getProperty("direccionEmpresa"));
        nuevoRellenarDireccion = new JTextField(20);

        configurarCoordenadas(panelCentral, gbc, nuevoCif, nuevoRellenarCif, 0);
        configurarCoordenadas(panelCentral, gbc, nuevoNombre, nuevoRellenarNombre, 1);
        configurarCoordenadas(panelCentral, gbc, nuevoTelefono, nuevoRellenarTelefono, 2);
        configurarCoordenadas(panelCentral, gbc, nuevoNumEmpleados, nuevoRellenarNumEmpleados, 3);
        configurarCoordenadas(panelCentral, gbc, nuevoSector, nuevoRellenarSector, 4);
        configurarCoordenadas(panelCentral, gbc, nuevoDireccion, nuevoRellenarDireccion, 5);

        JPanel panelSur = new JPanel();
        btnGuardarEmpresa = new JButton(lenguaje.getProperty("btnGuardar"));
        btnGuardarEmpresa.setFont(new Font("Arial", Font.BOLD, 30));
        panelSur.add(btnGuardarEmpresa);

        add(panelNorte, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelSur, BorderLayout.SOUTH);

        btnGuardarEmpresa.addActionListener(e-> {agregarEmpresa();GestionarEmpresas.CBlistadoEmpresas.addItem(empresaNueva);vaciarDatos();});

    }

    private void configurarCoordenadas(JPanel panel, GridBagConstraints gbc, JLabel label, JTextField textField, int yPos) {
        gbc.gridx = 0;
        gbc.gridy = yPos;
        panel.add(label, gbc);
        gbc.gridx = 1;
        panel.add(textField, gbc);
    }

    private static void agregarEmpresa(){
        empresaNueva = new Empresa(nuevoRellenarCif.getText(),nuevoRellenarNombre.getText(),nuevoRellenarTelefono.getText(),
                Integer.parseInt(nuevoRellenarNumEmpleados.getText()),nuevoRellenarSector.getText(),nuevoRellenarDireccion.getText());
    }

    private static void vaciarDatos(){
        nuevoRellenarCif.setText("");nuevoRellenarNombre.setText("");nuevoRellenarTelefono.setText("");
        nuevoRellenarNumEmpleados.setText("");nuevoRellenarSector.setText("");nuevoRellenarDireccion.setText("");
    }

}
