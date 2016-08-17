package com.luisadrian.petagram;

import java.util.ArrayList;

/**
 * Created by luisadrian on 8/16/16.
 */
public interface IMascotasFavoritas {

    //Metodos de la clase MascotasFavoritas
    public MascotasPetagramAdaptador crearAdaptador(ArrayList<MascotasPetagram> mascotasFavoritas);
    public void inicializarAdaptador(MascotasPetagramAdaptador adaptadorMascotasFavoritas);
    public void inicializarLayoutManager();

}
