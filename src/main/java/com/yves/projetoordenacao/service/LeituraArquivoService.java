package com.yves.projetoordenacao.service;

import java.io.File;
import java.util.Scanner;

import com.yves.projetoordenacao.model.Collection;
import com.yves.projetoordenacao.presenter.OrdenacaoPresenter;
import com.yves.projetoordenacao.view.ViewPrincipal;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeituraArquivoService {

    private Collection listaDouble;

    public LeituraArquivoService() {
        this.listaDouble = new Collection();
    }

    public Collection lerArquivo(File caminhoArquivo) {
        
        Scanner scanner;
        try {
            scanner = new Scanner(caminhoArquivo);
            String isCsv = caminhoArquivo.getName().substring(caminhoArquivo.getName().length() - 3);
            if (isCsv.equals("csv")) {
                scanner.next();
            }
            while (scanner.hasNext()) {
                this.listaDouble.inserirNumero(Double.valueOf(scanner.next()));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
           
        }
        
        return listaDouble;
    }
}
