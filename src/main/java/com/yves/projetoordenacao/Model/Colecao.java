package com.yves.projetoordenacao.Model;

import java.util.ArrayList;

public class Colecao {
	ArrayList <Double> lista;
	
	public Colecao() {
		this.lista = new ArrayList<>();
	}
	
	public void inserirNumero(Double num) {
		this.lista.add(num);
	}
	
	public ArrayList<Double> getLista() {
		return lista;
	}

	@Override
	public String toString() {
		return "Colecao [lista=" + lista + "]";
	}
}
