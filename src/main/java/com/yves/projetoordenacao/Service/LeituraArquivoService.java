package com.yves.projetoordenacao.Service;

import java.io.File;
import java.util.Scanner;

import com.yves.projetoordenacao.Model.Colecao;
import com.yves.projetoordenacao.Presenter.OrdenacaoPresenter;
import com.yves.projetoordenacao.View.ViewPrincipal;

public class LeituraArquivoService {
	private Colecao listaDouble;
	private OrdenacaoPresenter presenter;
	
	public LeituraArquivoService(OrdenacaoPresenter presenter) {
		this.presenter = presenter;
	}
	
	public Colecao lerArquivo(File caminhoArquivo, ViewPrincipal view) {
		int contador = 0;
		this.listaDouble = new Colecao();
		try (Scanner scanner = new Scanner(caminhoArquivo)) {
			String isCsv = caminhoArquivo.getName().substring(caminhoArquivo.getName().length()-3);
			System.out.println(isCsv);
			
			/* 35% do tempo dedicado neste projeto foi para resolver o problema da string "salario" e 
			de outras possíveis strings que não podem ser convertidas para Double.
			Devido a isso, o uso da "força"(gambiarra) foi preciso.*/
			//inicio gambiarra
			if(isCsv.equals("csv")) {
				scanner.next();
			}
			// fim gambiarra
			while (scanner.hasNext()) {
				this.listaDouble.inserirNumero(Double.valueOf(scanner.next()));//.replaceAll("[a-zA-Z^\\\\w+]", "")	
				contador++;
			}	
		}catch (Exception e) {
			this.presenter.exibirErroException(e.getMessage());
			e.printStackTrace();
		}
		System.out.println(contador);
		return listaDouble;
	}
}
