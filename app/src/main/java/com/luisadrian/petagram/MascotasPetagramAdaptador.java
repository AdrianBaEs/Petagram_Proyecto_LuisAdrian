package com.luisadrian.petagram;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by luisadrian on 8/2/16.
 */
public class MascotasPetagramAdaptador extends RecyclerView.Adapter<MascotasPetagramAdaptador.MascotasPetagramViewHolder>{

    ArrayList<MascotasPetagram> mascotasPetagramColeccion;
    Activity activity;

    public MascotasPetagramAdaptador(ArrayList<MascotasPetagram> mascotasPetagramColeccion,Activity activity){
        this.mascotasPetagramColeccion=mascotasPetagramColeccion;
        this.activity=activity;
    }

    @Override
    public MascotasPetagramViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewpetagram,parent,false);
        return new MascotasPetagramViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotasPetagramViewHolder holder, int position) {
        final MascotasPetagram mascotaPetagram=mascotasPetagramColeccion.get(position);
        holder.tvNombreMascotaPetagram.setText(mascotaPetagram.getNombreMascota());
        holder.tvNumeroLikesMascotaPetagram.setText(mascotaPetagram.getNumeroLikesOtrosUsuarios()+"");
        //holder.ibItemRecyclerPetagram.setImageResource(mascotaPetagram.getImagenMascota());
        if(activity.getClass()==MascotasFavoritas.class){
            holder.ivIconoLikePetagram.setBackgroundResource(mascotaPetagram.getImagenLike());
        }
        holder.iconoHuesoDarLikeMascota.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                if(activity.getClass()==MainActivity.class){
                    Toast.makeText(activity,"Has dado like a "+holder.tvNombreMascotaPetagram.getText(),Toast.LENGTH_SHORT).show();
                    MediadorMascotasPetagram mediadorMascotasPetagram=new MediadorMascotasPetagram(activity);
                    mediadorMascotasPetagram.insertarMascotaFavorita(mascotaPetagram);
                    holder.tvNumeroLikesMascotaPetagram.setText(""+mediadorMascotasPetagram.mostrarLikesMascota(mascotaPetagram));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotasPetagramColeccion.size();
    }


    public static class MascotasPetagramViewHolder extends RecyclerView.ViewHolder {

        private ImageView ibItemRecyclerPetagram;
        private ImageButton iconoHuesoDarLikeMascota;
        private TextView tvNombreMascotaPetagram;
        private TextView tvNumeroLikesMascotaPetagram;
        private ImageButton ibHuesoNumeroLikesMascotaPetagram;
        private ImageView ivIconoLikePetagram;

        public MascotasPetagramViewHolder(View itemView) {
            super(itemView);
            //Instanciacion de objetos (Views) que recibiran datos de la coleccion de datos (ArrayList)
            ibItemRecyclerPetagram=(ImageView) itemView.findViewById(R.id.ibItemRecyclerPetagram);
            iconoHuesoDarLikeMascota=(ImageButton) itemView.findViewById(R.id.iconoHuesoDarLikeMascota);
            tvNombreMascotaPetagram=(TextView) itemView.findViewById(R.id.tvNombreMascotaPetagram);
            tvNumeroLikesMascotaPetagram=(TextView) itemView.findViewById(R.id.tvNumeroLikesMascotaPetagram);
            ibHuesoNumeroLikesMascotaPetagram=(ImageButton) itemView.findViewById(R.id.ibHuesoNumeroLikesMascotaPetagram);
            ivIconoLikePetagram=(ImageView) itemView.findViewById(R.id.ivIconoLikePetagram);
        }
    }

}
