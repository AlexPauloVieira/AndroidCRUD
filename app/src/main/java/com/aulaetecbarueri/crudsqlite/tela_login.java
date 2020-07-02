package com.aulaetecbarueri.crudsqlite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class tela_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);
    }

    Intent trocar = null;
    public void Logar (View v){
        EditText login = findViewById(R.id.username);
        EditText pass = findViewById(R.id.password);
        String loginStr = login.getText().toString();
        String passStr = pass.getText().toString();

        if (loginStr.equals("")  || loginStr.trim().isEmpty()) {
            Toast errorToast = Toast.makeText(tela_login .this, "Campo Usuário não pode estar vazio", Toast.LENGTH_SHORT);
            errorToast.show();
        }
        else if (passStr.equals("") || passStr.trim().isEmpty()) {
            Toast errorToast = Toast.makeText(tela_login .this, "Campo senha não pode estar vazio", Toast.LENGTH_SHORT);
            errorToast.show();
        }
        else if (loginStr.equals(passStr)){
            this.trocar = new Intent(tela_login.this,MainActivity.class);
            startActivity(this.trocar);
        }
        else {
            Toast errorToast = Toast.makeText(tela_login .this, "Usuário não cadastrado", Toast.LENGTH_SHORT);
            errorToast.show();
        }
    }
}
