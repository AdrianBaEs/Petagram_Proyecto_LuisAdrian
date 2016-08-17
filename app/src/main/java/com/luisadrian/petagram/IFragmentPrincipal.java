package com.luisadrian.petagram;

import java.util.ArrayList;

/**
 * Created by luisadrian on 8/15/16.
 */
public interface IFragmentPrincipal {

    //Metodos del fragment principal
    public MascotasPetagramAdaptador crearAdaptador(ArrayList<MascotasPetagram> listaMascotas);
    public void inicializarAdaptador(MascotasPetagramAdaptador miAdaptador);
    public void inicializarLayoutManager();

}
