package com.luisadrian.petagram;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by luisadrian on 8/8/16.
 */
public class MiMascotaPetagramAdaptador extends RecyclerView.Adapter<MiMascotaPetagramAdaptador.MiMascotaPetagramViewHolder>{

    ArrayList<MascotasPetagram> fotosMiMascota;
    Activity activity;

    public MiMascotaPetagramAdaptador(ArrayList<MascotasPetagram> fotosMiMascota,Activity activity) {
        this.fotosMiMascota = fotosMiMascota;
        this.activity=activity;
    }


    @Override
    public MiMascotaPetagramViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewmascota,parent,false);
        return new MiMascotaPetagramViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MiMascotaPetagramViewHolder holder, int position) {
        MascotasPetagram fotosMiMascotaPetagram=fotosMiMascota.get(position);
        holder.ivItemRecyclerMiMascotaPetagram.setImageResource(fotosMiMascotaPetagram.getImagenMascota());
        holder.tvNumeroLikesMiMascota.setText(fotosMiMascotaPetagram.getNumeroLikesOtrosUsuarios()+"");
    }

    @Override
    public int getItemCount() {
        return fotosMiMascota.size();
    }

    public static class MiMascotaPetagramViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivItemRecyclerMiMascotaPetagram;
        private TextView tvNumeroLikesMiMascota;

        public MiMascotaPetagramViewHolder(View itemView) {
            super(itemView);
            ivItemRecyclerMiMascotaPetagram=(ImageView) itemView.findViewById(R.id.ivItemRecyclerMiMascotaPetagram);
            tvNumeroLikesMiMascota=(TextView) itemView.findViewById(R.id.tvNumeroLikesMiMascota);
        }
    }

}
