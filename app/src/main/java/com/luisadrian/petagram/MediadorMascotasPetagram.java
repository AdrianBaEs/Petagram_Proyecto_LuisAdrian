package com.luisadrian.petagram;

import android.content.ContentValues;
import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by luisadrian on 8/15/16.
 */
public class MediadorMascotasPetagram {
    Context contexto;

    public MediadorMascotasPetagram(Context contexto) {
        this.contexto = contexto;
    }

    public ArrayList<MascotasPetagram> recuperarDatosMascotas(){
        BaseDatosPetagram baseDatosRecuperacion=new BaseDatosPetagram(contexto);
        registrarMascotasPetagram();
        return baseDatosRecuperacion.recuperarDatos();
    }

    public ArrayList<MascotasPetagram> recuperarDatosMascotasRanking2(){
        BaseDatosPetagram baseDatosRecuperacionRanking=new BaseDatosPetagram(contexto);
        return baseDatosRecuperacionRanking.ultimasMascotasRanking();
    }

    public void registrarMascotasPetagram(){
        BaseDatosPetagram baseDatosAuxiliar=new BaseDatosPetagram(contexto);
        ContentValues mascota=new ContentValues();

        mascota.put(ConstantesBaseDatosPetagram.campoNombre,"Toby");
        mascota.put(ConstantesBaseDatosPetagram.campoNumeroLikes,0);
        mascota.put(ConstantesBaseDatosPetagram.campoImagenMascota,R.drawable.recurso_petagram_mascota01);

        baseDatosAuxiliar.añadirMascotasPetagram(mascota);

        ContentValues mascota2=new ContentValues();

        mascota2.put(ConstantesBaseDatosPetagram.campoNombre,"Rocky");
        mascota2.put(ConstantesBaseDatosPetagram.campoNumeroLikes,0);
        mascota2.put(ConstantesBaseDatosPetagram.campoImagenMascota,R.drawable.recurso_petagram_mascota02);

        baseDatosAuxiliar.añadirMascotasPetagram(mascota2);

        ContentValues mascota3=new ContentValues();

        mascota3.put(ConstantesBaseDatosPetagram.campoNombre,"Atenea");
        mascota3.put(ConstantesBaseDatosPetagram.campoNumeroLikes,0);
        mascota3.put(ConstantesBaseDatosPetagram.campoImagenMascota,R.drawable.recurso_petagram_mascota03);

        baseDatosAuxiliar.añadirMascotasPetagram(mascota3);

        ContentValues mascota4=new ContentValues();

        mascota4.put(ConstantesBaseDatosPetagram.campoNombre,"Angus");
        mascota4.put(ConstantesBaseDatosPetagram.campoNumeroLikes,0);
        mascota4.put(ConstantesBaseDatosPetagram.campoImagenMascota,R.drawable.recurso_petagram_mascota04);

        baseDatosAuxiliar.añadirMascotasPetagram(mascota4);

        ContentValues mascota5=new ContentValues();

        mascota5.put(ConstantesBaseDatosPetagram.campoNombre,"Bruno");
        mascota5.put(ConstantesBaseDatosPetagram.campoNumeroLikes,0);
        mascota5.put(ConstantesBaseDatosPetagram.campoImagenMascota,R.drawable.recurso_petagram_mascota05);

        baseDatosAuxiliar.añadirMascotasPetagram(mascota5);

        ContentValues mascota6=new ContentValues();

        mascota6.put(ConstantesBaseDatosPetagram.campoNombre,"Luna");
        mascota6.put(ConstantesBaseDatosPetagram.campoNumeroLikes,0);
        mascota6.put(ConstantesBaseDatosPetagram.campoImagenMascota,R.drawable.recurso_petagram_mascota06);

        baseDatosAuxiliar.añadirMascotasPetagram(mascota6);

        ContentValues mascota7=new ContentValues();

        mascota7.put(ConstantesBaseDatosPetagram.campoNombre,"Doggy");
        mascota7.put(ConstantesBaseDatosPetagram.campoNumeroLikes,0);
        mascota7.put(ConstantesBaseDatosPetagram.campoImagenMascota,R.drawable.recurso_petagram_mascota07);

        baseDatosAuxiliar.añadirMascotasPetagram(mascota7);

        ContentValues mascota8=new ContentValues();

        mascota8.put(ConstantesBaseDatosPetagram.campoNombre,"Blacky");
        mascota8.put(ConstantesBaseDatosPetagram.campoNumeroLikes,0);
        mascota8.put(ConstantesBaseDatosPetagram.campoImagenMascota,R.drawable.recurso_petagram_mascota08);

        baseDatosAuxiliar.añadirMascotasPetagram(mascota8);
    }

    public void insertarMascotaFavorita(MascotasPetagram mascotaFavorita){
        BaseDatosPetagram baseDatos=new BaseDatosPetagram(contexto);
        ContentValues mascotaFavoritaPetagram=new ContentValues();

        mascotaFavoritaPetagram.put(ConstantesBaseDatosPetagram.campoIdRecuperado,mascotaFavorita.getId());
        mascotaFavoritaPetagram.put(ConstantesBaseDatosPetagram.campoNombreRating,mascotaFavorita.getNombreMascota());
        mascotaFavoritaPetagram.put(ConstantesBaseDatosPetagram.campoNumeroLikesRating,1);
        mascotaFavoritaPetagram.put(ConstantesBaseDatosPetagram.campoImagenMascotaRating,mascotaFavorita.getImagenMascota());

        baseDatos.añadirMascotaFavorita(mascotaFavoritaPetagram);
    }

    public int mostrarLikesMascota(MascotasPetagram mascotaLikes){
        BaseDatosPetagram baseDatos=new BaseDatosPetagram(contexto);
        return baseDatos.recuperarLikesMascota(mascotaLikes);
    }

}
