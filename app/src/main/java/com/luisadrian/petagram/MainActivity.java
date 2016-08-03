package com.luisadrian.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolBarPetagramMain;
    ImageButton top5EstrellaPetagram;
    RelativeLayout layoutActionViewHuella;
    RelativeLayout layoutActionViewEstrella;
    ArrayList<MascotasPetagram> mascotasPetagram;
    private RecyclerView recyclerViewMainPetagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Definiendo "Toolbar" en esta Activity
        toolBarPetagramMain=(Toolbar) findViewById(R.id.toolBarPetagramMain);
        setSupportActionBar(toolBarPetagramMain);

        //Instanciando como objetos los "RelativeLayout" que contienen los "ItemView"
        layoutActionViewHuella=(RelativeLayout) findViewById(R.id.layoutActionViewHuella);
        layoutActionViewEstrella=(RelativeLayout) findViewById(R.id.layoutActionViewEstrella);

        //Instanciando como objeto un ItemView (Estrella que lleva a favoritos)
        top5EstrellaPetagram=(ImageButton) findViewById(R.id.top5EstrellaPetagram);

        //Instanciando el RecyclerView como objeto
        recyclerViewMainPetagram=(RecyclerView) findViewById(R.id.recyclerViewMainPetagram);

        //Instanciando un objeto de tipo LinearLayoutManager, definiendo la orientacion y seteando el LayoutManager del RecyclerView
        LinearLayoutManager ordenRecyclerMain=new LinearLayoutManager(this);
        ordenRecyclerMain.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewMainPetagram.setLayoutManager(ordenRecyclerMain);

        //Metodos: el primero contiene la colección de datos de la cuál depende el RecyclerView para mostrar contenido, el segundo contiene la instanciacion de un objeto de la clase Adaptadora
        datosMascotasPetagram();
        Adaptador();

    }

    public void Adaptador(){
        MascotasPetagramAdaptador mascotasPetagramMain=new MascotasPetagramAdaptador(mascotasPetagram,this);
        recyclerViewMainPetagram.setAdapter(mascotasPetagramMain);
    }

    public void datosMascotasPetagram(){
        //Instanciacion del ArrayList
        mascotasPetagram=new ArrayList<MascotasPetagram>();
        //Declaramos directamente los objetos de tipo "MascotaPetagram" dentro de cada nuevo indice del ArrayList
        mascotasPetagram.add(new MascotasPetagram("Tobby",18,R.drawable.recurso_petagram_mascota01));
        mascotasPetagram.add(new MascotasPetagram("Rocky",6,R.drawable.recurso_petagram_mascota02));
        mascotasPetagram.add(new MascotasPetagram("Atenea",10,R.drawable.recurso_petagram_mascota03));
        mascotasPetagram.add(new MascotasPetagram("Angus",9,R.drawable.recurso_petagram_mascota04));
        mascotasPetagram.add(new MascotasPetagram("Bruno",21,R.drawable.recurso_petagram_mascota05));
        mascotasPetagram.add(new MascotasPetagram("Luna",14,R.drawable.recurso_petagram_mascota06));
        mascotasPetagram.add(new MascotasPetagram("Doggy",12,R.drawable.recurso_petagram_mascota07));
        mascotasPetagram.add(new MascotasPetagram("Blacky",4,R.drawable.recurso_petagram_mascota08));
    }

    public void presionarActionView5FavoritosPetagram(View v){
        //Acción a realizar del ActionView (Estrella)
        Intent irMis5FavoritosPetagram=new Intent(MainActivity.this,MascotasFavoritas.class);
        startActivity(irMis5FavoritosPetagram);
    }

}
