package com.example.marcelopaglione.asprova2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by marcelopaglione on 10/23/15.
 */
public class DBHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "pessoal.db" ;
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE pessoal (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT NOT NULL," +
                "sexo TEXT NOT NULL," +
                "idade int);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS pessoal");
        onCreate(db);
    }
}
