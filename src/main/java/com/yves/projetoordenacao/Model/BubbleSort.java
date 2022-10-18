/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yves.projetoordenacao.Model;

import java.util.ArrayList;


public class BubbleSort implements Ordenacao {

    private ArrayList<Double> list;

    @Override
    public long ordenarPorSentido(Collection lista, boolean isDecrescente) {
        this.list = lista.getLista();
        boolean s = false;
        Double temp;
        long tempoInicial = System.currentTimeMillis();
        
        try{
               if (isDecrescente) {
                while (!s) {
                    s = true;
                    for (int i = 0; i < this.list.size() - 1; i++) {
                        if (this.list.get(i) < this.list.get(i + 1)) {
                            temp = this.list.get(i);
                            this.list.set(i, this.list.get(i + 1));
                            this.list.set(i + 1, temp);
                            s = false;
                        }
                    }
                }
            } else {
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
        }catch(Exception e){
            e.printStackTrace();
            //("Erro: Aconteceu um erro inesperado na ordenação, tente novamente.");
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
