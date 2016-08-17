package com.luisadrian.petagram;

import android.content.Context;
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
public class FragmentPrincipal extends Fragment implements IFragmentPrincipal {

    public FragmentPrincipal() {
    }

    ArrayList<MascotasPetagram> mascotasPetagram;
    private RecyclerView recyclerViewMainPetagram;
    FragmentPrincipalPresentador fragmentPrincipalPresentador;
    Context contexto;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.principal_fragment,container,false);

        //Instanciando el RecyclerView como objeto
        recyclerViewMainPetagram=(RecyclerView) v.findViewById(R.id.recyclerViewMainPetagram);
        contexto=getActivity();

        //Instanciando el presentador como objeto, definiendo que tome en cuenta la interface implementada y obtenga el contexto del fragment
        fragmentPrincipalPresentador=new FragmentPrincipalPresentador(this,getContext());

        return v;
    }

    @Override
    public MascotasPetagramAdaptador crearAdaptador(ArrayList<MascotasPetagram> listaMascotas) {
        MascotasPetagramAdaptador mascotasPetagramMain=new MascotasPetagramAdaptador(listaMascotas,getActivity());
        return mascotasPetagramMain;
    }

    @Override
    public void inicializarAdaptador(MascotasPetagramAdaptador miAdaptador) {
        recyclerViewMainPetagram.setAdapter(miAdaptador);
    }

    @Override
    public void inicializarLayoutManager() {
        //Instanciando un objeto de tipo LinearLayoutManager, definiendo la orientacion y seteando el LayoutManager del RecyclerView
        LinearLayoutManager ordenRecyclerMain=new LinearLayoutManager(getActivity());
        ordenRecyclerMain.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewMainPetagram.setLayoutManager(ordenRecyclerMain);
    }

}
