package com.example.pm2e12168;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pm2e12168.Configuracion.Contactos;
import com.example.pm2e12168.Configuracion.SQLiteConexion;
import com.example.pm2e12168.Models.pais;
import com.example.pm2e12168.Models.persona;

import java.util.ArrayList;

public class ActivityLista extends AppCompatActivity {

    SQLiteConexion conexion;
    Button btnatras, btneliminar, btnVerimg, btnactualiza;
    ListView listaContactos;
    ArrayList<persona> listapersonas;
    ArrayList<String> Arreglopersonas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);


            conexion = new SQLiteConexion(this, Contactos.namedb, null,1);
            btnatras = (Button)findViewById(R.id.btnatras);
            btneliminar = (Button) findViewById(R.id.btnEliminar);
            btnVerimg = (Button) findViewById(R.id.btnVerimg);
            btnactualiza = (Button) findViewById(R.id.btnActualizar);
            listaContactos = (ListView)findViewById(R.id.listaContactos);

            ConsultarSpiner();
            ArrayAdapter<CharSequence> adp = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Arreglopersonas );
            listaContactos.setAdapter(adp);


        /*boton regresar*/
        btnatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLista.this,Principal.class);
                startActivity(intent);
            }
        });



        listaContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Integer ItemDatos = listapersonas.get(i).getTelefono();
                Toast.makeText(ActivityLista.this,"Telefono " + ItemDatos, Toast.LENGTH_LONG ).show();

                alerta(ItemDatos);

                Intent intent = new Intent(ActivityLista.this, Activityllamada.class);
                startActivity(intent);
                intent.putExtra("telefono", ItemDatos);
                startActivity(intent);

            }
        });

    }


    private void ConsultarSpiner()
    {
        SQLiteDatabase db = conexion.getReadableDatabase();
        persona datos =null;
        listapersonas = new ArrayList<persona>();
        Cursor cursor = db.rawQuery(Contactos.SelectTableContactos,null);

        while (cursor.moveToNext()){
            datos = new persona();
            datos.setId(cursor.getInt(0));
            datos.setPais(cursor.getString(1));
            datos.setNombre(cursor.getString(2));
            datos.setTelefono(cursor.getInt(3));

            listapersonas.add(datos);

        }
        cursor.close();
        obtenerlista();
    }

    private void obtenerlista() {
        Arreglopersonas = new ArrayList<String>();

        for (int i = 0; i < listapersonas.size(); i++)
        {
            Arreglopersonas.add(listapersonas.get(i).getId()+ " - "+listapersonas.get(i).getNombre()+ " | "+listapersonas.get(i).getTelefono());
        }

    }

    private void alerta( Integer dato)
    {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Desea llamar a " + dato);

        alert.setMessage("llamando a");
    }


}


