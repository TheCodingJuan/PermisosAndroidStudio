package com.example.sistemas.permisos;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Contactos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        String color = getIntent().getStringExtra("color");

        TextView txtMensaje = (TextView)findViewById(R.id.textViewMensajeContactos);
        if(color.equals("verde")==true){
            txtMensaje.setTextColor(Color.GREEN);
            txtMensaje.setText("Permiso aceptado");
        }else{
            txtMensaje.setTextColor(Color.RED);
            txtMensaje.setText("Permiso denegado");
        }
    }
}
