package com.example.sistemas.permisos;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Contactos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        TextView txtMensaje = (TextView)findViewById(R.id.textViewMensajeContactos);

        txtMensaje.setVisibility(View.GONE);

        String color = getIntent().getStringExtra("color");

        if(color.equals("verde"))
        {
            txtMensaje.setText("Permiso Aceptado");
            txtMensaje.setTextColor(Color.GREEN);
            txtMensaje.setTextSize(24);
            txtMensaje.setVisibility(View.VISIBLE);

        }
        if(color.equals("rojo"))
        {
            txtMensaje.setText("Permisos Denegados");
            txtMensaje.setTextColor(Color.RED);
            txtMensaje.setVisibility(View.VISIBLE);
        }
    }
}
