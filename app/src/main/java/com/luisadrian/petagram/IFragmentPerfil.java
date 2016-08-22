package com.luisadrian.petagram;

import java.util.ArrayList;

/**
 * Created by luisadrian on 8/21/16.
 */
public interface IFragmentPerfil {

    public void inicializarAdaptadorMiMascota();
    public MiMascotaPetagramAdaptador crearAdaptadorFragmentPerfil(ArrayList<MascotasPetagram> mascotas);
    public void inicializarAdaptadorFragmentPerfil(MiMascotaPetagramAdaptador adaptador);
    public void creaImagenFragmentPerfil(SeguidoresPerfilPetagram perfilUsuario);

}
