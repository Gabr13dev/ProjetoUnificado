/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Gabriel
 */
public class Prioridade {
    private int id;     
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id_prioridade) {
        this.id = id_prioridade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome_prioridade) {
        this.nome = nome_prioridade;
    }
}
