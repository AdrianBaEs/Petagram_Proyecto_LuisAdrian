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
public class SeguidoresPerfilDeserializador implements JsonDeserializer <ListaSeguidoresPerfilResponse> {
    @Override
    public ListaSeguidoresPerfilResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        ListaSeguidoresPerfilResponse listaSeguidoresPerfil = gson.fromJson(json, ListaSeguidoresPerfilResponse.class);
        JsonArray arregloJson = json.getAsJsonObject().getAsJsonArray(ConstantesJson.arregloSeguidores);
        listaSeguidoresPerfil.setSeguidoresPerfilPetagram(deserializarSeguidoresPerfil(arregloJson));
        return listaSeguidoresPerfil;
    }

    private ArrayList<SeguidoresPerfilPetagram> deserializarSeguidoresPerfil(JsonArray arregloJson) {
        ArrayList<SeguidoresPerfilPetagram> seguidoresPerfil = new ArrayList<SeguidoresPerfilPetagram>();
        for(int i = 0; i < arregloJson.size(); i++){
            JsonObject followedDataObject = arregloJson.get(i).getAsJsonObject();

            SeguidoresPerfilPetagram seguidores = new SeguidoresPerfilPetagram();

            seguidores.setId(followedDataObject.get(ConstantesJson.seguidoresId).getAsString());
            seguidores.setNombrePerfil(followedDataObject.get(ConstantesJson.nombreCompletoSeguidores).getAsString());
            seguidores.setUsuarioPerfil(followedDataObject.get(ConstantesJson.usuarioSeguidores).getAsString());
            seguidores.setImagenPerfil(followedDataObject.get(ConstantesJson.fotoPerfilSeguidores).getAsString());

            seguidoresPerfil.add(seguidores);
        }

        return seguidoresPerfil;
    }

}
