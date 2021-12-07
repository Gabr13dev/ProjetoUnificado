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
public class Complexidade {
    private int id;     
    private String nome;

    public int getId_complexidade() {
        return id;
    }

    public void setId(int id_complexidade) {
        this.id = id_complexidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome_complexidade) {
        this.nome = nome_complexidade;
    }
}
