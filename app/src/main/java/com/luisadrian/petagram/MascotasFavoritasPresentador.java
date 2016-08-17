package com.luisadrian.petagram;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by luisadrian on 8/16/16.
 */
public class MascotasFavoritasPresentador implements IMascotasFavoritasPresentador {
    ArrayList<MascotasPetagram> mascotasMasRanking;
    MediadorMascotasPetagram mediadorMascotasPetagram;
    IMascotasFavoritas interfaceMetodosFavoritosPrincipal;
    Context contexto;

    public MascotasFavoritasPresentador(IMascotasFavoritas interfaceMetodosFavoritosPrincipal, Context contexto) {
        this.interfaceMetodosFavoritosPrincipal=interfaceMetodosFavoritosPrincipal;
        this.contexto=contexto;
        recuperarDatosMascotasRanking();
    }

    @Override
    public void recuperarDatosMascotasRanking() {
        mediadorMascotasPetagram=new MediadorMascotasPetagram(contexto);
        mascotasMasRanking=mediadorMascotasPetagram.recuperarDatosMascotasRanking2();
        mostrarDatosMascotasRanking();
    }

    @Override
    public void mostrarDatosMascotasRanking() {
        interfaceMetodosFavoritosPrincipal.inicializarAdaptador(interfaceMetodosFavoritosPrincipal.crearAdaptador(mascotasMasRanking));
        interfaceMetodosFavoritosPrincipal.inicializarLayoutManager();
    }
}
