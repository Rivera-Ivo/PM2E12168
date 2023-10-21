package com.example.pm2e12168;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.PixelCopy;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activityllamada extends AppCompatActivity {

    TextView txtNumero;
    Button btnllamar , btnatras;

    Integer numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityllamada);

        txtNumero = (TextView) findViewById(R.id.txtNumero);
        btnllamar = (Button) findViewById(R.id.btnllamar);
        btnatras = (Button) findViewById(R.id.btnAtras);

        recibirDatos();

        btnllamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                {
                    requestPermission(new String[]{Manifest.permission.CALL_PHONE},1);
                    String resu = txtNumero.getText().toString();

                    Toast.makeText(Activityllamada.this,"Telefono " + resu, Toast.LENGTH_LONG ).show();
                    Intent hacerllamada = new Intent(Intent.ACTION_CALL);
                    hacerllamada.setData(Uri.parse("tell"+ resu));
                    startActivity(hacerllamada);

                }

            }
        });

        btnatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(Activityllamada.this, ActivityLista.class);
                startActivity(inten);
            }
        });


    }

    private void requestPermission(String[] strings, int i) {
    }

    private void recibirDatos(){
        Intent extra = getIntent();
        Integer resultado = extra.getIntExtra("telefono",0);
        txtNumero = (TextView) findViewById(R.id. txtNumero);
        txtNumero.setText(String.valueOf(resultado));

    }


}