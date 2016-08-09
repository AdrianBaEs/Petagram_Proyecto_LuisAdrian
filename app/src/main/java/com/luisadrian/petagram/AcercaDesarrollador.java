package com.luisadrian.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.mikhaellopez.circularimageview.CircularImageView;

public class AcercaDesarrollador extends AppCompatActivity {

    Toolbar toolBarAcercaDe;
    CircularImageView perfilDesarrollador;
    ImageButton top5EstrellaPetagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desarrollador_acerca);

        //Instanciando como objeto, definiendo el toolbar y habilitando la funcion del boton subir
        toolBarAcercaDe=(Toolbar) findViewById(R.id.toolBarAcercaDe);
        setSupportActionBar(toolBarAcercaDe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Instanciando como objeto estrella que representa favoritos
        top5EstrellaPetagram=(ImageButton) findViewById(R.id.top5EstrellaPetagram);
        top5EstrellaPetagram.setVisibility(View.INVISIBLE);

        onCreateCircularImage();

    }

    public void onCreateCircularImage(){
        perfilDesarrollador = (CircularImageView) findViewById(R.id.perfilDesarrollador);
        //Definiendo color del borde
        perfilDesarrollador.setBorderWidth(10);
        //Añadiendo sombra a la imagen
        perfilDesarrollador.addShadow();
    }
}
