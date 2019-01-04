package com.projetomycity.mycity.modules;

/**
 * Created by PEDRONI on 15/08/2017.
 */

public class CityUser {

    private int id;
    private String user;
    private String email;
    private String nome;
    private String bio;
    private String cidade;
    private int nascimento;
    private String telefone;
    private String facebook;
    private String twitter;
    private String grupo;
    private int verified;
    private String icon;
    private int lastupdate;

    public CityUser(int id, String user, String email, String nome, String bio, String cidade, int nascimento, String telefone, String facebook, String twitter, String grupo, int verified, String icon, int lastupdate) {
        this.id = id;
        this.user = user;
        this.email = email;
        this.nome = nome;
        this.bio = bio;
        this.cidade = cidade;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.facebook = facebook;
        this.twitter = twitter;
        this.grupo = grupo;
        this.verified = verified;
        this.icon = icon;
        this.lastupdate = lastupdate;
    }

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getBio() {
        return bio;
    }

    public String getCidade() {
        return cidade;
    }

    public int getNascimento() {
        return nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getGrupo() {
        return grupo;
    }

    public int getVerified() {
        return verified;
    }

    public String getIcon() {
        return icon;
    }

    public int getLastupdate() {
        return lastupdate;
    }







}
