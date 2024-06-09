package Modelo.Pruebas;

import Modelo.Entidades.Trabajador;

import java.util.ArrayList;
import java.util.List;

public class TrabajadoresMentira {

    static List<Trabajador> listaTrabajadores = new ArrayList<>();

    public TrabajadoresMentira(){

        Trabajador trabajador1 = new Trabajador(1,"001","Pepe", "Martin","asfdl@gmail.com","","");
        Trabajador trabajador2 = new Trabajador(2,"002","Paco", "Ramirez","eeee@gmail.com","","");
        Trabajador trabajador3 = new Trabajador(3,"003","Pepito", "Lastre","pepin@gmail.com","","");
        listaTrabajadores.add(trabajador1);listaTrabajadores.add(trabajador2);listaTrabajadores.add(trabajador3);


    }

    public static List<Trabajador> getListaTrabajadores() {
        return listaTrabajadores;
    }
}
