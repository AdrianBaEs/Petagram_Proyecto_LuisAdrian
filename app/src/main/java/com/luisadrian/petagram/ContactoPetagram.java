package com.luisadrian.petagram;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.w3c.dom.Text;

public class ContactoPetagram extends AppCompatActivity {

    Toolbar toolBarContacto;
    ImageButton top5EstrellaPetagram;
    private TextInputEditText editTextNombre;
    private TextInputEditText editTextCorreo;
    private TextInputEditText editTextMensaje;
    private Button botonEnviarMensajeContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.petagram_contacto);

        //Instanciando como objeto y definiendo toolbar
        toolBarContacto=(Toolbar) findViewById(R.id.toolBarContacto);
        setSupportActionBar(toolBarContacto);

        //Instanciando como objeto estrella que representa favoritos
        top5EstrellaPetagram=(ImageButton) findViewById(R.id.top5EstrellaPetagram);
        top5EstrellaPetagram.setVisibility(View.INVISIBLE);

        //Instanciar como objetos los EditText y el boton para enviar el comentario
        editTextNombre=(TextInputEditText) findViewById(R.id.editTextNombre);
        editTextCorreo=(TextInputEditText) findViewById(R.id.editTextCorreo);
        editTextMensaje=(TextInputEditText) findViewById(R.id.editTextMensaje);
        botonEnviarMensajeContacto=(Button) findViewById(R.id.botonEnviarMensajeContacto);




    }

    private void enviarComentario(){
        String nombre=editTextNombre.getText().toString().trim();
        String correo=editTextCorreo.getText().toString().trim();
        String mensaje=editTextMensaje.getText().toString().trim();

        EnviarComentario enviarEsteComentario=new EnviarComentario(this,correo,nombre,mensaje);

        enviarEsteComentario.execute();
    }

    public void presionarEnviar(View v){
        enviarComentario();
    }
}
