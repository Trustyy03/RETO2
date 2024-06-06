package Vista.Empresas;

import Modelo.Entidades.Empresa;
import Modelo.Entidades.EmrpesasMentira;
import Modelo.Entidades.OperacionesEntidades;
import Vista.Estilo;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GestionarEmpresas extends JPanel {

    public static ArrayList<Empresa> listaEmpresas;
    public static JLabel cif, nombre, telefono, numEmpleados, sector, direccion;
    public static JTextField rellenarCif, rellenarNombre, rellenarTelefono,
            rellenarNumEmpleados, rellenarSector, rellenarDireccion;

    public static JButton btnGuardarEmpresa, btnBorrarEmpresa, btnAgregarEmpresa;

    public static JComboBox<Empresa> listadoEmpresas;

    static Empresa empresaSeleccionada;

    public GestionarEmpresas() {

        this.setLayout(new BorderLayout());

        EmrpesasMentira emrpesasMentira = new EmrpesasMentira();
        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        JPanel panelNorte = new JPanel();
        listadoEmpresas = new JComboBox<>();
       // listaEmpresas = EmrpesasMentira.getListaEmpresas();
        listaEmpresas = OperacionesEntidades.consultarEmpresas();
        for (Empresa empresa : listaEmpresas) {
            listadoEmpresas.addItem(empresa);
        }
        panelNorte.add(listadoEmpresas);

        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        cif = Estilo.textoBonito(lenguaje.getProperty("cifEmpresa"));
        rellenarCif = new JTextField(20);
        nombre = Estilo.textoBonito(lenguaje.getProperty("nombreEmpresa"));
        rellenarNombre = new JTextField(20);
        telefono = Estilo.textoBonito(lenguaje.getProperty("telefonoEmpresa"));
        rellenarTelefono = new JTextField(20);
        numEmpleados = Estilo.textoBonito(lenguaje.getProperty("numEmpleadoEmpresa"));
        rellenarNumEmpleados = new JTextField(20);
        sector = Estilo.textoBonito(lenguaje.getProperty("sectorEmpresa"));
        rellenarSector = new JTextField(20);
        direccion = Estilo.textoBonito(lenguaje.getProperty("direccionEmpresa"));
        rellenarDireccion = new JTextField(20);

        configurarCoordenadas(panelCentral, gbc, cif, rellenarCif, 0);
        configurarCoordenadas(panelCentral, gbc, nombre, rellenarNombre, 1);
        configurarCoordenadas(panelCentral, gbc, telefono, rellenarTelefono, 2);
        configurarCoordenadas(panelCentral, gbc, numEmpleados, rellenarNumEmpleados, 3);
        configurarCoordenadas(panelCentral, gbc, sector, rellenarSector, 4);
        configurarCoordenadas(panelCentral, gbc, direccion, rellenarDireccion, 5);

        JPanel panelSur = new JPanel();
        btnGuardarEmpresa = new JButton(lenguaje.getProperty("btnGuardarEmpresa"));
        btnBorrarEmpresa = new JButton(lenguaje.getProperty("btnBorrarEmpresa"));
        btnAgregarEmpresa = new JButton(lenguaje.getProperty("btnAgregarEmpresa"));
        panelSur.add(btnGuardarEmpresa);
        panelSur.add(btnBorrarEmpresa);
        panelSur.add(btnAgregarEmpresa);

        add(panelNorte, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelSur, BorderLayout.SOUTH);


        listadoEmpresas.addActionListener(e-> {empresaSeleccionada =(Empresa) listadoEmpresas.getSelectedItem();
        rellenarDatos(empresaSeleccionada);});

    }

    private void configurarCoordenadas(JPanel panel, GridBagConstraints gbc, JLabel label, JTextField textField, int yPos) {
        gbc.gridx = 0;
        gbc.gridy = yPos;
        panel.add(label, gbc);
        gbc.gridx = 1;
        panel.add(textField, gbc);
    }

    public static void rellenarDatos(Empresa empresa){

        rellenarCif.setText(empresa.getCif());
        rellenarNombre.setText(empresa.getNombre());
        rellenarTelefono.setText(empresa.getTelefono());
        rellenarNumEmpleados.setText(String.valueOf(empresa.getNumEmpleados()));
        rellenarSector.setText(empresa.getSector());
        rellenarDireccion.setText(empresa.getDireccion());
    }
}
