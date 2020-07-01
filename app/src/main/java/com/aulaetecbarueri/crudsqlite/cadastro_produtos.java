package com.aulaetecbarueri.crudsqlite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class cadastro_produtos extends AppCompatActivity {

    private EditText codigoBarras;
    private EditText nomeProduto;
    private EditText precoProduto;
    private EditText quantidadeProduto;
    private ProdutoDAO produtoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produtos);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);
        this.codigoBarras = (EditText) findViewById(R.id.codigoBarras);
        this.nomeProduto = (EditText) findViewById(R.id.nomeProduto);
        this.precoProduto = (EditText) findViewById(R.id.precoProduto);
        this.quantidadeProduto = (EditText) findViewById(R.id.quantidadeProduto);
        produtoDao = new ProdutoDAO(this);
    }

    public void validarCamposProduto(View v){

            String codigoBarras;
            String nomeProduto;
            String precoProduto;
            String quantidadeProduto;

            codigoBarras = this.codigoBarras.getText().toString();
            nomeProduto = this.nomeProduto.getText().toString();
            precoProduto = this.precoProduto.getText().toString();
            quantidadeProduto = this.quantidadeProduto.getText().toString();

            int opcaoErrada = 0;

            /*Validação dos campos*/

            if (codigoBarras.equals("")  || codigoBarras.trim().isEmpty()){
                opcaoErrada = 1;
            }
            else if (codigoBarras.length() != 6) {
                opcaoErrada = 2;
            }
            else if (nomeProduto.equals("") || nomeProduto.trim().isEmpty()){
                opcaoErrada = 3;
            }
            else if ((precoProduto.isEmpty()) || precoProduto.trim().isEmpty()){
                opcaoErrada = 4;
            }
            else if (quantidadeProduto.equals("") || quantidadeProduto.trim().isEmpty()){
                opcaoErrada = 5;
            }

            /*Emite as mensagens*/
            switch (opcaoErrada){
                case 1 :  Toast.makeText(this, "O CAMPO CÓDIGO DE BARRAS É OBRIGATÓRIO", Toast.LENGTH_SHORT).show();
                    this.codigoBarras.requestFocus();
                    break;
                case 2:  Toast.makeText(this, "O CÓDIGO DE BARRAS DEVE TER 6 DÍGITOS", Toast.LENGTH_SHORT).show();
                    this.nomeProduto.requestFocus();
                    break;
                case 3:  Toast.makeText(this, "O CAMPO NOME É OBRIGATÓRIO", Toast.LENGTH_SHORT).show();
                    this.nomeProduto.requestFocus();
                    break;
                case 4: Toast.makeText(this, "O CAMPO PREÇO É OBRIGATÓRIO", Toast.LENGTH_SHORT).show();
                    this.precoProduto.requestFocus();
                    break;
                case 5:  Toast.makeText(this, "O CAMPO QUANTIDADE É OBRIGATÓRIO", Toast.LENGTH_SHORT).show();
                    this.quantidadeProduto.requestFocus();
                    break;
                default:
                    Produto p = new Produto();
                    p.setCodigoDeBarras(this.codigoBarras.getText().toString());
                    p.setNomeProduto(this.nomeProduto.getText().toString());
                    p.setPrecoProduto(this.precoProduto.getText().toString());
                    p.setQuantidadeEstoque(this.quantidadeProduto.getText().toString());
                    long id = produtoDao.inserirProduto(p);

                    Toast.makeText(this, "Cadastro Realizado com Sucesso, id do produto: " + id + "\nNome do Produto: " + nomeProduto + "\nCódigo de Barras: " + codigoBarras +
                        "\nPreçoUnidade: " + precoProduto + "\nQuantidade: " + quantidadeProduto, Toast.LENGTH_LONG).show();

                    this.codigoBarras.setText(" ");
                    this.nomeProduto.setText(" ");
                    this.precoProduto.setText(" ");
                    this.quantidadeProduto.setText(" ");
                    this.nomeProduto.requestFocus();

                    break;
            }

    }

    public void listarProdutos(View v){

        Intent it = new Intent(cadastro_produtos.this, listar_produtos.class);
        startActivity(it);

    }

    public void cancelarCamposProdutos(View v){
        this.codigoBarras.setText(" ");
        this.nomeProduto.setText(" ");
        this.precoProduto.setText(" ");
        this.quantidadeProduto.setText(" ");
    }
}

