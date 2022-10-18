package com.yves.projetoordenacao.Service;

import java.io.File;
import java.util.Scanner;
import com.yves.projetoordenacao.Model.Collection;
import com.yves.projetoordenacao.Presenter.OrdenacaoPresenter;
import com.yves.projetoordenacao.View.ViewPrincipal;
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
