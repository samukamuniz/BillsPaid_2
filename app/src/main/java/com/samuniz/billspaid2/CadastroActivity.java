package com.samuniz.billspaid2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class CadastroActivity extends AppCompatActivity {

    //Definição de variáveis a ser usada nessa activity
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private FirebaseDatabase database;
    private DatabaseReference bdReference;

    //Campos declarados no Layout da Activity
    private EditText editUsuario;
    private EditText editEmail;
    private EditText editSenha;
    private Button btnCadastroLogin, btnCadastroSalvar;

    //Aqui é onde se inicia as coisas na tela
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //mAuth = FirebaseAuth.getInstance(); //Linha a Ser excluída
        mAuth = SingletonFirebase.getAutenticacao(); //Acessando autenticação via SingletonFirebase

        //Aqui se conecta as variáveis do Layout com o código da activity
        editUsuario = findViewById(R.id.cadUsuario);
        editEmail = findViewById(R.id.cadEmail);
        editSenha = findViewById(R.id.cadSenha);
        btnCadastroLogin = findViewById(R.id.btnCadastroLogin);
        btnCadastroSalvar = findViewById(R.id.btnCadastroSalvar);

        btnCadastroLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastroLogin();
            }
        });
        btnCadastroSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastroSalvar();
            }
        });

    }

    private void cadastroSalvar(){
        final String usuario = editUsuario.getText().toString().trim();
        final String email = editEmail.getText().toString().trim();
        String senha = editSenha.getText().toString().trim();

        if(usuario.equals("")){
            editUsuario.setError("Preencher este campo!");
            editUsuario.requestFocus();
            return;
        }
        if(email.equals("")){
            editEmail.setError("Preencher este campo!");
            editEmail.requestFocus();
            return;
        }
        if(senha.equals("")){
            editSenha.setError("Preencher este campo!");
            editSenha.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            /* [Velho] Antes do Singleton (Funcionava)
                            FirebaseUser user = mAuth.getCurrentUser(); //Pega o usuário atual
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference userRef = database.getReference("users/" + user.getUid());*/

                            // [Novo] Com o Singleton
                            user = SingletonFirebase.getUser(); //Resgatando usuário atual via SingletonFirebase
                            //database = SingletonFirebase.getDatabase();
                            bdReference = SingletonFirebase.getReferenciaFirebase("users/" + user.getUid());

                            //Mapeando os dados para salvar
                            Map<String, Object> userInfos = new HashMap<>();
                            userInfos.put("usuario", usuario);
                            userInfos.put("email", email);
                            //userRef.setValue(userInfos);
                            bdReference.setValue(userInfos);
                            Intent i = new Intent(CadastroActivity.this, LoginActivity.class);
                            startActivity(i);
                            finish();

                        } else {
                            try {
                                throw task.getException();
                            } catch (FirebaseAuthWeakPasswordException e){
                                editSenha.setError("Senha fraca!");
                                editSenha.requestFocus();
                            } catch (FirebaseAuthInvalidCredentialsException e){
                                editEmail.setError("E-mail inválido!");
                                editEmail.requestFocus();
                            } catch (FirebaseAuthUserCollisionException e){
                                editEmail.setError("E-mail já existe!");
                                editEmail.requestFocus();
                            } catch (Exception e){
                                Log.e("Cadastro", e.getMessage());
                            }
                        }
                    }
                });
    }

    private void cadastroLogin (){
        Intent i = new Intent(CadastroActivity.this, LoginActivity.class);
        startActivity(i);
    }
}