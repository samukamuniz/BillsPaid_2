package com.samuniz.billspaid2;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SingletonFirebase {

    private static FirebaseDatabase database;
    private static DatabaseReference referenciaFirebase;
    private static FirebaseAuth autenticacao;
    private static FirebaseUser user;

    public static FirebaseDatabase getDatabase() {
        database = FirebaseDatabase.getInstance();
        return database;
    }

    public static DatabaseReference getReferenciaFirebase(String s) {
        if (referenciaFirebase == null){
            referenciaFirebase = FirebaseDatabase.getInstance().getReference(s);
        }
        return referenciaFirebase;
    }

    public static FirebaseAuth getAutenticacao() {
        if (autenticacao == null){
            autenticacao = FirebaseAuth.getInstance();
        }
        return autenticacao;
    }

    public static FirebaseUser getUser() {
        if (user == null){
            user = autenticacao.getCurrentUser();
        }
        return user;
    }
}
