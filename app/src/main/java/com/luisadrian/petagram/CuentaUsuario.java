package com.luisadrian.petagram;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CuentaUsuario extends AppCompatActivity {

    TextInputEditText editTextUsuario;
    Button botonSincronizarCuentaUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usuario_cuenta);

        Toolbar toolBarCuenta=(Toolbar) findViewById(R.id.toolBarCuenta);
        setSupportActionBar(toolBarCuenta);

        editTextUsuario=(TextInputEditText) findViewById(R.id.editTextUsuario);
        botonSincronizarCuentaUsuario=(Button) findViewById(R.id.botonSincronizarCuentaUsuario);

    }

    public void presionarSincronizarCuenta(View v){
        GuardarCuentaUsuario();
    }

    private void GuardarCuentaUsuario() {
        String usuario = editTextUsuario.getText().toString().trim();
        if(validarEditText(usuario)){
            SharedPreferences perfilInstagram = getSharedPreferences("shared", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = perfilInstagram.edit();
            editor.putString("perfilInstagram", usuario);
            editor.commit();

            Toast.makeText(this, "La cuenta se ha sincronizado", Toast.LENGTH_SHORT).show();
        }
        else{
            editTextUsuario.setError("El usuario no existe");
        }

    }

    private boolean validarEditText(String usuario) {
        if(usuario.isEmpty() || usuario == null || usuario.length() == 0)
            return false;
        else
            return true;
    }
}
