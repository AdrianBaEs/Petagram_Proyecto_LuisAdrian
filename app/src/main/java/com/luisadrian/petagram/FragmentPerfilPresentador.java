package com.luisadrian.petagram;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by luisadrian on 8/21/16.
 */
public class FragmentPerfilPresentador implements IFragmentPerfilPresentador {

    IFragmentPerfil iFragmentPerfil;
    private Context contexto;
    private ArrayList<MascotasPetagram> mascotas;
    private SeguidoresPerfilPetagram usuarioPerfil=new SeguidoresPerfilPetagram();
    private String cuentaInstagram;

    public FragmentPerfilPresentador(IFragmentPerfil iFragmentPerfil, Context contexto, String cuentaInstagram) {
        this.iFragmentPerfil = iFragmentPerfil;
        this.contexto = contexto;
        this.cuentaInstagram = cuentaInstagram;
        obtenerFotoPerfilInstagram();
    }

    @Override
    public void obtenerPerfil() {

    }

    @Override
    public void mostrarPerfilRV() {
        iFragmentPerfil.creaImagenFragmentPerfil(usuarioPerfil);
        iFragmentPerfil.inicializarAdaptadorFragmentPerfil(iFragmentPerfil.crearAdaptadorFragmentPerfil(mascotas));
        iFragmentPerfil.inicializarAdaptadorMiMascota();
    }

    @Override
    public void obtenerPerfilInstagram() {
        if(!usuarioPerfil.getUsuarioPerfil().equals("No se encontró al usuario solicitado")){
            ApiRestAdaptador  restApiAdapter = new ApiRestAdaptador();
            Gson gson = restApiAdapter.construirDeserealizadorPerfilMascota();
            IMetodosEndpoint endpointsApi = restApiAdapter.establecerConexionApiRestInstagram(gson);
            mascotas = new ArrayList<MascotasPetagram>();
            Call<CuentaPrincipalResponse> perfilResponseCall = endpointsApi.obtenerMediaOtro(usuarioPerfil.getId());
            perfilResponseCall.enqueue(new Callback<CuentaPrincipalResponse>() {
                @Override
                public void onResponse(Call<CuentaPrincipalResponse> call, Response<CuentaPrincipalResponse> response) {
                    CuentaPrincipalResponse perfilResponse = response.body();
                    mascotas = perfilResponse.getMascotasPetagramMedia();
                    mostrarPerfilRV();
                }

                @Override
                public void onFailure(Call<CuentaPrincipalResponse> call, Throwable t) {
                    Toast.makeText(contexto, "Perfil:" + t.toString() , Toast.LENGTH_SHORT).show();
                }
            });
        }
        else{
            mascotas =  new ArrayList<MascotasPetagram>();
            mostrarPerfilRV();
        }
    }

    @Override
    public void obtenerFotoPerfilInstagram() {
        ApiRestAdaptador restApiAdapter = new ApiRestAdaptador();
        Gson gson = restApiAdapter.construirDeserealizadorResultadosBusqueda();
        IMetodosEndpoint endpointsApi = restApiAdapter.establecerConexionApiRestInstagram(gson);

        Call<ResultadosBusquedaResponse> busquedaResponseCall = endpointsApi.ObtenerUsuarioBusqueda(cuentaInstagram, ConstantesApiRest.accessToken);
        busquedaResponseCall.enqueue(new Callback<ResultadosBusquedaResponse>() {
            @Override
            public void onResponse(Call<ResultadosBusquedaResponse> call, Response<ResultadosBusquedaResponse> response) {
                ResultadosBusquedaResponse busquedaResponse =  response.body();
                usuarioPerfil = busquedaResponse.getSeguidoresPetagram();
                if(!usuarioPerfil.getUsuarioPerfil().equals("No se encontró al usuario solicitado"))
                    obtenerPerfilInstagram();
                else{
                    usuarioPerfil.setUsuarioPerfil("No se encontró al usuario solicitado");
                    obtenerPerfilInstagram();
                }
            }

            @Override
            public void onFailure(Call<ResultadosBusquedaResponse> call, Throwable t) {
                Toast.makeText(contexto, " ¡Oops!, parece que hubo un error: " + t.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
