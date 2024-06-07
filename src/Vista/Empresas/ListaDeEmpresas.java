package Vista.Empresas;

import Modelo.Entidades.Empresa;

import javax.swing.*;
import java.awt.*;

public class ListaDeEmpresas extends JPanel {

    DetallesEmpresa detallesEmpresaApartado; //Se usará cuando se de a la linea de una empresa
    JList<Empresa> empresas;

    public ListaDeEmpresas() {
        setLayout(new BorderLayout());

        //o tmb que sean botones, cambiarlo a gridLayout y hacer un bucle con las empresas que hayan, crear un boton en cada una
        //y cuando se presione, te salga los detalles

        empresas = new JList<>();
        add(empresas, BorderLayout.CENTER);

    }
}
