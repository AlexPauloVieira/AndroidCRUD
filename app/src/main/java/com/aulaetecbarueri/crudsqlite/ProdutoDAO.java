package com.aulaetecbarueri.crudsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private ConexaoProdutos conexaoProdutos;
    private SQLiteDatabase bancoProdutos;

    public ProdutoDAO(Context context) {

        conexaoProdutos = new ConexaoProdutos(context);
        bancoProdutos = conexaoProdutos.getWritableDatabase();

    }

    public long inserirProduto(Produto produto){

        ContentValues values = new ContentValues();
        values.put("codigoDeBarras", produto.getCodigoDeBarras());
        values.put("nome", produto.getNomeProduto());
        values.put("preco", produto.getPrecoProduto());
        values.put("quantidade", produto.getQuantidadeEstoque());

        return bancoProdutos.insert("produto", null, values);

    }

    public void alterarProduto(Produto produto){

        ContentValues values = new ContentValues();
        values.put("codigoDeBarras", produto.getCodigoDeBarras());
        values.put("nome", produto.getNomeProduto());
        values.put("preco", produto.getPrecoProduto());
        values.put("quantidade", produto.getQuantidadeEstoque());

        bancoProdutos.update("produto", values, "id = ?", new String[]{String.valueOf(produto.getID())});

    }

    public void excluirProduto(int id){

        bancoProdutos.delete("produto", "id = ?", new String[]{ String.valueOf(id) });

    }

    public List<Produto> obterTodosProdutos() {

        List<Produto> produtos = new ArrayList<>();
        Cursor cursor = bancoProdutos.query("produto", new String[]{"id", "codigoDeBarras", "nome", "preco", "quantidade"}, null, null, null, null, null);

        while (cursor.moveToNext()) {

            Produto p = new Produto();
            p.setID(cursor.getInt(0));
            p.setCodigoDeBarras(cursor.getString(1));
            p.setNomeProduto(cursor.getString(2));
            p.setPrecoProduto(cursor.getString(3));
            p.setQuantidadeEstoque(cursor.getString(4));

            produtos.add(p);

        }

        return produtos;

    }

    public List<Produto> obterProdutos(String cod){

        String[] codigo = new String[]{cod};

        List<Produto> produtos = new ArrayList<>();
        Cursor cursor = bancoProdutos.rawQuery("SELECT id, codigoDeBarras, nome, preco, quantidade FROM produto WHERE ID = ?", codigo);

            while (cursor.moveToNext()) {
                Produto p = new Produto();
                p.setID(cursor.getInt(0));
                p.setCodigoDeBarras(cursor.getString(1));
                p.setNomeProduto(cursor.getString(2));
                p.setPrecoProduto(cursor.getString(3));
                p.setQuantidadeEstoque(cursor.getString(4));
                produtos.add(p);
            }


        return produtos;

    }

}
