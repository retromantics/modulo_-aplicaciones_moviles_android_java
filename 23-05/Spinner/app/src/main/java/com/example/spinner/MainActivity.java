package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1 ;
    private EditText et1,et2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txt1);
        et2 = (EditText)findViewById(R.id.txt2);
        tv1 = (TextView)findViewById(R.id.tvResultado);
        spinner1=(Spinner)findViewById(R.id.spinner1);

        String [] operaciones = {"Sumar","Restar","Multiplicar","Dividir"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,operaciones);
        spinner1.setAdapter(adapter);
    }

    public void calcular(View v){
        int valor1 = Integer.parseInt(et1.getText().toString());
        int valor2 = Integer.parseInt(et2.getText().toString());

        String seleccion = spinner1.getSelectedItem().toString();
        int resultado=0;

        if(seleccion.equals("Sumar")){
            resultado = valor1+valor2;
        }else if (seleccion.equals("Restar")){
            resultado= valor1-valor2;
        }else if(seleccion.equals("Multiplicar")){
            resultado = valor1*valor2;
        }else if(seleccion.equals("Dividir")){
            if(valor2 !=0){
                resultado = valor1/valor2;
            }else{
                Toast.makeText(this,"Imposible dividir por 0",Toast.LENGTH_LONG).show();
            }
        }
        tv1.setText(String.valueOf(resultado));
    }
}