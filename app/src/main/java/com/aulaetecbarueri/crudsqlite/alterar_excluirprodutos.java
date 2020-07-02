package com.aulaetecbarueri.crudsqlite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        if (id.equals("")  || id.trim().isEmpty()) {
            Toast.makeText(this, "Campo ID não pode estar vazio!", Toast.LENGTH_LONG).show();
        }
        else {
            try {
                produto = produtoDao.obterProdutos(id);
                this.id.setText(String.valueOf(produto.get(0).getID()));
                codigoDeBarras.setText(String.valueOf(produto.get(0).getCodigoDeBarras()));
                nome.setText(String.valueOf(produto.get(0).getNomeProduto()));
                preco.setText(String.valueOf(produto.get(0).getPrecoProduto()));
                quantidade.setText(String.valueOf(produto.get(0).getQuantidadeEstoque()));
            } catch (Exception e) {
                Toast.makeText(this, "ID não encontrado", Toast.LENGTH_LONG).show();
                this.id.setText(" ");
                this.codigoDeBarras.setText(" ");
                this.nome.setText(" ");
                this.preco.setText(" ");
                this.quantidade.setText(" ");
            }
        }

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

        Toast.makeText(this, "Produto atualizado com sucesso!" , Toast.LENGTH_LONG).show();
        this.id.setText(" ");
        this.codigoDeBarras.setText(" ");
        this.nome.setText(" ");
        this.preco.setText(" ");
        this.quantidade.setText(" ");
        this.id.requestFocus();
    }

    public void excluir(View v){

        int id = Integer.parseInt(this.id.getText().toString());

        produtoDao.excluirProduto(id);

        Toast.makeText(this, "Produto excluído com sucesso", Toast.LENGTH_SHORT).show();
        this.id.setText(" ");
        this.codigoDeBarras.setText(" ");
        this.nome.setText(" ");
        this.preco.setText(" ");
        this.quantidade.setText(" ");
        this.id.requestFocus();

    }

//    public void voltar(View v){
//
//        Intent it = new Intent(alterar_excluirprodutos.this, MainActivity.class);
//        startActivity(it);
//
//    }
}
