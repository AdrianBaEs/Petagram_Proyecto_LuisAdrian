package com.luisadrian.petagram;

/**
 * Created by luisadrian on 8/2/16.
 */
public class MascotasPetagram {

    //atributos de una "Mascota de Petagram"
    private String id;
    private String nombreMascota;
    private int numeroLikesOtrosUsuarios;
    private String imagenMascota;
    private int imagenLike;

    public MascotasPetagram(String nombreMascota,int numeroLikesOtrosUsuarios,String imagenMascota){
        this.nombreMascota=nombreMascota;
        this.numeroLikesOtrosUsuarios=numeroLikesOtrosUsuarios;
        this.imagenMascota=imagenMascota;
        this.imagenLike=R.drawable.recurso_petagram_like_pet_2;
    }

    public MascotasPetagram(int numeroLikesOtrosUsuarios,String imagenMascota){
        this.numeroLikesOtrosUsuarios=numeroLikesOtrosUsuarios;
        this.imagenMascota=imagenMascota;
    }

    public MascotasPetagram(){
        //Constructor vacio
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumeroLikesOtrosUsuarios() {
        return numeroLikesOtrosUsuarios;
    }

    public void setNumeroLikesOtrosUsuarios(int numeroLikesOtrosUsuarios) {
        this.numeroLikesOtrosUsuarios = numeroLikesOtrosUsuarios;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getImagenMascota() {
        return imagenMascota;
    }

    public void setImagenMascota(String imagenMascota) {
        this.imagenMascota = imagenMascota;
    }

    public int getImagenLike(){
        return imagenLike;
    }

    public void setImagenLike(int imagenLike){
        this.imagenLike=imagenLike;
    }

}
