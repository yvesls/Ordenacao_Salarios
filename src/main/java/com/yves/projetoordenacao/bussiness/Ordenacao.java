/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yves.projetoordenacao.bussiness;

import com.yves.projetoordenacao.model.Collection;

public interface Ordenacao {
    public long ordenarPorSentido(Collection lista, boolean isDecrescente);
    
    public String tipo();
}
