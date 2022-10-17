/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yves.projetoordenacao.Presenter;

import java.io.File;

import com.yves.projetoordenacao.Model.Colecao;
import com.yves.projetoordenacao.Service.LeituraArquivoService;
import com.yves.projetoordenacao.Service.MetodoOrdenacaoService;
import com.yves.projetoordenacao.View.ViewPrincipal;

public class OrdenacaoPresenter {

    String tipo;
    boolean isDecrescente;
    Colecao arrayDoArquivoLido;
    ViewPrincipal view;
    long tempoExecucao;
    
    public OrdenacaoPresenter(ViewPrincipal view) {
    	this.setView(view);
    }
    
    public boolean isOrdenar() {
    	if(!this.view.getLstSemOrdem().getText().equals("")) {
    		//System.out.println(this.view.getRbtnDecrescente().isSelected());
    		//System.out.println(this.view.getCmbModelo().getSelectedItem());
    		this.setIsDecrescente(this.view.getRbtnDecrescente().isSelected());
    		this.setTipo((String) this.view.getCmbModelo().getSelectedItem());
    		return true;
    	}else {
    		return false;
    	}
    }

	public void Ordenar() {
		try {
	    	if(isOrdenar()) {
	    		MetodoOrdenacaoService ord = new MetodoOrdenacaoService();
	    		this.setTempoExecucao(ord.ordenar(this.getArrayDoArquivoLido(), this.getTipo(), this.getIsDecrescente()));
	    		this.getView().getLstOrdem().setText("");
	    		
	    		exibirListaOrdenada();
	    		exibirTempoExecucao();
	    	}else {
	    		this.exibirErroException("Erro: É necessário carregar uma lista primeiro.");
	    	}
		}catch (Exception e) {
			this.exibirErroException(e.getMessage());
		}
    }
    
    public void lerArquivo(File caminhoArquivo) {
    	this.getView().getLblError().setText("");
    	
    	try {
    		LeituraArquivoService l = new LeituraArquivoService(this);
        	Colecao lista = new Colecao();
        	lista = l.lerArquivo(caminhoArquivo, this.getView());
        
        	this.getView().getLstSemOrdem().setText("");
    	    this.setArrayDoArquivoLido(lista);
    	    this.exibirListaDesordenada();
    	}catch (Exception e) {
    		this.exibirErroException(e.getMessage());
    	}
    	
    }
    
    public void exibirListaDesordenada() {
    	for(Double lista : this.getArrayDoArquivoLido().getLista()) {
    		this.getView().getLstSemOrdem().append(String.valueOf(lista)+"\n");
    	}
    }
    
    public void exibirListaOrdenada() {
    	for(Double lista : this.getArrayDoArquivoLido().getLista()) {
    		this.getView().getLstOrdem().append(String.valueOf(lista)+"\n");
    	}
    }
    
    public void exibirTempoExecucao() {
    	this.getView().getLblTempo().setText("");
    	this.getView().getLblTempo().setText(Long.toString(this.getTempoExecucao()) + " ms");
    }
    
    public void exibirErroException(String e) {
    	this.getView().getLblError().setText("");
		this.getView().getLblError().setText(e);
    }
    
    public void resetarCampos() {
    	this.setArrayDoArquivoLido(null);
    	this.getView().getLstSemOrdem().setText("");
    	this.getView().getLstOrdem().setText("");
    	this.getView().getLblTempo().setText("");
    	this.setTempoExecucao((long)0.0);
    }

    public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean getIsDecrescente() {
		return this.isDecrescente;
	}

	public void setIsDecrescente(boolean isDecrescente) {
		this.isDecrescente = isDecrescente;
	}

	public Colecao getArrayDoArquivoLido() {
		return arrayDoArquivoLido;
	}

	public void setArrayDoArquivoLido(Colecao arrayDoArquivoLido) {
		this.arrayDoArquivoLido = arrayDoArquivoLido;
	}

	public long getTempoExecucao() {
		return tempoExecucao;
	}

	public void setTempoExecucao(long tempoExecucao) {
		this.tempoExecucao = tempoExecucao;
	}

	public void setView(ViewPrincipal view) {
		this.view = view;
	}
	
	public ViewPrincipal getView() {
		return this.view;
	}
}
