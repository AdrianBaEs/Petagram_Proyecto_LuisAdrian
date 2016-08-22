package com.luisadrian.petagram;

/**
 * Created by luisadrian on 8/20/16.
 */
public final class ConstantesApiRest {

    //Base de la URL, versión actual y Access Token para ejecutar cualquier Endpoint
    public static final String versionEndpoint = "/v1/";
    public static final String urlBase = "https://api.instagram.com" + versionEndpoint;
    public static final String accessToken = "3686851714.38522ac.e7f3504ae0144899a3c1023b67efa9d1";
    public static final String peticionAccessToken = "?access_token=";

    //Endpoint ----> https://api.instagram.com/v1/users/self/follows?access_token=3440249498.ddd48db.e0d6b826b21d4fb5915d8c44e00238b4
    public static final String peticionSeguidores = "users/self/follows";
    public static final String endpointRecuperarSeguidores = peticionSeguidores + peticionAccessToken + accessToken;

    //Endpoint ----> https://api.instagram.com/v1/users/self/media/recent/?access_token=3440249498.ddd48db.e0d6b826b21d4fb5915d8c44e00238b4
    public static final String peticionObtenerMediaCuenta = "users/self/media/recent/";
    public static final String endpointObtenerMediaCuenta = peticionObtenerMediaCuenta + peticionAccessToken + accessToken;

    //Endpoint ----> https://api.instagram.com/v1/users/search?q=usuario&access_token=3440249498.ddd48db.e0d6b826b21d4fb5915d8c44e00238b4
    public static final String peticionBuscarUsuario = "users/search";
    public static final String endpointBuscarUsuario = peticionBuscarUsuario;

    //Endpoint ----> https://api.instagram.com/v1/users/{user-id}/media/recent/?access_token=3440249498.ddd48db.e0d6b826b21d4fb5915d8c44e00238b4
    public static final String peticionObtenerMediaUsuario = "users/{id}/media/recent/";
    public static final String endpointObtenerMediaUsuario = peticionObtenerMediaUsuario + peticionAccessToken + accessToken;

}
