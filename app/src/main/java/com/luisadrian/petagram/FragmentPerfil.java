package com.luisadrian.petagram;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPerfil extends Fragment {


    public FragmentPerfil() {
        // Required empty public constructor
    }

    private RecyclerView recyclerViewMiMascota;
    ArrayList<MascotasPetagram> fotosMiMascota;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.perfil_fragment,container,false);

        //Instanciando como objeto y definiendo el orden de sus items del RecyclerView
        recyclerViewMiMascota=(RecyclerView) v.findViewById(R.id.recyclerViewMiMascota);
        GridLayoutManager recyclerMiMascota=new GridLayoutManager(getActivity(),3);
        recyclerViewMiMascota.setLayoutManager(recyclerMiMascota);

        //Dos metodos: el primero contiene definidos los objetos y el segundo inicializa el adaptador
        datosMiMascotaPetagram();
        inicializarAdaptadorMiMascota();

        return v;
    }

    public void datosMiMascotaPetagram(){
        fotosMiMascota=new ArrayList<MascotasPetagram>();
        fotosMiMascota.add(new MascotasPetagram(21,R.drawable.recurso_petagram_mascota05));
        fotosMiMascota.add(new MascotasPetagram(12,R.drawable.recurso_petagram_mascota05));
        fotosMiMascota.add(new MascotasPetagram(16,R.drawable.recurso_petagram_mascota05));
        fotosMiMascota.add(new MascotasPetagram(8,R.drawable.recurso_petagram_mascota05));
        fotosMiMascota.add(new MascotasPetagram(11,R.drawable.recurso_petagram_mascota05));
        fotosMiMascota.add(new MascotasPetagram(19,R.drawable.recurso_petagram_mascota05));
        fotosMiMascota.add(new MascotasPetagram(5,R.drawable.recurso_petagram_mascota05));
        fotosMiMascota.add(new MascotasPetagram(14,R.drawable.recurso_petagram_mascota05));
        fotosMiMascota.add(new MascotasPetagram(9,R.drawable.recurso_petagram_mascota05));
    }

    public void inicializarAdaptadorMiMascota(){
        MiMascotaPetagramAdaptador miMascotaAdaptador=new MiMascotaPetagramAdaptador(fotosMiMascota,getActivity());
        recyclerViewMiMascota.setAdapter(miMascotaAdaptador);
    }

}
