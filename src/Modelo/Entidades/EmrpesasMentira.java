package Modelo.Entidades;

import java.util.ArrayList;

public class EmrpesasMentira {

   static ArrayList<Empresa> listaEmpresas = new ArrayList<>();
    public EmrpesasMentira(){

        Empresa empresa1 = new Empresa("1","Empresa1","600001",15,"Coso","Calle Nose que");
        Empresa empresa2 = new Empresa("2","Empresa2","600002",20,"Coso","Calle no se cuantos");
        Empresa empresa3 = new Empresa("3","Empresa3","600003",50,"Tecno","Calle calle");

        listaEmpresas.add(empresa1);listaEmpresas.add(empresa2);listaEmpresas.add(empresa3);
    }

    public static ArrayList<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }
}
