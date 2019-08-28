package com.example.sistemas.permisos;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class ActividadPrincipal extends AppCompatActivity {

    final static int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 0;
    final static int MY_PERMISSIONS_REQUEST_CAMERA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        ImageButton btnContactos = (ImageButton) findViewById(R.id.imageButtonContactos);
        ImageButton btnCamara = (ImageButton) findViewById(R.id.imageButtonCamara);

        btnContactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPermission(ActividadPrincipal.this, "Manifest.permission.READ_CONTACTS", "I want to spy you", MY_PERMISSIONS_REQUEST_READ_CONTACTS);
                Intent intent;
                if (ContextCompat.checkSelfPermission(ActividadPrincipal.this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                    intent = new Intent(ActividadPrincipal.this, Contactos.class);
                    intent.putExtra("color","verde");
                    startActivity(intent);
                } else {
                    intent = new Intent(ActividadPrincipal.this, Contactos.class);
                    intent.putExtra("color","rojo");
                    startActivity(intent);
                }
            }
        });

        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPermission(ActividadPrincipal.this, "Manifest.permission.CAMERA", "I want to spy you", MY_PERMISSIONS_REQUEST_CAMERA);
                Intent intent;
                if (ContextCompat.checkSelfPermission(ActividadPrincipal.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    intent = new Intent(ActividadPrincipal.this, Camara.class);
                    intent.putExtra("color","verde");
                    startActivity(intent);
                }else{
                    intent = new Intent(ActividadPrincipal.this, Camara.class);
                    intent.putExtra("color","rojo");
                    startActivity(intent);
                }
            }
        });
    }

    private void requestPermission(Activity context, String permiso, String justificacion, int idCode) {

        if (ContextCompat.checkSelfPermission(context, permiso) != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(ActividadPrincipal.this, permiso)) {
                Toast.makeText(context, "I need read the contacts because I want to spy you", Toast.LENGTH_LONG).show();
            }
            // request the permission.
            ActivityCompat.requestPermissions(context, new String[]{permiso}, idCode);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){
        Intent intent;
        switch (requestCode){
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    intent = new Intent(ActividadPrincipal.this, Contactos.class);
                    intent.putExtra("color","verde");
                    startActivity(intent);
                }else{
                    intent = new Intent(ActividadPrincipal.this, Contactos.class);
                    intent.putExtra("color","rojo");
                    startActivity(intent);
                }

            case MY_PERMISSIONS_REQUEST_CAMERA:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    intent = new Intent(ActividadPrincipal.this, Camara.class);
                    intent.putExtra("color","verde");
                    startActivity(intent);
                }else{
                    intent = new Intent(ActividadPrincipal.this, Camara.class);
                    intent.putExtra("color","rojo");
                    startActivity(intent);
                }
        }
    }

}
