package com.yves.projetoordenacao.Service;

import java.util.ArrayList;

import com.yves.projetoordenacao.Model.BubbleSort;
import com.yves.projetoordenacao.Model.Collection;
import com.yves.projetoordenacao.Model.Ordenacao;
import com.yves.projetoordenacao.Model.SelectionSort;

public class MetodoOrdenacaoService {
	private ArrayList<Ordenacao> listaTiposDeOrdenacao;
	
	public MetodoOrdenacaoService() {
		this.setListaTiposDeOrdenacao(new ArrayList<>());
		this.getListaTiposDeOrdenacao().add(new BubbleSort());
		this.getListaTiposDeOrdenacao().add(new SelectionSort());
	}
	
	public long ordenar(Collection lista, String tipo, boolean isDecrescente) {
		for(Ordenacao ordem : this.getListaTiposDeOrdenacao()) {
			if(ordem.tipo().toUpperCase().equals(tipo.toUpperCase())) {
				return ordem.ordenarPorSentido(lista, isDecrescente);
			}
		}
		return (long) 0.0;
	}

	public ArrayList<Ordenacao> getListaTiposDeOrdenacao() {
		return listaTiposDeOrdenacao;
	}

	public void setListaTiposDeOrdenacao(ArrayList<Ordenacao> listaTiposDeOrdenacao) {
		this.listaTiposDeOrdenacao = listaTiposDeOrdenacao;
	}
}
