package Vista.FCT;

import Controlador.FCTController;
import Controlador.MainPanelController;
import Modelo.Entidades.Empresa;
import Modelo.Entidades.FCT;
import Modelo.Pruebas.FCTMentira;
import Vista.Estilo;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static Vista.Empresas.GestionarEmpresas.rellenarDireccion;

public class GestionarFCT extends JPanel {

    public static List<FCT> listaFCT;
    public static JLabel cif, idGrupo, cursoEscolar, numAlumnos;
    public static JTextField rellenarCif, rellenarIdGrupo, rellenarCursoEscolar, rellenarNumAlumnos;
    public static JButton btnGuardarFCT, btnBorrarFCT, btnAgregarFCT;
    public static JComboBox<FCT> CBlistadoFCT;
    static FCT fctSeleccionada;

    public GestionarFCT(){

        listaFCT = FCTController.consultarFCT();
        this.setLayout(new BorderLayout());

        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);
        AgregarFCT agregarFCTPanel = new AgregarFCT();

        JPanel panelNorte = new JPanel();
        CBlistadoFCT = new JComboBox<>();
        agregarFCT();

        btnBorrarFCT = new JButton(lenguaje.getProperty("btnBorrar"));
        btnAgregarFCT = new JButton(lenguaje.getProperty("btnAgregar"));
        panelNorte.add(CBlistadoFCT);
        panelNorte.add(btnBorrarFCT);
        panelNorte.add(btnAgregarFCT);

        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        cif = Estilo.textoBonito(lenguaje.getProperty("cif"));
        rellenarCif = new JTextField(20);
        idGrupo = Estilo.textoBonito(lenguaje.getProperty("idGrupoFCT"));
        rellenarIdGrupo = new JTextField(20);
        cursoEscolar = Estilo.textoBonito(lenguaje.getProperty("cursoEscolarFCT"));
        rellenarCursoEscolar = new JTextField(20);
        numAlumnos = Estilo.textoBonito(lenguaje.getProperty("numAlumnosFCT"));
        rellenarNumAlumnos = new JTextField(20);

        configurarCoordenadas(panelCentral, gbc, cif, rellenarCif, 0);
        configurarCoordenadas(panelCentral, gbc, idGrupo, rellenarIdGrupo, 1);
        configurarCoordenadas(panelCentral, gbc, cursoEscolar, rellenarCursoEscolar, 2);
        configurarCoordenadas(panelCentral, gbc, numAlumnos, rellenarNumAlumnos, 3);

        JPanel panelSur = new JPanel();
        btnGuardarFCT = new JButton(lenguaje.getProperty("btnGuardar"));
        panelSur.add(btnGuardarFCT);

        add(panelNorte, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelSur, BorderLayout.SOUTH);

        btnAgregarFCT.addActionListener(e-> MainPanelController.nuevoPanelActivo(agregarFCTPanel));

        CBlistadoFCT.addActionListener(e-> {fctSeleccionada =(FCT) CBlistadoFCT.getSelectedItem();
            rellenarDatos(fctSeleccionada);});
        btnBorrarFCT.addActionListener(e-> {fctSeleccionada = (FCT) CBlistadoFCT.getSelectedItem(); eliminarFCT(fctSeleccionada);});
    }
    private void configurarCoordenadas(JPanel panel, GridBagConstraints gbc, JLabel label, JTextField textField, int yPos) {
        gbc.gridx = 0;
        gbc.gridy = yPos;
        panel.add(label, gbc);
        gbc.gridx = 1;
        panel.add(textField, gbc);
    }

    private static void rellenarDatos(FCT fct){
        rellenarCif.setText(fct.getCif());
        rellenarIdGrupo.setText(fct.getIdGrupo());
        rellenarCursoEscolar.setText(fct.getCursoEscolar());
        rellenarNumAlumnos.setText(String.valueOf(fct.getNumAlumnos()));
    }

    private static void agregarFCT(){
        for (FCT fct : listaFCT){
            CBlistadoFCT.addItem(fct);
        }
    }

    private static void eliminarFCT(FCT fct){
        FCTController.borrarFCT(fct);
        listaFCT.remove(fct);
        CBlistadoFCT.removeItem(fct);
    }

}
