package com.example.spinnerbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private Spinner spinner ;
    private ArrayList<Producto> Productos = new ArrayList<Producto>();
    private ArrayList<String> listado ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       obtenerProductos();

        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_dropdown_item, listado);

        spinner.setAdapter(adapter);


    }

    public void Volver(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void obtenerProductos(){
        AdminBD admin = new AdminBD(this,"administracion", null, 1);
        SQLiteDatabase BD = admin.getWritableDatabase();


        Cursor resp = BD.rawQuery("select * from producto",null);
        while (resp.moveToNext()){
            Producto p = new Producto();
            p.setId(resp.getInt(0));
            p.setNombre(resp.getString(1));
            p.setValor(resp.getInt(2));
            Productos.add(p);

        }
        for (int i =0 ; i < Productos.size() ; i++){
            System.out.println(Productos.get(i).getNombre());
        }
        llenarProductos();
    }

    public void llenarProductos(){
        listado = new ArrayList<String>();
        /*
        for(Producto p :Productos) {
            listado.add(p.getNombre()+ " - $"+p.getValor());
        }

         */
        for (int i =0 ; i < Productos.size() ; i++){
            listado.add(Productos.get(i).getNombre()+" - "+Productos.get(i).getValor());
        }
    }
}