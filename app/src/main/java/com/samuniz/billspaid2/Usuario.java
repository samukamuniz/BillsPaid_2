package com.samuniz.billspaid2;


import java.util.List;

public class Usuario {
    private String id;
    private String nomeUsuario;
    private String emailUsuario;
    private String senhaUsuario;

    private List<String> contas;

    public Usuario() {
    }

    public Usuario(String id, String nomeUsuario, String emailUsuario, String senhaUsuario, List<String> contas) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
        this.contas = contas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public List<String> getContas() {
        return contas;
    }

    public void setContas(List<String> contas) {
        this.contas = contas;
    }
}
