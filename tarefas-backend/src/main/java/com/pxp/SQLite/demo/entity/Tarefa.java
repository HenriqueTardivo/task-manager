package com.pxp.SQLite.demo.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tarefa {
    @Id
    private int id;
    private String task;
    private String categoria;
    private String prioridade;
    private Date dataDeEntrega;
    private Boolean realizada;

    public Tarefa() {
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Date getDataDeEntrega() {
        return dataDeEntrega;
    }

    public void setDataDeEntrega(Date dataDeEntrega) {
        this.dataDeEntrega = dataDeEntrega;
    }

    public Boolean getRealizada() {
        return realizada;
    }

    public void setRealizada(Boolean realizada) {
        this.realizada = realizada;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", categoria='" + categoria + '\'' +
                ", prioridade='" + prioridade + '\'' +
                ", dataDeEntrega='" + dataDeEntrega + '\'' +
                ", realizada='" + realizada + '\'' +
                '}';
    }
}
