package com.luisadrian.petagram;

/**
 * Created by luisadrian on 8/21/16.
 */
public class SeguidoresPerfilPetagram {

    private String id;
    private String usuarioPerfil;
    private String nombrePerfil;
    private String imagenPerfil;

    public SeguidoresPerfilPetagram(String nombrePerfil, String usuarioPerfil, String imagenPerfil) {
        this.nombrePerfil = nombrePerfil;
        this.usuarioPerfil = usuarioPerfil;
        this.imagenPerfil = imagenPerfil;
    }

    public SeguidoresPerfilPetagram(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioPerfil() {
        return usuarioPerfil;
    }

    public void setUsuarioPerfil(String usuarioPerfil) {
        this.usuarioPerfil = usuarioPerfil;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }
}
