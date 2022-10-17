/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yves.projetoordenacao.Model;

import java.io.UncheckedIOException;
import java.util.ArrayList;

import com.yves.projetoordenacao.Presenter.OrdenacaoPresenter;

public class BubbleSort implements Ordenacao {
	private ArrayList<Double> list;
	private OrdenacaoPresenter presenter;
	
    @Override
    public long ordenarPorTipo(Colecao lista, boolean isDecrescente) {
        this.list = lista.getLista();
        boolean s = false;
        Double temp;
        long tempoInicial = System.currentTimeMillis();
        
        try {
        	 if(isDecrescente) {
 	    		while (!s) {
 	                s = true;
 	                for (int i = 0; i < this.list.size() - 1; i++) {
 	                    if (this.list.get(i) < this.list.get(i+1)) {
 	                        temp = this.list.get(i);
 	                        this.list.set(i, this.list.get(i + 1));
 	                        this.list.set(i + 1, temp);
 	                        s = false;
 	                    }
 	                }
 	    		}
 	    	}else {
 	    		while (!s) {
 	                s = true;
 	                for (int i = 0; i < this.list.size() - 1; i++) {
 	                    if (this.list.get(i).compareTo(this.list.get(i + 1)) > 0) {
 	                        temp = this.list.get(i);
 	                        this.list.set(i, this.list.get(i + 1));
 	                        this.list.set(i + 1, temp);
 	                        s = false;
 	                    }
 	                }
 	    		}
 	    	}
        }catch (UncheckedIOException e) {
        	this.presenter.exibirErroException(e.getMessage());
        	throw e;
        }
    	
    	
    	long tempoPercorrido = System.currentTimeMillis() - tempoInicial;
    	return tempoPercorrido;
    }
    
	@Override
	public String tipo() {
		// TODO Auto-generated method stub
		return "BUBBLESORT";
	}
}
