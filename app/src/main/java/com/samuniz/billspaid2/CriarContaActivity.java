package com.samuniz.billspaid2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class CriarContaActivity extends AppCompatActivity {

    //Definição de variáveis a ser usada nessa activity
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private FirebaseDatabase database;
    private DatabaseReference bdReference;

    private Conta contaUser;

    //Campos declarados no Layout da Activity
    private EditText editConta;
    private EditText editValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);

        mAuth = SingletonFirebase.getAutenticacao(); //Acessando autenticação via SingletonFirebase

        contaUser = getIntent().getParcelableExtra("conta");
        //Aqui se conecta as variáveis do Layout com o código da activity
        editConta = findViewById(R.id.contaDesc);
        editValor = findViewById(R.id.contaValor);

        editConta.setText(contaUser.getDescricaoConta());
        editValor.setText(contaUser.getValorConta());
    }

    public void salvarConta(View view){
        String account = editConta.getText().toString().trim();
        String amount = editValor.getText().toString().trim();

        if(account.equals("")){
            editConta.setError("Preencher este campo!");
            editConta.requestFocus();
            return;
        }
        if(amount.equals("")){
            editValor.setError("Preencher este campo!");
            editValor.requestFocus();
            return;
        }

        user = SingletonFirebase.getUser();
        database = SingletonFirebase.getDatabase();
        bdReference = SingletonFirebase.getReferenciaFirebase("users/" + user.getUid() + "/accounts");

        //Mapeando os dados para salvar
        Map<String, Object> userAccounts = new HashMap<>();
        userAccounts.put("conta", account);
        userAccounts.put("valor", amount);

        bdReference.setValue(userAccounts);
        finish();

    }
}
