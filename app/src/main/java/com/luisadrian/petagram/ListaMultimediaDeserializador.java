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
public class ListaMultimediaDeserializador implements JsonDeserializer <ListaMultimediaResponse> {
    @Override
    public ListaMultimediaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson=new Gson();
        ListaMultimediaResponse listaMultimedia=gson.fromJson(json,ListaMultimediaResponse.class);
        JsonArray listaMultimediaDatos=json.getAsJsonObject().getAsJsonArray(ConstantesJson.arregloTimeline);
        listaMultimedia.setMascotasPetagramMedia(deserealizarImagenesMascota(listaMultimediaDatos));
        return listaMultimedia;
    }

    private ArrayList<MascotasPetagram> deserealizarImagenesMascota(JsonArray listaMultimediaDatos){
        ArrayList<MascotasPetagram> mascotasPetagram = new ArrayList<>();
        for (int i=0; i < listaMultimediaDatos.size();i++){
            JsonObject mascotasDatos = listaMultimediaDatos.get(i).getAsJsonObject();

            MascotasPetagram mascota = new MascotasPetagram();

            JsonObject usuario = mascotasDatos.getAsJsonObject(ConstantesJson.timelineUsuario);
            mascota.setId(usuario.get(ConstantesJson.timelineIdUsuario).getAsString());
            mascota.setNombreMascota(usuario.get(ConstantesJson.timelineNombreCompleto).getAsString());

            JsonObject imagen = mascotasDatos.getAsJsonObject(ConstantesJson.timelineImagenesUsuario);
            JsonObject stdUrlJson = imagen.getAsJsonObject(ConstantesJson.timelineImagenStandar);
            mascota.setImagenMascota(stdUrlJson.get(ConstantesJson.urlImagen).getAsString());

            JsonObject numeroLikes = mascotasDatos.getAsJsonObject(ConstantesJson.likesTimeline);
            mascota.setNumeroLikesOtrosUsuarios(numeroLikes.get(ConstantesJson.numeroLikesTimeline).getAsInt());
            mascotasPetagram.add(mascota);

        }
        return mascotasPetagram;
    }

}
