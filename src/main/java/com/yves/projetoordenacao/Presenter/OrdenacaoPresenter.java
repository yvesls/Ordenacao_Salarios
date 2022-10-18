/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yves.projetoordenacao.Presenter;

import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JFileChooser;

import com.yves.projetoordenacao.Model.Collection;
import com.yves.projetoordenacao.Service.LeituraArquivoService;
import com.yves.projetoordenacao.Service.MetodoOrdenacaoService;
import com.yves.projetoordenacao.View.ViewPrincipal;

public class OrdenacaoPresenter {

    private String tipo;
    private boolean isDecrescente;
    private Collection arrayDoArquivoLido;
    private ViewPrincipal view;
    private long tempoExecucao;
    
    public OrdenacaoPresenter(ViewPrincipal view) {
        this.setView(view);
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
            //System.out.println(this.view.getRbtnDecrescente().isSelected());
            //System.out.println(this.view.getCmbModelo().getSelectedItem());
            this.setIsDecrescente(this.view.getRbtnDecrescente().isSelected());
            this.setTipo((String) this.view.getCmbModelo().getSelectedItem());
            return true;
        } else {
            return false;
        }
    }

    public void selecionarMetodoOrdenacao() {
        try {
            if (isOrdenar()) {
                MetodoOrdenacaoService ord = new MetodoOrdenacaoService();
                this.setTempoExecucao(ord.ordenar(this.getArrayDoArquivoLido(), this.getTipo(), this.getIsDecrescente()));
                this.getView().getLstOrdem().setText("");
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
        this.getView().getLblError().setText("");
        LeituraArquivoService l = new LeituraArquivoService();
        try {
            this.arrayDoArquivoLido = l.lerArquivo(caminhoArquivo);
        } catch (Exception e) {
            this.exibirErroException("Erro: Aconteceu um erro inesperado na execução do arquivo, tente novamente.");
        }
        this.getView().getLstSemOrdem().setText("");
        this.setArrayDoArquivoLido(this.arrayDoArquivoLido);
        this.exibirListaDesordenada();
    }

    public void exibirListaDesordenada() {
    	if(!this.arrayDoArquivoLido.getLista().isEmpty()) {
	        for (Double lista : this.getArrayDoArquivoLido().getLista()) {
	            this.getView().getLstSemOrdem().append(String.valueOf(lista) + "\n");
	        }
    	}else {
			this.getView().getLstSemOrdem().append("Arquivo vazio!");
		}
    }

    public void exibirListaOrdenada() {
    	for (Double lista : this.getArrayDoArquivoLido().getLista()) {
    		this.getView().getLstOrdem().append(String.valueOf(lista) + "\n");
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
        this.setTempoExecucao((long) 0.0);
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

    public Collection getArrayDoArquivoLido() {
        return arrayDoArquivoLido;
    }

    public void setArrayDoArquivoLido(Collection arrayDoArquivoLido) {
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
