package com.yves.projetoordenacao.service;

import java.util.ArrayList;

import com.yves.projetoordenacao.bussiness.BubbleSort;
import com.yves.projetoordenacao.bussiness.Ordenacao;
import com.yves.projetoordenacao.bussiness.SelectionSort;
import com.yves.projetoordenacao.model.Collection;

public class MetodoOrdenacaoService {
	private ArrayList<Ordenacao> listaTiposDeOrdenacao;
	
	public MetodoOrdenacaoService() {
		listaTiposDeOrdenacao = new ArrayList<>();
	}
	
	public long ordenar(Collection lista, String tipo, boolean isDecrescente) {
		for(Ordenacao ordem : listaTiposDeOrdenacao) {
			if(ordem.tipo().toUpperCase().equals(tipo.toUpperCase())) {
				return ordem.ordenarPorSentido(lista, isDecrescente);
			}
		}
		return (long) 0.0;
	}

	public ArrayList<Ordenacao> getListaTiposDeOrdenacao() {
		return listaTiposDeOrdenacao;
	}
}
