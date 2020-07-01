package com.aulaetecbarueri.crudsqlite;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Produto implements Serializable {

    private int ID;
    private String codigoDeBarras;
    private String nomeProduto;
    private String precoProduto;
    private String quantidadeEstoque;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(String precoProduto) {
        this.precoProduto = precoProduto;
    }

    public String getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(String quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @NonNull
    @Override
    public String toString() {
        return nomeProduto;
    }

}
