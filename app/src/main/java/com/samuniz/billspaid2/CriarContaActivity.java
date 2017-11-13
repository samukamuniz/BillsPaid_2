package com.samuniz.billspaid2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CriarContaActivity extends AppCompatActivity {

    private EditText editConta, editValor;
    private Button btnContaSalvar;
    private FirebaseAuth authUsuario;
    private DatabaseReference dbConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);

        authUsuario = SingletonFirebase.getAutenticacao();
        dbConta = SingletonFirebase.getReferenciaFirebase("accounts" );
    }

    @Override
    protected void onResume() {
        super.onResume();

        editConta = findViewById(R.id.contaDesc);
        editValor = findViewById(R.id.contaValor);
        btnContaSalvar = findViewById(R.id.btnContaSalvar);


        btnContaSalvar.setOnClickListener(new View.OnClickListener() {
            String idC = UUID.randomUUID().toString();
            String descricaoC = editConta.getText().toString().trim();
            String valorC = editValor.getText().toString().trim();

            @Override
            public void onClick(View view) {
                if(!editConta.getText().toString().equals("") && !editValor.getText().toString().equals("")){
                    //Loader
                    cadastroConta(idC, descricaoC, valorC);
                } else {
                    Toast.makeText(CriarContaActivity.this, "Preencha os campos", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void cadastroConta(final String id, final String descricao, final String valor){
        Conta conta = new Conta(id, descricao, valor);
        dbConta.child(id).setValue(conta);
        //Loader
        irParaTelaDeLogin();
        

    }
    private void irParaTelaDeLogin(){
        Intent it = new Intent(CriarContaActivity.this, MainActivity.class);
        startActivity(it);
        finish();
    }
}
