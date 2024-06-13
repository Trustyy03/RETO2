package Modelo.Pruebas;

import Modelo.Entidades.FCT;

import java.util.ArrayList;
import java.util.List;

public class FCTMentira {

    private static List<FCT> listaFCT = new ArrayList<>();

    public FCTMentira(){

        FCT fct1 = new FCT("1","1","DAM",5);
        FCT fct2 = new FCT("2","2","DAW",10);
        listaFCT.add(fct1);listaFCT.add(fct2);
    }

    public static List<FCT> getListaFCT() {
        return listaFCT;
    }
}
