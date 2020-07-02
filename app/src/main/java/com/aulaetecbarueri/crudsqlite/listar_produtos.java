package com.aulaetecbarueri.crudsqlite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class listar_produtos extends AppCompatActivity {

    private ListView listProduto;
    private ProdutoDAO produtoDao;
    private List<Produto> produtos;
    private List<Produto> produtosFiltrados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_produtos);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        listProduto = findViewById(R.id.lista_produtos);
        produtoDao = new ProdutoDAO(this);
        produtos = produtoDao.obterTodosProdutos();
        produtosFiltrados.addAll(produtos);
        ArrayAdapter<Produto> adaptador = new ArrayAdapter<Produto>(this, R.layout.my_textview, produtos);//criei a textview pra mudar a cor do texto na listview
        listProduto.setAdapter(adaptador);
    }
}
