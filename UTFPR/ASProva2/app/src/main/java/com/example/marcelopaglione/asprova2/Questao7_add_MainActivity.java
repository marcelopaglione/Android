package com.example.marcelopaglione.asprova2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Questao7_add_MainActivity extends AppCompatActivity {

    EditText editTextNome,editTextIdade;
    RadioButton radioButtonM,radioButtonF;
    Button buttonSalvar;
    PessoaDAO pDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao7_add__main);
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

        pDAO = new PessoaDAO(this);
        editTextIdade = (EditText) findViewById(R.id.editText_idade_t4);
        editTextNome = (EditText) findViewById(R.id.editText_nome_t4);
        radioButtonF = (RadioButton) findViewById(R.id.radioButton_feminino_t4);
        radioButtonM = (RadioButton) findViewById(R.id.radioButton_masculino_t4);
        buttonSalvar = (Button) findViewById(R.id.button_salvar_t4);
        buttonSalvar.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Pessoa p = new Pessoa();
            p.setNome(editTextNome.getEditableText().toString());
            if(!editTextIdade.getEditableText().toString().equals("")){
                p.setIdade(Integer.parseInt(editTextIdade.getEditableText().toString()));
            }else{
                p.setIdade(0);
            }

            if(radioButtonF.isChecked())
                p.setSexo(radioButtonF.getText().toString());
            else
                p.setSexo(radioButtonM.getText().toString());
            pDAO.save(p);

            Toast.makeText(Questao7_add_MainActivity.this, "Pessoa salva com sucesso! =D", Toast.LENGTH_LONG).show();
            Questao7_add_MainActivity.this.finish();
        }
    };
}
