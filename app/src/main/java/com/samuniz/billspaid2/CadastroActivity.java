package com.samuniz.billspaid2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CadastroActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText editUsuario;
    private EditText editEmail;
    private EditText editSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        mAuth = FirebaseAuth.getInstance();

        editUsuario = findViewById(R.id.cadUsuario);
        editEmail = findViewById(R.id.cadEmail);
        editSenha = findViewById(R.id.cadSenha);
    }

    public void salvar(View view){
        String usuario = editUsuario.getText().toString().trim();
        String email = editEmail.getText().toString().trim();
        String senha = editSenha.getText().toString().trim();

        if(usuario.equals("")){
            editUsuario.setError("Preencher este campo!");
            editUsuario.requestFocus();
            return;
        }
        if(usuario.equals("")){
            editEmail.setError("Preencher este campo!");
            editEmail.requestFocus();
            return;
        }
        if(usuario.equals("")){
            editSenha.setError("Preencher este campo!");
            editSenha.requestFocus();
            return;
        }

        mAuth.createUserWifiEmailAndPassword(email, senha)
                .addOnCompleteListenner(this, new OnCompleteListener<AuthResult>(){
            @
        }
    }
}
