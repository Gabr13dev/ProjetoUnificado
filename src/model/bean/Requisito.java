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
public class Requisito{
        private int id_requisito;
	private String nome;
        private String descricao;
	private java.util.Date datacriacao;
	private int autor;
	private int usuario_ultimamodificacao;
	private java.util.Date data_ultimamodificacao;
	private int id_prioridade;
	private int esforco_horas;
	private int complexidade;
	private int id_projeto;
        
        public int getIdRequisito(){
		return id_requisito;
	}
        
        public void setIdRequisito(int idRequisito){
		this.id_requisito = idRequisito;
	}

	public String getNome(){
		return nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}
        
        public String getDescricao(){
            return descricao;
        }
        
        public void setDescricao(String descricao){
            this.descricao = descricao;
        }

	public java.util.Date getDatacriacao(){
		return datacriacao;
	}

	public void setDatacriacao(java.util.Date datacriacao){
		this.datacriacao=datacriacao;
	}

	public int getAutor(){
		return autor;
	}

	public void setAutor(int autor){
		this.autor=autor;
	}

	public int getUsuario_ultimamodificacao(){
		return usuario_ultimamodificacao;
	}

	public void setUsuario_ultimamodificacao(int usuario_ultimamodificacao){
		this.usuario_ultimamodificacao=usuario_ultimamodificacao;
	}

	public java.util.Date getData_ultimamodificacao(){
		return data_ultimamodificacao;
	}

	public void setData_ultimamodificacao(java.util.Date data_ultimamodificacao){
		this.data_ultimamodificacao=data_ultimamodificacao;
	}

	public int getId_prioridade(){
		return id_prioridade;
	}

	public void setId_prioridade(int id_prioridade){
		this.id_prioridade=id_prioridade;
	}

	public int getEsforco_horas(){
		return esforco_horas;
	}

	public void setEsforco_horas(int esforco_horas){
		this.esforco_horas=esforco_horas;
	}

	public int getComplexidade(){
		return complexidade;
	}

	public void setComplexidade(int complexidade){
		this.complexidade=complexidade;
	}

	public int getId_projeto(){
		return id_projeto;
	}

	public void setId_projeto(int id_projeto){
		this.id_projeto=id_projeto;
	}
}
