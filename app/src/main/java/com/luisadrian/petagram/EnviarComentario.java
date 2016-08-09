package com.luisadrian.petagram;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by luisadrian on 8/9/16.
 */
public class EnviarComentario extends AsyncTask<Void,Void,Void>{
    //Declarando Variables
    private Context context;
    private Session session;

    //Declarando las variables que contendrán los datos para enviar un comentario
    private String email;
    private String subject;
    private String message;

    //Declarando un ProgressDialog que se visualizará mientras se este enviando el mensaje
    private ProgressDialog progressDialog;

    //Metodo constructor de la clase
    public EnviarComentario(Context context, String email, String subject, String message){
        this.context = context;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //Mostrando el progressDialog
        progressDialog = ProgressDialog.show(context,"Enviando comentario","Espere un momento...",false,false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //Se detiene el progressDialog con este metodo
        progressDialog.dismiss();
        //Mostrando un Toast que notifica que el mensaje a sido enviado
        Toast.makeText(context,"El comentario ha sido enviado",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        //Creando propiedades
        Properties props = new Properties();

        //Configurando las propiedades de correo (configuraciones para Gmail)
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        //Creando una sesion
        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    //Verificando la cuenta
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(ConfiguracionMail.EMAIL, ConfiguracionMail.PASSWORD);
                    }
                });

        try {
            //Instanciando un objeto de tipo MimeMessage
            MimeMessage mm = new MimeMessage(session);

            //Seteando datos de envio
            mm.setFrom(new InternetAddress(ConfiguracionMail.EMAIL));
            //Definiendo el correo que envia el comentario
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            //Definiendo el motivo del mensaje
            mm.setSubject(subject);
            //Definiendo el mensaje
            mm.setText(message);

            //Enviando el comentario
            Transport.send(mm);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
