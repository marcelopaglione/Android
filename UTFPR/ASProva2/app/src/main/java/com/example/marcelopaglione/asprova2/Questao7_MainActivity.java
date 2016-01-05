package com.example.marcelopaglione.asprova2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Questao7_MainActivity extends AppCompatActivity {

    Button buttonInserir,buttonMostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao7__main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        buttonInserir = (Button) findViewById(R.id.button_inserir_t3);
        buttonInserir.setOnClickListener(listener);
        buttonMostrar = (Button) findViewById(R.id.button_mostrar_t3);
        buttonMostrar.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i;
            switch (v.getId()){
                case R.id.button_inserir_t3:
                    i = new Intent(Questao7_MainActivity.this,Questao7_add_MainActivity.class);
                    startActivity(i);
                    break;
                case R.id.button_mostrar_t3:
                    i = new Intent(Questao7_MainActivity.this,Questao7_mostrar_MainActivity.class);
                    startActivity(i);
                    break;
            }
        }
    };

}
