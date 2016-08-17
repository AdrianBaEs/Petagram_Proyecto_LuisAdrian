package com.luisadrian.petagram;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by luisadrian on 8/15/16.
 */
public class BaseDatosPetagram extends SQLiteOpenHelper {
    Context contexto;

    public BaseDatosPetagram(Context contexto) {
        super(contexto, ConstantesBaseDatosPetagram.DATABASE_NAME, null, ConstantesBaseDatosPetagram.DATABASE_VERSION);
        this.contexto=contexto;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryTablaPrincipal="CREATE TABLE "+ConstantesBaseDatosPetagram.nombreTablaMascota+"("+
                                    ConstantesBaseDatosPetagram.campoId+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                                    ConstantesBaseDatosPetagram.campoNombre+" TEXT, "+
                                    ConstantesBaseDatosPetagram.campoNumeroLikes+" INTEGER, "+
                                    ConstantesBaseDatosPetagram.campoImagenMascota+" INTEGER"+")";

        String queryTablaRanking="CREATE TABLE "+ConstantesBaseDatosPetagram.nombreTablaMascotaRating+"("+
                                ConstantesBaseDatosPetagram.campoIdRating+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                                ConstantesBaseDatosPetagram.campoIdRecuperado+" INTEGER, "+
                                ConstantesBaseDatosPetagram.campoNombreRating+" TEXT, "+
                                ConstantesBaseDatosPetagram.campoNumeroLikesRating+" INTEGER, "+
                                ConstantesBaseDatosPetagram.campoImagenMascotaRating+" INTEGER, "+
                                "FOREIGN KEY ("+ConstantesBaseDatosPetagram.campoIdRecuperado+") "+
                                "REFERENCES "+ConstantesBaseDatosPetagram.nombreTablaMascota+"("+ConstantesBaseDatosPetagram.campoId+")"+
                                ")";

        sqLiteDatabase.execSQL(queryTablaPrincipal);
        sqLiteDatabase.execSQL(queryTablaRanking);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXIST "+ConstantesBaseDatosPetagram.nombreTablaMascota);
        //sqLiteDatabase.execSQL("DROP TABLE IF EXIST "+ConstantesBaseDatosPetagram.nombreTablaMascotaRating);

        onCreate(sqLiteDatabase);
    }

    public ArrayList<MascotasPetagram> recuperarDatos(){
        ArrayList<MascotasPetagram> todasLasMascotas=new ArrayList<MascotasPetagram>();

        String queryRecuperarTablaPrincipal="SELECT * FROM "+ConstantesBaseDatosPetagram.nombreTablaMascota;
        SQLiteDatabase baseDatos=this.getWritableDatabase();
        Cursor ejecucionQuery=baseDatos.rawQuery(queryRecuperarTablaPrincipal,null);

        while(ejecucionQuery.moveToNext()){
            MascotasPetagram mascotaPetagramRecovered=new MascotasPetagram();

            mascotaPetagramRecovered.setId(ejecucionQuery.getInt(0));
            mascotaPetagramRecovered.setNombreMascota(ejecucionQuery.getString(1));
            mascotaPetagramRecovered.setNumeroLikesOtrosUsuarios(ejecucionQuery.getInt(2));
            mascotaPetagramRecovered.setImagenMascota(ejecucionQuery.getInt(3));

            String queryVerificarLikes="SELECT COUNT ("+ConstantesBaseDatosPetagram.campoNumeroLikesRating+") as likes "+
                                        "FROM "+ConstantesBaseDatosPetagram.nombreTablaMascotaRating+" WHERE "+
                                        ConstantesBaseDatosPetagram.campoIdRecuperado+"="+mascotaPetagramRecovered.getId();

            Cursor ejecucionVerificacion=baseDatos.rawQuery(queryVerificarLikes,null);

            if(ejecucionVerificacion.moveToNext()){
                mascotaPetagramRecovered.setNumeroLikesOtrosUsuarios(ejecucionVerificacion.getInt(0));
            }else{
                mascotaPetagramRecovered.setNumeroLikesOtrosUsuarios(0);
            }

            todasLasMascotas.add(mascotaPetagramRecovered);
        }

        baseDatos.close();
        return todasLasMascotas;
    }

    public void añadirMascotasPetagram(ContentValues mascota){
        SQLiteDatabase baseDatos=this.getWritableDatabase();
        baseDatos.insert(ConstantesBaseDatosPetagram.nombreTablaMascota,null,mascota);
        baseDatos.close();
    }

    public ArrayList<MascotasPetagram> ultimasMascotasRanking(){
        ArrayList<MascotasPetagram> topRankingPetagram=new ArrayList<MascotasPetagram>();
        int n=ConstantesBaseDatosPetagram.nombreTablaMascotaRating.length()-5;
        int n2=ConstantesBaseDatosPetagram.nombreTablaMascotaRating.length();

        String queryRecuperarMasVotados="SELECT * FROM "+ConstantesBaseDatosPetagram.nombreTablaMascotaRating+" ORDER BY "+ConstantesBaseDatosPetagram.campoIdRating+" DESC LIMIT 5";
        SQLiteDatabase baseDatos=this.getWritableDatabase();
        Cursor ejecucionQueryTop=baseDatos.rawQuery(queryRecuperarMasVotados,null);

        while(ejecucionQueryTop.moveToNext()){
            MascotasPetagram mascotaVotada=new MascotasPetagram();

            mascotaVotada.setId(ejecucionQueryTop.getInt(0));
            mascotaVotada.setNombreMascota(ejecucionQueryTop.getString(2));
            mascotaVotada.setNumeroLikesOtrosUsuarios(ejecucionQueryTop.getInt(3));
            mascotaVotada.setImagenMascota(ejecucionQueryTop.getInt(4));

            topRankingPetagram.add(mascotaVotada);

        }

        baseDatos.close();
        return topRankingPetagram;
    }

    public void añadirMascotaFavorita(ContentValues mascotaFavorita){
        SQLiteDatabase baseDatos=this.getWritableDatabase();
        baseDatos.insert(ConstantesBaseDatosPetagram.nombreTablaMascotaRating,null,mascotaFavorita);
        baseDatos.close();
    }

    public int recuperarLikesMascota(MascotasPetagram mascotaLikes){
        int likes=0;
        String queryRecuperarLikesMascota="SELECT COUNT ("+ConstantesBaseDatosPetagram.campoNumeroLikesRating+") "+
                                            "FROM "+ConstantesBaseDatosPetagram.nombreTablaMascotaRating+
                                            " WHERE "+ConstantesBaseDatosPetagram.campoIdRecuperado+"="+mascotaLikes.getId();

        SQLiteDatabase baseDatos=this.getWritableDatabase();
        Cursor ejecucionQueryLikes=baseDatos.rawQuery(queryRecuperarLikesMascota,null);

        if(ejecucionQueryLikes.moveToNext()){
            likes=ejecucionQueryLikes.getInt(0);
        }

        baseDatos.close();
        return likes;
    }

}
