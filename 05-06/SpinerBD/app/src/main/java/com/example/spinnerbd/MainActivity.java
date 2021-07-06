package com.example.spinnerbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText et_cod,et_nombre,et_valor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_cod = (EditText)findViewById(R.id.txtCod);
        et_nombre = (EditText)findViewById(R.id.txtNombre);
        et_valor =(EditText)findViewById(R.id.txtValor);


    }

    //Metodos botonoes
    public void Agregar(View v){
        AdminBD admin = new AdminBD(this,"administracion",null,1);
        SQLiteDatabase BD = admin.getWritableDatabase();

        String codigo = et_cod.getText().toString();
        String nombre = et_nombre.getText().toString();
        String valor = et_valor.getText().toString();

        if(!codigo.isEmpty() && !nombre.isEmpty()&& !valor.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("codigo",codigo);
            registro.put("nombre",nombre);
            registro.put("valor",valor);
            BD.insert("producto",null,registro);
            et_cod.setText("");
            et_nombre.getText().clear();
            et_valor.setText("");

            Toast.makeText(this,"Registro existoso",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Debes llenar todos los datos",Toast.LENGTH_LONG).show();
        }

    }

    public void Buscar(View v){
        AdminBD admin = new AdminBD(this,"administracion",null, 1);
        SQLiteDatabase BD = admin.getWritableDatabase();

        String codigo = et_cod.getText().toString();

        if(!codigo.isEmpty()){
            Cursor fila = BD.rawQuery
                    ("select nombre, valor from producto where codigo ="+codigo,null);
            if(fila.moveToFirst()){
                et_nombre.setText(fila.getString( 0));
                et_valor.setText(fila.getString(1));
                BD.close();
            }
        }else{
            Toast.makeText(this,"Debes ingresar el codigo del prducto",Toast.LENGTH_LONG).show();
            BD.close();
        }
    }

    public void Eliminar(View v){
        AdminBD admin = new AdminBD
                (this,"administracion",null,1);
        SQLiteDatabase BD = admin.getWritableDatabase();
        String codigo = et_cod.getText().toString();

        if(!codigo.isEmpty()){
            int cantidad = BD.delete("producto","codigo ="+codigo,null);
            BD.close();
            if(cantidad ==1){
                Toast.makeText(this,"Producto eleminado correctamente",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"Error al intentar eliminar",Toast.LENGTH_LONG).show();
            }

        }else{
            Toast.makeText(this,"Debes introducir el codigo del articulo",Toast.LENGTH_SHORT).show();
        }
    }

    public void Modificar(View v){
        AdminBD admin = new AdminBD
                (this, "administracion", null,1);
        SQLiteDatabase BD = admin.getWritableDatabase();

        String codigo = et_cod.getText().toString();
        String nombre = et_nombre.getText().toString();
        String valor = et_valor.getText().toString();

        if(!codigo.isEmpty() && !nombre.isEmpty() && !valor.isEmpty()){

            ContentValues registro = new ContentValues();
            registro.put("codigo",codigo);
            registro.put("nombre", nombre);
            registro.put("valor", valor);

            int cantidad = BD.update
                    ("producto",registro,"codigo = "+codigo,null);
            BD.close();

            if(cantidad == 1){
                Toast.makeText(this, "Datos modificados existosamente",Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this,"Error al modificar",Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this,"Debe llenar todos los campos",Toast.LENGTH_LONG).show();

        }

    }

   public void Listar (View v){
       Intent i = new Intent(this,MainActivity2.class);
       startActivity(i);
   }
}