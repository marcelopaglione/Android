package com.example.marcelopaglione.asprova2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class Questao6_MainActivity extends AppCompatActivity {
    Spinner spinner;
    RadioButton radioButton_comSD,radioButton_semSD;
    EditText editText_memoRAM,editText_nome;
    Button button_salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao6__main);
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

        radioButton_comSD = (RadioButton) findViewById(R.id.radioButton_comSD);
        radioButton_semSD = (RadioButton) findViewById(R.id.radioButton_semSD);
        editText_memoRAM = (EditText) findViewById(R.id.editText);
        editText_nome = (EditText) findViewById(R.id.editText2);
        button_salvar = (Button) findViewById(R.id.button_salvar_t2);
        spinner = (Spinner) findViewById(R.id.spinner);
        button_salvar.setOnClickListener(listener);

        ArrayAdapter<CharSequence> regAdapter = ArrayAdapter.createFromResource(this,
                R.array.opcao_OS, android.R.layout.simple_spinner_item);
        spinner.setAdapter(regAdapter);


        SharedPreferences preferences = getSharedPreferences("questao6", Context.MODE_PRIVATE);
        radioButton_comSD.setChecked(preferences.getBoolean("radio1",true));
        radioButton_semSD.setChecked(preferences.getBoolean("radio2",false));
        editText_memoRAM.setText(preferences.getString("memoriaRAM", ""));
        editText_nome.setText(preferences.getString("nome", ""));
        spinner.setSelection(preferences.getInt("OS",0));

    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences preferences = getSharedPreferences("questao6", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("radio1", radioButton_comSD.isChecked());
            editor.commit();
            editor.putBoolean("radio2", radioButton_semSD.isChecked());
            editor.commit();
            editor.putString("memoriaRAM", editText_memoRAM.getEditableText().toString());
            editor.commit();
            editor.putString("nome", editText_nome.getEditableText().toString());
            editor.commit();
            editor.putInt("OS", spinner.getSelectedItemPosition());
            editor.commit();
            Questao6_MainActivity.this.finish();
        }
    };

}
