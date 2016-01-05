package com.example.marcelopaglione.asprova2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by marcelopaglione on 10/23/15.
 */
public class PessoaDAO {
    private DBHelper dbHelper;
    private SQLiteDatabase mDatabase;

    public PessoaDAO(Context context) {
        dbHelper = new DBHelper(context);
        try {
            mDatabase = dbHelper.getWritableDatabase();
        }catch(Exception e) {
            Log.e("PessoaDAO", "Exception while connecting the DB.");
            e.printStackTrace();
        }
    }

    public void save(Pessoa p){
        ContentValues valores = new ContentValues();
        valores.put("nome", p.getNome());
        valores.put("sexo", p.getSexo());
        valores.put("idade", p.getIdade());

        long idGerado = mDatabase.insert("pessoal", null, valores);
        p.setId(idGerado);
        dbHelper.close();
    }

    public List<Pessoa> getPessoas(){
        List<Pessoa> pessoasList = new ArrayList<>();

        Cursor cursor = mDatabase.rawQuery("SELECT * FROM pessoal", null);
        cursor.moveToFirst();

        while(! cursor.isAfterLast()) {
            Pessoa p = new Pessoa();
            p.setId(cursor.getLong(0));
            p.setNome(cursor.getString(1));
            p.setSexo(cursor.getString(2));
            p.setIdade(cursor.getInt(3));
            pessoasList.add(p);
            cursor.moveToNext();
        }
        cursor.close();

        return pessoasList;
    }
}
