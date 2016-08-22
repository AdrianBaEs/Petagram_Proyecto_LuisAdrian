package com.luisadrian.petagram;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPerfil extends Fragment implements IFragmentPerfil {


    public FragmentPerfil() {
        // Required empty public constructor
    }

    private RecyclerView recyclerViewMiMascota;
    ArrayList<MascotasPetagram> fotosMiMascota;
    FragmentPerfilPresentador fragmentPerfilPresentador;
    CircularImageView perfilMiMascota;
    TextView tvNombreMiMascota;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.perfil_fragment,container,false);

        //Instanciando como objeto y definiendo el orden de sus items del RecyclerView
        recyclerViewMiMascota=(RecyclerView) v.findViewById(R.id.recyclerViewMiMascota);
        recyclerViewMiMascota.setHasFixedSize(true);
        GridLayoutManager recyclerMiMascota=new GridLayoutManager(getActivity(),3);
        recyclerViewMiMascota.setLayoutManager(recyclerMiMascota);
        perfilMiMascota=(CircularImageView) v.findViewById(R.id.perfilMiMascota);
        tvNombreMiMascota=(TextView) v.findViewById(R.id.tvNombreMiMascota);

        fragmentPerfilPresentador=new FragmentPerfilPresentador(this,getContext(),obtieneCuentaInstagram());

        //Dos metodos: el primero contiene definidos los objetos y el segundo inicializa el adaptador
        //datosMiMascotaPetagram();
        //inicializarAdaptadorMiMascota();

        return v;
    }

    /*public void datosMiMascotaPetagram(){
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
    } */

    private String obtieneCuentaInstagram() {
        SharedPreferences misReferencias =  this.getActivity().getSharedPreferences("shared", Context.MODE_PRIVATE);
        return misReferencias.getString("perfilInstagram", "");
    }

    public void inicializarAdaptadorMiMascota() {
        GridLayoutManager lManager = new GridLayoutManager(getActivity(), 2);
        recyclerViewMiMascota.setLayoutManager(lManager);
    }

    @Override
    public MiMascotaPetagramAdaptador crearAdaptadorFragmentPerfil(ArrayList<MascotasPetagram> mascotas) {
        MiMascotaPetagramAdaptador mascotaPetagramAdaptador=new MiMascotaPetagramAdaptador(mascotas,getActivity());
        return mascotaPetagramAdaptador;
    }

    @Override
    public void inicializarAdaptadorFragmentPerfil(MiMascotaPetagramAdaptador adaptador) {
        recyclerViewMiMascota.setAdapter(adaptador);
    }

    @Override
    public void creaImagenFragmentPerfil(SeguidoresPerfilPetagram usuarioPerfil) {

        Picasso.with(getActivity())
                .load(usuarioPerfil.getImagenPerfil())
                .placeholder(R.drawable.recurso_petagram_icono_huella_blanco)
                .into(perfilMiMascota);

        tvNombreMiMascota.setText(usuarioPerfil.getNombrePerfil());

    }


}
