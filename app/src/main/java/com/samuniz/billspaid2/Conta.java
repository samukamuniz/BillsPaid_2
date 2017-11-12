package com.samuniz.billspaid2;


public class Conta {
    private String id;
    private String descricaoConta;
    private String valorConta;

    public Conta (){
    }
    
    public Conta(String id, String descricaoConta, String valorConta) {
        this.id = id;
        this.descricaoConta = descricaoConta;
        this.valorConta = valorConta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricaoConta() {
        return descricaoConta;
    }

    public void setDescricaoConta(String descricaoConta) {
        this.descricaoConta = descricaoConta;
    }

    public String getValorConta() {
        return valorConta;
    }

    public void setValorConta(String valorConta) {
        this.valorConta = valorConta;
    }
}
