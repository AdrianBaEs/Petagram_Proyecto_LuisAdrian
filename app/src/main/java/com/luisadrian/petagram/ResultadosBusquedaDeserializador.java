package com.luisadrian.petagram;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by luisadrian on 8/21/16.
 */
public class ResultadosBusquedaDeserializador implements JsonDeserializer <ResultadosBusquedaResponse> {
    @Override
    public ResultadosBusquedaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        ResultadosBusquedaResponse resultadosBusqueda = gson.fromJson(json, ResultadosBusquedaResponse.class);
        JsonArray arregloJson = json.getAsJsonObject().getAsJsonArray(ConstantesJson.arregloBusqueda);
        resultadosBusqueda.setSeguidoresPetagram(deserializarResultados(arregloJson));
        return resultadosBusqueda;
    }

    private SeguidoresPerfilPetagram deserializarResultados(JsonArray arregloJson){
        SeguidoresPerfilPetagram seguidoresPerfil = new SeguidoresPerfilPetagram();
        if( arregloJson.size() > 0 ){
            JsonObject searchDataObject = arregloJson.get(0).getAsJsonObject();

            seguidoresPerfil.setUsuarioPerfil(searchDataObject.get(ConstantesJson.nombreUsuarioResultadoBusqueda).getAsString());
            seguidoresPerfil.setNombrePerfil(searchDataObject.get(ConstantesJson.nombreCompletoResultadoBusqueda).getAsString());
            seguidoresPerfil.setImagenPerfil(searchDataObject.get(ConstantesJson.fotoPerfilResultadoBusqueda).getAsString());
            seguidoresPerfil.setId(searchDataObject.get(ConstantesJson.idResultadoBusqueda).getAsString());

        } else
            seguidoresPerfil.setUsuarioPerfil("No se encontró al usuario solicitado");
            return seguidoresPerfil;
    }
}
