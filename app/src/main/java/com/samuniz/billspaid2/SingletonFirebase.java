package com.samuniz.billspaid2;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SingletonFirebase {

    private static DatabaseReference referenciaFirebase;
    private static FirebaseAuth autenticacao;

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
}
