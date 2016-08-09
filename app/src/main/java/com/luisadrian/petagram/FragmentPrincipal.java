package com.luisadrian.petagram;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by luisadrian on 8/8/16.
 */
public class FragmentPrincipal extends Fragment {

    public FragmentPrincipal() {
    }

    ArrayList<MascotasPetagram> mascotasPetagram;
    private RecyclerView recyclerViewMainPetagram;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.principal_fragment,container,false);

        //Instanciando el RecyclerView como objeto
        recyclerViewMainPetagram=(RecyclerView) v.findViewById(R.id.recyclerViewMainPetagram);

        //Instanciando un objeto de tipo LinearLayoutManager, definiendo la orientacion y seteando el LayoutManager del RecyclerView
        LinearLayoutManager ordenRecyclerMain=new LinearLayoutManager(getActivity());
        ordenRecyclerMain.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewMainPetagram.setLayoutManager(ordenRecyclerMain);

        //Metodos: el primero contiene la colección de datos de la cuál depende el RecyclerView para mostrar contenido, el segundo contiene la instanciacion de un objeto de la clase Adaptadora
        datosMascotasPetagram();
        Adaptador();

        return v;
    }

    public void Adaptador(){
        MascotasPetagramAdaptador mascotasPetagramMain=new MascotasPetagramAdaptador(mascotasPetagram,getActivity());
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
}
