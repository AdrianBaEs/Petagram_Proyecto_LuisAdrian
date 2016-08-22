package com.luisadrian.petagram;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by luisadrian on 8/21/16.
 */
public interface IMetodosEndpoint {

    @GET(ConstantesApiRest.endpointObtenerMediaUsuario)
    Call<ListaMultimediaResponse> obtenerMediaUsuario(@Path("id") String id);

    @GET(ConstantesApiRest.endpointObtenerMediaUsuario)
    Call<CuentaPrincipalResponse> obtenerMediaOtro(@Path("id") String id);

    @GET(ConstantesApiRest.endpointRecuperarSeguidores)
    Call <ListaSeguidoresPerfilResponse> ObtenerSeguidores();


    @GET(ConstantesApiRest.endpointBuscarUsuario)
    Call<ResultadosBusquedaResponse> ObtenerUsuarioBusqueda(@Query("q") String jack, @Query("access_token") String access_token);
}
