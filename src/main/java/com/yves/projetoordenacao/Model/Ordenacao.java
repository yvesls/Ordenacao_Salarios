/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yves.projetoordenacao.Model;

public interface Ordenacao {
    public long ordenarPorTipo(Colecao lista, boolean isDecrescente);
    
    public String tipo();
}
