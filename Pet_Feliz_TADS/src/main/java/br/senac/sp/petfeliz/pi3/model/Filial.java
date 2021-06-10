/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.petfeliz.pi3.model;

/**
 *
 * @author fernanda.nunes
 */
public class Filial {
    private Long id;
    private String localidade;
    private String responsavel;
    private String dataCadastro;

    public Filial() {
    }

    public Filial(Long id, String localidade, String responsavel, String dataCadastro) {
        this.id = id;
        this.localidade = localidade;
        this.responsavel = responsavel;
        this.dataCadastro = dataCadastro;
    }

    public Filial(String localidade, String responsavel, String dataCadastro) {
        this.localidade = localidade;
        this.responsavel = responsavel;
        this.dataCadastro = dataCadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}
