package br.ufc.missingyou.services;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("cpfUser")
    private String cpfUser ;
    @SerializedName("emailUser")
    private String emailUser;
    @SerializedName("nomeUser")
    private String nomeUser;
    @SerializedName("idUser")
    private int idUser;
    @SerializedName("imagem2")
    private String imagem2;
    @SerializedName("contatoUser")
    private String contatoUser;
    @SerializedName("senhaUser")
    private String senhaUser;

    public User(){
        this.cpfUser = null;
    }

    public String getContatoUser() {
        return contatoUser;
    }

    public void setContatoUser(String contatoUser) {
        this.contatoUser = contatoUser;
    }

    public String getCpfUser() {
        return cpfUser;
    }

    public void setCpfUser(String cpfUser) {
        this.cpfUser = cpfUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getImagem2() {
        return imagem2;
    }

    public void setImagem2(String imagem2) {
        this.imagem2 = imagem2;
    }

    public String getSenhaUser() {
        return senhaUser;
    }

    public void setSenhaUser(String senhaUser) {
        this.senhaUser = senhaUser;
    }

    @Override
    public  String toString(){
        return "User{" +
                "cpfUser = " + cpfUser + '\'' +
                ", emailUser = " + emailUser + '\'' +
                ", senhaUser = " +  senhaUser + '\'' +
                ", idUser = " + idUser + '\'' +
                ", nomeUser = " + nomeUser + '\'' +
                ", contatoUser = " + contatoUser + '\'' +
                ", imagem2 = " + imagem2 + '\'' + "}";
    }
}