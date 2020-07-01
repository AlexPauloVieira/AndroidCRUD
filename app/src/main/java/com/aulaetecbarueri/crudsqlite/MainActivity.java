package com.aulaetecbarueri.crudsqlite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);
    }



    public void alterarTela(View v){

        Intent it = new Intent(MainActivity.this,cadastro_produtos.class);
        startActivity(it);

    }

    public void telaExcluir(View v){

        Intent it = new Intent(MainActivity.this,alterar_excluirprodutos.class);
        startActivity(it);

    }

}
