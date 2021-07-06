package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //public EditText n1,n2,n3,n4,n5,n6,n7,n8,n9,n0,nDiv,nMult,nRes,nSum,nTot;
    Button n1,n2,n3,n4,n5,n6,n7,n8,n9,n0,nDiv,nMul,nRes,nSum,nTot;

    public TextView txtRes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set Botonoes
        n1 = (Button) findViewById(R.id.btn1);
        n2 = (Button) findViewById(R.id.btn2);
        n3 = (Button) findViewById(R.id.btn3);
        n4 = (Button) findViewById(R.id.btn4);
        n5 = (Button) findViewById(R.id.btn5);
        n6 = (Button) findViewById(R.id.btn6);
        n7 = (Button) findViewById(R.id.btn6);
        n8 = (Button) findViewById(R.id.btn8);
        n9 = (Button) findViewById(R.id.btn9);
        n0 = (Button) findViewById(R.id.btn0);
        nDiv = (Button) findViewById(R.id.btnDividir);
        nRes = (Button) findViewById(R.id.btnRes);
        nSum = (Button) findViewById(R.id.btnSum);
        nMul = (Button) findViewById(R.id.btnMult);
        nTot = (Button) findViewById(R.id.btnCl);

        txtRes = this.findViewById(R.id.txtTotal);



    }

    public void sumar(){

    }
    public void mostrar(){

    }

    public void click1(View v){
        txtRes.setText(txtRes.getText()+"1");
    }

    public void clear(View v){
        txtRes.setText("0");
    }
}