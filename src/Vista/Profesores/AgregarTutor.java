package Vista.Profesores;

import Controlador.TutorController;
import Modelo.Entidades.Tutor;
import Vista.Estilo;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;

public class AgregarTutor extends JPanel{

    public static JLabel nuevoIdTutor,nuevoNombre,nuevoApellidos,cartelInformativo;
    public static JTextField nuevoRellenarIdTutor,nuevoRellenarNombre,nuevoRellenarApellidos;
    public static JButton btnGuardarTutor;
    static Tutor nuevoTutor;

    public AgregarTutor(){
        this.setLayout(new BorderLayout());
        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        JPanel panelNorte = new JPanel();
        cartelInformativo = Estilo.cartelInformativoBonito(lenguaje.getProperty("cartelInformacaionTutor"));
        panelNorte.add(cartelInformativo);

        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        nuevoIdTutor = Estilo.textoBonito(lenguaje.getProperty("idTutor"));
        nuevoRellenarIdTutor = Estilo.textFieldBonito(20);
        nuevoNombre = Estilo.textoBonito(lenguaje.getProperty("nombreTutor"));
        nuevoRellenarNombre = Estilo.textFieldBonito(20);
        nuevoApellidos = Estilo.textoBonito(lenguaje.getProperty("apellidosTutor"));
        nuevoRellenarApellidos = Estilo.textFieldBonito(20);

        configurarCoordenadas(panelCentral, gbc, nuevoIdTutor, nuevoRellenarIdTutor, 0);
        configurarCoordenadas(panelCentral, gbc, nuevoNombre, nuevoRellenarNombre, 1);
        configurarCoordenadas(panelCentral, gbc, nuevoApellidos, nuevoRellenarApellidos, 2);

        JPanel panelSur = new JPanel();
        btnGuardarTutor = new JButton(lenguaje.getProperty("btnGuardar"));
        btnGuardarTutor.setFont(new Font("Arial", Font.BOLD, 30));
        panelSur.add(btnGuardarTutor);

        add(panelNorte, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelSur, BorderLayout.SOUTH);

        btnGuardarTutor.addActionListener(e-> {agregarTutor();vaciarDatos();});

    }

    private void configurarCoordenadas(JPanel panel, GridBagConstraints gbc, JLabel label, JTextField textField, int yPos) {
        gbc.gridx = 0;
        gbc.gridy = yPos;
        panel.add(label, gbc);
        gbc.gridx = 1;
        panel.add(textField, gbc);
    }

    private static void vaciarDatos(){
        nuevoRellenarIdTutor.setText("");nuevoRellenarNombre.setText("");nuevoRellenarApellidos.setText("");
    }

    private static void agregarTutor(){
        nuevoTutor = new Tutor(Integer.parseInt(nuevoRellenarIdTutor.getText()),nuevoRellenarNombre.getText(),
                nuevoRellenarApellidos.getText());
        TutorController.agregarTutor(nuevoTutor);
    }

}
