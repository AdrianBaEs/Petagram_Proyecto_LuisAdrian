package com.luisadrian.petagram;

/**
 * Created by luisadrian on 8/2/16.
 */
public class MascotasPetagram {

    //atributos de una "Mascota de Petagram"
    private String nombreMascota;
    private int numeroLikesOtrosUsuarios;
    private boolean meGusta;
    private int imagenMascota;
    private int imagenLike;

    public MascotasPetagram(String nombreMascota,int numeroLikesOtrosUsuarios,int imagenMascota){
        this.nombreMascota=nombreMascota;
        this.numeroLikesOtrosUsuarios=numeroLikesOtrosUsuarios;
        this.meGusta=false;
        this.imagenMascota=imagenMascota;
        this.imagenLike=R.drawable.recurso_petagram_like_pet_2;
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

    public boolean isMeGusta() {
        return meGusta;
    }

    public void setMeGusta(boolean meGusta) {
        this.meGusta = meGusta;
    }

    public int getImagenMascota() {
        return imagenMascota;
    }

    public void setImagenMascota(int imagenMascota) {
        this.imagenMascota = imagenMascota;
    }

    public int getImagenLike(){
        return imagenLike;
    }

    public void setImagenLike(int imagenLike){
        this.imagenLike=imagenLike;
    }

}
