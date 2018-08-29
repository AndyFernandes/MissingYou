package br.ufc.missingyou.model;

import java.io.Serializable;

public class Quadro implements Serializable {

    private int foto_id;
    private String nome, local_desaparecimento;
    private String data_desaparecimento;

    String dataNascimentoDesaparecido;
    String corOlhosDesaparecidos;
    String cabelosDesaparecidos;
    String sexoDesaparecidos;
    String racasDesaparecidos;
    String idDesaparecids;

    String statusCampanhasPerdidas;
    String dataCampanhas;
    String numerosBO;
    String idUsuarios;

    public Quadro(){

    }

    public Quadro(int foto_id, String nome, String local_desaparecimento, String data_desaparecimento){
        this.foto_id = foto_id;
        this.nome = nome;
        this.local_desaparecimento = local_desaparecimento;
        this.data_desaparecimento = data_desaparecimento;
    }


    public int getFoto_id() {
        return foto_id;
    }

    public void setFoto_id(int foto_id) {
        this.foto_id = foto_id;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimentoDesaparecido() {
        return dataNascimentoDesaparecido;
    }

    public void setDataNascimentoDesaparecido(String dataNascimentoDesaparecido) {
        this.dataNascimentoDesaparecido = dataNascimentoDesaparecido;
    }

    public String getCorOlhosDesaparecidos() {
        return corOlhosDesaparecidos;
    }

    public void setCorOlhosDesaparecidos(String corOlhosDesaparecidos) {
        this.corOlhosDesaparecidos = corOlhosDesaparecidos;
    }

    public String getCabelosDesaparecidos() {
        return cabelosDesaparecidos;
    }

    public void setCabelosDesaparecidos(String cabelosDesaparecidos) {
        this.cabelosDesaparecidos = cabelosDesaparecidos;
    }

    public String getSexoDesaparecidos() {
        return sexoDesaparecidos;
    }

    public void setSexoDesaparecidos(String sexoDesaparecidos) {
        this.sexoDesaparecidos = sexoDesaparecidos;
    }

    public String getRacasDesaparecidos() {
        return racasDesaparecidos;
    }

    public void setRacasDesaparecidos(String racasDesaparecidos) {
        this.racasDesaparecidos = racasDesaparecidos;
    }

    public String getIdDesaparecids() {
        return idDesaparecids;
    }

    public void setIdDesaparecids(String idDesaparecids) {
        this.idDesaparecids = idDesaparecids;
    }

    public String getStatusCampanhasPerdidas() {
        return statusCampanhasPerdidas;
    }

    public void setStatusCampanhasPerdidas(String statusCampanhasPerdidas) {
        this.statusCampanhasPerdidas = statusCampanhasPerdidas;
    }

    public String getDataCampanhas() {
        return dataCampanhas;
    }

    public void setDataCampanhas(String dataCampanhas) {
        this.dataCampanhas = dataCampanhas;
    }

    public String getNumerosBO() {
        return numerosBO;
    }

    public void setNumerosBO(String numerosBO) {
        this.numerosBO = numerosBO;
    }

    public String getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(String idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal_desaparecimento() {
        return local_desaparecimento;
    }

    public void setLocal_desaparecimento(String local_desaparecimento) {
        this.local_desaparecimento = local_desaparecimento;
    }

    public String getData_desaparecimento() {
        return data_desaparecimento;
    }

    public void setData_desaparecimento(String data_desaparecimento) {
        this.data_desaparecimento = data_desaparecimento;
    }
}
