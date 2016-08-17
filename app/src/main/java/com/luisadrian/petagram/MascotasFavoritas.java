package com.luisadrian.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity implements IMascotasFavoritas {

    Toolbar toolBarPetagramFavoritos;
    RelativeLayout layoutActionViewHuella;
    RelativeLayout layoutActionViewEstrella;
    ImageButton top5EstrellaPetagram;
    ArrayList<MascotasPetagram> mascotasFavoritasPetagram;
    private RecyclerView recyclerViewFavoritosPetagram;
    MascotasFavoritasPresentador mascotasFavoritasPresentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favoritas_mascotas);

        //Definiendo "Toolbar" en esta Activity
        toolBarPetagramFavoritos=(Toolbar) findViewById(R.id.toolBarPetagramFavoritos);
        setSupportActionBar(toolBarPetagramFavoritos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Instanciando como objetos los "RelativeLayout" que contienen los "ItemView"
        layoutActionViewHuella=(RelativeLayout) findViewById(R.id.layoutActionViewHuella);
        layoutActionViewEstrella=(RelativeLayout) findViewById(R.id.layoutActionViewEstrella);

        //Instanciando como objeto un ItemView (Estrella que lleva a favoritos)
        top5EstrellaPetagram=(ImageButton) findViewById(R.id.top5EstrellaPetagram);
        //Ahora, utilizamos el metodo "setVisibility" para indicar que el icono "Estrella" NO sera visible en esta Activity
        top5EstrellaPetagram.setVisibility(View.INVISIBLE);

        //Instanciando el RecyclerView como objeto
        recyclerViewFavoritosPetagram=(RecyclerView) findViewById(R.id.recyclerViewFavoritosPetagram);

        //Instanciar el presentador como objeto (inicializar el proceso)
        mascotasFavoritasPresentador=new MascotasFavoritasPresentador(this,getBaseContext());

    }

    @Override
    public MascotasPetagramAdaptador crearAdaptador(ArrayList<MascotasPetagram> mascotasFavoritas) {
        MascotasPetagramAdaptador mascotasPetagramFavoritos=new MascotasPetagramAdaptador(mascotasFavoritas,this);
        return mascotasPetagramFavoritos;
    }

    @Override
    public void inicializarAdaptador(MascotasPetagramAdaptador adaptadorMascotasFavoritas) {
        recyclerViewFavoritosPetagram.setAdapter(adaptadorMascotasFavoritas);
    }

    @Override
    public void inicializarLayoutManager() {
        LinearLayoutManager ordenRecyclerFavoritos=new LinearLayoutManager(this);
        ordenRecyclerFavoritos.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewFavoritosPetagram.setLayoutManager(ordenRecyclerFavoritos);
    }
}
