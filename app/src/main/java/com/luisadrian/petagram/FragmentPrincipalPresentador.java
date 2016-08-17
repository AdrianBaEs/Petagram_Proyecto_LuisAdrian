package com.luisadrian.petagram;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by luisadrian on 8/15/16.
 */
public class FragmentPrincipalPresentador implements IFragmentPrincipalPresentador {

    MediadorMascotasPetagram mediadorPetagram;
    IFragmentPrincipal interfaceMetodosPrincipal;
    ArrayList<MascotasPetagram> listaMascotasPetagram;
    Context contexto;

    public FragmentPrincipalPresentador(IFragmentPrincipal interfaceMetodosPrincipal, Context contexto) {
        this.interfaceMetodosPrincipal=interfaceMetodosPrincipal;
        this.contexto=contexto;
        consultarBaseDatos();
    }

    @Override
    public void consultarBaseDatos() {
        mediadorPetagram=new MediadorMascotasPetagram(contexto);
        listaMascotasPetagram=mediadorPetagram.recuperarDatosMascotas();
        mostrarDatosRecuperados();
    }

    @Override
    public void mostrarDatosRecuperados() {
        interfaceMetodosPrincipal.inicializarAdaptador(interfaceMetodosPrincipal.crearAdaptador(listaMascotasPetagram));
        interfaceMetodosPrincipal.inicializarLayoutManager();
    }
}
