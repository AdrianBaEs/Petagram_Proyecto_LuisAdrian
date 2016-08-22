package com.luisadrian.petagram;

/**
 * Created by luisadrian on 8/21/16.
 */
public class ConstantesJson {

    //Constante de la respuesta en formato Json para recuperar las imagenes de la cuenta
    public static final String arregloTimeline="data";

    public static final String timelineUsuario="user";
    public static final String timelineIdUsuario="id";
    public static final String timelineNombreCompleto="full_name";

    public static final String timelineImagenesUsuario="images";
    public static final String timelineImagenStandar="standard_resolution";
    public static final String urlImagen="url";

    public static final String likesTimeline="likes";
    public static final String numeroLikesTimeline="count";

    //Constantes de la respuesta en formato Json para recuperar los datos de los seguidores
    public static final String arregloSeguidores="data";
    public static final String usuarioSeguidores="username";
    public static final String seguidoresId="id";
    public static final String nombreCompletoSeguidores="full_name";
    public static final String fotoPerfilSeguidores="profile_picture";

    //Constantes de la respuesta en formato Json para recuperar datos de perfil
    public static final String arregloBusqueda="data";
    public static final String idResultadoBusqueda="id";
    public static final String nombreCompletoResultadoBusqueda="full_name";
    public static final String nombreUsuarioResultadoBusqueda="username";
    public static final String fotoPerfilResultadoBusqueda="profile_picture";
}
