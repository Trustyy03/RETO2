package Vista.FCT;

import Controlador.FCTController;
import Modelo.Entidades.FCT;
import Vista.Estilo;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;

public class AgregarFCT extends JPanel{

    public static JLabel nuevoCif, nuevoIdGrupo, nuevoCursoEscolar, nuevoNumAlumnos,cartelInformacion;
    public static JTextField nuevoRellenarCif, nuevoRellenarIdGrupo, nuevoRellenarCursoEscolar, nuevoRellenarNumAlumnos;

    public static JButton btnGuardarFCT;

    static FCT nuevaFCT;

    public AgregarFCT(){

        this.setLayout(new BorderLayout());
        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        JPanel panelNorte = new JPanel();
        cartelInformacion = Estilo.cartelInformativoBonito(lenguaje.getProperty("cartelInformacaionFCT"));
        panelNorte.add(cartelInformacion);

        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        nuevoCif = Estilo.textoBonito(lenguaje.getProperty("cif"));
        nuevoRellenarCif = new JTextField(20);
        nuevoIdGrupo = Estilo.textoBonito(lenguaje.getProperty("idGrupoFCT"));
        nuevoRellenarIdGrupo = new JTextField(20);
        nuevoCursoEscolar = Estilo.textoBonito(lenguaje.getProperty("cursoEscolarFCT"));
        nuevoRellenarCursoEscolar = new JTextField(20);
        nuevoNumAlumnos = Estilo.textoBonito(lenguaje.getProperty("numAlumnosFCT"));
        nuevoRellenarNumAlumnos = new JTextField(20);


        configurarCoordenadas(panelCentral, gbc, nuevoCif, nuevoRellenarCif, 0);
        configurarCoordenadas(panelCentral, gbc, nuevoIdGrupo, nuevoRellenarIdGrupo, 1);
        configurarCoordenadas(panelCentral, gbc, nuevoCursoEscolar, nuevoRellenarCursoEscolar, 2);
        configurarCoordenadas(panelCentral, gbc, nuevoNumAlumnos, nuevoRellenarNumAlumnos, 3);

        JPanel panelSur = new JPanel();
        btnGuardarFCT = new JButton(lenguaje.getProperty("btnGuardar"));
        btnGuardarFCT.setFont(new Font("Arial", Font.BOLD, 30));
        panelSur.add(btnGuardarFCT);

        add(panelNorte, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelSur, BorderLayout.SOUTH);

        btnGuardarFCT.addActionListener(e-> {agregarFCT(); vaciarDatos();});

    }

    private void configurarCoordenadas(JPanel panel, GridBagConstraints gbc, JLabel label, JTextField textField, int yPos) {
        gbc.gridx = 0;
        gbc.gridy = yPos;
        panel.add(label, gbc);
        gbc.gridx = 1;
        panel.add(textField, gbc);
    }

    private static void agregarFCT(){
        nuevaFCT = new FCT(nuevoRellenarCif.getText(),nuevoRellenarIdGrupo.getText(),
                nuevoRellenarCursoEscolar.getText(),Integer.parseInt(nuevoRellenarNumAlumnos.getText()));
        if ( FCTController.insertarFCT(nuevaFCT)){
            GestionarFCT.CBlistadoFCT.addItem(nuevaFCT);
        }
    }

    private static void vaciarDatos(){
        nuevoRellenarCif.setText("");nuevoRellenarIdGrupo.setText("");nuevoRellenarCursoEscolar.setText("");
        nuevoRellenarNumAlumnos.setText("");
    }



}
