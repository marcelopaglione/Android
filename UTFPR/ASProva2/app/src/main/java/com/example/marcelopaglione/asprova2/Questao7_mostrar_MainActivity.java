package com.example.marcelopaglione.asprova2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class Questao7_mostrar_MainActivity extends AppCompatActivity {
    ArrayAdapter<Pessoa> pessoaArrayAdapter;
    List<Pessoa> pessoaList;
    PessoaDAO pessoaDAO;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao7_mostrar__main);
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

        listView = (ListView) findViewById(R.id.listView);
        pessoaDAO = new PessoaDAO(this);
        pessoaList = pessoaDAO.getPessoas();

        pessoaArrayAdapter = new ArrayAdapter<Pessoa>(Questao7_mostrar_MainActivity.this, android.R.layout.simple_list_item_1, pessoaList);
        listView.setAdapter(pessoaArrayAdapter);
    }

}
