package com.example.imgbtn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void presion1(View v){
        //Toast.makeText( context: this,text "Presionaste la estrella a color", Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Presionaste la estrella a color",Toast.LENGTH_LONG).show();
    }
}