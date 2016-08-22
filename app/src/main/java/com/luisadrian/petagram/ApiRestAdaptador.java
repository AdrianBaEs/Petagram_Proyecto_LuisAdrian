package com.luisadrian.petagram;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by luisadrian on 8/21/16.
 */
public class ApiRestAdaptador {

    public IMetodosEndpoint establecerConexionApiRestInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesApiRest.urlBase)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(IMetodosEndpoint.class);
    }

    public Gson construirDeserealizadorMascotas(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ListaMultimediaResponse.class, new ListaMultimediaDeserializador());
        return gsonBuilder.create();
    }

    public Gson construirDeserealizadorListaSeguidores(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ListaSeguidoresPerfilResponse.class, new SeguidoresPerfilDeserializador());
        return gsonBuilder.create();
    }

    public Gson construirDeserealizadorResultadosBusqueda() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ResultadosBusquedaResponse.class, new ResultadosBusquedaDeserializador());
        return gsonBuilder.create();
    }

    public Gson construirDeserealizadorPerfilMascota(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(CuentaPrincipalResponse.class, new CuentaDeserializador());
        return gsonBuilder.create();
    }

}
