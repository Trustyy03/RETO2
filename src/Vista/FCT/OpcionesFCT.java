package Vista.FCT;

import Controlador.MainPanelController;
import Vista.Empresas.BuscarEmpresa;
import Vista.Empresas.BuscarEmpresaPorPractica;
import Vista.Empresas.GestionarEmpresas;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;

public class OpcionesFCT extends JPanel {

    JButton gestionarFCT,buscarFCT;
    BuscarFCT buscarFCTApartado;
    GestionarFCT gestionarFCTApartado;
    GridBagConstraints constraints;

    public OpcionesFCT(){

        this.setLayout(new GridBagLayout());

        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        buscarFCTApartado = new BuscarFCT();
        gestionarFCTApartado = new GestionarFCT();

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,10,10,10);

        gestionarFCT = crearBotonBonito(lenguaje.getProperty("btnBuscarEmpresas"));
        gestionarFCT.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(gestionarFCTApartado);
        });
        buscarFCT = crearBotonBonito(lenguaje.getProperty("btnEmpresasPorPracticas"));
        buscarFCT.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(buscarFCTApartado);
        });

        colocarComponentes();
    }

    private static JButton crearBotonBonito(String text) { //modifica la interfaz de los botones
        JButton button = new JButton(text);

        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);

        button.setFont(new Font("Arial", Font.BOLD, 30));

        button.setFocusPainted(false);

        return button;
    }

    public void colocarComponentes(){

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(gestionarFCT, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add (buscarFCT, constraints);

    }

}
