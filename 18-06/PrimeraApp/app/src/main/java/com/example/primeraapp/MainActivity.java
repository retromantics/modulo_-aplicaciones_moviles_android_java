package com.example.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText e1,e2;
    public TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = this.findViewById(R.id.txt1);
        e2= this.findViewById(R.id.txt2);
        res=this.findViewById(R.id.result);
    }

    public void mostrarMensaje(View v){
        Toast.makeText(this, "Hola soy mensajito :D !", Toast.LENGTH_LONG).show();
    }

    public void decirhola(View v){
        Toast.makeText(this, "hola soy un perito uwu", Toast.LENGTH_LONG).show();
    }

    public  void sumar(View v){

        int v1 = Integer.parseInt(e1.getText().toString());
        int v2 = Integer.parseInt(e2.getText().toString());
        int resultado = v1+v2;
        res.setText("La suma es :" + resultado);
    }

}