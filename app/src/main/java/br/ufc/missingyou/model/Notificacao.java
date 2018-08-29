package br.ufc.missingyou.model;

import java.io.Serializable;

public class Notificacao implements Serializable {

    private String data_notificacao, descricao;

    public Notificacao(){}

    public Notificacao(String data_notificacao, String descricao){
        this.data_notificacao = data_notificacao;
        this.descricao = descricao;
    }

    public String getData_notificacao() {
        return data_notificacao;
    }

    public void setData_notificacao(String data_notificacao) {
        this.data_notificacao = data_notificacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
