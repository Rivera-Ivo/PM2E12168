package com.example.pm2e12168;

/* Examen Programacion movil Primer paracial
 * Ivo Alejandro Rivera 223081021
 * Ana Leticia Montes 2120010068
 * */

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pm2e12168.Configuracion.Contactos;
import com.example.pm2e12168.Configuracion.SQLiteConexion;
import com.example.pm2e12168.Models.pais;

import java.util.ArrayList;

public class Principal extends AppCompatActivity {

    SQLiteConexion conexion;
    Button btnRegsitrar, btnvercontactos;
    EditText txtNombre, txtTelefono, txtnota;
    ImageView foto, agregar;
    Spinner combo;
    ArrayList<pais> listapaises;
    ArrayList<String> Arreglopaises;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


    conexion = new SQLiteConexion(this, Contactos.namedb, null,1);

    txtNombre = (EditText) findViewById(R.id.txtnombre);
    txtTelefono = (EditText) findViewById(R.id.txtTelefono);
    txtnota = (EditText) findViewById(R.id.txtNota);
    foto = (ImageView) findViewById(R.id.imgContacts);
    btnRegsitrar = (Button) findViewById(R.id.btnSalvar);
    btnvercontactos = (Button) findViewById(R.id.btnVerListaContactos);
    agregar = (ImageView) findViewById(R.id.img_mas);
    combo = (Spinner) findViewById(R.id.spinner2);


        ConsultarSpiner();

        ArrayAdapter<CharSequence> adp = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Arreglopaises );
        combo.setAdapter(adp);

    btnRegsitrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AgregarPersona();
        }
    });

    /*Ver ActivityLista*/
    btnvercontactos.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           Intent intent = new Intent(Principal.this,ActivityLista.class);
           startActivity(intent);

        }
    });

    /*Ver Registrar pais*/
    agregar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Principal.this, RegistrarPais.class);
            startActivity(intent);
        }
    });


    }

    public void AgregarPersona()
    {
        if (validar()) {
            try {
                SQLiteConexion conexion = new SQLiteConexion(this, Contactos.namedb, null, 1);
                SQLiteDatabase db = conexion.getWritableDatabase();

                ContentValues datos = new ContentValues();
                datos.put(Contactos.nombre, txtNombre.getText().toString());
                datos.put(Contactos.telefono, txtTelefono.getText().toString());
                datos.put(Contactos.nota, txtnota.getText().toString());
                datos.put(Contactos.pais, combo.getSelectedItem().toString());


                Long Resul = db.insert(Contactos.Tabla_Contacto, Contactos.id, datos);

                Toast.makeText(this, "Datos Registrados con Exito", Toast.LENGTH_SHORT).show();
                db.close();
                limpiar();
            } catch (Exception exception) {
                Toast.makeText(this, "Error no se pudo registrar", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void ConsultarSpiner()
    {
        SQLiteDatabase db = conexion.getReadableDatabase();
        pais country =null;
        listapaises = new ArrayList<pais>();
        Cursor cursor = db.rawQuery(Contactos.SelectTablePais,null);

        while (cursor.moveToNext()){
            country = new pais();
            country.setId(cursor.getInt(0));
            country.setPais(cursor.getString(1));

            listapaises.add(country);

        }
       cursor.close();
       obtenerlista();
    }

    private void obtenerlista() {
        Arreglopaises = new ArrayList<String>();

        for (int i = 0; i < listapaises.size(); i++)
        {
            Arreglopaises.add(listapaises.get(i).getId() + " - "+listapaises.get(i).getPais());
        }

    }


    /*Validar datos en blanco*/
    public boolean validar(){
        boolean retorna = true;
        if(txtNombre.getText().toString().isEmpty()){
            txtNombre.setError("No permite campo vacio");
            retorna = false;
        }
        if(txtTelefono.getText().toString().isEmpty()){
            txtTelefono.setError("No permite campo vacio");
            retorna = false;
        }
        if(txtnota.getText().toString().isEmpty()){
            txtnota.setError("No permite campo vacio");
            retorna = false;
        }
        return retorna;

    }

    public void limpiar(){
        txtTelefono.setText("");
        txtNombre.setText("");
        txtnota.setText("");

        txtNombre.requestFocus();

      /*  //Steara la imagen
        foto.setImageResource(R.drawable.cont); */
    }

}