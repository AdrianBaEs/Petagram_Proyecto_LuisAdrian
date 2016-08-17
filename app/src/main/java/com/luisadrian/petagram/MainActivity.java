package com.luisadrian.petagram;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolBarPetagramMain;
    ImageButton top5EstrellaPetagram;
    RelativeLayout layoutActionViewHuella;
    RelativeLayout layoutActionViewEstrella;
    TabLayout tabLayoutMain;
    ViewPager viewPagerMain;
    ArrayList<Fragment> fragmentsMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Definiendo "Toolbar" en esta Activity
        toolBarPetagramMain=(Toolbar) findViewById(R.id.toolBarPetagramMain);
        if(toolBarPetagramMain!=null) {
            setSupportActionBar(toolBarPetagramMain);
        }

        //Instanciando como objetos los "RelativeLayout" que contienen los "ItemView"
        layoutActionViewHuella=(RelativeLayout) findViewById(R.id.layoutActionViewHuella);
        layoutActionViewEstrella=(RelativeLayout) findViewById(R.id.layoutActionViewEstrella);

        //Instanciando como objeto un ItemView (Estrella que lleva a favoritos)
        top5EstrellaPetagram=(ImageButton) findViewById(R.id.top5EstrellaPetagram);

        //Instanciando como objetos el TabLayout y ViewPager
        tabLayoutMain=(TabLayout) findViewById(R.id.tabLayoutMain);
        viewPagerMain=(ViewPager) findViewById(R.id.viewPagerMain);

        //Dos metodos: Uno inicializa el ArrayList que contiene los Fragments y el otro se encarga de inicializar la adaptacion de los fragments al TabLayout
        inicializarArrayFragments();
        inicializarPagerAdapter();

    }

    public void inicializarArrayFragments(){
        fragmentsMainActivity= new ArrayList<Fragment>();
        fragmentsMainActivity.add(new FragmentPrincipal());
        fragmentsMainActivity.add(new FragmentPerfil());
    }

    public void inicializarPagerAdapter(){
        viewPagerMain.setAdapter(new ViewPagerAdaptador(getSupportFragmentManager(),fragmentsMainActivity));
        tabLayoutMain.setupWithViewPager(viewPagerMain);

        tabLayoutMain.getTabAt(0).setIcon(R.drawable.home_mascotas);
        tabLayoutMain.getTabAt(1).setIcon(R.drawable.perfil_petagram);
    }

    public void presionarActionView5FavoritosPetagram(View v){
        //Acción a realizar del ActionView (Estrella)
        Intent irMis5FavoritosPetagram=new Intent(MainActivity.this,MascotasFavoritas.class);
        startActivity(irMis5FavoritosPetagram);

        Toast.makeText(getApplicationContext(),getResources().getString(R.string.aviso_favoritos),Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.opcionContacto:
                Intent irContacto=new Intent(MainActivity.this,ContactoPetagram.class);
                startActivity(irContacto);
                break;

            case R.id.opcionAcercaDe:
                Intent irAcercaDe=new Intent(MainActivity.this,AcercaDesarrollador.class);
                startActivity(irAcercaDe);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
