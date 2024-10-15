
package model;

import java.util.Date;

public class Tarefas {
    private int idTarefa;
    private String nome;
    private String descricao;
    private String data;
    private String status;

    public Tarefas() {
    }

    public Tarefas(int idTarefa, String nome, String descricao, String data, String status) {
        this.idTarefa = idTarefa;
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.status = status;
    }

    public int getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

  
       
    
}
