/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.petfeliz.pi3.model;

import java.sql.Date;

public class Venda {
    private Long id;
    private Long id_funcionario;
    private Long id_cliente;
    private Long id_produto;
    private int quantidade;
    private Date dt_venda;
    
    public Venda() {
    }

    public Venda(Long id_funcionario, Long id_cliente, Long id_produto, int quantidade) {
        this.id_funcionario = id_funcionario;
        this.id_cliente = id_cliente;
        this.id_produto = id_produto;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the id_funcionario
     */
    public Long getId_funcionario() {
        return id_funcionario;
    }

    /**
     * @param id_funcionario the id_funcionario to set
     */
    public void setId_funcionario(Long id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    /**
     * @return the id_cliente
     */
    public Long getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * @return the id_produto
     */
    public Long getId_produto() {
        return id_produto;
    }

    /**
     * @param id_produto the id_produto to set
     */
    public void setId_produto(Long id_produto) {
        this.id_produto = id_produto;
    }

    /**
     * @return the dt_venda
     */
    public Date getDt_venda() {
        return dt_venda;
    }

    /**
     * @param dt_venda the dt_venda to set
     */
    public void setDt_venda(Date dt_venda) {
        this.dt_venda = dt_venda;
    }    
}
