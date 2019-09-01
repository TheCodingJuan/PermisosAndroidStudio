package com.example.sistemas.permisos;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class ActividadPrincipal extends AppCompatActivity {

    final static int MY_PERMISSIONS= 1;

    ImageButton btnContactos;
    ImageButton btnCamara;

    String[] PERMISSIONS = {
            android.Manifest.permission.READ_CONTACTS,
            android.Manifest.permission.CAMERA
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnContactos = (ImageButton) findViewById(R.id.imageButtonContactos);
        btnCamara = (ImageButton) findViewById(R.id.imageButtonCamara);


        if(!hasPermissions(this, PERMISSIONS))
        {
            ActivityCompat.requestPermissions(this, PERMISSIONS, MY_PERMISSIONS);
        }

        btnContactos.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent;
                if (ContextCompat.checkSelfPermission(ActividadPrincipal.this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED)
                {
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

        btnCamara.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent;
                if (ContextCompat.checkSelfPermission(ActividadPrincipal.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                {
                    intent = new Intent(ActividadPrincipal.this, Camara.class);
                    startActivity(intent);
                }
                else{
                    intent = new Intent(ActividadPrincipal.this, Camara.class);
                    startActivity(intent);
                }
            }
        });
    }
    public static boolean hasPermissions(Activity context, String[] permissions) {
        if (context != null && permissions != null)
        {
            for (String permission : permissions)
            {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }


   @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        switch (requestCode)
        {
            case MY_PERMISSIONS:
            {
                if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED)
                {
                    btnCamara.setClickable(false);
                }
                else
                {
                    btnCamara.setClickable(true);
                }
            }
        }
    }
}

