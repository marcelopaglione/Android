package com.example.marcelopaglione.asprova2;

/**
 * Created by marcelopaglione on 10/23/15.
 */
public class Pessoa {
    private long id;
    private String nome;
    private String sexo;
    private int idade;

    @Override
    public String toString() {
        return nome +" - "+ sexo +" - "+ idade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
