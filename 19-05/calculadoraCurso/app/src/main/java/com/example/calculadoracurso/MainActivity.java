package com.example.calculadoracurso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    private TextView txtRTes ;
    public EditText e1,e2;
    public Button btnCalcular;
    public RadioButton rSum,rRes,rDiv,rMul;
    public RadioGroup radG ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        txtRTes = this.findViewById(R.id.txtResult);
        //editText
        e1 = this.findViewById(R.id.edit1);
        e2 = this. findViewById(R.id.edit2);
        //btn
        btnCalcular = this.findViewById(R.id.btnClacular);

    }

    public void calcular(View v){

        float n1 = !TextUtils.isEmpty(e1.getText())? Float.parseFloat(e1.getText().toString()):0;
        float n2 = !TextUtils.isEmpty(e2.getText())? Float.parseFloat(e2.getText().toString()):0;

        rSum = this.findViewById(R.id.radioSum);
        rDiv = this.findViewById(R.id.radioDiv);
        rRes = this.findViewById(R.id.radioRestar);
        rMul = this.findViewById(R.id.radioMulti);



        float resultado =0;

        if(rSum.isChecked()) {
            resultado = n1+n2;
        }
        else if(rRes.isChecked()) {
            resultado= n1-n2;
        }
        else if(rMul.isChecked()){
            resultado= n1*n2;
        }else if(rDiv.isChecked()){
            if(n2 == 0){
                Toast.makeText(this,"No es posible dividir por 0",Toast.LENGTH_LONG);
            }
            else{
                resultado = n1/n2;
            }
        }

        txtRTes.setText(String.valueOf(resultado));
    }
}