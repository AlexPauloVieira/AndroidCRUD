package com.aulaetecbarueri.crudsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexaoProdutos extends SQLiteOpenHelper{

    private static final String name = "bancoProdutos.db";
    private static final int version = 1;

    public ConexaoProdutos(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table produto(id integer primary key autoincrement, codigoDeBarras varchar(13), nome varchar(100), preco varchar(10), quantidade varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
