/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yves.projetoordenacao.presenter;

import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JFileChooser;

import com.yves.projetoordenacao.bussiness.BubbleSort;
import com.yves.projetoordenacao.bussiness.SelectionSort;
import com.yves.projetoordenacao.model.Collection;
import com.yves.projetoordenacao.service.LeituraArquivoService;
import com.yves.projetoordenacao.service.MetodoOrdenacaoService;
import com.yves.projetoordenacao.view.ViewPrincipal;

public class OrdenacaoPresenter {

    private String tipo;
    private boolean isDecrescente;
    private Collection arrayDoArquivoLido;
    private ViewPrincipal view;
    private long tempoExecucao;
    private MetodoOrdenacaoService ord;
    private LeituraArquivoService l;
    
    public OrdenacaoPresenter(ViewPrincipal view) {
        this.view = view;
        this.resgatarAcoesView();
    }
    
    public void resgatarAcoesView() {
    	this.view.getRbtnDecrescente().addActionListener((ActionEvent e) -> {
        	this.configuracaoButtonRadioDecrescente();
		});
        
        this.view.getRbtnCrescente().addActionListener((ActionEvent e) -> {
        	this.configuracaoButtonRadioCrescente();
		});
        
        this.view.getBtnOrdenar().addActionListener((ActionEvent e) ->{
        	 this.isOrdenar();
        	 this.selecionarMetodoOrdenacao();
		});
        
        this.view.getBtnCarregarArquivo().addActionListener((ActionEvent e) ->{
        	this.resetarCampos();
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooser.showOpenDialog(this.view.getFrame());
			File f = chooser.getSelectedFile();
			this.lerArquivo(f);
			
		});
        
        this.view.getBtnLimparCampos().addActionListener((ActionEvent e) ->{
			this.resetarCampos();
		});
    }
    
    public void configuracaoButtonRadioCrescente() {
    	if(this.view.getRbtnCrescente().isSelected()) {
			if(this.view.getRbtnDecrescente().isSelected()) {
				this.view.getRbtnDecrescente().setSelected(false);
			}else {
				this.view.getRbtnDecrescente().setSelected(true);
			}
		}else {
			this.view.getRbtnCrescente().setSelected(true);
		}
    }
    
    public void configuracaoButtonRadioDecrescente() {
    	if(this.view.getRbtnDecrescente().isSelected()) {
			if(this.view.getRbtnCrescente().isSelected()) {
				this.view.getRbtnCrescente().setSelected(false);
			}else {
				this.view.getRbtnCrescente().setSelected(true);
			}
		}else {
			this.view.getRbtnDecrescente().setSelected(true);
		}
    }

    public boolean isOrdenar() {
        if (!this.arrayDoArquivoLido.getLista().isEmpty()) {
            isDecrescente = this.view.getRbtnDecrescente().isSelected();
            tipo = (String) this.view.getCmbModelo().getSelectedItem();
            return true;
        } else {
            return false;
        }
    }

    public void selecionarMetodoOrdenacao() {
        try {
            if (isOrdenar()) {
                ord = new MetodoOrdenacaoService();
        		ord.getListaTiposDeOrdenacao().add(new BubbleSort());
        		ord.getListaTiposDeOrdenacao().add(new SelectionSort());
                tempoExecucao = ord.ordenar(arrayDoArquivoLido, tipo, isDecrescente);
                this.view.getLstOrdem().setText("");
                exibirListaOrdenada();
                exibirTempoExecucao();
                
            } else {
            	this.exibirErroException("Erro: A lista não existe ou está vazia.");
            }
        } catch (Exception e) {
            this.exibirErroException("Erro: Aconteceu um erro inesperado na ordenação da lista, tente novamente.");
        }
    }

    public void lerArquivo(File caminhoArquivo) {
        this.view.getLblError().setText("");
        l = new LeituraArquivoService();
        try {
            this.arrayDoArquivoLido = l.lerArquivo(caminhoArquivo);
        } catch (Exception e) {
            this.exibirErroException("Erro: Aconteceu um erro inesperado na execução do arquivo, tente novamente.");
        }
        this.view.getLstSemOrdem().setText("");
        this.exibirListaDesordenada();
    }

    public void exibirListaDesordenada() {
    	if(!this.arrayDoArquivoLido.getLista().isEmpty()) {
	        for (Double lista :arrayDoArquivoLido.getLista()) {
	        	this.view.getLstSemOrdem().append(String.valueOf(lista) + "\n");
	        }
    	}else {
    		this.view.getLstSemOrdem().append("Arquivo vazio!");
		}
    }

    public void exibirListaOrdenada() {
    	for (Double lista : arrayDoArquivoLido.getLista()) {
    		this.view.getLstOrdem().append(String.valueOf(lista) + "\n");
    	}
    }
    
    public void exibirTempoExecucao() {
        this.view.getLblTempo().setText("");
        this.view.getLblTempo().setText(String.valueOf(tempoExecucao) + " ms");
    }

    public void exibirErroException(String e) {
        this.view.getLblError().setText("");
        this.view.getLblError().setText(e);
    }

    public void resetarCampos() {
        arrayDoArquivoLido = null;
        this.view.getLstSemOrdem().setText("");
        this.view.getLstOrdem().setText("");
        this.view.getLblTempo().setText("");
        tempoExecucao = (long) 0.0;
    }

   
}
