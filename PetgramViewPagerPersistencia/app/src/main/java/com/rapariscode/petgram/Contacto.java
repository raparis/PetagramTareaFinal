package com.rapariscode.petgram;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.rapariscode.petgram.Correo.GMailSender;


public class Contacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

    }

    public void getBack( View v ) {
        finish();
    }

    public void sendComments( View v ) {

        final String myEmailAccount = getString(R.string.app_email);
        if ( myEmailAccount.trim().isEmpty() ) {
            Toast.makeText( getApplicationContext(), "Establezca nombre de usuario en el recurso strings (app_email)", Toast.LENGTH_LONG).show();
            return;
        }

        final String myPass = getString(R.string.app_email_password);
        if ( myPass.trim().isEmpty() ) {
            Toast.makeText( getApplicationContext(), "Establezca contraseña en el recurso strings (app_email_password)", Toast.LENGTH_LONG).show();
            return;
        }

        EditText comentarios = (EditText) findViewById(R.id.inputMensaje);
        final String myComments = comentarios.getText().toString();

        TextInputEditText senderName = (TextInputEditText) findViewById( R.id.inputSenderName );
        final String fSenderName = senderName.getText().toString();

        if ( fSenderName.trim().length() < 1 ) {
            Toast.makeText( this, getString( R.string.ingrese_nombre ), Toast.LENGTH_SHORT).show();
            return;
        }

        TextInputEditText senderMail = (TextInputEditText) findViewById( R.id.inputEmail );
        final String fSenderMail = senderMail.getText().toString();

        if ( fSenderMail.trim().length() < 1 ) {
            Toast.makeText( this, getString( R.string.ingrese_correo ), Toast.LENGTH_SHORT).show();
            return;
        }

        if ( myComments.trim().length() < 1 ) {
            Toast.makeText( this, getString( R.string.ingrese_comentarios ), Toast.LENGTH_SHORT).show();
            return;
        }

        final String SendTo = getString( R.string.app_send_to );

        new Thread(new Runnable() {

            @Override
            public void run() {


                try {
                    GMailSender sender = new GMailSender( myEmailAccount,
                            myPass);
                    sender.sendMail("Comentarios desde PetGram", fSenderName + " - " +
                            fSenderMail + " - " + myComments,
                            fSenderMail, SendTo + ", " + fSenderMail );
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }
            }

        }).start();

        Toast.makeText( this, getString(R.string.correo_enviado).toString(), Toast.LENGTH_LONG).show();

    }
}
