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

public class MascotasFavoritas extends AppCompatActivity {

    Toolbar toolBarPetagramFavoritos;
    RelativeLayout layoutActionViewHuella;
    RelativeLayout layoutActionViewEstrella;
    ImageButton top5EstrellaPetagram;
    ArrayList<MascotasPetagram> mascotasFavoritasPetagram;
    private RecyclerView recyclerViewFavoritosPetagram;

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

        //Instanciando el RecyclerView como objeto, instanciando un objeto de la clase "LinearLayoutManager" para definir el orden que tomarán los Items
        recyclerViewFavoritosPetagram=(RecyclerView) findViewById(R.id.recyclerViewFavoritosPetagram);
        LinearLayoutManager ordenRecyclerFavoritos=new LinearLayoutManager(this);
        ordenRecyclerFavoritos.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewFavoritosPetagram.setLayoutManager(ordenRecyclerFavoritos);

        //2 Metodos: El primero contiene la colección de datos y el segundo la instancianción del objeto de la clase "Adaptador"
        coleccionDatosFavoritosPetagram();
        AdaptadorFavoritos();

    }

    public void coleccionDatosFavoritosPetagram(){
        //Instanciacion del ArrayList (Colección de datos)
        mascotasFavoritasPetagram=new ArrayList<MascotasPetagram>();
        //Añadiendo 5 objetos de tipo MascotasPetagram
        mascotasFavoritasPetagram.add(new MascotasPetagram("Bruno",21,R.drawable.recurso_petagram_mascota05));
        mascotasFavoritasPetagram.add(new MascotasPetagram("Tobby",18,R.drawable.recurso_petagram_mascota01));
        mascotasFavoritasPetagram.add(new MascotasPetagram("Luna",14,R.drawable.recurso_petagram_mascota06));
        mascotasFavoritasPetagram.add(new MascotasPetagram("Doggy",12,R.drawable.recurso_petagram_mascota07));
        mascotasFavoritasPetagram.add(new MascotasPetagram("Atenea",10,R.drawable.recurso_petagram_mascota03));
    }

    public void AdaptadorFavoritos(){
        MascotasPetagramAdaptador mascotasPetagramFavoritos=new MascotasPetagramAdaptador(mascotasFavoritasPetagram,this);
        recyclerViewFavoritosPetagram.setAdapter(mascotasPetagramFavoritos);
    }

}
