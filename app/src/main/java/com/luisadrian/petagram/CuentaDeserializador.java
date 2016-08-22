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
public class CuentaDeserializador implements JsonDeserializer <CuentaPrincipalResponse> {
    @Override
    public CuentaPrincipalResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        CuentaPrincipalResponse cuentaPrincipal = gson.fromJson(json, CuentaPrincipalResponse.class);
        JsonArray arregloJson = json.getAsJsonObject().getAsJsonArray(ConstantesJson.arregloTimeline);
        cuentaPrincipal.setMascotasPetagramMedia(deserealizarPerfilPetagram(arregloJson));
        return cuentaPrincipal;
    }

    private ArrayList<MascotasPetagram> deserealizarPerfilPetagram(JsonArray arregloJson) {
        ArrayList<MascotasPetagram> mascotasPetagram = new ArrayList<MascotasPetagram>();
        for(int i = 0; i < arregloJson.size(); i++ ){
            JsonObject DatosMascotas = arregloJson.get(i).getAsJsonObject();
            MascotasPetagram mascota = new MascotasPetagram();
            JsonObject imagen = DatosMascotas.getAsJsonObject(ConstantesJson.timelineImagenesUsuario);
            JsonObject stdUrlJson = imagen.getAsJsonObject(ConstantesJson.timelineImagenStandar);
            mascota.setImagenMascota(stdUrlJson.get(ConstantesJson.urlImagen).getAsString());

            JsonObject numeroLikes = DatosMascotas.getAsJsonObject(ConstantesJson.likesTimeline);
            mascota.setNumeroLikesOtrosUsuarios(numeroLikes.get(ConstantesJson.numeroLikesTimeline).getAsInt());
            mascotasPetagram.add(mascota);
        }

        return mascotasPetagram;
    }

}
