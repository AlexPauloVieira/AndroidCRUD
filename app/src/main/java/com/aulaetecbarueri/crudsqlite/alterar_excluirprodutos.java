package com.aulaetecbarueri.crudsqlite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class alterar_excluirprodutos extends AppCompatActivity {

    private EditText id;
    private EditText codigoDeBarras;
    private EditText nome;
    private EditText preco;
    private EditText quantidade;
    private ProdutoDAO produtoDao;
    private List<Produto> produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_excluirprodutos);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        id = findViewById(R.id.ed_codigo);
        codigoDeBarras = findViewById(R.id.ed_codigoDeBarras);
        nome = findViewById(R.id.nomeLista);
        preco = findViewById(R.id.precoLista);
        quantidade = findViewById(R.id.quantidadeLista);

        produtoDao = new ProdutoDAO(this);
    }

    public void buscar(View v){

        String id = this.id.getText().toString();

            produto = produtoDao.obterProdutos(id);

                System.out.println(produto.get(0).getID());
                System.out.println(produto.get(0).getCodigoDeBarras());
                System.out.println(produto.get(0).getNomeProduto());
                System.out.println(produto.get(0).getPrecoProduto());
                System.out.println(produto.get(0).getQuantidadeEstoque());

                this.id.setText(String.valueOf(produto.get(0).getID()));
                codigoDeBarras.setText(String.valueOf(produto.get(0).getCodigoDeBarras()));
                nome.setText(String.valueOf(produto.get(0).getNomeProduto()));
                preco.setText(String.valueOf(produto.get(0).getPrecoProduto()));
                quantidade.setText(String.valueOf(produto.get(0).getQuantidadeEstoque()));


    }

    public void alterar (View v){

        Produto produto  = new Produto();

        int id = Integer.parseInt(this.id.getText().toString());
        produto.setID(id);
        produto.setCodigoDeBarras(codigoDeBarras.getText().toString());
        produto.setNomeProduto(nome.getText().toString());
        produto.setPrecoProduto(preco.getText().toString());
        produto.setQuantidadeEstoque(quantidade.getText().toString());

        produtoDao.alterarProduto(produto);

        Toast.makeText(this, "Produto alterado com sucesso - ID: " + id, Toast.LENGTH_SHORT).show();

    }

    public void excluir(View v){

        int id = Integer.parseInt(this.id.getText().toString());

        produtoDao.excluirProduto(id);

        Toast.makeText(this, "Produto alterado com sucesso - ID: " + id, Toast.LENGTH_SHORT).show();

    }
}
