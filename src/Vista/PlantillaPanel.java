package Vista;

import Controlador.MainPanelController;
import Vista.Idioma.Lenguaje;

import javax.swing.*;

public class PlantillaPanel extends JPanel {

    MainPanelController mainPanelController;

    public PlantillaPanel(){

        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);


        JPanel panelCentral = new JPanel();
        panelCentral.add(this);






        mainPanelController = new MainPanelController(panelCentral,this);


    }

}
