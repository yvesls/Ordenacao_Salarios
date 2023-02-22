package com.yves.projetoordenacao.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.yves.projetoordenacao.presenter.OrdenacaoPresenter;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DropMode;
import java.awt.Color;

public class ViewPrincipal {

	private JFrame frame;
	private JComboBox cmbModelo;
	private JRadioButton rbtnCrescente;
	private JRadioButton rbtnDecrescente;
	private JButton btnOrdenar;
	private JButton btnCarregarArquivo;
	private JLabel lblTempo;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTextArea lstOrdem;
	private JTextArea lstSemOrdem;
	private JTextArea lblError;
	private JButton btnLimparCampos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPrincipal window = new ViewPrincipal();
					new OrdenacaoPresenter(window);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewPrincipal() {
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 591, 383);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSemOrdem = new JLabel("Elementos a serem ordenados");
		lblSemOrdem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSemOrdem.setBounds(29, 11, 186, 14);
		frame.getContentPane().add(lblSemOrdem);
		
		JLabel lblOrdenados = new JLabel("Elementos ordenados");
		lblOrdenados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOrdenados.setBounds(358, 11, 186, 14);
		frame.getContentPane().add(lblOrdenados);
		
		JLabel lblMetodoOrdenacao = new JLabel("Método de ordenação");
		lblMetodoOrdenacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMetodoOrdenacao.setBounds(225, 40, 121, 14);
		frame.getContentPane().add(lblMetodoOrdenacao);
		
		cmbModelo = new JComboBox();
		cmbModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbModelo.setModel(new DefaultComboBoxModel(new String[] {"BubbleSort", "SelectionSort"}));
		cmbModelo.setToolTipText("BubbleSort\r\nSelectionSort\r\n");
		cmbModelo.setBounds(235, 65, 95, 22);
		frame.getContentPane().add(cmbModelo);
		
		JLabel lblOrdem = new JLabel("Ordem");
		lblOrdem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOrdem.setBounds(225, 127, 46, 14);
		frame.getContentPane().add(lblOrdem);
		
		rbtnCrescente = new JRadioButton("Crescente", true);
		rbtnCrescente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbtnCrescente.setBounds(221, 148, 109, 23);
		frame.getContentPane().add(rbtnCrescente);
		
		
		rbtnDecrescente = new JRadioButton("Decrescente", false);
		rbtnDecrescente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbtnDecrescente.setBounds(221, 169, 109, 23);
		frame.getContentPane().add(rbtnDecrescente);
		
		
		btnOrdenar = new JButton("Ordenar");
		btnOrdenar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOrdenar.setBounds(235, 199, 95, 23);
		frame.getContentPane().add(btnOrdenar);
		
		JList list = new JList();
		list.setBounds(29, 53, 1, 1);
		frame.getContentPane().add(list);
		
		btnCarregarArquivo = new JButton("Carregar Arquivo");
		btnCarregarArquivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCarregarArquivo.setBounds(39, 267, 162, 23);
		frame.getContentPane().add(btnCarregarArquivo);
		
		JLabel Tempo = new JLabel("Tempo:");
		Tempo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Tempo.setBounds(358, 268, 46, 14);
		frame.getContentPane().add(Tempo);
		
		lblTempo = new JLabel("");
		lblTempo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTempo.setBounds(408, 267, 71, 14);
		frame.getContentPane().add(lblTempo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 36, 186, 220);
		frame.getContentPane().add(scrollPane);
		
		lstSemOrdem = new JTextArea();
		lstSemOrdem.setEditable(false);
		lstSemOrdem.setDropMode(DropMode.INSERT);
		scrollPane.setViewportView(lstSemOrdem);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(358, 36, 186, 220);
		frame.getContentPane().add(scrollPane_1);
		
		lstOrdem = new JTextArea();
		lstOrdem.setEditable(false);
		lstOrdem.setDropMode(DropMode.INSERT);
		scrollPane_1.setViewportView(lstOrdem);
		
		btnLimparCampos = new JButton("Limpar");
		btnLimparCampos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimparCampos.setBounds(235, 233, 95, 23);
		frame.getContentPane().add(btnLimparCampos);
		
		lblError = new JTextArea();
		lblError.setDropMode(DropMode.INSERT);
		lblError.setEditable(false);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBackground(new Color(240, 240, 240));
		lblError.setBounds(29, 301, 515, 32);
		frame.getContentPane().add(lblError);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 318, 534, -28);
		frame.getContentPane().add(scrollPane_2);
		
	}

	public JComboBox getCmbModelo() {
		return cmbModelo;
	}

	public JRadioButton getRbtnCrescente() {
		return rbtnCrescente;
	}

	public JRadioButton getRbtnDecrescente() {
		return rbtnDecrescente;
	}

	public JButton getBtnCarregarArquivo() {
		return btnCarregarArquivo;
	}

	public JLabel getLblTempo() {
		return lblTempo;
	}

	public JTextArea getLstSemOrdem() {
		return lstSemOrdem;
	}

	public JTextArea getLstOrdem() {
		return lstOrdem;
	}

	public JTextArea getLblError() {
		return lblError;
	}
	
	public JButton getBtnOrdenar() {
		return btnOrdenar;
	}

	public JButton getBtnLimparCampos() {
		return btnLimparCampos;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
}
