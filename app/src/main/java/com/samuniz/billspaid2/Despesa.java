package com.samuniz.billspaid2;

public class Despesa {
    private String valorDespesa;
    private String dataDespesa;
    private String descricaoDespesa;
    private String categoriaDespesa;
    private String contaDespesa;
    private String checkDespesa;

    public Despesa(){
    }

    public Despesa(String valorDespesa, String dataDespesa, String descricaoDespesa,
                   String categoriaDespesa, String contaDespesa, String checkDespesa) {
        this.valorDespesa = valorDespesa;
        this.dataDespesa = dataDespesa;
        this.descricaoDespesa = descricaoDespesa;
        this.categoriaDespesa = categoriaDespesa;
        this.contaDespesa = contaDespesa;
        this.checkDespesa = checkDespesa;
    }

    public String getValorDespesa() {
        return valorDespesa;
    }

    public void setValorDespesa(String valorDespesa) {
        this.valorDespesa = valorDespesa;
    }

    public String getDataDespesa() {
        return dataDespesa;
    }

    public void setDataDespesa(String dataDespesa) {
        this.dataDespesa = dataDespesa;
    }

    public String getDescricaoDespesa() {
        return descricaoDespesa;
    }

    public void setDescricaoDespesa(String descricaoDespesa) {
        this.descricaoDespesa = descricaoDespesa;
    }

    public String getCategoriaDespesa() {
        return categoriaDespesa;
    }

    public void setCategoriaDespesa(String categoriaDespesa) {
        this.categoriaDespesa = categoriaDespesa;
    }

    public String getContaDespesa() {
        return contaDespesa;
    }

    public void setContaDespesa(String contaDespesa) {
        this.contaDespesa = contaDespesa;
    }

    public String getCheckDespesa() {
        return checkDespesa;
    }

    public void setCheckDespesa(String checkDespesa) {
        this.checkDespesa = checkDespesa;
    }
}
