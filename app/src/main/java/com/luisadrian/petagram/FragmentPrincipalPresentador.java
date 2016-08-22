package com.luisadrian.petagram;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by luisadrian on 8/15/16.
 */
public class FragmentPrincipalPresentador implements IFragmentPrincipalPresentador {

    MediadorMascotasPetagram mediadorPetagram;
    IFragmentPrincipal interfaceMetodosPrincipal;
    ArrayList<MascotasPetagram> listaMascotasPetagram;
    ArrayList<SeguidoresPerfilPetagram> seguidores=new ArrayList<>();
    Context contexto;

    public FragmentPrincipalPresentador(IFragmentPrincipal interfaceMetodosPrincipal, Context contexto) {
        this.interfaceMetodosPrincipal=interfaceMetodosPrincipal;
        this.contexto=contexto;
        consultarBaseDatos();
        mostrarDatosRecuperados();
    }

    @Override
    public void consultarBaseDatos() {
        mediadorPetagram=new MediadorMascotasPetagram(contexto);
        listaMascotasPetagram=mediadorPetagram.recuperarDatosMascotas();
        mostrarDatosRecuperados();
    }

    @Override
    public void mostrarDatosRecuperados() {
        interfaceMetodosPrincipal.inicializarAdaptador(interfaceMetodosPrincipal.crearAdaptador(listaMascotasPetagram));
        interfaceMetodosPrincipal.inicializarLayoutManager();
    }

    @Override
    public void obtenerImagenesMascotas() {
        ApiRestAdaptador restApiAdapter = new ApiRestAdaptador();
        Gson gson = restApiAdapter.construirDeserealizadorMascotas();
        IMetodosEndpoint endpointsApi = restApiAdapter.establecerConexionApiRestInstagram(gson);

        for (int i=0;i<seguidores.size();i++){
            String id = seguidores.get(i).getId();
            Call<ListaMultimediaResponse> listaImagenesResponseCall = endpointsApi.obtenerMediaUsuario(id);
            listaImagenesResponseCall.enqueue(new Callback<ListaMultimediaResponse>() {
                @Override
                public void onResponse(Call<ListaMultimediaResponse> call, Response<ListaMultimediaResponse> response) {

                    ListaMultimediaResponse listaImagenesResponse=response.body();
                    ArrayList<MascotasPetagram> mascotasaux=new ArrayList<>();
                    mascotasaux=listaImagenesResponse.getMascotasPetagramMedia();
                    listaMascotasPetagram.addAll(mascotasaux);
                }

                @Override
                public void onFailure(Call<ListaMultimediaResponse> call, Throwable t) {
                    Toast.makeText(contexto, "¡Oops!, parece que hubo un error: " + t.toString(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    @Override
    public void obtenerSeguidores() {

        ApiRestAdaptador restApiAdapter = new ApiRestAdaptador();
        Gson gson = restApiAdapter.construirDeserealizadorListaSeguidores();
        IMetodosEndpoint endpointsApi = restApiAdapter.establecerConexionApiRestInstagram(gson);
        Call<ListaSeguidoresPerfilResponse> seguidoresResponseCall=endpointsApi.ObtenerSeguidores();
        seguidoresResponseCall.enqueue(new Callback<ListaSeguidoresPerfilResponse>() {
            @Override
            public void onResponse(Call<ListaSeguidoresPerfilResponse> call, Response<ListaSeguidoresPerfilResponse> response) {
                ListaSeguidoresPerfilResponse seguidoresResponse=response.body();
                seguidores=seguidoresResponse.getSeguidoresPerfilPetagram();
                obtenerImagenesMascotas();
                mostrarDatosRecuperados();
            }

            @Override
            public void onFailure(Call<ListaSeguidoresPerfilResponse> call, Throwable t) {
                Toast.makeText(contexto, "¡Oops!, parece que hubo un error: " + t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }


}

