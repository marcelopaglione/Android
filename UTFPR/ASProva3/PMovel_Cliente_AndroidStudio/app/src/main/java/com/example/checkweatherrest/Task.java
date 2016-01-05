package com.example.checkweatherrest;

/*
 * Marcelo Ortiz Paglione Junior
 * RA: 1256300
 */
public class Task {
    private int id;
    private String nome;
    private String descricao;
    private String status;

    public Task(){}

    public Task(int id, String nome,String descricao, String status){
        this.id=id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
    }

    public Task(int id, String nome,String descricao){
        this.id=id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = "ABERTA";
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String toString(){
        return "Id: "+id+"\nNome: "+nome+"\nDescrição: "+descricao+"\nStatus: "+status;
    }


}
